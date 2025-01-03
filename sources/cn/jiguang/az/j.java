package cn.jiguang.az;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import cn.jiguang.api.JCoreManager;
import com.tencent.bugly.BuglyStrategy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile j f8604a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8605b = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static long f8606e = 1;

    /* renamed from: d, reason: collision with root package name */
    public cn.jiguang.bd.a f8608d = new cn.jiguang.bd.a() { // from class: cn.jiguang.az.j.1
        @Override // cn.jiguang.bd.a
        public void a(Message message) {
            long j = message.what - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            Bundle bundle = new Bundle();
            bundle.putLong("rid", j);
            h.a().a(JCoreManager.getAppContext(null), "tcp_a6", bundle);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public Map<Long, d> f8607c = new HashMap();

    public static j a() {
        if (f8604a == null) {
            synchronized (f8605b) {
                if (f8604a == null) {
                    f8604a = new j();
                }
            }
        }
        return f8604a;
    }

    private byte[] a(Context context, d dVar) {
        return cn.jiguang.bb.b.a(context, dVar.f8558d, dVar.f8559e, dVar.f8560f, dVar.f8561g, 0L);
    }

    public static long b() {
        long j = f8606e + 1;
        f8606e = j;
        if (j >= 2147483647L) {
            f8606e = 1L;
        }
        return f8606e;
    }

    public d a(long j) {
        return this.f8607c.get(Long.valueOf(j));
    }

    public void a(Context context) {
        if (this.f8607c.isEmpty()) {
            cn.jiguang.as.d.c("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, d> entry : this.f8607c.entrySet()) {
            if (entry.getValue().j) {
                long nanoTime = System.nanoTime() - entry.getValue().f8562h;
                if (entry.getValue().f8563i - nanoTime >= 10000) {
                    entry.getValue().a();
                    cn.jiguang.as.d.c("TcpRequestManager", "send again:" + entry.getValue());
                    h.a().c().d().a(a(context, entry.getValue()));
                } else {
                    cn.jiguang.as.d.c("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + nanoTime + ",timeout:" + entry.getValue().f8563i);
                }
            }
        }
    }

    public void a(Context context, long j) {
        d remove = this.f8607c.remove(Long.valueOf(j));
        if (remove != null) {
            if (remove.j) {
                cn.jiguang.bd.b.a().b((int) (j + 100000));
            }
            cn.jiguang.as.d.c("TcpRequestManager", "handle reponse :" + remove);
        }
    }

    public void a(Context context, long j, int i2, int i3, byte[] bArr, String str) {
        long c2 = cn.jiguang.ax.c.c(context);
        if (this.f8607c.containsKey(Long.valueOf(c2))) {
            cn.jiguang.as.d.h("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        d dVar = new d(j, str, i2, i3, c2, 0L, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        }
        this.f8607c.put(Long.valueOf(c2), dVar);
    }

    public void a(Context context, long j, int i2, int i3, byte[] bArr, String str, long j2) {
        long j3;
        if (i2 == 10) {
            j3 = j;
        } else {
            long c2 = cn.jiguang.ax.c.c(context);
            cn.jiguang.as.d.c("TcpRequestManager", "Generator new rid:" + c2);
            if (this.f8607c.containsKey(Long.valueOf(c2))) {
                cn.jiguang.as.d.h("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j3 = c2;
        }
        long j4 = j2 <= 0 ? 10000L : j2;
        long j5 = j4;
        d dVar = new d(j, str, i2, i3, j3, j4, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        }
        dVar.f8562h = System.nanoTime();
        this.f8607c.put(Long.valueOf(j3), dVar);
        cn.jiguang.bd.b.a().b((int) (j3 + 100000), j5, this.f8608d);
    }

    public void b(Context context, long j) {
        d remove = this.f8607c.remove(Long.valueOf(j));
        if (remove == null) {
            cn.jiguang.as.d.g("TcpRequestManager", "not found requst by rid:" + j);
            return;
        }
        cn.jiguang.as.d.c("TcpRequestManager", "request time out:" + remove);
        b.a().a(context, remove.f8557c, remove.f8556b, remove.f8558d);
    }
}
