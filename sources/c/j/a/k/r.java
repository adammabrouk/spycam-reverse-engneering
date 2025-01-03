package c.j.a.k;

import android.content.Context;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f6596b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f6597c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6598d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f6599e;

    public r(q qVar, int i2, List list, List list2, String str) {
        this.f6599e = qVar;
        this.f6595a = i2;
        this.f6596b = list;
        this.f6597c = list2;
        this.f6598d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        q qVar = this.f6599e;
        c.j.a.y.a aVar = qVar.f6591d;
        context = qVar.f6635a;
        aVar.onDelTags(context, this.f6595a, this.f6596b, this.f6597c, this.f6598d);
    }
}
