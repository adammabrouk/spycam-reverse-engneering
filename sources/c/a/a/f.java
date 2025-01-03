package c.a.a;

import android.content.Context;
import android.os.Build;
import c.a.a.l.i.n.a;
import c.a.a.l.i.n.i;
import java.util.concurrent.ExecutorService;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2924a;

    /* renamed from: b, reason: collision with root package name */
    public c.a.a.l.i.c f2925b;

    /* renamed from: c, reason: collision with root package name */
    public c.a.a.l.i.m.c f2926c;

    /* renamed from: d, reason: collision with root package name */
    public c.a.a.l.i.n.h f2927d;

    /* renamed from: e, reason: collision with root package name */
    public ExecutorService f2928e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f2929f;

    /* renamed from: g, reason: collision with root package name */
    public c.a.a.l.a f2930g;

    /* renamed from: h, reason: collision with root package name */
    public a.InterfaceC0067a f2931h;

    public f(Context context) {
        this.f2924a = context.getApplicationContext();
    }

    public e a() {
        if (this.f2928e == null) {
            this.f2928e = new c.a.a.l.i.o.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f2929f == null) {
            this.f2929f = new c.a.a.l.i.o.a(1);
        }
        i iVar = new i(this.f2924a);
        if (this.f2926c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f2926c = new c.a.a.l.i.m.f(iVar.a());
            } else {
                this.f2926c = new c.a.a.l.i.m.d();
            }
        }
        if (this.f2927d == null) {
            this.f2927d = new c.a.a.l.i.n.g(iVar.b());
        }
        if (this.f2931h == null) {
            this.f2931h = new c.a.a.l.i.n.f(this.f2924a);
        }
        if (this.f2925b == null) {
            this.f2925b = new c.a.a.l.i.c(this.f2927d, this.f2931h, this.f2929f, this.f2928e);
        }
        if (this.f2930g == null) {
            this.f2930g = c.a.a.l.a.DEFAULT;
        }
        return new e(this.f2925b, this.f2927d, this.f2926c, this.f2924a, this.f2930g);
    }
}
