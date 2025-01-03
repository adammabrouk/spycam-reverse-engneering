package c.a.a.l.j;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements e {

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<i>> f3202b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map<String, String> f3203c;

    /* compiled from: LazyHeaders.java */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final String f3204b = System.getProperty("http.agent");

        /* renamed from: c, reason: collision with root package name */
        public static final Map<String, List<i>> f3205c;

        /* renamed from: a, reason: collision with root package name */
        public Map<String, List<i>> f3206a;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f3204b)) {
                hashMap.put(HttpHeaders.USER_AGENT, Collections.singletonList(new b(f3204b)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            f3205c = Collections.unmodifiableMap(hashMap);
        }

        public a() {
            Map<String, List<i>> map = f3205c;
            this.f3206a = map;
            map.containsKey(f3204b);
        }

        public j a() {
            return new j(this.f3206a);
        }
    }

    /* compiled from: LazyHeaders.java */
    public static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        public final String f3207a;

        public b(String str) {
            this.f3207a = str;
        }

        @Override // c.a.a.l.j.i
        public String a() {
            return this.f3207a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f3207a.equals(((b) obj).f3207a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3207a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f3207a + "'}";
        }
    }

    public j(Map<String, List<i>> map) {
        this.f3202b = Collections.unmodifiableMap(map);
    }

    @Override // c.a.a.l.j.e
    public Map<String, String> a() {
        if (this.f3203c == null) {
            synchronized (this) {
                if (this.f3203c == null) {
                    this.f3203c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f3203c;
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f3202b.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            for (int i2 = 0; i2 < value.size(); i2++) {
                sb.append(value.get(i2).a());
                if (i2 != value.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f3202b.equals(((j) obj).f3202b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3202b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f3202b + '}';
    }
}
