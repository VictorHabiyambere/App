package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class GsonBuilder {
    private boolean complexMapKeySerialization = false;
    private String datePattern = Gson.DEFAULT_DATE_PATTERN;
    private int dateStyle = 2;
    private boolean escapeHtmlChars = true;
    private Excluder excluder = Excluder.DEFAULT;
    private final List<TypeAdapterFactory> factories = new ArrayList();
    private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    private boolean generateNonExecutableJson = false;
    private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList();
    private final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap();
    private boolean lenient = false;
    private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    private ToNumberStrategy numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
    private ToNumberStrategy objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
    private boolean prettyPrinting = false;
    private final LinkedList<ReflectionAccessFilter> reflectionFilters = new LinkedList<>();
    private boolean serializeNulls = false;
    private boolean serializeSpecialFloatingPointValues = false;
    private int timeStyle = 2;
    private boolean useJdkUnsafe = true;

    public GsonBuilder() {
    }

    GsonBuilder(Gson gson) {
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
        this.useJdkUnsafe = gson.useJdkUnsafe;
        this.objectToNumberStrategy = gson.objectToNumberStrategy;
        this.numberToNumberStrategy = gson.numberToNumberStrategy;
        this.reflectionFilters.addAll(gson.reflectionFilters);
    }

    public GsonBuilder setVersion(double version) {
        if (Double.isNaN(version) || version < 0.0d) {
            throw new IllegalArgumentException("Invalid version: " + version);
        }
        this.excluder = this.excluder.withVersion(version);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... modifiers) {
        Objects.requireNonNull(modifiers);
        this.excluder = this.excluder.withModifiers(modifiers);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy serializationPolicy) {
        this.longSerializationPolicy = (LongSerializationPolicy) Objects.requireNonNull(serializationPolicy);
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy namingConvention) {
        return setFieldNamingStrategy(namingConvention);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = (FieldNamingStrategy) Objects.requireNonNull(fieldNamingStrategy);
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy objectToNumberStrategy2) {
        this.objectToNumberStrategy = (ToNumberStrategy) Objects.requireNonNull(objectToNumberStrategy2);
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy numberToNumberStrategy2) {
        this.numberToNumberStrategy = (ToNumberStrategy) Objects.requireNonNull(numberToNumberStrategy2);
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... strategies) {
        Objects.requireNonNull(strategies);
        for (ExclusionStrategy strategy : strategies) {
            this.excluder = this.excluder.withExclusionStrategy(strategy, true, true);
        }
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy strategy) {
        Objects.requireNonNull(strategy);
        this.excluder = this.excluder.withExclusionStrategy(strategy, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy strategy) {
        Objects.requireNonNull(strategy);
        this.excluder = this.excluder.withExclusionStrategy(strategy, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder setDateFormat(String pattern) {
        this.datePattern = pattern;
        return this;
    }

    public GsonBuilder setDateFormat(int style) {
        this.dateStyle = style;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int dateStyle2, int timeStyle2) {
        this.dateStyle = dateStyle2;
        this.timeStyle = timeStyle2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object typeAdapter) {
        Objects.requireNonNull(type);
        C$Gson$Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof InstanceCreator) || (typeAdapter instanceof TypeAdapter));
        if (typeAdapter instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator) typeAdapter);
        }
        if ((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer)) {
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) typeAdapter));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory factory) {
        Objects.requireNonNull(factory);
        this.factories.add(factory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter) {
        Objects.requireNonNull(baseType);
        C$Gson$Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof TypeAdapter));
        if ((typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof JsonSerializer)) {
            this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(baseType, typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(baseType, (TypeAdapter) typeAdapter));
        }
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter filter) {
        Objects.requireNonNull(filter);
        this.reflectionFilters.addFirst(filter);
        return this;
    }

    public Gson create() {
        ArrayList arrayList = new ArrayList(this.factories.size() + this.hierarchyFactories.size() + 3);
        ArrayList arrayList2 = arrayList;
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        ArrayList arrayList3 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList3);
        arrayList.addAll(arrayList3);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        Excluder excluder2 = this.excluder;
        FieldNamingStrategy fieldNamingStrategy = this.fieldNamingPolicy;
        HashMap hashMap = r7;
        HashMap hashMap2 = new HashMap(this.instanceCreators);
        boolean z = this.serializeNulls;
        boolean z2 = this.complexMapKeySerialization;
        boolean z3 = this.generateNonExecutableJson;
        boolean z4 = this.escapeHtmlChars;
        boolean z5 = this.prettyPrinting;
        boolean z6 = this.lenient;
        boolean z7 = this.serializeSpecialFloatingPointValues;
        boolean z8 = this.useJdkUnsafe;
        LongSerializationPolicy longSerializationPolicy2 = this.longSerializationPolicy;
        ArrayList arrayList4 = arrayList;
        String str = this.datePattern;
        int i = this.dateStyle;
        int i2 = this.timeStyle;
        ArrayList arrayList5 = r1;
        ArrayList arrayList6 = arrayList3;
        ArrayList arrayList7 = new ArrayList(this.factories);
        ArrayList arrayList8 = r1;
        ArrayList arrayList9 = new ArrayList(this.hierarchyFactories);
        ToNumberStrategy toNumberStrategy = this.objectToNumberStrategy;
        ToNumberStrategy toNumberStrategy2 = this.numberToNumberStrategy;
        ArrayList arrayList10 = r1;
        ArrayList arrayList11 = new ArrayList(this.reflectionFilters);
        return new Gson(excluder2, fieldNamingStrategy, hashMap, z, z2, z3, z4, z5, z6, z7, z8, longSerializationPolicy2, str, i, i2, arrayList5, arrayList8, arrayList2, toNumberStrategy, toNumberStrategy2, arrayList10);
    }

    private void addTypeAdaptersForDate(String datePattern2, int dateStyle2, int timeStyle2, List<TypeAdapterFactory> factories2) {
        TypeAdapterFactory dateAdapterFactory;
        boolean sqlTypesSupported = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory sqlTimestampAdapterFactory = null;
        TypeAdapterFactory sqlDateAdapterFactory = null;
        if (datePattern2 != null && !datePattern2.trim().isEmpty()) {
            dateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(datePattern2);
            if (sqlTypesSupported) {
                sqlTimestampAdapterFactory = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(datePattern2);
                sqlDateAdapterFactory = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(datePattern2);
            }
        } else if (dateStyle2 != 2 && timeStyle2 != 2) {
            dateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(dateStyle2, timeStyle2);
            if (sqlTypesSupported) {
                sqlTimestampAdapterFactory = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(dateStyle2, timeStyle2);
                sqlDateAdapterFactory = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(dateStyle2, timeStyle2);
            }
        } else {
            return;
        }
        factories2.add(dateAdapterFactory);
        if (sqlTypesSupported) {
            factories2.add(sqlTimestampAdapterFactory);
            factories2.add(sqlDateAdapterFactory);
        }
    }
}
