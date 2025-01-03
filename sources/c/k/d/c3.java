package c.k.d;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class c3 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f7024c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7025d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7026e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7027f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7028g;

    public c3(Context context, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i2);
        this.f7024c = z;
        this.f7025d = z2;
        this.f7026e = z3;
        this.f7027f = z4;
        this.f7028g = z5;
    }

    private String b() {
        if (!this.f7024c) {
            return "off";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f6950b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels + "," + displayMetrics.widthPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    private String c() {
        if (!this.f7025d) {
            return "off";
        }
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // c.k.d.j.a
    public int a() {
        return 3;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public x6 mo92a() {
        return x6.DeviceInfoV2;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        return b() + "|" + c() + "|" + d() + "|" + e() + "|" + f();
    }

    public final String d() {
        if (!this.f7026e) {
            return "off";
        }
        try {
            return String.valueOf(Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String e() {
        if (!this.f7027f) {
            return "off";
        }
        try {
            return Settings.Secure.getString(this.f6950b.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String f() {
        if (!this.f7028g) {
            return "off";
        }
        try {
            return ((TelephonyManager) this.f6950b.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }
}
