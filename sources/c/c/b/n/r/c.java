package c.c.b.n.r;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import c.c.a.b.c.o.r;
import c.c.a.b.c.s.j;
import c.c.b.k.c;
import c.c.b.n.r.d;
import c.c.b.n.r.e;
import c.c.b.q.h;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f6096d = Pattern.compile("[0-9]+s");

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f6097e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f6098a;

    /* renamed from: b, reason: collision with root package name */
    public final h f6099b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.b.k.c f6100c;

    public c(Context context, h hVar, c.c.b.k.c cVar) {
        this.f6098a = context;
        this.f6099b = hVar;
        this.f6100c = cVar;
    }

    public static JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:16.3.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void d(HttpURLConnection httpURLConnection) {
        String e2 = e(httpURLConnection);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        Log.w("Firebase-Installations", e2);
    }

    public static String e(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f6097e));
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return format;
            } catch (IOException unused2) {
                bufferedReader.close();
                return null;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    public d a(String str, String str2, String str3, String str4, String str5) throws IOException {
        int i2 = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations", str3)));
        while (i2 <= 1) {
            HttpURLConnection a2 = a(url, str);
            try {
                a2.setRequestMethod("POST");
                a2.setDoOutput(true);
                if (str5 != null) {
                    a2.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                a(a2, str2, str4);
                int responseCode = a2.getResponseCode();
                if (responseCode == 200) {
                    return a(a2);
                }
                d(a2);
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    c();
                    d.a f2 = d.f();
                    f2.a(d.b.BAD_CONFIG);
                    return f2.a();
                }
                i2++;
            } finally {
                a2.disconnect();
            }
        }
        throw new IOException();
    }

    public final void c(HttpURLConnection httpURLConnection) throws IOException {
        a(httpURLConnection, a(b()));
    }

    public static void c() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    public final e b(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f6097e));
        e.a d2 = e.d();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(JThirdPlatFormInterface.KEY_TOKEN)) {
                d2.a(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                d2.a(a(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        d2.a(e.b.OK);
        return d2.a();
    }

    public final void a(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        a(httpURLConnection, a(a(str, str2)));
    }

    public static byte[] a(JSONObject jSONObject) throws IOException {
        return jSONObject.toString().getBytes("UTF-8");
    }

    public static void a(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
                try {
                    return;
                } catch (IOException unused) {
                    return;
                }
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
    }

    public static JSONObject a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:16.3.0");
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public e a(String str, String str2, String str3, String str4) throws IOException {
        int i2 = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s/authTokens:generate", str3, str2)));
        while (i2 <= 1) {
            HttpURLConnection a2 = a(url, str);
            try {
                a2.setRequestMethod("POST");
                a2.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + str4);
                c(a2);
                int responseCode = a2.getResponseCode();
                if (responseCode == 200) {
                    return b(a2);
                }
                d(a2);
                if (responseCode != 401 && responseCode != 404) {
                    if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                        c();
                        e.a d2 = e.d();
                        d2.a(e.b.BAD_CONFIG);
                        return d2.a();
                    }
                    i2++;
                }
                e.a d3 = e.d();
                d3.a(e.b.AUTH_ERROR);
                return d3.a();
            } finally {
                a2.disconnect();
            }
        }
        throw new IOException();
    }

    public final HttpURLConnection a(URL url, String str) throws IOException {
        c.a a2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnection.addRequestProperty("X-Android-Package", this.f6098a.getPackageName());
        c.c.b.k.c cVar = this.f6100c;
        if (cVar != null && this.f6099b != null && (a2 = cVar.a("fire-installations-id")) != c.a.NONE) {
            httpURLConnection.addRequestProperty("x-firebase-client", this.f6099b.a());
            httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(a2.getCode()));
        }
        httpURLConnection.addRequestProperty("X-Android-Cert", a());
        httpURLConnection.addRequestProperty("x-goog-api-key", str);
        return httpURLConnection;
    }

    public final d a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f6097e));
        e.a d2 = e.d();
        d.a f2 = d.f();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                f2.c(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                f2.a(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                f2.b(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals(JThirdPlatFormInterface.KEY_TOKEN)) {
                        d2.a(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        d2.a(a(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                f2.a(d2.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        f2.a(d.b.OK);
        return f2.a();
    }

    public final String a() {
        try {
            byte[] a2 = c.c.a.b.c.s.a.a(this.f6098a, this.f6098a.getPackageName());
            if (a2 == null) {
                Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f6098a.getPackageName());
                return null;
            }
            return j.a(a2, false);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("ContentValues", "No such package: " + this.f6098a.getPackageName(), e2);
            return null;
        }
    }

    public static long a(String str) {
        r.a(f6096d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }
}
