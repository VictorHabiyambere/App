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

public final class TimeOfDay extends GeneratedMessageLite<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
    /* access modifiers changed from: private */
    public static final TimeOfDay DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 1;
    public static final int MINUTES_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 4;
    private static volatile Parser<TimeOfDay> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 3;
    private int hours_;
    private int minutes_;
    private int nanos_;
    private int seconds_;

    private TimeOfDay() {
    }

    public int getHours() {
        return this.hours_;
    }

    /* access modifiers changed from: private */
    public void setHours(int value) {
        this.hours_ = value;
    }

    /* access modifiers changed from: private */
    public void clearHours() {
        this.hours_ = 0;
    }

    public int getMinutes() {
        return this.minutes_;
    }

    /* access modifiers changed from: private */
    public void setMinutes(int value) {
        this.minutes_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMinutes() {
        this.minutes_ = 0;
    }

    public int getSeconds() {
        return this.seconds_;
    }

    /* access modifiers changed from: private */
    public void setSeconds(int value) {
        this.seconds_ = value;
    }

    /* access modifiers changed from: private */
    public void clearSeconds() {
        this.seconds_ = 0;
    }

    public int getNanos() {
        return this.nanos_;
    }

    /* access modifiers changed from: private */
    public void setNanos(int value) {
        this.nanos_ = value;
    }

    /* access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    public static TimeOfDay parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TimeOfDay parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TimeOfDay parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TimeOfDay parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TimeOfDay parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TimeOfDay parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TimeOfDay parseFrom(InputStream input) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TimeOfDay parseDelimitedFrom(InputStream input) throws IOException {
        return (TimeOfDay) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TimeOfDay parseFrom(CodedInputStream input) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(TimeOfDay prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
        private Builder() {
            super(TimeOfDay.DEFAULT_INSTANCE);
        }

        public int getHours() {
            return ((TimeOfDay) this.instance).getHours();
        }

        public Builder setHours(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setHours(value);
            return this;
        }

        public Builder clearHours() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearHours();
            return this;
        }

        public int getMinutes() {
            return ((TimeOfDay) this.instance).getMinutes();
        }

        public Builder setMinutes(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setMinutes(value);
            return this;
        }

        public Builder clearMinutes() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearMinutes();
            return this;
        }

        public int getSeconds() {
            return ((TimeOfDay) this.instance).getSeconds();
        }

        public Builder setSeconds(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setSeconds(value);
            return this;
        }

        public Builder clearSeconds() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearSeconds();
            return this;
        }

        public int getNanos() {
            return ((TimeOfDay) this.instance).getNanos();
        }

        public Builder setNanos(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setNanos(value);
            return this;
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearNanos();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new TimeOfDay();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004", new Object[]{"hours_", "minutes_", "seconds_", "nanos_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<TimeOfDay> parser = PARSER;
                if (parser == null) {
                    synchronized (TimeOfDay.class) {
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
        TimeOfDay defaultInstance = new TimeOfDay();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(TimeOfDay.class, defaultInstance);
    }

    public static TimeOfDay getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TimeOfDay> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
