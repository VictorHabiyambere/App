package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzccd extends ScheduledThreadPoolExecutor {
    zzccd(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
