package cn.jpush.android.ac;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class b {
    public static SecretKeySpec a(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 32) {
            return null;
        }
        if (bytes.length == 32 || bytes.length == 16) {
            return new SecretKeySpec(bytes, "AES");
        }
        byte[] bArr = new byte[32];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec a2 = a(str);
            IvParameterSpec b2 = b(str2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, a2, b2);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static IvParameterSpec b(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 16) {
            return null;
        }
        if (bytes.length == 16) {
            return new IvParameterSpec(bytes);
        }
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return new IvParameterSpec(bArr);
    }
}
