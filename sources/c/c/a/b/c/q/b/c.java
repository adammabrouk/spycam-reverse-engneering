package c.c.a.b.c.q.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.zak;
import com.google.android.gms.common.server.response.zal;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        ArrayList arrayList = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                arrayList = c.c.a.b.c.o.v.a.c(parcel, a2, zal.CREATOR);
            } else if (a3 != 3) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zak(i2, arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i2) {
        return new zak[i2];
    }
}
