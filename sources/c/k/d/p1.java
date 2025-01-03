package c.k.d;

import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p1 {

    /* renamed from: a, reason: collision with root package name */
    public String f7478a;

    /* renamed from: b, reason: collision with root package name */
    public long f7479b;

    /* renamed from: d, reason: collision with root package name */
    public String f7481d;

    /* renamed from: e, reason: collision with root package name */
    public String f7482e;

    /* renamed from: f, reason: collision with root package name */
    public String f7483f;

    /* renamed from: g, reason: collision with root package name */
    public String f7484g;

    /* renamed from: h, reason: collision with root package name */
    public String f7485h;

    /* renamed from: i, reason: collision with root package name */
    public String f7486i;
    public String j;
    public String k;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<z1> f7480c = new ArrayList<>();
    public double l = 0.1d;
    public long m = JConstants.DAY;

    public p1(String str) {
        this.f7478a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f7479b = System.currentTimeMillis();
        this.f7480c.add(new z1(str, -1));
        this.f7478a = u1.m489a();
        this.f7481d = str;
    }

    public synchronized p1 a(JSONObject jSONObject) {
        this.f7478a = jSONObject.optString("net");
        this.m = jSONObject.getLong("ttl");
        this.l = jSONObject.getDouble("pct");
        this.f7479b = jSONObject.getLong("ts");
        this.f7483f = jSONObject.optString("city");
        this.f7482e = jSONObject.optString("prv");
        this.f7486i = jSONObject.optString("cty");
        this.f7484g = jSONObject.optString("isp");
        this.f7485h = jSONObject.optString("ip");
        this.f7481d = jSONObject.optString("host");
        this.j = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            z1 z1Var = new z1();
            z1Var.a(jSONArray.getJSONObject(i2));
            a(z1Var);
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        if (TextUtils.isEmpty(this.f7484g)) {
            return "hardcode_isp";
        }
        String a2 = k0.a(new String[]{this.f7484g, this.f7482e, this.f7483f, this.f7486i, this.f7485h}, "_");
        this.k = a2;
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m327a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (!TextUtils.equals(url.getHost(), this.f7481d)) {
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = a(true).iterator();
        while (it.hasNext()) {
            s1 a2 = s1.a(it.next(), url.getPort());
            arrayList.add(new URL(url.getProtocol(), a2.m458a(), a2.a(), url.getFile()).toString());
        }
        return arrayList;
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f7480c.size();
        z1[] z1VarArr = new z1[size];
        this.f7480c.toArray(z1VarArr);
        Arrays.sort(z1VarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            z1 z1Var = z1VarArr[i2];
            if (z) {
                substring = z1Var.f8055b;
            } else {
                int indexOf = z1Var.f8055b.indexOf(":");
                substring = indexOf != -1 ? z1Var.f8055b.substring(0, indexOf) : z1Var.f8055b;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m328a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f7478a);
        jSONObject.put("ttl", this.m);
        jSONObject.put("pct", this.l);
        jSONObject.put("ts", this.f7479b);
        jSONObject.put("city", this.f7483f);
        jSONObject.put("prv", this.f7482e);
        jSONObject.put("cty", this.f7486i);
        jSONObject.put("isp", this.f7484g);
        jSONObject.put("ip", this.f7485h);
        jSONObject.put("host", this.f7481d);
        jSONObject.put("xf", this.j);
        JSONArray jSONArray = new JSONArray();
        Iterator<z1> it = this.f7480c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.l = d2;
    }

    public void a(long j) {
        if (j > 0) {
            this.m = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public synchronized void a(z1 z1Var) {
        c(z1Var.f8055b);
        this.f7480c.add(z1Var);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m329a(String str) {
        a(new z1(str));
    }

    public void a(String str, int i2, long j, long j2, Exception exc) {
        a(str, new o1(i2, j, j2, exc));
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r4, c.k.d.o1 r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<c.k.d.z1> r0 = r3.f7480c     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            c.k.d.z1 r1 = (c.k.d.z1) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f8055b     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            goto L24
        L23:
            throw r4
        L24:
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p1.a(java.lang.String, c.k.d.o1):void");
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f7480c.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f7480c.get(size).f8055b, strArr[i2])) {
                        this.f7480c.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        Iterator<z1> it = this.f7480c.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            z1 next = it.next();
            if (next.f8057d > i3) {
                i3 = next.f8057d;
            }
        }
        while (i2 < strArr.length) {
            a(new z1(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m330a() {
        return TextUtils.equals(this.f7478a, u1.m489a());
    }

    public boolean a(p1 p1Var) {
        return TextUtils.equals(this.f7478a, p1Var.f7478a);
    }

    public void b(String str) {
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f7479b < this.m;
    }

    public final synchronized void c(String str) {
        Iterator<z1> it = this.f7480c.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f8055b, str)) {
                it.remove();
            }
        }
    }

    public boolean c() {
        long j = this.m;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f7479b;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.m && this.f7478a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7478a);
        sb.append(OSSUtils.NEW_LINE);
        sb.append(a());
        Iterator<z1> it = this.f7480c.iterator();
        while (it.hasNext()) {
            z1 next = it.next();
            sb.append(OSSUtils.NEW_LINE);
            sb.append(next.toString());
        }
        sb.append(OSSUtils.NEW_LINE);
        return sb.toString();
    }
}
