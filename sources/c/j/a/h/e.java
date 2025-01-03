package c.j.a.h;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import c.j.a.z.v;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: RsaSecurity.java */
/* loaded from: classes.dex */
public final class e implements b {

    /* renamed from: b, reason: collision with root package name */
    public static PrivateKey f6552b;

    /* renamed from: c, reason: collision with root package name */
    public static PublicKey f6553c;

    /* renamed from: d, reason: collision with root package name */
    public static KeyStore f6554d;

    /* renamed from: e, reason: collision with root package name */
    public static X500Principal f6555e;

    /* renamed from: a, reason: collision with root package name */
    public Context f6556a;

    public e(Context context) {
        this.f6556a = context;
        try {
            b();
            a(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (f6554d == null) {
                b();
            }
            return f6554d.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // c.j.a.h.b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.f6556a) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b2 = b(this.f6556a);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(b2);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            v.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    public static void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            f6554d = keyStore;
            keyStore.load(null);
            f6555e = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // c.j.a.h.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    public static PrivateKey b(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (f6552b != null) {
            return f6552b;
        }
        if (context == null) {
            v.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        if (!b("PushRsaKeyAlias")) {
            a(context);
        }
        KeyStore.Entry entry = f6554d.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            f6552b = privateKey;
            return privateKey;
        }
        return null;
    }

    public static void a(Context context) {
        try {
            if (context == null) {
                v.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            if (!b("PushRsaKeyAlias")) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(f6555e).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(build);
                    keyPairGenerator.generateKeyPair();
                    return;
                }
                return;
            }
            v.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    @Override // c.j.a.h.b
    public final PublicKey a() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
        }
        if (f6553c != null) {
            return f6553c;
        }
        if (!b("PushRsaKeyAlias")) {
            a(this.f6556a);
        }
        KeyStore.Entry entry = f6554d.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PublicKey publicKey = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            f6553c = publicKey;
            return publicKey;
        }
        return null;
    }
}
