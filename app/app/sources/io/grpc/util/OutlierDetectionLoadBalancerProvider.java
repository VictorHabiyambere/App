package io.grpc.util;

import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.JsonUtil;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import io.grpc.util.OutlierDetectionLoadBalancer;
import java.util.List;
import java.util.Map;

public final class OutlierDetectionLoadBalancerProvider extends LoadBalancerProvider {
    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new OutlierDetectionLoadBalancer(helper, TimeProvider.SYSTEM_TIME_PROVIDER);
    }

    public boolean isAvailable() {
        return true;
    }

    public int getPriority() {
        return 5;
    }

    public String getPolicyName() {
        return "outlier_detection_experimental";
    }

    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> rawConfig) {
        try {
            return parseLoadBalancingPolicyConfigInternal(rawConfig);
        } catch (RuntimeException e) {
            return NameResolver.ConfigOrError.fromError(Status.UNAVAILABLE.withCause(e).withDescription("Failed parsing configuration for " + getPolicyName()));
        }
    }

    private NameResolver.ConfigOrError parseLoadBalancingPolicyConfigInternal(Map<String, ?> rawConfig) {
        Map<String, ?> map = rawConfig;
        Long intervalNanos = JsonUtil.getStringAsDuration(map, "interval");
        Long baseEjectionTimeNanos = JsonUtil.getStringAsDuration(map, "baseEjectionTime");
        Long maxEjectionTimeNanos = JsonUtil.getStringAsDuration(map, "maxEjectionTime");
        Integer maxEjectionPercentage = JsonUtil.getNumberAsInteger(map, "maxEjectionPercentage");
        OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.Builder configBuilder = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.Builder();
        if (intervalNanos != null) {
            configBuilder.setIntervalNanos(intervalNanos);
        }
        if (baseEjectionTimeNanos != null) {
            configBuilder.setBaseEjectionTimeNanos(baseEjectionTimeNanos);
        }
        if (maxEjectionTimeNanos != null) {
            configBuilder.setMaxEjectionTimeNanos(maxEjectionTimeNanos);
        }
        if (maxEjectionPercentage != null) {
            configBuilder.setMaxEjectionPercent(maxEjectionPercentage);
        }
        Map<String, ?> rawSuccessRateEjection = JsonUtil.getObject(map, "successRateEjection");
        if (rawSuccessRateEjection != null) {
            OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.SuccessRateEjection.Builder successRateEjectionBuilder = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.SuccessRateEjection.Builder();
            Integer stdevFactor = JsonUtil.getNumberAsInteger(rawSuccessRateEjection, "stdevFactor");
            Integer enforcementPercentage = JsonUtil.getNumberAsInteger(rawSuccessRateEjection, "enforcementPercentage");
            Integer minimumHosts = JsonUtil.getNumberAsInteger(rawSuccessRateEjection, "minimumHosts");
            Integer requestVolume = JsonUtil.getNumberAsInteger(rawSuccessRateEjection, "requestVolume");
            if (stdevFactor != null) {
                successRateEjectionBuilder.setStdevFactor(stdevFactor);
            }
            if (enforcementPercentage != null) {
                successRateEjectionBuilder.setEnforcementPercentage(enforcementPercentage);
            }
            if (minimumHosts != null) {
                successRateEjectionBuilder.setMinimumHosts(minimumHosts);
            }
            if (requestVolume != null) {
                successRateEjectionBuilder.setRequestVolume(requestVolume);
            }
            configBuilder.setSuccessRateEjection(successRateEjectionBuilder.build());
        }
        Map<String, ?> rawFailurePercentageEjection = JsonUtil.getObject(map, "failurePercentageEjection");
        if (rawFailurePercentageEjection != null) {
            OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.FailurePercentageEjection.Builder failurePercentageEjectionBuilder = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.FailurePercentageEjection.Builder();
            Integer threshold = JsonUtil.getNumberAsInteger(rawFailurePercentageEjection, "threshold");
            Integer enforcementPercentage2 = JsonUtil.getNumberAsInteger(rawFailurePercentageEjection, "enforcementPercentage");
            Integer minimumHosts2 = JsonUtil.getNumberAsInteger(rawFailurePercentageEjection, "minimumHosts");
            Integer requestVolume2 = JsonUtil.getNumberAsInteger(rawFailurePercentageEjection, "requestVolume");
            if (threshold != null) {
                failurePercentageEjectionBuilder.setThreshold(threshold);
            }
            if (enforcementPercentage2 != null) {
                failurePercentageEjectionBuilder.setEnforcementPercentage(enforcementPercentage2);
            }
            if (minimumHosts2 != null) {
                failurePercentageEjectionBuilder.setMinimumHosts(minimumHosts2);
            }
            if (requestVolume2 != null) {
                failurePercentageEjectionBuilder.setRequestVolume(requestVolume2);
            }
            configBuilder.setFailurePercentageEjection(failurePercentageEjectionBuilder.build());
        }
        List<ServiceConfigUtil.LbConfig> childConfigCandidates = ServiceConfigUtil.unwrapLoadBalancingConfigList(JsonUtil.getListOfObjects(map, "childPolicy"));
        if (childConfigCandidates == null || childConfigCandidates.isEmpty()) {
            return NameResolver.ConfigOrError.fromError(Status.INTERNAL.withDescription("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        NameResolver.ConfigOrError selectedConfig = ServiceConfigUtil.selectLbPolicyFromList(childConfigCandidates, LoadBalancerRegistry.getDefaultRegistry());
        if (selectedConfig.getError() != null) {
            return selectedConfig;
        }
        configBuilder.setChildPolicy((ServiceConfigUtil.PolicySelection) selectedConfig.getConfig());
        return NameResolver.ConfigOrError.fromConfig(configBuilder.build());
    }
}
