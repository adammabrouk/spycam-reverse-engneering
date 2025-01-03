package c.c.a.b.c.l.m;

import android.util.Log;
import c.c.a.b.c.l.a;
import c.c.a.b.c.l.m.b;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f3894a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.c f3895b;

    public r(b.c cVar, ConnectionResult connectionResult) {
        this.f3895b = cVar;
        this.f3894a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var;
        a.f fVar;
        e0 e0Var2;
        a.f fVar2;
        if (!this.f3894a.y()) {
            Map map = b.this.f3848h;
            e0Var = this.f3895b.f3862b;
            ((b.a) map.get(e0Var)).a(this.f3894a);
            return;
        }
        b.c.a(this.f3895b, true);
        fVar = this.f3895b.f3861a;
        if (fVar.j()) {
            this.f3895b.a();
            return;
        }
        try {
            fVar2 = this.f3895b.f3861a;
            fVar2.a(null, Collections.emptySet());
        } catch (SecurityException e2) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
            Map map2 = b.this.f3848h;
            e0Var2 = this.f3895b.f3862b;
            ((b.a) map2.get(e0Var2)).a(new ConnectionResult(10));
        }
    }
}
