package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LatLng extends GeneratedMessageLite<LatLng, Builder> implements LatLngOrBuilder {
    /* access modifiers changed from: private */
    public static final LatLng DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile Parser<LatLng> PARSER;
    private double latitude_;
    private double longitude_;

    private LatLng() {
    }

    public double getLatitude() {
        return this.latitude_;
    }

    /* access modifiers changed from: private */
    public void setLatitude(double value) {
        this.latitude_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLatitude() {
        this.latitude_ = 0.0d;
    }

    public double getLongitude() {
        return this.longitude_;
    }

    /* access modifiers changed from: private */
    public void setLongitude(double value) {
        this.longitude_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLongitude() {
        this.longitude_ = 0.0d;
    }

    public static LatLng parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LatLng parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LatLng parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LatLng parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LatLng parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LatLng parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LatLng parseFrom(InputStream input) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LatLng parseDelimitedFrom(InputStream input) throws IOException {
        return (LatLng) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LatLng parseFrom(CodedInputStream input) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LatLng prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<LatLng, Builder> implements LatLngOrBuilder {
        private Builder() {
            super(LatLng.DEFAULT_INSTANCE);
        }

        public double getLatitude() {
            return ((LatLng) this.instance).getLatitude();
        }

        public Builder setLatitude(double value) {
            copyOnWrite();
            ((LatLng) this.instance).setLatitude(value);
            return this;
        }

        public Builder clearLatitude() {
            copyOnWrite();
            ((LatLng) this.instance).clearLatitude();
            return this;
        }

        public double getLongitude() {
            return ((LatLng) this.instance).getLongitude();
        }

        public Builder setLongitude(double value) {
            copyOnWrite();
            ((LatLng) this.instance).setLongitude(value);
            return this;
        }

        public Builder clearLongitude() {
            copyOnWrite();
            ((LatLng) this.instance).clearLongitude();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new LatLng();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<LatLng> parser = PARSER;
                if (parser == null) {
                    synchronized (LatLng.class) {
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
        LatLng defaultInstance = new LatLng();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(LatLng.class, defaultInstance);
    }

    public static LatLng getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LatLng> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
