package c.c.a.b.f.d;

import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class h extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        g.a(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        g.a(bArr);
    }
}
