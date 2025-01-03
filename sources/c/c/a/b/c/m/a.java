package c.c.a.b.c.m;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<BitmapTeleporter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) c.c.a.b.c.o.v.a.a(parcel, a2, ParcelFileDescriptor.CREATOR);
            } else if (a3 != 3) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new BitmapTeleporter(i2, parcelFileDescriptor, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter[] newArray(int i2) {
        return new BitmapTeleporter[i2];
    }
}
