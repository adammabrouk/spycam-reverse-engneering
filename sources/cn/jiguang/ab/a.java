package cn.jiguang.ab;

import android.content.Context;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f8113a;

    public a(Context context) {
        this.f8113a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055 A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:9:0x0045, B:11:0x0055, B:13:0x005b, B:14:0x0066, B:17:0x006a, B:18:0x000d, B:19:0x0038, B:21:0x0023, B:22:0x003d), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:9:0x0045, B:11:0x0055, B:13:0x005b, B:14:0x0066, B:17:0x006a, B:18:0x000d, B:19:0x0038, B:21:0x0023, B:22:0x003d), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VivoDB"
            r1 = 0
            if (r9 == 0) goto L3d
            r2 = 1
            if (r9 == r2) goto L23
            r2 = 2
            if (r9 == r2) goto Ld
            r3 = r1
            goto L45
        Ld:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1FXRr9EgPkoDQnyVgIu2tARnCHNUAAn6DU1ZkzxwPHKA=="
            java.lang.String r9 = cn.jiguang.l.d.g(r9)     // Catch: java.lang.Exception -> L70
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            r2.<init>()     // Catch: java.lang.Exception -> L70
            r2.append(r9)     // Catch: java.lang.Exception -> L70
            r2.append(r10)     // Catch: java.lang.Exception -> L70
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Exception -> L70
            goto L38
        L23:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1mRRRjMzvkebo9eb3zqoVhCi2GjcOItUY/+C68T3lxGg=="
            java.lang.String r9 = cn.jiguang.l.d.g(r9)     // Catch: java.lang.Exception -> L70
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            r2.<init>()     // Catch: java.lang.Exception -> L70
            r2.append(r9)     // Catch: java.lang.Exception -> L70
            r2.append(r10)     // Catch: java.lang.Exception -> L70
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Exception -> L70
        L38:
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> L70
            goto L44
        L3d:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1zTqeaHqknpahXd0Fww8QTTjy7MHX7/1f2JKNuxQ9omA=="
            java.lang.String r9 = cn.jiguang.l.d.g(r9)     // Catch: java.lang.Exception -> L70
            goto L38
        L44:
            r3 = r9
        L45:
            android.content.Context r9 = r8.f8113a     // Catch: java.lang.Exception -> L70
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Exception -> L70
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L70
            if (r9 == 0) goto L6a
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> L70
            if (r10 == 0) goto L66
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L70
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L70
            r1 = r10
        L66:
            r9.close()     // Catch: java.lang.Exception -> L70
            goto L89
        L6a:
            java.lang.String r9 = "return cursor is null,return"
            cn.jiguang.ai.a.a(r0, r9)     // Catch: java.lang.Exception -> L70
            goto L89
        L70:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "get id error: "
            r10.append(r2)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            cn.jiguang.ai.a.d(r0, r9)
        L89:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ab.a.a(int, java.lang.String):java.lang.String");
    }
}
