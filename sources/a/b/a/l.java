package a.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import cn.jiguang.internal.JConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hjq.permissions.Permission;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public static l f193d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f194a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f195b;

    /* renamed from: c, reason: collision with root package name */
    public final a f196c = new a();

    /* compiled from: TwilightManager.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f197a;

        /* renamed from: b, reason: collision with root package name */
        public long f198b;

        /* renamed from: c, reason: collision with root package name */
        public long f199c;

        /* renamed from: d, reason: collision with root package name */
        public long f200d;

        /* renamed from: e, reason: collision with root package name */
        public long f201e;

        /* renamed from: f, reason: collision with root package name */
        public long f202f;
    }

    public l(Context context, LocationManager locationManager) {
        this.f194a = context;
        this.f195b = locationManager;
    }

    public static l a(Context context) {
        if (f193d == null) {
            Context applicationContext = context.getApplicationContext();
            f193d = new l(applicationContext, (LocationManager) applicationContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION));
        }
        return f193d;
    }

    public boolean b() {
        a aVar = this.f196c;
        if (c()) {
            return aVar.f197a;
        }
        Location a2 = a();
        if (a2 != null) {
            a(a2);
            return aVar.f197a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }

    public final boolean c() {
        return this.f196c.f202f > System.currentTimeMillis();
    }

    @SuppressLint({"MissingPermission"})
    public final Location a() {
        Location a2 = a.h.b.c.a(this.f194a, Permission.ACCESS_COARSE_LOCATION) == 0 ? a("network") : null;
        Location a3 = a.h.b.c.a(this.f194a, Permission.ACCESS_FINE_LOCATION) == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    public final Location a(String str) {
        try {
            if (this.f195b.isProviderEnabled(str)) {
                return this.f195b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    public final void a(Location location) {
        long j;
        a aVar = this.f196c;
        long currentTimeMillis = System.currentTimeMillis();
        k a2 = k.a();
        a2.a(currentTimeMillis - JConstants.DAY, location.getLatitude(), location.getLongitude());
        long j2 = a2.f190a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f192c == 1;
        long j3 = a2.f191b;
        long j4 = a2.f190a;
        boolean z2 = z;
        a2.a(JConstants.DAY + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.f191b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + JConstants.MIN;
        }
        aVar.f197a = z2;
        aVar.f198b = j2;
        aVar.f199c = j3;
        aVar.f200d = j4;
        aVar.f201e = j5;
        aVar.f202f = j;
    }
}
