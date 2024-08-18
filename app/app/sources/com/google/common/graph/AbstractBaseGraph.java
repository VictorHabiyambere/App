package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    AbstractBaseGraph() {
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        long degreeSum = 0;
        for (N node : nodes()) {
            degreeSum += (long) degree(node);
        }
        Preconditions.checkState((1 & degreeSum) == 0);
        return degreeSum >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public boolean remove(@CheckForNull Object o) {
                throw new UnsupportedOperationException();
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors((Object) endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }
        };
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    public Set<EndpointPair<N>> incidentEdges(N node) {
        Preconditions.checkNotNull(node);
        Preconditions.checkArgument(nodes().contains(node), "Node %s is not an element of this graph.", (Object) node);
        return new IncidentEdgeSet<N>(this, this, node) {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                if (this.graph.isDirected()) {
                    return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda0(this)), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.of(this.node)).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda1(this))));
                }
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda2(this)));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$0$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m2039lambda$iterator$0$comgooglecommongraphAbstractBaseGraph$2(Object predecessor) {
                return EndpointPair.ordered(predecessor, this.node);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$1$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m2040lambda$iterator$1$comgooglecommongraphAbstractBaseGraph$2(Object successor) {
                return EndpointPair.ordered(this.node, successor);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$2$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m2041lambda$iterator$2$comgooglecommongraphAbstractBaseGraph$2(Object adjacentNode) {
                return EndpointPair.unordered(this.node, adjacentNode);
            }
        };
    }

    public int degree(N node) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) node).size(), successors((Object) node).size());
        }
        Set<N> neighbors = adjacentNodes(node);
        return IntMath.saturatedAdd(neighbors.size(), (!allowsSelfLoops() || !neighbors.contains(node)) ? 0 : 1);
    }

    public int inDegree(N node) {
        return isDirected() ? predecessors((Object) node).size() : degree(node);
    }

    public int outDegree(N node) {
        return isDirected() ? successors((Object) node).size() : degree(node);
    }

    public boolean hasEdgeConnecting(N nodeU, N nodeV) {
        Preconditions.checkNotNull(nodeU);
        Preconditions.checkNotNull(nodeV);
        return nodes().contains(nodeU) && successors((Object) nodeU).contains(nodeV);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
        Preconditions.checkNotNull(endpoints);
        if (!isOrderingCompatible(endpoints)) {
            return false;
        }
        N nodeU = endpoints.nodeU();
        N nodeV = endpoints.nodeV();
        if (!nodes().contains(nodeU) || !successors((Object) nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void validateEndpoints(EndpointPair<?> endpoints) {
        Preconditions.checkNotNull(endpoints);
        Preconditions.checkArgument(isOrderingCompatible(endpoints), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    /* access modifiers changed from: protected */
    public final boolean isOrderingCompatible(EndpointPair<?> endpoints) {
        return endpoints.isOrdered() == isDirected();
    }
}
