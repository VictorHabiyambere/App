package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            public Set<N> nodes() {
                return AbstractNetwork.this.nodes();
            }

            public Set<EndpointPair<N>> edges() {
                if (AbstractNetwork.this.allowsParallelEdges()) {
                    return super.edges();
                }
                return new AbstractSet<EndpointPair<N>>() {
                    public Iterator<EndpointPair<N>> iterator() {
                        return Iterators.transform(AbstractNetwork.this.edges().iterator(), new AbstractNetwork$1$1$$ExternalSyntheticLambda0(this));
                    }

                    /* access modifiers changed from: package-private */
                    /* renamed from: lambda$iterator$0$com-google-common-graph-AbstractNetwork$1$1  reason: not valid java name */
                    public /* synthetic */ EndpointPair m2042lambda$iterator$0$comgooglecommongraphAbstractNetwork$1$1(Object edge) {
                        return AbstractNetwork.this.incidentNodes(edge);
                    }

                    public int size() {
                        return AbstractNetwork.this.edges().size();
                    }

                    public boolean contains(@CheckForNull Object obj) {
                        if (!(obj instanceof EndpointPair)) {
                            return false;
                        }
                        EndpointPair<?> endpointPair = (EndpointPair) obj;
                        if (!AnonymousClass1.this.isOrderingCompatible(endpointPair) || !AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) || !AnonymousClass1.this.successors((Object) endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                            return false;
                        }
                        return true;
                    }
                };
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractNetwork.this.nodeOrder();
            }

            public ElementOrder<N> incidentEdgeOrder() {
                return ElementOrder.unordered();
            }

            public boolean isDirected() {
                return AbstractNetwork.this.isDirected();
            }

            public boolean allowsSelfLoops() {
                return AbstractNetwork.this.allowsSelfLoops();
            }

            public Set<N> adjacentNodes(N node) {
                return AbstractNetwork.this.adjacentNodes(node);
            }

            public Set<N> predecessors(N node) {
                return AbstractNetwork.this.predecessors((Object) node);
            }

            public Set<N> successors(N node) {
                return AbstractNetwork.this.successors((Object) node);
            }
        };
    }

    public int degree(N node) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(node).size(), outEdges(node).size());
        }
        return IntMath.saturatedAdd(incidentEdges(node).size(), edgesConnecting(node, node).size());
    }

    public int inDegree(N node) {
        return isDirected() ? inEdges(node).size() : degree(node);
    }

    public int outDegree(N node) {
        return isDirected() ? outEdges(node).size() : degree(node);
    }

    public Set<E> adjacentEdges(E edge) {
        EndpointPair<N> endpointPair = incidentNodes(edge);
        return Sets.difference(Sets.union(incidentEdges(endpointPair.nodeU()), incidentEdges(endpointPair.nodeV())), ImmutableSet.of(edge));
    }

    public Set<E> edgesConnecting(N nodeU, N nodeV) {
        Set<E> outEdgesU = outEdges(nodeU);
        Set<E> inEdgesV = inEdges(nodeV);
        if (outEdgesU.size() <= inEdgesV.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdgesU, connectedPredicate(nodeU, nodeV)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdgesV, connectedPredicate(nodeV, nodeU)));
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpoints) {
        validateEndpoints(endpoints);
        return edgesConnecting(endpoints.nodeU(), endpoints.nodeV());
    }

    private Predicate<E> connectedPredicate(final N nodePresent, final N nodeToCheck) {
        return new Predicate<E>() {
            public boolean apply(E edge) {
                return AbstractNetwork.this.incidentNodes(edge).adjacentNode(nodePresent).equals(nodeToCheck);
            }
        };
    }

    @CheckForNull
    public E edgeConnectingOrNull(N nodeU, N nodeV) {
        Set<E> edgesConnecting = edgesConnecting(nodeU, nodeV);
        switch (edgesConnecting.size()) {
            case 0:
                return null;
            case 1:
                return edgesConnecting.iterator().next();
            default:
                throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{nodeU, nodeV}));
        }
    }

    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpoints) {
        validateEndpoints(endpoints);
        return edgeConnectingOrNull(endpoints.nodeU(), endpoints.nodeV());
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
        return hasEdgeConnecting(endpoints.nodeU(), endpoints.nodeV());
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

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network<?, ?> other = (Network) obj;
        if (isDirected() != other.isDirected() || !nodes().equals(other.nodes()) || !edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(other))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(Network<N, E> network) {
        Set<E> edges = network.edges();
        Objects.requireNonNull(network);
        return Maps.asMap(edges, new AbstractNetwork$$ExternalSyntheticLambda0(network));
    }
}
