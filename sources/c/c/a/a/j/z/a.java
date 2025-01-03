package c.c.a.a.j.z;

import android.util.SparseArray;
import c.c.a.a.d;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<d> f3778a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static EnumMap<d, Integer> f3779b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>((Class<d>) d.class);
        f3779b = enumMap;
        enumMap.put((EnumMap<d, Integer>) d.DEFAULT, (d) 0);
        f3779b.put((EnumMap<d, Integer>) d.VERY_LOW, (d) 1);
        f3779b.put((EnumMap<d, Integer>) d.HIGHEST, (d) 2);
        for (d dVar : f3779b.keySet()) {
            f3778a.append(f3779b.get(dVar).intValue(), dVar);
        }
    }

    public static d a(int i2) {
        d dVar = f3778a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i2);
    }

    public static int a(d dVar) {
        Integer num = f3779b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }
}
