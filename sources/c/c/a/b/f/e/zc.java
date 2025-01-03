package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzaa;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class zc extends a implements xc {
    public zc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // c.c.a.b.f.e.xc
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeLong(j);
        b(23, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, bundle);
        b(9, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeLong(j);
        b(24, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void generateEventId(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(22, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getAppInstanceId(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(20, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getCachedAppInstanceId(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(19, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getConditionalUserProperties(String str, String str2, yc ycVar) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, ycVar);
        b(10, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getCurrentScreenClass(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(17, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getCurrentScreenName(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(16, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getGmpAppId(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(21, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getMaxUserProperties(String str, yc ycVar) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        s.a(f2, ycVar);
        b(6, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getTestFlag(yc ycVar, int i2) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        f2.writeInt(i2);
        b(38, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void getUserProperties(String str, String str2, boolean z, yc ycVar) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, z);
        s.a(f2, ycVar);
        b(5, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void initForTests(Map map) throws RemoteException {
        Parcel f2 = f();
        f2.writeMap(map);
        b(37, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void initialize(c.c.a.b.d.a aVar, zzaa zzaaVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        s.a(f2, zzaaVar);
        f2.writeLong(j);
        b(1, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void isDataCollectionEnabled(yc ycVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ycVar);
        b(40, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, bundle);
        s.a(f2, z);
        s.a(f2, z2);
        f2.writeLong(j);
        b(2, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void logEventAndBundle(String str, String str2, Bundle bundle, yc ycVar, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, bundle);
        s.a(f2, ycVar);
        f2.writeLong(j);
        b(3, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void logHealthData(int i2, String str, c.c.a.b.d.a aVar, c.c.a.b.d.a aVar2, c.c.a.b.d.a aVar3) throws RemoteException {
        Parcel f2 = f();
        f2.writeInt(i2);
        f2.writeString(str);
        s.a(f2, aVar);
        s.a(f2, aVar2);
        s.a(f2, aVar3);
        b(33, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityCreated(c.c.a.b.d.a aVar, Bundle bundle, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        s.a(f2, bundle);
        f2.writeLong(j);
        b(27, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityDestroyed(c.c.a.b.d.a aVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeLong(j);
        b(28, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityPaused(c.c.a.b.d.a aVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeLong(j);
        b(29, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityResumed(c.c.a.b.d.a aVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeLong(j);
        b(30, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivitySaveInstanceState(c.c.a.b.d.a aVar, yc ycVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        s.a(f2, ycVar);
        f2.writeLong(j);
        b(31, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityStarted(c.c.a.b.d.a aVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeLong(j);
        b(25, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void onActivityStopped(c.c.a.b.d.a aVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeLong(j);
        b(26, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void performAction(Bundle bundle, yc ycVar, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, bundle);
        s.a(f2, ycVar);
        f2.writeLong(j);
        b(32, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void registerOnMeasurementEventListener(dd ddVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ddVar);
        b(35, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeLong(j);
        b(12, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, bundle);
        f2.writeLong(j);
        b(8, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setCurrentScreen(c.c.a.b.d.a aVar, String str, String str2, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, aVar);
        f2.writeString(str);
        f2.writeString(str2);
        f2.writeLong(j);
        b(15, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, z);
        b(39, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, bundle);
        b(42, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setEventInterceptor(dd ddVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ddVar);
        b(34, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setInstanceIdProvider(ed edVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, edVar);
        b(18, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, z);
        f2.writeLong(j);
        b(11, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeLong(j);
        b(13, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeLong(j);
        b(14, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeLong(j);
        b(7, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void setUserProperty(String str, String str2, c.c.a.b.d.a aVar, boolean z, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, aVar);
        s.a(f2, z);
        f2.writeLong(j);
        b(4, f2);
    }

    @Override // c.c.a.b.f.e.xc
    public final void unregisterOnMeasurementEventListener(dd ddVar) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, ddVar);
        b(36, f2);
    }
}
