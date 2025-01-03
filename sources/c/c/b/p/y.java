package c.c.b.p;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.RemoteMessage;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            if (c.c.a.b.c.o.v.a.a(a2) != 2) {
                c.c.a.b.c.o.v.a.D(parcel, a2);
            } else {
                bundle = c.c.a.b.c.o.v.a.f(parcel, a2);
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new RemoteMessage(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
