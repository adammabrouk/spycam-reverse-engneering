package c.c.a.b.c.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class a {
    public static byte[] a(Context context, String str) throws PackageManager.NameNotFoundException {
        MessageDigest a2;
        PackageInfo b2 = c.c.a.b.c.t.c.b(context).b(str, 64);
        Signature[] signatureArr = b2.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (a2 = a("SHA1")) == null) {
            return null;
        }
        return a2.digest(b2.signatures[0].toByteArray());
    }

    public static MessageDigest a(String str) {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
