package c.c.b.l;

import android.util.Log;
import android.util.Pair;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6005a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public final Map<Pair<String, String>, c.c.a.b.j.h<a>> f6006b = new a.e.a();

    public w(Executor executor) {
        this.f6005a = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized c.c.a.b.j.h<a> a(String str, String str2, y yVar) {
        final Pair pair = new Pair(str, str2);
        c.c.a.b.j.h<a> hVar = this.f6006b.get(pair);
        if (hVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return hVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        c.c.a.b.j.h b2 = yVar.zza().b(this.f6005a, new c.c.a.b.j.a(this, pair) { // from class: c.c.b.l.v

            /* renamed from: a, reason: collision with root package name */
            public final w f6000a;

            /* renamed from: b, reason: collision with root package name */
            public final Pair f6001b;

            {
                this.f6000a = this;
                this.f6001b = pair;
            }

            @Override // c.c.a.b.j.a
            public final Object a(c.c.a.b.j.h hVar2) {
                this.f6000a.a(this.f6001b, hVar2);
                return hVar2;
            }
        });
        this.f6006b.put(pair, b2);
        return b2;
    }

    public final /* synthetic */ c.c.a.b.j.h a(Pair pair, c.c.a.b.j.h hVar) throws Exception {
        synchronized (this) {
            this.f6006b.remove(pair);
        }
        return hVar;
    }
}
