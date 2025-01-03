package c.c.a.b.c;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import c.c.a.b.c.o.p0;
import c.c.a.b.c.o.q0;
import c.c.a.b.c.o.r;
import com.google.android.gms.common.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static volatile p0 f4034a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4035b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static Context f4036c;

    public static synchronized void a(Context context) {
        synchronized (w.class) {
            if (f4036c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f4036c = context.getApplicationContext();
            }
        }
    }

    public static f0 b(final String str, final y yVar, final boolean z, boolean z2) {
        try {
            if (f4034a == null) {
                r.a(f4036c);
                synchronized (f4035b) {
                    if (f4034a == null) {
                        f4034a = q0.a(DynamiteModule.a(f4036c, DynamiteModule.j, "com.google.android.gms.googlecertificates").a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            r.a(f4036c);
            try {
                return f4034a.a(new zzk(str, yVar, z, z2), c.c.a.b.d.b.a(f4036c.getPackageManager())) ? f0.c() : f0.a((Callable<String>) new Callable(z, str, yVar) { // from class: c.c.a.b.c.x

                    /* renamed from: a, reason: collision with root package name */
                    public final boolean f4037a;

                    /* renamed from: b, reason: collision with root package name */
                    public final String f4038b;

                    /* renamed from: c, reason: collision with root package name */
                    public final y f4039c;

                    {
                        this.f4037a = z;
                        this.f4038b = str;
                        this.f4039c = yVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        String a2;
                        a2 = f0.a(this.f4038b, this.f4039c, this.f4037a, !r3 && w.b(r4, r5, true, false).f3817a);
                        return a2;
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return f0.a("module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return f0.a(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }

    public static f0 a(String str, y yVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, yVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
