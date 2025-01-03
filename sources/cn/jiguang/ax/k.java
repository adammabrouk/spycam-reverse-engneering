package cn.jiguang.ax;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    public static k f8437c;

    /* renamed from: a, reason: collision with root package name */
    public Context f8438a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<m> f8439b;

    /* renamed from: d, reason: collision with root package name */
    public int f8440d = 0;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f8441e;

    /* renamed from: f, reason: collision with root package name */
    public int f8442f;

    public k(Context context) {
        this.f8438a = context;
        this.f8439b = m.a((String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.I()));
    }

    public static k a(Context context) {
        if (f8437c == null) {
            synchronized (k.class) {
                if (f8437c == null) {
                    f8437c = new k(context);
                }
            }
        }
        return f8437c;
    }

    private n a(int i2) {
        double d2;
        long j;
        Bundle bundle;
        double d3;
        String e2 = cn.jiguang.d.a.e(this.f8438a);
        long f2 = cn.jiguang.d.a.f(this.f8438a);
        String b2 = cn.jiguang.e.g.b(this.f8438a);
        long currentTimeMillis = System.currentTimeMillis();
        Object a2 = cn.jiguang.az.e.a(this.f8438a, "get_loc_info", null);
        double d4 = 200.0d;
        if (a2 instanceof Bundle) {
            try {
                bundle = (Bundle) a2;
                d3 = bundle.getDouble("lat");
            } catch (Throwable unused) {
                d2 = 200.0d;
            }
            try {
                d4 = bundle.getDouble("lot");
                j = bundle.getLong("time");
                d4 = d3;
                d2 = d4;
            } catch (Throwable unused2) {
                double d5 = d4;
                d4 = d3;
                d2 = d5;
                j = currentTimeMillis;
                return new n(i2, e2, cn.jiguang.a.a.f8098b, f2, b2, d4, d2, j);
            }
        } else {
            j = currentTimeMillis;
            d2 = 200.0d;
        }
        return new n(i2, e2, cn.jiguang.a.a.f8098b, f2, b2, d4, d2, j);
    }

    private synchronized void a(m mVar) {
        this.f8439b.add(mVar);
        cn.jiguang.as.d.c("SisConnContext", "addSisReportInfo:" + mVar.a().toString());
        while (this.f8439b.size() > 30) {
            this.f8439b.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<m> it = this.f8439b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        cn.jiguang.f.b.a(this.f8438a, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.I().a((cn.jiguang.f.a<String>) jSONArray.toString())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(InetAddress inetAddress, int i2, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            return cn.jiguang.e.h.c(c.a(c.a(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i2)))) == 0;
        } catch (Throwable th) {
            cn.jiguang.as.d.i("SisConnContext", "report failed : " + th);
            return false;
        }
    }

    public l a(long j) {
        FutureTask futureTask = new FutureTask(new i(this));
        this.f8440d = 0;
        cn.jiguang.av.b.d(futureTask, new int[0]);
        if (j < 10) {
            j = 10;
        }
        try {
            return (l) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public void a(int i2, String str, int i3, long j, long j2, int i4) {
        if (g.a(str, i3)) {
            m mVar = new m();
            mVar.f8453a = cn.jiguang.d.a.e(this.f8438a);
            mVar.f8454b = i2;
            mVar.f8455c = new g(str, i3);
            mVar.f8457e = j;
            mVar.f8458f = j2;
            mVar.k = i4;
            mVar.f8459g = cn.jiguang.e.g.a(this.f8438a);
            mVar.f8456d = cn.jiguang.d.a.f(this.f8438a);
            mVar.f8460h = 200.0d;
            mVar.f8461i = 200.0d;
            mVar.j = System.currentTimeMillis();
            Object a2 = cn.jiguang.az.e.a(this.f8438a, "get_loc_info", null);
            if (a2 instanceof Bundle) {
                try {
                    Bundle bundle = (Bundle) a2;
                    mVar.f8460h = bundle.getDouble("lat");
                    mVar.f8461i = bundle.getDouble("lot");
                    mVar.j = bundle.getLong("time");
                } catch (Throwable unused) {
                }
            }
            a(mVar);
        }
    }

    public void a(final g gVar) {
        if (((Boolean) cn.jiguang.f.b.a(this.f8438a, cn.jiguang.f.a.N())).booleanValue()) {
            if (cn.jiguang.e.h.a(((Long) cn.jiguang.f.b.a(this.f8438a, cn.jiguang.f.a.P())).longValue(), JConstants.HOUR)) {
                cn.jiguang.av.b.b(new cn.jiguang.bj.b("SisConnContext#asyncSisReportIfNeed") { // from class: cn.jiguang.ax.k.1
                    @Override // cn.jiguang.bj.b
                    public void a() {
                        DatagramSocket datagramSocket;
                        Object th;
                        StringBuilder sb;
                        try {
                            datagramSocket = new DatagramSocket();
                        } catch (Throwable th2) {
                            datagramSocket = null;
                            th = th2;
                        }
                        try {
                            String str = (String) cn.jiguang.f.b.a(k.this.f8438a, cn.jiguang.f.a.I());
                            if (TextUtils.isEmpty(str)) {
                                cn.jiguang.as.d.c("SisConnContext", "reportInfo is Empty, quit report");
                                try {
                                    datagramSocket.close();
                                    return;
                                } catch (Throwable th3) {
                                    cn.jiguang.as.d.g("SisConnContext", "sisReport ,close udpsocket error:" + th3.getMessage());
                                    return;
                                }
                            }
                            byte[] a2 = c.a("DG", str);
                            cn.jiguang.as.d.c("SisConnContext", "sis report data(" + a2.length + ") at " + gVar.f8425c + ":" + gVar.f8424b);
                            if (k.this.a(gVar.f8425c, gVar.f8424b, datagramSocket, a2)) {
                                cn.jiguang.as.d.c("SisConnContext", "report succeed : " + str);
                                cn.jiguang.f.b.a(k.this.f8438a, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.P().a((cn.jiguang.f.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()))});
                                cn.jiguang.f.b.a(k.this.f8438a, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.I().a((cn.jiguang.f.a<String>) null)});
                            } else {
                                cn.jiguang.as.d.g("SisConnContext", "report failed" + str);
                            }
                            try {
                                datagramSocket.close();
                            } catch (Throwable th4) {
                                th = th4;
                                sb = new StringBuilder();
                                sb.append("sisReport ,close udpsocket error:");
                                sb.append(th.getMessage());
                                cn.jiguang.as.d.g("SisConnContext", sb.toString());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                cn.jiguang.as.d.g("SisConnContext", "sisReport failed, error:" + th);
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sb = new StringBuilder();
                                        sb.append("sisReport ,close udpsocket error:");
                                        sb.append(th.getMessage());
                                        cn.jiguang.as.d.g("SisConnContext", sb.toString());
                                    }
                                }
                            } catch (Throwable th7) {
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th8) {
                                        cn.jiguang.as.d.g("SisConnContext", "sisReport ,close udpsocket error:" + th8.getMessage());
                                    }
                                }
                                throw th7;
                            }
                        }
                    }
                }, new int[0]);
            } else {
                cn.jiguang.as.d.c("SisConnContext", "sis report: not yet");
            }
        }
    }

    public void a(boolean z) {
        this.f8440d = (z ? 1 : 2) | this.f8440d;
        cn.jiguang.ba.c.a().a(this.f8438a, this.f8440d);
    }

    public boolean a() {
        return false;
    }

    public byte[] a(Set<String> set) {
        int a2 = cn.jiguang.e.g.a(this.f8438a);
        if (this.f8441e == null || a2 != this.f8442f) {
            this.f8442f = a2;
            try {
                this.f8441e = c.a("UG", a(a2).a(set).toString());
            } catch (Exception e2) {
                throw new cn.jiguang.az.f(2, "Failed to package data - " + e2);
            }
        }
        return this.f8441e;
    }

    public int b() {
        this.f8440d = 3;
        int b2 = cn.jiguang.ba.c.a().b(this.f8440d);
        cn.jiguang.as.d.c("SisConnContext", "ipvsupport=" + this.f8440d + ", prefer=" + b2);
        return b2;
    }
}
