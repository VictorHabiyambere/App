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

public final class AuthRequirement extends GeneratedMessageLite<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final AuthRequirement DEFAULT_INSTANCE;
    private static volatile Parser<AuthRequirement> PARSER = null;
    public static final int PROVIDER_ID_FIELD_NUMBER = 1;
    private String audiences_ = "";
    private String providerId_ = "";

    private AuthRequirement() {
    }

    public String getProviderId() {
        return this.providerId_;
    }

    public ByteString getProviderIdBytes() {
        return ByteString.copyFromUtf8(this.providerId_);
    }

    /* access modifiers changed from: private */
    public void setProviderId(String value) {
        value.getClass();
        this.providerId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearProviderId() {
        this.providerId_ = getDefaultInstance().getProviderId();
    }

    /* access modifiers changed from: private */
    public void setProviderIdBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.providerId_ = value.toStringUtf8();
    }

    public String getAudiences() {
        return this.audiences_;
    }

    public ByteString getAudiencesBytes() {
        return ByteString.copyFromUtf8(this.audiences_);
    }

    /* access modifiers changed from: private */
    public void setAudiences(String value) {
        value.getClass();
        this.audiences_ = value;
    }

    /* access modifiers changed from: private */
    public void clearAudiences() {
        this.audiences_ = getDefaultInstance().getAudiences();
    }

    /* access modifiers changed from: private */
    public void setAudiencesBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.audiences_ = value.toStringUtf8();
    }

    public static AuthRequirement parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthRequirement parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthRequirement parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthRequirement parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthRequirement parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthRequirement parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthRequirement parseFrom(InputStream input) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthRequirement parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthRequirement) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthRequirement parseFrom(CodedInputStream input) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuthRequirement prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
        private Builder() {
            super(AuthRequirement.DEFAULT_INSTANCE);
        }

        public String getProviderId() {
            return ((AuthRequirement) this.instance).getProviderId();
        }

        public ByteString getProviderIdBytes() {
            return ((AuthRequirement) this.instance).getProviderIdBytes();
        }

        public Builder setProviderId(String value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setProviderId(value);
            return this;
        }

        public Builder clearProviderId() {
            copyOnWrite();
            ((AuthRequirement) this.instance).clearProviderId();
            return this;
        }

        public Builder setProviderIdBytes(ByteString value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setProviderIdBytes(value);
            return this;
        }

        public String getAudiences() {
            return ((AuthRequirement) this.instance).getAudiences();
        }

        public ByteString getAudiencesBytes() {
            return ((AuthRequirement) this.instance).getAudiencesBytes();
        }

        public Builder setAudiences(String value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setAudiences(value);
            return this;
        }

        public Builder clearAudiences() {
            copyOnWrite();
            ((AuthRequirement) this.instance).clearAudiences();
            return this;
        }

        public Builder setAudiencesBytes(ByteString value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setAudiencesBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new AuthRequirement();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"providerId_", "audiences_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<AuthRequirement> parser = PARSER;
                if (parser == null) {
                    synchronized (AuthRequirement.class) {
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
        AuthRequirement defaultInstance = new AuthRequirement();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(AuthRequirement.class, defaultInstance);
    }

    public static AuthRequirement getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthRequirement> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
