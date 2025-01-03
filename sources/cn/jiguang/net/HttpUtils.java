package cn.jiguang.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import cn.jiguang.e.h;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9009a = cn.jiguang.p.a.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    public static abstract class HttpListener {
        public void a() {
        }

        public void a(HttpResponse httpResponse) {
        }
    }

    public static class a extends AsyncTask<HttpRequest, Void, HttpResponse> {

        /* renamed from: a, reason: collision with root package name */
        public HttpListener f9010a;

        /* renamed from: b, reason: collision with root package name */
        public Context f9011b;

        public a(Context context, HttpListener httpListener) {
            this.f9010a = httpListener;
            this.f9011b = context;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpResponse doInBackground(HttpRequest... httpRequestArr) {
            if (httpRequestArr == null || httpRequestArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f9011b, httpRequestArr[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f9010a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            HttpListener httpListener = this.f9010a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    public static class b extends AsyncTask<String, Void, HttpResponse> {

        /* renamed from: a, reason: collision with root package name */
        public HttpListener f9012a;

        /* renamed from: b, reason: collision with root package name */
        public Context f9013b;

        public b(HttpListener httpListener, Context context) {
            this.f9012a = httpListener;
            this.f9013b = context;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpResponse doInBackground(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f9013b, strArr[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f9012a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            HttpListener httpListener = this.f9012a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:6|7|9|10|11|(6:104|105|(2:107|(1:109))|110|(1:112)(1:115)|113)|(2:14|(16:16|17|18|19|20|21|23|24|(9:27|28|(3:44|45|(1:47))|(1:35)|(1:37)|38|39|(1:41)|42)|52|(3:31|33|35)|(0)|38|39|(0)|42))|103|19|20|21|23|24|(9:27|28|(0)|(0)|(0)|38|39|(0)|42)|52|(0)|(0)|38|39|(0)|42) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0147, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0148, code lost:
    
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x023b, code lost:
    
        if (r11 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x023d, code lost:
    
        r11.disconnect();
        r3 = r3;
        r9 = r9;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0142, code lost:
    
        r8 = r1;
        r1 = r9;
        r9 = r8;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013c, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013d, code lost:
    
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a8, code lost:
    
        if (r11 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00d3, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00d4, code lost:
    
        cn.jiguang.as.d.c("HttpUtils", "get input stream error:" + r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ec, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f A[Catch: all -> 0x013c, IOException -> 0x0141, MalformedURLException -> 0x0147, TryCatch #13 {MalformedURLException -> 0x0147, IOException -> 0x0141, all -> 0x013c, blocks: (B:24:0x00ed, B:33:0x010f, B:35:0x0115, B:37:0x011f, B:38:0x0129), top: B:23:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01be A[Catch: all -> 0x0208, TryCatch #4 {all -> 0x0208, blocks: (B:65:0x01b2, B:67:0x01be, B:68:0x01c5, B:69:0x01e1, B:74:0x01c9, B:76:0x01cd, B:77:0x01d5, B:79:0x01d9), top: B:64:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c9 A[Catch: all -> 0x0208, TryCatch #4 {all -> 0x0208, blocks: (B:65:0x01b2, B:67:0x01be, B:68:0x01c5, B:69:0x01e1, B:74:0x01c9, B:76:0x01cd, B:77:0x01d5, B:79:0x01d9), top: B:64:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024d  */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.net.HttpResponse a(android.content.Context r9, cn.jiguang.net.HttpRequest r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.a(android.content.Context, cn.jiguang.net.HttpRequest, boolean):cn.jiguang.net.HttpResponse");
    }

    public static void a(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (httpRequest == null || httpURLConnection == null) {
            return;
        }
        setURLConnection(httpRequest.getRequestProperties(), httpURLConnection);
        if (httpRequest.getConnectTimeout() >= 0) {
            httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout());
        }
        if (httpRequest.getReadTimeout() >= 0) {
            httpURLConnection.setReadTimeout(httpRequest.getReadTimeout());
        }
    }

    public static void a(HttpURLConnection httpURLConnection, HttpResponse httpResponse) {
        if (httpResponse == null || httpURLConnection == null) {
            return;
        }
        httpResponse.setResponseCode(httpURLConnection.getResponseCode());
        httpResponse.setResponseHeader("expires", httpURLConnection.getHeaderField(HttpHeaders.EXPIRES));
        httpResponse.setResponseHeader("cache-control", httpURLConnection.getHeaderField(HttpHeaders.CACHE_CONTROL));
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        return sb.toString();
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(f9009a, 80)));
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!TextUtils.isEmpty(joinParas)) {
            sb.append("?");
            sb.append(joinParas);
        }
        return sb.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(joinParasWithEncodedValue)) {
            sb.append("?");
            sb.append(joinParasWithEncodedValue);
        }
        return sb.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, false);
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(httpRequest);
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(str);
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, true);
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return cn.jiguang.e.b.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return h.b(inputStream);
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
