package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

/* loaded from: classes.dex */
public final class d0 implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                iBinder = c.c.a.b.c.o.v.a.x(parcel, a2);
            } else if (a3 == 3) {
                connectionResult = (ConnectionResult) c.c.a.b.c.o.v.a.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 == 4) {
                z = c.c.a.b.c.o.v.a.r(parcel, a2);
            } else if (a3 != 5) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                z2 = c.c.a.b.c.o.v.a.r(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new ResolveAccountResponse(i2, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i2) {
        return new ResolveAccountResponse[i2];
    }
}
