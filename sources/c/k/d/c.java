package c.k.d;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7005a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f7006b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7007c;

    /* renamed from: d, reason: collision with root package name */
    public static int f7008d;

    static {
        String str = f.f7111a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f7005a = str;
        boolean contains = str.contains("2A2FE0D7");
        f7006b = contains;
        if (!contains) {
            "DEBUG".equalsIgnoreCase(f7005a);
        }
        "LOGABLE".equalsIgnoreCase(f7005a);
        f7005a.contains("YY");
        f7007c = f7005a.equalsIgnoreCase("TEST");
        "BETA".equalsIgnoreCase(f7005a);
        String str2 = f7005a;
        if (str2 != null) {
            str2.startsWith("RC");
        }
        int i2 = 1;
        f7008d = 1;
        if (f7005a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (f7005a.equalsIgnoreCase("ONEBOX")) {
            i2 = 3;
        }
        f7008d = i2;
    }

    public static int a() {
        return f7008d;
    }

    public static void a(int i2) {
        f7008d = i2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m97a() {
        return f7008d == 2;
    }

    public static boolean b() {
        return f7008d == 3;
    }
}
