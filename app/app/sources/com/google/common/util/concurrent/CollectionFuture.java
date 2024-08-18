package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    @CheckForNull
    private List<Present<V>> values;

    /* access modifiers changed from: package-private */
    public abstract C combine(List<Present<V>> list);

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed) {
        super(futures, allMustSucceed, true);
        List<Present<V>> values2;
        if (futures.isEmpty()) {
            values2 = Collections.emptyList();
        } else {
            values2 = Lists.newArrayListWithCapacity(futures.size());
        }
        for (int i = 0; i < futures.size(); i++) {
            values2.add((Object) null);
        }
        this.values = values2;
    }

    /* access modifiers changed from: package-private */
    public final void collectOneValue(int index, @ParametricNullness V returnValue) {
        List<Present<V>> localValues = this.values;
        if (localValues != null) {
            localValues.set(index, new Present(returnValue));
        }
    }

    /* access modifiers changed from: package-private */
    public final void handleAllCompleted() {
        List<Present<V>> localValues = this.values;
        if (localValues != null) {
            set(combine(localValues));
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseResources(AggregateFuture.ReleaseResourcesReason reason) {
        super.releaseResources(reason);
        this.values = null;
    }

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed) {
            super(futures, allMustSucceed);
            init();
        }

        public List<V> combine(List<Present<V>> values) {
            List<V> result = Lists.newArrayListWithCapacity(values.size());
            Iterator<Present<V>> it = values.iterator();
            while (it.hasNext()) {
                Present<V> element = it.next();
                result.add(element != null ? element.value : null);
            }
            return Collections.unmodifiableList(result);
        }
    }

    private static final class Present<V> {
        @ParametricNullness
        final V value;

        Present(@ParametricNullness V value2) {
            this.value = value2;
        }
    }
}
