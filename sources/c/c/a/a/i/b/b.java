package c.c.a.a.i.b;

import android.util.SparseArray;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<b> f3477a;
    public static final b zza = new b("DEFAULT", 0, 0);
    public static final b zzb = new b("UNMETERED_ONLY", 1, 1);
    public static final b zzc = new b("UNMETERED_OR_DAILY", 2, 2);
    public static final b zzd = new b("FAST_IF_RADIO_AWAKE", 3, 3);
    public static final b zze = new b("NEVER", 4, 4);
    public static final b zzf = new b("UNRECOGNIZED", 5, -1);

    static {
        SparseArray<b> sparseArray = new SparseArray<>();
        f3477a = sparseArray;
        sparseArray.put(0, zza);
        f3477a.put(1, zzb);
        f3477a.put(2, zzc);
        f3477a.put(3, zzd);
        f3477a.put(4, zze);
        f3477a.put(-1, zzf);
    }

    public b(String str, int i2, int i3) {
    }
}
