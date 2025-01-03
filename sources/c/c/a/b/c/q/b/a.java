package c.c.a.b.c.q.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 1:
                    i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 2:
                    i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 3:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 4:
                    i4 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 5:
                    z2 = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
                case 6:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 7:
                    i5 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 8:
                    str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 9:
                    zaaVar = (zaa) c.c.a.b.c.o.v.a.a(parcel, a2, zaa.CREATOR);
                    break;
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new FastJsonResponse.Field(i2, i3, z, i4, z2, str, i5, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
