package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    @CheckForNull
    public <T extends B> T getInstance(Class<T> type) {
        return trustedGet(TypeToken.of(type));
    }

    @CheckForNull
    public <T extends B> T getInstance(TypeToken<T> type) {
        return trustedGet(type.rejectTypeVariables());
    }

    @CheckForNull
    public <T extends B> T putInstance(Class<T> type, @ParametricNullness T value) {
        return trustedPut(TypeToken.of(type), value);
    }

    @CheckForNull
    public <T extends B> T putInstance(TypeToken<T> type, @ParametricNullness T value) {
        return trustedPut(type.rejectTypeVariables(), value);
    }

    @CheckForNull
    @Deprecated
    public B put(TypeToken<? extends B> typeToken, @ParametricNullness B b) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    /* access modifiers changed from: protected */
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @CheckForNull
    private <T extends B> T trustedPut(TypeToken<T> type, @ParametricNullness T value) {
        return this.backingMap.put(type, value);
    }

    @CheckForNull
    private <T extends B> T trustedGet(TypeToken<T> type) {
        return this.backingMap.get(type);
    }

    private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        /* renamed from: $r8$lambda$PXRRP_NYxQ7IKAyO13H8YX2p-q0  reason: not valid java name */
        public static /* synthetic */ UnmodifiableEntry m2044$r8$lambda$PXRRP_NYxQ7IKAyO13H8YX2pq0(Map.Entry entry) {
            return new UnmodifiableEntry(entry);
        }

        static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> entries) {
            return new ForwardingSet<Map.Entry<K, V>>() {
                /* access modifiers changed from: protected */
                public Set<Map.Entry<K, V>> delegate() {
                    return entries;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.transformEntries(super.iterator());
                }

                public Object[] toArray() {
                    return standardToArray();
                }

                public <T> T[] toArray(T[] array) {
                    return standardToArray(array);
                }
            };
        }

        /* access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> entries) {
            return Iterators.transform(entries, new MutableTypeToInstanceMap$UnmodifiableEntry$$ExternalSyntheticLambda0());
        }

        private UnmodifiableEntry(Map.Entry<K, V> delegate2) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(delegate2);
        }

        /* access modifiers changed from: protected */
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }
    }
}
