package io.grpc.okhttp;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.okhttp.OkHttpServerTransport;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;

final class OkHttpServer implements InternalServer {
    private static final Logger log = Logger.getLogger(OkHttpServer.class.getName());
    private SocketAddress actualListenAddress;
    private final InternalChannelz channelz;
    private InternalInstrumented<InternalChannelz.SocketStats> listenInstrumented;
    private ServerListener listener;
    private final SocketAddress originalListenAddress;
    private ScheduledExecutorService scheduledExecutorService;
    private final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
    private ServerSocket serverSocket;
    private boolean shutdown;
    private final ServerSocketFactory socketFactory;
    private final OkHttpServerTransport.Config transportConfig;
    private Executor transportExecutor;
    private final ObjectPool<Executor> transportExecutorPool;

    public OkHttpServer(OkHttpServerBuilder builder, List<? extends ServerStreamTracer.Factory> streamTracerFactories, InternalChannelz channelz2) {
        this.originalListenAddress = (SocketAddress) Preconditions.checkNotNull(builder.listenAddress, "listenAddress");
        this.socketFactory = (ServerSocketFactory) Preconditions.checkNotNull(builder.socketFactory, "socketFactory");
        this.transportExecutorPool = (ObjectPool) Preconditions.checkNotNull(builder.transportExecutorPool, "transportExecutorPool");
        this.scheduledExecutorServicePool = (ObjectPool) Preconditions.checkNotNull(builder.scheduledExecutorServicePool, "scheduledExecutorServicePool");
        this.transportConfig = new OkHttpServerTransport.Config(builder, streamTracerFactories);
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(channelz2, "channelz");
    }

    public void start(ServerListener listener2) throws IOException {
        this.listener = (ServerListener) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ServerSocket serverSocket2 = this.socketFactory.createServerSocket();
        try {
            serverSocket2.bind(this.originalListenAddress);
            this.serverSocket = serverSocket2;
            this.actualListenAddress = serverSocket2.getLocalSocketAddress();
            this.listenInstrumented = new ListenSocket(serverSocket2);
            this.transportExecutor = this.transportExecutorPool.getObject();
            this.scheduledExecutorService = this.scheduledExecutorServicePool.getObject();
            this.channelz.addListenSocket(this.listenInstrumented);
            this.transportExecutor.execute(new OkHttpServer$$ExternalSyntheticLambda0(this));
        } catch (IOException t) {
            serverSocket2.close();
            throw t;
        }
    }

    /* access modifiers changed from: private */
    public void acceptConnections() {
        while (true) {
            try {
                OkHttpServerTransport transport = new OkHttpServerTransport(this.transportConfig, this.serverSocket.accept());
                transport.start(this.listener.transportCreated(transport));
            } catch (IOException ex) {
                if (this.shutdown) {
                    this.listener.serverShutdown();
                    return;
                }
                throw ex;
            } catch (Throwable t) {
                log.log(Level.SEVERE, "Accept loop failed", t);
                this.listener.serverShutdown();
                return;
            }
        }
    }

    public void shutdown() {
        if (!this.shutdown) {
            this.shutdown = true;
            if (this.serverSocket != null) {
                this.channelz.removeListenSocket(this.listenInstrumented);
                try {
                    this.serverSocket.close();
                } catch (IOException e) {
                    log.log(Level.WARNING, "Failed closing server socket", this.serverSocket);
                }
                this.transportExecutor = this.transportExecutorPool.returnObject(this.transportExecutor);
                this.scheduledExecutorService = this.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
            }
        }
    }

    public SocketAddress getListenSocketAddress() {
        return this.actualListenAddress;
    }

    public InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats() {
        return this.listenInstrumented;
    }

    public List<? extends SocketAddress> getListenSocketAddresses() {
        return Collections.singletonList(getListenSocketAddress());
    }

    public List<InternalInstrumented<InternalChannelz.SocketStats>> getListenSocketStatsList() {
        return Collections.singletonList(getListenSocketStats());
    }

    private static final class ListenSocket implements InternalInstrumented<InternalChannelz.SocketStats> {
        private final InternalLogId id;
        private final ServerSocket socket;

        public ListenSocket(ServerSocket socket2) {
            this.socket = socket2;
            this.id = InternalLogId.allocate(getClass(), String.valueOf(socket2.getLocalSocketAddress()));
        }

        public ListenableFuture<InternalChannelz.SocketStats> getStats() {
            return Futures.immediateFuture(new InternalChannelz.SocketStats((InternalChannelz.TransportStats) null, this.socket.getLocalSocketAddress(), (SocketAddress) null, new InternalChannelz.SocketOptions.Builder().build(), (InternalChannelz.Security) null));
        }

        public InternalLogId getLogId() {
            return this.id;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("logId", this.id.getId()).add("socket", (Object) this.socket).toString();
        }
    }
}
