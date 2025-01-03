package c.j.a.z;

import android.content.Context;

/* compiled from: SharePreferenceManager.java */
/* loaded from: classes.dex */
public final class c0 extends h {

    /* renamed from: h, reason: collision with root package name */
    public static c0 f6682h;

    public static synchronized c0 b() {
        c0 c0Var;
        synchronized (c0.class) {
            if (f6682h == null) {
                f6682h = new c0();
            }
            c0Var = f6682h;
        }
        return c0Var;
    }

    public final synchronized void a(Context context) {
        if (this.f6707a == null) {
            this.f6707a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : c2;
    }

    public final byte[] d() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_key", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : c2;
    }

    public static byte[] c(String str) {
        int i2;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i2 = split.length;
            } else {
                i2 = 0;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
        } catch (Exception e2) {
            v.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
