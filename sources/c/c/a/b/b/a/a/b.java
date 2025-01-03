package c.c.a.b.b.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            switch (a.a(a2)) {
                case 1:
                    i2 = a.y(parcel, a2);
                    break;
                case 2:
                    str = a.n(parcel, a2);
                    break;
                case 3:
                    str2 = a.n(parcel, a2);
                    break;
                case 4:
                    str3 = a.n(parcel, a2);
                    break;
                case 5:
                    str4 = a.n(parcel, a2);
                    break;
                case 6:
                    uri = (Uri) a.a(parcel, a2, Uri.CREATOR);
                    break;
                case 7:
                    str5 = a.n(parcel, a2);
                    break;
                case 8:
                    j = a.A(parcel, a2);
                    break;
                case 9:
                    str6 = a.n(parcel, a2);
                    break;
                case 10:
                    arrayList = a.c(parcel, a2, Scope.CREATOR);
                    break;
                case 11:
                    str7 = a.n(parcel, a2);
                    break;
                case 12:
                    str8 = a.n(parcel, a2);
                    break;
                default:
                    a.D(parcel, a2);
                    break;
            }
        }
        a.q(parcel, b2);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
