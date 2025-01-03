package c.c.a.b.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String str = null;
        zzal zzalVar = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 2) {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            } else if (a3 == 3) {
                zzalVar = (zzal) c.c.a.b.c.o.v.a.a(parcel, a2, zzal.CREATOR);
            } else if (a3 == 4) {
                str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
            } else if (a3 != 5) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                j = c.c.a.b.c.o.v.a.A(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzaq(str, zzalVar, str2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i2) {
        return new zzaq[i2];
    }
}
