package c.c.a.b.c.o;

import android.util.Log;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f3964a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3965b;

    public i(String str, String str2) {
        r.a(str, (Object) "log tag cannot be null");
        r.a(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f3964a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f3965b = null;
        } else {
            this.f3965b = str2;
        }
    }

    public final boolean a(int i2) {
        return Log.isLoggable(this.f3964a, i2);
    }

    public final void b(String str, String str2) {
        if (a(6)) {
            Log.e(str, a(str2));
        }
    }

    public final void c(String str, String str2) {
        if (a(2)) {
            Log.v(str, a(str2));
        }
    }

    public final void a(String str, String str2) {
        if (a(3)) {
            Log.d(str, a(str2));
        }
    }

    public final void a(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, a(str2), th);
        }
    }

    public final String a(String str) {
        String str2 = this.f3965b;
        return str2 == null ? str : str2.concat(str);
    }
}
