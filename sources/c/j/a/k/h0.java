package c.j.a.k;

import android.content.Context;

/* compiled from: OnPublishReceiveTask.java */
/* loaded from: classes.dex */
public final class h0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.q f6589a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f6590b;

    public h0(g0 g0Var, c.j.a.f.q qVar) {
        this.f6590b = g0Var;
        this.f6589a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        g0 g0Var = this.f6590b;
        c.j.a.y.a aVar = g0Var.f6591d;
        context = g0Var.f6635a;
        aVar.onPublish(context, this.f6589a.e(), this.f6589a.d());
    }
}
