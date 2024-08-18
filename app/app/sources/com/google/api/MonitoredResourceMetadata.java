package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class MonitoredResourceMetadata extends GeneratedMessageLite<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
    /* access modifiers changed from: private */
    public static final MonitoredResourceMetadata DEFAULT_INSTANCE;
    private static volatile Parser<MonitoredResourceMetadata> PARSER = null;
    public static final int SYSTEM_LABELS_FIELD_NUMBER = 1;
    public static final int USER_LABELS_FIELD_NUMBER = 2;
    private Struct systemLabels_;
    private MapFieldLite<String, String> userLabels_ = MapFieldLite.emptyMapField();

    private MonitoredResourceMetadata() {
    }

    public boolean hasSystemLabels() {
        return this.systemLabels_ != null;
    }

    public Struct getSystemLabels() {
        return this.systemLabels_ == null ? Struct.getDefaultInstance() : this.systemLabels_;
    }

    /* access modifiers changed from: private */
    public void setSystemLabels(Struct value) {
        value.getClass();
        this.systemLabels_ = value;
    }

    /* access modifiers changed from: private */
    public void mergeSystemLabels(Struct value) {
        value.getClass();
        if (this.systemLabels_ == null || this.systemLabels_ == Struct.getDefaultInstance()) {
            this.systemLabels_ = value;
        } else {
            this.systemLabels_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.systemLabels_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSystemLabels() {
        this.systemLabels_ = null;
    }

    private static final class UserLabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private UserLabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetUserLabels() {
        return this.userLabels_;
    }

    private MapFieldLite<String, String> internalGetMutableUserLabels() {
        if (!this.userLabels_.isMutable()) {
            this.userLabels_ = this.userLabels_.mutableCopy();
        }
        return this.userLabels_;
    }

    public int getUserLabelsCount() {
        return internalGetUserLabels().size();
    }

    public boolean containsUserLabels(String key) {
        key.getClass();
        return internalGetUserLabels().containsKey(key);
    }

    @Deprecated
    public Map<String, String> getUserLabels() {
        return getUserLabelsMap();
    }

    public Map<String, String> getUserLabelsMap() {
        return Collections.unmodifiableMap(internalGetUserLabels());
    }

    public String getUserLabelsOrDefault(String key, String defaultValue) {
        key.getClass();
        Map<String, String> map = internalGetUserLabels();
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    public String getUserLabelsOrThrow(String key) {
        key.getClass();
        Map<String, String> map = internalGetUserLabels();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableUserLabelsMap() {
        return internalGetMutableUserLabels();
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResourceMetadata parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResourceMetadata parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResourceMetadata parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResourceMetadata parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResourceMetadata parseFrom(InputStream input) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceMetadata parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream input) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream input) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MonitoredResourceMetadata prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
        private Builder() {
            super(MonitoredResourceMetadata.DEFAULT_INSTANCE);
        }

        public boolean hasSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).hasSystemLabels();
        }

        public Struct getSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).getSystemLabels();
        }

        public Builder setSystemLabels(Struct value) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels(value);
            return this;
        }

        public Builder setSystemLabels(Struct.Builder builderForValue) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels((Struct) builderForValue.build());
            return this;
        }

        public Builder mergeSystemLabels(Struct value) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).mergeSystemLabels(value);
            return this;
        }

        public Builder clearSystemLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).clearSystemLabels();
            return this;
        }

        public int getUserLabelsCount() {
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().size();
        }

        public boolean containsUserLabels(String key) {
            key.getClass();
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().containsKey(key);
        }

        public Builder clearUserLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().clear();
            return this;
        }

        public Builder removeUserLabels(String key) {
            key.getClass();
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().remove(key);
            return this;
        }

        @Deprecated
        public Map<String, String> getUserLabels() {
            return getUserLabelsMap();
        }

        public Map<String, String> getUserLabelsMap() {
            return Collections.unmodifiableMap(((MonitoredResourceMetadata) this.instance).getUserLabelsMap());
        }

        public String getUserLabelsOrDefault(String key, String defaultValue) {
            key.getClass();
            Map<String, String> map = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        public String getUserLabelsOrThrow(String key) {
            key.getClass();
            Map<String, String> map = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }

        public Builder putUserLabels(String key, String value) {
            key.getClass();
            value.getClass();
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().put(key, value);
            return this;
        }

        public Builder putAllUserLabels(Map<String, String> values) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().putAll(values);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new MonitoredResourceMetadata();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\t\u00022", new Object[]{"systemLabels_", "userLabels_", UserLabelsDefaultEntryHolder.defaultEntry});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<MonitoredResourceMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (MonitoredResourceMetadata.class) {
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
        MonitoredResourceMetadata defaultInstance = new MonitoredResourceMetadata();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(MonitoredResourceMetadata.class, defaultInstance);
    }

    public static MonitoredResourceMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MonitoredResourceMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
