package cn.jiguang.bf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final k f8736a;

    public l(k kVar) {
        this.f8736a = kVar;
    }

    private cn.jiguang.bg.h a(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread) {
        cn.jiguang.bg.h hVar = new cn.jiguang.bg.h();
        hVar.a(thread.getName());
        hVar.a(Integer.valueOf(thread.getPriority()));
        hVar.a(Long.valueOf(thread.getId()));
        hVar.c(Boolean.valueOf(thread.isDaemon()));
        hVar.b(thread.getState().name());
        hVar.a(Boolean.valueOf(z));
        hVar.b(Boolean.valueOf(cn.jiguang.bh.c.a(thread)));
        cn.jiguang.bg.g gVar = new cn.jiguang.bg.g(this.f8736a.a(stackTraceElementArr));
        gVar.a(true);
        hVar.a(gVar);
        return hVar;
    }

    public List<cn.jiguang.bg.h> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    public List<cn.jiguang.bg.h> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(a(key == currentThread || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
