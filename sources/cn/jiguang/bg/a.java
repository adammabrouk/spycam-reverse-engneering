package cn.jiguang.bg;

/* loaded from: classes.dex */
public final class a extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final Thread f8737a;

    public a(String str, Thread thread) {
        super(str);
        this.f8737a = thread;
        setStackTrace(thread.getStackTrace());
    }

    public Thread a() {
        return this.f8737a;
    }
}
