package c.j.a.z;

import android.content.Context;
import c.j.a.k.a0;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f6734a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f6735b;

    public r(q qVar, List list) {
        this.f6735b = qVar;
        this.f6734a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.j.a.t.a aVar;
        long j;
        Context context;
        c.j.a.t.a aVar2;
        long j2;
        int i2;
        a0.a aVar3;
        aVar = this.f6735b.f6729b;
        if (aVar != null) {
            c0 b2 = c0.b();
            j = this.f6735b.f6730c;
            b2.a("com.vivo.push.notify_key", j);
            context = this.f6735b.f6728a;
            List list = this.f6734a;
            aVar2 = this.f6735b.f6729b;
            j2 = this.f6735b.f6730c;
            i2 = this.f6735b.f6732e;
            aVar3 = this.f6735b.f6733f;
            d.a(context, list, aVar2, j2, i2, aVar3);
        }
    }
}
