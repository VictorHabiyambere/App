package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class ChannelTracer {
    static final Logger logger = Logger.getLogger(ChannelLogger.class.getName());
    private final long channelCreationTimeNanos;
    @Nullable
    private final Collection<InternalChannelz.ChannelTrace.Event> events;
    private int eventsLogged;
    private final Object lock = new Object();
    private final InternalLogId logId;

    static /* synthetic */ int access$008(ChannelTracer x0) {
        int i = x0.eventsLogged;
        x0.eventsLogged = i + 1;
        return i;
    }

    ChannelTracer(InternalLogId logId2, final int maxEvents, long channelCreationTimeNanos2, String description) {
        Preconditions.checkNotNull(description, "description");
        this.logId = (InternalLogId) Preconditions.checkNotNull(logId2, "logId");
        if (maxEvents > 0) {
            this.events = new ArrayDeque<InternalChannelz.ChannelTrace.Event>() {
                public boolean add(InternalChannelz.ChannelTrace.Event event) {
                    if (size() == maxEvents) {
                        removeFirst();
                    }
                    ChannelTracer.access$008(ChannelTracer.this);
                    return super.add(event);
                }
            };
        } else {
            this.events = null;
        }
        this.channelCreationTimeNanos = channelCreationTimeNanos2;
        reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(description + " created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(channelCreationTimeNanos2).build());
    }

    /* access modifiers changed from: package-private */
    public void reportEvent(InternalChannelz.ChannelTrace.Event event) {
        Level logLevel;
        switch (event.severity) {
            case CT_ERROR:
                logLevel = Level.FINE;
                break;
            case CT_WARNING:
                logLevel = Level.FINER;
                break;
            default:
                logLevel = Level.FINEST;
                break;
        }
        traceOnly(event);
        logOnly(this.logId, logLevel, event.description);
    }

    /* access modifiers changed from: package-private */
    public boolean isTraceEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.events != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void traceOnly(InternalChannelz.ChannelTrace.Event event) {
        synchronized (this.lock) {
            if (this.events != null) {
                this.events.add(event);
            }
        }
    }

    static void logOnly(InternalLogId logId2, Level logLevel, String msg) {
        if (logger.isLoggable(logLevel)) {
            LogRecord lr = new LogRecord(logLevel, "[" + logId2 + "] " + msg);
            lr.setLoggerName(logger.getName());
            lr.setSourceClassName(logger.getName());
            lr.setSourceMethodName("log");
            logger.log(lr);
        }
    }

    /* access modifiers changed from: package-private */
    public InternalLogId getLogId() {
        return this.logId;
    }

    /* access modifiers changed from: package-private */
    public void updateBuilder(InternalChannelz.ChannelStats.Builder builder) {
        synchronized (this.lock) {
            if (this.events != null) {
                int eventsLoggedSnapshot = this.eventsLogged;
                List<InternalChannelz.ChannelTrace.Event> eventsSnapshot = new ArrayList<>(this.events);
                builder.setChannelTrace(new InternalChannelz.ChannelTrace.Builder().setNumEventsLogged((long) eventsLoggedSnapshot).setCreationTimeNanos(this.channelCreationTimeNanos).setEvents(eventsSnapshot).build());
            }
        }
    }
}
