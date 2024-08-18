package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final String DEFAULT_DATE_PATTERN = null;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    public Gson() {
        this(Excluder.DEFAULT, DEFAULT_FIELD_NAMING_STRATEGY, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, DEFAULT_DATE_PATTERN, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DEFAULT_OBJECT_TO_NUMBER_STRATEGY, DEFAULT_NUMBER_TO_NUMBER_STRATEGY, Collections.emptyList());
    }

    Gson(Excluder excluder2, FieldNamingStrategy fieldNamingStrategy2, Map<Type, InstanceCreator<?>> instanceCreators2, boolean serializeNulls2, boolean complexMapKeySerialization2, boolean generateNonExecutableGson, boolean htmlSafe2, boolean prettyPrinting2, boolean lenient2, boolean serializeSpecialFloatingPointValues2, boolean useJdkUnsafe2, LongSerializationPolicy longSerializationPolicy2, String datePattern2, int dateStyle2, int timeStyle2, List<TypeAdapterFactory> builderFactories2, List<TypeAdapterFactory> builderHierarchyFactories2, List<TypeAdapterFactory> factoriesToBeAdded, ToNumberStrategy objectToNumberStrategy2, ToNumberStrategy numberToNumberStrategy2, List<ReflectionAccessFilter> reflectionFilters2) {
        Excluder excluder3 = excluder2;
        Map<Type, InstanceCreator<?>> map = instanceCreators2;
        boolean z = complexMapKeySerialization2;
        boolean z2 = serializeSpecialFloatingPointValues2;
        boolean z3 = useJdkUnsafe2;
        List<ReflectionAccessFilter> list = reflectionFilters2;
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = excluder3;
        this.fieldNamingStrategy = fieldNamingStrategy2;
        this.instanceCreators = map;
        this.constructorConstructor = new ConstructorConstructor(map, z3, list);
        this.serializeNulls = serializeNulls2;
        this.complexMapKeySerialization = z;
        this.generateNonExecutableJson = generateNonExecutableGson;
        this.htmlSafe = htmlSafe2;
        this.prettyPrinting = prettyPrinting2;
        this.lenient = lenient2;
        this.serializeSpecialFloatingPointValues = z2;
        this.useJdkUnsafe = z3;
        this.longSerializationPolicy = longSerializationPolicy2;
        this.datePattern = datePattern2;
        this.dateStyle = dateStyle2;
        this.timeStyle = timeStyle2;
        this.builderFactories = builderFactories2;
        this.builderHierarchyFactories = builderHierarchyFactories2;
        this.objectToNumberStrategy = objectToNumberStrategy2;
        this.numberToNumberStrategy = numberToNumberStrategy2;
        this.reflectionFilters = list;
        List<TypeAdapterFactory> factories2 = new ArrayList<>();
        factories2.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        factories2.add(ObjectTypeAdapter.getFactory(objectToNumberStrategy2));
        factories2.add(excluder3);
        factories2.addAll(factoriesToBeAdded);
        factories2.add(TypeAdapters.STRING_FACTORY);
        factories2.add(TypeAdapters.INTEGER_FACTORY);
        factories2.add(TypeAdapters.BOOLEAN_FACTORY);
        factories2.add(TypeAdapters.BYTE_FACTORY);
        factories2.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy2);
        factories2.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        factories2.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z2)));
        factories2.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z2)));
        factories2.add(NumberTypeAdapter.getFactory(numberToNumberStrategy2));
        factories2.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        factories2.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        factories2.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        factories2.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        factories2.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        factories2.add(TypeAdapters.CHARACTER_FACTORY);
        factories2.add(TypeAdapters.STRING_BUILDER_FACTORY);
        factories2.add(TypeAdapters.STRING_BUFFER_FACTORY);
        factories2.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        factories2.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        factories2.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        factories2.add(TypeAdapters.URL_FACTORY);
        factories2.add(TypeAdapters.URI_FACTORY);
        factories2.add(TypeAdapters.UUID_FACTORY);
        factories2.add(TypeAdapters.CURRENCY_FACTORY);
        factories2.add(TypeAdapters.LOCALE_FACTORY);
        factories2.add(TypeAdapters.INET_ADDRESS_FACTORY);
        factories2.add(TypeAdapters.BIT_SET_FACTORY);
        factories2.add(DateTypeAdapter.FACTORY);
        factories2.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            factories2.add(SqlTypesSupport.TIME_FACTORY);
            factories2.add(SqlTypesSupport.DATE_FACTORY);
            factories2.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        factories2.add(ArrayTypeAdapter.FACTORY);
        factories2.add(TypeAdapters.CLASS_FACTORY);
        factories2.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        factories2.add(new MapTypeAdapterFactory(this.constructorConstructor, z));
        this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        factories2.add(this.jsonAdapterFactory);
        factories2.add(TypeAdapters.ENUM_FACTORY);
        TypeAdapter<Number> typeAdapter = longAdapter;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = r1;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy2, excluder2, this.jsonAdapterFactory, reflectionFilters2);
        factories2.add(reflectiveTypeAdapterFactory);
        this.factories = Collections.unmodifiableList(factories2);
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    private TypeAdapter<Number> doubleAdapter(boolean serializeSpecialFloatingPointValues2) {
        if (serializeSpecialFloatingPointValues2) {
            return TypeAdapters.DOUBLE;
        }
        return new TypeAdapter<Number>() {
            public Double read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) {
                    return Double.valueOf(in.nextDouble());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                double doubleValue = value.doubleValue();
                Gson.checkValidFloatingPoint(doubleValue);
                out.value(doubleValue);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean serializeSpecialFloatingPointValues2) {
        if (serializeSpecialFloatingPointValues2) {
            return TypeAdapters.FLOAT;
        }
        return new TypeAdapter<Number>() {
            public Float read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) in.nextDouble());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                float floatValue = value.floatValue();
                Gson.checkValidFloatingPoint((double) floatValue);
                out.value(value instanceof Float ? value : Float.valueOf(floatValue));
            }
        };
    }

    static void checkValidFloatingPoint(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(value + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy2) {
        if (longSerializationPolicy2 == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new TypeAdapter<Number>() {
            public Number read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) {
                    return Long.valueOf(in.nextLong());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.toString());
                }
            }
        };
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> longAdapter) {
        return new TypeAdapter<AtomicLong>() {
            public void write(JsonWriter out, AtomicLong value) throws IOException {
                TypeAdapter.this.write(out, Long.valueOf(value.get()));
            }

            public AtomicLong read(JsonReader in) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(in)).longValue());
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> longAdapter) {
        return new TypeAdapter<AtomicLongArray>() {
            public void write(JsonWriter out, AtomicLongArray value) throws IOException {
                out.beginArray();
                int length = value.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(out, Long.valueOf(value.get(i)));
                }
                out.endArray();
            }

            public AtomicLongArray read(JsonReader in) throws IOException {
                List<Long> list = new ArrayList<>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(Long.valueOf(((Number) TypeAdapter.this.read(in)).longValue()));
                }
                in.endArray();
                int length = list.size();
                AtomicLongArray array = new AtomicLongArray(length);
                for (int i = 0; i < length; i++) {
                    array.set(i, list.get(i).longValue());
                }
                return array;
            }
        }.nullSafe();
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> type) {
        Objects.requireNonNull(type, "type must not be null");
        TypeAdapter<T> cached = (TypeAdapter) this.typeTokenCache.get(type);
        if (cached != null) {
            return cached;
        }
        Map<TypeToken<?>, TypeAdapter<?>> threadCalls = this.threadLocalAdapterResults.get();
        boolean isInitialAdapterRequest = false;
        if (threadCalls == null) {
            threadCalls = new HashMap<>();
            this.threadLocalAdapterResults.set(threadCalls);
            isInitialAdapterRequest = true;
        } else {
            TypeAdapter<T> ongoingCall = threadCalls.get(type);
            if (ongoingCall != null) {
                return ongoingCall;
            }
        }
        TypeAdapter<T> candidate = null;
        try {
            FutureTypeAdapter<T> call = new FutureTypeAdapter<>();
            threadCalls.put(type, call);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            while (true) {
                if (it.hasNext()) {
                    candidate = it.next().create(this, type);
                    if (candidate != null) {
                        call.setDelegate(candidate);
                        threadCalls.put(type, candidate);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (candidate != null) {
                if (isInitialAdapterRequest) {
                    this.typeTokenCache.putAll(threadCalls);
                }
                return candidate;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + type);
        } finally {
            if (isInitialAdapterRequest) {
                this.threadLocalAdapterResults.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory skipPast, TypeToken<T> type) {
        if (!this.factories.contains(skipPast)) {
            skipPast = this.jsonAdapterFactory;
        }
        boolean skipPastFound = false;
        for (TypeAdapterFactory factory : this.factories) {
            if (skipPastFound) {
                TypeAdapter<T> candidate = factory.create(this, type);
                if (candidate != null) {
                    return candidate;
                }
            } else if (factory == skipPast) {
                skipPastFound = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + type);
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> type) {
        return getAdapter(TypeToken.get(type));
    }

    public JsonElement toJsonTree(Object src) {
        if (src == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(src, src.getClass());
    }

    public JsonElement toJsonTree(Object src, Type typeOfSrc) {
        JsonTreeWriter writer = new JsonTreeWriter();
        toJson(src, typeOfSrc, (JsonWriter) writer);
        return writer.get();
    }

    public String toJson(Object src) {
        if (src == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(src, (Type) src.getClass());
    }

    public String toJson(Object src, Type typeOfSrc) {
        StringWriter writer = new StringWriter();
        toJson(src, typeOfSrc, (Appendable) writer);
        return writer.toString();
    }

    public void toJson(Object src, Appendable writer) throws JsonIOException {
        if (src != null) {
            toJson(src, (Type) src.getClass(), writer);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, writer);
        }
    }

    public void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        try {
            toJson(src, typeOfSrc, newJsonWriter(Streams.writerForAppendable(writer)));
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        TypeAdapter<Object> adapter = getAdapter(TypeToken.get(typeOfSrc));
        boolean oldLenient = writer.isLenient();
        writer.setLenient(true);
        boolean oldHtmlSafe = writer.isHtmlSafe();
        writer.setHtmlSafe(this.htmlSafe);
        boolean oldSerializeNulls = writer.getSerializeNulls();
        writer.setSerializeNulls(this.serializeNulls);
        try {
            adapter.write(writer, src);
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        } catch (AssertionError e2) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
        } catch (Throwable th) {
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
            throw th;
        }
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter writer = new StringWriter();
        toJson(jsonElement, (Appendable) writer);
        return writer.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(writer)));
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setLenient(this.lenient);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
        boolean oldLenient = writer.isLenient();
        writer.setLenient(true);
        boolean oldHtmlSafe = writer.isHtmlSafe();
        writer.setHtmlSafe(this.htmlSafe);
        boolean oldSerializeNulls = writer.getSerializeNulls();
        writer.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(jsonElement, writer);
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        } catch (AssertionError e2) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
        } catch (Throwable th) {
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
            throw th;
        }
    }

    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return Primitives.wrap(classOfT).cast(fromJson(json, TypeToken.get(classOfT)));
    }

    public <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return fromJson(json, TypeToken.get(typeOfT));
    }

    public <T> T fromJson(String json, TypeToken<T> typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromJson((Reader) new StringReader(json), typeOfT);
    }

    public <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return Primitives.wrap(classOfT).cast(fromJson(json, TypeToken.get(classOfT)));
    }

    public <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return fromJson(json, TypeToken.get(typeOfT));
    }

    public <T> T fromJson(Reader json, TypeToken<T> typeOfT) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader = newJsonReader(json);
        T object = fromJson(jsonReader, typeOfT);
        assertFullConsumption(object, jsonReader);
        return object;
    }

    private static void assertFullConsumption(Object obj, JsonReader reader) {
        if (obj != null) {
            try {
                if (reader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            }
        }
    }

    public <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return fromJson(reader, TypeToken.get(typeOfT));
    }

    public <T> T fromJson(JsonReader reader, TypeToken<T> typeOfT) throws JsonIOException, JsonSyntaxException {
        boolean oldLenient = reader.isLenient();
        reader.setLenient(true);
        try {
            reader.peek();
            T read = getAdapter(typeOfT).read(reader);
            reader.setLenient(oldLenient);
            return read;
        } catch (EOFException e) {
            if (1 != 0) {
                reader.setLenient(oldLenient);
                return null;
            }
            throw new JsonSyntaxException((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IOException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        } catch (AssertionError e4) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
        } catch (Throwable th) {
            reader.setLenient(oldLenient);
            throw th;
        }
    }

    public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return Primitives.wrap(classOfT).cast(fromJson(json, TypeToken.get(classOfT)));
    }

    public <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        return fromJson(json, TypeToken.get(typeOfT));
    }

    public <T> T fromJson(JsonElement json, TypeToken<T> typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromJson((JsonReader) new JsonTreeReader(json), typeOfT);
    }

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate = null;

        FutureTypeAdapter() {
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate == null) {
                this.delegate = typeAdapter;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> delegate2 = this.delegate;
            if (delegate2 != null) {
                return delegate2;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        public T read(JsonReader in) throws IOException {
            return delegate().read(in);
        }

        public void write(JsonWriter out, T value) throws IOException {
            delegate().write(out, value);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}
