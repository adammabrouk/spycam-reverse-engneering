package c.c.a.b.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y9 implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j6 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 5:
                    str4 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 6:
                    j = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 7:
                    j2 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 8:
                    str5 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 9:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 10:
                    z2 = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 11:
                    j6 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 12:
                    str6 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 13:
                    j3 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 14:
                    j4 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 15:
                    i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 16:
                    z3 = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 17:
                    z4 = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 18:
                    z5 = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 19:
                    str7 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 20:
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
                case 21:
                    bool = c.c.a.b.c.o.v.a.s(parcel, a2);
                    break;
                case 22:
                    j5 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 23:
                    arrayList = c.c.a.b.c.o.v.a.p(parcel, a2);
                    break;
                case 24:
                    str8 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzm(str, str2, str3, str4, j, j2, str5, z, z2, j6, str6, j3, j4, i2, z3, z4, z5, str7, bool, j5, arrayList, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i2) {
        return new zzm[i2];
    }
}
