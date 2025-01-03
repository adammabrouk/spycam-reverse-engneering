package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class w2 {

    /* renamed from: a, reason: collision with root package name */
    public static final v2 f4505a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class a extends v2 {
        @Override // c.c.a.b.f.e.v2
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Integer r0 = a()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L14
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L2a
            r2 = 19
            if (r1 < r2) goto L14
            c.c.a.b.f.e.a3 r1 = new c.c.a.b.f.e.a3     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L14:
            java.lang.String r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch: java.lang.Throwable -> L2a
            r1 = r1 ^ 1
            if (r1 == 0) goto L24
            c.c.a.b.f.e.z2 r1 = new c.c.a.b.f.e.z2     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L24:
            c.c.a.b.f.e.w2$a r1 = new c.c.a.b.f.e.w2$a     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L2a:
            r1 = move-exception
            goto L2e
        L2c:
            r1 = move-exception
            r0 = 0
        L2e:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<c.c.a.b.f.e.w2$a> r3 = c.c.a.b.f.e.w2.a.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 133
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
            c.c.a.b.f.e.w2$a r1 = new c.c.a.b.f.e.w2$a
            r1.<init>()
        L63:
            c.c.a.b.f.e.w2.f4505a = r1
            if (r0 != 0) goto L68
            goto L6b
        L68:
            r0.intValue()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.w2.<clinit>():void");
    }

    public static void a(Throwable th, Throwable th2) {
        f4505a.a(th, th2);
    }

    public static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }
}
