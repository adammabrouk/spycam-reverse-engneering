package c.j.a.k;

import android.content.Context;

/* compiled from: OnNotificationClickTask.java */
/* loaded from: classes.dex */
public final class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.t.b f6587a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f6588b;

    public f0(d0 d0Var, c.j.a.t.b bVar) {
        this.f6588b = d0Var;
        this.f6587a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        d0 d0Var = this.f6588b;
        c.j.a.y.a aVar = d0Var.f6591d;
        context = d0Var.f6635a;
        aVar.onNotificationMessageClicked(context, this.f6587a);
    }
}
