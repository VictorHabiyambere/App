package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
    /* access modifiers changed from: private */
    public static final CustomHttpPattern DEFAULT_INSTANCE;
    public static final int KIND_FIELD_NUMBER = 1;
    private static volatile Parser<CustomHttpPattern> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private String kind_ = "";
    private String path_ = "";

    private CustomHttpPattern() {
    }

    public String getKind() {
        return this.kind_;
    }

    public ByteString getKindBytes() {
        return ByteString.copyFromUtf8(this.kind_);
    }

    /* access modifiers changed from: private */
    public void setKind(String value) {
        value.getClass();
        this.kind_ = value;
    }

    /* access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = getDefaultInstance().getKind();
    }

    /* access modifiers changed from: private */
    public void setKindBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.kind_ = value.toStringUtf8();
    }

    public String getPath() {
        return this.path_;
    }

    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    /* access modifiers changed from: private */
    public void setPath(String value) {
        value.getClass();
        this.path_ = value;
    }

    /* access modifiers changed from: private */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    /* access modifiers changed from: private */
    public void setPathBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.path_ = value.toStringUtf8();
    }

    public static CustomHttpPattern parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CustomHttpPattern parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CustomHttpPattern parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CustomHttpPattern parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(InputStream input) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream input) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream input) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(CustomHttpPattern prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        private Builder() {
            super(CustomHttpPattern.DEFAULT_INSTANCE);
        }

        public String getKind() {
            return ((CustomHttpPattern) this.instance).getKind();
        }

        public ByteString getKindBytes() {
            return ((CustomHttpPattern) this.instance).getKindBytes();
        }

        public Builder setKind(String value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKind(value);
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearKind();
            return this;
        }

        public Builder setKindBytes(ByteString value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKindBytes(value);
            return this;
        }

        public String getPath() {
            return ((CustomHttpPattern) this.instance).getPath();
        }

        public ByteString getPathBytes() {
            return ((CustomHttpPattern) this.instance).getPathBytes();
        }

        public Builder setPath(String value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPath(value);
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearPath();
            return this;
        }

        public Builder setPathBytes(ByteString value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPathBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new CustomHttpPattern();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"kind_", "path_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<CustomHttpPattern> parser = PARSER;
                if (parser == null) {
                    synchronized (CustomHttpPattern.class) {
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
        CustomHttpPattern defaultInstance = new CustomHttpPattern();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(CustomHttpPattern.class, defaultInstance);
    }

    public static CustomHttpPattern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CustomHttpPattern> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
