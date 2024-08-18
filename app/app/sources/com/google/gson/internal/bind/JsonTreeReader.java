package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = new Object();
    private static final Reader UNREADABLE_READER = new Reader() {
        public int read(char[] buffer, int offset, int count) {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    };
    private int[] pathIndices = new int[32];
    private String[] pathNames = new String[32];
    private Object[] stack = new Object[32];
    private int stackSize = 0;

    public JsonTreeReader(JsonElement element) {
        super(UNREADABLE_READER);
        push(element);
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public boolean hasNext() throws IOException {
        JsonToken token = peek();
        return (token == JsonToken.END_OBJECT || token == JsonToken.END_ARRAY || token == JsonToken.END_DOCUMENT) ? false : true;
    }

    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object o = peekStack();
        if (o instanceof Iterator) {
            boolean isObject = this.stack[this.stackSize - 2] instanceof JsonObject;
            Iterator<?> iterator = (Iterator) o;
            if (!iterator.hasNext()) {
                return isObject ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (isObject) {
                return JsonToken.NAME;
            }
            push(iterator.next());
            return peek();
        } else if (o instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (o instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (o instanceof JsonPrimitive) {
                JsonPrimitive primitive = (JsonPrimitive) o;
                if (primitive.isString()) {
                    return JsonToken.STRING;
                }
                if (primitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (primitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (o instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (o == SENTINEL_CLOSED) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new MalformedJsonException("Custom JsonElement subclass " + o.getClass().getName() + " is not supported");
            }
        }
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] objArr = this.stack;
        int i = this.stackSize - 1;
        this.stackSize = i;
        Object result = objArr[i];
        this.stack[this.stackSize] = null;
        return result;
    }

    private void expect(JsonToken expected) throws IOException {
        if (peek() != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + peek() + locationString());
        }
    }

    private String nextName(boolean skipName) throws IOException {
        expect(JsonToken.NAME);
        Map.Entry<?, ?> entry = (Map.Entry) ((Iterator) peekStack()).next();
        String result = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = skipName ? "<skipped>" : result;
        push(entry.getValue());
        return result;
    }

    public String nextName() throws IOException {
        return nextName(false);
    }

    public String nextString() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.STRING || token == JsonToken.NUMBER) {
            String result = ((JsonPrimitive) popStack()).getAsString();
            if (this.stackSize > 0) {
                int[] iArr = this.pathIndices;
                int i = this.stackSize - 1;
                iArr[i] = iArr[i] + 1;
            }
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + token + locationString());
    }

    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        boolean result = ((JsonPrimitive) popStack()).getAsBoolean();
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
        }
        return result;
    }

    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public double nextDouble() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            double result = ((JsonPrimitive) peekStack()).getAsDouble();
            if (isLenient() || (!Double.isNaN(result) && !Double.isInfinite(result))) {
                popStack();
                if (this.stackSize > 0) {
                    int[] iArr = this.pathIndices;
                    int i = this.stackSize - 1;
                    iArr[i] = iArr[i] + 1;
                }
                return result;
            }
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + result);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + locationString());
    }

    public long nextLong() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            long result = ((JsonPrimitive) peekStack()).getAsLong();
            popStack();
            if (this.stackSize > 0) {
                int[] iArr = this.pathIndices;
                int i = this.stackSize - 1;
                iArr[i] = iArr[i] + 1;
            }
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + locationString());
    }

    public int nextInt() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            int result = ((JsonPrimitive) peekStack()).getAsInt();
            popStack();
            if (this.stackSize > 0) {
                int[] iArr = this.pathIndices;
                int i = this.stackSize - 1;
                iArr[i] = iArr[i] + 1;
            }
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + locationString());
    }

    /* access modifiers changed from: package-private */
    public JsonElement nextJsonElement() throws IOException {
        JsonToken peeked = peek();
        if (peeked == JsonToken.NAME || peeked == JsonToken.END_ARRAY || peeked == JsonToken.END_OBJECT || peeked == JsonToken.END_DOCUMENT) {
            throw new IllegalStateException("Unexpected " + peeked + " when reading a JsonElement.");
        }
        JsonElement element = (JsonElement) peekStack();
        skipValue();
        return element;
    }

    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    public void skipValue() throws IOException {
        switch (peek()) {
            case NAME:
                String nextName = nextName(true);
                return;
            case END_ARRAY:
                endArray();
                return;
            case END_OBJECT:
                endObject();
                return;
            case END_DOCUMENT:
                return;
            default:
                popStack();
                if (this.stackSize > 0) {
                    int[] iArr = this.pathIndices;
                    int i = this.stackSize - 1;
                    iArr[i] = iArr[i] + 1;
                    return;
                }
                return;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public void promoteNameToValue() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry<?, ?> entry = (Map.Entry) ((Iterator) peekStack()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object newTop) {
        if (this.stackSize == this.stack.length) {
            int newLength = this.stackSize * 2;
            this.stack = Arrays.copyOf(this.stack, newLength);
            this.pathIndices = Arrays.copyOf(this.pathIndices, newLength);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, newLength);
        }
        Object[] objArr = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        objArr[i] = newTop;
    }

    private String getPath(boolean usePreviousPath) {
        StringBuilder result = new StringBuilder().append(Typography.dollar);
        int i = 0;
        while (i < this.stackSize) {
            if (this.stack[i] instanceof JsonArray) {
                i++;
                if (i < this.stackSize && (this.stack[i] instanceof Iterator)) {
                    int pathIndex = this.pathIndices[i];
                    if (usePreviousPath && pathIndex > 0 && (i == this.stackSize - 1 || i == this.stackSize - 2)) {
                        pathIndex--;
                    }
                    result.append('[').append(pathIndex).append(']');
                }
            } else if ((this.stack[i] instanceof JsonObject) && (i = i + 1) < this.stackSize && (this.stack[i] instanceof Iterator)) {
                result.append('.');
                if (this.pathNames[i] != null) {
                    result.append(this.pathNames[i]);
                }
            }
            i++;
        }
        return result.toString();
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public String getPath() {
        return getPath(false);
    }

    private String locationString() {
        return " at path " + getPath();
    }
}
