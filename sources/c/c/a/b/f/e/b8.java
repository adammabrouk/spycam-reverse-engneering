package c.c.a.b.f.e;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class b8 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ b8[] f4090a;
    public static final b8 zza = new b8("DOUBLE", 0, e8.DOUBLE, 1);
    public static final b8 zzb = new b8("FLOAT", 1, e8.FLOAT, 5);
    public static final b8 zzc = new b8("INT64", 2, e8.LONG, 0);
    public static final b8 zzd = new b8("UINT64", 3, e8.LONG, 0);
    public static final b8 zze = new b8("INT32", 4, e8.INT, 0);
    public static final b8 zzf = new b8("FIXED64", 5, e8.LONG, 1);
    public static final b8 zzg = new b8("FIXED32", 6, e8.INT, 5);
    public static final b8 zzh = new b8("BOOL", 7, e8.BOOLEAN, 0);
    public static final b8 zzi;
    public static final b8 zzj;
    public static final b8 zzk;
    public static final b8 zzl;
    public static final b8 zzm;
    public static final b8 zzn;
    public static final b8 zzo;
    public static final b8 zzp;
    public static final b8 zzq;
    public static final b8 zzr;
    public final e8 zzs;
    public final int zzt;

    static {
        final int i2 = 2;
        final int i3 = 3;
        final e8 e8Var = e8.STRING;
        final int i4 = 8;
        final String str = "STRING";
        zzi = new b8(str, i4, e8Var, i2) { // from class: c.c.a.b.f.e.a8
            {
                int i5 = 8;
                int i6 = 2;
                y7 y7Var = null;
            }
        };
        final e8 e8Var2 = e8.MESSAGE;
        final int i5 = 9;
        final String str2 = "GROUP";
        zzj = new b8(str2, i5, e8Var2, i3) { // from class: c.c.a.b.f.e.d8
            {
                int i6 = 9;
                int i7 = 3;
                y7 y7Var = null;
            }
        };
        final e8 e8Var3 = e8.MESSAGE;
        final int i6 = 10;
        final String str3 = "MESSAGE";
        zzk = new b8(str3, i6, e8Var3, i2) { // from class: c.c.a.b.f.e.c8
            {
                int i7 = 10;
                int i8 = 2;
                y7 y7Var = null;
            }
        };
        final e8 e8Var4 = e8.BYTE_STRING;
        final int i7 = 11;
        final String str4 = "BYTES";
        zzl = new b8(str4, i7, e8Var4, i2) { // from class: c.c.a.b.f.e.f8
            {
                int i8 = 11;
                int i9 = 2;
                y7 y7Var = null;
            }
        };
        zzm = new b8("UINT32", 12, e8.INT, 0);
        zzn = new b8("ENUM", 13, e8.ENUM, 0);
        zzo = new b8("SFIXED32", 14, e8.INT, 5);
        zzp = new b8("SFIXED64", 15, e8.LONG, 1);
        zzq = new b8("SINT32", 16, e8.INT, 0);
        b8 b8Var = new b8("SINT64", 17, e8.LONG, 0);
        zzr = b8Var;
        f4090a = new b8[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, b8Var};
    }

    public b8(String str, int i2, e8 e8Var, int i3) {
        this.zzs = e8Var;
        this.zzt = i3;
    }

    public static b8[] values() {
        return (b8[]) f4090a.clone();
    }

    public final e8 zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    public /* synthetic */ b8(String str, int i2, e8 e8Var, int i3, y7 y7Var) {
        this(str, i2, e8Var, i3);
    }
}
