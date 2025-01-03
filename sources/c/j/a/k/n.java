package c.j.a.k;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.h f6593b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f6594c;

    public n(m mVar, String str, c.j.a.f.h hVar) {
        this.f6594c = mVar;
        this.f6592a = str;
        this.f6593b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f6592a)) {
            m mVar = this.f6594c;
            c.j.a.y.a aVar = mVar.f6591d;
            context2 = mVar.f6635a;
            aVar.onReceiveRegId(context2, this.f6592a);
        }
        m mVar2 = this.f6594c;
        c.j.a.y.a aVar2 = mVar2.f6591d;
        context = mVar2.f6635a;
        aVar2.onBind(context, this.f6593b.e(), this.f6593b.f());
    }
}
