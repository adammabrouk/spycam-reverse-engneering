package c.k.d;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class s2 {
    public abstract int a();

    public abstract s2 a(b0 b0Var);

    public s2 a(byte[] bArr) {
        a(bArr, 0, bArr.length);
        return this;
    }

    public s2 a(byte[] bArr, int i2, int i3) {
        try {
            b0 a2 = b0.a(bArr, i2, i3);
            a(a2);
            a2.m83a(0);
            return this;
        } catch (r1 e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(c1 c1Var);

    /* renamed from: a, reason: collision with other method in class */
    public void m459a(byte[] bArr, int i2, int i3) {
        try {
            c1 a2 = c1.a(bArr, i2, i3);
            a(a2);
            a2.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b0 b0Var, int i2) {
        return b0Var.m85a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m460a() {
        int b2 = b();
        byte[] bArr = new byte[b2];
        m459a(bArr, 0, b2);
        return bArr;
    }

    public abstract int b();
}
