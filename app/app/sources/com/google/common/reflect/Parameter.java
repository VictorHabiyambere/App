package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Parameter implements AnnotatedElement {
    private final Object annotatedType;
    private final ImmutableList<Annotation> annotations;
    private final Invokable<?, ?> declaration;
    private final int position;
    private final TypeToken<?> type;

    Parameter(Invokable<?, ?> declaration2, int position2, TypeToken<?> type2, Annotation[] annotations2, Object annotatedType2) {
        this.declaration = declaration2;
        this.position = position2;
        this.type = type2;
        this.annotations = ImmutableList.copyOf((E[]) annotations2);
        this.annotatedType = annotatedType2;
    }

    public TypeToken<?> getType() {
        return this.type;
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.declaration;
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return getAnnotation(annotationType) != null;
    }

    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        Preconditions.checkNotNull(annotationType);
        UnmodifiableIterator<Annotation> it = this.annotations.iterator();
        while (it.hasNext()) {
            Annotation annotation = it.next();
            if (annotationType.isInstance(annotation)) {
                return (Annotation) annotationType.cast(annotation);
            }
        }
        return null;
    }

    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
        return getDeclaredAnnotationsByType(annotationType);
    }

    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.annotations.toArray(new Annotation[0]);
    }

    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationType) {
        Preconditions.checkNotNull(annotationType);
        return (Annotation) FluentIterable.from(this.annotations).filter(annotationType).first().orNull();
    }

    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationType) {
        return (Annotation[]) FluentIterable.from(this.annotations).filter(annotationType).toArray(annotationType);
    }

    @Deprecated
    public AnnotatedType getAnnotatedType() {
        return (AnnotatedType) Objects.requireNonNull((AnnotatedType) this.annotatedType);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter that = (Parameter) obj;
        if (this.position != that.position || !this.declaration.equals(that.declaration)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return this.type + " arg" + this.position;
    }
}
