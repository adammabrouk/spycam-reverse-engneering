package c.c.a.a.i.b;

import android.util.SparseArray;
import c.c.a.a.i.b.j;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public abstract class u {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class a {
        public abstract a a(b bVar);

        public abstract a a(c cVar);

        public abstract u a();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<b> f3532a;
        public static final b zza = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
        public static final b zzb = new b("GPRS", 1, 1);
        public static final b zzc = new b("EDGE", 2, 2);
        public static final b zzd = new b("UMTS", 3, 3);
        public static final b zze = new b("CDMA", 4, 4);
        public static final b zzf = new b("EVDO_0", 5, 5);
        public static final b zzg = new b("EVDO_A", 6, 6);
        public static final b zzh = new b("RTT", 7, 7);
        public static final b zzi = new b("HSDPA", 8, 8);
        public static final b zzj = new b("HSUPA", 9, 9);
        public static final b zzk = new b("HSPA", 10, 10);
        public static final b zzl = new b("IDEN", 11, 11);
        public static final b zzm = new b("EVDO_B", 12, 12);
        public static final b zzn = new b("LTE", 13, 13);
        public static final b zzo = new b("EHRPD", 14, 14);
        public static final b zzp = new b("HSPAP", 15, 15);
        public static final b zzq = new b("GSM", 16, 16);
        public static final b zzr = new b("TD_SCDMA", 17, 17);
        public static final b zzs = new b("IWLAN", 18, 18);
        public static final b zzt = new b("LTE_CA", 19, 19);
        public static final b zzu = new b("COMBINED", 20, 100);
        public final int zzw;

        static {
            SparseArray<b> sparseArray = new SparseArray<>();
            f3532a = sparseArray;
            sparseArray.put(0, zza);
            f3532a.put(1, zzb);
            f3532a.put(2, zzc);
            f3532a.put(3, zzd);
            f3532a.put(4, zze);
            f3532a.put(5, zzf);
            f3532a.put(6, zzg);
            f3532a.put(7, zzh);
            f3532a.put(8, zzi);
            f3532a.put(9, zzj);
            f3532a.put(10, zzk);
            f3532a.put(11, zzl);
            f3532a.put(12, zzm);
            f3532a.put(13, zzn);
            f3532a.put(14, zzo);
            f3532a.put(15, zzp);
            f3532a.put(16, zzq);
            f3532a.put(17, zzr);
            f3532a.put(18, zzs);
            f3532a.put(19, zzt);
        }

        public b(String str, int i2, int i3) {
            this.zzw = i3;
        }

        public int zza() {
            return this.zzw;
        }

        public static b zza(int i2) {
            return f3532a.get(i2);
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<c> f3533a;
        public static final c zza = new c("MOBILE", 0, 0);
        public static final c zzb = new c("WIFI", 1, 1);
        public static final c zzc = new c("MOBILE_MMS", 2, 2);
        public static final c zzd = new c("MOBILE_SUPL", 3, 3);
        public static final c zze = new c("MOBILE_DUN", 4, 4);
        public static final c zzf = new c("MOBILE_HIPRI", 5, 5);
        public static final c zzg = new c("WIMAX", 6, 6);
        public static final c zzh = new c("BLUETOOTH", 7, 7);
        public static final c zzi = new c("DUMMY", 8, 8);
        public static final c zzj = new c("ETHERNET", 9, 9);
        public static final c zzk = new c("MOBILE_FOTA", 10, 10);
        public static final c zzl = new c("MOBILE_IMS", 11, 11);
        public static final c zzm = new c("MOBILE_CBS", 12, 12);
        public static final c zzn = new c("WIFI_P2P", 13, 13);
        public static final c zzo = new c("MOBILE_IA", 14, 14);
        public static final c zzp = new c("MOBILE_EMERGENCY", 15, 15);
        public static final c zzq = new c("PROXY", 16, 16);
        public static final c zzr = new c("VPN", 17, 17);
        public static final c zzs = new c("NONE", 18, -1);
        public final int zzu;

        static {
            SparseArray<c> sparseArray = new SparseArray<>();
            f3533a = sparseArray;
            sparseArray.put(0, zza);
            f3533a.put(1, zzb);
            f3533a.put(2, zzc);
            f3533a.put(3, zzd);
            f3533a.put(4, zze);
            f3533a.put(5, zzf);
            f3533a.put(6, zzg);
            f3533a.put(7, zzh);
            f3533a.put(8, zzi);
            f3533a.put(9, zzj);
            f3533a.put(10, zzk);
            f3533a.put(11, zzl);
            f3533a.put(12, zzm);
            f3533a.put(13, zzn);
            f3533a.put(14, zzo);
            f3533a.put(15, zzp);
            f3533a.put(16, zzq);
            f3533a.put(17, zzr);
            f3533a.put(-1, zzs);
        }

        public c(String str, int i2, int i3) {
            this.zzu = i3;
        }

        public int zza() {
            return this.zzu;
        }

        public static c zza(int i2) {
            return f3533a.get(i2);
        }
    }

    public static a a() {
        return new j.b();
    }
}
