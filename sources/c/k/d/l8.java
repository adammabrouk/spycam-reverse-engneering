package c.k.d;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class l8 extends ByteArrayOutputStream {
    public l8(int i2) {
        super(i2);
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m288a() {
        return ((ByteArrayOutputStream) this).buf;
    }
}
