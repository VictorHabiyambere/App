package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.Settings;

class OkHttpSettingsUtil {
    public static final int ENABLE_PUSH = 2;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_HEADER_LIST_SIZE = 6;

    OkHttpSettingsUtil() {
    }

    public static boolean isSet(Settings settings, int id) {
        return settings.isSet(id);
    }

    public static int get(Settings settings, int id) {
        return settings.get(id);
    }

    public static void set(Settings settings, int id, int value) {
        settings.set(id, 0, value);
    }
}
