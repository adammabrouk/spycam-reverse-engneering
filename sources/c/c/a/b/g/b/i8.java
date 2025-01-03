package c.c.a.b.g.b;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class i8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4810a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4811b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzm f4812c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ yc f4813d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r7 f4814e;

    public i8(r7 r7Var, String str, String str2, zzm zzmVar, yc ycVar) {
        this.f4814e = r7Var;
        this.f4810a = str;
        this.f4811b = str2;
        this.f4812c = zzmVar;
        this.f4813d = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            o3Var = this.f4814e.f5045d;
            if (o3Var == null) {
                this.f4814e.c().t().a("Failed to get conditional properties; not connected to service", this.f4810a, this.f4811b);
                return;
            }
            ArrayList<Bundle> b2 = s9.b(o3Var.a(this.f4810a, this.f4811b, this.f4812c));
            this.f4814e.K();
            this.f4814e.j().a(this.f4813d, b2);
        } catch (RemoteException e2) {
            this.f4814e.c().t().a("Failed to get conditional properties; remote exception", this.f4810a, this.f4811b, e2);
        } finally {
            this.f4814e.j().a(this.f4813d, arrayList);
        }
    }
}
