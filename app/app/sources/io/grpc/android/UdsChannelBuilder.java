package io.grpc.android;

import android.net.LocalSocketAddress;
import io.grpc.ChannelCredentials;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannelBuilder;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import javax.net.SocketFactory;

public final class UdsChannelBuilder {
    @Nullable
    private static final Class<? extends ManagedChannelBuilder> OKHTTP_CHANNEL_BUILDER_CLASS = findOkHttp();

    private static Class<? extends ManagedChannelBuilder> findOkHttp() {
        try {
            return Class.forName("io.grpc.okhttp.OkHttpChannelBuilder").asSubclass(ManagedChannelBuilder.class);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static ManagedChannelBuilder<?> forPath(String path, LocalSocketAddress.Namespace namespace) {
        if (OKHTTP_CHANNEL_BUILDER_CLASS != null) {
            try {
                ManagedChannelBuilder<?> builder = (ManagedChannelBuilder) OKHTTP_CHANNEL_BUILDER_CLASS.cast(OKHTTP_CHANNEL_BUILDER_CLASS.getMethod("forTarget", new Class[]{String.class, ChannelCredentials.class}).invoke((Object) null, new Object[]{"dns:///localhost", InsecureChannelCredentials.create()}));
                OKHTTP_CHANNEL_BUILDER_CLASS.getMethod("socketFactory", new Class[]{SocketFactory.class}).invoke(builder, new Object[]{new UdsSocketFactory(path, namespace)});
                return builder;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to create OkHttpChannelBuilder", e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Failed to create OkHttpChannelBuilder", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to create OkHttpChannelBuilder", e3);
            }
        } else {
            throw new UnsupportedOperationException("OkHttpChannelBuilder not found on the classpath");
        }
    }

    private UdsChannelBuilder() {
    }
}
