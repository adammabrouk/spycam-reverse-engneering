package c.c.a.b.c.r;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int b2 = c.c.a.b.c.o.v.a.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = c.c.a.b.c.o.v.a.a(parcel);
            switch (c.c.a.b.c.o.v.a.a(a2)) {
                case 1:
                    i2 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 2:
                    j = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    c.c.a.b.c.o.v.a.D(parcel, a2);
                    break;
                case 4:
                    str = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 5:
                    i4 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 6:
                    arrayList = c.c.a.b.c.o.v.a.p(parcel, a2);
                    break;
                case 8:
                    j2 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 10:
                    str3 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 11:
                    i3 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 12:
                    str2 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 13:
                    str4 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 14:
                    i5 = c.c.a.b.c.o.v.a.y(parcel, a2);
                    break;
                case 15:
                    f2 = c.c.a.b.c.o.v.a.v(parcel, a2);
                    break;
                case 16:
                    j3 = c.c.a.b.c.o.v.a.A(parcel, a2);
                    break;
                case 17:
                    str5 = c.c.a.b.c.o.v.a.n(parcel, a2);
                    break;
                case 18:
                    z = c.c.a.b.c.o.v.a.r(parcel, a2);
                    break;
            }
        }
        c.c.a.b.c.o.v.a.q(parcel, b2);
        return new WakeLockEvent(i2, j, i3, str, i4, arrayList, str2, j2, i5, str3, str4, f2, j3, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
