package c.c.a.b.c.o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static Object f3993a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("sLock")
    public static boolean f3994b;

    /* renamed from: c, reason: collision with root package name */
    public static String f3995c;

    /* renamed from: d, reason: collision with root package name */
    public static int f3996d;

    public static String a(Context context) {
        c(context);
        return f3995c;
    }

    public static int b(Context context) {
        c(context);
        return f3996d;
    }

    public static void c(Context context) {
        Bundle bundle;
        synchronized (f3993a) {
            if (f3994b) {
                return;
            }
            f3994b = true;
            try {
                bundle = c.c.a.b.c.t.c.b(context).a(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f3995c = bundle.getString("com.google.app.id");
            f3996d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
