package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    private UndirectedGraphConnections(Map<N, V> adjacentNodeValues2) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(adjacentNodeValues2);
    }

    static <N, V> UndirectedGraphConnections<N, V> of(ElementOrder<N> incidentEdgeOrder) {
        switch (incidentEdgeOrder.type()) {
            case UNORDERED:
                return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
            case STABLE:
                return new UndirectedGraphConnections<>(new LinkedHashMap(2, 1.0f));
            default:
                throw new AssertionError(incidentEdgeOrder.type());
        }
    }

    static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> adjacentNodeValues2) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf(adjacentNodeValues2));
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public Set<N> successors() {
        return adjacentNodes();
    }

    public Iterator<EndpointPair<N>> incidentEdgeIterator(N thisNode) {
        return Iterators.transform(this.adjacentNodeValues.keySet().iterator(), new UndirectedGraphConnections$$ExternalSyntheticLambda0(thisNode));
    }

    @CheckForNull
    public V value(N node) {
        return this.adjacentNodeValues.get(node);
    }

    public void removePredecessor(N node) {
        Object removeSuccessor = removeSuccessor(node);
    }

    @CheckForNull
    public V removeSuccessor(N node) {
        return this.adjacentNodeValues.remove(node);
    }

    public void addPredecessor(N node, V value) {
        Object addSuccessor = addSuccessor(node, value);
    }

    @CheckForNull
    public V addSuccessor(N node, V value) {
        return this.adjacentNodeValues.put(node, value);
    }
}
