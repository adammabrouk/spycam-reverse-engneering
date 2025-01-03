package c.c.a.b.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class w3 extends v5 {

    /* renamed from: c, reason: collision with root package name */
    public char f5153c;

    /* renamed from: d, reason: collision with root package name */
    public long f5154d;

    /* renamed from: e, reason: collision with root package name */
    public String f5155e;

    /* renamed from: f, reason: collision with root package name */
    public final y3 f5156f;

    /* renamed from: g, reason: collision with root package name */
    public final y3 f5157g;

    /* renamed from: h, reason: collision with root package name */
    public final y3 f5158h;

    /* renamed from: i, reason: collision with root package name */
    public final y3 f5159i;
    public final y3 j;
    public final y3 k;
    public final y3 l;
    public final y3 m;
    public final y3 n;

    public w3(a5 a5Var) {
        super(a5Var);
        this.f5153c = (char) 0;
        this.f5154d = -1L;
        this.f5156f = new y3(this, 6, false, false);
        this.f5157g = new y3(this, 6, true, false);
        this.f5158h = new y3(this, 6, false, true);
        this.f5159i = new y3(this, 5, false, false);
        this.j = new y3(this, 5, true, false);
        this.k = new y3(this, 5, false, true);
        this.l = new y3(this, 4, false, false);
        this.m = new y3(this, 3, false, false);
        this.n = new y3(this, 2, false, false);
    }

    public static Object a(String str) {
        if (str == null) {
            return null;
        }
        return new b4(str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final y3 A() {
        return this.m;
    }

    public final y3 B() {
        return this.n;
    }

    public final String C() {
        Pair<String, Long> a2 = k().f4826d.a();
        if (a2 == null || a2 == j4.E) {
            return null;
        }
        String valueOf = String.valueOf(a2.second);
        String str = (String) a2.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        return false;
    }

    public final String s() {
        String str;
        String str2;
        synchronized (this) {
            if (this.f5155e == null) {
                if (this.f5160a.B() != null) {
                    str2 = this.f5160a.B();
                } else {
                    l().F();
                    str2 = "FA";
                }
                this.f5155e = str2;
            }
            str = this.f5155e;
        }
        return str;
    }

    public final y3 t() {
        return this.f5156f;
    }

    public final y3 u() {
        return this.f5157g;
    }

    public final y3 v() {
        return this.f5158h;
    }

    public final y3 w() {
        return this.f5159i;
    }

    public final y3 x() {
        return this.j;
    }

    public final y3 y() {
        return this.k;
    }

    public final y3 z() {
        return this.l;
    }

    public final void a(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i2)) {
            a(i2, a(false, str, obj, obj2, obj3));
        }
        if (z2 || i2 < 5) {
            return;
        }
        c.c.a.b.c.o.r.a(str);
        x4 t = this.f5160a.t();
        if (t == null) {
            a(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!t.r()) {
                a(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            t.a(new z3(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
        }
    }

    public final boolean a(int i2) {
        return Log.isLoggable(s(), i2);
    }

    public final void a(int i2, String str) {
        Log.println(i2, s(), str);
    }

    public static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(a3)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(a3);
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str3);
            sb.append(a4);
        }
        return sb.toString();
    }

    public static String a(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String b2 = b(a5.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && b(className).equals(b2)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i2++;
            }
            return sb2.toString();
        }
        if (!(obj instanceof b4)) {
            return z ? "-" : String.valueOf(obj);
        }
        str = ((b4) obj).f4603a;
        return str;
    }
}
