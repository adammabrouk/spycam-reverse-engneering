package c.c.a.b.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class u implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 3) {
                pendingIntent = (PendingIntent) c.c.a.b.c.o.v.a.a(parcel, a2, PendingIntent.CREATOR);
            } else if (a3 != 4) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new ConnectionResult(i2, i3, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult[] newArray(int i2) {
        return new ConnectionResult[i2];
    }
}
