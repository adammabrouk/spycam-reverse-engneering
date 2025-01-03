package c.c.a.b.c;

import android.util.Log;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f3816d = new f0(true, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3817a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3818b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f3819c;

    public f0(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f3817a = z;
        this.f3818b = str;
        this.f3819c = th;
    }

    public static f0 a(Callable<String> callable) {
        return new h0(callable);
    }

    public static f0 c() {
        return f3816d;
    }

    public final void b() {
        if (this.f3817a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f3819c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f3819c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }

    public static f0 a(String str) {
        return new f0(false, str, null);
    }

    public static f0 a(String str, Throwable th) {
        return new f0(false, str, th);
    }

    @Nullable
    public String a() {
        return this.f3818b;
    }

    public static String a(String str, y yVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, c.c.a.b.c.s.j.a(c.c.a.b.c.s.a.a("SHA-1").digest(yVar.f())), Boolean.valueOf(z), "12451009.false");
    }
}
