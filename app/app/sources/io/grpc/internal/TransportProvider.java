package io.grpc.internal;

import javax.annotation.Nullable;

interface TransportProvider {
    @Nullable
    ClientTransport obtainActiveTransport();
}
