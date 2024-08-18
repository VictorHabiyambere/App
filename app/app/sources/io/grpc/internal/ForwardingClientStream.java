package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

abstract class ForwardingClientStream implements ClientStream {
    /* access modifiers changed from: protected */
    public abstract ClientStream delegate();

    ForwardingClientStream() {
    }

    public void request(int numMessages) {
        delegate().request(numMessages);
    }

    public void writeMessage(InputStream message) {
        delegate().writeMessage(message);
    }

    public void flush() {
        delegate().flush();
    }

    public boolean isReady() {
        return delegate().isReady();
    }

    public void optimizeForDirectExecutor() {
        delegate().optimizeForDirectExecutor();
    }

    public void setCompressor(Compressor compressor) {
        delegate().setCompressor(compressor);
    }

    public void setMessageCompression(boolean enable) {
        delegate().setMessageCompression(enable);
    }

    public void cancel(Status reason) {
        delegate().cancel(reason);
    }

    public void halfClose() {
        delegate().halfClose();
    }

    public void setAuthority(String authority) {
        delegate().setAuthority(authority);
    }

    public void setFullStreamDecompression(boolean fullStreamDecompression) {
        delegate().setFullStreamDecompression(fullStreamDecompression);
    }

    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().setDecompressorRegistry(decompressorRegistry);
    }

    public void start(ClientStreamListener listener) {
        delegate().start(listener);
    }

    public void setMaxInboundMessageSize(int maxSize) {
        delegate().setMaxInboundMessageSize(maxSize);
    }

    public void setMaxOutboundMessageSize(int maxSize) {
        delegate().setMaxOutboundMessageSize(maxSize);
    }

    public void setDeadline(Deadline deadline) {
        delegate().setDeadline(deadline);
    }

    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }

    public void appendTimeoutInsight(InsightBuilder insight) {
        delegate().appendTimeoutInsight(insight);
    }
}
