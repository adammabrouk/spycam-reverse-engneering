package c.c.a.b.g.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            if (c.c.a.b.c.o.v.a.a(a2) != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zzal(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i2) {
        return new zzal[i2];
    }
}
