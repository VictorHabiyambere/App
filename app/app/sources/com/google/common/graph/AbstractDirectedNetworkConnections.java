package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    /* access modifiers changed from: private */
    public int selfLoopCount;

    AbstractDirectedNetworkConnections(Map<E, N> inEdgeMap2, Map<E, N> outEdgeMap2, int selfLoopCount2) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(inEdgeMap2);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(outEdgeMap2);
        this.selfLoopCount = Graphs.checkNonNegative(selfLoopCount2);
        Preconditions.checkState(selfLoopCount2 <= inEdgeMap2.size() && selfLoopCount2 <= outEdgeMap2.size());
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public UnmodifiableIterator<E> iterator() {
                Iterable<E> incidentEdges;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    incidentEdges = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    incidentEdges = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(incidentEdges.iterator());
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public boolean contains(@CheckForNull Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }
        };
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N adjacentNode(E edge) {
        return Objects.requireNonNull(this.outEdgeMap.get(edge));
    }

    public N removeInEdge(E edge, boolean isSelfLoop) {
        if (isSelfLoop) {
            int i = this.selfLoopCount - 1;
            this.selfLoopCount = i;
            Graphs.checkNonNegative(i);
        }
        return Objects.requireNonNull(this.inEdgeMap.remove(edge));
    }

    public N removeOutEdge(E edge) {
        return Objects.requireNonNull(this.outEdgeMap.remove(edge));
    }

    public void addInEdge(E edge, N node, boolean isSelfLoop) {
        Preconditions.checkNotNull(edge);
        Preconditions.checkNotNull(node);
        boolean z = true;
        if (isSelfLoop) {
            int i = this.selfLoopCount + 1;
            this.selfLoopCount = i;
            Graphs.checkPositive(i);
        }
        if (this.inEdgeMap.put(edge, node) != null) {
            z = false;
        }
        Preconditions.checkState(z);
    }

    public void addOutEdge(E edge, N node) {
        Preconditions.checkNotNull(edge);
        Preconditions.checkNotNull(node);
        Preconditions.checkState(this.outEdgeMap.put(edge, node) == null);
    }
}
