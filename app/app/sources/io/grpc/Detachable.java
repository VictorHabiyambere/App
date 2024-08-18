package io.grpc;

import java.io.InputStream;

public interface Detachable {
    InputStream detach();
}
