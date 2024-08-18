package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    /* access modifiers changed from: private */
    public static final PreconditionFailure DEFAULT_INSTANCE;
    private static volatile Parser<PreconditionFailure> PARSER = null;
    public static final int VIOLATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Violation> violations_ = emptyProtobufList();

    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getSubject();

        ByteString getSubjectBytes();

        String getType();

        ByteString getTypeBytes();
    }

    private PreconditionFailure() {
    }

    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {
        /* access modifiers changed from: private */
        public static final Violation DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 3;
        private static volatile Parser<Violation> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String description_ = "";
        private String subject_ = "";
        private String type_ = "";

        private Violation() {
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

        public String getSubject() {
            return this.subject_;
        }

        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        /* access modifiers changed from: private */
        public void setSubject(String value) {
            value.getClass();
            this.subject_ = value;
        }

        /* access modifiers changed from: private */
        public void clearSubject() {
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* access modifiers changed from: private */
        public void setSubjectBytes(ByteString value) {
            checkByteStringIsUtf8(value);
            this.subject_ = value.toStringUtf8();
        }

        public String getDescription() {
            return this.description_;
        }

        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        /* access modifiers changed from: private */
        public void setDescription(String value) {
            value.getClass();
            this.description_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* access modifiers changed from: private */
        public void setDescriptionBytes(ByteString value) {
            checkByteStringIsUtf8(value);
            this.description_ = value.toStringUtf8();
        }

        public static Violation parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Violation parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Violation parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Violation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Violation parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Violation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Violation parseFrom(InputStream input) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Violation parseDelimitedFrom(InputStream input) throws IOException {
            return (Violation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Violation parseFrom(CodedInputStream input) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Violation prototype) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            private Builder() {
                super(Violation.DEFAULT_INSTANCE);
            }

            public String getType() {
                return ((Violation) this.instance).getType();
            }

            public ByteString getTypeBytes() {
                return ((Violation) this.instance).getTypeBytes();
            }

            public Builder setType(String value) {
                copyOnWrite();
                ((Violation) this.instance).setType(value);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Violation) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setTypeBytes(value);
                return this;
            }

            public String getSubject() {
                return ((Violation) this.instance).getSubject();
            }

            public ByteString getSubjectBytes() {
                return ((Violation) this.instance).getSubjectBytes();
            }

            public Builder setSubject(String value) {
                copyOnWrite();
                ((Violation) this.instance).setSubject(value);
                return this;
            }

            public Builder clearSubject() {
                copyOnWrite();
                ((Violation) this.instance).clearSubject();
                return this;
            }

            public Builder setSubjectBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setSubjectBytes(value);
                return this;
            }

            public String getDescription() {
                return ((Violation) this.instance).getDescription();
            }

            public ByteString getDescriptionBytes() {
                return ((Violation) this.instance).getDescriptionBytes();
            }

            public Builder setDescription(String value) {
                copyOnWrite();
                ((Violation) this.instance).setDescription(value);
                return this;
            }

            public Builder clearDescription() {
                copyOnWrite();
                ((Violation) this.instance).clearDescription();
                return this;
            }

            public Builder setDescriptionBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setDescriptionBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new Violation();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"type_", "subject_", "description_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Violation> parser = PARSER;
                    if (parser == null) {
                        synchronized (Violation.class) {
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
            Violation defaultInstance = new Violation();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(Violation.class, defaultInstance);
        }

        public static Violation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Violation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public List<Violation> getViolationsList() {
        return this.violations_;
    }

    public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
        return this.violations_;
    }

    public int getViolationsCount() {
        return this.violations_.size();
    }

    public Violation getViolations(int index) {
        return (Violation) this.violations_.get(index);
    }

    public ViolationOrBuilder getViolationsOrBuilder(int index) {
        return (ViolationOrBuilder) this.violations_.get(index);
    }

    private void ensureViolationsIsMutable() {
        Internal.ProtobufList<Violation> tmp = this.violations_;
        if (!tmp.isModifiable()) {
            this.violations_ = GeneratedMessageLite.mutableCopy(tmp);
        }
    }

    /* access modifiers changed from: private */
    public void setViolations(int index, Violation value) {
        value.getClass();
        ensureViolationsIsMutable();
        this.violations_.set(index, value);
    }

    /* access modifiers changed from: private */
    public void addViolations(Violation value) {
        value.getClass();
        ensureViolationsIsMutable();
        this.violations_.add(value);
    }

    /* access modifiers changed from: private */
    public void addViolations(int index, Violation value) {
        value.getClass();
        ensureViolationsIsMutable();
        this.violations_.add(index, value);
    }

    /* access modifiers changed from: private */
    public void addAllViolations(Iterable<? extends Violation> values) {
        ensureViolationsIsMutable();
        AbstractMessageLite.addAll(values, this.violations_);
    }

    /* access modifiers changed from: private */
    public void clearViolations() {
        this.violations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeViolations(int index) {
        ensureViolationsIsMutable();
        this.violations_.remove(index);
    }

    public static PreconditionFailure parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PreconditionFailure parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PreconditionFailure parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PreconditionFailure parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(InputStream input) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream input) throws IOException {
        return (PreconditionFailure) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(CodedInputStream input) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(PreconditionFailure prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
        private Builder() {
            super(PreconditionFailure.DEFAULT_INSTANCE);
        }

        public List<Violation> getViolationsList() {
            return Collections.unmodifiableList(((PreconditionFailure) this.instance).getViolationsList());
        }

        public int getViolationsCount() {
            return ((PreconditionFailure) this.instance).getViolationsCount();
        }

        public Violation getViolations(int index) {
            return ((PreconditionFailure) this.instance).getViolations(index);
        }

        public Builder setViolations(int index, Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(index, value);
            return this;
        }

        public Builder setViolations(int index, Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(index, (Violation) builderForValue.build());
            return this;
        }

        public Builder addViolations(Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(value);
            return this;
        }

        public Builder addViolations(int index, Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(index, value);
            return this;
        }

        public Builder addViolations(Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations((Violation) builderForValue.build());
            return this;
        }

        public Builder addViolations(int index, Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(index, (Violation) builderForValue.build());
            return this;
        }

        public Builder addAllViolations(Iterable<? extends Violation> values) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addAllViolations(values);
            return this;
        }

        public Builder clearViolations() {
            copyOnWrite();
            ((PreconditionFailure) this.instance).clearViolations();
            return this;
        }

        public Builder removeViolations(int index) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).removeViolations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new PreconditionFailure();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"violations_", Violation.class});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<PreconditionFailure> parser = PARSER;
                if (parser == null) {
                    synchronized (PreconditionFailure.class) {
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
        PreconditionFailure defaultInstance = new PreconditionFailure();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(PreconditionFailure.class, defaultInstance);
    }

    public static PreconditionFailure getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PreconditionFailure> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
