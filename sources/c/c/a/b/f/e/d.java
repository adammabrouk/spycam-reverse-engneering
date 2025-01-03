package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 1:
                    j = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 2:
                    j2 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 3:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 4:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 5:
                    str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 6:
                    str3 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 7:
                    bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
                    break;
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzaa(j, j2, z, str, str2, str3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaa[] newArray(int i2) {
        return new zzaa[i2];
    }
}
