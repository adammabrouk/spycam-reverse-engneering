package c.c.a.b.c.q.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<StringToIntConverter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                arrayList = c.c.a.b.c.o.v.a.c(parcel, a2, StringToIntConverter.zaa.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new StringToIntConverter(i2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter[] newArray(int i2) {
        return new StringToIntConverter[i2];
    }
}
