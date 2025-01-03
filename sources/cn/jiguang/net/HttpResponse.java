package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    public String f9001a;

    /* renamed from: b, reason: collision with root package name */
    public String f9002b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Object> f9003c;

    /* renamed from: d, reason: collision with root package name */
    public int f9004d;

    /* renamed from: e, reason: collision with root package name */
    public long f9005e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9006f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9007g;

    /* renamed from: h, reason: collision with root package name */
    public int f9008h;

    public HttpResponse() {
        this.f9008h = -1;
        this.f9003c = new HashMap();
    }

    public HttpResponse(String str) {
        this.f9008h = -1;
        this.f9001a = str;
        this.f9004d = 0;
        this.f9006f = false;
        this.f9007g = false;
        this.f9003c = new HashMap();
    }

    private int a() {
        int indexOf;
        try {
            String str = (String) this.f9003c.get("cache-control");
            if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("max-age=")) == -1) {
                return -1;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            int i2 = indexOf + 8;
            return Integer.parseInt(indexOf2 != -1 ? str.substring(i2, indexOf2) : str.substring(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private long b() {
        if (a() != -1) {
            return System.currentTimeMillis() + (r0 * 1000);
        }
        if (TextUtils.isEmpty(getExpiresHeader())) {
            return -1L;
        }
        return HttpUtils.parseGmtTime(getExpiresHeader());
    }

    public long getExpiredTime() {
        if (this.f9007g) {
            return this.f9005e;
        }
        this.f9007g = true;
        long b2 = b();
        this.f9005e = b2;
        return b2;
    }

    public String getExpiresHeader() {
        try {
            if (this.f9003c == null) {
                return null;
            }
            return (String) this.f9003c.get("expires");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getResponseBody() {
        return this.f9002b;
    }

    public int getResponseCode() {
        return this.f9008h;
    }

    public int getType() {
        return this.f9004d;
    }

    public String getUrl() {
        return this.f9001a;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f9005e;
    }

    public boolean isInCache() {
        return this.f9006f;
    }

    public void setExpiredTime(long j) {
        this.f9007g = true;
        this.f9005e = j;
    }

    public HttpResponse setInCache(boolean z) {
        this.f9006f = z;
        return this;
    }

    public void setResponseBody(String str) {
        this.f9002b = str;
    }

    public void setResponseCode(int i2) {
        this.f9008h = i2;
    }

    public void setResponseHeader(String str, String str2) {
        Map<String, Object> map = this.f9003c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.f9003c = map;
    }

    public void setType(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f9004d = i2;
    }

    public void setUrl(String str) {
        this.f9001a = str;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f9002b + "', responseCode=" + this.f9008h + '}';
    }
}
