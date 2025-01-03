package c.c.a.b.c.m;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                strArr = c.c.a.b.c.o.v.a.o(parcel, a2);
            } else if (a3 == 2) {
                cursorWindowArr = (CursorWindow[]) c.c.a.b.c.o.v.a.b(parcel, a2, CursorWindow.CREATOR);
            } else if (a3 == 3) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 4) {
                bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
            } else if (a3 != 1000) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.x();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i2) {
        return new DataHolder[i2];
    }
}
