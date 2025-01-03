package cn.jiguang.au;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.e.h;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.net.SSLTrustManager;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static SSLTrustManager f8359a;

    public static g a(Context context, String str, byte[] bArr, int i2, int i3, int i4) {
        try {
            HttpRequest httpRequest = new HttpRequest(str);
            a(httpRequest, context, bArr, i2, i4);
            while (i3 > 0) {
                i3--;
                HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                int responseCode = httpPost.getResponseCode();
                cn.jiguang.as.d.d("HttpHelper", "status code:" + responseCode + " retry left:" + i3);
                if (responseCode == 200) {
                    return new g(0, httpPost.getResponseBody());
                }
                if (responseCode == 401) {
                    return new g(-3, httpPost.getResponseBody());
                }
                if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                    return new g(-1, httpPost.getResponseBody());
                }
                if (responseCode == 503) {
                    return new g(-2, httpPost.getResponseBody());
                }
                if (responseCode != 3005) {
                    return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                }
            }
            return new g(-2, "Failed - retry enough");
        } catch (AssertionError e2) {
            return new g(-2, "Catch AssertionError to avoid http close crash - " + e2.getMessage());
        } catch (Exception e3) {
            return new g(-2, "Exception - " + e3.getMessage());
        } catch (Throwable th) {
            return new g(-2, "Exception - " + th.getMessage());
        }
    }

    public static g a(String str, String str2, Context context, boolean z, int i2, int i3) {
        try {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (z) {
                    try {
                        bytes = h.a(bytes);
                    } catch (IOException e2) {
                        return new g(-2, "zip err:" + e2.getMessage());
                    }
                }
                HttpRequest httpRequest = new HttpRequest(str);
                a(httpRequest, context, bytes, i3);
                while (i2 > 0) {
                    i2--;
                    HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                    int responseCode = httpPost.getResponseCode();
                    cn.jiguang.as.d.d("HttpHelper", "status code:" + responseCode + " retry left:" + i2);
                    if (responseCode == 200) {
                        return new g(0, httpPost.getResponseBody());
                    }
                    if (responseCode == 401) {
                        return new g(-3, httpPost.getResponseBody());
                    }
                    if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                        return new g(-1, httpPost.getResponseBody());
                    }
                    if (responseCode == 503) {
                        return new g(-2, httpPost.getResponseBody());
                    }
                    if (responseCode != 3005) {
                        return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                    }
                }
                return new g(-2, "Failed - retry enough");
            } catch (AssertionError e3) {
                return new g(-2, "Catch AssertionError to avoid http close crash - " + e3.getMessage());
            } catch (Exception e4) {
                return new g(-2, "Exception - " + e4.getMessage());
            } catch (Throwable th) {
                return new g(-2, "Exception - " + th.getMessage());
            }
        } catch (UnsupportedEncodingException e5) {
            return new g(-2, "Exception - " + e5.getMessage());
        }
    }

    public static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i2) {
        String a2;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        String a3 = cn.jiguang.bk.e.a(cn.jiguang.bk.e.a());
        byte[] a4 = cn.jiguang.bk.e.a(bArr, a3, (i2 == 2 || i2 == 3) ? "0102030405060708" : "iop203040506aPk!", true);
        httpRequest.setBody(a4);
        httpRequest.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(a4.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f8359a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f8359a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = f8359a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        if (i2 == 2 || i2 == 3) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            if (i2 == 3) {
                httpRequest.setRequestProperty("X-Real-IP", "jcore");
                a2 = f.b(a3);
            } else {
                a2 = f.a(a3);
            }
        } else {
            boolean z = i2 == 4;
            httpRequest.setHaveRspData(z);
            httpRequest.setRspDatazip(z);
            a2 = "Basic " + f.a(context, cn.jiguang.e.f.b(a4), a3, z);
        }
        httpRequest.setRequestProperty(HttpHeaders.AUTHORIZATION, a2);
        httpRequest.setRequestProperty("Charset", "UTF-8");
    }

    public static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i2, int i3) {
        String str;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        httpRequest.setBody(bArr);
        httpRequest.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(bArr.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f8359a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f8359a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = f8359a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        httpRequest.setRequestProperty("Charset", "UTF-8");
        httpRequest.setRequestProperty(HttpHeaders.HOST, (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f.f8381c)) ? "stats.jpush.cn" : Uri.parse(f.f8381c).getHost());
        String a2 = cn.jiguang.bk.e.a(i2);
        if (i3 == 2) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            str = f.a(a2);
        } else {
            httpRequest.setHaveRspData(false);
            httpRequest.setRspDatazip(false);
            str = "Basic " + f.a(context, cn.jiguang.e.f.b(bArr), a2);
        }
        httpRequest.setRequestProperty(HttpHeaders.AUTHORIZATION, str);
    }
}
