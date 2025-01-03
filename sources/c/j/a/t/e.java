package c.j.a.t;

import android.text.TextUtils;

/* compiled from: PushPackageInfo.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f6656a;

    /* renamed from: b, reason: collision with root package name */
    public long f6657b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f6658c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6659d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6660e = false;

    public e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f6656a = str;
    }

    public final String a() {
        return this.f6656a;
    }

    public final void a(String str) {
    }

    public final long b() {
        return this.f6657b;
    }

    public final boolean c() {
        return this.f6659d;
    }

    public final boolean d() {
        return this.f6660e;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f6656a + ", mPushVersion=" + this.f6657b + ", mPackageVersion=" + this.f6658c + ", mInBlackList=" + this.f6659d + ", mPushEnable=" + this.f6660e + "}";
    }

    public final void a(long j) {
        this.f6657b = j;
    }

    public final void b(boolean z) {
        this.f6660e = z;
    }

    public final void a(boolean z) {
        this.f6659d = z;
    }

    public final void a(int i2) {
        this.f6658c = i2;
    }
}
