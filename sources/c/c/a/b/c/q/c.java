package c.c.a.b.c.q;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.a;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<FavaDiagnosticsEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FavaDiagnosticsEntity createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i2 = a.y(parcel, a2);
            } else if (a3 == 2) {
                str = a.n(parcel, a2);
            } else if (a3 != 3) {
                a.D(parcel, a2);
            } else {
                i3 = a.y(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new FavaDiagnosticsEntity(i2, str, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FavaDiagnosticsEntity[] newArray(int i2) {
        return new FavaDiagnosticsEntity[i2];
    }
}
