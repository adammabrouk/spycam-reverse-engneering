package cn.jiguang.net;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* loaded from: classes.dex */
public class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f8992a;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f8995d;

    /* renamed from: f, reason: collision with root package name */
    public Object f8997f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8998g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8999h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9000i;
    public SSLTrustManager m;
    public boolean n;
    public HostnameVerifier o;
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;

    /* renamed from: b, reason: collision with root package name */
    public int f8993b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f8994c = -1;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f8996e = new HashMap();

    public HttpRequest(String str) {
        this.f8992a = str;
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.f8992a = str;
        this.f8995d = map;
    }

    public Object getBody() {
        return this.f8997f;
    }

    public int getConnectTimeout() {
        return this.f8993b;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.o;
    }

    public byte[] getParas() {
        Object obj = this.f8997f;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f8997f).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String joinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.f8995d);
        if (TextUtils.isEmpty(joinParasWithEncodedValue)) {
            return null;
        }
        return joinParasWithEncodedValue.getBytes();
    }

    public Map<String, String> getParasMap() {
        return this.f8995d;
    }

    public int getReadTimeout() {
        return this.f8994c;
    }

    public Map<String, String> getRequestProperties() {
        return this.f8996e;
    }

    public String getRequestProperty(String str) {
        return this.f8996e.get(str);
    }

    public SSLTrustManager getSslTrustManager() {
        return this.m;
    }

    public String getUrl() {
        return this.f8992a;
    }

    public boolean isDoInPut() {
        return this.f8999h;
    }

    public boolean isDoOutPut() {
        return this.f8998g;
    }

    public boolean isHaveRspData() {
        return this.j;
    }

    public boolean isNeedErrorInput() {
        return this.l;
    }

    public boolean isNeedRetryIfHttpsFailed() {
        return this.n;
    }

    public boolean isRspDatazip() {
        return this.k;
    }

    public boolean isUseCaches() {
        return this.f9000i;
    }

    public void setBody(Object obj) {
        this.f8997f = obj;
    }

    public void setConnectTimeout(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f8993b = i2;
    }

    public void setDoInPut(boolean z) {
        this.f8999h = z;
    }

    public void setDoOutPut(boolean z) {
        this.f8998g = z;
    }

    public void setHaveRspData(boolean z) {
        this.j = z;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.o = hostnameVerifier;
    }

    public void setNeedErrorInput(boolean z) {
        this.l = z;
    }

    public void setNeedRetryIfHttpsFailed(boolean z) {
        this.n = z;
    }

    public void setParasMap(Map<String, String> map) {
        this.f8995d = map;
    }

    public void setReadTimeout(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f8994c = i2;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.f8996e = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.f8996e.put(str, str2);
    }

    public void setRspDatazip(boolean z) {
        this.k = z;
    }

    public void setSslTrustManager(SSLTrustManager sSLTrustManager) {
        this.m = sSLTrustManager;
    }

    public void setUrl(String str) {
        this.f8992a = str;
    }

    public void setUseCaches(boolean z) {
        this.f9000i = z;
    }

    public void setUserAgent(String str) {
        this.f8996e.put(HttpHeaders.USER_AGENT, str);
    }
}
