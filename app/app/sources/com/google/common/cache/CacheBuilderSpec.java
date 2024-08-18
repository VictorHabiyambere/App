package com.google.common.cache;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).buildOrThrow();
    long accessExpirationDuration;
    @CheckForNull
    TimeUnit accessExpirationTimeUnit;
    @CheckForNull
    Integer concurrencyLevel;
    @CheckForNull
    Integer initialCapacity;
    @CheckForNull
    LocalCache.Strength keyStrength;
    @CheckForNull
    Long maximumSize;
    @CheckForNull
    Long maximumWeight;
    @CheckForNull
    Boolean recordStats;
    long refreshDuration;
    @CheckForNull
    TimeUnit refreshTimeUnit;
    private final String specification;
    @CheckForNull
    LocalCache.Strength valueStrength;
    long writeExpirationDuration;
    @CheckForNull
    TimeUnit writeExpirationTimeUnit;

    private interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2);
    }

    private CacheBuilderSpec(String specification2) {
        this.specification = specification2;
    }

    public static CacheBuilderSpec parse(String cacheBuilderSpecification) {
        CacheBuilderSpec spec = new CacheBuilderSpec(cacheBuilderSpecification);
        if (!cacheBuilderSpecification.isEmpty()) {
            for (String keyValuePair : KEYS_SPLITTER.split(cacheBuilderSpecification)) {
                List<String> keyAndValue = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(keyValuePair));
                Preconditions.checkArgument(!keyAndValue.isEmpty(), "blank key-value pair");
                boolean z = false;
                Preconditions.checkArgument(keyAndValue.size() <= 2, "key-value pair %s with more than one equals sign", (Object) keyValuePair);
                String key = keyAndValue.get(0);
                ValueParser valueParser = VALUE_PARSERS.get(key);
                if (valueParser != null) {
                    z = true;
                }
                Preconditions.checkArgument(z, "unknown key %s", (Object) key);
                valueParser.parse(spec, key, keyAndValue.size() == 1 ? null : keyAndValue.get(1));
            }
        }
        return spec;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
        if (this.initialCapacity != null) {
            builder.initialCapacity(this.initialCapacity.intValue());
        }
        if (this.maximumSize != null) {
            builder.maximumSize(this.maximumSize.longValue());
        }
        if (this.maximumWeight != null) {
            builder.maximumWeight(this.maximumWeight.longValue());
        }
        if (this.concurrencyLevel != null) {
            builder.concurrencyLevel(this.concurrencyLevel.intValue());
        }
        if (this.keyStrength != null) {
            switch (this.keyStrength) {
                case WEAK:
                    builder.weakKeys();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (this.valueStrength != null) {
            switch (this.valueStrength) {
                case WEAK:
                    builder.weakValues();
                    break;
                case SOFT:
                    builder.softValues();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (this.recordStats != null && this.recordStats.booleanValue()) {
            builder.recordStats();
        }
        if (this.writeExpirationTimeUnit != null) {
            builder.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
        }
        if (this.accessExpirationTimeUnit != null) {
            builder.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
        }
        if (this.refreshTimeUnit != null) {
            builder.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
        }
        return builder;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).addValue((Object) toParsableString()).toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec that = (CacheBuilderSpec) obj;
        if (!Objects.equal(this.initialCapacity, that.initialCapacity) || !Objects.equal(this.maximumSize, that.maximumSize) || !Objects.equal(this.maximumWeight, that.maximumWeight) || !Objects.equal(this.concurrencyLevel, that.concurrencyLevel) || !Objects.equal(this.keyStrength, that.keyStrength) || !Objects.equal(this.valueStrength, that.valueStrength) || !Objects.equal(this.recordStats, that.recordStats) || !Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(that.writeExpirationDuration, that.writeExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(that.accessExpirationDuration, that.accessExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(that.refreshDuration, that.refreshTimeUnit))) {
            return false;
        }
        return true;
    }

    @CheckForNull
    private static Long durationInNanos(long duration, @CheckForNull TimeUnit unit) {
        if (unit == null) {
            return null;
        }
        return Long.valueOf(unit.toNanos(duration));
    }

    static abstract class IntegerParser implements ValueParser {
        /* access modifiers changed from: protected */
        public abstract void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i);

        IntegerParser() {
        }

        public void parse(CacheBuilderSpec spec, String key, String value) {
            if (!Strings.isNullOrEmpty(value)) {
                try {
                    parseInteger(spec, Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", key, value), e);
                }
            } else {
                throw new IllegalArgumentException("value of key " + key + " omitted");
            }
        }
    }

    static abstract class LongParser implements ValueParser {
        /* access modifiers changed from: protected */
        public abstract void parseLong(CacheBuilderSpec cacheBuilderSpec, long j);

        LongParser() {
        }

        public void parse(CacheBuilderSpec spec, String key, String value) {
            if (!Strings.isNullOrEmpty(value)) {
                try {
                    parseLong(spec, Long.parseLong(value));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", key, value), e);
                }
            } else {
                throw new IllegalArgumentException("value of key " + key + " omitted");
            }
        }
    }

    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        /* access modifiers changed from: protected */
        public void parseInteger(CacheBuilderSpec spec, int value) {
            Preconditions.checkArgument(spec.initialCapacity == null, "initial capacity was already set to %s", (Object) spec.initialCapacity);
            spec.initialCapacity = Integer.valueOf(value);
        }
    }

    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        /* access modifiers changed from: protected */
        public void parseLong(CacheBuilderSpec spec, long value) {
            boolean z = true;
            Preconditions.checkArgument(spec.maximumSize == null, "maximum size was already set to %s", (Object) spec.maximumSize);
            if (spec.maximumWeight != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum weight was already set to %s", (Object) spec.maximumWeight);
            spec.maximumSize = Long.valueOf(value);
        }
    }

    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        /* access modifiers changed from: protected */
        public void parseLong(CacheBuilderSpec spec, long value) {
            boolean z = true;
            Preconditions.checkArgument(spec.maximumWeight == null, "maximum weight was already set to %s", (Object) spec.maximumWeight);
            if (spec.maximumSize != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum size was already set to %s", (Object) spec.maximumSize);
            spec.maximumWeight = Long.valueOf(value);
        }
    }

    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        /* access modifiers changed from: protected */
        public void parseInteger(CacheBuilderSpec spec, int value) {
            Preconditions.checkArgument(spec.concurrencyLevel == null, "concurrency level was already set to %s", (Object) spec.concurrencyLevel);
            spec.concurrencyLevel = Integer.valueOf(value);
        }
    }

    static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength strength2) {
            this.strength = strength2;
        }

        public void parse(CacheBuilderSpec spec, String key, @CheckForNull String value) {
            boolean z = true;
            Preconditions.checkArgument(value == null, "key %s does not take values", (Object) key);
            if (spec.keyStrength != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "%s was already set to %s", (Object) key, (Object) spec.keyStrength);
            spec.keyStrength = this.strength;
        }
    }

    static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength strength2) {
            this.strength = strength2;
        }

        public void parse(CacheBuilderSpec spec, String key, @CheckForNull String value) {
            boolean z = true;
            Preconditions.checkArgument(value == null, "key %s does not take values", (Object) key);
            if (spec.valueStrength != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "%s was already set to %s", (Object) key, (Object) spec.valueStrength);
            spec.valueStrength = this.strength;
        }
    }

    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        public void parse(CacheBuilderSpec spec, String key, @CheckForNull String value) {
            boolean z = false;
            Preconditions.checkArgument(value == null, "recordStats does not take values");
            if (spec.recordStats == null) {
                z = true;
            }
            Preconditions.checkArgument(z, "recordStats already set");
            spec.recordStats = true;
        }
    }

    static abstract class DurationParser implements ValueParser {
        /* access modifiers changed from: protected */
        public abstract void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);

        DurationParser() {
        }

        public void parse(CacheBuilderSpec spec, String key, @CheckForNull String value) {
            TimeUnit timeUnit;
            if (!Strings.isNullOrEmpty(value)) {
                try {
                    switch (value.charAt(value.length() - 1)) {
                        case 'd':
                            timeUnit = TimeUnit.DAYS;
                            break;
                        case LocationRequestCompat.QUALITY_LOW_POWER:
                            timeUnit = TimeUnit.HOURS;
                            break;
                        case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /*109*/:
                            timeUnit = TimeUnit.MINUTES;
                            break;
                        case 's':
                            timeUnit = TimeUnit.SECONDS;
                            break;
                        default:
                            throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid unit: was %s, must end with one of [dhms]", key, value));
                    }
                    parseDuration(spec, Long.parseLong(value.substring(0, value.length() - 1)), timeUnit);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", key, value));
                }
            } else {
                throw new IllegalArgumentException("value of key " + key + " omitted");
            }
        }
    }

    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void parseDuration(CacheBuilderSpec spec, long duration, TimeUnit unit) {
            Preconditions.checkArgument(spec.accessExpirationTimeUnit == null, "expireAfterAccess already set");
            spec.accessExpirationDuration = duration;
            spec.accessExpirationTimeUnit = unit;
        }
    }

    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void parseDuration(CacheBuilderSpec spec, long duration, TimeUnit unit) {
            Preconditions.checkArgument(spec.writeExpirationTimeUnit == null, "expireAfterWrite already set");
            spec.writeExpirationDuration = duration;
            spec.writeExpirationTimeUnit = unit;
        }
    }

    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void parseDuration(CacheBuilderSpec spec, long duration, TimeUnit unit) {
            Preconditions.checkArgument(spec.refreshTimeUnit == null, "refreshAfterWrite already set");
            spec.refreshDuration = duration;
            spec.refreshTimeUnit = unit;
        }
    }

    /* access modifiers changed from: private */
    public static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
