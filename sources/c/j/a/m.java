package c.j.a;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import c.j.a.f.y;
import c.j.a.k.i0;
import c.j.a.z.c0;
import c.j.a.z.f;
import c.j.a.z.f0;
import c.j.a.z.h;
import c.j.a.z.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushClientManager.java */
/* loaded from: classes.dex */
public final class m {
    public static volatile m p;

    /* renamed from: d, reason: collision with root package name */
    public Context f6614d;

    /* renamed from: f, reason: collision with root package name */
    public h f6616f;

    /* renamed from: g, reason: collision with root package name */
    public String f6617g;

    /* renamed from: h, reason: collision with root package name */
    public String f6618h;
    public Boolean k;
    public Long l;
    public boolean m;
    public int o;

    /* renamed from: a, reason: collision with root package name */
    public long f6611a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f6612b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f6613c = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6615e = true;

    /* renamed from: i, reason: collision with root package name */
    public SparseArray<a> f6619i = new SparseArray<>();
    public int j = 0;
    public c.j.a.b n = new l();

    /* compiled from: TestManager.java */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<String> f6624a;

        /* compiled from: TestManager.java */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static b f6625a = new b(0);
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static b c() {
            return a.f6625a;
        }

        public final ArrayList<String> a() {
            return new ArrayList<>(this.f6624a);
        }

        public final boolean b() {
            ArrayList<String> arrayList = this.f6624a;
            return (arrayList == null || arrayList.size() == 0) ? false : true;
        }

        public b() {
            this.f6624a = null;
            this.f6624a = new ArrayList<>();
        }
    }

    public static synchronized m m() {
        m mVar;
        synchronized (m.class) {
            if (p == null) {
                p = new m();
            }
            mVar = p;
        }
        return mVar;
    }

    public final boolean d() {
        return this.m;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f6617g)) {
            return this.f6617g;
        }
        h hVar = this.f6616f;
        String b2 = hVar != null ? hVar.b("APP_TOKEN", (String) null) : "";
        c(b2);
        return b2;
    }

    public final boolean f() {
        return this.f6615e;
    }

    public final Context g() {
        return this.f6614d;
    }

    public final void h() {
        this.f6616f.a();
    }

    public final int i() {
        return this.o;
    }

    public final long j() {
        Context context = this.f6614d;
        if (context == null) {
            return -1L;
        }
        if (this.l == null) {
            this.l = Long.valueOf(f0.b(context));
        }
        return this.l.longValue();
    }

    public final void k() {
        this.f6618h = null;
        this.f6616f.b("APP_ALIAS");
    }

    public final boolean l() {
        if (this.k == null) {
            this.k = Boolean.valueOf(j() >= 1230 && f0.e(this.f6614d));
        }
        return this.k.booleanValue();
    }

    public final boolean c() {
        if (this.f6614d == null) {
            c.j.a.z.v.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(l());
        this.k = valueOf;
        return valueOf.booleanValue();
    }

    public final synchronized a d(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f6619i.get(parseInt);
                this.f6619i.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void a() throws f {
        Context context = this.f6614d;
        if (context != null) {
            f0.c(context);
        }
    }

    public final List<String> b() {
        String b2 = this.f6616f.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.f6616f.b("APP_TAGS");
            arrayList.clear();
            c.j.a.z.v.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b2)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b2).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* compiled from: PushClientManager.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public c.j.a.a f6620a;

        /* renamed from: b, reason: collision with root package name */
        public c.j.a.a f6621b;

        /* renamed from: c, reason: collision with root package name */
        public Runnable f6622c;

        /* renamed from: d, reason: collision with root package name */
        public Object[] f6623d;

        public a(c.j.a.f.b bVar, c.j.a.a aVar) {
            this.f6620a = aVar;
        }

        public final void a(int i2, Object... objArr) {
            this.f6623d = objArr;
            c.j.a.a aVar = this.f6621b;
            if (aVar != null) {
                aVar.onStateChanged(i2);
            }
            c.j.a.a aVar2 = this.f6620a;
            if (aVar2 != null) {
                aVar2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f6623d;
        }

        public final void a(Runnable runnable) {
            this.f6622c = runnable;
        }

        public final void a() {
            Runnable runnable = this.f6622c;
            if (runnable == null) {
                c.j.a.z.v.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(c.j.a.a aVar) {
            this.f6621b = aVar;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f6614d == null) {
            this.f6614d = c.j.a.z.c.c(context);
            this.m = z.c(context, context.getPackageName());
            c0.b().a(this.f6614d);
            a(new c.j.a.f.f());
            h hVar = new h();
            this.f6616f = hVar;
            hVar.a(this.f6614d, "com.vivo.push_preferences.appconfig_v1");
            this.f6617g = e();
            this.f6618h = this.f6616f.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f6618h)) {
            k();
        }
    }

    public final void e(String str) {
        s.a(new q(this, str));
    }

    public final void c(String str) {
        s.c(new n(this, str));
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b2 = this.f6616f.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b2);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f6616f.b("APP_TAGS");
            } else {
                this.f6616f.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f6616f.b("APP_TAGS");
        }
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b2 = this.f6616f.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b2);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f6616f.b("APP_TAGS");
            } else {
                this.f6616f.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f6616f.b("APP_TAGS");
        }
    }

    public final void b(String str) {
        this.f6618h = str;
        this.f6616f.a("APP_ALIAS", str);
    }

    public final void b(ArrayList<String> arrayList, c.j.a.a aVar) {
        Context context = this.f6614d;
        if (context == null) {
            if (aVar != null) {
                aVar.onStateChanged(102);
                return;
            }
            return;
        }
        y yVar = new y(false, context.getPackageName(), arrayList);
        yVar.a(500);
        if (this.m) {
            if (!l()) {
                if (aVar != null) {
                    aVar.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f6613c)) {
                if (aVar != null) {
                    aVar.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f6613c = SystemClock.elapsedRealtime();
            String a2 = a(new a(yVar, aVar));
            yVar.b(a2);
            if (TextUtils.isEmpty(this.f6617g)) {
                a(a2, 20001);
                return;
            }
            if (arrayList.size() < 0) {
                a(a2, 20002);
                return;
            }
            if (arrayList.size() > 500) {
                a(a2, 20004);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a2, 20003);
                    return;
                }
            }
            a(yVar);
            e(a2);
            return;
        }
        a(yVar);
        if (aVar != null) {
            aVar.onStateChanged(0);
        }
    }

    public final void a(String str) {
        this.f6617g = str;
        this.f6616f.a("APP_TOKEN", str);
    }

    public final void a(c.j.a.a aVar) {
        if (this.f6614d == null) {
            if (aVar != null) {
                aVar.onStateChanged(102);
                return;
            }
            return;
        }
        String e2 = e();
        this.f6617g = e2;
        if (!TextUtils.isEmpty(e2)) {
            if (aVar != null) {
                aVar.onStateChanged(0);
                return;
            }
            return;
        }
        if (!a(this.f6611a)) {
            if (aVar != null) {
                aVar.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f6611a = SystemClock.elapsedRealtime();
        String packageName = this.f6614d.getPackageName();
        a aVar2 = null;
        if (this.f6614d != null) {
            c.j.a.f.a aVar3 = new c.j.a.f.a(true, packageName);
            aVar3.e();
            aVar3.g();
            aVar3.h();
            aVar3.a(100);
            if (this.m) {
                if (l()) {
                    aVar2 = a(aVar3, aVar);
                } else if (aVar != null) {
                    aVar.onStateChanged(101);
                }
            } else if (aVar3.a(this.f6614d) == 2) {
                aVar2 = a(aVar3, aVar);
            } else {
                a(aVar3);
                if (aVar != null) {
                    aVar.onStateChanged(0);
                }
            }
        } else if (aVar != null) {
            aVar.onStateChanged(102);
        }
        if (aVar2 == null) {
            return;
        }
        aVar2.a(new o(this, aVar2));
        aVar2.a();
    }

    public final a a(c.j.a.f.a aVar, c.j.a.a aVar2) {
        a aVar3 = new a(aVar, aVar2);
        String a2 = a(aVar3);
        aVar.b(a2);
        aVar3.a(new p(this, aVar, a2));
        return aVar3;
    }

    public final void a(String str, int i2, Object... objArr) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, objArr);
        } else {
            c.j.a.z.v.d("PushClientManager", "notifyApp token is null");
        }
    }

    public static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    public final void a(String str, int i2) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, new Object[0]);
        } else {
            c.j.a.z.v.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    public final synchronized String a(a aVar) {
        int i2;
        this.f6619i.put(this.j, aVar);
        i2 = this.j;
        this.j = i2 + 1;
        return Integer.toString(i2);
    }

    public final void a(ArrayList<String> arrayList, c.j.a.a aVar) {
        Context context = this.f6614d;
        if (context == null) {
            if (aVar != null) {
                aVar.onStateChanged(102);
                return;
            }
            return;
        }
        y yVar = new y(true, context.getPackageName(), arrayList);
        yVar.a(500);
        if (this.m) {
            if (!l()) {
                if (aVar != null) {
                    aVar.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f6612b)) {
                if (aVar != null) {
                    aVar.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f6612b = SystemClock.elapsedRealtime();
            String a2 = a(new a(yVar, aVar));
            yVar.b(a2);
            if (TextUtils.isEmpty(this.f6617g)) {
                a(a2, 20001);
                return;
            }
            if (arrayList.size() < 0) {
                a(a2, 20002);
                return;
            }
            if (arrayList.size() + b().size() > 500) {
                a(a2, 20004);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a2, 20003);
                    return;
                }
            }
            a(yVar);
            e(a2);
            return;
        }
        a(yVar);
        if (aVar != null) {
            aVar.onStateChanged(0);
        }
    }

    public final void a(Intent intent, c.j.a.y.a aVar) {
        v a2 = this.n.a(intent);
        Context context = m().f6614d;
        if (a2 == null) {
            c.j.a.z.v.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                c.j.a.z.v.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        i0 a3 = this.n.a(a2);
        if (a3 == null) {
            c.j.a.z.v.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(a2)));
            if (context != null) {
                c.j.a.z.v.c(context, "[执行指令失败]指令" + a2 + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(a2 instanceof c.j.a.f.m)) {
            c.j.a.z.v.a(context, "[接收指令]".concat(String.valueOf(a2)));
        }
        a3.a(aVar);
        s.a((r) a3);
    }

    public final void a(v vVar) {
        Context context = m().f6614d;
        if (vVar == null) {
            c.j.a.z.v.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                c.j.a.z.v.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        r b2 = this.n.b(vVar);
        if (b2 == null) {
            c.j.a.z.v.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                c.j.a.z.v.c(context, "[执行指令失败]指令" + vVar + "任务空！");
                return;
            }
            return;
        }
        c.j.a.z.v.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        s.a(b2);
    }
}
