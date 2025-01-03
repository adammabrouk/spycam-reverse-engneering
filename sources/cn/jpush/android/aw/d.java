package cn.jpush.android.aw;

import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public List<a> f9418a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9419a;

        /* renamed from: b, reason: collision with root package name */
        public String f9420b;

        /* renamed from: c, reason: collision with root package name */
        public String f9421c;

        /* renamed from: d, reason: collision with root package name */
        public String f9422d;

        /* renamed from: e, reason: collision with root package name */
        public int f9423e;

        /* renamed from: f, reason: collision with root package name */
        public int f9424f;

        /* renamed from: g, reason: collision with root package name */
        public String f9425g;

        public int a() {
            return this.f9419a;
        }

        public void a(int i2) {
            this.f9419a = i2;
        }

        public void a(String str) {
            this.f9420b = str;
        }

        public String b() {
            return this.f9421c;
        }

        public void b(int i2) {
            this.f9423e = i2;
        }

        public void b(String str) {
            this.f9421c = str;
        }

        public String c() {
            return this.f9422d;
        }

        public void c(int i2) {
            this.f9424f = i2;
        }

        public void c(String str) {
            this.f9422d = str;
        }

        public int d() {
            return this.f9423e;
        }

        public void d(String str) {
            this.f9425g = str;
        }

        public int e() {
            return this.f9424f;
        }

        public String f() {
            return this.f9425g;
        }

        public String toString() {
            return "InMatches{version=" + this.f9419a + ", manufacturer='" + this.f9420b + "', model='" + this.f9421c + "', rom='" + this.f9422d + "', android_min=" + this.f9423e + ", android_max=" + this.f9424f + ", file_path='" + this.f9425g + "'}";
        }
    }

    public List<a> a() {
        return this.f9418a;
    }

    public void a(List<a> list) {
        this.f9418a = list;
    }

    public String toString() {
        return "InAppMatchesConfig{inMatchesList=" + this.f9418a + '}';
    }
}
