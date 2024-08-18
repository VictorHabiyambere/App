package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FuturesGetChecked$$ExternalSyntheticLambda0 implements Function {
    public final Object apply(Object obj) {
        return Boolean.valueOf(Arrays.asList(((Constructor) obj).getParameterTypes()).contains(String.class));
    }
}
