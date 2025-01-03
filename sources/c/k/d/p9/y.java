package c.k.d.p9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* loaded from: classes.dex */
public class y {

    /* renamed from: c, reason: collision with root package name */
    public static y f7732c;

    /* renamed from: a, reason: collision with root package name */
    public Context f7733a;

    /* renamed from: b, reason: collision with root package name */
    public int f7734b = 0;

    public y(Context context) {
        this.f7733a = context.getApplicationContext();
    }

    public static y a(Context context) {
        if (f7732c == null) {
            f7732c = new y(context);
        }
        return f7732c;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i2 = this.f7734b;
        if (i2 != 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f7734b = Settings.Global.getInt(this.f7733a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f7734b;
        }
        int i3 = Settings.Secure.getInt(this.f7733a.getContentResolver(), "device_provisioned", 0);
        this.f7734b = i3;
        return i3;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a, reason: collision with other method in class */
    public Uri m410a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m411a() {
        return c.k.d.c.f7005a.contains("xmsf") || c.k.d.c.f7005a.contains("xiaomi") || c.k.d.c.f7005a.contains("miui");
    }
}
