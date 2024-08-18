package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@ElementTypesAreNonnullByDefault
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        public String escape(String string) {
            return (String) Preconditions.checkNotNull(string);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public char[] escape(char c) {
            return null;
        }
    };

    private Escapers() {
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        /* access modifiers changed from: private */
        @CheckForNull
        public String unsafeReplacement;

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }

        public Builder setSafeRange(char safeMin2, char safeMax2) {
            this.safeMin = safeMin2;
            this.safeMax = safeMax2;
            return this;
        }

        public Builder setUnsafeReplacement(String unsafeReplacement2) {
            this.unsafeReplacement = unsafeReplacement2;
            return this;
        }

        public Builder addEscape(char c, String replacement) {
            Preconditions.checkNotNull(replacement);
            this.replacementMap.put(Character.valueOf(c), replacement);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                @CheckForNull
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                public char[] escapeUnsafe(char c) {
                    return this.replacementChars;
                }
            };
        }
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper escaper, char c) {
        return stringOrNull(escaper.escape(c));
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper escaper, int cp) {
        return stringOrNull(escaper.escape(cp));
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] in) {
        if (in == null) {
            return null;
        }
        return new String(in);
    }

    private static UnicodeEscaper wrap(final CharEscaper escaper) {
        return new UnicodeEscaper() {
            /* access modifiers changed from: protected */
            @CheckForNull
            public char[] escape(int cp) {
                if (cp < 65536) {
                    return CharEscaper.this.escape((char) cp);
                }
                char[] surrogateChars = new char[2];
                Character.toChars(cp, surrogateChars, 0);
                char[] hiChars = CharEscaper.this.escape(surrogateChars[0]);
                char[] loChars = CharEscaper.this.escape(surrogateChars[1]);
                if (hiChars == null && loChars == null) {
                    return null;
                }
                int hiCount = hiChars != null ? hiChars.length : 1;
                char[] output = new char[(hiCount + (loChars != null ? loChars.length : 1))];
                if (hiChars != null) {
                    for (int n = 0; n < hiChars.length; n++) {
                        output[n] = hiChars[n];
                    }
                } else {
                    output[0] = surrogateChars[0];
                }
                if (loChars != null) {
                    for (int n2 = 0; n2 < loChars.length; n2++) {
                        output[hiCount + n2] = loChars[n2];
                    }
                } else {
                    output[hiCount] = surrogateChars[1];
                }
                return output;
            }
        };
    }
}
