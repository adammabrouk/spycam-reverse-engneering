package c.k.d;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class b3 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f6987c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6988d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6989e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6990f;

    public b3(Context context, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i2);
        this.f6987c = z;
        this.f6988d = z2;
        if (g9.d()) {
            this.f6988d = false;
        }
        this.f6989e = z3;
        this.f6990f = z4;
    }

    private String b() {
        if (!this.f6987c) {
            return "off";
        }
        try {
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            return k0.a(c2) + "," + k0.b(c2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private String c() {
        return "";
    }

    @Override // c.k.d.j.a
    public int a() {
        return 13;
    }

    @Override // c.k.d.a3
    /* renamed from: a, reason: collision with other method in class */
    public x6 mo92a() {
        return x6.DeviceBaseInfo;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        return b() + "|" + d() + "|" + e() + "|" + a(this.f6950b);
    }

    public final String a(Context context) {
        return !this.f6990f ? "off" : "";
    }

    public final String d() {
        return !this.f6988d ? "off" : "";
    }

    public final String e() {
        return !this.f6989e ? "off" : "";
    }
}
