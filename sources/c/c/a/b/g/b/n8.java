package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j8 f4958a;

    public n8(j8 j8Var) {
        this.f4958a = j8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r7 r7Var = this.f4958a.f4839c;
        Context d2 = this.f4958a.f4839c.d();
        this.f4958a.f4839c.F();
        r7Var.a(new ComponentName(d2, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
