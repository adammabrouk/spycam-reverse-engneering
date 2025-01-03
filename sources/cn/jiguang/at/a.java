package cn.jiguang.at;

import cn.jiguang.as.d;
import cn.jiguang.e.h;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class a {
    public static void a(int i2, String str, File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            String substring = str.substring(0, 16);
            d.c("CryptoUtils", "doCrypto cipherMode is " + i2 + ", key is " + str + ", IvParameterSpec is " + substring + ", inputFile is " + file.getAbsolutePath() + ", outputFile is " + file2.getAbsolutePath());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(substring.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(i2, secretKeySpec, ivParameterSpec);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream2.read(bArr);
                byte[] doFinal = cipher.doFinal(bArr);
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(doFinal);
                    fileOutputStream.flush();
                    h.a((Closeable) fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        d.g("CryptoUtils", "Error encrypting/decrypting file, error message is " + e.getMessage());
                        h.a((Closeable) fileInputStream);
                        h.a(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        h.a((Closeable) fileInputStream);
                        h.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    h.a((Closeable) fileInputStream);
                    h.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        h.a(fileOutputStream);
    }

    public static void a(String str, File file, File file2) {
        a(1, str, file, file2);
    }
}
