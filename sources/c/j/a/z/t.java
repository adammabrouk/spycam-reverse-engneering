package c.j.a.z;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import c.j.a.m;
import java.util.Iterator;

/* compiled from: LogController.java */
/* loaded from: classes.dex */
public final class t implements u {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6736a = "(" + Process.myPid() + ")";

    @Override // c.j.a.z.u
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // c.j.a.z.u
    public final int b(String str, String str2) {
        return Log.e("VivoPush.".concat(String.valueOf(str)), f6736a + str2);
    }

    @Override // c.j.a.z.u
    public final int c(String str, String str2) {
        return Log.d("VivoPush.".concat(String.valueOf(str)), f6736a + str2);
    }

    @Override // c.j.a.z.u
    public final int d(String str, String str2) {
        if (!v.a()) {
            return -1;
        }
        return Log.i("VivoPush.".concat(String.valueOf(str)), f6736a + str2);
    }

    @Override // c.j.a.z.u
    public final int e(String str, String str2) {
        if (!v.a()) {
            return -1;
        }
        return Log.v("VivoPush.".concat(String.valueOf(str)), f6736a + str2);
    }

    @Override // c.j.a.z.u
    public final int b(String str, String str2, Throwable th) {
        return Log.e("VivoPush.".concat(String.valueOf(str)), f6736a + str2, th);
    }

    @Override // c.j.a.z.u
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // c.j.a.z.u
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // c.j.a.z.u
    public final int a(String str, String str2) {
        return Log.w("VivoPush.".concat(String.valueOf(str)), f6736a + str2);
    }

    @Override // c.j.a.z.u
    public final int a(String str, String str2, Throwable th) {
        if (!v.a()) {
            return -1;
        }
        return Log.i("VivoPush.".concat(String.valueOf(str)), f6736a + str2, th);
    }

    @Override // c.j.a.z.u
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // c.j.a.z.u
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    public final void a(Context context, String str, int i2) {
        c.j.a.f.m mVar = new c.j.a.f.m();
        mVar.b(str);
        mVar.a(i2);
        if (i2 > 0) {
            d("LogController", str);
        }
        if (context.getPackageName().equals("com.vivo.pushservice")) {
            mVar.a(true);
            Iterator<String> it = m.b.c().a().iterator();
            while (it.hasNext()) {
                c.j.a.d.a.a(context, mVar, it.next());
            }
            return;
        }
        mVar.a(false);
        c.j.a.d.a.a(context, mVar, context.getPackageName());
    }

    public static boolean a() {
        v.a();
        return m.b.c().b();
    }
}
