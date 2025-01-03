package cn.jiguang.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bk.e;
import cn.jiguang.l.c;
import cn.jiguang.l.d;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.p.f;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.service.WakedResultReceiver;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f8964a = "";

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile c f8965c;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f8966f = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Context f8967b;

    /* renamed from: d, reason: collision with root package name */
    public int f8968d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f8969e = "";

    /* renamed from: g, reason: collision with root package name */
    public String f8970g = "I8iQemLpVcDAL0AS";

    /* renamed from: h, reason: collision with root package name */
    public String f8971h = "RTDdJXgDDVXH8Tbv";

    public class a implements Callable<Integer> {

        /* renamed from: b, reason: collision with root package name */
        public Context f8976b;

        public a(Context context) {
            this.f8976b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            c.this.a(this.f8976b);
            return 0;
        }
    }

    private int a(Context context, String str) {
        synchronized (f8966f) {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.ai.a.a("JDataConfigManager", "[refreshConfig] data config is null");
            } else {
                try {
                    String str2 = new String(e.a(str, this.f8970g, this.f8971h), "UTF-8");
                    a("JDataConfigManager", "serverConfig:" + str2);
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE);
                    String optString = jSONObject.optString("message");
                    if (optInt == 2000) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(JThirdPlatFormInterface.KEY_DATA);
                        if (optJSONObject != null) {
                            cn.jiguang.h.a.a().b();
                            int optInt2 = optJSONObject.optInt("status");
                            this.f8969e = optJSONObject.optString("sign");
                            if (optInt2 == 0) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("rt");
                                if (optJSONArray != null) {
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        String optString2 = optJSONArray.optString(i2);
                                        if (!TextUtils.isEmpty(optString2)) {
                                            String[] split = optString2.split("-");
                                            cn.jiguang.h.a.a().f8896b.add(new String[]{split[0], split[1]});
                                        }
                                    }
                                }
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("pl");
                                if (optJSONArray2 != null) {
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                                        if (optJSONObject2 != null) {
                                            cn.jiguang.m.a aVar = new cn.jiguang.m.a();
                                            aVar.a(true);
                                            aVar.a(optJSONObject2.optInt("ci"));
                                            aVar.b(optJSONObject2.optInt("sc"));
                                            aVar.d(optJSONObject2.optInt("bc"));
                                            aVar.c(optJSONObject2.optInt("sr"));
                                            aVar.e(optJSONObject2.optInt("br"));
                                            aVar.f(optJSONObject2.optInt("bg"));
                                            aVar.g(optJSONObject2.optInt("md"));
                                            cn.jiguang.h.a.a().a(aVar);
                                        }
                                    }
                                }
                            } else {
                                cn.jiguang.ai.a.a("JDataConfigManager", "parse data config , config status is no");
                            }
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject("in_app");
                            if (optJSONObject3 != null) {
                                String optString3 = optJSONObject3.optString("rule_file_md5");
                                cn.jiguang.ai.a.a("JDataConfigManager", "recv inapp file md5: " + optString3);
                                if (!TextUtils.isEmpty(optString3) && !LogUtils.NULL.equals(optString3)) {
                                    d.e(context, optString3);
                                }
                            }
                        }
                    } else {
                        cn.jiguang.ai.a.a("JDataConfigManager", "[refreshConfig] data config code:" + optInt + " msg:" + optString);
                    }
                    return optInt;
                } catch (Throwable th) {
                    cn.jiguang.ai.a.d("JDataConfigManager", "[refreshConfig] refreshConfig failed, errMsg: " + th.getMessage());
                }
            }
            return 0;
        }
    }

    public static c a() {
        if (f8965c == null) {
            synchronized (c.class) {
                if (f8965c == null) {
                    f8965c = new c();
                }
            }
        }
        return f8965c;
    }

    private String a(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String b2;
        String str2;
        try {
            b2 = d.b(this.f8967b);
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
            inputStream = null;
        }
        if (TextUtils.isEmpty(b2)) {
            cn.jiguang.ai.a.d("JDataConfigManager", "request data config failed because can't get appKey");
            return null;
        }
        String str3 = "https://ce3e75d5.jpush.cn/wi/op8jdu";
        if (c.a.f8946a && !TextUtils.isEmpty(f8964a)) {
            str3 = f8964a;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ak", b2);
        jSONObject.put("p", c.a.a.j.a.o);
        jSONObject.put("av", WakedResultReceiver.WAKE_TYPE_KEY);
        jSONObject.put("sign", str);
        String p = d.p(this.f8967b);
        String str4 = "";
        if (TextUtils.isEmpty(p)) {
            p = "";
        }
        jSONObject.put("file_version", p);
        String str5 = c.a.f8947b;
        if (!TextUtils.isEmpty(str5)) {
            str4 = str5.trim();
        }
        jSONObject.put("manufacturer", str4);
        if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty((CharSequence) cn.jiguang.f.b.a(this.f8967b, cn.jiguang.f.a.ad()))) {
            f.a().d(this.f8967b, str4);
        }
        String a2 = cn.jiguang.o.b.a();
        jSONObject.put("rom", a2);
        if (!TextUtils.isEmpty(a2) && !a2.equalsIgnoreCase((String) cn.jiguang.f.b.a(this.f8967b, cn.jiguang.f.a.ae()))) {
            f.a().b(this.f8967b, a2);
        }
        jSONObject.put("model", Build.MODEL);
        if (!TextUtils.isEmpty(Build.MODEL) && TextUtils.isEmpty((CharSequence) cn.jiguang.f.b.a(this.f8967b, cn.jiguang.f.a.ac()))) {
            f.a().c(this.f8967b, Build.MODEL);
        }
        String num = Integer.toString(Build.VERSION.SDK_INT);
        jSONObject.put("osversion", num);
        if (!TextUtils.isEmpty(num) && !num.equalsIgnoreCase((String) cn.jiguang.f.b.a(this.f8967b, cn.jiguang.f.a.af()))) {
            f.a().a(this.f8967b, num);
        }
        String format = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
        if (!TextUtils.isEmpty(format)) {
            jSONObject.put("android_ver", format);
        }
        String a3 = d.a();
        if (!TextUtils.isEmpty(a3)) {
            jSONObject.put("jcore_ver", a3);
        }
        String b3 = d.b(0);
        if (!TextUtils.isEmpty(b3)) {
            jSONObject.put("jpush_ver", b3);
        }
        cn.jiguang.ai.a.a("JDataConfigManager", "url:" + str3 + ", param json:" + jSONObject.toString());
        hashMap.put(HttpHeaders.CONTENT_TYPE, "text/plain");
        hashMap.put("Accept", "application/json");
        hashMap.put("Charset", "UTF-8");
        HttpURLConnection httpURLConnectionWithProxy = HttpUtils.getHttpURLConnectionWithProxy(this.f8967b, str3);
        try {
            httpURLConnectionWithProxy.setConnectTimeout(30000);
            httpURLConnectionWithProxy.setReadTimeout(30000);
            httpURLConnectionWithProxy.setRequestMethod("POST");
            for (Map.Entry entry : hashMap.entrySet()) {
                httpURLConnectionWithProxy.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            OutputStream outputStream = httpURLConnectionWithProxy.getOutputStream();
            String a4 = e.a(jSONObject.toString().getBytes(), this.f8970g, this.f8971h);
            cn.jiguang.ai.a.a("JDataConfigManager", "encryptStr:" + a4 + ", paramJson: " + jSONObject);
            outputStream.write(a4.getBytes("UTF-8"));
            outputStream.flush();
            int responseCode = httpURLConnectionWithProxy.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpURLConnectionWithProxy.getInputStream();
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
                    str2 = new String(byteArrayOutputStream.toByteArray());
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    httpURLConnection = httpURLConnectionWithProxy;
                    th = th3;
                    try {
                        cn.jiguang.ai.a.d("JDataConfigManager", "request data config exception:" + th.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                cn.jiguang.ai.a.d("JDataConfigManager", "request data config exception:" + e2.getMessage());
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } finally {
                    }
                }
            } else {
                inputStream = null;
                str2 = null;
            }
            cn.jiguang.ai.a.a("JDataConfigManager", "request data config code:" + responseCode + ", body:" + str2);
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    cn.jiguang.ai.a.d("JDataConfigManager", "request data config exception:" + e3.getMessage());
                }
            }
            if (httpURLConnectionWithProxy != null) {
                httpURLConnectionWithProxy.disconnect();
            }
            return null;
        }
        cn.jiguang.ai.a.a("JDataConfigManager", "request data config success");
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e4) {
                cn.jiguang.ai.a.d("JDataConfigManager", "request data config exception:" + e4.getMessage());
            }
        }
        if (httpURLConnectionWithProxy != null) {
            httpURLConnectionWithProxy.disconnect();
        }
        return str2;
    }

    public static void a(String str, String str2) {
        int length = 4000 - str.length();
        while (str2.length() > length) {
            cn.jiguang.ai.a.a(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        cn.jiguang.ai.a.a(str, str2);
    }

    public synchronized void a(Context context) {
        if (this.f8968d >= 3) {
            cn.jiguang.ai.a.a("JDataConfigManager", "try more than 3 times,won't try again");
            cn.jiguang.l.b.d(context, "JDataConfigManager");
            this.f8968d = 0;
            return;
        }
        if (cn.jiguang.l.b.a(context, "JDataConfigManager")) {
            b(context);
            String a2 = a(this.f8969e);
            if (TextUtils.isEmpty(a2)) {
                this.f8968d++;
            } else {
                if (a(context, a2) == 2000) {
                    cn.jiguang.p.c.a(context, "bac.catch", a2);
                }
                cn.jiguang.l.b.d(context, "JDataConfigManager");
                this.f8968d = 0;
            }
        } else {
            b(context);
        }
    }

    public void a(Context context, int i2) {
        try {
            FutureTask futureTask = new FutureTask(new a(context));
            d.a(futureTask);
            futureTask.get(i2, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            cn.jiguang.ai.a.a("JDataConfigManager", "requestConfigSync timeout");
        }
    }

    public void a(final Context context, final b bVar) {
        d.a(new cn.jiguang.l.e() { // from class: cn.jiguang.m.c.1
            @Override // cn.jiguang.l.e
            public void a() {
                try {
                    c.this.a(context);
                } catch (Throwable th) {
                    cn.jiguang.ai.a.a("JDataConfigManager", "request config error:" + th);
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        });
    }

    public void b(Context context) {
        synchronized (f8966f) {
            if (TextUtils.isEmpty(this.f8969e)) {
                String c2 = cn.jiguang.p.c.c(context, "bac.catch");
                if (!TextUtils.isEmpty(c2)) {
                    a(context, c2);
                }
            }
        }
    }
}
