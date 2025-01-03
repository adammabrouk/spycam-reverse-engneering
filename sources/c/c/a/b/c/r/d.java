package c.c.a.b.c.r;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.b.c.s.t;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f4007a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f4008b;

    public static d a() {
        return f4007a;
    }

    public static boolean b() {
        if (f4008b == null) {
            f4008b = false;
        }
        return f4008b.booleanValue();
    }

    public void a(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        a(context, str, i2, str2, str3, str4, i3, list, 0L);
    }

    public void a(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j) {
        if (b()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                a(context, new WakeLockEvent(System.currentTimeMillis(), i2, str2, i3, c.a(list), str, SystemClock.elapsedRealtime(), t.a(context), str3, c.a(context.getPackageName()), t.b(context), j, str4, false));
            }
        }
    }

    public static void a(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(b.f4006a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e2) {
            Log.wtf("WakeLockTracker", e2);
        }
    }
}
