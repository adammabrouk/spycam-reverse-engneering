package c.k.d.p9;

import c.k.d.p9.j0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class k0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f7634a;

    public k0(j0 j0Var) {
        this.f7634a = j0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f7634a.f7622d;
            Iterator it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                ((j0.a) it.next()).run();
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("Sync job exception :" + e2.getMessage());
        }
        this.f7634a.f7621c = false;
    }
}
