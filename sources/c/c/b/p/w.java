package c.c.b.p;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f6168a;

    public w(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException(JThirdPlatFormInterface.KEY_DATA);
        }
        this.f6168a = new Bundle(bundle);
    }

    public static String h(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public static String i(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    public final String a(String str) {
        Bundle bundle = this.f6168a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String i2 = i(str);
            if (this.f6168a.containsKey(i2)) {
                str = i2;
            }
        }
        return bundle.getString(str);
    }

    public final boolean b(String str) {
        String a2 = a(str);
        return "1".equals(a2) || Boolean.parseBoolean(a2);
    }

    public final Integer c(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(a2));
        } catch (NumberFormatException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 38 + String.valueOf(a2).length());
            sb.append("Couldn't parse value of ");
            sb.append(h2);
            sb.append("(");
            sb.append(a2);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Long d(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(a2));
        } catch (NumberFormatException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 38 + String.valueOf(a2).length());
            sb.append("Couldn't parse value of ");
            sb.append(h2);
            sb.append("(");
            sb.append(a2);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final String e(String str) {
        String valueOf = String.valueOf(str);
        return a("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    public final Object[] f(String str) {
        String valueOf = String.valueOf(str);
        JSONArray g2 = g("_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (g2 == null) {
            return null;
        }
        int length = g2.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = g2.optString(i2);
        }
        return strArr;
    }

    public final JSONArray g(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return new JSONArray(a2);
        } catch (JSONException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 50 + String.valueOf(a2).length());
            sb.append("Malformed JSON for key ");
            sb.append(h2);
            sb.append(": ");
            sb.append(a2);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Bundle e() {
        Bundle bundle = new Bundle(this.f6168a);
        for (String str : this.f6168a.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public final String b() {
        String a2 = a("gcm.n.sound2");
        return TextUtils.isEmpty(a2) ? a("gcm.n.sound") : a2;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle(this.f6168a);
        for (String str : this.f6168a.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public final Uri a() {
        String a2 = a("gcm.n.link_android");
        if (TextUtils.isEmpty(a2)) {
            a2 = a("gcm.n.link");
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return Uri.parse(a2);
    }

    public final String b(Resources resources, String str, String str2) {
        String e2 = e(str2);
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        int identifier = resources.getIdentifier(e2, "string", str);
        if (identifier == 0) {
            String valueOf = String.valueOf(str2);
            String h2 = h("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 49 + String.valueOf(str2).length());
            sb.append(h2);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] f2 = f(str2);
        if (f2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, f2);
        } catch (MissingFormatArgumentException e3) {
            String h3 = h(str2);
            String arrays = Arrays.toString(f2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(h3).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(h3);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e3);
            return null;
        }
    }

    public final long[] c() {
        JSONArray g2 = g("gcm.n.vibrate_timings");
        if (g2 == null) {
            return null;
        }
        try {
            if (g2.length() > 1) {
                int length = g2.length();
                long[] jArr = new long[length];
                for (int i2 = 0; i2 < length; i2++) {
                    jArr[i2] = g2.optLong(i2);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(g2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final int[] d() {
        JSONArray g2 = g("gcm.n.light_settings");
        if (g2 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (g2.length() == 3) {
                int parseColor = Color.parseColor(g2.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = g2.optInt(1);
                    iArr[2] = g2.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (IllegalArgumentException e2) {
            String valueOf = String.valueOf(g2);
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 60 + String.valueOf(message).length());
            sb.append("LightSettings is invalid: ");
            sb.append(valueOf);
            sb.append(". ");
            sb.append(message);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(g2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf2);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    public final String a(Resources resources, String str, String str2) {
        String a2 = a(str2);
        return !TextUtils.isEmpty(a2) ? a2 : b(resources, str, str2);
    }

    public static boolean a(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(i("gcm.n.e")));
    }
}
