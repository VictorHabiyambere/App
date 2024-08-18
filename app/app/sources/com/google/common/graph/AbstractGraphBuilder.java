package com.google.common.graph;

import com.google.common.base.Optional;

@ElementTypesAreNonnullByDefault
abstract class AbstractGraphBuilder<N> {
    boolean allowsSelfLoops = false;
    final boolean directed;
    Optional<Integer> expectedNodeCount = Optional.absent();
    ElementOrder<N> incidentEdgeOrder = ElementOrder.unordered();
    ElementOrder<N> nodeOrder = ElementOrder.insertion();

    AbstractGraphBuilder(boolean directed2) {
        this.directed = directed2;
    }
}
