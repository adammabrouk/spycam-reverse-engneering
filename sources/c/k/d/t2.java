package c.k.d;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import c.k.d.j;
import com.google.zxing.decoding.InactivityTimer;

/* loaded from: classes.dex */
public class t2 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile t2 f7873b;

    /* renamed from: a, reason: collision with root package name */
    public Context f7874a;

    public t2(Context context) {
        this.f7874a = context;
    }

    public static t2 a(Context context) {
        if (f7873b == null) {
            synchronized (t2.class) {
                if (f7873b == null) {
                    f7873b = new t2(context);
                }
            }
        }
        return f7873b;
    }

    public final int a(int i2) {
        return Math.max(60, i2);
    }

    public void a() {
        j.a(this.f7874a).a(new u2(this));
    }

    public final void a(c.k.d.p9.m mVar, j jVar, boolean z) {
        if (mVar.a(a7.UploadSwitch.a(), true)) {
            f3 f3Var = new f3(this.f7874a);
            if (z) {
                jVar.a((j.a) f3Var, a(mVar.a(a7.UploadFrequency.a(), 86400)));
            } else {
                jVar.m235a((j.a) f3Var);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m479a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                ((Application) (this.f7874a instanceof Application ? this.f7874a : this.f7874a.getApplicationContext())).registerActivityLifecycleCallbacks(new j2(this.f7874a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        return false;
    }

    public final void b() {
        j a2 = j.a(this.f7874a);
        c.k.d.p9.m a3 = c.k.d.p9.m.a(this.f7874a);
        SharedPreferences sharedPreferences = this.f7874a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(a7.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(a7.StorageCollectionFrequency.a(), 86400));
            a2.a(new d3(this.f7874a, a4), a4, 0);
        }
        boolean a5 = a3.a(a7.AppIsInstalledCollectionSwitch.a(), false);
        String a6 = a3.a(a7.AppIsInstalledList.a(), (String) null);
        if (a5 && !TextUtils.isEmpty(a6)) {
            int a7 = a(a3.a(a7.AppIsInstalledCollectionFrequency.a(), 86400));
            a2.a(new w2(this.f7874a, a7, a6), a7, 0);
        }
        if (a3.a(a7.LauncherAppListCollectionSwitch.a(), false)) {
            int a8 = a(a3.a(a7.LauncherAppListCollectionFrequency.a(), 86400));
            a2.a(new x2(this.f7874a, a8), a8, 0, true);
        }
        boolean a9 = a3.a(a7.ScreenSizeCollectionSwitch.a(), true);
        boolean a10 = a3.a(a7.AndroidVnCollectionSwitch.a(), true);
        boolean a11 = a3.a(a7.AndroidVcCollectionSwitch.a(), true);
        boolean a12 = a3.a(a7.AndroidIdCollectionSwitch.a(), true);
        boolean a13 = a3.a(a7.OperatorSwitch.a(), true);
        if (a9 || a10 || a11 || a12 || a13) {
            int a14 = a(a3.a(a7.DeviceInfoCollectionFrequency.a(), 1209600));
            a2.a(new c3(this.f7874a, a14, a9, a10, a11, a12, a13), a14, 0);
        }
        boolean a15 = a3.a(a7.MacCollectionSwitch.a(), false);
        boolean a16 = a3.a(a7.IMSICollectionSwitch.a(), false);
        boolean a17 = a3.a(a7.IccidCollectionSwitch.a(), false);
        boolean a18 = a3.a(a7.DeviceIdSwitch.a(), false);
        if (a15 || a16 || a17 || a18) {
            int a19 = a(a3.a(a7.DeviceBaseInfoCollectionFrequency.a(), 1209600));
            a2.a(new b3(this.f7874a, a19, a15, a16, a17, a18), a19, 0);
        }
        if (Build.VERSION.SDK_INT < 21 && a3.a(a7.AppActiveListCollectionSwitch.a(), false)) {
            int a20 = a(a3.a(a7.AppActiveListCollectionFrequency.a(), 900));
            a2.a(new v2(this.f7874a, a20), a20, 0);
        }
        if (a3.a(a7.TopAppCollectionSwitch.a(), false)) {
            int a21 = a(a3.a(a7.TopAppCollectionFrequency.a(), InactivityTimer.INACTIVITY_DELAY_SECONDS));
            a2.a(new e3(this.f7874a, a21), a21, 0);
        }
        if (a3.a(a7.BroadcastActionCollectionSwitch.a(), true)) {
            int a22 = a(a3.a(a7.BroadcastActionCollectionFrequency.a(), 900));
            a2.a(new z2(this.f7874a, a22), a22, 0);
        }
        if (a3.a(a7.ActivityTSSwitch.a(), false)) {
            m479a();
        }
        if (a3.a(a7.BatteryCollectionSwitch.a(), false)) {
            int a23 = a(a3.a(a7.BatteryCollectionFrequency.a(), 3600));
            a2.a(new y2(this.f7874a, a23), a23, 0);
        }
        a(a3, a2, true);
    }
}
