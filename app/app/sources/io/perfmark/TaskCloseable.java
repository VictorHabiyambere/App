package io.perfmark;

import java.io.Closeable;

public final class TaskCloseable implements Closeable {
    static final TaskCloseable INSTANCE = new TaskCloseable();

    public void close() {
        PerfMark.stopTask();
    }

    private TaskCloseable() {
    }
}
