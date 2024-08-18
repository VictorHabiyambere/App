package com.google.common.collect;

@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    private BoundType(boolean inclusive2) {
        this.inclusive = inclusive2;
    }

    static BoundType forBoolean(boolean inclusive2) {
        return inclusive2 ? CLOSED : OPEN;
    }
}
