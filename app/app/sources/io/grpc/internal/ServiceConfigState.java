package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import javax.annotation.Nullable;

final class ServiceConfigState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @Nullable
    private NameResolver.ConfigOrError currentServiceConfigOrError;
    @Nullable
    private final NameResolver.ConfigOrError defaultServiceConfig;
    private final boolean lookUpServiceConfig;
    private boolean updated;

    ServiceConfigState(@Nullable ManagedChannelServiceConfig defaultServiceConfig2, boolean lookUpServiceConfig2) {
        if (defaultServiceConfig2 == null) {
            this.defaultServiceConfig = null;
        } else {
            this.defaultServiceConfig = NameResolver.ConfigOrError.fromConfig(defaultServiceConfig2);
        }
        this.lookUpServiceConfig = lookUpServiceConfig2;
        if (!lookUpServiceConfig2) {
            this.currentServiceConfigOrError = this.defaultServiceConfig;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldWaitOnServiceConfig() {
        return !this.updated && expectUpdates();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError getCurrent() {
        Preconditions.checkState(!shouldWaitOnServiceConfig(), "still waiting on service config");
        return this.currentServiceConfigOrError;
    }

    /* access modifiers changed from: package-private */
    public void update(@Nullable NameResolver.ConfigOrError coe) {
        Preconditions.checkState(expectUpdates(), "unexpected service config update");
        boolean firstUpdate = !this.updated;
        this.updated = true;
        if (firstUpdate) {
            if (coe == null) {
                this.currentServiceConfigOrError = this.defaultServiceConfig;
            } else if (coe.getError() != null) {
                if (this.defaultServiceConfig != null) {
                    this.currentServiceConfigOrError = this.defaultServiceConfig;
                } else {
                    this.currentServiceConfigOrError = coe;
                }
            } else if (coe.getConfig() != null) {
                this.currentServiceConfigOrError = coe;
            } else {
                throw new AssertionError();
            }
        } else if (coe == null) {
            if (this.defaultServiceConfig != null) {
                this.currentServiceConfigOrError = this.defaultServiceConfig;
            } else {
                this.currentServiceConfigOrError = null;
            }
        } else if (coe.getError() != null) {
            if (this.currentServiceConfigOrError != null && this.currentServiceConfigOrError.getError() != null) {
                this.currentServiceConfigOrError = coe;
            }
        } else if (coe.getConfig() != null) {
            this.currentServiceConfigOrError = coe;
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean expectUpdates() {
        return this.lookUpServiceConfig;
    }
}
