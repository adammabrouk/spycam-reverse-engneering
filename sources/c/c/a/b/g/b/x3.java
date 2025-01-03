package c.c.a.b.g.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.c.a.b.c.o.c;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x3 extends c.c.a.b.c.o.c<o3> {
    public x3(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    @Override // c.c.a.b.c.o.c
    public final /* synthetic */ o3 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof o3 ? (o3) queryLocalInterface : new q3(iBinder);
    }

    @Override // c.c.a.b.c.o.c
    public final String b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // c.c.a.b.c.o.c, c.c.a.b.c.l.a.f
    public final int d() {
        return c.c.a.b.c.h.f3820a;
    }

    @Override // c.c.a.b.c.o.c
    public final String k() {
        return "com.google.android.gms.measurement.START";
    }
}
