package c.c.b.l;

import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class k1 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f5967a;

    public k1(ExecutorService executorService) {
        this.f5967a = executorService;
    }

    @Override // c.c.b.l.d0
    public final c.c.a.b.j.h<Integer> a(final Intent intent) {
        return c.c.a.b.j.k.a(this.f5967a, new Callable(intent) { // from class: c.c.b.l.j1

            /* renamed from: a, reason: collision with root package name */
            public final Intent f5962a;

            {
                this.f5962a = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Intent intent2 = this.f5962a;
                String stringExtra = intent2.getStringExtra("CMD");
                if (stringExtra != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                        sb.append("Received command: ");
                        sb.append(stringExtra);
                        sb.append(" - ");
                        sb.append(valueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                    if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                        FirebaseInstanceId.o().f();
                    } else if ("SYNC".equals(stringExtra)) {
                        FirebaseInstanceId.o().h();
                    }
                }
                return -1;
            }
        });
    }
}
