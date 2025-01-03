package c.c.a.b.f.e;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import c.c.a.b.f.e.c;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class u extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c.c.a.b.g.b.f6 f4450e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4451f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(c cVar, c.c.a.b.g.b.f6 f6Var) {
        super(cVar);
        this.f4451f = cVar;
        this.f4450e = f6Var;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        List list;
        Pair pair;
        xc xcVar;
        List list2;
        String str;
        List list3;
        List list4;
        int i2 = 0;
        while (true) {
            list = this.f4451f.f4103d;
            if (i2 >= list.size()) {
                pair = null;
                break;
            }
            c.c.a.b.g.b.f6 f6Var = this.f4450e;
            list3 = this.f4451f.f4103d;
            if (f6Var.equals(((Pair) list3.get(i2)).first)) {
                list4 = this.f4451f.f4103d;
                pair = (Pair) list4.get(i2);
                break;
            }
            i2++;
        }
        if (pair == null) {
            str = this.f4451f.f4100a;
            Log.w(str, "OnEventListener had not been registered.");
        } else {
            xcVar = this.f4451f.f4106g;
            xcVar.unregisterOnMeasurementEventListener((dd) pair.second);
            list2 = this.f4451f.f4103d;
            list2.remove(pair);
        }
    }
}
