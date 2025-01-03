package c.c.a.b.c.l;

import android.text.TextUtils;
import c.c.a.b.c.l.a;
import c.c.a.b.c.l.m.e0;
import c.c.a.b.c.o.r;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c extends Exception {
    public final a.e.a<e0<?>, ConnectionResult> zaay;

    public c(a.e.a<e0<?>, ConnectionResult> aVar) {
        this.zaay = aVar;
    }

    public ConnectionResult getConnectionResult(e<? extends a.d> eVar) {
        e0<? extends a.d> c2 = eVar.c();
        r.a(this.zaay.get(c2) != null, "The given API was not part of the availability request.");
        return this.zaay.get(c2);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (e0<?> e0Var : this.zaay.keySet()) {
            ConnectionResult connectionResult = this.zaay.get(e0Var);
            if (connectionResult.y()) {
                z = false;
            }
            String a2 = e0Var.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final a.e.a<e0<?>, ConnectionResult> zaj() {
        return this.zaay;
    }
}
