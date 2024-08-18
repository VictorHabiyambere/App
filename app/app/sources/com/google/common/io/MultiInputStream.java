package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class MultiInputStream extends InputStream {
    @CheckForNull
    private InputStream in;
    private Iterator<? extends ByteSource> it;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    public void close() throws IOException {
        if (this.in != null) {
            try {
                this.in.close();
            } finally {
                this.in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.in = ((ByteSource) this.it.next()).openStream();
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            return 0;
        }
        return this.in.available();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        while (this.in != null) {
            int result = this.in.read();
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        Preconditions.checkNotNull(b);
        while (this.in != null) {
            int result = this.in.read(b, off, len);
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    public long skip(long n) throws IOException {
        if (this.in == null || n <= 0) {
            return 0;
        }
        long result = this.in.skip(n);
        if (result != 0) {
            return result;
        }
        if (read() == -1) {
            return 0;
        }
        return this.in.skip(n - 1) + 1;
    }
}
