package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import c.k.b.a.a;
import c.k.d.a5;
import c.k.d.a7;
import c.k.d.c5;
import c.k.d.d2;
import c.k.d.e0;
import c.k.d.f5;
import c.k.d.f7;
import c.k.d.g5;
import c.k.d.g6;
import c.k.d.g9;
import c.k.d.h8;
import c.k.d.i4;
import c.k.d.j;
import c.k.d.j0;
import c.k.d.j4;
import c.k.d.j9;
import c.k.d.k4;
import c.k.d.l5;
import c.k.d.n6;
import c.k.d.n8;
import c.k.d.p5;
import c.k.d.p6;
import c.k.d.p9.a1;
import c.k.d.p9.b0;
import c.k.d.p9.b1;
import c.k.d.p9.c0;
import c.k.d.p9.c1;
import c.k.d.p9.d0;
import c.k.d.p9.e1;
import c.k.d.p9.g1;
import c.k.d.p9.h0;
import c.k.d.p9.i1;
import c.k.d.p9.j1;
import c.k.d.p9.k1;
import c.k.d.p9.m1;
import c.k.d.p9.n1;
import c.k.d.p9.o0;
import c.k.d.p9.p0;
import c.k.d.p9.q0;
import c.k.d.p9.r;
import c.k.d.p9.r0;
import c.k.d.p9.s0;
import c.k.d.p9.t0;
import c.k.d.p9.u0;
import c.k.d.p9.v;
import c.k.d.p9.v0;
import c.k.d.p9.w;
import c.k.d.p9.w0;
import c.k.d.p9.w1;
import c.k.d.p9.x;
import c.k.d.p9.x0;
import c.k.d.p9.y;
import c.k.d.p9.y0;
import c.k.d.p9.z;
import c.k.d.p9.z0;
import c.k.d.q5;
import c.k.d.q6;
import c.k.d.q9;
import c.k.d.r5;
import c.k.d.s4;
import c.k.d.s7;
import c.k.d.t5;
import c.k.d.t6;
import c.k.d.u1;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.w7;
import c.k.d.x3;
import c.k.d.x4;
import c.k.d.z4;
import c.k.d.z6;
import com.shix.shixipc.system.ContentCommon;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class XMPushService extends Service implements c5 {
    public static final int u = Process.myPid();
    public static int v;

    /* renamed from: a, reason: collision with root package name */
    public a5 f11267a;

    /* renamed from: b, reason: collision with root package name */
    public c0 f11268b;

    /* renamed from: c, reason: collision with root package name */
    public String f11269c;

    /* renamed from: d, reason: collision with root package name */
    public e f11270d;

    /* renamed from: e, reason: collision with root package name */
    public p f11271e;

    /* renamed from: i, reason: collision with root package name */
    public x4 f11275i;
    public z4 j;
    public b1 k;
    public ContentObserver r;
    public ContentObserver t;

    /* renamed from: f, reason: collision with root package name */
    public int f11272f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f11273g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f11274h = 0;
    public c.k.d.p9.q l = null;
    public e1 m = null;
    public Messenger n = null;
    public Collection<c.k.d.p9.g> o = Collections.synchronizedCollection(new ArrayList());
    public ArrayList<l> p = new ArrayList<>();
    public f5 q = new o0(this);

    public class a extends i {

        /* renamed from: b, reason: collision with root package name */
        public r.b f11276b;

        public a(r.b bVar) {
            super(9);
            this.f11276b = null;
            this.f11276b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f11276b.f7684h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            String str;
            try {
                if (!XMPushService.this.m595c()) {
                    c.k.a.a.a.c.d("trying bind while the connection is not created, quit!");
                    return;
                }
                r.b a2 = r.a().a(this.f11276b.f7684h, this.f11276b.f7678b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f11276b.f7684h + " is removed ";
                } else if (a2.m == r.c.unbind) {
                    a2.a(r.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.j.a(a2);
                    p6.a(XMPushService.this, a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.m;
                }
                c.k.a.a.a.c.m6a(str);
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b extends i {

        /* renamed from: b, reason: collision with root package name */
        public final r.b f11278b;

        public b(r.b bVar) {
            super(12);
            this.f11278b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.f11278b.f7684h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            this.f11278b.a(r.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).f11278b.f7684h, this.f11278b.f7684h);
            }
            return false;
        }

        public int hashCode() {
            return this.f11278b.f7684h.hashCode();
        }
    }

    public class c extends i {

        /* renamed from: b, reason: collision with root package name */
        public s4 f11279b;

        public c(s4 s4Var) {
            super(8);
            this.f11279b = null;
            this.f11279b = s4Var;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.l.a(this.f11279b);
        }
    }

    public class d extends i {
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            if (XMPushService.this.m589a()) {
                XMPushService.this.f();
            } else {
                c.k.a.a.a.c.m6a("should not connect. quit the job.");
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.v);
        }
    }

    public class f extends i {

        /* renamed from: b, reason: collision with root package name */
        public int f11283b;

        /* renamed from: c, reason: collision with root package name */
        public Exception f11284c;

        public f(int i2, Exception exc) {
            super(2);
            this.f11283b = i2;
            this.f11284c = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.a(this.f11283b, this.f11284c);
        }
    }

    public class g extends i {
        public g() {
            super(ContentCommon.INVALID_OPTION);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.c();
        }
    }

    public class h extends i {

        /* renamed from: b, reason: collision with root package name */
        public Intent f11287b;

        public h(Intent intent) {
            super(15);
            this.f11287b = null;
            this.f11287b = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Handle intent action = " + this.f11287b.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.c(this.f11287b);
        }
    }

    public static abstract class i extends e1.b {
        public i(int i2) {
            super(i2);
        }

        public abstract String a();

        /* renamed from: a */
        public abstract void mo224a();

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f7570a;
            if (i2 != 4 && i2 != 8) {
                c.k.a.a.a.c.m6a("JOB: " + a());
            }
            mo224a();
        }
    }

    public class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.m.m369a();
        }
    }

    public class k extends i {

        /* renamed from: b, reason: collision with root package name */
        public r5 f11290b;

        public k(r5 r5Var) {
            super(8);
            this.f11290b = null;
            this.f11290b = r5Var;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.l.a(this.f11290b);
        }
    }

    public interface l {
        void a();
    }

    public class m extends i {

        /* renamed from: b, reason: collision with root package name */
        public boolean f11292b;

        public m(boolean z) {
            super(4);
            this.f11292b = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            if (XMPushService.this.m595c()) {
                try {
                    if (!this.f11292b) {
                        p6.a();
                    }
                    XMPushService.this.j.a(this.f11292b);
                } catch (l5 e2) {
                    c.k.a.a.a.c.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }
    }

    public class n extends i {

        /* renamed from: b, reason: collision with root package name */
        public r.b f11294b;

        public n(r.b bVar) {
            super(4);
            this.f11294b = null;
            this.f11294b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f11294b.f7684h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            try {
                this.f11294b.a(r.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.j.a(this.f11294b.f7684h, this.f11294b.f7678b);
                this.f11294b.a(r.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.j.a(this.f11294b);
            } catch (l5 e2) {
                c.k.a.a.a.c.a(e2);
                XMPushService.this.a(10, e2);
            }
        }
    }

    public class o extends i {
        public o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m589a()) {
                XMPushService.this.f();
            }
        }
    }

    public class p extends BroadcastReceiver {
        public p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class q extends i {

        /* renamed from: b, reason: collision with root package name */
        public r.b f11298b;

        /* renamed from: c, reason: collision with root package name */
        public int f11299c;

        /* renamed from: d, reason: collision with root package name */
        public String f11300d;

        /* renamed from: e, reason: collision with root package name */
        public String f11301e;

        public q(r.b bVar, int i2, String str, String str2) {
            super(9);
            this.f11298b = null;
            this.f11298b = bVar;
            this.f11299c = i2;
            this.f11300d = str;
            this.f11301e = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f11298b.f7684h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public void mo224a() {
            if (this.f11298b.m != r.c.unbind && XMPushService.this.j != null) {
                try {
                    XMPushService.this.j.a(this.f11298b.f7684h, this.f11298b.f7678b);
                } catch (l5 e2) {
                    c.k.a.a.a.c.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.f11298b.a(r.c.unbind, this.f11299c, 0, this.f11301e, this.f11300d);
        }
    }

    static {
        u1.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
        v = 1;
    }

    public b1 a() {
        return new b1();
    }

    public final r.b a(String str, Intent intent) {
        r.b a2 = r.a().a(str, intent.getStringExtra(v.n));
        if (a2 == null) {
            a2 = new r.b(this);
        }
        a2.f7684h = intent.getStringExtra(v.p);
        a2.f7678b = intent.getStringExtra(v.n);
        a2.f7679c = intent.getStringExtra(v.q);
        a2.f7677a = intent.getStringExtra(v.w);
        a2.f7682f = intent.getStringExtra(v.u);
        a2.f7683g = intent.getStringExtra(v.v);
        a2.f7681e = intent.getBooleanExtra(v.t, false);
        a2.f7685i = intent.getStringExtra(v.s);
        a2.j = intent.getStringExtra(v.z);
        a2.f7680d = intent.getStringExtra(v.r);
        a2.k = this.k;
        a2.a((Messenger) intent.getParcelableExtra(v.D));
        a2.l = getApplicationContext();
        r.a().a(a2);
        return a2;
    }

    public final r5 a(r5 r5Var, String str, String str2) {
        StringBuilder sb;
        String str3;
        r a2 = r.a();
        List<String> m404a = a2.m404a(str);
        if (m404a.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            r5Var.f(str);
            str = r5Var.d();
            if (TextUtils.isEmpty(str)) {
                str = m404a.get(0);
                r5Var.c(str);
            }
            r.b a3 = a2.a(str, r5Var.f());
            if (!m595c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else {
                if (a3 != null && a3.m == r.c.binded) {
                    if (TextUtils.equals(str2, a3.j)) {
                        return r5Var;
                    }
                    sb = new StringBuilder();
                    sb.append("invalid session. ");
                    sb.append(str2);
                    c.k.a.a.a.c.m6a(sb.toString());
                    return null;
                }
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        c.k.a.a.a.c.m6a(sb.toString());
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public z4 m586a() {
        return this.j;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final String m587a() {
        String b2;
        c.k.d.p.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            y a2 = y.a(this);
            b2 = null;
            while (true) {
                if (!TextUtils.isEmpty(b2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = g9.m181a("ro.miui.region");
                    if (TextUtils.isEmpty(b2)) {
                        b2 = g9.m181a("ro.product.locale.region");
                    }
                }
                try {
                    synchronized (obj) {
                        obj.wait(100L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            b2 = g9.b();
        }
        if (!TextUtils.isEmpty(b2)) {
            c.k.d.p9.a.a(getApplicationContext()).b(b2);
            str = g9.a(b2).name();
        }
        c.k.a.a.a.c.m6a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m588a() {
        if (System.currentTimeMillis() - this.f11274h >= g5.a() && e0.c(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.m.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        z4 z4Var = this.j;
        sb.append(z4Var == null ? null : Integer.valueOf(z4Var.hashCode()));
        c.k.a.a.a.c.m6a(sb.toString());
        z4 z4Var2 = this.j;
        if (z4Var2 != null) {
            z4Var2.a(i2, exc);
            this.j = null;
        }
        a(7);
        a(4);
        r.a().a(this, i2);
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
    }

    public final void a(Intent intent) {
        String stringExtra = intent.getStringExtra(v.w);
        String stringExtra2 = intent.getStringExtra(v.z);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        r a2 = r.a();
        s4 s4Var = null;
        if (bundleExtra != null) {
            q5 q5Var = (q5) a(new q5(bundleExtra), stringExtra, stringExtra2);
            if (q5Var == null) {
                return;
            } else {
                s4Var = s4.a(q5Var, a2.a(q5Var.d(), q5Var.f()).f7685i);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(v.n, 0L);
                String stringExtra3 = intent.getStringExtra(v.o);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                r.b a3 = a2.a(stringExtra4, Long.toString(longExtra));
                if (a3 != null) {
                    s4 s4Var2 = new s4();
                    try {
                        s4Var2.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException unused) {
                    }
                    s4Var2.a("SECMSG", (String) null);
                    s4Var2.a(longExtra, "xiaomi.com", stringExtra3);
                    s4Var2.a(intent.getStringExtra("ext_pkt_id"));
                    s4Var2.a(byteArrayExtra, a3.f7685i);
                    s4Var = s4Var2;
                }
            }
        }
        if (s4Var != null) {
            c(new d0(this, s4Var));
        }
    }

    public final void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        v7 v7Var = new v7();
        try {
            h8.a(v7Var, byteArrayExtra);
            c.k.d.j.a(getApplicationContext()).a((j.a) new b0(v7Var, new WeakReference(this), booleanExtra), i2);
        } catch (n8 unused) {
            c.k.a.a.a.c.d("aw_ping : send help app ping  error");
        }
    }

    public void a(r.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            c.k.a.a.a.c.m6a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(s4 s4Var) {
        z4 z4Var = this.j;
        if (z4Var == null) {
            throw new l5("try send msg while connection is null.");
        }
        z4Var.a(s4Var);
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var) {
        c.k.a.a.a.c.c("begin to connect...");
        n6.a().a(z4Var);
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, int i2, Exception exc) {
        n6.a().a(z4Var, i2, exc);
        if (m601i()) {
            return;
        }
        a(false);
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, Exception exc) {
        n6.a().a(z4Var, exc);
        c(false);
        if (m601i()) {
            return;
        }
        a(false);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.m.a(iVar, j2);
        } catch (IllegalStateException e2) {
            c.k.a.a.a.c.m6a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.p) {
            this.p.add(lVar);
        }
    }

    public final void a(String str, int i2) {
        Collection<r.b> m403a = r.a().m403a(str);
        if (m403a != null) {
            for (r.b bVar : m403a) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        r.a().m406a(str);
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        r.b a2 = r.a().a(str, str2);
        if (a2 != null) {
            a(new q(a2, i2, str4, str3));
        }
        r.a().m407a(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection<r.b> m403a = r.a().m403a("5");
        if (m403a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (m403a.iterator().next().m == r.c.binded) {
            a(new p0(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        n1.b(str, bArr);
    }

    public void a(boolean z) {
        this.f11268b.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            n1.a(this, str, bArr, 70000003, "null payload");
            c.k.a.a.a.c.m6a("register request without payload");
            return;
        }
        s7 s7Var = new s7();
        try {
            h8.a(s7Var, bArr);
            if (s7Var.f94a == v6.Registration) {
                w7 w7Var = new w7();
                try {
                    h8.a(w7Var, s7Var.m475a());
                    n1.a(s7Var.b(), bArr);
                    a(new m1(this, s7Var.b(), w7Var.b(), w7Var.c(), bArr));
                    j4.a(getApplicationContext()).a(s7Var.b(), "E100003", w7Var.a(), 6002, null);
                } catch (n8 e2) {
                    c.k.a.a.a.c.a(e2);
                    n1.a(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                n1.a(this, str, bArr, 70000003, " registration action required.");
                c.k.a.a.a.c.m6a("register request with invalid payload");
            }
        } catch (n8 e3) {
            c.k.a.a.a.c.a(e3);
            n1.a(this, str, bArr, 70000003, " data container error.");
        }
    }

    public void a(s4[] s4VarArr) {
        z4 z4Var = this.j;
        if (z4Var == null) {
            throw new l5("try send msg while connection is null.");
        }
        z4Var.a(s4VarArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m589a() {
        return e0.b(this) && r.a().m401a() > 0 && !m594b() && m600h() && !m599g() && !m598f();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m590a(int i2) {
        return this.m.m371a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m591a(String str, Intent intent) {
        r.b a2 = r.a().a(str, intent.getStringExtra(v.n));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(v.z);
        String stringExtra2 = intent.getStringExtra(v.s);
        if (!TextUtils.isEmpty(a2.j) && !TextUtils.equals(stringExtra, a2.j)) {
            c.k.a.a.a.c.m6a("session changed. old session=" + a2.j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.f7685i)) {
            return z;
        }
        c.k.a.a.a.c.m6a("security changed. chid = " + str + " sechash = " + j0.a(stringExtra2));
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final int[] m592a() {
        String[] split;
        String a2 = c.k.d.p9.m.a(getApplicationContext()).a(a7.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                c.k.a.a.a.c.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    public b1 b() {
        return this.k;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m593b() {
        Iterator it = new ArrayList(this.p).iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra(v.w);
        String stringExtra2 = intent.getStringExtra(v.z);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        q5[] q5VarArr = new q5[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            q5VarArr[i2] = new q5((Bundle) parcelableArrayExtra[i2]);
            q5VarArr[i2] = (q5) a(q5VarArr[i2], stringExtra, stringExtra2);
            if (q5VarArr[i2] == null) {
                return;
            }
        }
        r a2 = r.a();
        s4[] s4VarArr = new s4[length];
        for (int i3 = 0; i3 < length; i3++) {
            q5 q5Var = q5VarArr[i3];
            s4VarArr[i3] = s4.a(q5Var, a2.a(q5Var.d(), q5Var.f()).f7685i);
        }
        c(new a1(this, s4VarArr));
    }

    @Override // c.k.d.c5
    public void b(z4 z4Var) {
        n6.a().b(z4Var);
        c(true);
        this.f11268b.m364a();
        if (!k4.m267a() && !m601i()) {
            c.k.a.a.a.c.m6a("reconnection successful, reactivate alarm.");
            k4.a(true);
        }
        Iterator<r.b> it = r.a().m402a().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    public void b(i iVar) {
        this.m.a(iVar.f7570a, iVar);
    }

    public final void b(boolean z) {
        this.f11274h = System.currentTimeMillis();
        if (m595c()) {
            if (this.j.m550d() || this.j.e() || e0.d(this)) {
                c(new m(z));
                return;
            }
            c(new f(17, null));
        }
        a(true);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m594b() {
        try {
            Class<?> a2 = q9.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void c() {
        String str;
        c.k.d.p9.a a2 = c.k.d.p9.a.a(getApplicationContext());
        String a3 = a2.a();
        c.k.a.a.a.c.m6a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = m587a();
        }
        if (TextUtils.isEmpty(a3)) {
            this.f11269c = j9.China.name();
        } else {
            this.f11269c = a3;
            a2.a(a3);
            if (j9.Global.name().equals(this.f11269c)) {
                str = "app.chat.global.xiaomi.net";
            } else if (j9.Europe.name().equals(this.f11269c)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (j9.Russia.name().equals(this.f11269c)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (j9.India.name().equals(this.f11269c)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            a5.c(str);
        }
        if (j9.China.name().equals(this.f11269c)) {
            a5.c("cn.app.chat.xiaomi.net");
        }
        if (m600h()) {
            x0 x0Var = new x0(this, 11);
            a(x0Var);
            j1.a(new y0(this, x0Var));
        }
        try {
            if (q9.m435a()) {
                this.k.a(this);
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    public final void c(Intent intent) {
        String str;
        b1 b1Var;
        boolean z;
        int i2;
        String format;
        i nVar;
        String str2;
        String b2;
        String str3;
        d0 d0Var;
        r a2 = r.a();
        boolean z2 = true;
        int i3 = 0;
        if (v.f7715d.equalsIgnoreCase(intent.getAction()) || v.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(v.p);
            if (!TextUtils.isEmpty(intent.getStringExtra(v.s))) {
                if (stringExtra == null) {
                    str = "channel id is empty, do nothing!";
                    c.k.a.a.a.c.d(str);
                    return;
                }
                boolean m591a = m591a(stringExtra, intent);
                r.b a3 = a(stringExtra, intent);
                if (e0.b(this)) {
                    if (m595c()) {
                        r.c cVar = a3.m;
                        if (cVar == r.c.unbind) {
                            nVar = new a(a3);
                        } else if (m591a) {
                            nVar = new n(a3);
                        } else if (cVar == r.c.binding) {
                            format = String.format("the client is binding. %1$s %2$s.", a3.f7684h, r.b.a(a3.f7678b));
                        } else {
                            if (cVar != r.c.binded) {
                                return;
                            }
                            b1Var = this.k;
                            z = true;
                            i2 = 0;
                        }
                        c(nVar);
                        return;
                    }
                    a(true);
                    return;
                }
                b1Var = this.k;
                z = false;
                i2 = 2;
                b1Var.a(this, a3, z, i2, null);
                return;
            }
            format = "security is empty. ignore.";
            c.k.a.a.a.c.m6a(format);
            return;
        }
        if (v.f7720i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(v.w);
            String stringExtra3 = intent.getStringExtra(v.p);
            String stringExtra4 = intent.getStringExtra(v.n);
            c.k.a.a.a.c.m6a("Service called close channel chid = " + stringExtra3 + " res = " + r.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                Iterator<String> it = a2.m404a(stringExtra2).iterator();
                while (it.hasNext()) {
                    a(it.next(), 2);
                }
                return;
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
                return;
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
                return;
            }
        }
        if (v.f7716e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
            return;
        }
        if (v.f7718g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
            return;
        }
        if (v.f7717f.equalsIgnoreCase(intent.getAction())) {
            r5 a4 = a(new p5(intent.getBundleExtra("ext_packet")), intent.getStringExtra(v.w), intent.getStringExtra(v.z));
            if (a4 == null) {
                return;
            } else {
                d0Var = new d0(this, s4.a(a4, a2.a(a4.d(), a4.f()).f7685i));
            }
        } else {
            if (!v.f7719h.equalsIgnoreCase(intent.getAction())) {
                if (!v.k.equals(intent.getAction())) {
                    r.b bVar = null;
                    if (!v.l.equals(intent.getAction())) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                if (m601i()) {
                                    return;
                                }
                                c.k.a.a.a.c.m6a("exit falldown mode, activate alarm.");
                                e();
                                if (m595c() || m596d()) {
                                    return;
                                }
                                a(true);
                                return;
                            }
                            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || !m601i() || !k4.m267a()) {
                                return;
                            } else {
                                str2 = "enter falldown mode, stop alarm.";
                            }
                        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                            if (y.a(getApplicationContext()).m411a() && y.a(getApplicationContext()).a() == 0) {
                                str3 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                            } else {
                                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra5 = intent.getStringExtra("mipush_app_package");
                                boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                                int intExtra = intent.getIntExtra("mipush_env_type", 1);
                                k1.a(this).d(stringExtra5);
                                if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                    a(byteArrayExtra, stringExtra5);
                                    return;
                                }
                                nVar = new z0(this, 14, intExtra, byteArrayExtra, stringExtra5);
                            }
                        } else {
                            if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                String stringExtra6 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                                boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                    k1.a(this).a(stringExtra6);
                                }
                                a(stringExtra6, byteArrayExtra2, booleanExtra2);
                                return;
                            }
                            if (!z.f7739a.equals(intent.getAction())) {
                                if (z.f7740b.equals(intent.getAction())) {
                                    String stringExtra7 = intent.getStringExtra("data_cleared_pkg_name");
                                    if (stringExtra7 == null || TextUtils.isEmpty(stringExtra7.trim())) {
                                        return;
                                    }
                                    c.k.a.a.a.c.m6a("clear notifications of package " + stringExtra7);
                                    c.k.d.p9.b.m357a((Context) this, stringExtra7);
                                    return;
                                }
                                if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                                    String stringExtra8 = intent.getStringExtra(v.w);
                                    int intExtra2 = intent.getIntExtra(v.x, -2);
                                    if (TextUtils.isEmpty(stringExtra8)) {
                                        return;
                                    }
                                    if (intExtra2 >= -1) {
                                        c.k.d.p9.b.a(this, stringExtra8, intExtra2);
                                        return;
                                    } else {
                                        c.k.d.p9.b.a(this, stringExtra8, intent.getStringExtra(v.B), intent.getStringExtra(v.C));
                                        return;
                                    }
                                }
                                if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                                    String stringExtra9 = intent.getStringExtra(v.w);
                                    String stringExtra10 = intent.getStringExtra(v.A);
                                    if (intent.hasExtra(v.y)) {
                                        int intExtra3 = intent.getIntExtra(v.y, 0);
                                        b2 = j0.b(stringExtra9 + intExtra3);
                                        i3 = intExtra3;
                                        z2 = false;
                                    } else {
                                        b2 = j0.b(stringExtra9);
                                    }
                                    if (!TextUtils.isEmpty(stringExtra9) && TextUtils.equals(stringExtra10, b2)) {
                                        if (z2) {
                                            c.k.d.p9.b.m361b((Context) this, stringExtra9);
                                            return;
                                        } else {
                                            c.k.d.p9.b.b(this, stringExtra9, i3);
                                            return;
                                        }
                                    }
                                    str = "invalid notification for " + stringExtra9;
                                    c.k.a.a.a.c.d(str);
                                    return;
                                }
                                if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                                    String stringExtra11 = intent.getStringExtra("mipush_app_package");
                                    if (!TextUtils.isEmpty(stringExtra11)) {
                                        k1.a(this).b(stringExtra11);
                                    }
                                    if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                        return;
                                    }
                                    a(19, (Exception) null);
                                    e();
                                    stopSelf();
                                    return;
                                }
                                if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    String stringExtra12 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                                    String stringExtra13 = intent.getStringExtra("mipush_app_id");
                                    String stringExtra14 = intent.getStringExtra("mipush_app_token");
                                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        k1.a(this).c(stringExtra12);
                                    }
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        k1.a(this).e(stringExtra12);
                                        k1.a(this).f(stringExtra12);
                                    }
                                    if (byteArrayExtra3 == null) {
                                        n1.a(this, stringExtra12, byteArrayExtra3, 70000003, "null payload");
                                        return;
                                    }
                                    n1.b(stringExtra12, byteArrayExtra3);
                                    a(new m1(this, stringExtra12, stringExtra13, stringExtra14, byteArrayExtra3));
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f11270d == null) {
                                        this.f11270d = new e();
                                        registerReceiver(this.f11270d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                        return;
                                    }
                                    return;
                                }
                                if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                                    String stringExtra15 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                                    z6 z6Var = new z6();
                                    try {
                                        h8.a(z6Var, byteArrayExtra4);
                                        t6.a(this).a(z6Var, stringExtra15);
                                        return;
                                    } catch (n8 e2) {
                                        c.k.a.a.a.c.a(e2);
                                        return;
                                    }
                                }
                                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                                    c.k.a.a.a.c.m6a("Service called on timer");
                                    if (!m601i()) {
                                        k4.a(false);
                                        if (!m597e()) {
                                            return;
                                        }
                                    } else if (!k4.m267a()) {
                                        return;
                                    } else {
                                        str2 = "enter falldown mode, stop alarm";
                                    }
                                } else {
                                    if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                            c.k.a.a.a.c.m6a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                                            k4.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                                            return;
                                        }
                                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                                            d();
                                            return;
                                        }
                                        if ("action_cr_config".equals(intent.getAction())) {
                                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                                            a.C0127a g2 = c.k.b.a.a.g();
                                            g2.b(booleanExtra3);
                                            g2.a(longExtra);
                                            g2.c(booleanExtra4);
                                            g2.c(longExtra2);
                                            g2.a(c.k.d.o0.a(getApplicationContext()));
                                            g2.a(booleanExtra5);
                                            g2.b(longExtra3);
                                            c.k.b.a.a a5 = g2.a(getApplicationContext());
                                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                                return;
                                            }
                                            i4.a(getApplicationContext(), a5);
                                            return;
                                        }
                                        if (!"action_help_ping".equals(intent.getAction())) {
                                            if ("action_aw_app_logic".equals(intent.getAction())) {
                                                d(intent);
                                                return;
                                            }
                                            return;
                                        }
                                        boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                                        int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                                        if (intExtra4 >= 0 && intExtra4 < 30) {
                                            c.k.a.a.a.c.c("aw_ping: frquency need > 30s.");
                                            intExtra4 = 30;
                                        }
                                        boolean z3 = intExtra4 >= 0 ? booleanExtra6 : false;
                                        c.k.a.a.a.c.m6a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                                        if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                            return;
                                        }
                                        a(intent, intExtra4);
                                        return;
                                    }
                                    c.k.a.a.a.c.m6a("Service called on check alive.");
                                    if (!m597e()) {
                                        return;
                                    }
                                }
                                b(false);
                                return;
                            }
                            String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
                            if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                                return;
                            }
                            try {
                                getPackageManager().getPackageInfo(stringExtra16, 0);
                                z2 = false;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra16) || r.a().m403a("1").isEmpty() || !z2) {
                                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences.getString(stringExtra16, null);
                                if (TextUtils.isEmpty(string) || !z2) {
                                    return;
                                }
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.remove(stringExtra16);
                                edit.commit();
                                if (c.k.d.p9.b.m362b((Context) this, stringExtra16)) {
                                    c.k.d.p9.b.m361b((Context) this, stringExtra16);
                                }
                                c.k.d.p9.b.m357a((Context) this, stringExtra16);
                                if (!m595c() || string == null) {
                                    return;
                                }
                                try {
                                    w1.a(this, w1.a(stringExtra16, string));
                                    c.k.a.a.a.c.m6a("uninstall " + stringExtra16 + " msg sent");
                                    return;
                                } catch (l5 e3) {
                                    c.k.a.a.a.c.d("Fail to send Message: " + e3.getMessage());
                                    a(10, e3);
                                    return;
                                }
                            }
                            a("1", 0);
                            str3 = "close the miliao channel as the app is uninstalled.";
                        }
                        c.k.a.a.a.c.m6a(str2);
                        k4.a();
                        return;
                    }
                    String stringExtra17 = intent.getStringExtra(v.w);
                    List<String> m404a = a2.m404a(stringExtra17);
                    if (!m404a.isEmpty()) {
                        String stringExtra18 = intent.getStringExtra(v.p);
                        String stringExtra19 = intent.getStringExtra(v.n);
                        if (TextUtils.isEmpty(stringExtra18)) {
                            stringExtra18 = m404a.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra19)) {
                            Collection<r.b> m403a = a2.m403a(stringExtra18);
                            if (m403a != null && !m403a.isEmpty()) {
                                bVar = m403a.iterator().next();
                            }
                        } else {
                            bVar = a2.a(stringExtra18, stringExtra19);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(v.u)) {
                                bVar.f7682f = intent.getStringExtra(v.u);
                            }
                            if (intent.hasExtra(v.v)) {
                                bVar.f7683g = intent.getStringExtra(v.v);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str3 = "open channel should be called first before update info, pkg=" + stringExtra17;
                    c.k.a.a.a.c.m6a(str3);
                    return;
                }
                String stringExtra20 = intent.getStringExtra(v.p);
                String stringExtra21 = intent.getStringExtra(v.n);
                if (stringExtra20 == null) {
                    return;
                }
                c.k.a.a.a.c.m6a("request reset connection from chid = " + stringExtra20);
                r.b a6 = r.a().a(stringExtra20, stringExtra21);
                if (a6 == null || !a6.f7685i.equals(intent.getStringExtra(v.s)) || a6.m != r.c.binded) {
                    return;
                }
                z4 m586a = m586a();
                if (m586a != null && m586a.a(System.currentTimeMillis() - 15000)) {
                    return;
                } else {
                    nVar = new o();
                }
                c(nVar);
                return;
            }
            r5 a7 = a(new t5(intent.getBundleExtra("ext_packet")), intent.getStringExtra(v.w), intent.getStringExtra(v.z));
            if (a7 == null) {
                return;
            } else {
                d0Var = new d0(this, s4.a(a7, a2.a(a7.d(), a7.f()).f7685i));
            }
        }
        c(d0Var);
    }

    public final void c(i iVar) {
        this.m.a(iVar);
    }

    public final void c(boolean z) {
        try {
            if (q9.m435a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (c.k.d.p9.g gVar : (c.k.d.p9.g[]) this.o.toArray(new c.k.d.p9.g[0])) {
                    gVar.mo388a();
                }
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m595c() {
        z4 z4Var = this.j;
        return z4Var != null && z4Var.m549c();
    }

    public final void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            c.k.a.a.a.c.m6a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            c.k.a.a.a.c.m6a("network changed, no active network");
        }
        if (n6.a() != null) {
            n6.a().m299a();
        }
        g6.m178a((Context) this);
        this.f11275i.d();
        if (e0.b(this)) {
            if (m595c() && m597e()) {
                b(false);
            }
            if (!m595c() && !m596d()) {
                this.m.a(1);
                a(new d());
            }
            d2.a(this).a();
        } else {
            a(new f(2, null));
        }
        e();
    }

    public final void d(Intent intent) {
        int i2;
        try {
            x3.a(getApplicationContext()).a(new x());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            v7 v7Var = new v7();
            h8.a(v7Var, byteArrayExtra);
            String b2 = v7Var.b();
            Map<String, String> m504a = v7Var.m504a();
            if (m504a != null) {
                String str = m504a.get("extra_help_aw_info");
                String str2 = m504a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                x3.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (n8 e2) {
            c.k.a.a.a.c.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m596d() {
        z4 z4Var = this.j;
        return z4Var != null && z4Var.m548b();
    }

    public final void e() {
        if (!m589a()) {
            k4.a();
        } else {
            if (k4.m267a()) {
                return;
            }
            k4.a(true);
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public final boolean m597e() {
        if (System.currentTimeMillis() - this.f11274h < 30000) {
            return false;
        }
        return e0.c(this);
    }

    public final void f() {
        String str;
        z4 z4Var = this.j;
        if (z4Var == null || !z4Var.m548b()) {
            z4 z4Var2 = this.j;
            if (z4Var2 == null || !z4Var2.m549c()) {
                this.f11267a.a(e0.m138a((Context) this));
                g();
                if (this.j == null) {
                    r.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        c.k.a.a.a.c.d(str);
    }

    /* renamed from: f, reason: collision with other method in class */
    public final boolean m598f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    public final void g() {
        try {
            this.f11275i.a(this.q, new r0(this));
            this.f11275i.e();
            this.j = this.f11275i;
        } catch (l5 e2) {
            c.k.a.a.a.c.a("fail to create Slim connection", e2);
            this.f11275i.a(3, e2);
        }
    }

    /* renamed from: g, reason: collision with other method in class */
    public final boolean m599g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    public final void h() {
    }

    /* renamed from: h, reason: collision with other method in class */
    public final boolean m600h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !k1.a(this).m399b(getPackageName());
    }

    public final void i() {
        synchronized (this.p) {
            this.p.clear();
        }
    }

    /* renamed from: i, reason: collision with other method in class */
    public final boolean m601i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !f7.m156b((Context) this) && !f7.m153a(getApplicationContext());
    }

    public final boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f11272f;
        int i3 = this.f11273g;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return c.k.d.p9.m.a(this).a(a7.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.n.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        q9.m434a((Context) this);
        i1 a2 = j1.a((Context) this);
        if (a2 != null) {
            c.k.d.c.a(a2.f7612g);
        }
        this.n = new Messenger(new s0(this));
        w.a(this);
        t0 t0Var = new t0(this, null, 5222, "xiaomi.com", null);
        this.f11267a = t0Var;
        t0Var.a(true);
        this.f11275i = new x4(this, this.f11267a);
        this.k = a();
        k4.a(this);
        this.f11275i.a(this);
        this.l = new c.k.d.p9.q(this);
        this.f11268b = new c0(this);
        new c1().a();
        n6.m307a().a(this);
        this.m = new e1("Connection Controller Thread");
        r a3 = r.a();
        a3.b();
        a3.a(new u0(this));
        if (k()) {
            h();
        }
        t6.a(this).a(new g1(this), "UPLOADER_PUSH_CHANNEL");
        a(new q6(this));
        a(new g());
        this.o.add(c.k.d.p9.j0.a(this));
        if (m600h()) {
            this.f11270d = new e();
            registerReceiver(this.f11270d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.r = new v0(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.r);
                } catch (Throwable th) {
                    c.k.a.a.a.c.m6a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.t = new w0(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.t);
                } catch (Throwable th2) {
                    c.k.a.a.a.c.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] m592a = m592a();
            if (m592a != null) {
                this.f11271e = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f11271e, intentFilter);
                this.f11272f = m592a[0];
                this.f11273g = m592a[1];
                c.k.a.a.a.c.m6a("falldown initialized: " + this.f11272f + "," + this.f11273g);
            }
        }
        c.k.a.a.a.c.m6a("XMPushService created pid = " + u);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e eVar = this.f11270d;
        if (eVar != null) {
            a(eVar);
            this.f11270d = null;
        }
        p pVar = this.f11271e;
        if (pVar != null) {
            a(pVar);
            this.f11271e = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.r != null) {
            try {
                getContentResolver().unregisterContentObserver(this.r);
            } catch (Throwable th) {
                c.k.a.a.a.c.m6a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.t != null) {
            try {
                getContentResolver().unregisterContentObserver(this.t);
            } catch (Throwable th2) {
                c.k.a.a.a.c.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.o.clear();
        this.m.b();
        a(new q0(this, 2));
        a(new j());
        r.a().b();
        r.a().a(this, 15);
        r.a().m405a();
        this.f11275i.b(this);
        h0.a().m386a();
        k4.a();
        i();
        super.onDestroy();
        c.k.a.a.a.c.m6a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            c.k.a.a.a.c.d("onStart() with intent NULL");
        } else {
            c.k.a.a.a.c.c(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s", intent.getAction(), intent.getStringExtra(v.p), intent.getStringExtra(v.w), intent.getStringExtra("mipush_app_package"), intent.getStringExtra("ext_is_xmpushservice_bridge")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.m.m370a()) {
                    c.k.a.a.a.c.d("ERROR, the job controller is blocked.");
                    r.a().a(this, 14);
                    stopSelf();
                } else {
                    hVar = new h(intent);
                    a(hVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                hVar = new h(intent);
                a(hVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            c.k.a.a.a.c.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return v;
    }
}
