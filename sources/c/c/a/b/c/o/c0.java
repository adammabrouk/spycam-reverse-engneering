package c.c.a.b.c.o;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;

/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<ResolveAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            int a3 = c.c.a.b.c.o.v.a.a(a2);
            if (a3 == 1) {
                i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 == 2) {
                account = (Account) c.c.a.b.c.o.v.a.a(parcel, a2, Account.CREATOR);
            } else if (a3 == 3) {
                i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
            } else if (a3 != 4) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                googleSignInAccount = (GoogleSignInAccount) c.c.a.b.c.o.v.a.a(parcel, a2, GoogleSignInAccount.CREATOR);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new ResolveAccountRequest(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest[] newArray(int i2) {
        return new ResolveAccountRequest[i2];
    }
}
