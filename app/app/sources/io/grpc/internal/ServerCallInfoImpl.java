package io.grpc.internal;

import com.google.common.base.Objects;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import javax.annotation.Nullable;

final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
    private final Attributes attributes;
    private final String authority;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;

    ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> methodDescriptor2, Attributes attributes2, @Nullable String authority2) {
        this.methodDescriptor = methodDescriptor2;
        this.attributes = attributes2;
        this.authority = authority2;
    }

    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.methodDescriptor;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    @Nullable
    public String getAuthority() {
        return this.authority;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ServerCallInfoImpl)) {
            return false;
        }
        ServerCallInfoImpl<?, ?> that = (ServerCallInfoImpl) other;
        if (!Objects.equal(this.methodDescriptor, that.methodDescriptor) || !Objects.equal(this.attributes, that.attributes) || !Objects.equal(this.authority, that.authority)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.methodDescriptor, this.attributes, this.authority);
    }
}
