package c.j.a.k;

import android.content.Context;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6600a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f6601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f6602c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6603d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f6604e;

    public s(q qVar, int i2, List list, List list2, String str) {
        this.f6604e = qVar;
        this.f6600a = i2;
        this.f6601b = list;
        this.f6602c = list2;
        this.f6603d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        q qVar = this.f6604e;
        c.j.a.y.a aVar = qVar.f6591d;
        context = qVar.f6635a;
        aVar.onDelAlias(context, this.f6600a, this.f6601b, this.f6602c, this.f6603d);
    }
}
