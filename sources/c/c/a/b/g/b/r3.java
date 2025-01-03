package c.c.a.b.g.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class r3 extends c.c.a.b.f.e.j1 implements o3 {
    public r3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // c.c.a.b.f.e.j1
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                a((zzaq) c.c.a.b.f.e.s.a(parcel, zzaq.CREATOR), (zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                a((zzkn) c.c.a.b.f.e.s.a(parcel, zzkn.CREATOR), (zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                d((zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                a((zzaq) c.c.a.b.f.e.s.a(parcel, zzaq.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                a((zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkn> a2 = a((zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR), c.c.a.b.f.e.s.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a2);
                return true;
            case 9:
                byte[] a3 = a((zzaq) c.c.a.b.f.e.s.a(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a3);
                return true;
            case 10:
                a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String b2 = b((zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            case 12:
                a((zzy) c.c.a.b.f.e.s.a(parcel, zzy.CREATOR), (zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                a((zzy) c.c.a.b.f.e.s.a(parcel, zzy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkn> a4 = a(parcel.readString(), parcel.readString(), c.c.a.b.f.e.s.a(parcel), (zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a4);
                return true;
            case 15:
                List<zzkn> a5 = a(parcel.readString(), parcel.readString(), parcel.readString(), c.c.a.b.f.e.s.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a5);
                return true;
            case 16:
                List<zzy> a6 = a(parcel.readString(), parcel.readString(), (zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a6);
                return true;
            case 17:
                List<zzy> b3 = b(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(b3);
                return true;
            case 18:
                c((zzm) c.c.a.b.f.e.s.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
