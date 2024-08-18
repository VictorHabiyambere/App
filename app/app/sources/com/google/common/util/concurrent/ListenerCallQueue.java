package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(L l);
    }

    ListenerCallQueue() {
    }

    public void addListener(L listener, Executor executor) {
        Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(listener, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String label) {
        enqueueHelper(event, label);
    }

    private void enqueueHelper(Event<L> event, Object label) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(label, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> queue : this.listeners) {
                queue.add(event, label);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        PerListenerQueue(L listener2, Executor executor2) {
            this.listener = Preconditions.checkNotNull(listener2);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(Event<L> event, Object label) {
            this.waitQueue.add(event);
            this.labelQueue.add(label);
        }

        /* access modifiers changed from: package-private */
        public void dispatch() {
            boolean scheduleEventRunner = false;
            synchronized (this) {
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                    scheduleEventRunner = true;
                }
            }
            if (scheduleEventRunner) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r9.isThreadScheduled = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r2.call(r9.listener);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
            if (0 == 0) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                r0 = 1
            L_0x0001:
                r1 = 0
                monitor-enter(r9)     // Catch:{ all -> 0x005b }
                boolean r2 = r9.isThreadScheduled     // Catch:{ all -> 0x0058 }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x0058 }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.waitQueue     // Catch:{ all -> 0x0058 }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0058 }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x0058 }
                java.util.Queue<java.lang.Object> r3 = r9.labelQueue     // Catch:{ all -> 0x0058 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0058 }
                if (r2 != 0) goto L_0x0027
                r9.isThreadScheduled = r1     // Catch:{ all -> 0x0058 }
                r0 = 0
                monitor-exit(r9)     // Catch:{ all -> 0x0058 }
                if (r0 == 0) goto L_0x0026
                monitor-enter(r9)
                r9.isThreadScheduled = r1     // Catch:{ all -> 0x0023 }
                monitor-exit(r9)     // Catch:{ all -> 0x0023 }
                goto L_0x0026
            L_0x0023:
                r1 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0023 }
                throw r1
            L_0x0026:
                return
            L_0x0027:
                monitor-exit(r9)     // Catch:{ all -> 0x0058 }
                L r4 = r9.listener     // Catch:{ RuntimeException -> 0x002e }
                r2.call(r4)     // Catch:{ RuntimeException -> 0x002e }
                goto L_0x0057
            L_0x002e:
                r4 = move-exception
                java.util.logging.Logger r5 = com.google.common.util.concurrent.ListenerCallQueue.logger     // Catch:{ all -> 0x005b }
                java.util.logging.Level r6 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x005b }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
                r7.<init>()     // Catch:{ all -> 0x005b }
                java.lang.String r8 = "Exception while executing callback: "
                java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x005b }
                L r8 = r9.listener     // Catch:{ all -> 0x005b }
                java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x005b }
                java.lang.String r8 = " "
                java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x005b }
                java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ all -> 0x005b }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x005b }
                r5.log(r6, r7, r4)     // Catch:{ all -> 0x005b }
            L_0x0057:
                goto L_0x0001
            L_0x0058:
                r2 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0058 }
                throw r2     // Catch:{ all -> 0x005b }
            L_0x005b:
                r2 = move-exception
                if (r0 == 0) goto L_0x0066
                monitor-enter(r9)
                r9.isThreadScheduled = r1     // Catch:{ all -> 0x0063 }
                monitor-exit(r9)     // Catch:{ all -> 0x0063 }
                goto L_0x0066
            L_0x0063:
                r1 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0063 }
                throw r1
            L_0x0066:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}
