package c.c.a.b.g.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q3 extends c.c.a.b.f.e.a implements o3 {
    public q3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzaq zzaqVar, zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzaqVar);
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(1, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final String b(zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzmVar);
        Parcel a2 = a(11, f2);
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // c.c.a.b.g.b.o3
    public final void c(zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(18, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final void d(zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(4, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzkn zzknVar, zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzknVar);
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(2, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzy> b(String str, String str2, String str3) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        f2.writeString(str3);
        Parcel a2 = a(17, f2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzy.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzaq zzaqVar, String str, String str2) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzaqVar);
        f2.writeString(str);
        f2.writeString(str2);
        b(5, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(6, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(zzm zzmVar, boolean z) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzmVar);
        c.c.a.b.f.e.s.a(f2, z);
        Parcel a2 = a(7, f2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzkn.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    @Override // c.c.a.b.g.b.o3
    public final byte[] a(zzaq zzaqVar, String str) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzaqVar);
        f2.writeString(str);
        Parcel a2 = a(9, f2);
        byte[] createByteArray = a2.createByteArray();
        a2.recycle();
        return createByteArray;
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(long j, String str, String str2, String str3) throws RemoteException {
        Parcel f2 = f();
        f2.writeLong(j);
        f2.writeString(str);
        f2.writeString(str2);
        f2.writeString(str3);
        b(10, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzy zzyVar, zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzyVar);
        c.c.a.b.f.e.s.a(f2, zzmVar);
        b(12, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzy zzyVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.e.s.a(f2, zzyVar);
        b(13, f2);
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(String str, String str2, boolean z, zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        c.c.a.b.f.e.s.a(f2, z);
        c.c.a.b.f.e.s.a(f2, zzmVar);
        Parcel a2 = a(14, f2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzkn.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        f2.writeString(str3);
        c.c.a.b.f.e.s.a(f2, z);
        Parcel a2 = a(15, f2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzkn.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzy> a(String str, String str2, zzm zzmVar) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        c.c.a.b.f.e.s.a(f2, zzmVar);
        Parcel a2 = a(16, f2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzy.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }
}
