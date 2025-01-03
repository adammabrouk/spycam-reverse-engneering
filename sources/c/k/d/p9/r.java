package c.k.d.p9;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    public static r f7674c;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, HashMap<String, b>> f7675a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public List<a> f7676b = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f7677a;

        /* renamed from: b, reason: collision with root package name */
        public String f7678b;

        /* renamed from: c, reason: collision with root package name */
        public String f7679c;

        /* renamed from: d, reason: collision with root package name */
        public String f7680d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f7681e;

        /* renamed from: f, reason: collision with root package name */
        public String f7682f;

        /* renamed from: g, reason: collision with root package name */
        public String f7683g;

        /* renamed from: h, reason: collision with root package name */
        public String f7684h;

        /* renamed from: i, reason: collision with root package name */
        public String f7685i;
        public String j;
        public b1 k;
        public Context l;
        public XMPushService p;
        public Messenger r;
        public c m = c.unbind;
        public int n = 0;
        public List<a> o = new ArrayList();
        public c q = null;
        public boolean s = false;
        public XMPushService.b t = new XMPushService.b(this);
        public IBinder.DeathRecipient u = null;
        public final C0130b v = new C0130b();

        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        /* renamed from: c.k.d.p9.r$b$b, reason: collision with other inner class name */
        public class C0130b extends XMPushService.i {

            /* renamed from: b, reason: collision with root package name */
            public int f7686b;

            /* renamed from: c, reason: collision with root package name */
            public int f7687c;

            /* renamed from: d, reason: collision with root package name */
            public String f7688d;

            /* renamed from: e, reason: collision with root package name */
            public String f7689e;

            public C0130b() {
                super(0);
            }

            public XMPushService.i a(int i2, int i3, String str, String str2) {
                this.f7686b = i2;
                this.f7687c = i3;
                this.f7689e = str2;
                this.f7688d = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            /* renamed from: a */
            public void mo224a() {
                if (b.this.a(this.f7686b, this.f7687c, this.f7689e)) {
                    b.this.a(this.f7686b, this.f7687c, this.f7688d, this.f7689e);
                    return;
                }
                c.k.a.a.a.c.b(" ignore notify client :" + b.this.f7684h);
            }
        }

        public class c implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            public final b f7691a;

            /* renamed from: b, reason: collision with root package name */
            public final Messenger f7692b;

            public c(b bVar, Messenger messenger) {
                this.f7691a = bVar;
                this.f7692b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                c.k.a.a.a.c.b("peer died, chid = " + this.f7691a.f7684h);
                b.this.p.a(new t(this, 0), 0L);
                if ("9".equals(this.f7691a.f7684h) && "com.xiaomi.xmsf".equals(b.this.p.getPackageName())) {
                    b.this.p.a(new u(this, 0), JConstants.MIN);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.p = xMPushService;
            a(new s(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.n + 1) * 15)) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m409a() {
            try {
                Messenger messenger = this.r;
                if (messenger != null && this.u != null) {
                    messenger.getBinder().unlinkToDeath(this.u, 0);
                }
            } catch (Exception unused) {
            }
            this.q = null;
        }

        public final void a(int i2, int i3, String str, String str2) {
            c cVar = this.m;
            this.q = cVar;
            if (i2 == 2) {
                this.k.a(this.l, this, i3);
                return;
            }
            if (i2 == 3) {
                this.k.a(this.l, this, str2, str);
                return;
            }
            if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.n++;
                } else if (z) {
                    this.n = 0;
                    if (this.r != null) {
                        try {
                            this.r.send(Message.obtain(null, 16, this.p.n));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.k.a(this.p, this, z, i3, str);
            }
        }

        public void a(Messenger messenger) {
            m409a();
            try {
                if (messenger != null) {
                    this.r = messenger;
                    this.s = true;
                    this.u = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.u, 0);
                } else {
                    c.k.a.a.a.c.b("peer linked with old sdk chid = " + this.f7684h);
                }
            } catch (Exception e2) {
                c.k.a.a.a.c.b("peer linkToDeath err: " + e2.getMessage());
                this.r = null;
                this.s = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.o) {
                this.o.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.o) {
                Iterator<a> it = this.o.iterator();
                while (it.hasNext()) {
                    it.next().a(this.m, cVar, i3);
                }
            }
            c cVar2 = this.m;
            int i4 = 0;
            if (cVar2 != cVar) {
                c.k.a.a.a.c.m6a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), v.a(i3), str, str2, this.f7684h));
                this.m = cVar;
            }
            if (this.k == null) {
                c.k.a.a.a.c.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.q != null && (z = this.s)) {
                i4 = (this.r == null || !z) ? 10100 : 1000;
            }
            this.p.b(this.v);
            if (b(i2, i3, str2)) {
                a(i2, i3, str, str2);
                return;
            }
            XMPushService xMPushService = this.p;
            C0130b c0130b = this.v;
            c0130b.a(i2, i3, str, str2);
            xMPushService.a(c0130b, i4);
        }

        public final boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.q;
            if (cVar == null || !(z = this.s)) {
                return true;
            }
            if (cVar == this.m) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else {
                if (this.r != null && z) {
                    c.k.a.a.a.c.b("Peer alive notify status to client:" + this.f7684h);
                    return true;
                }
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb.append(str2);
            sb.append(this.f7684h);
            c.k.a.a.a.c.b(sb.toString());
            return false;
        }

        public void b(a aVar) {
            synchronized (this.o) {
                this.o.remove(aVar);
            }
        }

        public final boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.m == c.binded || !this.p.m595c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i2 == 2) {
                return this.p.m595c();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (f7674c == null) {
                f7674c = new r();
            }
            rVar = f7674c;
        }
        return rVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m401a() {
        return this.f7675a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f7675a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m402a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f7675a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m403a(String str) {
        if (this.f7675a.containsKey(str)) {
            return ((HashMap) this.f7675a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m404a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f7675a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f7677a)) {
                    arrayList.add(bVar.f7684h);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m405a() {
        Iterator<b> it = m402a().iterator();
        while (it.hasNext()) {
            it.next().m409a();
        }
        this.f7675a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f7675a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i2) {
        Iterator<HashMap<String, b>> it = this.f7675a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f7676b.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f7675a.get(bVar.f7684h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f7675a.put(bVar.f7684h, hashMap);
        }
        hashMap.put(a(bVar.f7678b), bVar);
        Iterator<a> it = this.f7676b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m406a(String str) {
        HashMap<String, b> hashMap = this.f7675a.get(str);
        if (hashMap != null) {
            Iterator<b> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().m409a();
            }
            hashMap.clear();
            this.f7675a.remove(str);
        }
        Iterator<a> it2 = this.f7676b.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m407a(String str, String str2) {
        HashMap<String, b> hashMap = this.f7675a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m409a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f7675a.remove(str);
            }
        }
        Iterator<a> it = this.f7676b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized void b() {
        this.f7676b.clear();
    }
}
