package c.j.a.z;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpCache.java */
/* loaded from: classes.dex */
public final class d0 implements j {

    /* renamed from: b, reason: collision with root package name */
    public static String f6685b = "SpCache";

    /* renamed from: c, reason: collision with root package name */
    public static String f6686c = "com.vivo.push.cache";

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6687a;

    @Override // c.j.a.z.j
    public final boolean a(Context context) {
        if (this.f6687a != null) {
            return true;
        }
        this.f6687a = context.getSharedPreferences(f6686c, 0);
        return true;
    }

    @Override // c.j.a.z.j
    public final String b(String str, String str2) {
        String string = this.f6687a.getString(str, str2);
        v.d(f6685b, "getString " + str + " is " + string);
        return string;
    }

    @Override // c.j.a.z.j
    public final void a(String str, String str2) {
        SharedPreferences.Editor edit = this.f6687a.edit();
        if (edit != null) {
            edit.putString(str, str2);
            h.a(edit);
            v.d(f6685b, "putString by ".concat(String.valueOf(str)));
            return;
        }
        v.b(f6685b, "putString error by ".concat(String.valueOf(str)));
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f6687a.edit();
        if (edit != null) {
            edit.clear();
            h.a(edit);
        }
        v.d(f6685b, "system cache is cleared");
    }
}
