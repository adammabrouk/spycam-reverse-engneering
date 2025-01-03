package c.j.a.h;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import androidx.recyclerview.widget.RecyclerView;
import c.j.a.z.v;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* compiled from: AesSecurity.java */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public KeyStore f6546a;

    /* renamed from: b, reason: collision with root package name */
    public SecretKey f6547b;

    public a() {
        a();
        b();
    }

    public final void a() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f6546a = keyStore;
            keyStore.load(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("AesSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    public final SecretKey b() {
        try {
            if (this.f6547b != null) {
                return this.f6547b;
            }
            if (c()) {
                this.f6547b = d();
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                if (Build.VERSION.SDK_INT >= 23) {
                    keyGenerator.init(new KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(RecyclerView.c0.FLAG_TMP_DETACHED).build());
                }
                this.f6547b = keyGenerator.generateKey();
            }
            return this.f6547b;
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("AesSecurity", "getSecretKey error" + e2.getMessage());
            return null;
        }
    }

    public final boolean c() {
        try {
            if (this.f6546a == null) {
                a();
            }
            return this.f6546a.containsAlias("AesKeyAlias");
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("AesSecurity", "hasAESKey error" + e2.getMessage());
            return false;
        }
    }

    public final SecretKey d() {
        try {
            return ((KeyStore.SecretKeyEntry) this.f6546a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (Exception e2) {
            e2.printStackTrace();
            v.a("AesSecurity", "getAESSecretKey error" + e2.getMessage());
            return null;
        }
    }
}
