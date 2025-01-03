package c.c.a.b.c.o;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzb;

/* loaded from: classes.dex */
public final class g0 implements Parcelable.Creator<zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
            } else if (a3 != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                featureArr = (Feature[]) c.c.a.b.c.o.v.a.b(parcel, a2, Feature.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzb(bundle, featureArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i2) {
        return new zzb[i2];
    }
}
