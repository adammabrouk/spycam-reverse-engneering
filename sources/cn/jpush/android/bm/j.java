package cn.jpush.android.bm;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import cn.jpush.android.helper.Logger;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class j {
    public static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a(str.getBytes("utf-8"));
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & ThreadUtils.TYPE_SINGLE;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            Logger.d("Secure", "Get SHA1 error");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] decode;
        synchronized (j.class) {
            byte[] decode2 = Base64.decode(str, 2);
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(2, rSAPublicKey);
            decode = Base64.decode(cipher.doFinal(decode2), 2);
        }
        return decode;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z) {
        synchronized (j.class) {
            if (str == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), "AES");
            IvParameterSpec b2 = b(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(z ? 1 : 2, secretKeySpec, b2);
            return cipher.doFinal(bArr);
        }
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, b(str2), str3), 2), "UTF-8");
    }

    public static RSAPublicKey b(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            Log.d("JumpManager", "rsa loadRSAKey e=" + th);
            return null;
        }
    }

    public static IvParameterSpec b(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, (Class<?>[]) new Class[]{byte[].class});
        } catch (Exception unused) {
            return null;
        }
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
