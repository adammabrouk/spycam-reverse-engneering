package cn.jiguang.ay;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static f f8547a;

    /* renamed from: b, reason: collision with root package name */
    public static String[] f8548b;

    /* renamed from: c, reason: collision with root package name */
    public static String[] f8549c;

    static {
        f fVar = new f("Message Section", 3);
        f8547a = fVar;
        f8548b = new String[4];
        f8549c = new String[4];
        fVar.a(3);
        f8547a.a(true);
        f8547a.a(0, "qd");
        f8547a.a(1, "an");
        f8547a.a(2, "au");
        f8547a.a(3, "ad");
        String[] strArr = f8548b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f8549c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i2) {
        return f8547a.d(i2);
    }
}
