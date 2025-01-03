package c.j.a.k;

import android.content.Context;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6572a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f6573b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f6574c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6575d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f6576e;

    public c(b bVar, int i2, List list, List list2, String str) {
        this.f6576e = bVar;
        this.f6572a = i2;
        this.f6573b = list;
        this.f6574c = list2;
        this.f6575d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        b bVar = this.f6576e;
        c.j.a.y.a aVar = bVar.f6591d;
        context = bVar.f6635a;
        aVar.onSetTags(context, this.f6572a, this.f6573b, this.f6574c, this.f6575d);
    }
}
