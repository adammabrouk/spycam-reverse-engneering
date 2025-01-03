package c.k.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6944c = new a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f6945a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f6946b = 0;

    public a(byte[] bArr) {
        this.f6945a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new a(bArr2);
    }

    public int a() {
        return this.f6945a.length;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m66a() {
        byte[] bArr = this.f6945a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f6945a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f6945a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f6946b;
        if (i2 == 0) {
            byte[] bArr = this.f6945a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f6946b = i2;
        }
        return i2;
    }
}
