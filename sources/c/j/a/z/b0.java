package c.j.a.z;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* compiled from: SettingsCache.java */
/* loaded from: classes.dex */
public final class b0 implements j {

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f6676a;

    @Override // c.j.a.z.j
    public final boolean a(Context context) {
        if (!p.b()) {
            return false;
        }
        this.f6676a = context.getContentResolver();
        return true;
    }

    @Override // c.j.a.z.j
    public final String b(String str, String str2) {
        try {
            return Settings.System.getString(this.f6676a, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }

    @Override // c.j.a.z.j
    public final void a(String str, String str2) {
        try {
            Settings.System.putString(this.f6676a, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.b("SettingsCache", "putString error by ".concat(String.valueOf(str)));
        }
    }
}
