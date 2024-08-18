package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    @CheckForNull
    private transient TypeResolver covariantTypeResolver;
    @CheckForNull
    private transient TypeResolver invariantTypeResolver;
    /* access modifiers changed from: private */
    public final Type runtimeType;

    private enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> type) {
                return !(type.runtimeType instanceof TypeVariable) && !(type.runtimeType instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> type) {
                return type.getRawType().isInterface();
            }
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        Preconditions.checkState(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", (Object) this.runtimeType);
    }

    protected TypeToken(Class<?> declaringClass) {
        Type captured = super.capture();
        if (captured instanceof Class) {
            this.runtimeType = captured;
        } else {
            this.runtimeType = TypeResolver.covariantly(declaringClass).resolveType(captured);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.checkNotNull(type);
    }

    public static <T> TypeToken<T> of(Class<T> type) {
        return new SimpleTypeToken(type);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return (Class) getRawTypes().iterator().next();
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, TypeToken<X> typeArg) {
        return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.of(new TypeResolver.TypeVariableKey(typeParam.typeVariable), typeArg.runtimeType)).resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, Class<X> typeArg) {
        return where(typeParam, of(typeArg));
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return of(getInvariantTypeResolver().resolveType(type));
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> supertype = of(getCovariantTypeResolver().resolveType(type));
        supertype.covariantTypeResolver = this.covariantTypeResolver;
        supertype.invariantTypeResolver = this.invariantTypeResolver;
        return supertype;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type superclass = getRawType().getGenericSuperclass();
        if (superclass == null) {
            return null;
        }
        return resolveSupertype(superclass);
    }

    @CheckForNull
    private TypeToken<? super T> boundAsSuperclass(Type bound) {
        TypeToken<?> token = of(bound);
        if (token.getRawType().isInterface()) {
            return null;
        }
        return token;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) this.runtimeType).getUpperBounds());
        }
        ImmutableList.Builder<TypeToken<? super T>> builder = ImmutableList.builder();
        for (Type interfaceType : getRawType().getGenericInterfaces()) {
            builder.add((Object) resolveSupertype(interfaceType));
        }
        return builder.build();
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] bounds) {
        ImmutableList.Builder<TypeToken<? super T>> builder = ImmutableList.builder();
        for (Type bound : bounds) {
            TypeToken<?> of = of(bound);
            if (of.getRawType().isInterface()) {
                builder.add((Object) of);
            }
        }
        return builder.build();
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> superclass) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(superclass), "%s is not a super class of %s", (Object) superclass, (Object) this);
        if (this.runtimeType instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(superclass, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return getSupertypeFromUpperBounds(superclass, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (superclass.isArray()) {
            return getArraySupertype(superclass);
        }
        return resolveSupertype(toGenericType(superclass).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> subclass) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", (Object) this);
        if (this.runtimeType instanceof WildcardType) {
            return getSubtypeFromLowerBounds(subclass, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(subclass);
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(subclass), "%s isn't a subclass of %s", (Object) subclass, (Object) this);
        TypeToken<?> of = of(resolveTypeArgsForSubclass(subclass));
        Preconditions.checkArgument(of.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", (Object) of, (Object) this);
        return of;
    }

    public final boolean isSupertypeOf(TypeToken<?> type) {
        return type.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final boolean isSubtypeOf(TypeToken<?> type) {
        return isSubtypeOf(type.getType());
    }

    public final boolean isSubtypeOf(Type supertype) {
        Preconditions.checkNotNull(supertype);
        if (supertype instanceof WildcardType) {
            return any(((WildcardType) supertype).getLowerBounds()).isSupertypeOf(this.runtimeType);
        }
        if (this.runtimeType instanceof WildcardType) {
            return any(((WildcardType) this.runtimeType).getUpperBounds()).isSubtypeOf(supertype);
        }
        if (this.runtimeType instanceof TypeVariable) {
            if (this.runtimeType.equals(supertype) || any(((TypeVariable) this.runtimeType).getBounds()).isSubtypeOf(supertype)) {
                return true;
            }
            return false;
        } else if (this.runtimeType instanceof GenericArrayType) {
            return of(supertype).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        } else {
            if (supertype instanceof Class) {
                return someRawTypeIsSubclassOf((Class) supertype);
            }
            if (supertype instanceof ParameterizedType) {
                return isSubtypeOfParameterizedType((ParameterizedType) supertype);
            }
            if (supertype instanceof GenericArrayType) {
                return isSubtypeOfArrayType((GenericArrayType) supertype);
            }
            return false;
        }
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return (this.runtimeType instanceof Class) && ((Class) this.runtimeType).isPrimitive();
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive()) {
            return of(Primitives.wrap((Class) this.runtimeType));
        }
        return this;
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (isWrapper()) {
            return of(Primitives.unwrap((Class) this.runtimeType));
        }
        return this;
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type componentType = Types.getComponentType(this.runtimeType);
        if (componentType == null) {
            return null;
        }
        return of(componentType);
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", (Object) method, (Object) this);
        return new Invokable.MethodInvokable<T>(method) {
            /* access modifiers changed from: package-private */
            public Type getGenericReturnType() {
                return TypeToken.this.getCovariantTypeResolver().resolveType(super.getGenericReturnType());
            }

            /* access modifiers changed from: package-private */
            public Type[] getGenericParameterTypes() {
                return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(super.getGenericParameterTypes());
            }

            /* access modifiers changed from: package-private */
            public Type[] getGenericExceptionTypes() {
                return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(super.getGenericExceptionTypes());
            }

            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            public String toString() {
                return getOwnerType() + "." + super.toString();
            }
        };
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", (Object) constructor, (Object) getRawType());
        return new Invokable.ConstructorInvokable<T>(constructor) {
            /* access modifiers changed from: package-private */
            public Type getGenericReturnType() {
                return TypeToken.this.getCovariantTypeResolver().resolveType(super.getGenericReturnType());
            }

            /* access modifiers changed from: package-private */
            public Type[] getGenericParameterTypes() {
                return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(super.getGenericParameterTypes());
            }

            /* access modifiers changed from: package-private */
            public Type[] getGenericExceptionTypes() {
                return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(super.getGenericExceptionTypes());
            }

            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            public String toString() {
                return getOwnerType() + "(" + Joiner.on(", ").join((Object[]) getGenericParameterTypes()) + ")";
            }
        };
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet();
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> filteredTypes = this.types;
            if (filteredTypes != null) {
                return filteredTypes;
            }
            ImmutableSet<TypeToken<?>> set = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = set;
            return set;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes()));
        }
    }

    private final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        InterfaceSet(TypeToken<T>.TypeSet allTypes2) {
            super();
            this.allTypes = allTypes2;
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> result = this.interfaces;
            if (result != null) {
                return result;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = set;
            return set;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes())).filter(new TypeToken$InterfaceSet$$ExternalSyntheticLambda0()).toSet();
        }

        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> result = this.classes;
            if (result != null) {
                return result;
            }
            ImmutableSet<TypeToken<?>> set = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = set;
            return set;
        }

        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.this.getRawTypes()));
        }

        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    public boolean equals(@CheckForNull Object o) {
        if (o instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) o).runtimeType);
        }
        return false;
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return of(new TypeResolver().resolveType(this.runtimeType));
    }

    /* access modifiers changed from: package-private */
    public final TypeToken<T> rejectTypeVariables() {
        new TypeVisitor() {
            /* access modifiers changed from: package-private */
            public void visitTypeVariable(TypeVariable<?> typeVariable) {
                throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
            }

            /* access modifiers changed from: package-private */
            public void visitWildcardType(WildcardType type) {
                visit(type.getLowerBounds());
                visit(type.getUpperBounds());
            }

            /* access modifiers changed from: package-private */
            public void visitParameterizedType(ParameterizedType type) {
                visit(type.getActualTypeArguments());
                visit(type.getOwnerType());
            }

            /* access modifiers changed from: package-private */
            public void visitGenericArrayType(GenericArrayType type) {
                visit(type.getGenericComponentType());
            }
        }.visit(this.runtimeType);
        return this;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> superclass) {
        UnmodifiableIterator it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (superclass.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType supertype) {
        Class<? super Object> rawType = of((Type) supertype).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<?>[] typeVars = rawType.getTypeParameters();
        Type[] supertypeArgs = supertype.getActualTypeArguments();
        for (int i = 0; i < typeVars.length; i++) {
            if (!of(getCovariantTypeResolver().resolveType(typeVars[i])).is(supertypeArgs[i], typeVars[i])) {
                return false;
            }
        }
        if (Modifier.isStatic(((Class) supertype.getRawType()).getModifiers()) || supertype.getOwnerType() == null || isOwnedBySubtypeOf(supertype.getOwnerType())) {
            return true;
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType supertype) {
        if (this.runtimeType instanceof Class) {
            Class<?> fromClass = (Class) this.runtimeType;
            if (!fromClass.isArray()) {
                return false;
            }
            return of(fromClass.getComponentType()).isSubtypeOf(supertype.getGenericComponentType());
        } else if (this.runtimeType instanceof GenericArrayType) {
            return of(((GenericArrayType) this.runtimeType).getGenericComponentType()).isSubtypeOf(supertype.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isSupertypeOfArray(GenericArrayType subtype) {
        if (this.runtimeType instanceof Class) {
            Class<?> thisClass = (Class) this.runtimeType;
            if (!thisClass.isArray()) {
                return thisClass.isAssignableFrom(Object[].class);
            }
            return of(subtype.getGenericComponentType()).isSubtypeOf((Type) thisClass.getComponentType());
        } else if (this.runtimeType instanceof GenericArrayType) {
            return of(subtype.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean is(Type formalType, TypeVariable<?> declaration) {
        if (this.runtimeType.equals(formalType)) {
            return true;
        }
        if (!(formalType instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(formalType));
        }
        WildcardType your = canonicalizeWildcardType(declaration, (WildcardType) formalType);
        if (!every(your.getUpperBounds()).isSupertypeOf(this.runtimeType) || !every(your.getLowerBounds()).isSubtypeOf(this.runtimeType)) {
            return false;
        }
        return true;
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> declaration, Type typeArg) {
        if (typeArg instanceof WildcardType) {
            return canonicalizeWildcardType(declaration, (WildcardType) typeArg);
        }
        return canonicalizeWildcardsInType(typeArg);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return Types.newArrayType(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType()));
        }
        return type;
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> declaration, WildcardType type) {
        Type[] declared = declaration.getBounds();
        List<Type> upperBounds = new ArrayList<>();
        for (Type bound : type.getUpperBounds()) {
            if (!any(declared).isSubtypeOf(bound)) {
                upperBounds.add(canonicalizeWildcardsInType(bound));
            }
        }
        return new Types.WildcardTypeImpl(type.getLowerBounds(), (Type[]) upperBounds.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType type) {
        Class<?> rawType = (Class) type.getRawType();
        TypeVariable<?>[] typeVars = rawType.getTypeParameters();
        Type[] typeArgs = type.getActualTypeArguments();
        for (int i = 0; i < typeArgs.length; i++) {
            typeArgs[i] = canonicalizeTypeArg(typeVars[i], typeArgs[i]);
        }
        return Types.newParameterizedTypeWithOwner(type.getOwnerType(), rawType, typeArgs);
    }

    private static Bounds every(Type[] bounds) {
        return new Bounds(bounds, false);
    }

    private static Bounds any(Type[] bounds) {
        return new Bounds(bounds, true);
    }

    private static class Bounds {
        private final Type[] bounds;
        private final boolean target;

        Bounds(Type[] bounds2, boolean target2) {
            this.bounds = bounds2;
            this.target = target2;
        }

        /* access modifiers changed from: package-private */
        public boolean isSubtypeOf(Type supertype) {
            for (Type bound : this.bounds) {
                if (TypeToken.of(bound).isSubtypeOf(supertype) == this.target) {
                    return this.target;
                }
            }
            return !this.target;
        }

        /* access modifiers changed from: package-private */
        public boolean isSupertypeOf(Type subtype) {
            TypeToken<?> type = TypeToken.of(subtype);
            for (Type bound : this.bounds) {
                if (type.isSubtypeOf(bound) == this.target) {
                    return this.target;
                }
            }
            return !this.target;
        }
    }

    /* access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        final ImmutableSet.Builder<Class<?>> builder = ImmutableSet.builder();
        new TypeVisitor(this) {
            /* access modifiers changed from: package-private */
            public void visitTypeVariable(TypeVariable<?> t) {
                visit(t.getBounds());
            }

            /* access modifiers changed from: package-private */
            public void visitWildcardType(WildcardType t) {
                visit(t.getUpperBounds());
            }

            /* access modifiers changed from: package-private */
            public void visitParameterizedType(ParameterizedType t) {
                builder.add((Object) (Class) t.getRawType());
            }

            /* access modifiers changed from: package-private */
            public void visitClass(Class<?> t) {
                builder.add((Object) t);
            }

            /* access modifiers changed from: package-private */
            public void visitGenericArrayType(GenericArrayType t) {
                builder.add((Object) Types.getArrayClass(TypeToken.of(t.getGenericComponentType()).getRawType()));
            }
        }.visit(this.runtimeType);
        return builder.build();
    }

    private boolean isOwnedBySubtypeOf(Type supertype) {
        Iterator it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerType = ((TypeToken) it.next()).getOwnerTypeIfPresent();
            if (ownerType != null && of(ownerType).isSubtypeOf(supertype)) {
                return true;
            }
        }
        return false;
    }

    @CheckForNull
    private Type getOwnerTypeIfPresent() {
        if (this.runtimeType instanceof ParameterizedType) {
            return ((ParameterizedType) this.runtimeType).getOwnerType();
        }
        if (this.runtimeType instanceof Class) {
            return ((Class) this.runtimeType).getEnclosingClass();
        }
        return null;
    }

    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        Type ownerType;
        if (cls.isArray()) {
            return of(Types.newArrayType(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParams = cls.getTypeParameters();
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            ownerType = null;
        } else {
            ownerType = toGenericType(cls.getEnclosingClass()).runtimeType;
        }
        if (typeParams.length > 0 || (ownerType != null && ownerType != cls.getEnclosingClass())) {
            return of((Type) Types.newParameterizedTypeWithOwner(ownerType, cls, typeParams));
        }
        return of(cls);
    }

    /* access modifiers changed from: private */
    public TypeResolver getCovariantTypeResolver() {
        TypeResolver resolver = this.covariantTypeResolver;
        if (resolver != null) {
            return resolver;
        }
        TypeResolver resolver2 = TypeResolver.covariantly(this.runtimeType);
        this.covariantTypeResolver = resolver2;
        return resolver2;
    }

    /* access modifiers changed from: private */
    public TypeResolver getInvariantTypeResolver() {
        TypeResolver resolver = this.invariantTypeResolver;
        if (resolver != null) {
            return resolver;
        }
        TypeResolver resolver2 = TypeResolver.invariantly(this.runtimeType);
        this.invariantTypeResolver = resolver2;
        return resolver2;
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> supertype, Type[] upperBounds) {
        for (Type upperBound : upperBounds) {
            TypeToken<?> of = of(upperBound);
            if (of.isSubtypeOf((Type) supertype)) {
                return of.getSupertype(supertype);
            }
        }
        throw new IllegalArgumentException(supertype + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> subclass, Type[] lowerBounds) {
        if (lowerBounds.length > 0) {
            return of(lowerBounds[0]).getSubtype(subclass);
        }
        throw new IllegalArgumentException(subclass + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> supertype) {
        TypeToken componentType = getComponentType();
        if (componentType != null) {
            return of(newArrayClassOrGenericArrayType(componentType.getSupertype((Class) Objects.requireNonNull(supertype.getComponentType())).runtimeType));
        }
        throw new IllegalArgumentException(supertype + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> subclass) {
        Class<?> subclassComponentType = subclass.getComponentType();
        if (subclassComponentType != null) {
            return of(newArrayClassOrGenericArrayType(((TypeToken) Objects.requireNonNull(getComponentType())).getSubtype(subclassComponentType).runtimeType));
        }
        throw new IllegalArgumentException(subclass + " does not appear to be a subtype of " + this);
    }

    private Type resolveTypeArgsForSubclass(Class<?> subclass) {
        if ((this.runtimeType instanceof Class) && (subclass.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return subclass;
        }
        TypeToken<?> genericSubtype = toGenericType(subclass);
        return new TypeResolver().where(genericSubtype.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(genericSubtype.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type componentType) {
        return Types.JavaVersion.JAVA7.newArrayType(componentType);
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>() {
            /* access modifiers changed from: package-private */
            public Class<?> getRawType(TypeToken<?> type) {
                return type.getRawType();
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> type) {
                return type.getGenericInterfaces();
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            public TypeToken<?> getSuperclass(TypeToken<?> type) {
                return type.getGenericSuperclass();
            }
        };
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>() {
            /* access modifiers changed from: package-private */
            public Class<?> getRawType(Class<?> type) {
                return type;
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends Class<?>> getInterfaces(Class<?> type) {
                return Arrays.asList(type.getInterfaces());
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            public Class<?> getSuperclass(Class<?> type) {
                return type.getSuperclass();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Iterable<? extends K> getInterfaces(K k);

        /* access modifiers changed from: package-private */
        public abstract Class<?> getRawType(K k);

        /* access modifiers changed from: package-private */
        @CheckForNull
        public abstract K getSuperclass(K k);

        private TypeCollector() {
        }

        /* access modifiers changed from: package-private */
        public final TypeCollector<K> classesOnly() {
            return new ForwardingTypeCollector<K>(this, this) {
                /* access modifiers changed from: package-private */
                public Iterable<? extends K> getInterfaces(K k) {
                    return ImmutableSet.of();
                }

                /* access modifiers changed from: package-private */
                public ImmutableList<K> collectTypes(Iterable<? extends K> types) {
                    ImmutableList.Builder<K> builder = ImmutableList.builder();
                    for (K type : types) {
                        if (!getRawType(type).isInterface()) {
                            builder.add((Object) type);
                        }
                    }
                    return super.collectTypes(builder.build());
                }
            };
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<K> collectTypes(K type) {
            return collectTypes(ImmutableList.of(type));
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<K> collectTypes(Iterable<? extends K> types) {
            Map<K, Integer> map = Maps.newHashMap();
            for (K type : types) {
                collectTypes(type, map);
            }
            return sortKeysByValue(map, Ordering.natural().reverse());
        }

        private int collectTypes(K type, Map<? super K, Integer> map) {
            Integer existing = map.get(type);
            if (existing != null) {
                return existing.intValue();
            }
            int aboveMe = getRawType(type).isInterface();
            for (K interfaceType : getInterfaces(type)) {
                aboveMe = Math.max(aboveMe, collectTypes(interfaceType, map));
            }
            K superclass = getSuperclass(type);
            if (superclass != null) {
                aboveMe = Math.max(aboveMe, collectTypes(superclass, map));
            }
            map.put(type, Integer.valueOf(aboveMe + 1));
            return aboveMe + 1;
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map, final Comparator<? super V> valueComparator) {
            return new Ordering<K>() {
                public int compare(K left, K right) {
                    return valueComparator.compare(Objects.requireNonNull(map.get(left)), Objects.requireNonNull(map.get(right)));
                }
            }.immutableSortedCopy(map.keySet());
        }

        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> delegate2) {
                super();
                this.delegate = delegate2;
            }

            /* access modifiers changed from: package-private */
            public Class<?> getRawType(K type) {
                return this.delegate.getRawType(type);
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends K> getInterfaces(K type) {
                return this.delegate.getInterfaces(type);
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            public K getSuperclass(K type) {
                return this.delegate.getSuperclass(type);
            }
        }
    }
}
