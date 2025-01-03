package c.k.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.system.ContentCommon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u1 {

    /* renamed from: h, reason: collision with root package name */
    public static Context f7913h;

    /* renamed from: i, reason: collision with root package name */
    public static u1 f7914i;
    public static a j;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, q1> f7915a;

    /* renamed from: b, reason: collision with root package name */
    public t1 f7916b;

    /* renamed from: c, reason: collision with root package name */
    public b f7917c;

    /* renamed from: d, reason: collision with root package name */
    public String f7918d;

    /* renamed from: e, reason: collision with root package name */
    public long f7919e;

    /* renamed from: f, reason: collision with root package name */
    public long f7920f;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, p1> f7912g = new HashMap();
    public static boolean k = false;

    public interface a {
        u1 a(Context context, t1 t1Var, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    public u1(Context context, t1 t1Var, b bVar, String str) {
        this(context, t1Var, bVar, str, null, null);
    }

    public u1(Context context, t1 t1Var, b bVar, String str, String str2, String str3) {
        this.f7915a = new HashMap();
        this.f7918d = "0";
        this.f7919e = 0L;
        this.f7920f = 0L;
        this.f7917c = bVar;
        this.f7916b = t1Var == null ? new v1(this) : t1Var;
        this.f7918d = str;
        if (str2 == null) {
            context.getPackageName();
        }
        if (str3 != null) {
            return;
        }
        f();
    }

    public static synchronized u1 a() {
        u1 u1Var;
        synchronized (u1.class) {
            if (f7914i == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            u1Var = f7914i;
        }
        return u1Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m489a() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context context = f7913h;
        if (context == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable unused) {
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() != 1) {
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        }
        WifiManager wifiManager = (WifiManager) f7913h.getSystemService("wifi");
        if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
            return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
        }
        return "unknown";
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static synchronized void a(Context context, t1 t1Var, b bVar, String str, String str2, String str3) {
        synchronized (u1.class) {
            Context applicationContext = context.getApplicationContext();
            f7913h = applicationContext;
            if (applicationContext == null) {
                f7913h = context;
            }
            if (f7914i == null) {
                if (j == null) {
                    f7914i = new u1(context, t1Var, bVar, str, str2, str3);
                } else {
                    f7914i = j.a(context, t1Var, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (u1.class) {
            j = aVar;
            f7914i = null;
        }
    }

    public static void a(String str, String str2) {
        p1 p1Var = f7912g.get(str);
        synchronized (f7912g) {
            if (p1Var == null) {
                p1 p1Var2 = new p1(str);
                p1Var2.a(604800000L);
                p1Var2.m329a(str2);
                f7912g.put(str, p1Var2);
            } else {
                p1Var.m329a(str2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public p1 m490a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public p1 a(String str, boolean z) {
        p1 d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (!this.f7916b.a(str)) {
            return null;
        }
        p1 c2 = c(str);
        return (c2 == null || !c2.b()) ? (z && e0.b(f7913h) && (d2 = d(str)) != null) ? d2 : new w1(this, str, c2) : c2;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<d0> arrayList3 = new ArrayList();
        arrayList3.add(new a0(ContentCommon.TYPE, str));
        if (str.equals("wap")) {
            arrayList3.add(new a0("conpt", a(e0.m138a(f7913h))));
        }
        if (z) {
            arrayList3.add(new a0("reserved", "1"));
        }
        arrayList3.add(new a0("uuid", str2));
        arrayList3.add(new a0("list", k0.a(arrayList, ",")));
        arrayList3.add(new a0("countrycode", c.k.d.p9.a.a(f7913h).b()));
        p1 c2 = c(b());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (f7912g) {
                p1 p1Var = f7912g.get("resolver.msg.xiaomi.net");
                if (p1Var != null) {
                    Iterator<String> it = p1Var.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (d0 d0Var : arrayList3) {
                buildUpon.appendQueryParameter(d0Var.a(), d0Var.b());
            }
            try {
                return this.f7917c == null ? e0.a(f7913h, new URL(buildUpon.toString())) : this.f7917c.a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        c.k.a.a.a.c.m6a("network exception: " + e2.getMessage());
        throw e2;
    }

    public final ArrayList<p1> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m498d();
        synchronized (this.f7915a) {
            m494a();
            for (String str : this.f7915a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = f7912g.isEmpty();
        synchronized (f7912g) {
            for (Object obj : f7912g.values().toArray()) {
                p1 p1Var = (p1) obj;
                if (!p1Var.b()) {
                    f7912g.remove(p1Var.f7481d);
                    isEmpty = true;
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<p1> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = e0.d(f7913h) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f7918d, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                c.k.a.a.a.c.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    c.k.a.a.a.c.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            c.k.a.a.a.c.m6a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            p1 p1Var2 = new p1(str3);
                            int i4 = 0;
                            while (i4 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i4);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    p1Var2.a(new z1(string6, optJSONArray.length() - i4));
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, p1Var2);
                            p1Var2.f7486i = string5;
                            p1Var2.f7482e = string;
                            p1Var2.f7484g = string3;
                            p1Var2.f7485h = string4;
                            p1Var2.f7483f = string2;
                            if (jSONObject4.has("stat-percent")) {
                                p1Var2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                p1Var2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                p1Var2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m493a(p1Var2.a());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j2 = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                c.k.a.a.a.c.m6a("no bucket found for " + next);
                            } else {
                                p1 p1Var3 = new p1(next);
                                p1Var3.a(j2);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        p1Var3.a(new z1(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (f7912g) {
                                    if (this.f7916b.a(next)) {
                                        f7912g.put(next, p1Var3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            p1 p1Var4 = arrayList2.get(i6);
            if (p1Var4 != null) {
                a(arrayList.get(i6), p1Var4);
            }
        }
        m497c();
        return arrayList2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m491a() {
        JSONObject jSONObject;
        synchronized (this.f7915a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<q1> it = this.f7915a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m420a());
            }
            jSONObject.put(JThirdPlatFormInterface.KEY_DATA, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<p1> it2 = f7912g.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m328a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m492a() {
        synchronized (this.f7915a) {
            this.f7915a.clear();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m493a(String str) {
    }

    public void a(String str, p1 p1Var) {
        if (TextUtils.isEmpty(str) || p1Var == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + p1Var);
        }
        if (this.f7916b.a(str)) {
            synchronized (this.f7915a) {
                m494a();
                if (this.f7915a.containsKey(str)) {
                    this.f7915a.get(str).a(p1Var);
                } else {
                    q1 q1Var = new q1(str);
                    q1Var.a(p1Var);
                    this.f7915a.put(str, q1Var);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m494a() {
        synchronized (this.f7915a) {
            if (k) {
                return true;
            }
            k = true;
            this.f7915a.clear();
            try {
                String d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    m496b(d2);
                    c.k.a.a.a.c.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                c.k.a.a.a.c.m6a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public p1 b(String str) {
        return a(str, true);
    }

    public String b() {
        String a2 = c.k.d.p9.a.a(f7913h).a();
        return (TextUtils.isEmpty(a2) || c.k.d.p9.l1.a.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m495b() {
        ArrayList<String> arrayList;
        synchronized (this.f7915a) {
            m494a();
            arrayList = new ArrayList<>(this.f7915a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                q1 q1Var = this.f7915a.get(arrayList.get(size));
                if (q1Var != null && q1Var.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<p1> a2 = a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (a2.get(i2) != null) {
                a(arrayList.get(i2), a2.get(i2));
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m496b(String str) {
        synchronized (this.f7915a) {
            this.f7915a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(JThirdPlatFormInterface.KEY_DATA);
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                q1 q1Var = new q1();
                q1Var.a(optJSONArray.getJSONObject(i2));
                this.f7915a.put(q1Var.m418a(), q1Var);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                p1 p1Var = new p1("");
                p1Var.a(optJSONArray2.getJSONObject(i3));
                f7912g.put(p1Var.f7481d, p1Var);
            }
        }
    }

    public p1 c(String str) {
        q1 q1Var;
        p1 a2;
        synchronized (this.f7915a) {
            m494a();
            q1Var = this.f7915a.get(str);
        }
        if (q1Var == null || (a2 = q1Var.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f7915a) {
            for (Map.Entry<String, q1> entry : this.f7915a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append(OSSUtils.NEW_LINE);
            }
        }
        return sb.toString();
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m497c() {
        synchronized (this.f7915a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f7913h.openFileOutput(e(), 0)));
                String jSONObject = m491a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e2) {
                c.k.a.a.a.c.m6a("persist bucket failure: " + e2.getMessage());
            }
        }
    }

    public p1 d(String str) {
        if (System.currentTimeMillis() - this.f7920f <= this.f7919e * 60 * 1000) {
            return null;
        }
        this.f7920f = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        p1 p1Var = a(arrayList).get(0);
        if (p1Var != null) {
            this.f7919e = 0L;
            return p1Var;
        }
        long j2 = this.f7919e;
        if (j2 >= 15) {
            return null;
        }
        this.f7919e = j2 + 1;
        return null;
    }

    public String d() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(f7913h.getFilesDir(), e());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            v9.a((Closeable) null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                c.k.a.a.a.c.m6a("load host exception " + th.getMessage());
                return null;
            } finally {
                v9.a(bufferedReader);
            }
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m498d() {
        String next;
        synchronized (this.f7915a) {
            Iterator<q1> it = this.f7915a.values().iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f7915a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f7915a.get(next).m419a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f7915a.remove(next);
            }
        }
    }

    public String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f7913h.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return "com.xiaomi";
    }

    public final String f() {
        try {
            PackageInfo packageInfo = f7913h.getPackageManager().getPackageInfo(f7913h.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }
}
