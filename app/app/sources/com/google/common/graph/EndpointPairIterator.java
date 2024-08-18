package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;
    @CheckForNull
    N node;
    private final Iterator<N> nodeIterator;
    Iterator<N> successorIterator;

    static <N> EndpointPairIterator<N> of(BaseGraph<N> graph2) {
        return graph2.isDirected() ? new Directed(graph2) : new Undirected(graph2);
    }

    private EndpointPairIterator(BaseGraph<N> graph2) {
        this.node = null;
        this.successorIterator = ImmutableSet.of().iterator();
        this.graph = graph2;
        this.nodeIterator = graph2.nodes().iterator();
    }

    /* access modifiers changed from: package-private */
    public final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (!this.nodeIterator.hasNext()) {
            return false;
        }
        this.node = this.nodeIterator.next();
        this.successorIterator = this.graph.successors((Object) this.node).iterator();
        return true;
    }

    private static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> graph) {
            super(graph);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public EndpointPair<N> computeNext() {
            while (!this.successorIterator.hasNext()) {
                if (!advance()) {
                    return (EndpointPair) endOfData();
                }
            }
            return EndpointPair.ordered(Objects.requireNonNull(this.node), this.successorIterator.next());
        }
    }

    private static final class Undirected<N> extends EndpointPairIterator<N> {
        @CheckForNull
        private Set<N> visitedNodes;

        private Undirected(BaseGraph<N> graph) {
            super(graph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(graph.nodes().size() + 1);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public EndpointPair<N> computeNext() {
            do {
                Objects.requireNonNull(this.visitedNodes);
                while (this.successorIterator.hasNext()) {
                    N otherNode = this.successorIterator.next();
                    if (!this.visitedNodes.contains(otherNode)) {
                        return EndpointPair.unordered(Objects.requireNonNull(this.node), otherNode);
                    }
                }
                this.visitedNodes.add(this.node);
            } while (advance());
            this.visitedNodes = null;
            return (EndpointPair) endOfData();
        }
    }
}
