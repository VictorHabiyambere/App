package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class RetryInfo extends GeneratedMessageLite<RetryInfo, Builder> implements RetryInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final RetryInfo DEFAULT_INSTANCE;
    private static volatile Parser<RetryInfo> PARSER = null;
    public static final int RETRY_DELAY_FIELD_NUMBER = 1;
    private Duration retryDelay_;

    private RetryInfo() {
    }

    public boolean hasRetryDelay() {
        return this.retryDelay_ != null;
    }

    public Duration getRetryDelay() {
        return this.retryDelay_ == null ? Duration.getDefaultInstance() : this.retryDelay_;
    }

    /* access modifiers changed from: private */
    public void setRetryDelay(Duration value) {
        value.getClass();
        this.retryDelay_ = value;
    }

    /* access modifiers changed from: private */
    public void mergeRetryDelay(Duration value) {
        value.getClass();
        if (this.retryDelay_ == null || this.retryDelay_ == Duration.getDefaultInstance()) {
            this.retryDelay_ = value;
        } else {
            this.retryDelay_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.retryDelay_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRetryDelay() {
        this.retryDelay_ = null;
    }

    public static RetryInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RetryInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RetryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RetryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RetryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RetryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RetryInfo parseFrom(InputStream input) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RetryInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (RetryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RetryInfo parseFrom(CodedInputStream input) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RetryInfo prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
        private Builder() {
            super(RetryInfo.DEFAULT_INSTANCE);
        }

        public boolean hasRetryDelay() {
            return ((RetryInfo) this.instance).hasRetryDelay();
        }

        public Duration getRetryDelay() {
            return ((RetryInfo) this.instance).getRetryDelay();
        }

        public Builder setRetryDelay(Duration value) {
            copyOnWrite();
            ((RetryInfo) this.instance).setRetryDelay(value);
            return this;
        }

        public Builder setRetryDelay(Duration.Builder builderForValue) {
            copyOnWrite();
            ((RetryInfo) this.instance).setRetryDelay((Duration) builderForValue.build());
            return this;
        }

        public Builder mergeRetryDelay(Duration value) {
            copyOnWrite();
            ((RetryInfo) this.instance).mergeRetryDelay(value);
            return this;
        }

        public Builder clearRetryDelay() {
            copyOnWrite();
            ((RetryInfo) this.instance).clearRetryDelay();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new RetryInfo();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"retryDelay_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<RetryInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (RetryInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RetryInfo defaultInstance = new RetryInfo();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(RetryInfo.class, defaultInstance);
    }

    public static RetryInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RetryInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
