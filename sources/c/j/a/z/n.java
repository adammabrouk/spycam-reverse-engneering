package c.j.a.z;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: DefaultNotifyDataAdapter.java */
/* loaded from: classes.dex */
public final class n implements a {

    /* renamed from: e, reason: collision with root package name */
    public static int f6714e;

    /* renamed from: f, reason: collision with root package name */
    public static int f6715f;

    /* renamed from: a, reason: collision with root package name */
    public Resources f6716a;

    /* renamed from: b, reason: collision with root package name */
    public String f6717b;

    /* renamed from: c, reason: collision with root package name */
    public String f6718c;

    /* renamed from: d, reason: collision with root package name */
    public String f6719d;

    public static boolean a(int i2) {
        return (i2 == -1 || i2 == 0) ? false : true;
    }

    @Override // c.j.a.z.a
    public final void a(Context context) {
        this.f6717b = context.getPackageName();
        this.f6716a = context.getResources();
        this.f6718c = p.a();
        this.f6719d = Build.VERSION.RELEASE;
    }

    @Override // c.j.a.z.a
    public final int b() {
        if (a(f6715f)) {
            return f6715f;
        }
        String str = this.f6719d;
        int a2 = !a(str) ? -1 : a(str, "_icon");
        f6715f = a2;
        if (a(a2)) {
            return f6715f;
        }
        for (String str2 = this.f6718c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f6716a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f6717b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f6716a.getIdentifier("vivo_push_icon", "drawable", this.f6717b);
    }

    @Override // c.j.a.z.a
    public final int a() {
        if (a(f6714e)) {
            return f6714e;
        }
        String str = this.f6719d;
        int a2 = !a(str) ? -1 : a(str, "_notifyicon");
        f6714e = a2;
        if (a(a2)) {
            return f6714e;
        }
        for (String str2 = this.f6718c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f6716a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f6717b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f6716a.getIdentifier("vivo_push_notifyicon", "drawable", this.f6717b);
    }

    public static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        v.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    public final int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    v.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f6716a.getIdentifier(str3, "drawable", this.f6717b);
                    if (identifier > 0) {
                        v.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                v.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }

    @Override // c.j.a.z.a
    public final int a(c.j.a.t.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }
}
