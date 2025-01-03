package c.j.a.k;

import android.content.Context;

/* compiled from: OnLogReceiveTask.java */
/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.m f6607a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f6608b;

    public x(w wVar, c.j.a.f.m mVar) {
        this.f6608b = wVar;
        this.f6607a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        w wVar = this.f6608b;
        c.j.a.y.a aVar = wVar.f6591d;
        context = wVar.f6635a;
        aVar.onLog(context, this.f6607a.f(), this.f6607a.g(), this.f6607a.h());
    }
}
