package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzaa;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public interface xc extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(yc ycVar) throws RemoteException;

    void getAppInstanceId(yc ycVar) throws RemoteException;

    void getCachedAppInstanceId(yc ycVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, yc ycVar) throws RemoteException;

    void getCurrentScreenClass(yc ycVar) throws RemoteException;

    void getCurrentScreenName(yc ycVar) throws RemoteException;

    void getGmpAppId(yc ycVar) throws RemoteException;

    void getMaxUserProperties(String str, yc ycVar) throws RemoteException;

    void getTestFlag(yc ycVar, int i2) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, yc ycVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(c.c.a.b.d.a aVar, zzaa zzaaVar, long j) throws RemoteException;

    void isDataCollectionEnabled(yc ycVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, yc ycVar, long j) throws RemoteException;

    void logHealthData(int i2, String str, c.c.a.b.d.a aVar, c.c.a.b.d.a aVar2, c.c.a.b.d.a aVar3) throws RemoteException;

    void onActivityCreated(c.c.a.b.d.a aVar, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(c.c.a.b.d.a aVar, long j) throws RemoteException;

    void onActivityPaused(c.c.a.b.d.a aVar, long j) throws RemoteException;

    void onActivityResumed(c.c.a.b.d.a aVar, long j) throws RemoteException;

    void onActivitySaveInstanceState(c.c.a.b.d.a aVar, yc ycVar, long j) throws RemoteException;

    void onActivityStarted(c.c.a.b.d.a aVar, long j) throws RemoteException;

    void onActivityStopped(c.c.a.b.d.a aVar, long j) throws RemoteException;

    void performAction(Bundle bundle, yc ycVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(dd ddVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(c.c.a.b.d.a aVar, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(dd ddVar) throws RemoteException;

    void setInstanceIdProvider(ed edVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, c.c.a.b.d.a aVar, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(dd ddVar) throws RemoteException;
}
