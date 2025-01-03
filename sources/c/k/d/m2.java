package c.k.d;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

/* loaded from: classes.dex */
public class m2 {
    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static r2 m293a() {
        return new n2();
    }

    public static void a(Context context) {
        t2.a(context).a();
        try {
            context.registerReceiver(new BroadcastActionsReceiver(m293a()), a());
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
        }
    }
}
