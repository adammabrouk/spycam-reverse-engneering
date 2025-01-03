package c.c.a.a.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.viewpager.widget.ViewPager;
import c.c.a.a.i.b.a;
import c.c.a.a.i.b.k;
import c.c.a.a.i.b.m;
import c.c.a.a.i.b.o;
import c.c.a.a.i.b.p;
import c.c.a.a.i.b.r;
import c.c.a.a.i.b.t;
import c.c.a.a.i.b.u;
import c.c.a.a.j.h;
import c.c.a.a.j.t.g;
import c.c.a.a.j.t.m;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class e implements m {

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f3537b;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3539d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3540e;

    /* renamed from: a, reason: collision with root package name */
    public final c.c.b.i.a f3536a = o.a();

    /* renamed from: c, reason: collision with root package name */
    public final URL f3538c = a(c.c.a.a.i.a.f3470c);

    /* renamed from: f, reason: collision with root package name */
    public final int f3541f = 40000;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final URL f3542a;

        /* renamed from: b, reason: collision with root package name */
        public final k f3543b;

        /* renamed from: c, reason: collision with root package name */
        public final String f3544c;

        public a(URL url, k kVar, String str) {
            this.f3542a = url;
            this.f3543b = kVar;
            this.f3544c = str;
        }

        public a a(URL url) {
            return new a(url, this.f3543b, this.f3544c);
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3545a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f3546b;

        /* renamed from: c, reason: collision with root package name */
        public final long f3547c;

        public b(int i2, URL url, long j) {
            this.f3545a = i2;
            this.f3546b = url;
            this.f3547c = j;
        }
    }

    public e(Context context, c.c.a.a.j.y.a aVar, c.c.a.a.j.y.a aVar2) {
        this.f3537b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f3539d = aVar2;
        this.f3540e = aVar;
    }

    @Override // c.c.a.a.j.t.m
    public h a(h hVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f3537b.getActiveNetworkInfo();
        h.a h2 = hVar.h();
        h2.a("sdk-version", Build.VERSION.SDK_INT);
        h2.a("model", Build.MODEL);
        h2.a("hardware", Build.HARDWARE);
        h2.a("device", Build.DEVICE);
        h2.a("product", Build.PRODUCT);
        h2.a("os-uild", Build.ID);
        h2.a("manufacturer", Build.MANUFACTURER);
        h2.a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        h2.a("tz-offset", TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
        h2.a("net-type", activeNetworkInfo == null ? u.c.zzs.zza() : activeNetworkInfo.getType());
        if (activeNetworkInfo == null) {
            subtype = u.b.zza.zza();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = u.b.zzu.zza();
            } else if (u.b.zza(subtype) == null) {
                subtype = 0;
            }
        }
        h2.a("mobile-subtype", subtype);
        return h2.a();
    }

    @Override // c.c.a.a.j.t.m
    public g a(c.c.a.a.j.t.f fVar) {
        p.a a2;
        HashMap hashMap = new HashMap();
        for (h hVar : fVar.a()) {
            String f2 = hVar.f();
            if (!hashMap.containsKey(f2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hVar);
                hashMap.put(f2, arrayList);
            } else {
                ((List) hashMap.get(f2)).add(hVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            h hVar2 = (h) ((List) entry.getValue()).get(0);
            r.a a3 = r.a();
            a3.a(c.c.a.a.i.b.b.zza);
            a3.a(this.f3540e.a());
            a3.b(this.f3539d.a());
            m.a a4 = c.c.a.a.i.b.m.a();
            a4.a(m.b.zzb);
            a.AbstractC0077a a5 = c.c.a.a.i.b.a.a();
            a5.a(hVar2.b("sdk-version"));
            a5.e(hVar2.a("model"));
            a5.c(hVar2.a("hardware"));
            a5.a(hVar2.a("device"));
            a5.g(hVar2.a("product"));
            a5.f(hVar2.a("os-uild"));
            a5.d(hVar2.a("manufacturer"));
            a5.b(hVar2.a("fingerprint"));
            a4.a(a5.a());
            a3.a(a4.a());
            try {
                a3.b(Integer.valueOf((String) entry.getKey()).intValue());
            } catch (NumberFormatException unused) {
                a3.b((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (h hVar3 : (List) entry.getValue()) {
                c.c.a.a.j.g c2 = hVar3.c();
                c.c.a.a.b b2 = c2.b();
                if (b2.equals(c.c.a.a.b.a("proto"))) {
                    a2 = p.a(c2.a());
                } else if (b2.equals(c.c.a.a.b.a("json"))) {
                    a2 = p.a(new String(c2.a(), Charset.forName("UTF-8")));
                } else {
                    c.c.a.a.j.u.a.b("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b2);
                }
                a2.a(hVar3.d());
                a2.b(hVar3.g());
                a2.c(hVar3.c("tz-offset"));
                u.a a6 = u.a();
                a6.a(u.c.zza(hVar3.b("net-type")));
                a6.a(u.b.zza(hVar3.b("mobile-subtype")));
                a2.a(a6.a());
                if (hVar3.b() != null) {
                    a2.a(hVar3.b().intValue());
                }
                arrayList3.add(a2.a());
            }
            a3.a(arrayList3);
            arrayList2.add(a3.a());
        }
        k a7 = k.a(arrayList2);
        URL url = this.f3538c;
        if (fVar.b() != null) {
            try {
                c.c.a.a.i.a a8 = c.c.a.a.i.a.a(fVar.b());
                r1 = a8.e() != null ? a8.e() : null;
                if (a8.f() != null) {
                    url = a(a8.f());
                }
            } catch (IllegalArgumentException unused2) {
                return g.c();
            }
        }
        try {
            b bVar = (b) c.c.a.a.j.v.b.a(5, new a(url, a7, r1), c.a(this), d.a());
            if (bVar.f3545a == 200) {
                return g.a(bVar.f3547c);
            }
            int i2 = bVar.f3545a;
            if (i2 < 500 && i2 != 404) {
                return g.c();
            }
            return g.d();
        } catch (IOException e2) {
            c.c.a.a.j.u.a.a("CctTransportBackend", "Could not make request to the backend", (Throwable) e2);
            return g.d();
        }
    }

    public static URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    public final b a(a aVar) throws IOException {
        InputStream inputStream;
        c.c.a.a.j.u.a.a("CctTransportBackend", "Making request to: %s", aVar.f3542a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f3542a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f3541f);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, String.format("datatransport/%s android/", "2.2.0"));
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f3544c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        WritableByteChannel newChannel = Channels.newChannel(httpURLConnection.getOutputStream());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    this.f3536a.a(aVar.f3543b, new OutputStreamWriter(gZIPOutputStream));
                    gZIPOutputStream.close();
                    newChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                    int responseCode = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Status Code: ");
                    sb.append(responseCode);
                    c.c.a.a.j.u.a.a("CctTransportBackend", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Content-Type: ");
                    sb2.append(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE));
                    c.c.a.a.j.u.a.a("CctTransportBackend", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Content-Encoding: ");
                    sb3.append(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                    c.c.a.a.j.u.a.a("CctTransportBackend", sb3.toString());
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        if (responseCode != 200) {
                            return new b(responseCode, null, 0L);
                        }
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING);
                        if (headerField != null && headerField.equals("gzip")) {
                            inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                        } else {
                            inputStream = httpURLConnection.getInputStream();
                        }
                        try {
                            return new b(responseCode, null, t.a(new InputStreamReader(inputStream)).a());
                        } finally {
                            inputStream.close();
                        }
                    }
                    return new b(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0L);
                } catch (c.c.b.i.c | IOException e2) {
                    c.c.a.a.j.u.a.a("CctTransportBackend", "Couldn't encode request, returning with 400", e2);
                    return new b(ViewPager.MIN_FLING_VELOCITY, null, 0L);
                }
            } finally {
                gZIPOutputStream.close();
            }
        } finally {
            newChannel.close();
        }
    }

    public static /* synthetic */ a a(a aVar, b bVar) {
        URL url = bVar.f3546b;
        if (url == null) {
            return null;
        }
        c.c.a.a.j.u.a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f3546b);
    }
}
