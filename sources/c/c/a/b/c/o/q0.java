package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class q0 extends c.c.a.b.f.c.b implements p0 {
    public static p0 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof p0 ? (p0) queryLocalInterface : new r0(iBinder);
    }
}
