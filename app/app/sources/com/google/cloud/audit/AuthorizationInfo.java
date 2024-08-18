package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final AuthorizationInfo DEFAULT_INSTANCE;
    public static final int GRANTED_FIELD_NUMBER = 3;
    private static volatile Parser<AuthorizationInfo> PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 2;
    public static final int RESOURCE_FIELD_NUMBER = 1;
    private boolean granted_;
    private String permission_ = "";
    private String resource_ = "";

    private AuthorizationInfo() {
    }

    public String getResource() {
        return this.resource_;
    }

    public ByteString getResourceBytes() {
        return ByteString.copyFromUtf8(this.resource_);
    }

    /* access modifiers changed from: private */
    public void setResource(String value) {
        value.getClass();
        this.resource_ = value;
    }

    /* access modifiers changed from: private */
    public void clearResource() {
        this.resource_ = getDefaultInstance().getResource();
    }

    /* access modifiers changed from: private */
    public void setResourceBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.resource_ = value.toStringUtf8();
    }

    public String getPermission() {
        return this.permission_;
    }

    public ByteString getPermissionBytes() {
        return ByteString.copyFromUtf8(this.permission_);
    }

    /* access modifiers changed from: private */
    public void setPermission(String value) {
        value.getClass();
        this.permission_ = value;
    }

    /* access modifiers changed from: private */
    public void clearPermission() {
        this.permission_ = getDefaultInstance().getPermission();
    }

    /* access modifiers changed from: private */
    public void setPermissionBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.permission_ = value.toStringUtf8();
    }

    public boolean getGranted() {
        return this.granted_;
    }

    /* access modifiers changed from: private */
    public void setGranted(boolean value) {
        this.granted_ = value;
    }

    /* access modifiers changed from: private */
    public void clearGranted() {
        this.granted_ = false;
    }

    public static AuthorizationInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(InputStream input) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream input) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuthorizationInfo prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
        private Builder() {
            super(AuthorizationInfo.DEFAULT_INSTANCE);
        }

        public String getResource() {
            return ((AuthorizationInfo) this.instance).getResource();
        }

        public ByteString getResourceBytes() {
            return ((AuthorizationInfo) this.instance).getResourceBytes();
        }

        public Builder setResource(String value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResource(value);
            return this;
        }

        public Builder clearResource() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearResource();
            return this;
        }

        public Builder setResourceBytes(ByteString value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResourceBytes(value);
            return this;
        }

        public String getPermission() {
            return ((AuthorizationInfo) this.instance).getPermission();
        }

        public ByteString getPermissionBytes() {
            return ((AuthorizationInfo) this.instance).getPermissionBytes();
        }

        public Builder setPermission(String value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermission(value);
            return this;
        }

        public Builder clearPermission() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearPermission();
            return this;
        }

        public Builder setPermissionBytes(ByteString value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermissionBytes(value);
            return this;
        }

        public boolean getGranted() {
            return ((AuthorizationInfo) this.instance).getGranted();
        }

        public Builder setGranted(boolean value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setGranted(value);
            return this;
        }

        public Builder clearGranted() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearGranted();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new AuthorizationInfo();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"resource_", "permission_", "granted_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<AuthorizationInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (AuthorizationInfo.class) {
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
        AuthorizationInfo defaultInstance = new AuthorizationInfo();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(AuthorizationInfo.class, defaultInstance);
    }

    public static AuthorizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthorizationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
