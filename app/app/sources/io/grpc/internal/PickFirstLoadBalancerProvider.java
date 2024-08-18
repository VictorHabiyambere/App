package io.grpc.internal;

import com.google.common.base.Strings;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.PickFirstLoadBalancer;
import java.util.Map;

public final class PickFirstLoadBalancerProvider extends LoadBalancerProvider {
    private static final String CONFIG_FLAG_NAME = "GRPC_EXPERIMENTAL_PICKFIRST_LB_CONFIG";
    private static final String NO_CONFIG = "no service config";
    private static final String SHUFFLE_ADDRESS_LIST_KEY = "shuffleAddressList";
    static boolean enablePickFirstConfig = (!Strings.isNullOrEmpty(System.getenv(CONFIG_FLAG_NAME)));

    public boolean isAvailable() {
        return true;
    }

    public int getPriority() {
        return 5;
    }

    public String getPolicyName() {
        return GrpcUtil.DEFAULT_LB_POLICY;
    }

    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new PickFirstLoadBalancer(helper);
    }

    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> rawLoadBalancingPolicyConfig) {
        if (!enablePickFirstConfig) {
            return NameResolver.ConfigOrError.fromConfig(NO_CONFIG);
        }
        try {
            return NameResolver.ConfigOrError.fromConfig(new PickFirstLoadBalancer.PickFirstLoadBalancerConfig(JsonUtil.getBoolean(rawLoadBalancingPolicyConfig, SHUFFLE_ADDRESS_LIST_KEY)));
        } catch (RuntimeException e) {
            return NameResolver.ConfigOrError.fromError(Status.UNAVAILABLE.withCause(e).withDescription("Failed parsing configuration for " + getPolicyName()));
        }
    }
}
