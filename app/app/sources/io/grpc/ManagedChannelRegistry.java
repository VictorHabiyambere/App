package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ManagedChannelProvider;
import io.grpc.ServiceProviders;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ManagedChannelRegistry {
    private static ManagedChannelRegistry instance;
    private static final Logger logger = Logger.getLogger(ManagedChannelRegistry.class.getName());
    private final LinkedHashSet<ManagedChannelProvider> allProviders = new LinkedHashSet<>();
    private List<ManagedChannelProvider> effectiveProviders = Collections.emptyList();

    public synchronized void register(ManagedChannelProvider provider) {
        addProvider(provider);
        refreshProviders();
    }

    private synchronized void addProvider(ManagedChannelProvider provider) {
        Preconditions.checkArgument(provider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(provider);
    }

    public synchronized void deregister(ManagedChannelProvider provider) {
        this.allProviders.remove(provider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        List<ManagedChannelProvider> providers = new ArrayList<>(this.allProviders);
        Collections.sort(providers, Collections.reverseOrder(new Comparator<ManagedChannelProvider>() {
            public int compare(ManagedChannelProvider o1, ManagedChannelProvider o2) {
                return o1.priority() - o2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(providers);
    }

    public static synchronized ManagedChannelRegistry getDefaultRegistry() {
        ManagedChannelRegistry managedChannelRegistry;
        synchronized (ManagedChannelRegistry.class) {
            if (instance == null) {
                List<ManagedChannelProvider> providerList = ServiceProviders.loadAll(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new ManagedChannelPriorityAccessor());
                instance = new ManagedChannelRegistry();
                for (ManagedChannelProvider provider : providerList) {
                    logger.fine("Service loader found " + provider);
                    instance.addProvider(provider);
                }
                instance.refreshProviders();
            }
            managedChannelRegistry = instance;
        }
        return managedChannelRegistry;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<ManagedChannelProvider> providers() {
        return this.effectiveProviders;
    }

    /* access modifiers changed from: package-private */
    public ManagedChannelProvider provider() {
        List<ManagedChannelProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    static List<Class<?>> getHardCodedClasses() {
        List<Class<?>> list = new ArrayList<>();
        try {
            list.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", e);
        }
        try {
            list.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", e2);
        }
        try {
            list.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", e3);
        }
        return Collections.unmodifiableList(list);
    }

    /* access modifiers changed from: package-private */
    public ManagedChannelBuilder<?> newChannelBuilder(String target, ChannelCredentials creds) {
        return newChannelBuilder(NameResolverRegistry.getDefaultRegistry(), target, creds);
    }

    /* access modifiers changed from: package-private */
    public ManagedChannelBuilder<?> newChannelBuilder(NameResolverRegistry nameResolverRegistry, String target, ChannelCredentials creds) {
        Collection<Class<? extends SocketAddress>> nameResolverSocketAddressTypes;
        NameResolverProvider nameResolverProvider = null;
        try {
            nameResolverProvider = nameResolverRegistry.providers().get(new URI(target).getScheme());
        } catch (URISyntaxException e) {
        }
        if (nameResolverProvider == null) {
            nameResolverProvider = nameResolverRegistry.providers().get(nameResolverRegistry.asFactory().getDefaultScheme());
        }
        if (nameResolverProvider != null) {
            nameResolverSocketAddressTypes = nameResolverProvider.getProducedSocketAddressTypes();
        } else {
            nameResolverSocketAddressTypes = Collections.emptySet();
        }
        if (!providers().isEmpty()) {
            StringBuilder error = new StringBuilder();
            for (ManagedChannelProvider provider : providers()) {
                if (!provider.getSupportedSocketAddressTypes().containsAll(nameResolverSocketAddressTypes)) {
                    error.append("; ");
                    error.append(provider.getClass().getName());
                    error.append(": does not support 1 or more of ");
                    error.append(Arrays.toString(nameResolverSocketAddressTypes.toArray()));
                } else {
                    ManagedChannelProvider.NewChannelBuilderResult result = provider.newChannelBuilder(target, creds);
                    if (result.getChannelBuilder() != null) {
                        return result.getChannelBuilder();
                    }
                    error.append("; ");
                    error.append(provider.getClass().getName());
                    error.append(": ");
                    error.append(result.getError());
                }
            }
            throw new ProviderNotFoundException(error.substring(2));
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    private static final class ManagedChannelPriorityAccessor implements ServiceProviders.PriorityAccessor<ManagedChannelProvider> {
        private ManagedChannelPriorityAccessor() {
        }

        public boolean isAvailable(ManagedChannelProvider provider) {
            return provider.isAvailable();
        }

        public int getPriority(ManagedChannelProvider provider) {
            return provider.priority();
        }
    }

    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String msg) {
            super(msg);
        }
    }
}
