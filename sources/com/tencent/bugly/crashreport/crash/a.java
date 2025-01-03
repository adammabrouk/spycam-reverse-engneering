package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class a implements Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f10916a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f10917b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f10918c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10919d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10920e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f10921f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        a aVar2 = aVar;
        if (aVar2 == null) {
            return 1;
        }
        long j = this.f10917b - aVar2.f10917b;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }
}
