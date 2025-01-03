package cn.jiguang.bf;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public volatile cn.jiguang.bg.i f8711a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8712b = new Object();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final cn.jiguang.bg.i f8713a;

        /* renamed from: b, reason: collision with root package name */
        public final cn.jiguang.bg.i f8714b;

        public a(cn.jiguang.bg.i iVar, cn.jiguang.bg.i iVar2) {
            this.f8714b = iVar;
            this.f8713a = iVar2;
        }
    }

    public cn.jiguang.bg.i a() {
        cn.jiguang.bg.i clone;
        synchronized (this.f8712b) {
            clone = this.f8711a != null ? this.f8711a.clone() : null;
        }
        return clone;
    }

    public a b() {
        a aVar;
        synchronized (this.f8712b) {
            if (this.f8711a != null) {
                this.f8711a.i();
            }
            cn.jiguang.bg.i iVar = this.f8711a;
            this.f8711a = new cn.jiguang.bg.i();
            aVar = new a(this.f8711a.clone(), iVar != null ? iVar.clone() : null);
        }
        return aVar;
    }
}
