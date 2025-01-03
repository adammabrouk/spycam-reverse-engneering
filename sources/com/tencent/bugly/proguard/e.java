package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11122a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f11122a;
            cArr[i3 + 1] = cArr2[b2 & 15];
            cArr[i3] = cArr2[((byte) (b2 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
