package cn.jiguang.bf;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.l.c;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f8730b = cn.jiguang.p.a.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 107, 115, 34, 85, 23, 44, 108, 35, 63, 90, 80, 108, 123, 126, 63, 83, 78, 54, Byte.MAX_VALUE, Byte.MAX_VALUE, 62, 64, 76, 105, 48, 124, 33, 91});

    /* renamed from: a, reason: collision with root package name */
    public static String f8729a = "";

    /* renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f8731c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static AtomicBoolean f8732d = new AtomicBoolean(false);

    public static void a(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.aa())).longValue();
        cn.jiguang.as.d.c("SentryEntryHelper", "currentTime is : " + currentTimeMillis + ", lastTime is : " + longValue);
        if (currentTimeMillis - longValue > JConstants.DAY) {
            cn.jiguang.bj.d.a("FUTURE_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.bf.i.1
                @Override // cn.jiguang.bj.b
                public void a() {
                    boolean e2 = i.e(context);
                    if (i.f8732d.get()) {
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.aa().a((cn.jiguang.f.a<Long>) Long.valueOf(currentTimeMillis))});
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ab().a((cn.jiguang.f.a<Boolean>) Boolean.valueOf(e2))});
                        i.f8731c.set(e2);
                        i.d(context);
                    }
                }
            });
        } else {
            f8731c.set(((Boolean) cn.jiguang.f.b.a(context, cn.jiguang.f.a.ab())).booleanValue());
            d(context);
        }
    }

    public static void d(Context context) {
        if (f8731c.get()) {
            h.a().a(context);
            h.a().b();
            b.a(context);
        }
    }

    public static boolean e(Context context) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        f8732d.set(false);
        InputStream inputStream2 = null;
        String str = null;
        inputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        if (cn.jiguang.e.a.d(context)) {
            String a2 = cn.jiguang.ao.a.a(context);
            if (!TextUtils.isEmpty(a2)) {
                String str2 = f8730b;
                if (c.a.f8946a && !TextUtils.isEmpty(f8729a)) {
                    str2 = f8729a;
                }
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, c.a.a.j.a.o);
                jSONObject.put("app_key", a2);
                jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f8098b);
                jSONObject.put("os_ver", Integer.toString(Build.VERSION.SDK_INT));
                if (cn.jiguang.h.a.a().d(2002)) {
                    String format = String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
                    if (TextUtils.isEmpty(format)) {
                        format = "";
                    }
                    jSONObject.put("brand", format);
                }
                hashMap.put(HttpHeaders.CONTENT_TYPE, "application/json");
                hashMap.put("Accept", "application/json");
                hashMap.put("X-Http-Platform", "android");
                hashMap.put("X-Http-Appkey", a2);
                hashMap.put("Charset", "UTF-8");
                cn.jiguang.as.d.c("SentryEntryHelper", "url:" + str2 + ", param json:" + jSONObject.toString() + ", header is : " + hashMap.toString());
                HttpURLConnection httpURLConnectionWithProxy = HttpUtils.getHttpURLConnectionWithProxy(context, str2);
                try {
                    httpURLConnectionWithProxy.setConnectTimeout(30000);
                    httpURLConnectionWithProxy.setReadTimeout(30000);
                    httpURLConnectionWithProxy.setRequestMethod("POST");
                    for (Map.Entry entry : hashMap.entrySet()) {
                        httpURLConnectionWithProxy.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    OutputStream outputStream = httpURLConnectionWithProxy.getOutputStream();
                    outputStream.write(jSONObject.toString().getBytes("UTF-8"));
                    outputStream.flush();
                    if (httpURLConnectionWithProxy.getResponseCode() == 200) {
                        inputStream2 = httpURLConnectionWithProxy.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        String str3 = new String(byteArrayOutputStream.toByteArray());
                        inputStream = inputStream2;
                        str = str3;
                    } else {
                        inputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    cn.jiguang.as.d.c("SentryEntryHelper", "responseBody:" + str);
                    if (!TextUtils.isEmpty(str)) {
                        cn.jiguang.as.d.c("SentryEntryHelper", "request sentry sample success,response body:" + str);
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.optInt(JThirdPlatFormInterface.KEY_CODE) == 2000) {
                            r5 = jSONObject2.optJSONObject(JThirdPlatFormInterface.KEY_DATA) != null ? jSONObject2.optJSONObject(JThirdPlatFormInterface.KEY_DATA).optBoolean("crash_switch", false) : false;
                            cn.jiguang.e.h.a((Closeable) inputStream);
                            if (httpURLConnectionWithProxy != null) {
                                httpURLConnectionWithProxy.disconnect();
                            }
                            f8732d.set(true);
                            return r5;
                        }
                    }
                    cn.jiguang.e.h.a((Closeable) inputStream);
                    if (httpURLConnectionWithProxy != null) {
                        httpURLConnectionWithProxy.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = inputStream;
                    Throwable th4 = th;
                    httpURLConnection = httpURLConnectionWithProxy;
                    th = th4;
                    try {
                        cn.jiguang.as.d.g("SentryEntryHelper", "sentry sample error is " + th.getMessage());
                        return false;
                    } finally {
                        cn.jiguang.e.h.a((Closeable) inputStream2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        f8732d.set(true);
                    }
                }
                return false;
            }
            cn.jiguang.as.d.g("SentryEntryHelper", "request sentry sample failed because can't get appKey");
        }
        cn.jiguang.e.h.a((Closeable) null);
        f8732d.set(true);
        return r5;
    }
}
