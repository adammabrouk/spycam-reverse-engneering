package c.k.d;

import android.content.Context;
import c.k.d.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h6 extends m.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7226a;

    public h6(Context context) {
        this.f7226a = context;
    }

    @Override // c.k.d.m.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = g6.f7163d;
        synchronized (obj) {
            list = g6.f7164e;
            arrayList = new ArrayList(list);
            list2 = g6.f7164e;
            list2.clear();
        }
        g6.b(this.f7226a, arrayList);
    }
}
