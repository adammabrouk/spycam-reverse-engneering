package c.c.b.n.q;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.zxing.view.ViewfinderView;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6074c = {"*", "FCM", "GCM", ""};

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6075a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6076b;

    public b(c.c.b.c cVar) {
        this.f6075a = cVar.b().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f6076b = a(cVar);
    }

    public static String a(c.c.b.c cVar) {
        String c2 = cVar.d().c();
        if (c2 != null) {
            return c2;
        }
        String b2 = cVar.d().b();
        if (!b2.startsWith("1:") && !b2.startsWith("2:")) {
            return b2;
        }
        String[] split = b2.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public final String b() {
        String string;
        synchronized (this.f6075a) {
            string = this.f6075a.getString("|S|id", null);
        }
        return string;
    }

    public final String c() {
        synchronized (this.f6075a) {
            String string = this.f6075a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey b2 = b(string);
            if (b2 == null) {
                return null;
            }
            return a(b2);
        }
    }

    public String d() {
        synchronized (this.f6075a) {
            for (String str : f6074c) {
                String string = this.f6075a.getString(a(this.f6076b, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = a(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }

    public final PublicKey b(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            Log.w("ContentValues", "Invalid key stored " + e2);
            return null;
        }
    }

    public final String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    public final String a(String str) {
        try {
            return new JSONObject(str).getString(JThirdPlatFormInterface.KEY_TOKEN);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        synchronized (this.f6075a) {
            String b2 = b();
            if (b2 != null) {
                return b2;
            }
            return c();
        }
    }

    public static String a(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & ViewfinderView.OPAQUE);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }
}
