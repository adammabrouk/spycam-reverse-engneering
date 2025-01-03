package cn.jpush.android.bd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.hjq.permissions.Permission;

/* loaded from: classes.dex */
public class c {
    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        if (locationManager == null || !b(context, locationManager)) {
            return null;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
        Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
        Location lastKnownLocation3 = locationManager.getLastKnownLocation("passive");
        Logger.v("GeoLocHelper", "gpsLocation:" + lastKnownLocation);
        Logger.v("GeoLocHelper", "netLocation:" + lastKnownLocation2);
        Logger.v("GeoLocHelper", "passLocation:" + lastKnownLocation3);
        long time = lastKnownLocation == null ? 0L : lastKnownLocation.getTime();
        long time2 = lastKnownLocation2 == null ? 0L : lastKnownLocation2.getTime();
        long time3 = lastKnownLocation3 != null ? lastKnownLocation3.getTime() : 0L;
        if (time > time2) {
            if (time > time3) {
                return lastKnownLocation;
            }
        } else if (time2 > time3) {
            return lastKnownLocation2;
        }
        return lastKnownLocation3;
    }

    public static boolean b(Context context, LocationManager locationManager) {
        if (!cn.jpush.android.bm.a.b(context, Permission.ACCESS_FINE_LOCATION)) {
            Logger.w("GeoLocHelper", "Require the permissionandroid.permission.ACCESS_FINE_LOCATION");
            Logger.dd("GeoLocHelper", "No location permission!");
            return false;
        }
        if (!JPushConstants.canGetLbsInBackGround(context)) {
            Logger.ww("GeoLocHelper", "can not get lbs in background");
            return false;
        }
        if (!cn.jpush.android.cache.a.o(context)) {
            Logger.ww("GeoLocHelper", "lbs is disable by user");
            return false;
        }
        if (locationManager != null) {
            try {
                if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                    if (!locationManager.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            } catch (IllegalArgumentException unused) {
                Logger.ww("GeoLocHelper", "The provider [gps] is illegal argument!");
                return false;
            } catch (SecurityException unused2) {
                Logger.ww("GeoLocHelper", "No suitable permission is present when get GPS_PROVIDER!");
            } catch (Throwable th) {
                Logger.ww("GeoLocHelper", "Check GPS enable failed:" + th);
                return false;
            }
        }
        return false;
    }
}
