package i;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b2) throws IOException;

    String a(Charset charset) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    f c(long j) throws IOException;

    c d();

    byte[] d(long j) throws IOException;

    String e(long j) throws IOException;

    void g(long j) throws IOException;

    String h() throws IOException;

    byte[] i() throws IOException;

    int j() throws IOException;

    boolean k() throws IOException;

    short p() throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    long s() throws IOException;

    void skip(long j) throws IOException;

    InputStream t();
}
