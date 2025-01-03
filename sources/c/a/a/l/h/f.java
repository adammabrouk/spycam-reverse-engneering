package c.a.a.l.h;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class f implements c.a.a.l.h.c<InputStream> {

    /* renamed from: f, reason: collision with root package name */
    public static final c f3047f = new b();

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.j.d f3048a;

    /* renamed from: b, reason: collision with root package name */
    public final c f3049b;

    /* renamed from: c, reason: collision with root package name */
    public HttpURLConnection f3050c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f3051d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f3052e;

    /* compiled from: HttpUrlFetcher.java */
    public static class b implements c {
        public b() {
        }

        @Override // c.a.a.l.h.f.c
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    public interface c {
        HttpURLConnection a(URL url) throws IOException;
    }

    public f(c.a.a.l.j.d dVar) {
        this(dVar, f3047f);
    }

    @Override // c.a.a.l.h.c
    public String c() {
        return this.f3048a.a();
    }

    @Override // c.a.a.l.h.c
    public void cancel() {
        this.f3052e = true;
    }

    public f(c.a.a.l.j.d dVar, c cVar) {
        this.f3048a = dVar;
        this.f3049b = cVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.h.c
    public InputStream a(c.a.a.g gVar) throws Exception {
        return a(this.f3048a.e(), 0, null, this.f3048a.b());
    }

    public final InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new IOException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f3050c = this.f3049b.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f3050c.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f3050c.setConnectTimeout(2500);
            this.f3050c.setReadTimeout(2500);
            this.f3050c.setUseCaches(false);
            this.f3050c.setDoInput(true);
            this.f3050c.connect();
            if (this.f3052e) {
                return null;
            }
            int responseCode = this.f3050c.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                return a(this.f3050c);
            }
            if (i3 == 3) {
                String headerField = this.f3050c.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    return a(new URL(url, headerField), i2 + 1, url, map);
                }
                throw new IOException("Received empty or null redirect url");
            }
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.f3050c.getResponseMessage());
        }
        throw new IOException("Too many (> 5) redirects!");
    }

    public final InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f3051d = c.a.a.r.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f3051d = httpURLConnection.getInputStream();
        }
        return this.f3051d;
    }

    @Override // c.a.a.l.h.c
    public void a() {
        InputStream inputStream = this.f3051d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f3050c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
