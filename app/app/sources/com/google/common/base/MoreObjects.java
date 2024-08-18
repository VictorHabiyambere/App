package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class MoreObjects {
    public static <T> T firstNonNull(@CheckForNull T first, @CheckForNull T second) {
        if (first != null) {
            return first;
        }
        if (second != null) {
            return second;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object self) {
        return new ToStringHelper(self.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> clazz) {
        return new ToStringHelper(clazz.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String className) {
        return new ToStringHelper(className);
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitEmptyValues;
        private boolean omitNullValues;

        private ToStringHelper(String className2) {
            this.holderHead = new ValueHolder();
            this.holderTail = this.holderHead;
            this.omitNullValues = false;
            this.omitEmptyValues = false;
            this.className = (String) Preconditions.checkNotNull(className2);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String name, @CheckForNull Object value) {
            return addHolder(name, value);
        }

        public ToStringHelper add(String name, boolean value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, char value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, double value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, float value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, int value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, long value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper addValue(@CheckForNull Object value) {
            return addHolder(value);
        }

        public ToStringHelper addValue(boolean value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(char value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(double value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(float value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(int value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(long value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        private static boolean isEmpty(Object value) {
            if (value instanceof CharSequence) {
                if (((CharSequence) value).length() == 0) {
                    return true;
                }
                return false;
            } else if (value instanceof Collection) {
                return ((Collection) value).isEmpty();
            } else {
                if (value instanceof Map) {
                    return ((Map) value).isEmpty();
                }
                if (value instanceof Optional) {
                    return !((Optional) value).isPresent();
                }
                if (!value.getClass().isArray()) {
                    return false;
                }
                if (Array.getLength(value) == 0) {
                    return true;
                }
                return false;
            }
        }

        public String toString() {
            boolean omitNullValuesSnapshot = this.omitNullValues;
            boolean omitEmptyValuesSnapshot = this.omitEmptyValues;
            String nextSeparator = "";
            StringBuilder builder = new StringBuilder(32).append(this.className).append('{');
            ValueHolder valueHolder = this.holderHead.next;
            while (valueHolder != null) {
                Object value = valueHolder.value;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (value == null) {
                        if (omitNullValuesSnapshot) {
                            valueHolder = valueHolder.next;
                        }
                    } else if (omitEmptyValuesSnapshot && isEmpty(value)) {
                        valueHolder = valueHolder.next;
                    }
                }
                builder.append(nextSeparator);
                nextSeparator = ", ";
                if (valueHolder.name != null) {
                    builder.append(valueHolder.name).append('=');
                }
                if (value == null || !value.getClass().isArray()) {
                    builder.append(value);
                    valueHolder = valueHolder.next;
                } else {
                    String arrayString = Arrays.deepToString(new Object[]{value});
                    builder.append(arrayString, 1, arrayString.length() - 1);
                    valueHolder = valueHolder.next;
                }
            }
            return builder.append('}').toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(@CheckForNull Object value) {
            addHolder().value = value;
            return this;
        }

        private ToStringHelper addHolder(String name, @CheckForNull Object value) {
            ValueHolder valueHolder = addHolder();
            valueHolder.value = value;
            valueHolder.name = (String) Preconditions.checkNotNull(name);
            return this;
        }

        private UnconditionalValueHolder addUnconditionalHolder() {
            UnconditionalValueHolder valueHolder = new UnconditionalValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addUnconditionalHolder(Object value) {
            addUnconditionalHolder().value = value;
            return this;
        }

        private ToStringHelper addUnconditionalHolder(String name, Object value) {
            UnconditionalValueHolder valueHolder = addUnconditionalHolder();
            valueHolder.value = value;
            valueHolder.name = (String) Preconditions.checkNotNull(name);
            return this;
        }

        private static class ValueHolder {
            @CheckForNull
            String name;
            @CheckForNull
            ValueHolder next;
            @CheckForNull
            Object value;

            private ValueHolder() {
            }
        }

        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super();
            }
        }
    }

    private MoreObjects() {
    }
}
