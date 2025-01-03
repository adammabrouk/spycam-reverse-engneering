package c.k.b.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.o0;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f6751a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6752b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6753c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6754d;

    /* renamed from: e, reason: collision with root package name */
    public long f6755e;

    /* renamed from: f, reason: collision with root package name */
    public long f6756f;

    /* renamed from: g, reason: collision with root package name */
    public long f6757g;

    /* renamed from: c.k.b.a.a$a, reason: collision with other inner class name */
    public static class C0127a {

        /* renamed from: a, reason: collision with root package name */
        public int f6758a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f6759b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f6760c = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f6761d = null;

        /* renamed from: e, reason: collision with root package name */
        public long f6762e = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f6763f = -1;

        /* renamed from: g, reason: collision with root package name */
        public long f6764g = -1;

        public C0127a a(long j) {
            this.f6763f = j;
            return this;
        }

        public C0127a a(String str) {
            this.f6761d = str;
            return this;
        }

        public C0127a a(boolean z) {
            this.f6758a = z ? 1 : 0;
            return this;
        }

        public a a(Context context) {
            return new a(context, this);
        }

        public C0127a b(long j) {
            this.f6762e = j;
            return this;
        }

        public C0127a b(boolean z) {
            this.f6759b = z ? 1 : 0;
            return this;
        }

        public C0127a c(long j) {
            this.f6764g = j;
            return this;
        }

        public C0127a c(boolean z) {
            this.f6760c = z ? 1 : 0;
            return this;
        }
    }

    public a(Context context, C0127a c0127a) {
        this.f6752b = true;
        this.f6753c = false;
        this.f6754d = false;
        this.f6755e = 1048576L;
        this.f6756f = 86400L;
        this.f6757g = 86400L;
        if (c0127a.f6758a == 0) {
            this.f6752b = false;
        } else {
            int unused = c0127a.f6758a;
            this.f6752b = true;
        }
        this.f6751a = !TextUtils.isEmpty(c0127a.f6761d) ? c0127a.f6761d : o0.a(context);
        this.f6755e = c0127a.f6762e > -1 ? c0127a.f6762e : 1048576L;
        if (c0127a.f6763f > -1) {
            this.f6756f = c0127a.f6763f;
        } else {
            this.f6756f = 86400L;
        }
        if (c0127a.f6764g > -1) {
            this.f6757g = c0127a.f6764g;
        } else {
            this.f6757g = 86400L;
        }
        if (c0127a.f6759b != 0 && c0127a.f6759b == 1) {
            this.f6753c = true;
        } else {
            this.f6753c = false;
        }
        if (c0127a.f6760c != 0 && c0127a.f6760c == 1) {
            this.f6754d = true;
        } else {
            this.f6754d = false;
        }
    }

    public static a a(Context context) {
        C0127a g2 = g();
        g2.a(true);
        g2.a(o0.a(context));
        g2.b(1048576L);
        g2.b(false);
        g2.a(86400L);
        g2.c(false);
        g2.c(86400L);
        return g2.a(context);
    }

    public static C0127a g() {
        return new C0127a();
    }

    public long a() {
        return this.f6756f;
    }

    public long b() {
        return this.f6755e;
    }

    public long c() {
        return this.f6757g;
    }

    public boolean d() {
        return this.f6752b;
    }

    public boolean e() {
        return this.f6753c;
    }

    public boolean f() {
        return this.f6754d;
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.f6752b + ", mAESKey='" + this.f6751a + "', mMaxFileLength=" + this.f6755e + ", mEventUploadSwitchOpen=" + this.f6753c + ", mPerfUploadSwitchOpen=" + this.f6754d + ", mEventUploadFrequency=" + this.f6756f + ", mPerfUploadFrequency=" + this.f6757g + '}';
    }
}
