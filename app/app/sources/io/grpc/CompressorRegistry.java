package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Codec;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public final class CompressorRegistry {
    private static final CompressorRegistry DEFAULT_INSTANCE = new CompressorRegistry(new Codec.Gzip(), Codec.Identity.NONE);
    private final ConcurrentMap<String, Compressor> compressors = new ConcurrentHashMap();

    public static CompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CompressorRegistry newEmptyInstance() {
        return new CompressorRegistry(new Compressor[0]);
    }

    CompressorRegistry(Compressor... cs) {
        for (Compressor c : cs) {
            this.compressors.put(c.getMessageEncoding(), c);
        }
    }

    @Nullable
    public Compressor lookupCompressor(String compressorName) {
        return (Compressor) this.compressors.get(compressorName);
    }

    public void register(Compressor c) {
        String encoding = c.getMessageEncoding();
        Preconditions.checkArgument(!encoding.contains(","), "Comma is currently not allowed in message encoding");
        this.compressors.put(encoding, c);
    }
}
