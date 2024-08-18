package io.grpc;

import io.grpc.Metadata;
import javax.annotation.Nullable;

public final class InternalStatus {
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;

    private InternalStatus() {
    }

    public static final StatusRuntimeException asRuntimeException(Status status, @Nullable Metadata trailers, boolean fillInStackTrace) {
        return new StatusRuntimeException(status, trailers, fillInStackTrace);
    }
}
