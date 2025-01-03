package c.c.a.b.c.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3958a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static h f3959b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3960a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3961b;

        /* renamed from: c, reason: collision with root package name */
        public final ComponentName f3962c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3963d;

        public a(String str, String str2, int i2) {
            r.b(str);
            this.f3960a = str;
            r.b(str2);
            this.f3961b = str2;
            this.f3962c = null;
            this.f3963d = i2;
        }

        public final ComponentName a() {
            return this.f3962c;
        }

        public final String b() {
            return this.f3961b;
        }

        public final int c() {
            return this.f3963d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return q.a(this.f3960a, aVar.f3960a) && q.a(this.f3961b, aVar.f3961b) && q.a(this.f3962c, aVar.f3962c) && this.f3963d == aVar.f3963d;
        }

        public final int hashCode() {
            return q.a(this.f3960a, this.f3961b, this.f3962c, Integer.valueOf(this.f3963d));
        }

        public final String toString() {
            String str = this.f3960a;
            return str == null ? this.f3962c.flattenToString() : str;
        }

        public final Intent a(Context context) {
            return this.f3960a != null ? new Intent(this.f3960a).setPackage(this.f3961b) : new Intent().setComponent(this.f3962c);
        }
    }

    public static h a(Context context) {
        synchronized (f3958a) {
            if (f3959b == null) {
                f3959b = new i0(context.getApplicationContext());
            }
        }
        return f3959b;
    }

    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);

    public final void a(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        b(new a(str, str2, i2), serviceConnection, str3);
    }
}
