package cn.jiguang.at;

import android.text.TextUtils;
import cn.jiguang.as.d;
import cn.jiguang.e.f;
import cn.jiguang.e.h;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8351a = cn.jiguang.p.a.b(new byte[]{65, 87, 92, 29, 117, 43, 125, 38, 37, 123, 22, 96, 109, 94, 107, 8, 75, 85, 64, 78, 126, 120, 114, 78, 78, 37, 71, 94, 107, 44, 101, 94, 93, 106, 22, 111, 79, 87, 114, 88, 20, 99, 98, 115});

    public static boolean a(String str, File file, Map<String, String> map) {
        Closeable closeable;
        DataOutputStream dataOutputStream;
        RandomAccessFile randomAccessFile;
        HttpURLConnection httpURLConnection;
        int responseCode;
        byte[] bArr;
        d.c("UploadLogUtils", "url is : " + str + "\n fileName is : " + file.getName() + "\n param is : " + map.toString());
        HttpURLConnection httpURLConnection2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                sb.append(String.format("--%s\r\n%s; name=\"%s\"\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", str2));
                sb.append(String.format("%s\r\n", str3));
            }
            String format = String.format("--%s\r\n%s; name=\"%s\"; filename=\"%s\"\nContent-Type:%s\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", "file", f.l(file.getName()), "text/plain");
            String format2 = String.format("\r\n--%s--\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf");
            int length = (int) file.length();
            byte[] bArr2 = new byte[length];
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.read(bArr2);
                byte[] bytes = sb.toString().getBytes();
                byte[] bytes2 = format.getBytes();
                byte[] bytes3 = format2.getBytes();
                int length2 = bytes.length + bytes2.length + length + bytes3.length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
                System.arraycopy(bytes2, 0, bArr3, bytes.length, bytes2.length);
                System.arraycopy(bArr2, 0, bArr3, bytes.length + bytes2.length, length);
                System.arraycopy(bytes3, 0, bArr3, bytes.length + bytes2.length + length, bytes3.length);
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=werghnvt54wef654rjuhgb56trtg34tweuyrgf");
                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(length2));
                    httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, c.a().b(f8351a));
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    closeable = null;
                }
                try {
                    dataOutputStream.write(bArr3);
                    dataOutputStream.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    d.c("UploadLogUtils", "response code is " + responseCode + ", response message is " + httpURLConnection.getResponseMessage());
                    bArr = new byte[2048];
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        d.c("UploadLogUtils", "error message is : " + th.getMessage());
                        return false;
                    } finally {
                        h.a(dataOutputStream);
                        h.a(closeable);
                        h.a(randomAccessFile);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                dataOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            dataOutputStream = null;
            randomAccessFile = null;
        }
        if (responseCode != 200) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = errorStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            d.c("UploadLogUtils", "error response is : " + new String(byteArrayOutputStream.toByteArray()));
            h.a(dataOutputStream);
            h.a((Closeable) errorStream);
            h.a(randomAccessFile);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        while (true) {
            int read2 = inputStream.read(bArr);
            if (read2 == -1) {
                break;
            }
            byteArrayOutputStream2.write(bArr, 0, read2);
        }
        String str4 = new String(byteArrayOutputStream2.toByteArray());
        d.c("UploadLogUtils", "UploadFile response is : " + str4);
        boolean isEmpty = TextUtils.isEmpty(new JSONObject(str4).optString("key"));
        h.a(dataOutputStream);
        h.a((Closeable) inputStream);
        h.a(randomAccessFile);
        if (isEmpty) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        return true;
    }
}
