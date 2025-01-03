package c.c.a.b.c.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static long f4027b;

    /* renamed from: a, reason: collision with root package name */
    public static final IntentFilter f4026a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: c, reason: collision with root package name */
    public static float f4028c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f4026a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return (n.f() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 2 : 0) | i2;
    }

    public static synchronized float b(Context context) {
        synchronized (t.class) {
            if (SystemClock.elapsedRealtime() - f4027b < JConstants.MIN && !Float.isNaN(f4028c)) {
                return f4028c;
            }
            if (context.getApplicationContext().registerReceiver(null, f4026a) != null) {
                f4028c = r6.getIntExtra("level", -1) / r6.getIntExtra("scale", -1);
            }
            f4027b = SystemClock.elapsedRealtime();
            return f4028c;
        }
    }
}
