package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
enum DirectExecutor implements Executor {
    INSTANCE;

    public void execute(Runnable command) {
        command.run();
    }

    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
