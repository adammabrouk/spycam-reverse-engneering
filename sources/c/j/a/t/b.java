package c.j.a.t;

import java.util.HashMap;
import java.util.Map;

/* compiled from: UPSNotificationMessage.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f6641a;

    /* renamed from: b, reason: collision with root package name */
    public String f6642b;

    /* renamed from: c, reason: collision with root package name */
    public String f6643c;

    /* renamed from: d, reason: collision with root package name */
    public String f6644d;

    /* renamed from: e, reason: collision with root package name */
    public int f6645e;

    /* renamed from: f, reason: collision with root package name */
    public String f6646f;

    /* renamed from: g, reason: collision with root package name */
    public String f6647g;

    /* renamed from: h, reason: collision with root package name */
    public String f6648h;

    /* renamed from: i, reason: collision with root package name */
    public String f6649i;
    public int j;
    public boolean k;
    public long l;
    public Map<String, String> m = new HashMap();
    public int n;
    public String o;
    public int p;

    public void a(long j) {
        this.l = j;
    }

    public void b(String str) {
        this.f6644d = str;
    }

    public void c(String str) {
        this.f6648h = str;
    }

    public void d(String str) {
        this.f6647g = str;
    }

    public void e(int i2) {
        this.f6641a = i2;
    }

    public String f() {
        return this.f6648h;
    }

    public String g() {
        return this.f6647g;
    }

    public void h(String str) {
        this.f6642b = str;
    }

    public long i() {
        return this.l;
    }

    public int j() {
        return this.f6645e;
    }

    public Map<String, String> k() {
        return this.m;
    }

    public String l() {
        return this.f6646f;
    }

    public String m() {
        return this.f6649i;
    }

    public int n() {
        return this.j;
    }

    public int o() {
        return this.f6641a;
    }

    public String p() {
        return this.f6643c;
    }

    public String q() {
        return this.f6642b;
    }

    public boolean r() {
        return this.k;
    }

    public String toString() {
        return "UPSNotificationMessage{mTargetType=" + this.f6641a + ", mTragetContent='" + this.f6642b + "', mTitle='" + this.f6643c + "', mContent='" + this.f6644d + "', mNotifyType=" + this.f6645e + ", mPurePicUrl='" + this.f6646f + "', mIconUrl='" + this.f6647g + "', mCoverUrl='" + this.f6648h + "', mSkipContent='" + this.f6649i + "', mSkipType=" + this.j + ", mShowTime=" + this.k + ", mMsgId=" + this.l + ", mParams=" + this.m + '}';
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void b() {
        this.f6646f = "";
    }

    public void c(int i2) {
        this.f6645e = i2;
    }

    public void d(int i2) {
        this.j = i2;
    }

    public String e() {
        return this.f6644d;
    }

    public void f(String str) {
        this.f6649i = str;
    }

    public void g(String str) {
        this.f6643c = str;
    }

    public int h() {
        return this.n;
    }

    public void a() {
        this.f6647g = "";
    }

    public void b(int i2) {
        this.n = i2;
    }

    public String c() {
        return this.o;
    }

    public int d() {
        return this.p;
    }

    public void e(String str) {
        this.f6646f = str;
    }

    public void a(Map<String, String> map) {
        this.m = map;
    }

    public void a(String str) {
        this.o = str;
    }

    public void a(int i2) {
        this.p = i2;
    }
}
