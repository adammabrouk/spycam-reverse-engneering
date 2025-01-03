package c.c.a.b.c.n;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<WebImage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        Uri uri = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                uri = (Uri) c.c.a.b.c.o.v.a.a(parcel, a2, Uri.CREATOR);
            } else if (a3 == 3) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 4) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                i4 = c.c.a.b.c.o.v.a.y(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new WebImage(i2, uri, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i2) {
        return new WebImage[i2];
    }
}
