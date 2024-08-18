package com.google.common.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@ElementTypesAreNonnullByDefault
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowConcurrentEvents {
}
