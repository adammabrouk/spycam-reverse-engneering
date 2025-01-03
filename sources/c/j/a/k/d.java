package c.j.a.k;

import android.content.Context;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6578a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f6579b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f6580c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6581d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f6582e;

    public d(b bVar, int i2, List list, List list2, String str) {
        this.f6582e = bVar;
        this.f6578a = i2;
        this.f6579b = list;
        this.f6580c = list2;
        this.f6581d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        b bVar = this.f6582e;
        c.j.a.y.a aVar = bVar.f6591d;
        context = bVar.f6635a;
        aVar.onSetAlias(context, this.f6578a, this.f6579b, this.f6580c, this.f6581d);
    }
}
