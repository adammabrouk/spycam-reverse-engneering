package c.j.a.j;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: ClientConfigManagerImpl.java */
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f6558d;

    /* renamed from: a, reason: collision with root package name */
    public Context f6559a;

    /* renamed from: b, reason: collision with root package name */
    public b f6560b;

    /* renamed from: c, reason: collision with root package name */
    public f f6561c;

    public a(Context context) {
        this.f6559a = c.j.a.z.c.c(context);
        this.f6560b = new b(this.f6559a);
        this.f6561c = new f(this.f6559a);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f6558d == null) {
                f6558d = new a(context);
            }
            aVar = f6558d;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            r3 = this;
            c.j.a.j.f r0 = r3.f()
            java.lang.String r1 = "PSM"
            java.lang.String r0 = r0.c(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L16
            goto L1b
        L16:
            r0 = move-exception
            r0.printStackTrace()
        L1a:
            r0 = 0
        L1b:
            r0 = r0 & 4
            if (r0 == 0) goto L21
            r0 = 1
            return r0
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.j.a.j.a.b():boolean");
    }

    public boolean c() {
        this.f6560b.c();
        return b.a(this.f6560b.b());
    }

    public boolean d() {
        e();
        c.j.a.t.d c2 = this.f6560b.c(this.f6559a.getPackageName());
        if (c2 != null) {
            return "1".equals(c2.b());
        }
        return true;
    }

    public final void e() {
        b bVar = this.f6560b;
        if (bVar == null) {
            this.f6560b = new b(this.f6559a);
        } else {
            bVar.c();
        }
    }

    public final f f() {
        f fVar = this.f6561c;
        if (fVar == null) {
            this.f6561c = new f(this.f6559a);
        } else {
            fVar.c();
        }
        return this.f6561c;
    }

    public void a() {
        this.f6560b.d();
    }

    @Override // c.j.a.j.e
    public boolean a(long j) {
        String c2 = f().c("BL");
        if (!TextUtils.isEmpty(c2)) {
            for (String str : c2.split(",")) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j) {
                        return true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean a(int i2) {
        return b.a(i2);
    }
}
