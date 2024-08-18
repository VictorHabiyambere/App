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

public final class Quaternion extends GeneratedMessageLite<Quaternion, Builder> implements QuaternionOrBuilder {
    /* access modifiers changed from: private */
    public static final Quaternion DEFAULT_INSTANCE;
    private static volatile Parser<Quaternion> PARSER = null;
    public static final int W_FIELD_NUMBER = 4;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    public static final int Z_FIELD_NUMBER = 3;
    private double w_;
    private double x_;
    private double y_;
    private double z_;

    private Quaternion() {
    }

    public double getX() {
        return this.x_;
    }

    /* access modifiers changed from: private */
    public void setX(double value) {
        this.x_ = value;
    }

    /* access modifiers changed from: private */
    public void clearX() {
        this.x_ = 0.0d;
    }

    public double getY() {
        return this.y_;
    }

    /* access modifiers changed from: private */
    public void setY(double value) {
        this.y_ = value;
    }

    /* access modifiers changed from: private */
    public void clearY() {
        this.y_ = 0.0d;
    }

    public double getZ() {
        return this.z_;
    }

    /* access modifiers changed from: private */
    public void setZ(double value) {
        this.z_ = value;
    }

    /* access modifiers changed from: private */
    public void clearZ() {
        this.z_ = 0.0d;
    }

    public double getW() {
        return this.w_;
    }

    /* access modifiers changed from: private */
    public void setW(double value) {
        this.w_ = value;
    }

    /* access modifiers changed from: private */
    public void clearW() {
        this.w_ = 0.0d;
    }

    public static Quaternion parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Quaternion parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Quaternion parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Quaternion parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Quaternion parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Quaternion parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Quaternion parseFrom(InputStream input) throws IOException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Quaternion parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Quaternion parseDelimitedFrom(InputStream input) throws IOException {
        return (Quaternion) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Quaternion parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quaternion) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Quaternion parseFrom(CodedInputStream input) throws IOException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Quaternion parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quaternion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Quaternion prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Quaternion, Builder> implements QuaternionOrBuilder {
        private Builder() {
            super(Quaternion.DEFAULT_INSTANCE);
        }

        public double getX() {
            return ((Quaternion) this.instance).getX();
        }

        public Builder setX(double value) {
            copyOnWrite();
            ((Quaternion) this.instance).setX(value);
            return this;
        }

        public Builder clearX() {
            copyOnWrite();
            ((Quaternion) this.instance).clearX();
            return this;
        }

        public double getY() {
            return ((Quaternion) this.instance).getY();
        }

        public Builder setY(double value) {
            copyOnWrite();
            ((Quaternion) this.instance).setY(value);
            return this;
        }

        public Builder clearY() {
            copyOnWrite();
            ((Quaternion) this.instance).clearY();
            return this;
        }

        public double getZ() {
            return ((Quaternion) this.instance).getZ();
        }

        public Builder setZ(double value) {
            copyOnWrite();
            ((Quaternion) this.instance).setZ(value);
            return this;
        }

        public Builder clearZ() {
            copyOnWrite();
            ((Quaternion) this.instance).clearZ();
            return this;
        }

        public double getW() {
            return ((Quaternion) this.instance).getW();
        }

        public Builder setW(double value) {
            copyOnWrite();
            ((Quaternion) this.instance).setW(value);
            return this;
        }

        public Builder clearW() {
            copyOnWrite();
            ((Quaternion) this.instance).clearW();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Quaternion();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0000\u0002\u0000\u0003\u0000\u0004\u0000", new Object[]{"x_", "y_", "z_", "w_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Quaternion> parser = PARSER;
                if (parser == null) {
                    synchronized (Quaternion.class) {
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
        Quaternion defaultInstance = new Quaternion();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Quaternion.class, defaultInstance);
    }

    public static Quaternion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Quaternion> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
