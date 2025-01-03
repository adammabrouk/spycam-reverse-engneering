package c.k.d;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.google.gson.internal.bind.util.ISO8601Utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class r5 {
    public static final String j = Locale.getDefault().getLanguage().toLowerCase();
    public static String k = null;
    public static final DateFormat l;
    public static String m;
    public static long n;

    /* renamed from: a, reason: collision with root package name */
    public String f7800a;

    /* renamed from: b, reason: collision with root package name */
    public String f7801b;

    /* renamed from: c, reason: collision with root package name */
    public String f7802c;

    /* renamed from: d, reason: collision with root package name */
    public String f7803d;

    /* renamed from: e, reason: collision with root package name */
    public String f7804e;

    /* renamed from: f, reason: collision with root package name */
    public String f7805f;

    /* renamed from: g, reason: collision with root package name */
    public List<o5> f7806g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f7807h;

    /* renamed from: i, reason: collision with root package name */
    public v5 f7808i;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.ISO8601_DATE_FORMAT);
        l = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ISO8601Utils.UTC_ID));
        m = c6.a(5) + "-";
        n = 0L;
    }

    public r5() {
        this.f7800a = k;
        this.f7801b = null;
        this.f7802c = null;
        this.f7803d = null;
        this.f7804e = null;
        this.f7805f = null;
        this.f7806g = new CopyOnWriteArrayList();
        this.f7807h = new HashMap();
        this.f7808i = null;
    }

    public r5(Bundle bundle) {
        this.f7800a = k;
        this.f7801b = null;
        this.f7802c = null;
        this.f7803d = null;
        this.f7804e = null;
        this.f7805f = null;
        this.f7806g = new CopyOnWriteArrayList();
        this.f7807h = new HashMap();
        this.f7808i = null;
        this.f7802c = bundle.getString("ext_to");
        this.f7803d = bundle.getString("ext_from");
        this.f7804e = bundle.getString("ext_chid");
        this.f7801b = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f7806g = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                o5 a2 = o5.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f7806g.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f7808i = new v5(bundle2);
        }
    }

    public static synchronized String j() {
        String sb;
        synchronized (r5.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m);
            long j2 = n;
            n = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String k() {
        return j;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f7800a)) {
            bundle.putString("ext_ns", this.f7800a);
        }
        if (!TextUtils.isEmpty(this.f7803d)) {
            bundle.putString("ext_from", this.f7803d);
        }
        if (!TextUtils.isEmpty(this.f7802c)) {
            bundle.putString("ext_to", this.f7802c);
        }
        if (!TextUtils.isEmpty(this.f7801b)) {
            bundle.putString("ext_pkt_id", this.f7801b);
        }
        if (!TextUtils.isEmpty(this.f7804e)) {
            bundle.putString("ext_chid", this.f7804e);
        }
        v5 v5Var = this.f7808i;
        if (v5Var != null) {
            bundle.putBundle("ext_ERROR", v5Var.a());
        }
        List<o5> list = this.f7806g;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<o5> it = this.f7806g.iterator();
            while (it.hasNext()) {
                Bundle a2 = it.next().a();
                if (a2 != null) {
                    bundleArr[i2] = a2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public o5 a(String str) {
        return a(str, null);
    }

    public o5 a(String str, String str2) {
        for (o5 o5Var : this.f7806g) {
            if (str2 == null || str2.equals(o5Var.b())) {
                if (str.equals(o5Var.m323a())) {
                    return o5Var;
                }
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public v5 m447a() {
        return this.f7808i;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Object m448a(String str) {
        if (this.f7807h == null) {
            return null;
        }
        return this.f7807h.get(str);
    }

    /* renamed from: a */
    public abstract String mo336a();

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<o5> m449a() {
        if (this.f7806g == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f7806g));
    }

    public void a(o5 o5Var) {
        this.f7806g.add(o5Var);
    }

    public void a(v5 v5Var) {
        this.f7808i = v5Var;
    }

    public synchronized Collection<String> b() {
        if (this.f7807h == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f7807h.keySet()));
    }

    public void b(String str) {
        this.f7801b = str;
    }

    public String c() {
        if ("ID_NOT_AVAILABLE".equals(this.f7801b)) {
            return null;
        }
        if (this.f7801b == null) {
            this.f7801b = j();
        }
        return this.f7801b;
    }

    public void c(String str) {
        this.f7804e = str;
    }

    public String d() {
        return this.f7804e;
    }

    public void d(String str) {
        this.f7802c = str;
    }

    public String e() {
        return this.f7802c;
    }

    public void e(String str) {
        this.f7803d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r5 r5Var = (r5) obj;
        v5 v5Var = this.f7808i;
        if (v5Var == null ? r5Var.f7808i != null : !v5Var.equals(r5Var.f7808i)) {
            return false;
        }
        String str = this.f7803d;
        if (str == null ? r5Var.f7803d != null : !str.equals(r5Var.f7803d)) {
            return false;
        }
        if (!this.f7806g.equals(r5Var.f7806g)) {
            return false;
        }
        String str2 = this.f7801b;
        if (str2 == null ? r5Var.f7801b != null : !str2.equals(r5Var.f7801b)) {
            return false;
        }
        String str3 = this.f7804e;
        if (str3 == null ? r5Var.f7804e != null : !str3.equals(r5Var.f7804e)) {
            return false;
        }
        Map<String, Object> map = this.f7807h;
        if (map == null ? r5Var.f7807h != null : !map.equals(r5Var.f7807h)) {
            return false;
        }
        String str4 = this.f7802c;
        if (str4 == null ? r5Var.f7802c != null : !str4.equals(r5Var.f7802c)) {
            return false;
        }
        String str5 = this.f7800a;
        String str6 = r5Var.f7800a;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f7803d;
    }

    public void f(String str) {
        this.f7805f = str;
    }

    public String g() {
        return this.f7805f;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String h() {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.r5.h():java.lang.String");
    }

    public int hashCode() {
        String str = this.f7800a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7801b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7802c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f7803d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f7804e;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f7806g.hashCode()) * 31) + this.f7807h.hashCode()) * 31;
        v5 v5Var = this.f7808i;
        return hashCode5 + (v5Var != null ? v5Var.hashCode() : 0);
    }

    public String i() {
        return this.f7800a;
    }
}
