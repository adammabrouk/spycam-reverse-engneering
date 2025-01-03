package f.i;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Maps.kt */
/* loaded from: classes.dex */
public class o extends n {
    public static final <K, V> Map<K, V> a() {
        k kVar = k.INSTANCE;
        if (kVar != null) {
            return kVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> Map<K, V> b(Map<? extends K, ? extends V> map) {
        f.j.b.f.c(map, "$this$toMap");
        int size = map.size();
        return size != 0 ? size != 1 ? c(map) : n.a(map) : a();
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        f.j.b.f.c(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> a(f.d<? extends K, ? extends V>... dVarArr) {
        f.j.b.f.c(dVarArr, "pairs");
        if (dVarArr.length <= 0) {
            return a();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(n.a(dVarArr.length));
        a(dVarArr, linkedHashMap);
        return linkedHashMap;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, f.d<? extends K, ? extends V>[] dVarArr) {
        f.j.b.f.c(map, "$this$putAll");
        f.j.b.f.c(dVarArr, "pairs");
        for (f.d<? extends K, ? extends V> dVar : dVarArr) {
            map.put(dVar.component1(), dVar.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(f.d<? extends K, ? extends V>[] dVarArr, M m) {
        f.j.b.f.c(dVarArr, "$this$toMap");
        f.j.b.f.c(m, "destination");
        a(m, dVarArr);
        return m;
    }
}
