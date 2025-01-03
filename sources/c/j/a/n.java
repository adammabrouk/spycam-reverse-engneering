package c.j.a;

import android.content.Context;
import android.text.TextUtils;
import c.j.a.z.f0;

/* compiled from: PushClientManager.java */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6626a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f6627b;

    public n(m mVar, String str) {
        this.f6627b = mVar;
        this.f6626a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f6627b.f6614d;
        if (context == null || TextUtils.isEmpty(this.f6626a)) {
            return;
        }
        context2 = this.f6627b.f6614d;
        context3 = this.f6627b.f6614d;
        if (f0.b(context2, context3.getPackageName(), this.f6626a)) {
            this.f6627b.h();
        }
    }
}
