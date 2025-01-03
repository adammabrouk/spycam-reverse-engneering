package c.c.a.b.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzk;

/* loaded from: classes.dex */
public final class e0 implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            } else if (a3 == 2) {
                iBinder = c.c.a.b.c.o.v.a.x(parcel, a2);
            } else if (a3 == 3) {
                z = c.c.a.b.c.o.v.a.r(parcel, a2);
            } else if (a3 != 4) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                z2 = c.c.a.b.c.o.v.a.r(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzk(str, iBinder, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i2) {
        return new zzk[i2];
    }
}
