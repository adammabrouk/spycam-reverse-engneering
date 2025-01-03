package c.k.d;

import android.content.Context;
import c.k.d.h1;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f8052a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference<Context> f8053b;

    public z0(String str, WeakReference<Context> weakReference) {
        this.f8052a = str;
        this.f8053b = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f8053b;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (n1.a(this.f8052a) <= y0.f8030b) {
            c.k.a.a.a.c.b("=====> do not need clean db");
            return;
        }
        d1 a2 = d1.a(this.f8052a);
        b1 a3 = b1.a(this.f8052a);
        a2.a(a3);
        a3.a(a1.a(context, this.f8052a, 1000));
        h1.a(context).a((h1.a) a2);
    }
}
