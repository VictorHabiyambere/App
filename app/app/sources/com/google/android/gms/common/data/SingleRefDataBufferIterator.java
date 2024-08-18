package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private Object zac;

    public SingleRefDataBufferIterator(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    public final Object next() {
        if (hasNext()) {
            int i = this.zab + 1;
            this.zab = i;
            if (i == 0) {
                this.zac = Preconditions.checkNotNull(this.zaa.get(0));
                Object obj = this.zac;
                if (!(obj instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(obj.getClass());
                    throw new IllegalStateException("DataBuffer reference of type " + valueOf + " is not movable");
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
            }
            return this.zac;
        }
        int i2 = this.zab;
        throw new NoSuchElementException("Cannot advance the iterator beyond " + i2);
    }
}
