package c.c.a.b.c.o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzr;

/* loaded from: classes.dex */
public final class u0 implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            if (c.c.a.b.c.o.v.a.a(a2) != 1) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzr(i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i2) {
        return new zzr[i2];
    }
}
