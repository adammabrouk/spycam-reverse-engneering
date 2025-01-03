package i;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends r, WritableByteChannel {
    long a(s sVar) throws IOException;

    d a(f fVar) throws IOException;

    d a(String str) throws IOException;

    d b(long j) throws IOException;

    c d();

    @Override // i.r, java.io.Flushable
    void flush() throws IOException;

    d q() throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i2, int i3) throws IOException;

    d writeByte(int i2) throws IOException;

    d writeInt(int i2) throws IOException;

    d writeShort(int i2) throws IOException;
}
