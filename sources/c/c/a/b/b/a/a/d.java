package c.c.a.b.b.a.a;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.a;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            switch (a.a(a2)) {
                case 1:
                    i2 = a.y(parcel, a2);
                    break;
                case 2:
                    arrayList = a.c(parcel, a2, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) a.a(parcel, a2, Account.CREATOR);
                    break;
                case 4:
                    z = a.r(parcel, a2);
                    break;
                case 5:
                    z2 = a.r(parcel, a2);
                    break;
                case 6:
                    z3 = a.r(parcel, a2);
                    break;
                case 7:
                    str = a.n(parcel, a2);
                    break;
                case 8:
                    str2 = a.n(parcel, a2);
                    break;
                case 9:
                    arrayList2 = a.c(parcel, a2, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    a.D(parcel, a2);
                    break;
            }
        }
        a.q(parcel, b2);
        return new GoogleSignInOptions(i2, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (ArrayList<GoogleSignInOptionsExtensionParcelable>) arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i2) {
        return new GoogleSignInOptions[i2];
    }
}
