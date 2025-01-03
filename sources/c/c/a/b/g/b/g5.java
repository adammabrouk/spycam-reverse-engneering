package c.c.a.b.g.b;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class g5 extends r3 {

    /* renamed from: a, reason: collision with root package name */
    public final l9 f4739a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f4740b;

    /* renamed from: c, reason: collision with root package name */
    public String f4741c;

    public g5(l9 l9Var) {
        this(l9Var, null);
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzm zzmVar) {
        b(zzmVar, false);
        a(new f5(this, zzmVar));
    }

    public final zzaq b(zzaq zzaqVar, zzm zzmVar) {
        zzal zzalVar;
        boolean z = false;
        if ("_cmp".equals(zzaqVar.f10207a) && (zzalVar = zzaqVar.f10208b) != null && zzalVar.zza() != 0) {
            String e2 = zzaqVar.f10208b.e("_cis");
            if (!TextUtils.isEmpty(e2) && (("referrer broadcast".equals(e2) || "referrer API".equals(e2)) && this.f4739a.h().e(zzmVar.f10218a, r.S))) {
                z = true;
            }
        }
        if (!z) {
            return zzaqVar;
        }
        this.f4739a.c().z().a("Event has been filtered ", zzaqVar.toString());
        return new zzaq("_cmpx", zzaqVar.f10208b, zzaqVar.f10209c, zzaqVar.f10210d);
    }

    @Override // c.c.a.b.g.b.o3
    public final void c(zzm zzmVar) {
        a(zzmVar.f10218a, false);
        a(new l5(this, zzmVar));
    }

    @Override // c.c.a.b.g.b.o3
    public final void d(zzm zzmVar) {
        b(zzmVar, false);
        a(new r5(this, zzmVar));
    }

    public g5(l9 l9Var, String str) {
        c.c.a.b.c.o.r.a(l9Var);
        this.f4739a = l9Var;
        this.f4741c = null;
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzaq zzaqVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzaqVar);
        b(zzmVar, false);
        a(new o5(this, zzaqVar, zzmVar));
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzaq zzaqVar, String str, String str2) {
        c.c.a.b.c.o.r.a(zzaqVar);
        c.c.a.b.c.o.r.b(str);
        a(str, true);
        a(new n5(this, zzaqVar, str));
    }

    @Override // c.c.a.b.g.b.o3
    public final byte[] a(zzaq zzaqVar, String str) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(zzaqVar);
        a(str, true);
        this.f4739a.c().A().a("Log and bundle. event", this.f4739a.o().a(zzaqVar.f10207a));
        long c2 = this.f4739a.b().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f4739a.a().b(new q5(this, zzaqVar, str)).get();
            if (bArr == null) {
                this.f4739a.c().t().a("Log and bundle returned null. appId", w3.a(str));
                bArr = new byte[0];
            }
            this.f4739a.c().A().a("Log and bundle processed. event, size, time_ms", this.f4739a.o().a(zzaqVar.f10207a), Integer.valueOf(bArr.length), Long.valueOf((this.f4739a.b().c() / 1000000) - c2));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to log and bundle. appId, event, error", w3.a(str), this.f4739a.o().a(zzaqVar.f10207a), e2);
            return null;
        }
    }

    public final void b(zzm zzmVar, boolean z) {
        c.c.a.b.c.o.r.a(zzmVar);
        a(zzmVar.f10218a, false);
        this.f4739a.p().a(zzmVar.f10219b, zzmVar.r, zzmVar.w);
    }

    @Override // c.c.a.b.g.b.o3
    public final String b(zzm zzmVar) {
        b(zzmVar, false);
        return this.f4739a.d(zzmVar);
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzy> b(String str, String str2, String str3) {
        a(str, true);
        try {
            return (List) this.f4739a.a().a(new m5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzkn zzknVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzknVar);
        b(zzmVar, false);
        a(new p5(this, zzknVar, zzmVar));
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(zzm zzmVar, boolean z) {
        b(zzmVar, false);
        try {
            List<t9> list = (List) this.f4739a.a().a(new s5(this, zzmVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (t9 t9Var : list) {
                if (z || !s9.i(t9Var.f5106c)) {
                    arrayList.add(new zzkn(t9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to get user properties. appId", w3.a(zzmVar.f10218a), e2);
            return null;
        }
    }

    public final void a(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f4740b == null) {
                        if (!"com.google.android.gms".equals(this.f4741c) && !c.c.a.b.c.s.q.a(this.f4739a.d(), Binder.getCallingUid()) && !c.c.a.b.c.i.a(this.f4739a.d()).a(Binder.getCallingUid())) {
                            z2 = false;
                            this.f4740b = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.f4740b = Boolean.valueOf(z2);
                    }
                    if (this.f4740b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f4739a.c().t().a("Measurement Service called with invalid calling package. appId", w3.a(str));
                    throw e2;
                }
            }
            if (this.f4741c == null && c.c.a.b.c.h.a(this.f4739a.d(), Binder.getCallingUid(), str)) {
                this.f4741c = str;
            }
            if (str.equals(this.f4741c)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        this.f4739a.c().t().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(long j, String str, String str2, String str3) {
        a(new u5(this, str2, str3, str, j));
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzy zzyVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        c.c.a.b.c.o.r.a(zzyVar.f10229c);
        b(zzmVar, false);
        zzy zzyVar2 = new zzy(zzyVar);
        zzyVar2.f10227a = zzmVar.f10218a;
        a(new t5(this, zzyVar2, zzmVar));
    }

    @Override // c.c.a.b.g.b.o3
    public final void a(zzy zzyVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        c.c.a.b.c.o.r.a(zzyVar.f10229c);
        a(zzyVar.f10227a, true);
        a(new i5(this, new zzy(zzyVar)));
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(String str, String str2, boolean z, zzm zzmVar) {
        b(zzmVar, false);
        try {
            List<t9> list = (List) this.f4739a.a().a(new h5(this, zzmVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (t9 t9Var : list) {
                if (z || !s9.i(t9Var.f5106c)) {
                    arrayList.add(new zzkn(t9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to query user properties. appId", w3.a(zzmVar.f10218a), e2);
            return Collections.emptyList();
        }
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzkn> a(String str, String str2, String str3, boolean z) {
        a(str, true);
        try {
            List<t9> list = (List) this.f4739a.a().a(new k5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (t9 t9Var : list) {
                if (z || !s9.i(t9Var.f5106c)) {
                    arrayList.add(new zzkn(t9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to get user properties as. appId", w3.a(str), e2);
            return Collections.emptyList();
        }
    }

    @Override // c.c.a.b.g.b.o3
    public final List<zzy> a(String str, String str2, zzm zzmVar) {
        b(zzmVar, false);
        try {
            return (List) this.f4739a.a().a(new j5(this, zzmVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f4739a.c().t().a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final void a(Runnable runnable) {
        c.c.a.b.c.o.r.a(runnable);
        if (this.f4739a.a().s()) {
            runnable.run();
        } else {
            this.f4739a.a().a(runnable);
        }
    }
}
