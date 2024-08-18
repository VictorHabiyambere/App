package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.util.List;
import okio.Buffer;

abstract class ForwardingFrameWriter implements FrameWriter {
    private final FrameWriter delegate;

    public ForwardingFrameWriter(FrameWriter delegate2) {
        this.delegate = (FrameWriter) Preconditions.checkNotNull(delegate2, "delegate");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public void connectionPreface() throws IOException {
        this.delegate.connectionPreface();
    }

    public void ackSettings(Settings peerSettings) throws IOException {
        this.delegate.ackSettings(peerSettings);
    }

    public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) throws IOException {
        this.delegate.pushPromise(streamId, promisedStreamId, requestHeaders);
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public void synStream(boolean outFinished, boolean inFinished, int streamId, int associatedStreamId, List<Header> headerBlock) throws IOException {
        this.delegate.synStream(outFinished, inFinished, streamId, associatedStreamId, headerBlock);
    }

    public void synReply(boolean outFinished, int streamId, List<Header> headerBlock) throws IOException {
        this.delegate.synReply(outFinished, streamId, headerBlock);
    }

    public void headers(int streamId, List<Header> headerBlock) throws IOException {
        this.delegate.headers(streamId, headerBlock);
    }

    public void rstStream(int streamId, ErrorCode errorCode) throws IOException {
        this.delegate.rstStream(streamId, errorCode);
    }

    public int maxDataLength() {
        return this.delegate.maxDataLength();
    }

    public void data(boolean outFinished, int streamId, Buffer source, int byteCount) throws IOException {
        this.delegate.data(outFinished, streamId, source, byteCount);
    }

    public void settings(Settings okHttpSettings) throws IOException {
        this.delegate.settings(okHttpSettings);
    }

    public void ping(boolean ack, int payload1, int payload2) throws IOException {
        this.delegate.ping(ack, payload1, payload2);
    }

    public void goAway(int lastGoodStreamId, ErrorCode errorCode, byte[] debugData) throws IOException {
        this.delegate.goAway(lastGoodStreamId, errorCode, debugData);
    }

    public void windowUpdate(int streamId, long windowSizeIncrement) throws IOException {
        this.delegate.windowUpdate(streamId, windowSizeIncrement);
    }
}
