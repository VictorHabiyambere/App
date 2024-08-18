package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = create();

    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    /* access modifiers changed from: private */
    public static void assertInstantiable(Class<?> c) {
        String exceptionMessage = ConstructorConstructor.checkInstantiable(c);
        if (exceptionMessage != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + exceptionMessage);
        }
    }

    private static UnsafeAllocator create() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            final Object unsafe = f.get((Object) null);
            final Method allocateInstance = unsafeClass.getMethod("allocateInstance", new Class[]{Class.class});
            return new UnsafeAllocator() {
                public <T> T newInstance(Class<T> c) throws Exception {
                    UnsafeAllocator.assertInstantiable(c);
                    return allocateInstance.invoke(unsafe, new Object[]{c});
                }
            };
        } catch (Exception e) {
            try {
                Method getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                getConstructorId.setAccessible(true);
                final int constructorId = ((Integer) getConstructorId.invoke((Object) null, new Object[]{Object.class})).intValue();
                final Method newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                newInstance.setAccessible(true);
                return new UnsafeAllocator() {
                    public <T> T newInstance(Class<T> c) throws Exception {
                        UnsafeAllocator.assertInstantiable(c);
                        return newInstance.invoke((Object) null, new Object[]{c, Integer.valueOf(constructorId)});
                    }
                };
            } catch (Exception e2) {
                try {
                    final Method newInstance2 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    newInstance2.setAccessible(true);
                    return new UnsafeAllocator() {
                        public <T> T newInstance(Class<T> c) throws Exception {
                            UnsafeAllocator.assertInstantiable(c);
                            return newInstance2.invoke((Object) null, new Object[]{c, Object.class});
                        }
                    };
                } catch (Exception e3) {
                    return new UnsafeAllocator() {
                        public <T> T newInstance(Class<T> c) {
                            throw new UnsupportedOperationException("Cannot allocate " + c + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
                        }
                    };
                }
            }
        }
    }
}
