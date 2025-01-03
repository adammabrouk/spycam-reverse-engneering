package c.c.a.b.g.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.f.e.a1;
import c.c.a.b.f.e.b1;
import c.c.a.b.f.e.f1;
import c.c.a.b.f.e.oa;
import c.c.a.b.f.e.x0;
import c.c.a.b.f.e.z0;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import com.shix.shixipc.utilcode.TimeConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public class l9 implements y5 {
    public static volatile l9 x;

    /* renamed from: a, reason: collision with root package name */
    public v4 f4901a;

    /* renamed from: b, reason: collision with root package name */
    public e4 f4902b;

    /* renamed from: c, reason: collision with root package name */
    public c f4903c;

    /* renamed from: d, reason: collision with root package name */
    public h4 f4904d;

    /* renamed from: e, reason: collision with root package name */
    public h9 f4905e;

    /* renamed from: f, reason: collision with root package name */
    public aa f4906f;

    /* renamed from: g, reason: collision with root package name */
    public final p9 f4907g;

    /* renamed from: h, reason: collision with root package name */
    public k7 f4908h;

    /* renamed from: i, reason: collision with root package name */
    public final a5 f4909i;
    public boolean j;
    public boolean k;
    public long l;
    public List<Runnable> m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public FileLock s;
    public FileChannel t;
    public List<Long> u;
    public List<Long> v;
    public long w;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public c.c.a.b.f.e.b1 f4910a;

        /* renamed from: b, reason: collision with root package name */
        public List<Long> f4911b;

        /* renamed from: c, reason: collision with root package name */
        public List<c.c.a.b.f.e.x0> f4912c;

        /* renamed from: d, reason: collision with root package name */
        public long f4913d;

        public a(l9 l9Var) {
        }

        @Override // c.c.a.b.g.b.e
        public final void a(c.c.a.b.f.e.b1 b1Var) {
            c.c.a.b.c.o.r.a(b1Var);
            this.f4910a = b1Var;
        }

        public /* synthetic */ a(l9 l9Var, k9 k9Var) {
            this(l9Var);
        }

        @Override // c.c.a.b.g.b.e
        public final boolean a(long j, c.c.a.b.f.e.x0 x0Var) {
            c.c.a.b.c.o.r.a(x0Var);
            if (this.f4912c == null) {
                this.f4912c = new ArrayList();
            }
            if (this.f4911b == null) {
                this.f4911b = new ArrayList();
            }
            if (this.f4912c.size() > 0 && a(this.f4912c.get(0)) != a(x0Var)) {
                return false;
            }
            long e2 = this.f4913d + x0Var.e();
            if (e2 >= Math.max(0, r.f5034i.a(null).intValue())) {
                return false;
            }
            this.f4913d = e2;
            this.f4912c.add(x0Var);
            this.f4911b.add(Long.valueOf(j));
            return this.f4912c.size() < Math.max(1, r.j.a(null).intValue());
        }

        public static long a(c.c.a.b.f.e.x0 x0Var) {
            return ((x0Var.q() / 1000) / 60) / 60;
        }
    }

    public l9(q9 q9Var) {
        this(q9Var, null);
    }

    public static l9 a(Context context) {
        c.c.a.b.c.o.r.a(context);
        c.c.a.b.c.o.r.a(context.getApplicationContext());
        if (x == null) {
            synchronized (l9.class) {
                if (x == null) {
                    x = new l9(new q9(context));
                }
            }
        }
        return x;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.A():void");
    }

    @Override // c.c.a.b.g.b.y5
    public final fa F() {
        return this.f4909i.F();
    }

    @Override // c.c.a.b.g.b.y5
    public final c.c.a.b.c.s.e b() {
        return this.f4909i.b();
    }

    @Override // c.c.a.b.g.b.y5
    public final w3 c() {
        return this.f4909i.c();
    }

    @Override // c.c.a.b.g.b.y5
    public final Context d() {
        return this.f4909i.d();
    }

    public final void e() {
        this.f4909i.a().g();
        k().B();
        if (this.f4909i.p().f4827e.a() == 0) {
            this.f4909i.p().f4827e.a(this.f4909i.b().a());
        }
        A();
    }

    public final void f() {
        x();
        if (this.p || this.q || this.r) {
            this.f4909i.c().B().a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.p), Boolean.valueOf(this.q), Boolean.valueOf(this.r));
            return;
        }
        this.f4909i.c().B().a("Stopping uploading service(s)");
        List<Runnable> list = this.m;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.m.clear();
    }

    public final boolean g() {
        FileLock fileLock;
        x();
        if (this.f4909i.o().a(r.n0) && (fileLock = this.s) != null && fileLock.isValid()) {
            this.f4909i.c().B().a("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f4909i.d().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.t = channel;
            FileLock tryLock = channel.tryLock();
            this.s = tryLock;
            if (tryLock != null) {
                this.f4909i.c().B().a("Storage concurrent access okay");
                return true;
            }
            this.f4909i.c().t().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.f4909i.c().t().a("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.f4909i.c().t().a("Failed to access storage lock file", e3);
            return false;
        } catch (OverlappingFileLockException e4) {
            this.f4909i.c().w().a("Storage lock already acquired", e4);
            return false;
        }
    }

    public final b h() {
        return this.f4909i.o();
    }

    public final v4 i() {
        b(this.f4901a);
        return this.f4901a;
    }

    public final e4 j() {
        b(this.f4902b);
        return this.f4902b;
    }

    public final c k() {
        b(this.f4903c);
        return this.f4903c;
    }

    public final aa l() {
        b(this.f4906f);
        return this.f4906f;
    }

    public final k7 m() {
        b(this.f4908h);
        return this.f4908h;
    }

    public final p9 n() {
        b(this.f4907g);
        return this.f4907g;
    }

    public final u3 o() {
        return this.f4909i.w();
    }

    public final s9 p() {
        return this.f4909i.v();
    }

    public final void q() {
        if (!this.j) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void r() {
        d5 b2;
        String str;
        x();
        q();
        this.r = true;
        try {
            this.f4909i.F();
            Boolean G = this.f4909i.E().G();
            if (G == null) {
                this.f4909i.c().w().a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (G.booleanValue()) {
                this.f4909i.c().t().a("Upload called in the client side when service should be used");
                return;
            }
            if (this.l > 0) {
                A();
                return;
            }
            x();
            if (this.u != null) {
                this.f4909i.c().B().a("Uploading requested multiple times");
                return;
            }
            if (!j().t()) {
                this.f4909i.c().B().a("Network not connected, ignoring upload request");
                A();
                return;
            }
            long a2 = this.f4909i.b().a();
            int b3 = this.f4909i.o().b(null, r.Q);
            long x2 = a2 - b.x();
            for (int i2 = 0; i2 < b3 && a((String) null, x2); i2++) {
            }
            long a3 = this.f4909i.p().f4827e.a();
            if (a3 != 0) {
                this.f4909i.c().A().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a2 - a3)));
            }
            String v = k().v();
            if (TextUtils.isEmpty(v)) {
                this.w = -1L;
                String a4 = k().a(a2 - b.x());
                if (!TextUtils.isEmpty(a4) && (b2 = k().b(a4)) != null) {
                    a(b2);
                }
            } else {
                if (this.w == -1) {
                    this.w = k().w();
                }
                List<Pair<c.c.a.b.f.e.b1, Long>> a5 = k().a(v, this.f4909i.o().b(v, r.f5032g), Math.max(0, this.f4909i.o().b(v, r.f5033h)));
                if (!a5.isEmpty()) {
                    Iterator<Pair<c.c.a.b.f.e.b1, Long>> it = a5.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        c.c.a.b.f.e.b1 b1Var = (c.c.a.b.f.e.b1) it.next().first;
                        if (!TextUtils.isEmpty(b1Var.q())) {
                            str = b1Var.q();
                            break;
                        }
                    }
                    if (str != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= a5.size()) {
                                break;
                            }
                            c.c.a.b.f.e.b1 b1Var2 = (c.c.a.b.f.e.b1) a5.get(i3).first;
                            if (!TextUtils.isEmpty(b1Var2.q()) && !b1Var2.q().equals(str)) {
                                a5 = a5.subList(0, i3);
                                break;
                            }
                            i3++;
                        }
                    }
                    a1.a n = c.c.a.b.f.e.a1.n();
                    int size = a5.size();
                    ArrayList arrayList = new ArrayList(a5.size());
                    boolean f2 = this.f4909i.o().f(v);
                    for (int i4 = 0; i4 < size; i4++) {
                        b1.a j = ((c.c.a.b.f.e.b1) a5.get(i4).first).j();
                        arrayList.add((Long) a5.get(i4).second);
                        j.g(this.f4909i.o().n());
                        j.a(a2);
                        this.f4909i.F();
                        j.b(false);
                        if (!f2) {
                            j.v();
                        }
                        if (this.f4909i.o().e(v, r.Z)) {
                            j.l(n().a(((c.c.a.b.f.e.b1) ((c.c.a.b.f.e.s4) j.F())).g()));
                        }
                        n.a(j);
                    }
                    String a6 = this.f4909i.c().a(2) ? n().a((c.c.a.b.f.e.a1) ((c.c.a.b.f.e.s4) n.F())) : null;
                    n();
                    byte[] g2 = ((c.c.a.b.f.e.a1) ((c.c.a.b.f.e.s4) n.F())).g();
                    String a7 = r.q.a(null);
                    try {
                        URL url = new URL(a7);
                        c.c.a.b.c.o.r.a(!arrayList.isEmpty());
                        if (this.u != null) {
                            this.f4909i.c().t().a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.u = new ArrayList(arrayList);
                        }
                        this.f4909i.p().f4828f.a(a2);
                        this.f4909i.c().B().a("Uploading data. app, uncompressed size, data", size > 0 ? n.a(0).w0() : "?", Integer.valueOf(g2.length), a6);
                        this.q = true;
                        e4 j2 = j();
                        n9 n9Var = new n9(this, v);
                        j2.g();
                        j2.q();
                        c.c.a.b.c.o.r.a(url);
                        c.c.a.b.c.o.r.a(g2);
                        c.c.a.b.c.o.r.a(n9Var);
                        j2.a().b(new i4(j2, v, url, g2, null, n9Var));
                    } catch (MalformedURLException unused) {
                        this.f4909i.c().t().a("Failed to parse upload URL. Not uploading. appId", w3.a(v), a7);
                    }
                }
            }
        } finally {
            this.r = false;
            f();
        }
    }

    public final void s() {
        x();
        q();
        if (this.k) {
            return;
        }
        this.k = true;
        if (g()) {
            int a2 = a(this.t);
            int E = this.f4909i.H().E();
            x();
            if (a2 > E) {
                this.f4909i.c().t().a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(E));
            } else if (a2 < E) {
                if (a(E, this.t)) {
                    this.f4909i.c().B().a("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(E));
                } else {
                    this.f4909i.c().t().a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(E));
                }
            }
        }
    }

    public final void t() {
        this.o++;
    }

    public final a5 u() {
        return this.f4909i;
    }

    public final h4 v() {
        h4 h4Var = this.f4904d;
        if (h4Var != null) {
            return h4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final h9 w() {
        b(this.f4905e);
        return this.f4905e;
    }

    public final void x() {
        this.f4909i.a().g();
    }

    public final long y() {
        long a2 = this.f4909i.b().a();
        j4 p = this.f4909i.p();
        p.n();
        p.g();
        long a3 = p.f4831i.a();
        if (a3 == 0) {
            a3 = 1 + p.j().t().nextInt(TimeConstants.DAY);
            p.f4831i.a(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    public final boolean z() {
        x();
        q();
        return k().E() || !TextUtils.isEmpty(k().v());
    }

    public l9(q9 q9Var, a5 a5Var) {
        this.j = false;
        c.c.a.b.c.o.r.a(q9Var);
        this.f4909i = a5.a(q9Var.f5025a, null, null);
        this.w = -1L;
        p9 p9Var = new p9(this);
        p9Var.r();
        this.f4907g = p9Var;
        e4 e4Var = new e4(this);
        e4Var.r();
        this.f4902b = e4Var;
        v4 v4Var = new v4(this);
        v4Var.r();
        this.f4901a = v4Var;
        this.f4909i.a().a(new k9(this, q9Var));
    }

    public static void b(i9 i9Var) {
        if (i9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (i9Var.p()) {
            return;
        }
        String valueOf = String.valueOf(i9Var.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    public final d5 c(zzm zzmVar) {
        x();
        q();
        c.c.a.b.c.o.r.a(zzmVar);
        c.c.a.b.c.o.r.b(zzmVar.f10218a);
        d5 b2 = k().b(zzmVar.f10218a);
        String b3 = this.f4909i.p().b(zzmVar.f10218a);
        if (!c.c.a.b.f.e.ba.a() || !this.f4909i.o().a(r.v0)) {
            return a(zzmVar, b2, b3);
        }
        if (b2 == null) {
            b2 = new d5(this.f4909i, zzmVar.f10218a);
            b2.a(this.f4909i.v().v());
            b2.e(b3);
        } else if (!b3.equals(b2.q())) {
            b2.e(b3);
            b2.a(this.f4909i.v().v());
        }
        b2.b(zzmVar.f10219b);
        b2.c(zzmVar.r);
        if (oa.a() && this.f4909i.o().e(b2.l(), r.p0)) {
            b2.d(zzmVar.w);
        }
        if (!TextUtils.isEmpty(zzmVar.k)) {
            b2.f(zzmVar.k);
        }
        long j = zzmVar.f10222e;
        if (j != 0) {
            b2.d(j);
        }
        if (!TextUtils.isEmpty(zzmVar.f10220c)) {
            b2.g(zzmVar.f10220c);
        }
        b2.c(zzmVar.j);
        String str = zzmVar.f10221d;
        if (str != null) {
            b2.h(str);
        }
        b2.e(zzmVar.f10223f);
        b2.a(zzmVar.f10225h);
        if (!TextUtils.isEmpty(zzmVar.f10224g)) {
            b2.i(zzmVar.f10224g);
        }
        if (!this.f4909i.o().a(r.N0)) {
            b2.p(zzmVar.l);
        }
        b2.b(zzmVar.o);
        b2.c(zzmVar.p);
        b2.a(zzmVar.t);
        b2.f(zzmVar.u);
        if (b2.a()) {
            k().a(b2);
        }
        return b2;
    }

    public final String d(zzm zzmVar) {
        try {
            return (String) this.f4909i.a().a(new o9(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.f4909i.c().t().a("Failed to get app instance id. appId", w3.a(zzmVar.f10218a), e2);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:97|(1:99)(1:296)|100|(6:105|106|107|(1:109)|110|(0))|288|289|290|291|106|107|(0)|110|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x035e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0360, code lost:
    
        r7.c().t().a("Error pruning currencies. appId", c.c.a.b.g.b.w3.a(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0396 A[Catch: all -> 0x09f2, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03cd A[Catch: all -> 0x09f2, TRY_LEAVE, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03f3 A[Catch: all -> 0x09f2, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0446 A[Catch: all -> 0x09f2, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x09a3 A[Catch: all -> 0x09f2, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0237 A[Catch: all -> 0x09f2, TRY_LEAVE, TryCatch #0 {all -> 0x09f2, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:86:0x0276, B:88:0x0280, B:90:0x028e, B:93:0x02bf, B:95:0x02c5, B:97:0x02d3, B:99:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:107:0x038c, B:109:0x0396, B:112:0x03cd, B:115:0x03df, B:117:0x03f3, B:119:0x0403, B:120:0x0414, B:122:0x0446, B:124:0x044b, B:125:0x0464, B:129:0x0475, B:131:0x0489, B:133:0x048e, B:134:0x04a7, B:138:0x04ca, B:142:0x04ef, B:143:0x0508, B:146:0x0517, B:149:0x053a, B:150:0x0556, B:152:0x0560, B:154:0x056c, B:156:0x0572, B:157:0x057d, B:159:0x0589, B:160:0x05a0, B:162:0x05c7, B:165:0x05e0, B:168:0x0624, B:169:0x064c, B:171:0x0684, B:172:0x0689, B:174:0x0691, B:175:0x0696, B:177:0x069e, B:178:0x06a3, B:180:0x06ac, B:181:0x06b2, B:183:0x06bf, B:184:0x06c4, B:186:0x06ca, B:188:0x06da, B:190:0x06e4, B:192:0x06ec, B:193:0x06f1, B:195:0x06fb, B:197:0x0705, B:199:0x070d, B:200:0x072a, B:202:0x0732, B:203:0x0737, B:205:0x074c, B:207:0x0756, B:208:0x0759, B:210:0x0767, B:212:0x0771, B:214:0x0775, B:216:0x0780, B:217:0x07ee, B:219:0x0833, B:220:0x0838, B:222:0x0840, B:224:0x0849, B:225:0x084e, B:227:0x085a, B:229:0x08be, B:230:0x08c3, B:231:0x08cf, B:233:0x08d9, B:234:0x08e0, B:236:0x08ea, B:237:0x08f1, B:238:0x08fc, B:240:0x0902, B:243:0x0931, B:244:0x0941, B:246:0x0949, B:247:0x094f, B:249:0x0955, B:253:0x099d, B:255:0x09a3, B:256:0x09bf, B:261:0x0963, B:263:0x0988, B:269:0x09a7, B:270:0x078c, B:272:0x079e, B:274:0x07a2, B:276:0x07b4, B:277:0x07eb, B:278:0x07ce, B:280:0x07d4, B:281:0x0713, B:283:0x071d, B:285:0x0725, B:286:0x063e, B:288:0x0325, B:290:0x0343, B:291:0x0371, B:295:0x0360, B:296:0x02e4, B:298:0x0298, B:299:0x02b5), top: B:53:0x01e7, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.android.gms.measurement.internal.zzaq r30, com.google.android.gms.measurement.internal.zzm r31) {
        /*
            Method dump skipped, instructions count: 2558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.b(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzm):void");
    }

    public final void a(q9 q9Var) {
        this.f4909i.a().g();
        c cVar = new c(this);
        cVar.r();
        this.f4903c = cVar;
        this.f4909i.o().a(this.f4901a);
        aa aaVar = new aa(this);
        aaVar.r();
        this.f4906f = aaVar;
        k7 k7Var = new k7(this);
        k7Var.r();
        this.f4908h = k7Var;
        h9 h9Var = new h9(this);
        h9Var.r();
        this.f4905e = h9Var;
        this.f4904d = new h4(this);
        if (this.n != this.o) {
            this.f4909i.c().t().a("Not all upload components initialized", Integer.valueOf(this.n), Integer.valueOf(this.o));
        }
        this.j = true;
    }

    public final boolean e(zzm zzmVar) {
        return (oa.a() && this.f4909i.o().e(zzmVar.f10218a, r.p0)) ? (TextUtils.isEmpty(zzmVar.f10219b) && TextUtils.isEmpty(zzmVar.w) && TextUtils.isEmpty(zzmVar.r)) ? false : true : (TextUtils.isEmpty(zzmVar.f10219b) && TextUtils.isEmpty(zzmVar.r)) ? false : true;
    }

    @Override // c.c.a.b.g.b.y5
    public final x4 a() {
        return this.f4909i.a();
    }

    public final void a(zzaq zzaqVar, String str) {
        d5 b2 = k().b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.u())) {
            Boolean b3 = b(b2);
            if (b3 == null) {
                if (!"_ui".equals(zzaqVar.f10207a)) {
                    this.f4909i.c().w().a("Could not find package. appId", w3.a(str));
                }
            } else if (!b3.booleanValue()) {
                this.f4909i.c().t().a("App version does not match; dropping event. appId", w3.a(str));
                return;
            }
            a(zzaqVar, new zzm(str, b2.n(), b2.u(), b2.v(), b2.w(), b2.x(), b2.y(), (String) null, b2.A(), false, b2.r(), b2.f(), 0L, 0, b2.g(), b2.h(), false, b2.o(), b2.i(), b2.z(), b2.j(), (oa.a() && this.f4909i.o().e(b2.l(), r.p0)) ? b2.p() : null));
            return;
        }
        this.f4909i.c().A().a("No app data available; dropping event", str);
    }

    public final void a(zzaq zzaqVar, zzm zzmVar) {
        List<zzy> a2;
        List<zzy> a3;
        List<zzy> a4;
        List<String> list;
        zzaq zzaqVar2 = zzaqVar;
        c.c.a.b.c.o.r.a(zzmVar);
        c.c.a.b.c.o.r.b(zzmVar.f10218a);
        x();
        q();
        String str = zzmVar.f10218a;
        long j = zzaqVar2.f10210d;
        n();
        if (p9.a(zzaqVar, zzmVar)) {
            if (!zzmVar.f10225h) {
                c(zzmVar);
                return;
            }
            if (this.f4909i.o().e(str, r.d0) && (list = zzmVar.v) != null) {
                if (list.contains(zzaqVar2.f10207a)) {
                    Bundle zzb = zzaqVar2.f10208b.zzb();
                    zzb.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.f10207a, new zzal(zzb), zzaqVar2.f10209c, zzaqVar2.f10210d);
                } else {
                    this.f4909i.c().A().a("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.f10207a, zzaqVar2.f10209c);
                    return;
                }
            }
            k().y();
            try {
                c k = k();
                c.c.a.b.c.o.r.b(str);
                k.g();
                k.q();
                if (j < 0) {
                    k.c().w().a("Invalid time querying timed out conditional properties", w3.a(str), Long.valueOf(j));
                    a2 = Collections.emptyList();
                } else {
                    a2 = k.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzy zzyVar : a2) {
                    if (zzyVar != null) {
                        this.f4909i.c().B().a("User property timed out", zzyVar.f10227a, this.f4909i.w().c(zzyVar.f10229c.f10212b), zzyVar.f10229c.zza());
                        if (zzyVar.f10233g != null) {
                            b(new zzaq(zzyVar.f10233g, j), zzmVar);
                        }
                        k().e(str, zzyVar.f10229c.f10212b);
                    }
                }
                c k2 = k();
                c.c.a.b.c.o.r.b(str);
                k2.g();
                k2.q();
                if (j < 0) {
                    k2.c().w().a("Invalid time querying expired conditional properties", w3.a(str), Long.valueOf(j));
                    a3 = Collections.emptyList();
                } else {
                    a3 = k2.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(a3.size());
                for (zzy zzyVar2 : a3) {
                    if (zzyVar2 != null) {
                        this.f4909i.c().B().a("User property expired", zzyVar2.f10227a, this.f4909i.w().c(zzyVar2.f10229c.f10212b), zzyVar2.f10229c.zza());
                        k().b(str, zzyVar2.f10229c.f10212b);
                        if (zzyVar2.k != null) {
                            arrayList.add(zzyVar2.k);
                        }
                        k().e(str, zzyVar2.f10229c.f10212b);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    b(new zzaq((zzaq) obj, j), zzmVar);
                }
                c k3 = k();
                String str2 = zzaqVar2.f10207a;
                c.c.a.b.c.o.r.b(str);
                c.c.a.b.c.o.r.b(str2);
                k3.g();
                k3.q();
                if (j < 0) {
                    k3.c().w().a("Invalid time querying triggered conditional properties", w3.a(str), k3.i().a(str2), Long.valueOf(j));
                    a4 = Collections.emptyList();
                } else {
                    a4 = k3.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(a4.size());
                for (zzy zzyVar3 : a4) {
                    if (zzyVar3 != null) {
                        zzkn zzknVar = zzyVar3.f10229c;
                        t9 t9Var = new t9(zzyVar3.f10227a, zzyVar3.f10228b, zzknVar.f10212b, j, zzknVar.zza());
                        if (k().a(t9Var)) {
                            this.f4909i.c().B().a("User property triggered", zzyVar3.f10227a, this.f4909i.w().c(t9Var.f5106c), t9Var.f5108e);
                        } else {
                            this.f4909i.c().t().a("Too many active user properties, ignoring", w3.a(zzyVar3.f10227a), this.f4909i.w().c(t9Var.f5106c), t9Var.f5108e);
                        }
                        if (zzyVar3.f10235i != null) {
                            arrayList2.add(zzyVar3.f10235i);
                        }
                        zzyVar3.f10229c = new zzkn(t9Var);
                        zzyVar3.f10231e = true;
                        k().a(zzyVar3);
                    }
                }
                b(zzaqVar2, zzmVar);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    b(new zzaq((zzaq) obj2, j), zzmVar);
                }
                k().t();
            } finally {
                k().z();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x059c A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0673 A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x081a A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x082a A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0844 A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0258 A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0266 A[Catch: all -> 0x0f3e, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0f26 A[Catch: all -> 0x0f3e, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0251 A[Catch: all -> 0x0f3e, TRY_ENTER, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0f3a A[Catch: all -> 0x0f3e, TRY_ENTER, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:584:? A[Catch: all -> 0x0f3e, SYNTHETIC, TRY_LEAVE, TryCatch #10 {all -> 0x0f3e, blocks: (B:3:0x000d, B:20:0x0086, B:21:0x0254, B:23:0x0258, B:28:0x0266, B:29:0x028c, B:32:0x02a4, B:35:0x02ca, B:37:0x0301, B:42:0x0317, B:44:0x0321, B:47:0x0895, B:49:0x0347, B:52:0x035f, B:69:0x03c2, B:72:0x03cc, B:74:0x03da, B:76:0x0425, B:77:0x03f8, B:79:0x0407, B:87:0x0432, B:89:0x0469, B:90:0x0498, B:92:0x04cc, B:93:0x04d2, B:96:0x04de, B:98:0x0513, B:99:0x0530, B:101:0x0536, B:103:0x0544, B:105:0x0558, B:106:0x054d, B:114:0x055f, B:116:0x0565, B:117:0x0581, B:119:0x059c, B:120:0x05a8, B:123:0x05b2, B:127:0x05d5, B:128:0x05c4, B:136:0x05db, B:138:0x05e7, B:140:0x05f3, B:145:0x0642, B:146:0x065f, B:148:0x0673, B:150:0x0680, B:153:0x0693, B:155:0x06a5, B:157:0x06b3, B:161:0x081a, B:163:0x0824, B:165:0x082a, B:166:0x0844, B:168:0x0858, B:169:0x0872, B:170:0x087b, B:176:0x06d9, B:178:0x06e9, B:181:0x06fe, B:183:0x0710, B:185:0x071e, B:188:0x0731, B:190:0x0749, B:192:0x0755, B:195:0x0768, B:197:0x077c, B:199:0x07c7, B:200:0x07ce, B:202:0x07d4, B:204:0x07df, B:205:0x07e6, B:207:0x07ec, B:209:0x07f7, B:210:0x0808, B:214:0x0614, B:218:0x0628, B:220:0x062e, B:222:0x0639, B:234:0x0381, B:237:0x038b, B:240:0x0395, B:249:0x08af, B:251:0x08bd, B:253:0x08c6, B:255:0x08f8, B:256:0x08ce, B:258:0x08d7, B:260:0x08dd, B:262:0x08e9, B:264:0x08f3, B:272:0x08ff, B:273:0x090b, B:275:0x0911, B:281:0x092a, B:282:0x0935, B:286:0x0942, B:287:0x0969, B:289:0x0988, B:291:0x0996, B:293:0x099c, B:295:0x09a6, B:296:0x09d5, B:298:0x09db, B:302:0x09e9, B:304:0x09f4, B:300:0x09ee, B:307:0x09f7, B:309:0x0a09, B:310:0x0a0c, B:382:0x0a7b, B:384:0x0a97, B:385:0x0aa8, B:387:0x0aac, B:389:0x0ab8, B:390:0x0ac1, B:392:0x0ac5, B:394:0x0acd, B:395:0x0adc, B:396:0x0ae7, B:403:0x0b27, B:404:0x0b2f, B:406:0x0b35, B:410:0x0b47, B:412:0x0b4b, B:416:0x0b81, B:418:0x0b97, B:463:0x0b59, B:465:0x0b5d, B:467:0x0b67, B:469:0x0b6b, B:314:0x0d83, B:316:0x0d95, B:317:0x0d98, B:319:0x0daa, B:320:0x0e1f, B:322:0x0e25, B:324:0x0e3a, B:327:0x0e41, B:328:0x0e74, B:329:0x0e49, B:331:0x0e55, B:332:0x0e5b, B:333:0x0e85, B:334:0x0e9c, B:337:0x0ea4, B:339:0x0ea9, B:342:0x0eb9, B:344:0x0ed3, B:345:0x0eec, B:347:0x0ef4, B:348:0x0f16, B:355:0x0f05, B:356:0x0dc4, B:358:0x0dca, B:360:0x0dd4, B:361:0x0ddb, B:366:0x0deb, B:367:0x0df2, B:369:0x0e11, B:370:0x0e18, B:371:0x0e15, B:372:0x0def, B:374:0x0dd8, B:487:0x0947, B:489:0x094d, B:495:0x0f26, B:506:0x0124, B:520:0x01bb, B:536:0x01f3, B:532:0x0212, B:547:0x022b, B:553:0x0251, B:582:0x0f3a, B:583:0x0f3d, B:571:0x00dd, B:509:0x012d), top: B:2:0x000d, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03ad  */
    /* JADX WARN: Type inference failed for: r5v0, types: [c.c.a.b.g.b.k9] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r44, long r45) {
        /*
            Method dump skipped, instructions count: 3914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.a(java.lang.String, long):boolean");
    }

    public final void b(x0.a aVar, x0.a aVar2) {
        c.c.a.b.c.o.r.a("_e".equals(aVar.l()));
        n();
        c.c.a.b.f.e.z0 b2 = p9.b((c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) aVar.F()), "_et");
        if (!b2.q() || b2.r() <= 0) {
            return;
        }
        long r = b2.r();
        n();
        c.c.a.b.f.e.z0 b3 = p9.b((c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) aVar2.F()), "_et");
        if (b3 != null && b3.r() > 0) {
            r += b3.r();
        }
        n().a(aVar2, "_et", Long.valueOf(r));
        n().a(aVar, "_fr", (Object) 1L);
    }

    public final Boolean b(d5 d5Var) {
        try {
            if (d5Var.v() != -2147483648L) {
                if (d5Var.v() == c.c.a.b.c.t.c.b(this.f4909i.d()).b(d5Var.l(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = c.c.a.b.c.t.c.b(this.f4909i.d()).b(d5Var.l(), 0).versionName;
                if (d5Var.u() != null && d5Var.u().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void b(zzkn zzknVar, zzm zzmVar) {
        x();
        q();
        if (e(zzmVar)) {
            if (!zzmVar.f10225h) {
                c(zzmVar);
                return;
            }
            if ("_npa".equals(zzknVar.f10212b) && zzmVar.t != null) {
                this.f4909i.c().A().a("Falling back to manifest metadata value for ad personalization");
                a(new zzkn("_npa", this.f4909i.b().a(), Long.valueOf(zzmVar.t.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                return;
            }
            this.f4909i.c().A().a("Removing user property", this.f4909i.w().c(zzknVar.f10212b));
            k().y();
            try {
                c(zzmVar);
                k().b(zzmVar.f10218a, zzknVar.f10212b);
                k().t();
                this.f4909i.c().A().a("User property removed", this.f4909i.w().c(zzknVar.f10212b));
            } finally {
                k().z();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x048c A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cb A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0205 A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x022e A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024e A[Catch: all -> 0x04b8, TRY_LEAVE, TryCatch #1 {all -> 0x04b8, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0262, B:69:0x0285, B:70:0x0293, B:72:0x02c6, B:73:0x02ce, B:75:0x02d2, B:76:0x02d5, B:78:0x02f6, B:82:0x03d2, B:83:0x03d5, B:84:0x0446, B:86:0x0456, B:88:0x0470, B:89:0x0477, B:90:0x04a9, B:95:0x030f, B:97:0x033a, B:99:0x0342, B:101:0x034c, B:105:0x0360, B:107:0x036e, B:110:0x0379, B:112:0x038b, B:114:0x03b6, B:116:0x03bc, B:117:0x03c1, B:119:0x03c7, B:122:0x039e, B:124:0x0366, B:129:0x0322, B:133:0x03ed, B:135:0x0423, B:136:0x042b, B:138:0x042f, B:139:0x0432, B:141:0x048c, B:143:0x0490, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            Method dump skipped, instructions count: 1219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.b(com.google.android.gms.measurement.internal.zzm):void");
    }

    public final void b(zzy zzyVar) {
        zzm a2 = a(zzyVar.f10227a);
        if (a2 != null) {
            b(zzyVar, a2);
        }
    }

    public final void b(zzy zzyVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        c.c.a.b.c.o.r.b(zzyVar.f10227a);
        c.c.a.b.c.o.r.a(zzyVar.f10229c);
        c.c.a.b.c.o.r.b(zzyVar.f10229c.f10212b);
        x();
        q();
        if (e(zzmVar)) {
            if (!zzmVar.f10225h) {
                c(zzmVar);
                return;
            }
            k().y();
            try {
                c(zzmVar);
                zzy d2 = k().d(zzyVar.f10227a, zzyVar.f10229c.f10212b);
                if (d2 != null) {
                    this.f4909i.c().A().a("Removing conditional user property", zzyVar.f10227a, this.f4909i.w().c(zzyVar.f10229c.f10212b));
                    k().e(zzyVar.f10227a, zzyVar.f10229c.f10212b);
                    if (d2.f10231e) {
                        k().b(zzyVar.f10227a, zzyVar.f10229c.f10212b);
                    }
                    if (zzyVar.k != null) {
                        b(this.f4909i.v().a(zzyVar.f10227a, zzyVar.k.f10207a, zzyVar.k.f10208b != null ? zzyVar.k.f10208b.zzb() : null, d2.f10228b, zzyVar.k.f10210d, true, false), zzmVar);
                    }
                } else {
                    this.f4909i.c().w().a("Conditional user property doesn't exist", w3.a(zzyVar.f10227a), this.f4909i.w().c(zzyVar.f10229c.f10212b));
                }
                k().t();
            } finally {
                k().z();
            }
        }
    }

    public static void a(b1.a aVar) {
        aVar.b(RecyclerView.FOREVER_NS);
        aVar.c(Long.MIN_VALUE);
        for (int i2 = 0; i2 < aVar.j(); i2++) {
            c.c.a.b.f.e.x0 b2 = aVar.b(i2);
            if (b2.q() < aVar.n()) {
                aVar.b(b2.q());
            }
            if (b2.q() > aVar.o()) {
                aVar.c(b2.q());
            }
        }
    }

    public final void a(b1.a aVar, long j, boolean z) {
        t9 t9Var;
        String str = z ? "_se" : "_lte";
        t9 c2 = k().c(aVar.r(), str);
        if (c2 != null && c2.f5108e != null) {
            t9Var = new t9(aVar.r(), "auto", str, this.f4909i.b().a(), Long.valueOf(((Long) c2.f5108e).longValue() + j));
        } else {
            t9Var = new t9(aVar.r(), "auto", str, this.f4909i.b().a(), Long.valueOf(j));
        }
        f1.a y = c.c.a.b.f.e.f1.y();
        y.a(str);
        y.a(this.f4909i.b().a());
        y.b(((Long) t9Var.f5108e).longValue());
        c.c.a.b.f.e.f1 f1Var = (c.c.a.b.f.e.f1) ((c.c.a.b.f.e.s4) y.F());
        boolean z2 = false;
        int a2 = p9.a(aVar, str);
        if (a2 >= 0) {
            aVar.a(a2, f1Var);
            z2 = true;
        }
        if (!z2) {
            aVar.a(f1Var);
        }
        if (j > 0) {
            k().a(t9Var);
            this.f4909i.c().B().a("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", t9Var.f5108e);
        }
    }

    public final boolean a(x0.a aVar, x0.a aVar2) {
        c.c.a.b.c.o.r.a("_e".equals(aVar.l()));
        n();
        c.c.a.b.f.e.z0 b2 = p9.b((c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) aVar.F()), "_sc");
        String p = b2 == null ? null : b2.p();
        n();
        c.c.a.b.f.e.z0 b3 = p9.b((c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) aVar2.F()), "_pc");
        String p2 = b3 != null ? b3.p() : null;
        if (p2 == null || !p2.equals(p)) {
            return false;
        }
        b(aVar, aVar2);
        return true;
    }

    public static void a(x0.a aVar, String str) {
        List<c.c.a.b.f.e.z0> zza = aVar.zza();
        for (int i2 = 0; i2 < zza.size(); i2++) {
            if (str.equals(zza.get(i2).n())) {
                aVar.b(i2);
                return;
            }
        }
    }

    public static void a(x0.a aVar, int i2, String str) {
        List<c.c.a.b.f.e.z0> zza = aVar.zza();
        for (int i3 = 0; i3 < zza.size(); i3++) {
            if ("_err".equals(zza.get(i3).n())) {
                return;
            }
        }
        z0.a B = c.c.a.b.f.e.z0.B();
        B.a("_err");
        B.a(Long.valueOf(i2).longValue());
        c.c.a.b.f.e.z0 z0Var = (c.c.a.b.f.e.z0) ((c.c.a.b.f.e.s4) B.F());
        z0.a B2 = c.c.a.b.f.e.z0.B();
        B2.a("_ev");
        B2.b(str);
        c.c.a.b.f.e.z0 z0Var2 = (c.c.a.b.f.e.z0) ((c.c.a.b.f.e.s4) B2.F());
        aVar.a(z0Var);
        aVar.a(z0Var2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0158, code lost:
    
        r8.f4909i.p().f4829g.a(r8.f4909i.b().a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.a(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    public final void a(d5 d5Var) {
        a.e.a aVar;
        x();
        if (oa.a() && this.f4909i.o().e(d5Var.l(), r.p0)) {
            if (TextUtils.isEmpty(d5Var.n()) && TextUtils.isEmpty(d5Var.p()) && TextUtils.isEmpty(d5Var.o())) {
                a(d5Var.l(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(d5Var.n()) && TextUtils.isEmpty(d5Var.o())) {
            a(d5Var.l(), 204, null, null, null);
            return;
        }
        String a2 = this.f4909i.o().a(d5Var);
        try {
            URL url = new URL(a2);
            this.f4909i.c().B().a("Fetching remote configuration", d5Var.l());
            c.c.a.b.f.e.r0 a3 = i().a(d5Var.l());
            String b2 = i().b(d5Var.l());
            if (a3 == null || TextUtils.isEmpty(b2)) {
                aVar = null;
            } else {
                a.e.a aVar2 = new a.e.a();
                aVar2.put("If-Modified-Since", b2);
                aVar = aVar2;
            }
            this.p = true;
            e4 j = j();
            String l = d5Var.l();
            m9 m9Var = new m9(this);
            j.g();
            j.q();
            c.c.a.b.c.o.r.a(url);
            c.c.a.b.c.o.r.a(m9Var);
            j.a().b(new i4(j, l, url, null, aVar, m9Var));
        } catch (MalformedURLException unused) {
            this.f4909i.c().t().a("Failed to parse config URL. Not fetching. appId", w3.a(d5Var.l()), a2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r6.f4909i.p().f4829g.a(r6.f4909i.b().a());
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void a(Runnable runnable) {
        x();
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(runnable);
    }

    public final int a(FileChannel fileChannel) {
        x();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    return allocate.getInt();
                }
                if (read != -1) {
                    this.f4909i.c().w().a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            } catch (IOException e2) {
                this.f4909i.c().t().a("Failed to read from channel", e2);
                return 0;
            }
        }
        this.f4909i.c().t().a("Bad channel to read from");
        return 0;
    }

    public final boolean a(int i2, FileChannel fileChannel) {
        x();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.flip();
            try {
                fileChannel.truncate(0L);
                if (this.f4909i.o().a(r.A0) && Build.VERSION.SDK_INT <= 19) {
                    fileChannel.position(0L);
                }
                fileChannel.write(allocate);
                fileChannel.force(true);
                if (fileChannel.size() != 4) {
                    this.f4909i.c().t().a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                }
                return true;
            } catch (IOException e2) {
                this.f4909i.c().t().a("Failed to write to channel", e2);
                return false;
            }
        }
        this.f4909i.c().t().a("Bad channel to read from");
        return false;
    }

    public final void a(zzm zzmVar) {
        if (this.u != null) {
            ArrayList arrayList = new ArrayList();
            this.v = arrayList;
            arrayList.addAll(this.u);
        }
        c k = k();
        String str = zzmVar.f10218a;
        c.c.a.b.c.o.r.b(str);
        k.g();
        k.q();
        try {
            SQLiteDatabase u = k.u();
            String[] strArr = {str};
            int delete = u.delete("apps", "app_id=?", strArr) + 0 + u.delete("events", "app_id=?", strArr) + u.delete("user_attributes", "app_id=?", strArr) + u.delete("conditional_properties", "app_id=?", strArr) + u.delete("raw_events", "app_id=?", strArr) + u.delete("raw_events_metadata", "app_id=?", strArr) + u.delete("queue", "app_id=?", strArr) + u.delete("audience_filter_values", "app_id=?", strArr) + u.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                k.c().B().a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            k.c().t().a("Error resetting analytics data. appId, error", w3.a(str), e2);
        }
        if (zzmVar.f10225h) {
            b(zzmVar);
        }
    }

    public final void a(zzkn zzknVar, zzm zzmVar) {
        x();
        q();
        if (e(zzmVar)) {
            if (!zzmVar.f10225h) {
                c(zzmVar);
                return;
            }
            int b2 = this.f4909i.v().b(zzknVar.f10212b);
            if (b2 != 0) {
                this.f4909i.v();
                String a2 = s9.a(zzknVar.f10212b, 24, true);
                String str = zzknVar.f10212b;
                this.f4909i.v().a(zzmVar.f10218a, b2, "_ev", a2, str != null ? str.length() : 0);
                return;
            }
            int b3 = this.f4909i.v().b(zzknVar.f10212b, zzknVar.zza());
            if (b3 != 0) {
                this.f4909i.v();
                String a3 = s9.a(zzknVar.f10212b, 24, true);
                Object zza = zzknVar.zza();
                this.f4909i.v().a(zzmVar.f10218a, b3, "_ev", a3, (zza == null || !((zza instanceof String) || (zza instanceof CharSequence))) ? 0 : String.valueOf(zza).length());
                return;
            }
            Object c2 = this.f4909i.v().c(zzknVar.f10212b, zzknVar.zza());
            if (c2 == null) {
                return;
            }
            if ("_sid".equals(zzknVar.f10212b)) {
                long j = zzknVar.f10213c;
                String str2 = zzknVar.f10216f;
                long j2 = 0;
                t9 c3 = k().c(zzmVar.f10218a, "_sno");
                if (c3 != null) {
                    Object obj = c3.f5108e;
                    if (obj instanceof Long) {
                        j2 = ((Long) obj).longValue();
                        a(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
                    }
                }
                if (c3 != null) {
                    this.f4909i.c().w().a("Retrieved last session number from database does not contain a valid (long) value", c3.f5108e);
                }
                m a4 = k().a(zzmVar.f10218a, "_s");
                if (a4 != null) {
                    j2 = a4.f4916c;
                    this.f4909i.c().B().a("Backfill the session number. Last used session number", Long.valueOf(j2));
                }
                a(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
            }
            t9 t9Var = new t9(zzmVar.f10218a, zzknVar.f10216f, zzknVar.f10212b, zzknVar.f10213c, c2);
            this.f4909i.c().B().a("Setting user property", this.f4909i.w().c(t9Var.f5106c), c2);
            k().y();
            try {
                c(zzmVar);
                boolean a5 = k().a(t9Var);
                k().t();
                if (!a5) {
                    this.f4909i.c().t().a("Too many unique user properties are set. Ignoring user property", this.f4909i.w().c(t9Var.f5106c), t9Var.f5108e);
                    this.f4909i.v().a(zzmVar.f10218a, 9, (String) null, (String) null, 0);
                }
            } finally {
                k().z();
            }
        }
    }

    public final void a(i9 i9Var) {
        this.n++;
    }

    public final zzm a(String str) {
        d5 b2 = k().b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.u())) {
            Boolean b3 = b(b2);
            if (b3 != null && !b3.booleanValue()) {
                this.f4909i.c().t().a("App version does not match; dropping. appId", w3.a(str));
                return null;
            }
            return new zzm(str, b2.n(), b2.u(), b2.v(), b2.w(), b2.x(), b2.y(), (String) null, b2.A(), false, b2.r(), b2.f(), 0L, 0, b2.g(), b2.h(), false, b2.o(), b2.i(), b2.z(), b2.j(), (oa.a() && this.f4909i.o().e(str, r.p0)) ? b2.p() : null);
        }
        this.f4909i.c().A().a("No app data available; dropping", str);
        return null;
    }

    public final void a(zzy zzyVar) {
        zzm a2 = a(zzyVar.f10227a);
        if (a2 != null) {
            a(zzyVar, a2);
        }
    }

    public final void a(zzy zzyVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        c.c.a.b.c.o.r.b(zzyVar.f10227a);
        c.c.a.b.c.o.r.a(zzyVar.f10228b);
        c.c.a.b.c.o.r.a(zzyVar.f10229c);
        c.c.a.b.c.o.r.b(zzyVar.f10229c.f10212b);
        x();
        q();
        if (e(zzmVar)) {
            if (!zzmVar.f10225h) {
                c(zzmVar);
                return;
            }
            zzy zzyVar2 = new zzy(zzyVar);
            boolean z = false;
            zzyVar2.f10231e = false;
            k().y();
            try {
                zzy d2 = k().d(zzyVar2.f10227a, zzyVar2.f10229c.f10212b);
                if (d2 != null && !d2.f10228b.equals(zzyVar2.f10228b)) {
                    this.f4909i.c().w().a("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f4909i.w().c(zzyVar2.f10229c.f10212b), zzyVar2.f10228b, d2.f10228b);
                }
                if (d2 != null && d2.f10231e) {
                    zzyVar2.f10228b = d2.f10228b;
                    zzyVar2.f10230d = d2.f10230d;
                    zzyVar2.f10234h = d2.f10234h;
                    zzyVar2.f10232f = d2.f10232f;
                    zzyVar2.f10235i = d2.f10235i;
                    zzyVar2.f10231e = d2.f10231e;
                    zzyVar2.f10229c = new zzkn(zzyVar2.f10229c.f10212b, d2.f10229c.f10213c, zzyVar2.f10229c.zza(), d2.f10229c.f10216f);
                } else if (TextUtils.isEmpty(zzyVar2.f10232f)) {
                    zzyVar2.f10229c = new zzkn(zzyVar2.f10229c.f10212b, zzyVar2.f10230d, zzyVar2.f10229c.zza(), zzyVar2.f10229c.f10216f);
                    zzyVar2.f10231e = true;
                    z = true;
                }
                if (zzyVar2.f10231e) {
                    zzkn zzknVar = zzyVar2.f10229c;
                    t9 t9Var = new t9(zzyVar2.f10227a, zzyVar2.f10228b, zzknVar.f10212b, zzknVar.f10213c, zzknVar.zza());
                    if (k().a(t9Var)) {
                        this.f4909i.c().A().a("User property updated immediately", zzyVar2.f10227a, this.f4909i.w().c(t9Var.f5106c), t9Var.f5108e);
                    } else {
                        this.f4909i.c().t().a("(2)Too many active user properties, ignoring", w3.a(zzyVar2.f10227a), this.f4909i.w().c(t9Var.f5106c), t9Var.f5108e);
                    }
                    if (z && zzyVar2.f10235i != null) {
                        b(new zzaq(zzyVar2.f10235i, zzyVar2.f10230d), zzmVar);
                    }
                }
                if (k().a(zzyVar2)) {
                    this.f4909i.c().A().a("Conditional property added", zzyVar2.f10227a, this.f4909i.w().c(zzyVar2.f10229c.f10212b), zzyVar2.f10229c.zza());
                } else {
                    this.f4909i.c().t().a("Too many conditional properties, ignoring", w3.a(zzyVar2.f10227a), this.f4909i.w().c(zzyVar2.f10229c.f10212b), zzyVar2.f10229c.zza());
                }
                k().t();
            } finally {
                k().z();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c.c.a.b.g.b.d5 a(com.google.android.gms.measurement.internal.zzm r9, c.c.a.b.g.b.d5 r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.l9.a(com.google.android.gms.measurement.internal.zzm, c.c.a.b.g.b.d5, java.lang.String):c.c.a.b.g.b.d5");
    }

    public final void a(boolean z) {
        A();
    }
}
