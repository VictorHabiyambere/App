package com.google.api;

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

public final class MonitoredResource extends GeneratedMessageLite<MonitoredResource, Builder> implements MonitoredResourceOrBuilder {
    /* access modifiers changed from: private */
    public static final MonitoredResource DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 2;
    private static volatile Parser<MonitoredResource> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String type_ = "";

    private MonitoredResource() {
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

    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private LabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    public boolean containsLabels(String key) {
        key.getClass();
        return internalGetLabels().containsKey(key);
    }

    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    public String getLabelsOrDefault(String key, String defaultValue) {
        key.getClass();
        Map<String, String> map = internalGetLabels();
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    public String getLabelsOrThrow(String key) {
        key.getClass();
        Map<String, String> map = internalGetLabels();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    public static MonitoredResource parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResource parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResource parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResource parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResource parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResource parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResource parseFrom(InputStream input) throws IOException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResource parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResource parseDelimitedFrom(InputStream input) throws IOException {
        return (MonitoredResource) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResource parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResource) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResource parseFrom(CodedInputStream input) throws IOException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResource parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MonitoredResource prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResource, Builder> implements MonitoredResourceOrBuilder {
        private Builder() {
            super(MonitoredResource.DEFAULT_INSTANCE);
        }

        public String getType() {
            return ((MonitoredResource) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((MonitoredResource) this.instance).getTypeBytes();
        }

        public Builder setType(String value) {
            copyOnWrite();
            ((MonitoredResource) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((MonitoredResource) this.instance).clearType();
            return this;
        }

        public Builder setTypeBytes(ByteString value) {
            copyOnWrite();
            ((MonitoredResource) this.instance).setTypeBytes(value);
            return this;
        }

        public int getLabelsCount() {
            return ((MonitoredResource) this.instance).getLabelsMap().size();
        }

        public boolean containsLabels(String key) {
            key.getClass();
            return ((MonitoredResource) this.instance).getLabelsMap().containsKey(key);
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((MonitoredResource) this.instance).getMutableLabelsMap().clear();
            return this;
        }

        public Builder removeLabels(String key) {
            key.getClass();
            copyOnWrite();
            ((MonitoredResource) this.instance).getMutableLabelsMap().remove(key);
            return this;
        }

        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((MonitoredResource) this.instance).getLabelsMap());
        }

        public String getLabelsOrDefault(String key, String defaultValue) {
            key.getClass();
            Map<String, String> map = ((MonitoredResource) this.instance).getLabelsMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        public String getLabelsOrThrow(String key) {
            key.getClass();
            Map<String, String> map = ((MonitoredResource) this.instance).getLabelsMap();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }

        public Builder putLabels(String key, String value) {
            key.getClass();
            value.getClass();
            copyOnWrite();
            ((MonitoredResource) this.instance).getMutableLabelsMap().put(key, value);
            return this;
        }

        public Builder putAllLabels(Map<String, String> values) {
            copyOnWrite();
            ((MonitoredResource) this.instance).getMutableLabelsMap().putAll(values);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new MonitoredResource();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001Ȉ\u00022", new Object[]{"type_", "labels_", LabelsDefaultEntryHolder.defaultEntry});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<MonitoredResource> parser = PARSER;
                if (parser == null) {
                    synchronized (MonitoredResource.class) {
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
        MonitoredResource defaultInstance = new MonitoredResource();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(MonitoredResource.class, defaultInstance);
    }

    public static MonitoredResource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MonitoredResource> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
