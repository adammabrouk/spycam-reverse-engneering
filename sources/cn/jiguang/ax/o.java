package cn.jiguang.ax;

import android.content.Context;
import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o implements Callable<l> {

    /* renamed from: a, reason: collision with root package name */
    public final k f8471a;

    /* renamed from: b, reason: collision with root package name */
    public final p f8472b;

    /* renamed from: c, reason: collision with root package name */
    public final f f8473c;

    /* renamed from: d, reason: collision with root package name */
    public Set<String> f8474d;

    /* renamed from: e, reason: collision with root package name */
    public g f8475e;

    public o(k kVar, g gVar, Set<String> set) {
        this.f8471a = kVar;
        this.f8472b = null;
        this.f8473c = null;
        this.f8475e = gVar;
        this.f8474d = set;
    }

    public o(k kVar, p pVar, f fVar) {
        this.f8471a = kVar;
        this.f8472b = pVar;
        this.f8473c = fVar;
    }

    public static void a(Context context, l lVar) {
        if (lVar == null || lVar.a()) {
            return;
        }
        String a2 = g.a(lVar.f8445a);
        String a3 = g.a(lVar.f8446b);
        String c2 = cn.jiguang.e.g.c(context);
        cn.jiguang.as.d.c("SisTask", "updateSisInfo ips=" + a2 + " sslIps=" + a3 + " net=" + c2);
        cn.jiguang.f.a[] aVarArr = new cn.jiguang.f.a[8];
        aVarArr[0] = cn.jiguang.f.a.L().a((cn.jiguang.f.a<String>) a2);
        aVarArr[1] = cn.jiguang.f.a.M().a((cn.jiguang.f.a<String>) a3);
        aVarArr[2] = cn.jiguang.f.a.d(false).a((cn.jiguang.f.a<String>) g.a(lVar.f8447c));
        aVarArr[3] = cn.jiguang.f.a.d(true).a((cn.jiguang.f.a<String>) g.a(lVar.f8448d));
        aVarArr[4] = cn.jiguang.f.a.Q().a((cn.jiguang.f.a<String>) g.a(lVar.f8449e));
        cn.jiguang.f.a<String> T = cn.jiguang.f.a.T();
        JSONObject jSONObject = lVar.f8450f;
        aVarArr[5] = T.a((cn.jiguang.f.a<String>) (jSONObject != null ? jSONObject.toString() : null));
        aVarArr[6] = cn.jiguang.f.a.N().a((cn.jiguang.f.a<Boolean>) Boolean.valueOf(lVar.f8452h));
        aVarArr[7] = cn.jiguang.f.a.O().a((cn.jiguang.f.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()));
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) aVarArr);
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.H().a((cn.jiguang.f.a<String>) c2)});
    }

    private Object[] a(DatagramSocket datagramSocket, InetAddress inetAddress, int i2) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] a2 = this.f8471a.a(this.f8474d);
            DatagramPacket datagramPacket = new DatagramPacket(a2, a2.length, inetAddress, i2);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] a3 = c.a(datagramSocket, datagramPacket);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                try {
                    l lVar = new l(new String(c.a(a3)));
                    if (lVar.a()) {
                        objArr[0] = 6;
                        return objArr;
                    }
                    a(this.f8471a.f8438a, lVar);
                    lVar.f8451g = new g(inetAddress, i2);
                    objArr[0] = lVar;
                    return objArr;
                } catch (cn.jiguang.az.f e2) {
                    objArr[0] = Integer.valueOf(e2.a());
                    return objArr;
                }
            } catch (Exception unused) {
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                return objArr;
            }
        } catch (cn.jiguang.az.f e3) {
            objArr[0] = Integer.valueOf(e3.a());
            return objArr;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() {
        try {
            if (this.f8473c == null) {
                return a(this.f8475e);
            }
            return a(this.f8473c.a(this.f8471a.b()));
        } catch (Throwable th) {
            cn.jiguang.as.d.g("SisTask", "run e:" + th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
    
        if (r5 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.ax.l a(cn.jiguang.ax.g r20) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ax.o.a(cn.jiguang.ax.g):cn.jiguang.ax.l");
    }
}
