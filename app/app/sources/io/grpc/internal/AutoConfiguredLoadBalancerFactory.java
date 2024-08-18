package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class AutoConfiguredLoadBalancerFactory {
    /* access modifiers changed from: private */
    public final String defaultPolicy;
    /* access modifiers changed from: private */
    public final LoadBalancerRegistry registry;

    public AutoConfiguredLoadBalancerFactory(String defaultPolicy2) {
        this(LoadBalancerRegistry.getDefaultRegistry(), defaultPolicy2);
    }

    AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry registry2, String defaultPolicy2) {
        this.registry = (LoadBalancerRegistry) Preconditions.checkNotNull(registry2, "registry");
        this.defaultPolicy = (String) Preconditions.checkNotNull(defaultPolicy2, "defaultPolicy");
    }

    public AutoConfiguredLoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }

    private static final class NoopLoadBalancer extends LoadBalancer {
        private NoopLoadBalancer() {
        }

        @Deprecated
        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            return true;
        }

        public void handleNameResolutionError(Status error) {
        }

        public void shutdown() {
        }
    }

    public final class AutoConfiguredLoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;

        AutoConfiguredLoadBalancer(LoadBalancer.Helper helper2) {
            this.helper = helper2;
            this.delegateProvider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            if (this.delegateProvider != null) {
                this.delegate = this.delegateProvider.newLoadBalancer(helper2);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        /* access modifiers changed from: package-private */
        public boolean tryAcceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            ServiceConfigUtil.PolicySelection policySelection = (ServiceConfigUtil.PolicySelection) resolvedAddresses.getLoadBalancingPolicyConfig();
            if (policySelection == null) {
                try {
                    policySelection = new ServiceConfigUtil.PolicySelection(AutoConfiguredLoadBalancerFactory.this.getProviderOrThrow(AutoConfiguredLoadBalancerFactory.this.defaultPolicy, "using default policy"), (Object) null);
                } catch (PolicyException e) {
                    this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(Status.INTERNAL.withDescription(e.getMessage())));
                    this.delegate.shutdown();
                    this.delegateProvider = null;
                    this.delegate = new NoopLoadBalancer();
                    return true;
                }
            }
            if (this.delegateProvider == null || !policySelection.provider.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                this.delegate.shutdown();
                this.delegateProvider = policySelection.provider;
                LoadBalancer old = this.delegate;
                this.delegate = this.delegateProvider.newLoadBalancer(this.helper);
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", old.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
            }
            Object lbConfig = policySelection.config;
            if (lbConfig != null) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", policySelection.config);
            }
            return getDelegate().acceptResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(resolvedAddresses.getAddresses()).setAttributes(resolvedAddresses.getAttributes()).setLoadBalancingPolicyConfig(lbConfig).build());
        }

        /* access modifiers changed from: package-private */
        public void handleNameResolutionError(Status error) {
            getDelegate().handleNameResolutionError(error);
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
            getDelegate().handleSubchannelState(subchannel, stateInfo);
        }

        /* access modifiers changed from: package-private */
        public void requestConnection() {
            getDelegate().requestConnection();
        }

        /* access modifiers changed from: package-private */
        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }

        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        /* access modifiers changed from: package-private */
        public void setDelegate(LoadBalancer lb) {
            this.delegate = lb;
        }

        /* access modifiers changed from: package-private */
        public LoadBalancerProvider getDelegateProvider() {
            return this.delegateProvider;
        }
    }

    /* access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String policy, String choiceReason) throws PolicyException {
        LoadBalancerProvider provider = this.registry.getProvider(policy);
        if (provider != null) {
            return provider;
        }
        throw new PolicyException("Trying to load '" + policy + "' because " + choiceReason + ", but it's unavailable");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError parseLoadBalancerPolicy(Map<String, ?> serviceConfig) {
        List<ServiceConfigUtil.LbConfig> loadBalancerConfigs = null;
        if (serviceConfig != null) {
            try {
                loadBalancerConfigs = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(serviceConfig));
            } catch (RuntimeException e) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e));
            }
        }
        if (loadBalancerConfigs == null || loadBalancerConfigs.isEmpty()) {
            return null;
        }
        return ServiceConfigUtil.selectLbPolicyFromList(loadBalancerConfigs, this.registry);
    }

    static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String msg) {
            super(msg);
        }
    }

    private static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withNoResult();
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) EmptyPicker.class).toString();
        }
    }

    private static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        FailingPicker(Status failure2) {
            this.failure = failure2;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }
}
