package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class t7 {

    /* renamed from: a, reason: collision with root package name */
    public static final u7 f4442a;

    static {
        f4442a = (!(q7.a() && q7.b()) || h3.a()) ? new x7() : new z7();
    }

    public static boolean a(byte[] bArr) {
        return f4442a.a(bArr, 0, bArr.length);
    }

    public static int b(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    public static int b(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    public static int b(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    public static String b(byte[] bArr, int i2, int i3) throws c5 {
        return f4442a.b(bArr, i2, i3);
    }

    public static int d(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return b(b2);
        }
        if (i4 == 1) {
            return b(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return b(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean a(byte[] bArr, int i2, int i3) {
        return f4442a.a(bArr, i2, i3);
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new w7(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j = i4 + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return f4442a.a(charSequence, bArr, i2, i3);
    }
}
