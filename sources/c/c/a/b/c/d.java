package c.c.a.b.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import c.c.a.b.c.o.k0;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3814a = h.f3820a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f3815b = new d();

    public static d a() {
        return f3815b;
    }

    public int b(Context context) {
        return a(context, f3814a);
    }

    public int a(Context context, int i2) {
        int a2 = h.a(context, i2);
        if (h.b(context, a2)) {
            return 18;
        }
        return a2;
    }

    public boolean b(int i2) {
        return h.b(i2);
    }

    public Intent a(Context context, int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return k0.a("com.google.android.gms");
        }
        if (context != null && c.c.a.b.c.s.i.c(context)) {
            return k0.a();
        }
        return k0.a("com.google.android.gms", a(context, str));
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return a(context, i2, i3, null);
    }

    public PendingIntent a(Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, a2, 134217728);
    }

    public int a(Context context) {
        return h.a(context);
    }

    public String a(int i2) {
        return h.a(i2);
    }

    public static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f3814a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(c.c.a.b.c.t.c.b(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }
}
