package h;

import h.r;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final s f11788a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11789b;

    /* renamed from: c, reason: collision with root package name */
    public final r f11790c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final z f11791d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, Object> f11792e;

    /* renamed from: f, reason: collision with root package name */
    public volatile d f11793f;

    public y(a aVar) {
        this.f11788a = aVar.f11794a;
        this.f11789b = aVar.f11795b;
        this.f11790c = aVar.f11796c.a();
        this.f11791d = aVar.f11797d;
        this.f11792e = h.e0.c.a(aVar.f11798e);
    }

    @Nullable
    public String a(String str) {
        return this.f11790c.a(str);
    }

    public d b() {
        d dVar = this.f11793f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f11790c);
        this.f11793f = a2;
        return a2;
    }

    public r c() {
        return this.f11790c;
    }

    public boolean d() {
        return this.f11788a.h();
    }

    public String e() {
        return this.f11789b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.f11788a;
    }

    public String toString() {
        return "Request{method=" + this.f11789b + ", url=" + this.f11788a + ", tags=" + this.f11792e + '}';
    }

    /* compiled from: Request.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public s f11794a;

        /* renamed from: b, reason: collision with root package name */
        public String f11795b;

        /* renamed from: c, reason: collision with root package name */
        public r.a f11796c;

        /* renamed from: d, reason: collision with root package name */
        public z f11797d;

        /* renamed from: e, reason: collision with root package name */
        public Map<Class<?>, Object> f11798e;

        public a() {
            this.f11798e = Collections.emptyMap();
            this.f11795b = "GET";
            this.f11796c = new r.a();
        }

        public a a(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f11794a = sVar;
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            a(s.d(str));
            return this;
        }

        public a c() {
            a("GET", (z) null);
            return this;
        }

        public a d() {
            a("HEAD", (z) null);
            return this;
        }

        public a a(String str, String str2) {
            this.f11796c.a(str, str2);
            return this;
        }

        public a a(String str) {
            this.f11796c.b(str);
            return this;
        }

        public a(y yVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.f11798e = Collections.emptyMap();
            this.f11794a = yVar.f11788a;
            this.f11795b = yVar.f11789b;
            this.f11797d = yVar.f11791d;
            if (yVar.f11792e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(yVar.f11792e);
            }
            this.f11798e = linkedHashMap;
            this.f11796c = yVar.f11790c.a();
        }

        public a a(r rVar) {
            this.f11796c = rVar.a();
            return this;
        }

        public a a(@Nullable z zVar) {
            a("DELETE", zVar);
            return this;
        }

        public a a(String str, @Nullable z zVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (zVar != null && !h.e0.g.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (zVar == null && h.e0.g.f.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.f11795b = str;
                    this.f11797d = zVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a b(String str, String str2) {
            this.f11796c.d(str, str2);
            return this;
        }

        public a b() {
            a(h.e0.c.f11398d);
            return this;
        }

        public y a() {
            if (this.f11794a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    @Nullable
    public z a() {
        return this.f11791d;
    }
}
