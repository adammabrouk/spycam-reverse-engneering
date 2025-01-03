package cn.jpush.android.bf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.bm.d;
import cn.jpush.android.bm.j;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9562a = d.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    /* renamed from: b, reason: collision with root package name */
    public static final String f9563b = d.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, 58, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    public static String a(Context context, String str, String str2, int i2) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection a2;
        String str3;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.CONTENT_TYPE, "text/plain");
            hashMap.put("Accept", "application/json");
            hashMap.put("Charset", "UTF-8");
            hashMap.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(str2.getBytes().length));
            if (i2 == 1) {
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put(HttpHeaders.AUTHORIZATION, "Basic " + b(context, str2));
            }
            a2 = a(context, str);
            try {
                a2.setConnectTimeout(30000);
                a2.setReadTimeout(30000);
                a2.setRequestMethod("POST");
                for (Map.Entry entry : hashMap.entrySet()) {
                    a2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                OutputStream outputStream = a2.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
                int responseCode = a2.getResponseCode();
                if (responseCode == 200) {
                    inputStream = a2.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        str3 = new String(byteArrayOutputStream.toByteArray());
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        httpURLConnection = a2;
                        th = th2;
                        try {
                            Logger.w("HttpManager", "request config exception:" + th.getMessage());
                            return null;
                        } finally {
                            k.a((Closeable) inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } else {
                    inputStream = null;
                    str3 = null;
                }
                Logger.d("HttpManager", "request config code:" + responseCode + ", url: " + str);
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
        if (TextUtils.isEmpty(str3)) {
            k.a((Closeable) inputStream);
            if (a2 != null) {
                a2.disconnect();
            }
            return null;
        }
        Logger.d("HttpManager", "request config success");
        k.a((Closeable) inputStream);
        if (a2 != null) {
            a2.disconnect();
        }
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r10, int r11, long r12) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bf.a.a(java.lang.String, int, long):java.lang.String");
    }

    public static HttpURLConnection a(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(f9562a, 80)));
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static byte[] a(InputStream inputStream) {
        return k.b(inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130 A[Catch: all -> 0x0138, TRY_ENTER, TryCatch #7 {all -> 0x0138, blocks: (B:42:0x0105, B:44:0x010a, B:60:0x0130, B:62:0x0135), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0135 A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #7 {all -> 0x0138, blocks: (B:42:0x0105, B:44:0x010a, B:60:0x0130, B:62:0x0135), top: B:5:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bf.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i2, int i3) {
        byte[] bArr = null;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr = a(str, i3);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    public static byte[] a(String str, int i2, long j, int i3) {
        byte[] bArr = null;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr = b(str, i2, j);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String appKey = JCoreHelper.getAppKey(context);
        String a2 = j.a(appKey + f9563b + j.a(str));
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return Base64.encodeToString((appKey + ":" + a2).getBytes(), 10);
        } catch (Exception unused) {
            Logger.w("generateAuthForBlackListConfig", "basic authorization encode failed");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x00bd, code lost:
    
        if (r8 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        if (r8 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bf, code lost:
    
        r8.disconnect();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(java.lang.String r10, int r11, long r12) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bf.a.b(java.lang.String, int, long):byte[]");
    }
}
