package c.j.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: PushCommand.java */
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public int f6661a;

    /* renamed from: b, reason: collision with root package name */
    public String f6662b;

    public v(int i2) {
        this.f6661a = -1;
        if (i2 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f6661a = i2;
    }

    public final String a() {
        return this.f6662b;
    }

    public final int b() {
        return this.f6661a;
    }

    public abstract void c(e eVar);

    public boolean c() {
        return false;
    }

    public abstract void d(e eVar);

    public final void e(e eVar) {
        eVar.a("command", this.f6661a);
        eVar.a("client_pkgname", this.f6662b);
        c(eVar);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f6662b = str;
    }

    public final void b(Intent intent) {
        e a2 = e.a(intent);
        if (a2 == null) {
            c.j.a.z.v.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.f6661a);
        e(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(Intent intent) {
        e a2 = e.a(intent);
        if (a2 == null) {
            c.j.a.z.v.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(e eVar) {
        String a2 = w.a(this.f6661a);
        if (a2 == null) {
            a2 = "";
        }
        eVar.a("method", a2);
        e(eVar);
    }

    public final void b(e eVar) {
        String a2 = eVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.f6662b = a2;
        } else {
            this.f6662b = eVar.a("client_pkgname");
        }
        d(eVar);
    }
}
