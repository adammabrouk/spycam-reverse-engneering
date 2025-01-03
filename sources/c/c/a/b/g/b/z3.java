package c.c.a.b.g.b;

import cn.jpush.android.service.WakedResultReceiver;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5215b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5216c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5217d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5218e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w3 f5219f;

    public z3(w3 w3Var, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f5219f = w3Var;
        this.f5214a = i2;
        this.f5215b = str;
        this.f5216c = obj;
        this.f5217d = obj2;
        this.f5218e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        long j;
        char c3;
        long j2;
        j4 p = this.f5219f.f5160a.p();
        if (!p.r()) {
            this.f5219f.a(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c2 = this.f5219f.f5153c;
        if (c2 == 0) {
            if (this.f5219f.l().o()) {
                w3 w3Var = this.f5219f;
                w3Var.F();
                w3Var.f5153c = 'C';
            } else {
                w3 w3Var2 = this.f5219f;
                w3Var2.F();
                w3Var2.f5153c = 'c';
            }
        }
        j = this.f5219f.f5154d;
        if (j < 0) {
            w3 w3Var3 = this.f5219f;
            w3Var3.f5154d = w3Var3.l().n();
        }
        char charAt = "01VDIWEA?".charAt(this.f5214a);
        c3 = this.f5219f.f5153c;
        j2 = this.f5219f.f5154d;
        String a2 = w3.a(true, this.f5215b, this.f5216c, this.f5217d, this.f5218e);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 24);
        sb.append(WakedResultReceiver.WAKE_TYPE_KEY);
        sb.append(charAt);
        sb.append(c3);
        sb.append(j2);
        sb.append(":");
        sb.append(a2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f5215b.substring(0, 1024);
        }
        p.f4826d.a(sb2, 1L);
    }
}
