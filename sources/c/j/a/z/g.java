package c.j.a.z;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    public static volatile g f6704c;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6705a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6706b;

    public g(Context context) {
        c0.b().a(c.c(context));
        c0 b2 = c0.b();
        this.f6705a = b2.c();
        this.f6706b = b2.d();
    }

    public static g a(Context context) {
        if (f6704c == null) {
            synchronized (g.class) {
                if (f6704c == null) {
                    f6704c = new g(context.getApplicationContext());
                }
            }
        }
        return f6704c;
    }

    public final String b(String str) throws Exception {
        return new String(l.a(l.a(a()), l.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    public final byte[] b() {
        byte[] bArr = this.f6706b;
        return (bArr == null || bArr.length <= 0) ? c0.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a2 = l.a(a());
        String a3 = l.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    public final byte[] a() {
        byte[] bArr = this.f6705a;
        return (bArr == null || bArr.length <= 0) ? c0.b().c() : bArr;
    }
}
