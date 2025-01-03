package c.c.a.b.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class ha implements Parcelable.Creator<zzy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzkn zzknVar = null;
        String str3 = null;
        zzaq zzaqVar = null;
        zzaq zzaqVar2 = null;
        zzaq zzaqVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 2:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 3:
                    str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 4:
                    zzknVar = (zzkn) c.c.a.b.c.o.v.a.a(parcel, a2, zzkn.CREATOR);
                    break;
                case 5:
                    j = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 6:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 7:
                    str3 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 8:
                    zzaqVar = (zzaq) c.c.a.b.c.o.v.a.a(parcel, a2, zzaq.CREATOR);
                    break;
                case 9:
                    j2 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 10:
                    zzaqVar2 = (zzaq) c.c.a.b.c.o.v.a.a(parcel, a2, zzaq.CREATOR);
                    break;
                case 11:
                    j3 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 12:
                    zzaqVar3 = (zzaq) c.c.a.b.c.o.v.a.a(parcel, a2, zzaq.CREATOR);
                    break;
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzy(str, str2, zzknVar, j, z, str3, zzaqVar, j2, zzaqVar2, j3, zzaqVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy[] newArray(int i2) {
        return new zzy[i2];
    }
}
