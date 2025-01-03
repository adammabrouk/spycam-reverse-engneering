package c.c.a.b.g.b;

import android.os.RemoteException;
import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class w7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f5163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yc f5164b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r7 f5165c;

    public w7(r7 r7Var, zzm zzmVar, yc ycVar) {
        this.f5165c = r7Var;
        this.f5163a = zzmVar;
        this.f5164b = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        try {
            o3Var = this.f5165c.f5045d;
            if (o3Var == null) {
                this.f5165c.c().t().a("Failed to get app instance id");
                return;
            }
            String b2 = o3Var.b(this.f5163a);
            if (b2 != null) {
                this.f5165c.o().a(b2);
                this.f5165c.k().l.a(b2);
            }
            this.f5165c.K();
            this.f5165c.j().a(this.f5164b, b2);
        } catch (RemoteException e2) {
            this.f5165c.c().t().a("Failed to get app instance id", e2);
        } finally {
            this.f5165c.j().a(this.f5164b, (String) null);
        }
    }
}
