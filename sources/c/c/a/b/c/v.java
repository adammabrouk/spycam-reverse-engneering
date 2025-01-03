package c.c.a.b.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class v implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String str = null;
        int i2 = 0;
        long j = -1;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            } else if (a3 == 2) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 3) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                j = c.c.a.b.c.o.v.a.A(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new Feature(str, i2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i2) {
        return new Feature[i2];
    }
}
