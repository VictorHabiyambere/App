package io.grpc.util;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;

public class RoundRobinLoadBalancer extends LoadBalancer {
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    protected RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    private final Random random;
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();

    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        public abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);
    }

    public RoundRobinLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
        this.random = new Random();
    }

    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        if (resolvedAddresses.getAddresses().isEmpty()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes()));
            return false;
        }
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        Set<EquivalentAddressGroup> currentAddrs = this.subchannels.keySet();
        Map<EquivalentAddressGroup, EquivalentAddressGroup> latestAddrs = stripAttrs(servers);
        Set<EquivalentAddressGroup> removedAddrs = setsDifference(currentAddrs, latestAddrs.keySet());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> latestEntry : latestAddrs.entrySet()) {
            EquivalentAddressGroup strippedAddressGroup = latestEntry.getKey();
            EquivalentAddressGroup originalAddressGroup = latestEntry.getValue();
            LoadBalancer.Subchannel existingSubchannel = this.subchannels.get(strippedAddressGroup);
            if (existingSubchannel != null) {
                existingSubchannel.updateAddresses(Collections.singletonList(originalAddressGroup));
            } else {
                final LoadBalancer.Subchannel subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(originalAddressGroup).setAttributes(Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build()).build()), "subchannel");
                subchannel.start(new LoadBalancer.SubchannelStateListener() {
                    public void onSubchannelState(ConnectivityStateInfo state) {
                        RoundRobinLoadBalancer.this.processSubchannelState(subchannel, state);
                    }
                });
                this.subchannels.put(strippedAddressGroup, subchannel);
                subchannel.requestConnection();
            }
        }
        ArrayList<LoadBalancer.Subchannel> removedSubchannels = new ArrayList<>();
        for (EquivalentAddressGroup addressGroup : removedAddrs) {
            removedSubchannels.add(this.subchannels.remove(addressGroup));
        }
        updateBalancingState();
        Iterator<LoadBalancer.Subchannel> it = removedSubchannels.iterator();
        while (it.hasNext()) {
            shutdownSubchannel(it.next());
        }
        return true;
    }

    public void handleNameResolutionError(Status error) {
        if (this.currentState != ConnectivityState.READY) {
            updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(error));
        }
    }

    /* access modifiers changed from: private */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        if (this.subchannels.get(stripAttrs(subchannel.getAddresses())) == subchannel) {
            if (stateInfo.getState() == ConnectivityState.TRANSIENT_FAILURE || stateInfo.getState() == ConnectivityState.IDLE) {
                this.helper.refreshNameResolution();
            }
            if (stateInfo.getState() == ConnectivityState.IDLE) {
                subchannel.requestConnection();
            }
            Ref<ConnectivityStateInfo> subchannelStateRef = getSubchannelStateInfoRef(subchannel);
            if (!((ConnectivityStateInfo) subchannelStateRef.value).getState().equals(ConnectivityState.TRANSIENT_FAILURE) || (!stateInfo.getState().equals(ConnectivityState.CONNECTING) && !stateInfo.getState().equals(ConnectivityState.IDLE))) {
                subchannelStateRef.value = stateInfo;
                updateBalancingState();
            }
        }
    }

    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
    }

    public void shutdown() {
        for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
            shutdownSubchannel(subchannel);
        }
        this.subchannels.clear();
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> activeList = filterNonFailingSubchannels(getSubchannels());
        if (activeList.isEmpty()) {
            boolean isConnecting = false;
            Status aggStatus = EMPTY_OK;
            for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
                ConnectivityStateInfo stateInfo = (ConnectivityStateInfo) getSubchannelStateInfoRef(subchannel).value;
                if (stateInfo.getState() == ConnectivityState.CONNECTING || stateInfo.getState() == ConnectivityState.IDLE) {
                    isConnecting = true;
                }
                if (aggStatus == EMPTY_OK || !aggStatus.isOk()) {
                    aggStatus = stateInfo.getStatus();
                }
            }
            updateBalancingState(isConnecting ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(aggStatus));
            return;
        }
        updateBalancingState(ConnectivityState.READY, createReadyPicker(activeList));
    }

    private void updateBalancingState(ConnectivityState state, RoundRobinPicker picker) {
        if (state != this.currentState || !picker.isEquivalentTo(this.currentPicker)) {
            this.helper.updateBalancingState(state, picker);
            this.currentState = state;
            this.currentPicker = picker;
        }
    }

    /* access modifiers changed from: protected */
    public RoundRobinPicker createReadyPicker(List<LoadBalancer.Subchannel> activeList) {
        return new ReadyPicker(activeList, this.random.nextInt(activeList.size()));
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> subchannels2) {
        List<LoadBalancer.Subchannel> readySubchannels = new ArrayList<>(subchannels2.size());
        for (LoadBalancer.Subchannel subchannel : subchannels2) {
            if (isReady(subchannel)) {
                readySubchannels.add(subchannel);
            }
        }
        return readySubchannels;
    }

    private static Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> groupList) {
        Map<EquivalentAddressGroup, EquivalentAddressGroup> addrs = new HashMap<>(groupList.size() * 2);
        for (EquivalentAddressGroup group : groupList) {
            addrs.put(stripAttrs(group), group);
        }
        return addrs;
    }

    private static EquivalentAddressGroup stripAttrs(EquivalentAddressGroup eag) {
        return new EquivalentAddressGroup(eag.getAddresses());
    }

    /* access modifiers changed from: protected */
    public Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull((Ref) subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return ((ConnectivityStateInfo) getSubchannelStateInfoRef(subchannel).value).getState() == ConnectivityState.READY;
    }

    private static <T> Set<T> setsDifference(Set<T> a, Set<T> b) {
        Set<T> aCopy = new HashSet<>(a);
        aCopy.removeAll(b);
        return aCopy;
    }

    static class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, "index");
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        public ReadyPicker(List<LoadBalancer.Subchannel> list2, int startIndex) {
            Preconditions.checkArgument(!list2.isEmpty(), "empty list");
            this.list = list2;
            this.index = startIndex - 1;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) ReadyPicker.class).add("list", (Object) this.list).toString();
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            int i = indexUpdater.incrementAndGet(this);
            if (i >= size) {
                int oldi = i;
                i %= size;
                indexUpdater.compareAndSet(this, oldi, i);
            }
            return this.list.get(i);
        }

        /* access modifiers changed from: package-private */
        public List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [io.grpc.util.RoundRobinLoadBalancer$RoundRobinPicker] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof io.grpc.util.RoundRobinLoadBalancer.ReadyPicker
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = r5
                io.grpc.util.RoundRobinLoadBalancer$ReadyPicker r0 = (io.grpc.util.RoundRobinLoadBalancer.ReadyPicker) r0
                if (r0 == r4) goto L_0x0028
                java.util.List<io.grpc.LoadBalancer$Subchannel> r2 = r4.list
                int r2 = r2.size()
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r0.list
                int r3 = r3.size()
                if (r2 != r3) goto L_0x0029
                java.util.HashSet r2 = new java.util.HashSet
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r4.list
                r2.<init>(r3)
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r0.list
                boolean r2 = r2.containsAll(r3)
                if (r2 == 0) goto L_0x0029
            L_0x0028:
                r1 = 1
            L_0x0029:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.util.RoundRobinLoadBalancer.ReadyPicker.isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer$RoundRobinPicker):boolean");
        }
    }

    static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status2) {
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        public boolean isEquivalentTo(RoundRobinPicker picker) {
            return (picker instanceof EmptyPicker) && (Objects.equal(this.status, ((EmptyPicker) picker).status) || (this.status.isOk() && ((EmptyPicker) picker).status.isOk()));
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) EmptyPicker.class).add(NotificationCompat.CATEGORY_STATUS, (Object) this.status).toString();
        }
    }

    static final class Ref<T> {
        T value;

        Ref(T value2) {
            this.value = value2;
        }
    }
}
