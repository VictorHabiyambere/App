package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> head;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> keyToKeyList;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> tail;

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @ParametricNullness
        final K key;
        @CheckForNull
        Node<K, V> next;
        @CheckForNull
        Node<K, V> nextSibling;
        @CheckForNull
        Node<K, V> previous;
        @CheckForNull
        Node<K, V> previousSibling;
        @ParametricNullness
        V value;

        Node(@ParametricNullness K key2, @ParametricNullness V value2) {
            this.key = key2;
            this.value = value2;
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @ParametricNullness
        public V getValue() {
            return this.value;
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V newValue) {
            V result = this.value;
            this.value = newValue;
            return result;
        }
    }

    private static class KeyList<K, V> {
        int count = 1;
        Node<K, V> head;
        Node<K, V> tail;

        KeyList(Node<K, V> firstNode) {
            this.head = firstNode;
            this.tail = firstNode;
            firstNode.previousSibling = null;
            firstNode.nextSibling = null;
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int expectedKeys) {
        return new LinkedListMultimap<>(expectedKeys);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int expectedKeys) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(expectedKeys);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* access modifiers changed from: private */
    public Node<K, V> addNode(@ParametricNullness K key, @ParametricNullness V value, @CheckForNull Node<K, V> nextSibling) {
        Node<K, V> node = new Node<>(key, value);
        if (this.head == null) {
            this.tail = node;
            this.head = node;
            this.keyToKeyList.put(key, new KeyList(node));
            this.modCount++;
        } else if (nextSibling == null) {
            ((Node) Objects.requireNonNull(this.tail)).next = node;
            node.previous = this.tail;
            this.tail = node;
            KeyList<K, V> keyList = this.keyToKeyList.get(key);
            if (keyList == null) {
                Map<K, KeyList<K, V>> map = this.keyToKeyList;
                KeyList keyList2 = new KeyList(node);
                KeyList keyList3 = keyList2;
                map.put(key, keyList2);
                this.modCount++;
            } else {
                keyList.count++;
                Node<K, V> keyTail = keyList.tail;
                keyTail.nextSibling = node;
                node.previousSibling = keyTail;
                keyList.tail = node;
            }
        } else {
            KeyList<K, V> keyList4 = (KeyList) Objects.requireNonNull(this.keyToKeyList.get(key));
            keyList4.count++;
            node.previous = nextSibling.previous;
            node.previousSibling = nextSibling.previousSibling;
            node.next = nextSibling;
            node.nextSibling = nextSibling;
            if (nextSibling.previousSibling == null) {
                keyList4.head = node;
            } else {
                nextSibling.previousSibling.nextSibling = node;
            }
            if (nextSibling.previous == null) {
                this.head = node;
            } else {
                nextSibling.previous.next = node;
            }
            nextSibling.previous = node;
            nextSibling.previousSibling = node;
        }
        this.size++;
        return node;
    }

    /* access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            ((KeyList) Objects.requireNonNull(this.keyToKeyList.remove(node.key))).count = 0;
            this.modCount++;
        } else {
            KeyList<K, V> keyList = (KeyList) Objects.requireNonNull(this.keyToKeyList.get(node.key));
            keyList.count--;
            if (node.previousSibling == null) {
                keyList.head = (Node) Objects.requireNonNull(node.nextSibling);
            } else {
                node.previousSibling.nextSibling = node.nextSibling;
            }
            if (node.nextSibling == null) {
                keyList.tail = (Node) Objects.requireNonNull(node.previousSibling);
            } else {
                node.nextSibling.previousSibling = node.previousSibling;
            }
        }
        this.size--;
    }

    /* access modifiers changed from: private */
    public void removeAllNodes(@ParametricNullness K key) {
        Iterators.clear(new ValueForKeyIterator(key));
    }

    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        @CheckForNull
        Node<K, V> current;
        int expectedModCount = LinkedListMultimap.this.modCount;
        @CheckForNull
        Node<K, V> next;
        int nextIndex;
        @CheckForNull
        Node<K, V> previous;

        NodeIterator(int index) {
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(index, size);
            if (index < size / 2) {
                this.next = LinkedListMultimap.this.head;
                while (true) {
                    int index2 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = index2;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (true) {
                    int index3 = index + 1;
                    if (index >= size) {
                        break;
                    }
                    previous();
                    index = index3;
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public Node<K, V> next() {
            checkForConcurrentModification();
            if (this.next != null) {
                Node<K, V> node = this.next;
                this.current = node;
                this.previous = node;
                this.next = this.next.next;
                this.nextIndex++;
                return this.current;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            Preconditions.checkState(this.current != null, "no calls to next() since the last call to remove()");
            if (this.current != this.next) {
                this.previous = this.current.previous;
                this.nextIndex--;
            } else {
                this.next = this.current.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            return this.previous != null;
        }

        public Node<K, V> previous() {
            checkForConcurrentModification();
            if (this.previous != null) {
                Node<K, V> node = this.previous;
                this.current = node;
                this.next = node;
                this.previous = this.previous.previous;
                this.nextIndex--;
                return this.current;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void setValue(@ParametricNullness V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }
    }

    private class DistinctKeyIterator implements Iterator<K> {
        @CheckForNull
        Node<K, V> current;
        int expectedModCount;
        @CheckForNull
        Node<K, V> next;
        final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        @ParametricNullness
        public K next() {
            checkForConcurrentModification();
            if (this.next != null) {
                this.current = this.next;
                this.seenKeys.add(this.current.key);
                do {
                    this.next = this.next.next;
                    if (this.next == null || this.seenKeys.add(this.next.key)) {
                    }
                    this.next = this.next.next;
                    break;
                } while (this.seenKeys.add(this.next.key));
                return this.current.key;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            Preconditions.checkState(this.current != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    private class ValueForKeyIterator implements ListIterator<V> {
        @CheckForNull
        Node<K, V> current;
        @ParametricNullness
        final K key;
        @CheckForNull
        Node<K, V> next;
        int nextIndex;
        @CheckForNull
        Node<K, V> previous;

        ValueForKeyIterator(@ParametricNullness K key2) {
            this.key = key2;
            KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key2);
            this.next = keyList == null ? null : keyList.head;
        }

        public ValueForKeyIterator(@ParametricNullness K key2, int index) {
            KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key2);
            int size = keyList == null ? 0 : keyList.count;
            Preconditions.checkPositionIndex(index, size);
            if (index < size / 2) {
                this.next = keyList == null ? null : keyList.head;
                while (true) {
                    int index2 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = index2;
                }
            } else {
                this.previous = keyList == null ? null : keyList.tail;
                this.nextIndex = size;
                while (true) {
                    int index3 = index + 1;
                    if (index >= size) {
                        break;
                    }
                    previous();
                    index = index3;
                }
            }
            this.key = key2;
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @ParametricNullness
        public V next() {
            if (this.next != null) {
                Node<K, V> node = this.next;
                this.current = node;
                this.previous = node;
                this.next = this.next.nextSibling;
                this.nextIndex++;
                return this.current.value;
            }
            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        @ParametricNullness
        public V previous() {
            if (this.previous != null) {
                Node<K, V> node = this.previous;
                this.current = node;
                this.next = node;
                this.previous = this.previous.previousSibling;
                this.nextIndex--;
                return this.current.value;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            Preconditions.checkState(this.current != null, "no calls to next() since the last call to remove()");
            if (this.current != this.next) {
                this.previous = this.current.previousSibling;
                this.nextIndex--;
            } else {
                this.next = this.current.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        public void set(@ParametricNullness V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }

        public void add(@ParametricNullness V value) {
            this.previous = LinkedListMultimap.this.addNode(this.key, value, this.next);
            this.nextIndex++;
            this.current = null;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean containsKey(@CheckForNull Object key) {
        return this.keyToKeyList.containsKey(key);
    }

    public boolean containsValue(@CheckForNull Object value) {
        return values().contains(value);
    }

    public boolean put(@ParametricNullness K key, @ParametricNullness V value) {
        addNode(key, value, (Node) null);
        return true;
    }

    public List<V> replaceValues(@ParametricNullness K key, Iterable<? extends V> values) {
        List<V> oldValues = getCopy(key);
        ListIterator<V> keyValues = new ValueForKeyIterator(key);
        Iterator<? extends V> newValues = values.iterator();
        while (keyValues.hasNext() && newValues.hasNext()) {
            keyValues.next();
            keyValues.set(newValues.next());
        }
        while (keyValues.hasNext()) {
            keyValues.next();
            keyValues.remove();
        }
        while (newValues.hasNext()) {
            keyValues.add(newValues.next());
        }
        return oldValues;
    }

    private List<V> getCopy(@ParametricNullness K key) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(key)));
    }

    public List<V> removeAll(@CheckForNull Object key) {
        Object obj = key;
        List<V> oldValues = getCopy(obj);
        removeAllNodes(obj);
        return oldValues;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    public List<V> get(@ParametricNullness final K key) {
        return new AbstractSequentialList<V>() {
            public int size() {
                KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key);
                if (keyList == null) {
                    return 0;
                }
                return keyList.count;
            }

            public ListIterator<V> listIterator(int index) {
                return new ValueForKeyIterator(key, index);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>() {
            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean contains(@CheckForNull Object key) {
                return LinkedListMultimap.this.containsKey(key);
            }

            public boolean remove(@CheckForNull Object o) {
                return !LinkedListMultimap.this.removeAll(o).isEmpty();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public List<V> values() {
        return (List) super.values();
    }

    /* access modifiers changed from: package-private */
    public List<V> createValues() {
        return new AbstractSequentialList<V>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<V> listIterator(int index) {
                final LinkedListMultimap<K, V>.NodeIterator nodeItr = new NodeIterator(index);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeItr) {
                    /* access modifiers changed from: package-private */
                    @ParametricNullness
                    public V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    public void set(@ParametricNullness V value) {
                        nodeItr.setValue(value);
                    }
                };
            }
        };
    }

    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    /* access modifiers changed from: package-private */
    public List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<Map.Entry<K, V>> listIterator(int index) {
                return new NodeIterator(index);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int size2 = stream.readInt();
        for (int i = 0; i < size2; i++) {
            put(stream.readObject(), stream.readObject());
        }
    }
}
