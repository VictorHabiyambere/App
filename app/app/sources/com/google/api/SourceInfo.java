package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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

public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final SourceInfo DEFAULT_INSTANCE;
    private static volatile Parser<SourceInfo> PARSER = null;
    public static final int SOURCE_FILES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Any> sourceFiles_ = emptyProtobufList();

    private SourceInfo() {
    }

    public List<Any> getSourceFilesList() {
        return this.sourceFiles_;
    }

    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
        return this.sourceFiles_;
    }

    public int getSourceFilesCount() {
        return this.sourceFiles_.size();
    }

    public Any getSourceFiles(int index) {
        return (Any) this.sourceFiles_.get(index);
    }

    public AnyOrBuilder getSourceFilesOrBuilder(int index) {
        return (AnyOrBuilder) this.sourceFiles_.get(index);
    }

    private void ensureSourceFilesIsMutable() {
        Internal.ProtobufList<Any> tmp = this.sourceFiles_;
        if (!tmp.isModifiable()) {
            this.sourceFiles_ = GeneratedMessageLite.mutableCopy(tmp);
        }
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int index, Any value) {
        value.getClass();
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(index, value);
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any value) {
        value.getClass();
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(value);
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int index, Any value) {
        value.getClass();
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(index, value);
    }

    /* access modifiers changed from: private */
    public void addAllSourceFiles(Iterable<? extends Any> values) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.addAll(values, this.sourceFiles_);
    }

    /* access modifiers changed from: private */
    public void clearSourceFiles() {
        this.sourceFiles_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSourceFiles(int index) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(index);
    }

    public static SourceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SourceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SourceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SourceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SourceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SourceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SourceInfo parseFrom(InputStream input) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SourceInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SourceInfo parseFrom(CodedInputStream input) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(SourceInfo prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        private Builder() {
            super(SourceInfo.DEFAULT_INSTANCE);
        }

        public List<Any> getSourceFilesList() {
            return Collections.unmodifiableList(((SourceInfo) this.instance).getSourceFilesList());
        }

        public int getSourceFilesCount() {
            return ((SourceInfo) this.instance).getSourceFilesCount();
        }

        public Any getSourceFiles(int index) {
            return ((SourceInfo) this.instance).getSourceFiles(index);
        }

        public Builder setSourceFiles(int index, Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(index, value);
            return this;
        }

        public Builder setSourceFiles(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(index, (Any) builderForValue.build());
            return this;
        }

        public Builder addSourceFiles(Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(value);
            return this;
        }

        public Builder addSourceFiles(int index, Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(index, value);
            return this;
        }

        public Builder addSourceFiles(Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles((Any) builderForValue.build());
            return this;
        }

        public Builder addSourceFiles(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(index, (Any) builderForValue.build());
            return this;
        }

        public Builder addAllSourceFiles(Iterable<? extends Any> values) {
            copyOnWrite();
            ((SourceInfo) this.instance).addAllSourceFiles(values);
            return this;
        }

        public Builder clearSourceFiles() {
            copyOnWrite();
            ((SourceInfo) this.instance).clearSourceFiles();
            return this;
        }

        public Builder removeSourceFiles(int index) {
            copyOnWrite();
            ((SourceInfo) this.instance).removeSourceFiles(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new SourceInfo();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"sourceFiles_", Any.class});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<SourceInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (SourceInfo.class) {
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
        SourceInfo defaultInstance = new SourceInfo();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(SourceInfo.class, defaultInstance);
    }

    public static SourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
