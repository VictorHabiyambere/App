package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<C> columnList;
    @CheckForNull
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<R> rowList;
    @CheckForNull
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        return new ArrayTable<>(rowKeys, columnKeys);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) table);
        }
        return new ArrayTable<>(table);
    }

    private ArrayTable(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        this.rowList = ImmutableList.copyOf(rowKeys);
        this.columnList = ImmutableList.copyOf(columnKeys);
        Preconditions.checkArgument(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        int size = this.rowList.size();
        int[] iArr = new int[2];
        iArr[1] = this.columnList.size();
        iArr[0] = size;
        this.array = (Object[][]) Array.newInstance(Object.class, iArr);
        eraseAll();
    }

    private ArrayTable(Table<R, C, ? extends V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> table) {
        this.rowList = table.rowList;
        this.columnList = table.columnList;
        this.rowKeyToIndex = table.rowKeyToIndex;
        this.columnKeyToIndex = table.columnKeyToIndex;
        int size = this.rowList.size();
        int[] iArr = new int[2];
        iArr[1] = this.columnList.size();
        iArr[0] = size;
        V[][] copy = (Object[][]) Array.newInstance(Object.class, iArr);
        this.array = copy;
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(table.array[i], 0, copy[i], 0, table.array[i].length);
        }
    }

    private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        /* access modifiers changed from: package-private */
        public abstract String getKeyRole();

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V getValue(int i);

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V setValue(int i, @ParametricNullness V v);

        private ArrayMap(ImmutableMap<K, Integer> keyIndex2) {
            this.keyIndex = keyIndex2;
        }

        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        /* access modifiers changed from: package-private */
        public K getKey(int index) {
            return this.keyIndex.keySet().asList().get(index);
        }

        public int size() {
            return this.keyIndex.size();
        }

        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> getEntry(final int index) {
            Preconditions.checkElementIndex(index, size());
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                    return ArrayMap.this.getKey(index);
                }

                @ParametricNullness
                public V getValue() {
                    return ArrayMap.this.getValue(index);
                }

                @ParametricNullness
                public V setValue(@ParametricNullness V value) {
                    return ArrayMap.this.setValue(index, value);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
                /* access modifiers changed from: protected */
                public Map.Entry<K, V> get(int index) {
                    return ArrayMap.this.getEntry(index);
                }
            };
        }

        public boolean containsKey(@CheckForNull Object key) {
            return this.keyIndex.containsKey(key);
        }

        @CheckForNull
        public V get(@CheckForNull Object key) {
            Integer index = this.keyIndex.get(key);
            if (index == null) {
                return null;
            }
            return getValue(index.intValue());
        }

        @CheckForNull
        public V put(K key, @ParametricNullness V value) {
            Integer index = this.keyIndex.get(key);
            if (index != null) {
                return setValue(index.intValue(), value);
            }
            throw new IllegalArgumentException(getKeyRole() + " " + key + " not in " + this.keyIndex.keySet());
        }

        @CheckForNull
        public V remove(@CheckForNull Object key) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @CheckForNull
    public V at(int rowIndex, int columnIndex) {
        Preconditions.checkElementIndex(rowIndex, this.rowList.size());
        Preconditions.checkElementIndex(columnIndex, this.columnList.size());
        return this.array[rowIndex][columnIndex];
    }

    @CheckForNull
    public V set(int rowIndex, int columnIndex, @CheckForNull V value) {
        Preconditions.checkElementIndex(rowIndex, this.rowList.size());
        Preconditions.checkElementIndex(columnIndex, this.columnList.size());
        V oldValue = this.array[rowIndex][columnIndex];
        this.array[rowIndex][columnIndex] = value;
        return oldValue;
    }

    public V[][] toArray(Class<V> valueClass) {
        V[][] copy = (Object[][]) Array.newInstance(valueClass, new int[]{this.rowList.size(), this.columnList.size()});
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(this.array[i], 0, copy[i], 0, this.array[i].length);
        }
        return copy;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] row : this.array) {
            Arrays.fill(row, (Object) null);
        }
    }

    public boolean contains(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return containsRow(rowKey) && containsColumn(columnKey);
    }

    public boolean containsColumn(@CheckForNull Object columnKey) {
        return this.columnKeyToIndex.containsKey(columnKey);
    }

    public boolean containsRow(@CheckForNull Object rowKey) {
        return this.rowKeyToIndex.containsKey(rowKey);
    }

    public boolean containsValue(@CheckForNull Object value) {
        for (V[] row : this.array) {
            for (V element : r0[r3]) {
                if (Objects.equal(value, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @CheckForNull
    public V get(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (rowIndex == null || columnIndex == null) {
            return null;
        }
        return at(rowIndex.intValue(), columnIndex.intValue());
    }

    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @CheckForNull
    public V put(R rowKey, C columnKey, @CheckForNull V value) {
        Preconditions.checkNotNull(rowKey);
        Preconditions.checkNotNull(columnKey);
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        boolean z = true;
        Preconditions.checkArgument(rowIndex != null, "Row %s not in %s", (Object) rowKey, (Object) this.rowList);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (columnIndex == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", (Object) columnKey, (Object) this.columnList);
        return set(rowIndex.intValue(), columnIndex.intValue(), value);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @CheckForNull
    @Deprecated
    public V remove(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public V erase(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (rowIndex == null || columnIndex == null) {
            return null;
        }
        return set(rowIndex.intValue(), columnIndex.intValue(), (Object) null);
    }

    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
            /* access modifiers changed from: protected */
            public Table.Cell<R, C, V> get(int index) {
                return ArrayTable.this.getCell(index);
            }
        };
    }

    /* access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(final int index) {
        return new Tables.AbstractCell<R, C, V>() {
            final int columnIndex = (index % ArrayTable.this.columnList.size());
            final int rowIndex = (index / ArrayTable.this.columnList.size());

            public R getRowKey() {
                return ArrayTable.this.rowList.get(this.rowIndex);
            }

            public C getColumnKey() {
                return ArrayTable.this.columnList.get(this.columnIndex);
            }

            @CheckForNull
            public V getValue() {
                return ArrayTable.this.at(this.rowIndex, this.columnIndex);
            }
        };
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public V getValue(int index) {
        return at(index / this.columnList.size(), index % this.columnList.size());
    }

    public Map<R, V> column(C columnKey) {
        Preconditions.checkNotNull(columnKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (columnIndex == null) {
            return Collections.emptyMap();
        }
        return new Column(columnIndex.intValue());
    }

    private class Column extends ArrayMap<R, V> {
        final int columnIndex;

        Column(int columnIndex2) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = columnIndex2;
        }

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V getValue(int index) {
            return ArrayTable.this.at(index, this.columnIndex);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V setValue(int index, @CheckForNull V newValue) {
            return ArrayTable.this.set(index, this.columnIndex, newValue);
        }
    }

    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap map = this.columnMap;
        if (map != null) {
            return map;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
        this.columnMap = columnMap2;
        return columnMap2;
    }

    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> getValue(int index) {
            return new Column(index);
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> setValue(int index, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public Map<C, V> row(R rowKey) {
        Preconditions.checkNotNull(rowKey);
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        if (rowIndex == null) {
            return Collections.emptyMap();
        }
        return new Row(rowIndex.intValue());
    }

    private class Row extends ArrayMap<C, V> {
        final int rowIndex;

        Row(int rowIndex2) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = rowIndex2;
        }

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V getValue(int index) {
            return ArrayTable.this.at(this.rowIndex, index);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V setValue(int index, @CheckForNull V newValue) {
            return ArrayTable.this.set(this.rowIndex, index, newValue);
        }
    }

    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap map = this.rowMap;
        if (map != null) {
            return map;
        }
        ArrayTable<R, C, V>.RowMap rowMap2 = new RowMap();
        this.rowMap = rowMap2;
        return rowMap2;
    }

    private class RowMap extends ArrayMap<R, Map<C, V>> {
        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> getValue(int index) {
            return new Row(index);
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> setValue(int index, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) {
            /* access modifiers changed from: protected */
            @CheckForNull
            public V get(int index) {
                return ArrayTable.this.getValue(index);
            }
        };
    }
}
