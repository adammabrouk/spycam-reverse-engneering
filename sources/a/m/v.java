package a.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, t> f1548a = new HashMap<>();

    public final void a(String str, t tVar) {
        t put = this.f1548a.put(str, tVar);
        if (put != null) {
            put.b();
        }
    }

    public Set<String> b() {
        return new HashSet(this.f1548a.keySet());
    }

    public final t a(String str) {
        return this.f1548a.get(str);
    }

    public final void a() {
        Iterator<t> it = this.f1548a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f1548a.clear();
    }
}
