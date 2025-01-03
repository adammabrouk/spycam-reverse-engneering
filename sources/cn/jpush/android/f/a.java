package cn.jpush.android.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<b, cn.jpush.android.e.a> f9718a = new ConcurrentHashMap();

    public static cn.jpush.android.e.a a(b bVar) {
        return f9718a.get(bVar);
    }

    public static void a(b bVar, cn.jpush.android.e.a aVar) {
        if (aVar != null) {
            f9718a.put(bVar, aVar);
        }
    }

    public static void b(b bVar) {
        f9718a.remove(bVar);
    }
}
