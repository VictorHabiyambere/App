package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    @CheckForNull
    public final Object invoke(Object proxy, Method method, @CheckForNull Object[] args) throws Throwable {
        if (args == null) {
            args = NO_ARGS;
        }
        if (args.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        boolean z = true;
        if (args.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object arg = args[0];
            if (arg == null) {
                return false;
            }
            if (proxy == arg) {
                return true;
            }
            if (!isProxyOfSameInterfaces(arg, proxy.getClass()) || !equals(Proxy.getInvocationHandler(arg))) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (args.length != 0 || !method.getName().equals("toString")) {
            return handleInvocation(proxy, method, args);
        } else {
            return toString();
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    private static boolean isProxyOfSameInterfaces(Object arg, Class<?> proxyClass) {
        return proxyClass.isInstance(arg) || (Proxy.isProxyClass(arg.getClass()) && Arrays.equals(arg.getClass().getInterfaces(), proxyClass.getInterfaces()));
    }
}
