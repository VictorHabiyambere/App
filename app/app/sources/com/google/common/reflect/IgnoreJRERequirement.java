package com.google.common.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@ElementTypesAreNonnullByDefault
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@interface IgnoreJRERequirement {
}
