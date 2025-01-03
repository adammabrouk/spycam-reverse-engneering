package c.c.a.b.c.o;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;

/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<AuthAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 1:
                    i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 2:
                    iBinder = c.c.a.b.c.o.v.a.x(parcel, a2);
                    break;
                case 3:
                    scopeArr = (Scope[]) c.c.a.b.c.o.v.a.b(parcel, a2, Scope.CREATOR);
                    break;
                case 4:
                    num = c.c.a.b.c.o.v.a.z(parcel, a2);
                    break;
                case 5:
                    num2 = c.c.a.b.c.o.v.a.z(parcel, a2);
                    break;
                case 6:
                    account = (Account) c.c.a.b.c.o.v.a.a(parcel, a2, Account.CREATOR);
                    break;
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new AuthAccountRequest(i2, iBinder, scopeArr, num, num2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest[] newArray(int i2) {
        return new AuthAccountRequest[i2];
    }
}
