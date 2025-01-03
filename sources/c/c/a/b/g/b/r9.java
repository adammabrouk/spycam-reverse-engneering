package c.c.a.b.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzkn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r9 implements Parcelable.Creator<zzkn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkn createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 1:
                    i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 2:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 3:
                    j = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 4:
                    l = c.c.a.b.c.o.v.a.B(parcel, a2);
                    break;
                case 5:
                    f2 = c.c.a.b.c.o.v.a.w(parcel, a2);
                    break;
                case 6:
                    str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 7:
                    str3 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 8:
                    d2 = c.c.a.b.c.o.v.a.u(parcel, a2);
                    break;
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzkn(i2, str, j, l, f2, str2, str3, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkn[] newArray(int i2) {
        return new zzkn[i2];
    }
}
