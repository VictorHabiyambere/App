package io.grpc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public interface HasByteBuffer {
    boolean byteBufferSupported();

    @Nullable
    ByteBuffer getByteBuffer();
}
