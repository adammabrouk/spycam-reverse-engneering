package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.c.a.b.d.a;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class wc extends j1 implements xc {
    public wc() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static xc asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof xc ? (xc) queryLocalInterface : new zc(iBinder);
    }

    @Override // c.c.a.b.f.e.j1
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        yc adVar;
        yc ycVar = null;
        yc ycVar2 = null;
        yc ycVar3 = null;
        dd ddVar = null;
        dd ddVar2 = null;
        dd ddVar3 = null;
        yc ycVar4 = null;
        yc ycVar5 = null;
        yc ycVar6 = null;
        yc ycVar7 = null;
        yc ycVar8 = null;
        yc ycVar9 = null;
        ed edVar = null;
        yc ycVar10 = null;
        yc ycVar11 = null;
        yc ycVar12 = null;
        yc ycVar13 = null;
        switch (i2) {
            case 1:
                initialize(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), (zzaa) s.a(parcel, zzaa.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) s.a(parcel, Bundle.CREATOR), s.a(parcel), s.a(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) s.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    adVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    adVar = queryLocalInterface instanceof yc ? (yc) queryLocalInterface : new ad(readStrongBinder);
                }
                logEventAndBundle(readString, readString2, bundle, adVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), a.AbstractBinderC0092a.a(parcel.readStrongBinder()), s.a(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean a2 = s.a(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar = queryLocalInterface2 instanceof yc ? (yc) queryLocalInterface2 : new ad(readStrongBinder2);
                }
                getUserProperties(readString3, readString4, a2, ycVar);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar13 = queryLocalInterface3 instanceof yc ? (yc) queryLocalInterface3 : new ad(readStrongBinder3);
                }
                getMaxUserProperties(readString5, ycVar13);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) s.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) s.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar12 = queryLocalInterface4 instanceof yc ? (yc) queryLocalInterface4 : new ad(readStrongBinder4);
                }
                getConditionalUserProperties(readString6, readString7, ycVar12);
                break;
            case 11:
                setMeasurementEnabled(s.a(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar11 = queryLocalInterface5 instanceof yc ? (yc) queryLocalInterface5 : new ad(readStrongBinder5);
                }
                getCurrentScreenName(ycVar11);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar10 = queryLocalInterface6 instanceof yc ? (yc) queryLocalInterface6 : new ad(readStrongBinder6);
                }
                getCurrentScreenClass(ycVar10);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    edVar = queryLocalInterface7 instanceof ed ? (ed) queryLocalInterface7 : new b(readStrongBinder7);
                }
                setInstanceIdProvider(edVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar9 = queryLocalInterface8 instanceof yc ? (yc) queryLocalInterface8 : new ad(readStrongBinder8);
                }
                getCachedAppInstanceId(ycVar9);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar8 = queryLocalInterface9 instanceof yc ? (yc) queryLocalInterface9 : new ad(readStrongBinder9);
                }
                getAppInstanceId(ycVar8);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar7 = queryLocalInterface10 instanceof yc ? (yc) queryLocalInterface10 : new ad(readStrongBinder10);
                }
                getGmpAppId(ycVar7);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar6 = queryLocalInterface11 instanceof yc ? (yc) queryLocalInterface11 : new ad(readStrongBinder11);
                }
                generateEventId(ycVar6);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), (Bundle) s.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(a.AbstractBinderC0092a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar5 = queryLocalInterface12 instanceof yc ? (yc) queryLocalInterface12 : new ad(readStrongBinder12);
                }
                onActivitySaveInstanceState(a3, ycVar5, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) s.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar4 = queryLocalInterface13 instanceof yc ? (yc) queryLocalInterface13 : new ad(readStrongBinder13);
                }
                performAction(bundle2, ycVar4, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), a.AbstractBinderC0092a.a(parcel.readStrongBinder()), a.AbstractBinderC0092a.a(parcel.readStrongBinder()), a.AbstractBinderC0092a.a(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ddVar3 = queryLocalInterface14 instanceof dd ? (dd) queryLocalInterface14 : new fd(readStrongBinder14);
                }
                setEventInterceptor(ddVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ddVar2 = queryLocalInterface15 instanceof dd ? (dd) queryLocalInterface15 : new fd(readStrongBinder15);
                }
                registerOnMeasurementEventListener(ddVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ddVar = queryLocalInterface16 instanceof dd ? (dd) queryLocalInterface16 : new fd(readStrongBinder16);
                }
                unregisterOnMeasurementEventListener(ddVar);
                break;
            case 37:
                initForTests(s.b(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar3 = queryLocalInterface17 instanceof yc ? (yc) queryLocalInterface17 : new ad(readStrongBinder17);
                }
                getTestFlag(ycVar3, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(s.a(parcel));
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    ycVar2 = queryLocalInterface18 instanceof yc ? (yc) queryLocalInterface18 : new ad(readStrongBinder18);
                }
                isDataCollectionEnabled(ycVar2);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) s.a(parcel, Bundle.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
