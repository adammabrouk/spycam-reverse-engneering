package c.c.b.o;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import c.c.b.j.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6103a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f6104b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f6105c = new AtomicBoolean(b());

    public a(Context context, String str, c cVar) {
        this.f6103a = a(context);
        this.f6104b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
    }

    public static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || a.h.b.a.d(context)) ? context : a.h.b.a.a(context);
    }

    public final boolean b() {
        ApplicationInfo applicationInfo;
        if (this.f6104b.contains("firebase_data_collection_default_enabled")) {
            return this.f6104b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f6103a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.f6103a.getPackageName(), RecyclerView.c0.FLAG_IGNORE)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    public boolean a() {
        return this.f6105c.get();
    }
}
