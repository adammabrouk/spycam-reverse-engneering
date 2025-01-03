package c.j.a.k;

import android.content.Context;

/* compiled from: OnUnBindAppReceiveTask.java */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.h f6585a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6586b;

    public f(e eVar, c.j.a.f.h hVar) {
        this.f6586b = eVar;
        this.f6585a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        e eVar = this.f6586b;
        c.j.a.y.a aVar = eVar.f6591d;
        context = eVar.f6635a;
        aVar.onUnBind(context, this.f6585a.e(), this.f6585a.f());
    }
}
