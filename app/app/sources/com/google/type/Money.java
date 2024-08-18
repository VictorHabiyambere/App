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

public final class Money extends GeneratedMessageLite<Money, Builder> implements MoneyOrBuilder {
    public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Money DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 3;
    private static volatile Parser<Money> PARSER = null;
    public static final int UNITS_FIELD_NUMBER = 2;
    private String currencyCode_ = "";
    private int nanos_;
    private long units_;

    private Money() {
    }

    public String getCurrencyCode() {
        return this.currencyCode_;
    }

    public ByteString getCurrencyCodeBytes() {
        return ByteString.copyFromUtf8(this.currencyCode_);
    }

    /* access modifiers changed from: private */
    public void setCurrencyCode(String value) {
        value.getClass();
        this.currencyCode_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCurrencyCode() {
        this.currencyCode_ = getDefaultInstance().getCurrencyCode();
    }

    /* access modifiers changed from: private */
    public void setCurrencyCodeBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.currencyCode_ = value.toStringUtf8();
    }

    public long getUnits() {
        return this.units_;
    }

    /* access modifiers changed from: private */
    public void setUnits(long value) {
        this.units_ = value;
    }

    /* access modifiers changed from: private */
    public void clearUnits() {
        this.units_ = 0;
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

    public static Money parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Money parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Money parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Money parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Money parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Money parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Money parseFrom(InputStream input) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Money parseDelimitedFrom(InputStream input) throws IOException {
        return (Money) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Money parseFrom(CodedInputStream input) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Money prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
        private Builder() {
            super(Money.DEFAULT_INSTANCE);
        }

        public String getCurrencyCode() {
            return ((Money) this.instance).getCurrencyCode();
        }

        public ByteString getCurrencyCodeBytes() {
            return ((Money) this.instance).getCurrencyCodeBytes();
        }

        public Builder setCurrencyCode(String value) {
            copyOnWrite();
            ((Money) this.instance).setCurrencyCode(value);
            return this;
        }

        public Builder clearCurrencyCode() {
            copyOnWrite();
            ((Money) this.instance).clearCurrencyCode();
            return this;
        }

        public Builder setCurrencyCodeBytes(ByteString value) {
            copyOnWrite();
            ((Money) this.instance).setCurrencyCodeBytes(value);
            return this;
        }

        public long getUnits() {
            return ((Money) this.instance).getUnits();
        }

        public Builder setUnits(long value) {
            copyOnWrite();
            ((Money) this.instance).setUnits(value);
            return this;
        }

        public Builder clearUnits() {
            copyOnWrite();
            ((Money) this.instance).clearUnits();
            return this;
        }

        public int getNanos() {
            return ((Money) this.instance).getNanos();
        }

        public Builder setNanos(int value) {
            copyOnWrite();
            ((Money) this.instance).setNanos(value);
            return this;
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((Money) this.instance).clearNanos();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Money();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0004", new Object[]{"currencyCode_", "units_", "nanos_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Money> parser = PARSER;
                if (parser == null) {
                    synchronized (Money.class) {
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
        Money defaultInstance = new Money();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Money.class, defaultInstance);
    }

    public static Money getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Money> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
