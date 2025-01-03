package c.c.a.b.g.b;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import c.c.a.b.f.e.x0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    public c.c.a.b.f.e.x0 f4615a;

    /* renamed from: b, reason: collision with root package name */
    public Long f4616b;

    /* renamed from: c, reason: collision with root package name */
    public long f4617c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ aa f4618d;

    public ba(aa aaVar) {
        this.f4618d = aaVar;
    }

    public final c.c.a.b.f.e.x0 a(String str, c.c.a.b.f.e.x0 x0Var) {
        Object obj;
        String o = x0Var.o();
        List<c.c.a.b.f.e.z0> zza = x0Var.zza();
        Long l = (Long) this.f4618d.m().a(x0Var, "_eid");
        boolean z = l != null;
        if (z && o.equals("_ep")) {
            o = (String) this.f4618d.m().a(x0Var, "_en");
            if (TextUtils.isEmpty(o)) {
                this.f4618d.c().u().a("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.f4615a == null || this.f4616b == null || l.longValue() != this.f4616b.longValue()) {
                Pair<c.c.a.b.f.e.x0, Long> a2 = this.f4618d.n().a(str, l);
                if (a2 == null || (obj = a2.first) == null) {
                    this.f4618d.c().u().a("Extra parameter without existing main event. eventName, eventId", o, l);
                    return null;
                }
                this.f4615a = (c.c.a.b.f.e.x0) obj;
                this.f4617c = ((Long) a2.second).longValue();
                this.f4616b = (Long) this.f4618d.m().a(this.f4615a, "_eid");
            }
            long j = this.f4617c - 1;
            this.f4617c = j;
            if (j <= 0) {
                c n = this.f4618d.n();
                n.g();
                n.c().B().a("Clearing complex main event info. appId", str);
                try {
                    n.u().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e2) {
                    n.c().t().a("Error clearing complex main event", e2);
                }
            } else {
                this.f4618d.n().a(str, l, this.f4617c, this.f4615a);
            }
            ArrayList arrayList = new ArrayList();
            for (c.c.a.b.f.e.z0 z0Var : this.f4615a.zza()) {
                this.f4618d.m();
                if (p9.b(x0Var, z0Var.n()) == null) {
                    arrayList.add(z0Var);
                }
            }
            if (arrayList.isEmpty()) {
                this.f4618d.c().u().a("No unique parameters in main event. eventName", o);
            } else {
                arrayList.addAll(zza);
                zza = arrayList;
            }
        } else if (z) {
            this.f4616b = l;
            this.f4615a = x0Var;
            Object a3 = this.f4618d.m().a(x0Var, "_epc");
            long longValue = ((Long) (a3 != null ? a3 : 0L)).longValue();
            this.f4617c = longValue;
            if (longValue <= 0) {
                this.f4618d.c().u().a("Complex event with zero extra param count. eventName", o);
            } else {
                this.f4618d.n().a(str, l, this.f4617c, x0Var);
            }
        }
        x0.a j2 = x0Var.j();
        j2.a(o);
        j2.k();
        j2.a(zza);
        return (c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) j2.F());
    }

    public /* synthetic */ ba(aa aaVar, z9 z9Var) {
        this(aaVar);
    }
}
