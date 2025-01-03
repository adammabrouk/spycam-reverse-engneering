package c.c.a.b.g.b;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class i7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final URL f4805a;

    /* renamed from: b, reason: collision with root package name */
    public final f7 f4806b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4807c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f4808d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g7 f4809e;

    public i7(g7 g7Var, String str, URL url, byte[] bArr, Map<String, String> map, f7 f7Var) {
        this.f4809e = g7Var;
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(url);
        c.c.a.b.c.o.r.a(f7Var);
        this.f4805a = url;
        this.f4806b = f7Var;
        this.f4807c = str;
        this.f4808d = null;
    }

    public final /* synthetic */ void a(int i2, Exception exc, byte[] bArr, Map map) {
        this.f4806b.a(this.f4807c, i2, exc, bArr, map);
    }

    public final void b(final int i2, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f4809e.a().a(new Runnable(this, i2, exc, bArr, map) { // from class: c.c.a.b.g.b.h7

            /* renamed from: a, reason: collision with root package name */
            public final i7 f4774a;

            /* renamed from: b, reason: collision with root package name */
            public final int f4775b;

            /* renamed from: c, reason: collision with root package name */
            public final Exception f4776c;

            /* renamed from: d, reason: collision with root package name */
            public final byte[] f4777d;

            /* renamed from: e, reason: collision with root package name */
            public final Map f4778e;

            {
                this.f4774a = this;
                this.f4775b = i2;
                this.f4776c = exc;
                this.f4777d = bArr;
                this.f4778e = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f4774a.a(this.f4775b, this.f4776c, this.f4777d, this.f4778e);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        Map<String, List<String>> headerFields;
        byte[] a2;
        this.f4809e.f();
        int i2 = 0;
        try {
            httpURLConnection = this.f4809e.a(this.f4805a);
            try {
                if (this.f4808d != null) {
                    for (Map.Entry<String, String> entry : this.f4808d.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                i2 = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e2) {
                e = e2;
                map2 = null;
            } catch (Throwable th) {
                th = th;
                map = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            map = null;
        }
        try {
            g7 g7Var = this.f4809e;
            a2 = g7.a(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, null, a2, headerFields);
        } catch (IOException e4) {
            map2 = headerFields;
            e = e4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, e, null, map2);
        } catch (Throwable th3) {
            map = headerFields;
            th = th3;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, null, null, map);
            throw th;
        }
    }
}
