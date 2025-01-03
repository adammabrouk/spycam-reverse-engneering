package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import cn.jiguang.internal.JConstants;

@Deprecated
/* loaded from: classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<PowerManager.WakeLock> f2641a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static int f2642b = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f2641a) {
            PowerManager.WakeLock wakeLock = f2641a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f2641a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }

    public static ComponentName b(Context context, Intent intent) {
        synchronized (f2641a) {
            int i2 = f2642b;
            int i3 = f2642b + 1;
            f2642b = i3;
            if (i3 <= 0) {
                f2642b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i2);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(JConstants.MIN);
            f2641a.put(i2, newWakeLock);
            return startService;
        }
    }
}
