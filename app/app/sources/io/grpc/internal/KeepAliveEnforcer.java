package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

public final class KeepAliveEnforcer {
    public static final long IMPLICIT_PERMIT_TIME_NANOS = TimeUnit.HOURS.toNanos(2);
    public static final int MAX_PING_STRIKES = 2;
    private final long epoch;
    private boolean hasOutstandingCalls;
    private long lastValidPingTime;
    private final long minTimeNanos;
    private final boolean permitWithoutCalls;
    private int pingStrikes;
    private final Ticker ticker;

    interface Ticker {
        long nanoTime();
    }

    public KeepAliveEnforcer(boolean permitWithoutCalls2, long minTime, TimeUnit unit) {
        this(permitWithoutCalls2, minTime, unit, SystemTicker.INSTANCE);
    }

    KeepAliveEnforcer(boolean permitWithoutCalls2, long minTime, TimeUnit unit, Ticker ticker2) {
        Preconditions.checkArgument(minTime >= 0, "minTime must be non-negative: %s", minTime);
        this.permitWithoutCalls = permitWithoutCalls2;
        this.minTimeNanos = Math.min(unit.toNanos(minTime), IMPLICIT_PERMIT_TIME_NANOS);
        this.ticker = ticker2;
        this.epoch = ticker2.nanoTime();
        this.lastValidPingTime = this.epoch;
    }

    @CheckReturnValue
    public boolean pingAcceptable() {
        boolean valid;
        long now = this.ticker.nanoTime();
        if (this.hasOutstandingCalls || this.permitWithoutCalls) {
            valid = compareNanos(this.lastValidPingTime + this.minTimeNanos, now) <= 0;
        } else {
            valid = compareNanos(this.lastValidPingTime + IMPLICIT_PERMIT_TIME_NANOS, now) <= 0;
        }
        if (!valid) {
            this.pingStrikes++;
            if (this.pingStrikes <= 2) {
                return true;
            }
            return false;
        }
        this.lastValidPingTime = now;
        return true;
    }

    public void resetCounters() {
        this.lastValidPingTime = this.epoch;
        this.pingStrikes = 0;
    }

    public void onTransportActive() {
        this.hasOutstandingCalls = true;
    }

    public void onTransportIdle() {
        this.hasOutstandingCalls = false;
    }

    private static long compareNanos(long time1, long time2) {
        return time1 - time2;
    }

    static class SystemTicker implements Ticker {
        public static final SystemTicker INSTANCE = new SystemTicker();

        SystemTicker() {
        }

        public long nanoTime() {
            return System.nanoTime();
        }
    }
}
