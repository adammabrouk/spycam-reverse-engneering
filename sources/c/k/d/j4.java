package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class j4 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile j4 f7286b;

    /* renamed from: a, reason: collision with root package name */
    public Context f7287a;

    public j4(Context context) {
        this.f7287a = context;
    }

    public static j4 a(Context context) {
        if (f7286b == null) {
            synchronized (j4.class) {
                if (f7286b == null) {
                    f7286b = new j4(context);
                }
            }
        }
        return f7286b;
    }

    public final void a(c.k.b.a.d dVar) {
        if (dVar instanceof c.k.b.a.c) {
            c.k.b.b.a.a(this.f7287a, (c.k.b.a.c) dVar);
        } else if (dVar instanceof c.k.b.a.b) {
            c.k.b.b.a.a(this.f7287a, (c.k.b.a.b) dVar);
        }
    }

    public void a(String str, int i2, long j, long j2) {
        if (i2 < 0 || j2 < 0 || j <= 0) {
            return;
        }
        c.k.b.a.c a2 = i4.a(this.f7287a, i2, j, j2);
        a2.a(str);
        a2.b("3_7_6");
        a(a2);
    }

    public void a(String str, Intent intent, int i2, String str2) {
        if (intent == null) {
            return;
        }
        a(str, i4.m221a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i2, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, i4.m221a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i2, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        c.k.b.a.b a2 = i4.a(this.f7287a, str2, str3, i2, j, str4);
        a2.a(str);
        a2.b("3_7_6");
        a(a2);
    }

    public void a(String str, String str2, String str3, int i2, String str4) {
        a(str, str2, str3, i2, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
