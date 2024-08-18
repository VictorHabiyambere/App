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

public final class ResourceReference extends GeneratedMessageLite<ResourceReference, Builder> implements ResourceReferenceOrBuilder {
    public static final int CHILD_TYPE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final ResourceReference DEFAULT_INSTANCE;
    private static volatile Parser<ResourceReference> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private String childType_ = "";
    private String type_ = "";

    private ResourceReference() {
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    /* access modifiers changed from: private */
    public void setType(String value) {
        value.getClass();
        this.type_ = value;
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* access modifiers changed from: private */
    public void setTypeBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.type_ = value.toStringUtf8();
    }

    public String getChildType() {
        return this.childType_;
    }

    public ByteString getChildTypeBytes() {
        return ByteString.copyFromUtf8(this.childType_);
    }

    /* access modifiers changed from: private */
    public void setChildType(String value) {
        value.getClass();
        this.childType_ = value;
    }

    /* access modifiers changed from: private */
    public void clearChildType() {
        this.childType_ = getDefaultInstance().getChildType();
    }

    /* access modifiers changed from: private */
    public void setChildTypeBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.childType_ = value.toStringUtf8();
    }

    public static ResourceReference parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ResourceReference parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ResourceReference parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ResourceReference parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ResourceReference parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ResourceReference parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ResourceReference parseFrom(InputStream input) throws IOException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceReference parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ResourceReference parseDelimitedFrom(InputStream input) throws IOException {
        return (ResourceReference) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceReference parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceReference) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ResourceReference parseFrom(CodedInputStream input) throws IOException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceReference parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ResourceReference prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ResourceReference, Builder> implements ResourceReferenceOrBuilder {
        private Builder() {
            super(ResourceReference.DEFAULT_INSTANCE);
        }

        public String getType() {
            return ((ResourceReference) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((ResourceReference) this.instance).getTypeBytes();
        }

        public Builder setType(String value) {
            copyOnWrite();
            ((ResourceReference) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((ResourceReference) this.instance).clearType();
            return this;
        }

        public Builder setTypeBytes(ByteString value) {
            copyOnWrite();
            ((ResourceReference) this.instance).setTypeBytes(value);
            return this;
        }

        public String getChildType() {
            return ((ResourceReference) this.instance).getChildType();
        }

        public ByteString getChildTypeBytes() {
            return ((ResourceReference) this.instance).getChildTypeBytes();
        }

        public Builder setChildType(String value) {
            copyOnWrite();
            ((ResourceReference) this.instance).setChildType(value);
            return this;
        }

        public Builder clearChildType() {
            copyOnWrite();
            ((ResourceReference) this.instance).clearChildType();
            return this;
        }

        public Builder setChildTypeBytes(ByteString value) {
            copyOnWrite();
            ((ResourceReference) this.instance).setChildTypeBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new ResourceReference();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"type_", "childType_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<ResourceReference> parser = PARSER;
                if (parser == null) {
                    synchronized (ResourceReference.class) {
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
        ResourceReference defaultInstance = new ResourceReference();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(ResourceReference.class, defaultInstance);
    }

    public static ResourceReference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ResourceReference> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
