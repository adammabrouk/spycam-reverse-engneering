package cn.jiguang.bk;

import android.util.Base64;
import cn.jiguang.e.f;
import com.shix.shixipc.he.Constant;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class e {
    public static int a() {
        return Math.abs(new SecureRandom().nextInt()) & Constant.PPPP_STATUS_UNKNOWN;
    }

    public static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(long j) {
        long j2;
        long j3;
        switch ((int) (j % 10)) {
            case 1:
                j2 = 5 * j;
                j3 = 88;
                break;
            case 2:
                j2 = 23 * j;
                j3 = 15;
                break;
            case 3:
                j2 = 3 * j;
                j3 = 73;
                break;
            case 4:
                j2 = 13 * j;
                j3 = 96;
                break;
            case 5:
                j2 = 17 * j;
                j3 = 49;
                break;
            case 6:
                j2 = 7 * j;
                j3 = 68;
                break;
            case 7:
                j2 = 31 * j;
                j3 = 39;
                break;
            case 8:
                j2 = 29 * j;
                j3 = 41;
                break;
            case 9:
                j2 = 37 * j;
                j3 = 91;
                break;
            default:
                j2 = 8 * j;
                j3 = 74;
                break;
        }
        return f.d("JCKP" + (j2 + (j % j3)));
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            cn.jiguang.as.d.g("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, (Class<?>[]) new Class[]{byte[].class});
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] doFinal;
        synchronized (e.class) {
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, rSAPublicKey);
            doFinal = cipher.doFinal(str.getBytes());
        }
        return doFinal;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z) {
        synchronized (e.class) {
            if (str == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), "AES");
            IvParameterSpec a2 = a(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(z ? 1 : 2, secretKeySpec, a2);
            return cipher.doFinal(bArr);
        }
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            cn.jiguang.as.d.g("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, a(str2), str3), 2), "UTF-8");
    }

    public static byte[] c(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }
}
