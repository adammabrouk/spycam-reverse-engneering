package c.k.d;

import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class i6 implements r.b.a {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f7251a;

    /* renamed from: b, reason: collision with root package name */
    public r.b f7252b;

    /* renamed from: c, reason: collision with root package name */
    public z4 f7253c;

    /* renamed from: e, reason: collision with root package name */
    public int f7255e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7256f = false;

    /* renamed from: d, reason: collision with root package name */
    public r.c f7254d = r.c.binding;

    public i6(XMPushService xMPushService, r.b bVar) {
        this.f7251a = xMPushService;
        this.f7252b = bVar;
    }

    public void a() {
        this.f7252b.a(this);
        this.f7253c = this.f7251a.m586a();
    }

    @Override // c.k.d.p9.r.b.a
    public void a(r.c cVar, r.c cVar2, int i2) {
        if (!this.f7256f && cVar == r.c.binding) {
            this.f7254d = cVar2;
            this.f7255e = i2;
            this.f7256f = true;
        }
        this.f7251a.a(new j6(this, 4));
    }

    public final void b() {
        this.f7252b.b(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            r4 = this;
            r4.b()
            boolean r0 = r4.f7256f
            if (r0 != 0) goto L8
            return
        L8:
            int r0 = r4.f7255e
            r1 = 11
            if (r0 != r1) goto Lf
            return
        Lf:
            c.k.d.n6 r0 = c.k.d.n6.m307a()
            c.k.d.p4 r0 = r0.m308a()
            int[] r1 = c.k.d.k6.f7324a
            c.k.d.p9.r$c r2 = r4.f7254d
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L31
            r3 = 3
            if (r1 == r3) goto L28
            goto L5c
        L28:
            c.k.d.o4 r1 = c.k.d.o4.BIND_SUCCESS
        L2a:
            int r1 = r1.a()
            r0.f74a = r1
            goto L5c
        L31:
            int r1 = r4.f7255e
            r3 = 17
            if (r1 != r3) goto L3a
            c.k.d.o4 r1 = c.k.d.o4.BIND_TCP_READ_TIMEOUT
            goto L2a
        L3a:
            r3 = 21
            if (r1 != r3) goto L41
            c.k.d.o4 r1 = c.k.d.o4.BIND_TIMEOUT
            goto L2a
        L41:
            c.k.d.m6 r1 = c.k.d.n6.a()     // Catch: java.lang.NullPointerException -> L5b
            java.lang.Exception r1 = r1.a()     // Catch: java.lang.NullPointerException -> L5b
            c.k.d.l6$a r1 = c.k.d.l6.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            c.k.d.o4 r3 = r1.f7350a     // Catch: java.lang.NullPointerException -> L5b
            int r3 = r3.a()     // Catch: java.lang.NullPointerException -> L5b
            r0.f74a = r3     // Catch: java.lang.NullPointerException -> L5b
            java.lang.String r1 = r1.f7351b     // Catch: java.lang.NullPointerException -> L5b
            r0.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == 0) goto L83
            c.k.d.z4 r1 = r4.f7253c
            java.lang.String r1 = r1.mo543a()
            r0.b(r1)
            c.k.d.p9.r$b r1 = r4.f7252b
            java.lang.String r1 = r1.f7678b
            r0.d(r1)
            r0.f7495b = r2
            c.k.d.p9.r$b r1 = r4.f7252b     // Catch: java.lang.NumberFormatException -> L7c
            java.lang.String r1 = r1.f7684h     // Catch: java.lang.NumberFormatException -> L7c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L7c
            byte r1 = (byte) r1     // Catch: java.lang.NumberFormatException -> L7c
            r0.a(r1)     // Catch: java.lang.NumberFormatException -> L7c
        L7c:
            c.k.d.n6 r1 = c.k.d.n6.m307a()
            r1.a(r0)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.i6.c():void");
    }
}
