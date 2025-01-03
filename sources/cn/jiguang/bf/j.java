package cn.jiguang.bf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final k f8735a;

    public j(k kVar) {
        this.f8735a = kVar;
    }

    private cn.jiguang.bg.d a(Throwable th, cn.jiguang.bg.c cVar, Thread thread, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        cn.jiguang.bg.d dVar = new cn.jiguang.bg.d();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + ".", "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        List<cn.jiguang.bg.f> a2 = this.f8735a.a(th.getStackTrace());
        if (a2 != null && !a2.isEmpty()) {
            if (!a(thread) && !a(a2)) {
                return null;
            }
            cn.jiguang.bg.g gVar = new cn.jiguang.bg.g(a2);
            if (z) {
                gVar.a(true);
            }
            dVar.a(gVar);
        }
        if (thread != null) {
            dVar.a(Long.valueOf(thread.getId()));
        }
        dVar.a(name);
        dVar.a(cVar);
        dVar.c(name2);
        dVar.b(message);
        return dVar;
    }

    private List<cn.jiguang.bg.d> a(Deque<cn.jiguang.bg.d> deque) {
        return new ArrayList(deque);
    }

    public List<cn.jiguang.bg.d> a(Throwable th) {
        return a(b(th));
    }

    public boolean a(Thread thread) {
        if (thread.getName() != null) {
            return thread.getName().contains("jg");
        }
        return false;
    }

    public boolean a(List<cn.jiguang.bg.f> list) {
        Iterator<cn.jiguang.bg.f> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = z || it.next().h().booleanValue();
            if (z) {
                break;
            }
        }
        return z;
    }

    public Deque<cn.jiguang.bg.d> b(Throwable th) {
        Thread currentThread;
        cn.jiguang.bg.c cVar;
        boolean z;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof c) {
                c cVar2 = (c) th;
                cVar = cVar2.a();
                Throwable b2 = cVar2.b();
                currentThread = cVar2.c();
                z = cVar2.d();
                th = b2;
            } else {
                currentThread = Thread.currentThread();
                cVar = null;
                z = false;
            }
            arrayDeque.addFirst(a(th, cVar, currentThread, z));
            th = th.getCause();
        }
        return arrayDeque;
    }
}
