package cn.jiguang.bb;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import com.google.zxing.view.ViewfinderView;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Integer f8634a;

    public static int a() {
        Integer num = f8634a;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f8634a = valueOf;
        return valueOf.intValue();
    }

    public static String a(Context context) {
        long f2 = cn.jiguang.d.a.f(context);
        return f2 > 0 ? cn.jiguang.bk.e.a(f2) : cn.jiguang.bk.e.a(a());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(long j, int i2, long j2, short s, int i3) {
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(20480);
        bVar.b(0);
        bVar.a(6);
        bVar.a(2);
        bVar.b(j);
        bVar.a(i2);
        bVar.b(j2);
        bVar.a(s);
        bVar.a(i3);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, long j2, String str, String str2, String str3, long j3, byte b2, int i2, String str4, String str5, String str6, String str7, int i3) {
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(1);
        bVar.b(j);
        bVar.a(0L);
        bVar.b(j2);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j3);
        bVar.a((int) b2);
        bVar.a(i2);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.a(i3);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, String str2, String str3, String str4, long j2, String str5) {
        int a2 = a();
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(0);
        bVar.b(j);
        bVar.a(a2);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j2);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(Context context, int i2, int i3, long j, byte[] bArr, long j2) {
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(20480);
        bVar.b(0);
        bVar.a(i3);
        bVar.a(i2);
        bVar.b(j);
        bVar.a(JConstants.tcpSessionId);
        if (j2 == 0) {
            j2 = cn.jiguang.d.a.f(context);
        }
        bVar.b(j2);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String a2 = a(context);
        try {
            byte b2 = JConstants.tcpAlgorithm;
            byte[] a3 = b2 == 2 ? new cn.jiguang.bk.d().a(bArr3, a2) : cn.jiguang.bk.e.a(bArr3, a2, a2.substring(0, 16), true);
            int length2 = a3.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(a3, 0, bArr4, 24, a3.length);
            bArr4[0] = (byte) ((length2 >>> 8) & ViewfinderView.OPAQUE);
            bArr4[1] = (byte) (length2 & ViewfinderView.OPAQUE);
            bArr4[0] = (byte) (bArr4[0] | 128);
            bArr4[4] = b2;
            return bArr4;
        } catch (Exception e2) {
            cn.jiguang.as.d.g("CorePackage", "e:" + e2);
            cn.jiguang.as.d.h("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(short s, short s2, String str) {
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(20480);
        bVar.a((int) s);
        bVar.a((int) s2);
        bVar.a(str);
        return bVar.b();
    }
}
