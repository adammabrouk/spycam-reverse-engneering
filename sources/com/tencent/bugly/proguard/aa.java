package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f11037a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11038b;

    /* renamed from: c, reason: collision with root package name */
    public long f11039c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11040d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11041e = true;

    /* renamed from: f, reason: collision with root package name */
    public long f11042f;

    public aa(Handler handler, String str, long j) {
        this.f11037a = handler;
        this.f11038b = str;
        this.f11039c = j;
        this.f11040d = j;
    }

    public final void a() {
        if (this.f11041e) {
            this.f11041e = false;
            this.f11042f = SystemClock.uptimeMillis();
            this.f11037a.post(this);
        }
    }

    public final boolean b() {
        return !this.f11041e && SystemClock.uptimeMillis() > this.f11042f + this.f11039c;
    }

    public final int c() {
        if (this.f11041e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f11042f < this.f11039c ? 1 : 3;
    }

    public final String d() {
        return this.f11038b;
    }

    public final Looper e() {
        return this.f11037a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11041e = true;
        this.f11039c = this.f11040d;
    }

    public final void a(long j) {
        this.f11039c = RecyclerView.FOREVER_NS;
    }
}
