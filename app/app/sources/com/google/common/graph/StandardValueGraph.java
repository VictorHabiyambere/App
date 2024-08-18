package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    StandardValueGraph(AbstractGraphBuilder<? super N> builder) {
        this(builder, builder.nodeOrder.createMap(builder.expectedNodeCount.or(10).intValue()), 0);
    }

    StandardValueGraph(AbstractGraphBuilder<? super N> builder, Map<N, GraphConnections<N, V>> nodeConnections2, long edgeCount2) {
        MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
        this.isDirected = builder.directed;
        this.allowsSelfLoops = builder.allowsSelfLoops;
        this.nodeOrder = builder.nodeOrder.cast();
        if (nodeConnections2 instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(nodeConnections2);
        } else {
            mapIteratorCache = new MapIteratorCache<>(nodeConnections2);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeCount = Graphs.checkNonNegative(edgeCount2);
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> adjacentNodes(N node) {
        return checkedConnections(node).adjacentNodes();
    }

    public Set<N> predecessors(N node) {
        return checkedConnections(node).predecessors();
    }

    public Set<N> successors(N node) {
        return checkedConnections(node).successors();
    }

    public Set<EndpointPair<N>> incidentEdges(N node) {
        final GraphConnections<N, V> connections = checkedConnections(node);
        return new IncidentEdgeSet<N>(this, this, node) {
            public Iterator<EndpointPair<N>> iterator() {
                return connections.incidentEdgeIterator(this.node);
            }
        };
    }

    public boolean hasEdgeConnecting(N nodeU, N nodeV) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(nodeU), Preconditions.checkNotNull(nodeV));
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
        Preconditions.checkNotNull(endpoints);
        return isOrderingCompatible(endpoints) && hasEdgeConnectingInternal(endpoints.nodeU(), endpoints.nodeV());
    }

    @CheckForNull
    public V edgeValueOrDefault(N nodeU, N nodeV, @CheckForNull V defaultValue) {
        return edgeValueOrDefaultInternal(Preconditions.checkNotNull(nodeU), Preconditions.checkNotNull(nodeV), defaultValue);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpoints, @CheckForNull V defaultValue) {
        validateEndpoints(endpoints);
        return edgeValueOrDefaultInternal(endpoints.nodeU(), endpoints.nodeV(), defaultValue);
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return this.edgeCount;
    }

    private final GraphConnections<N, V> checkedConnections(N node) {
        GraphConnections<N, V> connections = this.nodeConnections.get(node);
        if (connections != null) {
            return connections;
        }
        Preconditions.checkNotNull(node);
        throw new IllegalArgumentException("Node " + node + " is not an element of this graph.");
    }

    /* access modifiers changed from: package-private */
    public final boolean containsNode(@CheckForNull N node) {
        return this.nodeConnections.containsKey(node);
    }

    private final boolean hasEdgeConnectingInternal(N nodeU, N nodeV) {
        GraphConnections<N, V> connectionsU = this.nodeConnections.get(nodeU);
        return connectionsU != null && connectionsU.successors().contains(nodeV);
    }

    @CheckForNull
    private final V edgeValueOrDefaultInternal(N nodeU, N nodeV, @CheckForNull V defaultValue) {
        GraphConnections<N, V> connectionsU = this.nodeConnections.get(nodeU);
        V value = connectionsU == null ? null : connectionsU.value(nodeV);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}
