package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utilcode.LogUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    public static HashSet<Integer> f11001a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public String f11002b = null;

    /* renamed from: c, reason: collision with root package name */
    public Thread f11003c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f11004d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f11005e = null;

    public static a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.f11006a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                aVar.f11007b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f11008c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                aVar.f11009d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                aVar.f11010e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f11011f = string7;
                if (string7 == null || string7.equals(LogUtils.NULL) || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf(OSSUtils.NEW_LINE);
                if (indexOf < 0) {
                    x.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f11013h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f11012g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    aVar.f11012g = aVar.f11012g.substring(indexOf2 + 1);
                }
                aVar.f11014i = jSONObject.getString("file");
                if (aVar.f11011f == null) {
                    return null;
                }
                long j = jSONObject.getLong("lineNumber");
                aVar.j = j;
                if (j < 0) {
                    return null;
                }
                long j2 = jSONObject.getLong("columnNumber");
                aVar.k = j2;
                if (j2 < 0) {
                    return null;
                }
                x.a("H5 crash information is following: ", new Object[0]);
                x.a("[projectRoot]: " + aVar.f11006a, new Object[0]);
                x.a("[context]: " + aVar.f11007b, new Object[0]);
                x.a("[url]: " + aVar.f11008c, new Object[0]);
                x.a("[userAgent]: " + aVar.f11009d, new Object[0]);
                x.a("[language]: " + aVar.f11010e, new Object[0]);
                x.a("[name]: " + aVar.f11011f, new Object[0]);
                x.a("[message]: " + aVar.f11012g, new Object[0]);
                x.a("[stacktrace]: \n" + aVar.f11013h, new Object[0]);
                x.a("[file]: " + aVar.f11014i, new Object[0]);
                x.a("[lineNumber]: " + aVar.j, new Object[0]);
                x.a("[columnNumber]: " + aVar.k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f11001a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f11001a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f11003c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(OSSUtils.NEW_LINE);
            for (int i2 = 2; i2 < currentThread.getStackTrace().length; i2++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i2];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append(OSSUtils.NEW_LINE);
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f11004d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f11005e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        x.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            x.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String a2 = z.a(str.getBytes());
        String str2 = this.f11002b;
        if (str2 != null && str2.equals(a2)) {
            x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f11002b = a2;
        x.d("Handling JS exception ...", new Object[0]);
        a a3 = a(str);
        if (a3 == null) {
            x.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a3.f11006a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a3.f11007b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a3.f11008c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a3.f11009d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a3.f11014i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j = a3.j;
        if (j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f11005e);
        linkedHashMap.put("Java Stack", this.f11004d);
        Thread thread = this.f11003c;
        if (a3 != null) {
            InnerApi.postH5CrashAsync(thread, a3.f11011f, a3.f11012g, a3.f11013h, linkedHashMap);
        }
    }
}
