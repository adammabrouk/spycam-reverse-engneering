package i;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.java */
/* loaded from: classes.dex */
public interface s extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    t timeout();
}
