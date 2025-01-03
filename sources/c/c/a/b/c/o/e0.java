package c.c.a.b.c.o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;

/* loaded from: classes.dex */
public final class e0 implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 3) {
                i4 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 4) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                scopeArr = (Scope[]) c.c.a.b.c.o.v.a.b(parcel, a2, Scope.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new SignInButtonConfig(i2, i3, i4, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }
}
