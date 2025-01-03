package c.c.a.b.b.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        Bundle bundle = null;
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
                bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new GoogleSignInOptionsExtensionParcelable(i2, i3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable[] newArray(int i2) {
        return new GoogleSignInOptionsExtensionParcelable[i2];
    }
}
