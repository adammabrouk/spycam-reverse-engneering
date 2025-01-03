package c.c.a.b.c.o;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

/* loaded from: classes.dex */
public final class h0 implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
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
                    i4 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 4:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 5:
                    iBinder = c.c.a.b.c.o.v.a.x(parcel, a2);
                    break;
                case 6:
                    scopeArr = (Scope[]) c.c.a.b.c.o.v.a.b(parcel, a2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
                    break;
                case 8:
                    account = (Account) c.c.a.b.c.o.v.a.a(parcel, a2, Account.CREATOR);
                    break;
                case 9:
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
                case 10:
                    featureArr = (Feature[]) c.c.a.b.c.o.v.a.b(parcel, a2, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) c.c.a.b.c.o.v.a.b(parcel, a2, Feature.CREATOR);
                    break;
                case 12:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
