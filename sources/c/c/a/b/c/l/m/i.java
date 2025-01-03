package c.c.a.b.c.l.m;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f3885a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Map<c.c.a.b.j.i<?>, Boolean> f3886b = Collections.synchronizedMap(new WeakHashMap());

    public final boolean a() {
        return (this.f3885a.isEmpty() && this.f3886b.isEmpty()) ? false : true;
    }

    public final void b() {
        a(false, b.m);
    }

    public final void c() {
        a(true, a0.f3840a);
    }

    public final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f3885a) {
            hashMap = new HashMap(this.f3885a);
        }
        synchronized (this.f3886b) {
            hashMap2 = new HashMap(this.f3886b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c.c.a.b.j.i) entry2.getKey()).b((Exception) new c.c.a.b.c.l.b(status));
            }
        }
    }
}
