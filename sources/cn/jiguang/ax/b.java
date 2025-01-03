package cn.jiguang.ax;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b implements Callable<cn.jiguang.bc.a> {

    /* renamed from: a, reason: collision with root package name */
    public final k f8410a;

    /* renamed from: b, reason: collision with root package name */
    public final p f8411b;

    /* renamed from: c, reason: collision with root package name */
    public final f f8412c;

    /* renamed from: d, reason: collision with root package name */
    public final h f8413d;

    public b(k kVar, p pVar, f fVar, h hVar) {
        this.f8411b = pVar;
        this.f8410a = kVar;
        this.f8412c = fVar;
        this.f8413d = hVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public cn.jiguang.bc.a call() {
        try {
            if (this.f8412c == null) {
                return null;
            }
            return a(this.f8412c.a(this.f8410a.b()));
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ConnTask", "run e:" + th);
            return null;
        }
    }

    public cn.jiguang.bc.a a(g gVar) {
        if (this.f8411b.a()) {
            return null;
        }
        h hVar = this.f8413d;
        if (hVar == null || hVar.f8426a) {
            this.f8411b.a(new cn.jiguang.az.f(-991, null));
            return null;
        }
        if (gVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(cn.jiguang.aw.a.f8403c)) {
            String str = cn.jiguang.aw.a.f8403c;
            gVar.f8423a = str;
            gVar.f8425c = InetAddress.getByName(str);
        }
        int i2 = cn.jiguang.aw.a.f8404d;
        if (i2 > 0) {
            gVar.f8424b = i2;
        }
        cn.jiguang.as.d.d("ConnTask", "Open connection with ip=" + gVar.f8425c + ", port:" + gVar.f8424b);
        long uptimeMillis = SystemClock.uptimeMillis();
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(8128, 20);
        int a2 = bVar.a(gVar.f8423a, gVar.f8424b);
        if (this.f8411b.a()) {
            cn.jiguang.e.h.a(bVar);
            return null;
        }
        if (this.f8413d.f8426a) {
            this.f8411b.a(new cn.jiguang.az.f(-991, null));
            cn.jiguang.e.h.a(bVar);
            return null;
        }
        if (a2 == 0) {
            cn.jiguang.f.b.a(this.f8410a.f8438a, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.c((gVar.f8425c instanceof Inet4Address) || cn.jiguang.e.f.f(gVar.f8423a)).a((cn.jiguang.f.a<String>) gVar.toString())});
            cn.jiguang.as.d.f("ConnTask", "Succeed to open connection - ip:" + gVar.f8425c + ", port:" + gVar.f8424b);
            this.f8411b.a(bVar);
            e.a(this.f8410a.f8438a, gVar, 1, 0L);
            return bVar;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        this.f8410a.a(2, gVar.f8423a, gVar.f8424b, cn.jiguang.d.b.b(this.f8410a.f8438a), uptimeMillis2, a2);
        cn.jiguang.as.d.e("ConnTask", "Failed(" + a2 + ") to open connection - ip:" + gVar.f8425c + ", port:" + gVar.f8424b + ", cost:" + uptimeMillis2);
        e.a(this.f8410a.f8438a, gVar, -1, uptimeMillis2);
        cn.jiguang.e.h.a(bVar);
        return null;
    }
}
