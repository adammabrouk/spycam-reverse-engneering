package c.c.a.b.c.q.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                stringToIntConverter = (StringToIntConverter) c.c.a.b.c.o.v.a.a(parcel, a2, StringToIntConverter.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new zaa(i2, stringToIntConverter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i2) {
        return new zaa[i2];
    }
}
