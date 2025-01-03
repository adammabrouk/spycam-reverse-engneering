package c.k.d;

/* loaded from: classes.dex */
public abstract class d9 {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i2, int i3);

    public void a(int i2) {
    }

    /* renamed from: a */
    public abstract void mo76a(byte[] bArr, int i2, int i3);

    /* renamed from: a */
    public byte[] mo122a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int a2 = a(bArr, i2 + i4, i3 - i4);
            if (a2 <= 0) {
                throw new e9("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes.");
            }
            i4 += a2;
        }
        return i4;
    }
}
