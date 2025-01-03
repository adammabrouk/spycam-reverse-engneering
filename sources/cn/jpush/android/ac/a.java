package cn.jpush.android.ac;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class a {
    public static String a(String str) {
        return a(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                int i2 = b2 & ThreadUtils.TYPE_SINGLE;
                if (i2 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toString(i2, 16));
            }
            return sb.substring(8, 24);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }
}
