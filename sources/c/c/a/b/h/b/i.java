package c.c.a.b.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<zaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                connectionResult = (ConnectionResult) c.c.a.b.c.o.v.a.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 != 3) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) c.c.a.b.c.o.v.a.a(parcel, a2, ResolveAccountResponse.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zaj(i2, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj[] newArray(int i2) {
        return new zaj[i2];
    }
}
