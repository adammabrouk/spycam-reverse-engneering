package c.c.a.b.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zaa;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 3) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                intent = (Intent) c.c.a.b.c.o.v.a.a(parcel, a2, Intent.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zaa(i2, i3, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i2) {
        return new zaa[i2];
    }
}
