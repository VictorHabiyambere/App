package com.google.api;

import com.google.api.ContextRule;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Context extends GeneratedMessageLite<Context, Builder> implements ContextOrBuilder {
    /* access modifiers changed from: private */
    public static final Context DEFAULT_INSTANCE;
    private static volatile Parser<Context> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<ContextRule> rules_ = emptyProtobufList();

    private Context() {
    }

    public List<ContextRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends ContextRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public ContextRule getRules(int index) {
        return (ContextRule) this.rules_.get(index);
    }

    public ContextRuleOrBuilder getRulesOrBuilder(int index) {
        return (ContextRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        Internal.ProtobufList<ContextRule> tmp = this.rules_;
        if (!tmp.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(tmp);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, ContextRule value) {
        value.getClass();
        ensureRulesIsMutable();
        this.rules_.set(index, value);
    }

    /* access modifiers changed from: private */
    public void addRules(ContextRule value) {
        value.getClass();
        ensureRulesIsMutable();
        this.rules_.add(value);
    }

    /* access modifiers changed from: private */
    public void addRules(int index, ContextRule value) {
        value.getClass();
        ensureRulesIsMutable();
        this.rules_.add(index, value);
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends ContextRule> values) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(values, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int index) {
        ensureRulesIsMutable();
        this.rules_.remove(index);
    }

    public static Context parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Context parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Context parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Context parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Context parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Context parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Context parseFrom(InputStream input) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Context parseDelimitedFrom(InputStream input) throws IOException {
        return (Context) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Context parseFrom(CodedInputStream input) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Context prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Context, Builder> implements ContextOrBuilder {
        private Builder() {
            super(Context.DEFAULT_INSTANCE);
        }

        public List<ContextRule> getRulesList() {
            return Collections.unmodifiableList(((Context) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Context) this.instance).getRulesCount();
        }

        public ContextRule getRules(int index) {
            return ((Context) this.instance).getRules(index);
        }

        public Builder setRules(int index, ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).setRules(index, (ContextRule) builderForValue.build());
            return this;
        }

        public Builder addRules(ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).addRules((ContextRule) builderForValue.build());
            return this;
        }

        public Builder addRules(int index, ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).addRules(index, (ContextRule) builderForValue.build());
            return this;
        }

        public Builder addAllRules(Iterable<? extends ContextRule> values) {
            copyOnWrite();
            ((Context) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Context) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Context) this.instance).removeRules(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Context();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"rules_", ContextRule.class});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Context> parser = PARSER;
                if (parser == null) {
                    synchronized (Context.class) {
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
        Context defaultInstance = new Context();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Context.class, defaultInstance);
    }

    public static Context getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Context> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
