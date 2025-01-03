package c.c.a.b.c.l;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class n implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                str = c.c.a.b.c.o.v.a.n(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new Scope(i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
