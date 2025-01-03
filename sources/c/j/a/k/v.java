package c.j.a.k;

import android.content.Context;

/* compiled from: OnListTagReceiveTask.java */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.l f6605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f6606b;

    public v(u uVar, c.j.a.f.l lVar) {
        this.f6606b = uVar;
        this.f6605a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u uVar = this.f6606b;
        c.j.a.y.a aVar = uVar.f6591d;
        context = uVar.f6635a;
        aVar.onListTags(context, this.f6605a.e(), this.f6605a.f(), this.f6605a.d());
    }
}
