package cn.jiguang.az;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.TimeConstants;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static i f8585a;

    /* renamed from: e, reason: collision with root package name */
    public static int f8586e;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f8587b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final Map<cn.jiguang.ax.g, Pair<Integer, cn.jiguang.bc.a>> f8588c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<cn.jiguang.ax.g, ConcurrentHashMap<Integer, b>> f8589d = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Set<cn.jiguang.ax.g>> f8590f = new HashMap();

    public static class a extends cn.jiguang.bd.a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Context f8591a;

        /* renamed from: d, reason: collision with root package name */
        public int f8592d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f8593e;

        /* renamed from: f, reason: collision with root package name */
        public int f8594f;

        public a(Context context, int i2, Object obj) {
            this.f8591a = context;
            this.f8592d = i2;
            this.f8593e = obj;
        }

        public a(Context context, Object obj) {
            this.f8591a = context;
            this.f8593e = obj;
        }

        @Override // cn.jiguang.bd.a
        public void a(Message message) {
            int i2 = message.what;
            if (i2 >= 60000) {
                if (this.f8593e instanceof cn.jiguang.ax.g) {
                    cn.jiguang.as.d.c("TcpReporter", "time to idle=" + this.f8593e);
                    i.a().a(this.f8591a, (cn.jiguang.ax.g) this.f8593e, 0);
                    return;
                }
                return;
            }
            if (i2 >= 50000) {
                Object obj = this.f8593e;
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    cn.jiguang.as.d.c("TcpReporter", "onTimeout=" + bVar);
                    i.a().a(bVar.f8601g, bVar.f8600f);
                    i.a().a(this.f8591a, bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i2 = this.f8592d;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && (this.f8593e instanceof b)) {
                            b bVar = (b) this.f8593e;
                            cn.jiguang.as.d.c("TcpReporter", "onResult, data=" + bVar + " code=" + this.f8594f);
                            JCoreManager.onEvent(this.f8591a, JConstants.SDK_TYPE, 61, "", null, Integer.valueOf(this.f8594f), bVar.f8596b, bVar.f8597c, Integer.valueOf(bVar.f8595a), bVar.f8598d, bVar.f8599e, bVar.j, bVar.k);
                        }
                    } else if (this.f8593e instanceof cn.jiguang.ax.g) {
                        i.a().b(this.f8591a, (cn.jiguang.ax.g) this.f8593e);
                    }
                } else if (this.f8593e instanceof cn.jiguang.ax.g) {
                    i.a().a(this.f8591a, (cn.jiguang.ax.g) this.f8593e);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f8595a;

        /* renamed from: b, reason: collision with root package name */
        public JSONObject f8596b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f8597c;

        /* renamed from: d, reason: collision with root package name */
        public File f8598d;

        /* renamed from: e, reason: collision with root package name */
        public Set<String> f8599e;

        /* renamed from: f, reason: collision with root package name */
        public int f8600f = -1;

        /* renamed from: g, reason: collision with root package name */
        public cn.jiguang.ax.g f8601g;

        /* renamed from: h, reason: collision with root package name */
        public LinkedHashSet<cn.jiguang.ax.g> f8602h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f8603i;
        public transient ReportCallBack j;
        public transient String k;

        public String toString() {
            return "TcpReportData{types=" + this.f8599e + ", seqId=" + this.f8600f + ", ipPort=" + this.f8601g + ", restUrls=" + this.f8602h + '}';
        }
    }

    public static synchronized int a(Context context) {
        int intValue;
        synchronized (i.class) {
            Integer num = (Integer) cn.jiguang.f.b.b(context, cn.jiguang.f.a.K());
            if (num == null) {
                num = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
            }
            Integer valueOf = Integer.valueOf((num.intValue() + 1) % 10000);
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.K().a((cn.jiguang.f.a<Integer>) valueOf)});
            intValue = valueOf.intValue();
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(cn.jiguang.ax.g gVar, int i2) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        if (gVar == null || (concurrentHashMap = this.f8589d.get(gVar)) == null) {
            return null;
        }
        b bVar = concurrentHashMap.get(Integer.valueOf(i2));
        concurrentHashMap.remove(Integer.valueOf(i2));
        return bVar;
    }

    public static i a() {
        if (f8585a == null) {
            synchronized (i.class) {
                if (f8585a == null) {
                    f8585a = new i();
                }
            }
        }
        return f8585a;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        switch (str) {
            case "android_awake2":
            case "android_awake":
            case "android_awake_target2":
            case "android_awake_target":
            case "awake":
            case "aa3":
            case "aat3":
                return "awake";
            case "active_launch":
            case "active_terminate":
            case "active_user":
                return "active_user";
            case "identify_account":
            case "detach_account":
            case "account":
                return "account";
            case "android_notification_state":
                return "android_notification_state";
            case "normal":
                break;
            default:
                if (this.f8590f.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    private LinkedHashSet<cn.jiguang.ax.g> a(Context context, Set<String> set) {
        LinkedHashSet<cn.jiguang.ax.g> linkedHashSet = new LinkedHashSet<>();
        cn.jiguang.ax.g a2 = cn.jiguang.ax.g.a(cn.jiguang.aw.a.d());
        if (a2 == null || !a2.a()) {
            Set<cn.jiguang.ax.g> b2 = b(context, set);
            if (b2 != null) {
                for (cn.jiguang.ax.g gVar : b2) {
                    if (gVar != null && gVar.a()) {
                        linkedHashSet.add(gVar);
                    }
                }
            }
        } else {
            linkedHashSet.add(a2);
        }
        cn.jiguang.as.d.c("TcpReporter", "tcp report find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    private void a(Context context, int i2, cn.jiguang.bc.a aVar, cn.jiguang.ax.g gVar, b bVar) {
        byte[] a2 = a(context, bVar.f8597c, bVar.f8595a, bVar.f8600f);
        if (a2 == null || a2.length == 0) {
            cn.jiguang.as.d.c("TcpReporter", "package data failed, give up, data=" + bVar);
            a(context, bVar, -1);
            return;
        }
        cn.jiguang.as.d.c("TcpReporter", "send tcp data, len=" + a2.length + ", data=" + bVar);
        bVar.f8603i = true;
        aVar.a(a2);
        cn.jiguang.bd.b.a().b(i2 + TimeConstants.MIN, 31000L, new a(context, gVar));
        cn.jiguang.bd.b.a().b(bVar.f8600f + 50000, 15000L, new a(context, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.ax.g gVar) {
        cn.jiguang.bc.a aVar;
        if (gVar == null) {
            return;
        }
        try {
            Pair<Integer, cn.jiguang.bc.a> pair = this.f8588c.get(gVar);
            if (pair != null && (aVar = (cn.jiguang.bc.a) pair.second) != null && !aVar.b()) {
                cn.jiguang.as.d.c("TcpReporter", "start tcp socket(" + pair.first + "):" + gVar);
                if (aVar.a(gVar.f8423a, gVar.f8424b) != 0) {
                    a(context, gVar, 0);
                } else {
                    cn.jiguang.av.b.c(new a(context, 2, gVar), new int[0]);
                    a aVar2 = new a(context, gVar);
                    while (!this.f8587b.get()) {
                        try {
                            a(context, aVar.a(), gVar);
                            cn.jiguang.bd.b.a().b(((Integer) pair.first).intValue() + TimeConstants.MIN, 31000L, aVar2);
                        } catch (f e2) {
                            if (e2.f8564a != -997) {
                                cn.jiguang.as.d.g("TcpReporter", "recv failed with error:" + e2);
                            }
                        }
                    }
                }
                a(context, gVar, 0);
                cn.jiguang.as.d.g("TcpReporter", this.f8587b.get() ? "Break receiving by wantStop" : "disconnected");
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.b("TcpReporter", "socket exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.ax.g gVar, int i2) {
        int i3;
        StringBuilder sb;
        Pair<Integer, cn.jiguang.bc.a> remove = this.f8588c.remove(gVar);
        if (remove != null) {
            i3 = ((Integer) remove.first).intValue();
            cn.jiguang.e.h.a((Closeable) remove.second);
        } else {
            i3 = 0;
        }
        ConcurrentHashMap<Integer, b> remove2 = this.f8589d.remove(gVar);
        if (i2 == 0 && !cn.jiguang.e.a.d(context)) {
            i2 = -2;
        }
        if (remove2 == null || remove2.size() <= 0) {
            if (i3 > 0) {
                cn.jiguang.as.d.c("TcpReporter", "socket(" + i3 + ") at " + gVar + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i3);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, go on send waiting request");
        } else {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i3);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, finish waiting request, code=");
            sb.append(i2);
        }
        cn.jiguang.as.d.c("TcpReporter", sb.toString());
        for (b bVar : remove2.values()) {
            if (bVar != null) {
                cn.jiguang.bd.b.a().b(bVar.f8600f + 50000);
                if (i2 == 0) {
                    a(context, bVar);
                } else {
                    a aVar = new a(context, 3, bVar);
                    aVar.f8594f = i2;
                    cn.jiguang.av.b.c(aVar, new int[0]);
                }
            }
        }
    }

    private synchronized void a(Context context, cn.jiguang.ax.g gVar, b bVar) {
        Pair<Integer, cn.jiguang.bc.a> pair = this.f8588c.get(gVar);
        cn.jiguang.bc.a aVar = pair != null ? (cn.jiguang.bc.a) pair.second : null;
        if (aVar == null) {
            this.f8588c.put(gVar, new Pair<>(Integer.valueOf(b()), new cn.jiguang.bc.b(30720, 19)));
            cn.jiguang.bj.d.a("ONCE_TASK", new a(context, 1, gVar));
        } else if (aVar.b()) {
            a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
        }
    }

    private void a(Context context, b bVar, int i2) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        cn.jiguang.ax.g gVar = bVar.f8601g;
        if (gVar != null && (concurrentHashMap = this.f8589d.get(gVar)) != null) {
            concurrentHashMap.remove(Integer.valueOf(bVar.f8600f));
        }
        cn.jiguang.bd.b.a().b(bVar.f8600f + 50000);
        a aVar = new a(context, 3, bVar);
        aVar.f8594f = i2;
        cn.jiguang.av.b.c(aVar, new int[0]);
    }

    private void a(Context context, ByteBuffer byteBuffer, cn.jiguang.ax.g gVar) {
        try {
            cn.jiguang.as.d.c("TcpReporter", "Received bytes - len:" + byteBuffer.array().length);
            byte b2 = byteBuffer.get(2);
            if (b2 != 1 && b2 != 0) {
                cn.jiguang.as.d.g("TcpReporter", "wrong version");
            }
            short s = byteBuffer.getShort(15);
            short s2 = byteBuffer.getShort(17);
            cn.jiguang.as.d.c("TcpReporter", "onResult seqId=" + ((int) s) + " code=" + ((int) s2));
            cn.jiguang.bd.b.a().b(50000 + s);
            b a2 = a(gVar, s);
            if (a2 != null) {
                if (s2 == 0) {
                    a aVar = new a(context, 3, a2);
                    aVar.f8594f = s2;
                    cn.jiguang.av.b.c(aVar, new int[0]);
                } else if (s2 == 401) {
                    a(context, gVar, s2);
                } else {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("TcpReporter", "tcp reporter onReceive err:" + th);
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        cn.jiguang.ax.g a2 = cn.jiguang.ax.g.a(optJSONArray.getString(i2));
                        if (a2 != null && a2.a()) {
                            linkedHashSet.add(a2);
                        }
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.f8590f = hashMap;
        } catch (JSONException unused) {
        }
    }

    public static byte[] a(Context context, long j, byte[] bArr) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.f());
        if (TextUtils.isEmpty(str)) {
            str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.g());
        }
        byte[] c2 = cn.jiguang.e.f.c(j + cn.jiguang.e.f.e(str) + cn.jiguang.e.f.b(bArr));
        if (c2 == null) {
            return new byte[16];
        }
        if (c2.length == 16) {
            return c2;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(c2.length, 16));
        return bArr2;
    }

    private byte[] a(Context context, byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0 || bArr.length > 30683) {
            return null;
        }
        cn.jiguang.be.b bVar = new cn.jiguang.be.b(bArr.length + 37);
        bVar.b(0);
        bVar.a(1);
        bVar.a(cn.jiguang.az.b.a().b());
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
        bVar.b(longValue);
        bVar.a(a(context, longValue, bArr));
        bVar.a(i2);
        bVar.b(i3);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static synchronized int b() {
        int i2;
        synchronized (i.class) {
            i2 = (f8586e + 1) % 10000;
            f8586e = i2;
        }
        return i2;
    }

    private Set<cn.jiguang.ax.g> b(Context context, Set<String> set) {
        b(context);
        if (set != null && !set.isEmpty()) {
            Set<cn.jiguang.ax.g> set2 = null;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                Set<cn.jiguang.ax.g> set3 = this.f8590f.get(a(it.next()));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f8590f.get("normal");
    }

    private void b(Context context) {
        Map<String, Set<cn.jiguang.ax.g>> map = this.f8590f;
        if (map == null || map.isEmpty()) {
            String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.T());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, cn.jiguang.ax.g gVar) {
        cn.jiguang.bc.a aVar;
        cn.jiguang.as.d.c("TcpReporter", "socket at " + gVar + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.f8589d.get(gVar);
        Pair<Integer, cn.jiguang.bc.a> pair = this.f8588c.get(gVar);
        if (pair == null) {
            return;
        }
        if (concurrentHashMap != null && (aVar = (cn.jiguang.bc.a) pair.second) != null && aVar.b()) {
            for (b bVar : concurrentHashMap.values()) {
                if (bVar != null && !bVar.f8603i) {
                    a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
                }
            }
        }
        cn.jiguang.bd.b.a().b(((Integer) pair.first).intValue() + TimeConstants.MIN, 31000L, new a(context, gVar));
    }

    public b a(Context context, JSONObject jSONObject, byte[] bArr, int i2, File file, Set<String> set, ReportCallBack reportCallBack, String str) {
        b bVar = new b();
        bVar.f8596b = jSONObject;
        bVar.f8595a = i2;
        bVar.f8597c = bArr;
        bVar.f8598d = file;
        bVar.f8599e = set;
        bVar.f8600f = a(context);
        bVar.j = reportCallBack;
        bVar.k = str;
        return bVar;
    }

    public void a(Context context, b bVar) {
        try {
            boolean z = bVar.f8602h == null;
            if (z) {
                cn.jiguang.bd.b.a().a(context);
                bVar.f8602h = a(context, bVar.f8599e);
                cn.jiguang.as.d.c("TcpReporter", "tcp report begin=" + bVar);
            }
            if (!cn.jiguang.e.a.d(context)) {
                a(context, bVar, -2);
                return;
            }
            if (bVar.f8602h != null && !bVar.f8602h.isEmpty()) {
                cn.jiguang.ax.g gVar = null;
                Iterator<cn.jiguang.ax.g> it = this.f8588c.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cn.jiguang.ax.g next = it.next();
                    if (bVar.f8602h.contains(next)) {
                        cn.jiguang.as.d.c("TcpReporter", "use exist ipPort=" + next);
                        gVar = next;
                        break;
                    }
                }
                if (gVar == null) {
                    gVar = bVar.f8602h.iterator().next();
                    cn.jiguang.as.d.c("TcpReporter", "use next ipPort=" + gVar);
                }
                bVar.f8601g = gVar;
                bVar.f8602h.remove(gVar);
                if (z) {
                    cn.jiguang.bd.b.a().b(bVar.f8600f + 50000, 15000L, new a(context, bVar));
                }
                ConcurrentHashMap<Integer, b> concurrentHashMap = this.f8589d.get(gVar);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.f8589d.put(gVar, concurrentHashMap);
                }
                bVar.f8603i = false;
                concurrentHashMap.put(Integer.valueOf(bVar.f8600f), bVar);
                a(context, gVar, bVar);
                return;
            }
            a(context, bVar, -1);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("TcpReporter", "tcp upload e:" + th);
        }
    }
}
