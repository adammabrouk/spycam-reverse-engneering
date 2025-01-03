package cn.jiguang.ay;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static volatile l f8536a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8537b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f8538c = JConstants.DAY;

    /* renamed from: d, reason: collision with root package name */
    public long f8539d = 1800000;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, Pair<LinkedHashSet<cn.jiguang.ax.g>, Long>> f8540e = new HashMap();

    public static class a implements Callable<LinkedHashSet<cn.jiguang.ax.g>> {

        /* renamed from: a, reason: collision with root package name */
        public String f8541a;

        /* renamed from: b, reason: collision with root package name */
        public l f8542b;

        public a(String str, l lVar) {
            this.f8541a = str;
            this.f8542b = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LinkedHashSet<cn.jiguang.ax.g> call() {
            LinkedHashSet<cn.jiguang.ax.g> a2 = l.a(this.f8541a);
            if (a2 != null && a2.size() > 0) {
                this.f8542b.a(this.f8541a, (Pair<LinkedHashSet<cn.jiguang.ax.g>, Long>) new Pair(a2, Long.valueOf(System.currentTimeMillis())));
            }
            return a2;
        }
    }

    private Pair<LinkedHashSet<cn.jiguang.ax.g>, Boolean> a(String str, long j, long j2) {
        Object obj;
        Pair<LinkedHashSet<cn.jiguang.ax.g>, Long> pair = this.f8540e.get(str);
        boolean z = pair == null || (obj = pair.first) == null || ((LinkedHashSet) obj).size() == 0;
        long longValue = ((Long) (z ? cn.jiguang.f.b.a((Context) null, cn.jiguang.f.a.e(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            String str2 = (String) cn.jiguang.f.b.a((Context) null, cn.jiguang.f.a.d(str));
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    cn.jiguang.ax.g a2 = cn.jiguang.ax.g.a(str3);
                    if (a2 != null && a2.a()) {
                        linkedHashSet.add(a2);
                    }
                }
                this.f8540e.put(str, new Pair<>(linkedHashSet, Long.valueOf(System.currentTimeMillis())));
            }
        } else {
            linkedHashSet = (LinkedHashSet) pair.first;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new Pair<>(linkedHashSet, Boolean.valueOf(currentTimeMillis > longValue + j2));
    }

    public static l a() {
        if (f8536a == null) {
            synchronized (f8537b) {
                if (f8536a == null) {
                    f8536a = new l();
                }
            }
        }
        return f8536a;
    }

    public static LinkedHashSet<cn.jiguang.ax.g> a(String str) {
        String[] a2;
        e eVar;
        i a3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b2 = b(str);
            cn.jiguang.as.d.c("SRVLoader", "srv host:" + str);
            LinkedHashSet<cn.jiguang.ax.g> linkedHashSet = new LinkedHashSet<>();
            try {
                a2 = k.b().a();
            } catch (Throwable th) {
                cn.jiguang.as.d.h("SRVLoader", "Get default ports error with Exception:" + th);
            }
            if (a2 != null && a2.length != 0) {
                LinkedHashSet<InetAddress> linkedHashSet2 = new LinkedHashSet();
                cn.jiguang.ba.b a4 = cn.jiguang.ba.b.a();
                for (String str2 : a2) {
                    InetAddress a5 = a4.a((Context) null, str2, NetworkUtils.SCAN_PERIOD_MILLIS, false);
                    if (a5 != null) {
                        linkedHashSet2.add(a5);
                    }
                }
                for (InetAddress inetAddress : linkedHashSet2) {
                    try {
                        eVar = new e(o.a(null, new InetSocketAddress(inetAddress, 53), b2, System.currentTimeMillis() + 1000));
                        a3 = eVar.a();
                    } catch (IOException e2) {
                        cn.jiguang.as.d.g("SRVLoader", "tcp send to " + inetAddress.getHostAddress() + " err:" + e2);
                    }
                    if (a3 == null) {
                        break;
                    }
                    for (h hVar : eVar.b(1)) {
                        if (hVar.d() == a3.g() && hVar.c() == a3.e() && hVar.b().equals(a3.d())) {
                            Iterator a6 = hVar.a();
                            while (a6.hasNext()) {
                                m mVar = (m) a6.next();
                                if (mVar.j() > 0) {
                                    String gVar = mVar.k().toString();
                                    if (!TextUtils.isEmpty(gVar)) {
                                        if (gVar.endsWith(".")) {
                                            gVar = gVar.substring(0, gVar.length() - 1);
                                        }
                                        cn.jiguang.ax.g gVar2 = new cn.jiguang.ax.g(gVar, mVar.j());
                                        if (gVar2.a()) {
                                            linkedHashSet.add(gVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return linkedHashSet;
            }
            return linkedHashSet;
        } catch (IOException e3) {
            cn.jiguang.as.d.g("SRVLoader", "can't srv, create query:" + e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, Pair<LinkedHashSet<cn.jiguang.ax.g>, Long> pair) {
        Object obj = pair.first;
        if (obj == null || ((LinkedHashSet) obj).size() <= 0 || pair.second == null) {
            return;
        }
        this.f8540e.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((cn.jiguang.ax.g) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        cn.jiguang.f.b.a((Context) null, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.d(str).a((cn.jiguang.f.a<String>) sb.toString()), cn.jiguang.f.a.e(str).a((cn.jiguang.f.a<Long>) pair.second)});
    }

    public static byte[] b(String str) {
        return e.a(i.a(g.a(g.a(str), g.f8515a), 33, 1)).c(ContentCommon.INVALID_OPTION);
    }

    public LinkedHashSet<cn.jiguang.ax.g> a(String str, long j) {
        LinkedHashSet<cn.jiguang.ax.g> linkedHashSet;
        StringBuilder sb;
        LinkedHashSet<cn.jiguang.ax.g> linkedHashSet2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Pair<LinkedHashSet<cn.jiguang.ax.g>, Boolean> a2 = a(str, this.f8538c, this.f8539d);
        if (a2 != null) {
            Object obj = a2.first;
            linkedHashSet = (obj == null || ((LinkedHashSet) obj).size() <= 0) ? null : (LinkedHashSet) a2.first;
            if (!((Boolean) a2.second).booleanValue()) {
                return linkedHashSet;
            }
        } else {
            linkedHashSet = null;
        }
        FutureTask futureTask = new FutureTask(new a(str, this));
        cn.jiguang.av.b.d(futureTask, new int[0]);
        if (j == 0) {
            sb = new StringBuilder();
        } else {
            try {
                linkedHashSet2 = (LinkedHashSet) futureTask.get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                cn.jiguang.as.d.g("SRVLoader", "run futureTask e:" + th);
            }
            if (linkedHashSet2 != null && linkedHashSet2.size() > 0) {
                cn.jiguang.as.d.c("SRVLoader", "use resolved result=" + linkedHashSet2);
                return linkedHashSet2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        sb.append(linkedHashSet);
        cn.jiguang.as.d.c("SRVLoader", sb.toString());
        return linkedHashSet;
    }
}
