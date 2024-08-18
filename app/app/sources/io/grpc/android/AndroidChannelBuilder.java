package io.grpc.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.InternalManagedChannelProvider;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannelProvider;
import io.grpc.MethodDescriptor;
import io.grpc.internal.GrpcUtil;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class AndroidChannelBuilder extends ForwardingChannelBuilder<AndroidChannelBuilder> {
    private static final String LOG_TAG = "AndroidChannelBuilder";
    @Nullable
    private static final ManagedChannelProvider OKHTTP_CHANNEL_PROVIDER = findOkHttp();
    @Nullable
    private Context context;
    private final ManagedChannelBuilder<?> delegateBuilder;

    private static ManagedChannelProvider findOkHttp() {
        try {
            try {
                try {
                    ManagedChannelProvider provider = (ManagedChannelProvider) Class.forName("io.grpc.okhttp.OkHttpChannelProvider").asSubclass(ManagedChannelProvider.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (InternalManagedChannelProvider.isAvailable(provider)) {
                        return provider;
                    }
                    Log.w(LOG_TAG, "OkHttpChannelProvider.isAvailable() returned false");
                    return null;
                } catch (Exception e) {
                    Log.w(LOG_TAG, "Failed to construct OkHttpChannelProvider", e);
                    return null;
                }
            } catch (ClassCastException e2) {
                Log.w(LOG_TAG, "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider", e2);
                return null;
            }
        } catch (ClassNotFoundException e3) {
            Log.w(LOG_TAG, "Failed to find OkHttpChannelProvider", e3);
            return null;
        }
    }

    public static AndroidChannelBuilder forTarget(String target) {
        return new AndroidChannelBuilder(target);
    }

    public static AndroidChannelBuilder forAddress(String name, int port) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(name, port));
    }

    @Deprecated
    public static AndroidChannelBuilder fromBuilder(ManagedChannelBuilder<?> builder) {
        return usingBuilder(builder);
    }

    public static AndroidChannelBuilder usingBuilder(ManagedChannelBuilder<?> builder) {
        return new AndroidChannelBuilder(builder);
    }

    private AndroidChannelBuilder(String target) {
        if (OKHTTP_CHANNEL_PROVIDER != null) {
            this.delegateBuilder = InternalManagedChannelProvider.builderForTarget(OKHTTP_CHANNEL_PROVIDER, target);
            return;
        }
        throw new UnsupportedOperationException("Unable to load OkHttpChannelProvider");
    }

    private AndroidChannelBuilder(ManagedChannelBuilder<?> delegateBuilder2) {
        this.delegateBuilder = (ManagedChannelBuilder) Preconditions.checkNotNull(delegateBuilder2, "delegateBuilder");
    }

    public AndroidChannelBuilder context(Context context2) {
        this.context = context2;
        return this;
    }

    /* access modifiers changed from: protected */
    public ManagedChannelBuilder<?> delegate() {
        return this.delegateBuilder;
    }

    public ManagedChannel build() {
        return new AndroidChannel(this.delegateBuilder.build(), this.context);
    }

    static final class AndroidChannel extends ManagedChannel {
        /* access modifiers changed from: private */
        @Nullable
        public final ConnectivityManager connectivityManager;
        /* access modifiers changed from: private */
        @Nullable
        public final Context context;
        /* access modifiers changed from: private */
        public final ManagedChannel delegate;
        private final Object lock = new Object();
        private Runnable unregisterRunnable;

        AndroidChannel(ManagedChannel delegate2, @Nullable Context context2) {
            this.delegate = delegate2;
            this.context = context2;
            if (context2 != null) {
                this.connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                try {
                    configureNetworkMonitoring();
                } catch (SecurityException e) {
                    Log.w(AndroidChannelBuilder.LOG_TAG, "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e);
                }
            } else {
                this.connectivityManager = null;
            }
        }

        private void configureNetworkMonitoring() {
            if (this.connectivityManager != null) {
                final DefaultNetworkCallback defaultNetworkCallback = new DefaultNetworkCallback();
                this.connectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback);
                this.unregisterRunnable = new Runnable() {
                    public void run() {
                        AndroidChannel.this.connectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
                    }
                };
                return;
            }
            final NetworkReceiver networkReceiver = new NetworkReceiver();
            this.context.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.unregisterRunnable = new Runnable() {
                public void run() {
                    AndroidChannel.this.context.unregisterReceiver(networkReceiver);
                }
            };
        }

        private void unregisterNetworkListener() {
            synchronized (this.lock) {
                if (this.unregisterRunnable != null) {
                    this.unregisterRunnable.run();
                    this.unregisterRunnable = null;
                }
            }
        }

        public ManagedChannel shutdown() {
            unregisterNetworkListener();
            return this.delegate.shutdown();
        }

        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        public ManagedChannel shutdownNow() {
            unregisterNetworkListener();
            return this.delegate.shutdownNow();
        }

        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.delegate.awaitTermination(timeout, unit);
        }

        public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
            return this.delegate.newCall(methodDescriptor, callOptions);
        }

        public String authority() {
            return this.delegate.authority();
        }

        public ConnectivityState getState(boolean requestConnection) {
            return this.delegate.getState(requestConnection);
        }

        public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
            this.delegate.notifyWhenStateChanged(source, callback);
        }

        public void resetConnectBackoff() {
            this.delegate.resetConnectBackoff();
        }

        public void enterIdle() {
            this.delegate.enterIdle();
        }

        private class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
            private DefaultNetworkCallback() {
            }

            public void onAvailable(Network network) {
                AndroidChannel.this.delegate.enterIdle();
            }

            public void onBlockedStatusChanged(Network network, boolean blocked) {
                if (!blocked) {
                    AndroidChannel.this.delegate.enterIdle();
                }
            }
        }

        private class NetworkReceiver extends BroadcastReceiver {
            private boolean isConnected;

            private NetworkReceiver() {
                this.isConnected = false;
            }

            public void onReceive(Context context, Intent intent) {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean wasConnected = this.isConnected;
                this.isConnected = networkInfo != null && networkInfo.isConnected();
                if (this.isConnected && !wasConnected) {
                    AndroidChannel.this.delegate.enterIdle();
                }
            }
        }
    }
}
