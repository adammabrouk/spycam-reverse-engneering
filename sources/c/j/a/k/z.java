package c.j.a.k;

import android.content.Context;

/* compiled from: OnMessageReceiveTask.java */
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.t.c f6609a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f6610b;

    public z(y yVar, c.j.a.t.c cVar) {
        this.f6610b = yVar;
        this.f6609a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        y yVar = this.f6610b;
        c.j.a.y.a aVar = yVar.f6591d;
        context = yVar.f6635a;
        aVar.onTransmissionMessage(context, this.f6609a);
    }
}
