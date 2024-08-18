package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((Object) null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    @CheckForNull
    private final transient Object hashTable;
    private final transient int size;

    static <K, V> RegularImmutableMap<K, V> create(int n, Object[] alternatingKeysAndValues2) {
        return create(n, alternatingKeysAndValues2, (ImmutableMap.Builder) null);
    }

    static <K, V> RegularImmutableMap<K, V> create(int n, Object[] alternatingKeysAndValues2, ImmutableMap.Builder<K, V> builder) {
        Object hashTable2;
        if (n == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (n == 1) {
            CollectPreconditions.checkEntryNotNull(Objects.requireNonNull(alternatingKeysAndValues2[0]), Objects.requireNonNull(alternatingKeysAndValues2[1]));
            return new RegularImmutableMap<>((Object) null, alternatingKeysAndValues2, 1);
        }
        Preconditions.checkPositionIndex(n, alternatingKeysAndValues2.length >> 1);
        Object hashTablePlus = createHashTable(alternatingKeysAndValues2, n, ImmutableSet.chooseTableSize(n), 0);
        if (hashTablePlus instanceof Object[]) {
            Object[] hashTableAndSizeAndDuplicate = (Object[]) hashTablePlus;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) hashTableAndSizeAndDuplicate[2];
            if (builder != null) {
                builder.duplicateKey = duplicateKey;
                hashTable2 = hashTableAndSizeAndDuplicate[0];
                n = ((Integer) hashTableAndSizeAndDuplicate[1]).intValue();
                alternatingKeysAndValues2 = Arrays.copyOf(alternatingKeysAndValues2, n * 2);
            } else {
                throw duplicateKey.exception();
            }
        } else {
            hashTable2 = hashTablePlus;
        }
        return new RegularImmutableMap<>(hashTable2, alternatingKeysAndValues2, n);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object createHashTable(java.lang.Object[] r17, int r18, int r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r2) goto L_0x001a
            r2 = r17[r20]
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            r3 = r20 ^ 1
            r3 = r17[r3]
            java.lang.Object r3 = java.util.Objects.requireNonNull(r3)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r2, r3)
            r2 = 0
            return r2
        L_0x001a:
            int r3 = r1 + -1
            r4 = 0
            r5 = 128(0x80, float:1.794E-43)
            r7 = 3
            r8 = -1
            if (r1 > r5) goto L_0x009a
            byte[] r5 = new byte[r1]
            java.util.Arrays.fill(r5, r8)
            r8 = 0
            r10 = 0
        L_0x002a:
            if (r10 >= r0) goto L_0x0086
            int r11 = r10 * 2
            int r11 = r11 + r20
            int r12 = r8 * 2
            int r12 = r12 + r20
            r13 = r17[r11]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r14 = r11 ^ 1
            r14 = r17[r14]
            java.lang.Object r14 = java.util.Objects.requireNonNull(r14)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r13, r14)
            int r15 = r13.hashCode()
            int r15 = com.google.common.collect.Hashing.smear(r15)
        L_0x004d:
            r15 = r15 & r3
            byte r9 = r5[r15]
            r2 = 255(0xff, float:3.57E-43)
            r9 = r9 & r2
            if (r9 != r2) goto L_0x0064
            byte r2 = (byte) r12
            r5[r15] = r2
            if (r8 >= r10) goto L_0x0061
            r17[r12] = r13
            r2 = r12 ^ 1
            r17[r2] = r14
        L_0x0061:
            int r8 = r8 + 1
            goto L_0x007e
        L_0x0064:
            r2 = r17[r9]
            boolean r2 = r13.equals(r2)
            if (r2 == 0) goto L_0x0082
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r2 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r16 = r9 ^ 1
            r16 = r17[r16]
            java.lang.Object r6 = java.util.Objects.requireNonNull(r16)
            r2.<init>(r13, r14, r6)
            r4 = r9 ^ 1
            r17[r4] = r14
            r4 = r2
        L_0x007e:
            int r10 = r10 + 1
            r2 = 1
            goto L_0x002a
        L_0x0082:
            int r15 = r15 + 1
            r2 = 1
            goto L_0x004d
        L_0x0086:
            if (r8 != r0) goto L_0x008a
            r2 = r5
            goto L_0x0099
        L_0x008a:
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r6 = 0
            r2[r6] = r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r7 = 1
            r2[r7] = r6
            r6 = 2
            r2[r6] = r4
        L_0x0099:
            return r2
        L_0x009a:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r1 > r2) goto L_0x0116
            short[] r2 = new short[r1]
            java.util.Arrays.fill(r2, r8)
            r5 = 0
            r6 = 0
        L_0x00a6:
            if (r6 >= r0) goto L_0x0102
            int r8 = r6 * 2
            int r8 = r8 + r20
            int r9 = r5 * 2
            int r9 = r9 + r20
            r10 = r17[r8]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            r11 = r8 ^ 1
            r11 = r17[r11]
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r10, r11)
            int r12 = r10.hashCode()
            int r12 = com.google.common.collect.Hashing.smear(r12)
        L_0x00c9:
            r12 = r12 & r3
            short r13 = r2[r12]
            r14 = 65535(0xffff, float:9.1834E-41)
            r13 = r13 & r14
            if (r13 != r14) goto L_0x00e1
            short r14 = (short) r9
            r2[r12] = r14
            if (r5 >= r6) goto L_0x00de
            r17[r9] = r10
            r12 = r9 ^ 1
            r17[r12] = r11
        L_0x00de:
            int r5 = r5 + 1
            goto L_0x00fc
        L_0x00e1:
            r14 = r17[r13]
            boolean r14 = r10.equals(r14)
            if (r14 == 0) goto L_0x00ff
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r14 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r15 = r13 ^ 1
            r15 = r17[r15]
            java.lang.Object r15 = java.util.Objects.requireNonNull(r15)
            r14.<init>(r10, r11, r15)
            r4 = r14
            r14 = r13 ^ 1
            r17[r14] = r11
        L_0x00fc:
            int r6 = r6 + 1
            goto L_0x00a6
        L_0x00ff:
            int r12 = r12 + 1
            goto L_0x00c9
        L_0x0102:
            if (r5 != r0) goto L_0x0106
            r6 = r2
            goto L_0x0115
        L_0x0106:
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r7 = 0
            r6[r7] = r2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r4
        L_0x0115:
            return r6
        L_0x0116:
            int[] r2 = new int[r1]
            java.util.Arrays.fill(r2, r8)
            r5 = 0
            r6 = 0
        L_0x011d:
            if (r6 >= r0) goto L_0x0176
            int r9 = r6 * 2
            int r9 = r9 + r20
            int r10 = r5 * 2
            int r10 = r10 + r20
            r11 = r17[r9]
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            r12 = r9 ^ 1
            r12 = r17[r12]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r11, r12)
            int r13 = r11.hashCode()
            int r13 = com.google.common.collect.Hashing.smear(r13)
        L_0x0140:
            r13 = r13 & r3
            r14 = r2[r13]
            if (r14 != r8) goto L_0x0153
            r2[r13] = r10
            if (r5 >= r6) goto L_0x0150
            r17[r10] = r11
            r13 = r10 ^ 1
            r17[r13] = r12
        L_0x0150:
            int r5 = r5 + 1
            goto L_0x016e
        L_0x0153:
            r15 = r17[r14]
            boolean r15 = r11.equals(r15)
            if (r15 == 0) goto L_0x0172
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r15 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r16 = r14 ^ 1
            r16 = r17[r16]
            java.lang.Object r8 = java.util.Objects.requireNonNull(r16)
            r15.<init>(r11, r12, r8)
            r4 = r15
            r8 = r14 ^ 1
            r17[r8] = r12
        L_0x016e:
            int r6 = r6 + 1
            r8 = -1
            goto L_0x011d
        L_0x0172:
            int r13 = r13 + 1
            r8 = -1
            goto L_0x0140
        L_0x0176:
            if (r5 != r0) goto L_0x017a
            r6 = r2
            goto L_0x0189
        L_0x017a:
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r7 = 0
            r6[r7] = r2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r4
        L_0x0189:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):java.lang.Object");
    }

    @CheckForNull
    static Object createHashTableOrThrow(Object[] alternatingKeysAndValues2, int n, int tableSize, int keyOffset) {
        Object hashTablePlus = createHashTable(alternatingKeysAndValues2, n, tableSize, keyOffset);
        if (!(hashTablePlus instanceof Object[])) {
            return hashTablePlus;
        }
        throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) hashTablePlus)[2]).exception();
    }

    private RegularImmutableMap(@CheckForNull Object hashTable2, Object[] alternatingKeysAndValues2, int size2) {
        this.hashTable = hashTable2;
        this.alternatingKeysAndValues = alternatingKeysAndValues2;
        this.size = size2;
    }

    public int size() {
        return this.size;
    }

    @CheckForNull
    public V get(@CheckForNull Object key) {
        Object result = get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, key);
        if (result == null) {
            return null;
        }
        return result;
    }

    @CheckForNull
    static Object get(@CheckForNull Object hashTableObject, Object[] alternatingKeysAndValues2, int size2, int keyOffset, @CheckForNull Object key) {
        if (key == null) {
            return null;
        }
        if (size2 == 1) {
            if (Objects.requireNonNull(alternatingKeysAndValues2[keyOffset]).equals(key)) {
                return Objects.requireNonNull(alternatingKeysAndValues2[keyOffset ^ 1]);
            }
            return null;
        } else if (hashTableObject == null) {
            return null;
        } else {
            if (hashTableObject instanceof byte[]) {
                byte[] hashTable2 = (byte[]) hashTableObject;
                int mask = hashTable2.length - 1;
                int h = Hashing.smear(key.hashCode());
                while (true) {
                    int h2 = h & mask;
                    int keyIndex = hashTable2[h2] & 255;
                    if (keyIndex == 255) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues2[keyIndex])) {
                        return alternatingKeysAndValues2[keyIndex ^ 1];
                    }
                    h = h2 + 1;
                }
            } else if (hashTableObject instanceof short[]) {
                short[] hashTable3 = (short[]) hashTableObject;
                int mask2 = hashTable3.length - 1;
                int h3 = Hashing.smear(key.hashCode());
                while (true) {
                    int h4 = h3 & mask2;
                    int keyIndex2 = hashTable3[h4] & 65535;
                    if (keyIndex2 == 65535) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues2[keyIndex2])) {
                        return alternatingKeysAndValues2[keyIndex2 ^ 1];
                    }
                    h3 = h4 + 1;
                }
            } else {
                int[] hashTable4 = (int[]) hashTableObject;
                int mask3 = hashTable4.length - 1;
                int h5 = Hashing.smear(key.hashCode());
                while (true) {
                    int h6 = h5 & mask3;
                    int keyIndex3 = hashTable4[h6];
                    if (keyIndex3 == -1) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues2[keyIndex3])) {
                        return alternatingKeysAndValues2[keyIndex3 ^ 1];
                    }
                    h5 = h6 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient Object[] alternatingKeysAndValues;
        /* access modifiers changed from: private */
        public final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        /* access modifiers changed from: private */
        public final transient int size;

        EntrySet(ImmutableMap<K, V> map2, Object[] alternatingKeysAndValues2, int keyOffset2, int size2) {
            this.map = map2;
            this.alternatingKeysAndValues = alternatingKeysAndValues2;
            this.keyOffset = keyOffset2;
            this.size = size2;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public Map.Entry<K, V> get(int index) {
                    Preconditions.checkElementIndex(index, EntrySet.this.size);
                    return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[(index * 2) + EntrySet.this.keyOffset]), Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[(index * 2) + (EntrySet.this.keyOffset ^ 1)]));
                }

                public int size() {
                    return EntrySet.this.size;
                }

                public boolean isPartialView() {
                    return true;
                }
            };
        }

        public boolean contains(@CheckForNull Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) object;
            Object k = entry.getKey();
            Object v = entry.getValue();
            if (v == null || !v.equals(this.map.get(k))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] alternatingKeysAndValues2, int offset2, int size2) {
            this.alternatingKeysAndValues = alternatingKeysAndValues2;
            this.offset = offset2;
            this.size = size2;
        }

        public Object get(int index) {
            Preconditions.checkElementIndex(index, this.size);
            return Objects.requireNonNull(this.alternatingKeysAndValues[(index * 2) + this.offset]);
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> map2, ImmutableList<K> list2) {
            this.map = map2;
            this.list = list2;
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(@CheckForNull Object object) {
            return this.map.get(object) != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.map.size();
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }
}
