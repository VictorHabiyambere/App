package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<Date>(Date.class) {
            /* access modifiers changed from: protected */
            public Date deserialize(Date date) {
                return date;
            }
        };
        private final Class<T> dateClass;

        /* access modifiers changed from: protected */
        public abstract T deserialize(Date date);

        protected DateType(Class<T> dateClass2) {
            this.dateClass = dateClass2;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> adapter) {
            return TypeAdapters.newFactory(this.dateClass, adapter);
        }

        public final TypeAdapterFactory createAdapterFactory(String datePattern) {
            return createFactory(new DefaultDateTypeAdapter(this, datePattern));
        }

        public final TypeAdapterFactory createAdapterFactory(int style) {
            return createFactory(new DefaultDateTypeAdapter(this, style));
        }

        public final TypeAdapterFactory createAdapterFactory(int dateStyle, int timeStyle) {
            return createFactory(new DefaultDateTypeAdapter(this, dateStyle, timeStyle));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return createFactory(new DefaultDateTypeAdapter(this, 2, 2));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, String datePattern) {
        this.dateFormats = new ArrayList();
        this.dateType = (DateType) Objects.requireNonNull(dateType2);
        this.dateFormats.add(new SimpleDateFormat(datePattern, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(datePattern));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int style) {
        this.dateFormats = new ArrayList();
        this.dateType = (DateType) Objects.requireNonNull(dateType2);
        this.dateFormats.add(DateFormat.getDateInstance(style, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(style));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(style));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int dateStyle, int timeStyle) {
        this.dateFormats = new ArrayList();
        this.dateType = (DateType) Objects.requireNonNull(dateType2);
        this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(dateStyle, timeStyle));
        }
    }

    public void write(JsonWriter out, Date value) throws IOException {
        String dateFormatAsString;
        if (value == null) {
            out.nullValue();
            return;
        }
        DateFormat dateFormat = this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            dateFormatAsString = dateFormat.format(value);
        }
        out.value(dateFormatAsString);
    }

    public T read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        return this.dateType.deserialize(deserializeToDate(in));
    }

    private Date deserializeToDate(JsonReader in) throws IOException {
        String s = in.nextString();
        synchronized (this.dateFormats) {
            for (DateFormat dateFormat : this.dateFormats) {
                try {
                    Date parse = dateFormat.parse(s);
                    return parse;
                } catch (ParseException e) {
                }
            }
            try {
                return ISO8601Utils.parse(s, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + s + "' as Date; at path " + in.getPreviousPath(), e2);
            }
        }
    }

    public String toString() {
        DateFormat defaultFormat = this.dateFormats.get(0);
        if (defaultFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) defaultFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + defaultFormat.getClass().getSimpleName() + ')';
    }
}
