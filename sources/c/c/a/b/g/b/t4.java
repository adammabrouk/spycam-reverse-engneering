package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t4 {

    /* renamed from: a, reason: collision with root package name */
    public final w4 f5091a;

    public t4(w4 w4Var) {
        c.c.a.b.c.o.r.a(w4Var);
        this.f5091a = w4Var;
    }

    public static boolean a(Context context) {
        ActivityInfo receiverInfo;
        c.c.a.b.c.o.r.a(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        a5 a2 = a5.a(context, null, null);
        w3 c2 = a2.c();
        if (intent == null) {
            c2.w().a("Receiver called with null intent");
            return;
        }
        a2.F();
        String action = intent.getAction();
        c2.B().a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c2.B().a("Starting wakeful intent.");
            this.f5091a.a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            c2.w().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
