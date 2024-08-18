package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class ErrorInfo extends GeneratedMessageLite<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final ErrorInfo DEFAULT_INSTANCE;
    public static final int DOMAIN_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile Parser<ErrorInfo> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private String domain_ = "";
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String reason_ = "";

    private ErrorInfo() {
    }

    public String getReason() {
        return this.reason_;
    }

    public ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    /* access modifiers changed from: private */
    public void setReason(String value) {
        value.getClass();
        this.reason_ = value;
    }

    /* access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* access modifiers changed from: private */
    public void setReasonBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.reason_ = value.toStringUtf8();
    }

    public String getDomain() {
        return this.domain_;
    }

    public ByteString getDomainBytes() {
        return ByteString.copyFromUtf8(this.domain_);
    }

    /* access modifiers changed from: private */
    public void setDomain(String value) {
        value.getClass();
        this.domain_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDomain() {
        this.domain_ = getDefaultInstance().getDomain();
    }

    /* access modifiers changed from: private */
    public void setDomainBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.domain_ = value.toStringUtf8();
    }

    private static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private MetadataDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    public boolean containsMetadata(String key) {
        key.getClass();
        return internalGetMetadata().containsKey(key);
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    public String getMetadataOrDefault(String key, String defaultValue) {
        key.getClass();
        Map<String, String> map = internalGetMetadata();
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    public String getMetadataOrThrow(String key) {
        key.getClass();
        Map<String, String> map = internalGetMetadata();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    public static ErrorInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ErrorInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ErrorInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ErrorInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ErrorInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ErrorInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ErrorInfo parseFrom(InputStream input) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ErrorInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ErrorInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ErrorInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ErrorInfo parseFrom(CodedInputStream input) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ErrorInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ErrorInfo prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
        private Builder() {
            super(ErrorInfo.DEFAULT_INSTANCE);
        }

        public String getReason() {
            return ((ErrorInfo) this.instance).getReason();
        }

        public ByteString getReasonBytes() {
            return ((ErrorInfo) this.instance).getReasonBytes();
        }

        public Builder setReason(String value) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReason(value);
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearReason();
            return this;
        }

        public Builder setReasonBytes(ByteString value) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReasonBytes(value);
            return this;
        }

        public String getDomain() {
            return ((ErrorInfo) this.instance).getDomain();
        }

        public ByteString getDomainBytes() {
            return ((ErrorInfo) this.instance).getDomainBytes();
        }

        public Builder setDomain(String value) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomain(value);
            return this;
        }

        public Builder clearDomain() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearDomain();
            return this;
        }

        public Builder setDomainBytes(ByteString value) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomainBytes(value);
            return this;
        }

        public int getMetadataCount() {
            return ((ErrorInfo) this.instance).getMetadataMap().size();
        }

        public boolean containsMetadata(String key) {
            key.getClass();
            return ((ErrorInfo) this.instance).getMetadataMap().containsKey(key);
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder removeMetadata(String key) {
            key.getClass();
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().remove(key);
            return this;
        }

        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((ErrorInfo) this.instance).getMetadataMap());
        }

        public String getMetadataOrDefault(String key, String defaultValue) {
            key.getClass();
            Map<String, String> map = ((ErrorInfo) this.instance).getMetadataMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        public String getMetadataOrThrow(String key) {
            key.getClass();
            Map<String, String> map = ((ErrorInfo) this.instance).getMetadataMap();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }

        public Builder putMetadata(String key, String value) {
            key.getClass();
            value.getClass();
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().put(key, value);
            return this;
        }

        public Builder putAllMetadata(Map<String, String> values) {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().putAll(values);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new ErrorInfo();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"reason_", "domain_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<ErrorInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (ErrorInfo.class) {
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
        ErrorInfo defaultInstance = new ErrorInfo();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(ErrorInfo.class, defaultInstance);
    }

    public static ErrorInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ErrorInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
