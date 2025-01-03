package c.c.a.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import c.c.a.b.c.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f3795a;

    public c(Context context) {
        try {
            Context b2 = h.b(context);
            this.f3795a = b2 == null ? null : b2.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f3795a = null;
        }
    }

    public final float a(String str, float f2) {
        try {
            if (this.f3795a == null) {
                return 0.0f;
            }
            return this.f3795a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    public final String a(String str, String str2) {
        try {
            return this.f3795a == null ? str2 : this.f3795a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    public final boolean a(String str, boolean z) {
        try {
            if (this.f3795a == null) {
                return false;
            }
            return this.f3795a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
