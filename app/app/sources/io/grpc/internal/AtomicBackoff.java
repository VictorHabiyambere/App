package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AtomicBackoff {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(AtomicBackoff.class.getName());
    /* access modifiers changed from: private */
    public final String name;
    /* access modifiers changed from: private */
    public final AtomicLong value = new AtomicLong();

    public AtomicBackoff(String name2, long value2) {
        Preconditions.checkArgument(value2 > 0, "value must be positive");
        this.name = name2;
        this.value.set(value2);
    }

    public State getState() {
        return new State(this.value.get());
    }

    public final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long savedValue;

        static {
            Class<AtomicBackoff> cls = AtomicBackoff.class;
        }

        private State(long value) {
            this.savedValue = value;
        }

        public long get() {
            return this.savedValue;
        }

        public void backoff() {
            long newValue = Math.max(this.savedValue * 2, this.savedValue);
            boolean swapped = AtomicBackoff.this.value.compareAndSet(this.savedValue, newValue);
            if (AtomicBackoff.this.value.get() < newValue) {
                throw new AssertionError();
            } else if (swapped) {
                AtomicBackoff.log.log(Level.WARNING, "Increased {0} to {1}", new Object[]{AtomicBackoff.this.name, Long.valueOf(newValue)});
            }
        }
    }
}
