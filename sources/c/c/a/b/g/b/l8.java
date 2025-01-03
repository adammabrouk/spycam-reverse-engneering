package c.c.a.b.g.b;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f4899a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j8 f4900b;

    public l8(j8 j8Var, ComponentName componentName) {
        this.f4900b = j8Var;
        this.f4899a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4900b.f4839c.a(this.f4899a);
    }
}
