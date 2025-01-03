package c.c.a.b.g.b;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public interface o3 extends IInterface {
    List<zzkn> a(zzm zzmVar, boolean z) throws RemoteException;

    List<zzy> a(String str, String str2, zzm zzmVar) throws RemoteException;

    List<zzkn> a(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkn> a(String str, String str2, boolean z, zzm zzmVar) throws RemoteException;

    void a(long j, String str, String str2, String str3) throws RemoteException;

    void a(zzaq zzaqVar, zzm zzmVar) throws RemoteException;

    void a(zzaq zzaqVar, String str, String str2) throws RemoteException;

    void a(zzkn zzknVar, zzm zzmVar) throws RemoteException;

    void a(zzm zzmVar) throws RemoteException;

    void a(zzy zzyVar) throws RemoteException;

    void a(zzy zzyVar, zzm zzmVar) throws RemoteException;

    byte[] a(zzaq zzaqVar, String str) throws RemoteException;

    String b(zzm zzmVar) throws RemoteException;

    List<zzy> b(String str, String str2, String str3) throws RemoteException;

    void c(zzm zzmVar) throws RemoteException;

    void d(zzm zzmVar) throws RemoteException;
}
