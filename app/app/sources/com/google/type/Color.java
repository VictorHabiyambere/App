package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {
    public static final int ALPHA_FIELD_NUMBER = 4;
    public static final int BLUE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Color DEFAULT_INSTANCE;
    public static final int GREEN_FIELD_NUMBER = 2;
    private static volatile Parser<Color> PARSER = null;
    public static final int RED_FIELD_NUMBER = 1;
    private FloatValue alpha_;
    private float blue_;
    private float green_;
    private float red_;

    private Color() {
    }

    public float getRed() {
        return this.red_;
    }

    /* access modifiers changed from: private */
    public void setRed(float value) {
        this.red_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRed() {
        this.red_ = 0.0f;
    }

    public float getGreen() {
        return this.green_;
    }

    /* access modifiers changed from: private */
    public void setGreen(float value) {
        this.green_ = value;
    }

    /* access modifiers changed from: private */
    public void clearGreen() {
        this.green_ = 0.0f;
    }

    public float getBlue() {
        return this.blue_;
    }

    /* access modifiers changed from: private */
    public void setBlue(float value) {
        this.blue_ = value;
    }

    /* access modifiers changed from: private */
    public void clearBlue() {
        this.blue_ = 0.0f;
    }

    public boolean hasAlpha() {
        return this.alpha_ != null;
    }

    public FloatValue getAlpha() {
        return this.alpha_ == null ? FloatValue.getDefaultInstance() : this.alpha_;
    }

    /* access modifiers changed from: private */
    public void setAlpha(FloatValue value) {
        value.getClass();
        this.alpha_ = value;
    }

    /* access modifiers changed from: private */
    public void mergeAlpha(FloatValue value) {
        value.getClass();
        if (this.alpha_ == null || this.alpha_ == FloatValue.getDefaultInstance()) {
            this.alpha_ = value;
        } else {
            this.alpha_ = (FloatValue) ((FloatValue.Builder) FloatValue.newBuilder(this.alpha_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAlpha() {
        this.alpha_ = null;
    }

    public static Color parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Color parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Color parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Color parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Color parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Color parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Color parseFrom(InputStream input) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Color parseDelimitedFrom(InputStream input) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Color parseFrom(CodedInputStream input) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Color prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        private Builder() {
            super(Color.DEFAULT_INSTANCE);
        }

        public float getRed() {
            return ((Color) this.instance).getRed();
        }

        public Builder setRed(float value) {
            copyOnWrite();
            ((Color) this.instance).setRed(value);
            return this;
        }

        public Builder clearRed() {
            copyOnWrite();
            ((Color) this.instance).clearRed();
            return this;
        }

        public float getGreen() {
            return ((Color) this.instance).getGreen();
        }

        public Builder setGreen(float value) {
            copyOnWrite();
            ((Color) this.instance).setGreen(value);
            return this;
        }

        public Builder clearGreen() {
            copyOnWrite();
            ((Color) this.instance).clearGreen();
            return this;
        }

        public float getBlue() {
            return ((Color) this.instance).getBlue();
        }

        public Builder setBlue(float value) {
            copyOnWrite();
            ((Color) this.instance).setBlue(value);
            return this;
        }

        public Builder clearBlue() {
            copyOnWrite();
            ((Color) this.instance).clearBlue();
            return this;
        }

        public boolean hasAlpha() {
            return ((Color) this.instance).hasAlpha();
        }

        public FloatValue getAlpha() {
            return ((Color) this.instance).getAlpha();
        }

        public Builder setAlpha(FloatValue value) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(value);
            return this;
        }

        public Builder setAlpha(FloatValue.Builder builderForValue) {
            copyOnWrite();
            ((Color) this.instance).setAlpha((FloatValue) builderForValue.build());
            return this;
        }

        public Builder mergeAlpha(FloatValue value) {
            copyOnWrite();
            ((Color) this.instance).mergeAlpha(value);
            return this;
        }

        public Builder clearAlpha() {
            copyOnWrite();
            ((Color) this.instance).clearAlpha();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Color();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0001\u0004\t", new Object[]{"red_", "green_", "blue_", "alpha_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Color> parser = PARSER;
                if (parser == null) {
                    synchronized (Color.class) {
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
        Color defaultInstance = new Color();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Color.class, defaultInstance);
    }

    public static Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Color> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
