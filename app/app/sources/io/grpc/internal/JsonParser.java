package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JsonParser {
    private static final Logger logger = Logger.getLogger(JsonParser.class.getName());

    private JsonParser() {
    }

    public static Object parse(String raw) throws IOException {
        JsonReader jr = new JsonReader(new StringReader(raw));
        try {
            return parseRecursive(jr);
        } finally {
            try {
                jr.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to close", e);
            }
        }
    }

    private static Object parseRecursive(JsonReader jr) throws IOException {
        Preconditions.checkState(jr.hasNext(), "unexpected end of JSON");
        switch (jr.peek()) {
            case BEGIN_ARRAY:
                return parseJsonArray(jr);
            case BEGIN_OBJECT:
                return parseJsonObject(jr);
            case STRING:
                return jr.nextString();
            case NUMBER:
                return Double.valueOf(jr.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(jr.nextBoolean());
            case NULL:
                return parseJsonNull(jr);
            default:
                throw new IllegalStateException("Bad token: " + jr.getPath());
        }
    }

    private static Map<String, ?> parseJsonObject(JsonReader jr) throws IOException {
        jr.beginObject();
        Map<String, Object> obj = new LinkedHashMap<>();
        while (jr.hasNext()) {
            obj.put(jr.nextName(), parseRecursive(jr));
        }
        Preconditions.checkState(jr.peek() == JsonToken.END_OBJECT, "Bad token: " + jr.getPath());
        jr.endObject();
        return Collections.unmodifiableMap(obj);
    }

    private static List<?> parseJsonArray(JsonReader jr) throws IOException {
        jr.beginArray();
        List<Object> array = new ArrayList<>();
        while (jr.hasNext()) {
            array.add(parseRecursive(jr));
        }
        Preconditions.checkState(jr.peek() == JsonToken.END_ARRAY, "Bad token: " + jr.getPath());
        jr.endArray();
        return Collections.unmodifiableList(array);
    }

    private static Void parseJsonNull(JsonReader jr) throws IOException {
        jr.nextNull();
        return null;
    }
}
