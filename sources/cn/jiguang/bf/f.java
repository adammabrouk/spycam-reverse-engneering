package cn.jiguang.bf;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f8710a;

    public f() {
        this(Looper.getMainLooper());
    }

    public f(Looper looper) {
        this.f8710a = new Handler(looper);
    }

    @Override // cn.jiguang.bf.e
    public Thread a() {
        return this.f8710a.getLooper().getThread();
    }

    @Override // cn.jiguang.bf.e
    public void a(Runnable runnable) {
        this.f8710a.post(runnable);
    }
}
