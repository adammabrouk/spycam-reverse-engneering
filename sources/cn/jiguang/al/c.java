package cn.jiguang.al;

/* loaded from: classes.dex */
public class c {
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0030, code lost:
    
        if (r8 != r1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        if (r1 == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = cn.jiguang.l.b.c(r9)
            boolean r1 = cn.jiguang.l.b.b(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "OFF"
            java.lang.String r4 = "ON"
            r5 = 0
            java.lang.String r6 = "JWakeLocalState"
            r7 = 1
            if (r2 == 0) goto L1a
            if (r1 != 0) goto L39
        L18:
            r5 = 1
            goto L39
        L1a:
            boolean r2 = android.text.TextUtils.equals(r4, r0)
            if (r2 == 0) goto L23
            r2 = 0
        L21:
            r8 = 1
            goto L2e
        L23:
            boolean r2 = android.text.TextUtils.equals(r3, r0)
            if (r2 == 0) goto L2c
            r2 = 0
            r8 = 0
            goto L2e
        L2c:
            r2 = 1
            goto L21
        L2e:
            if (r2 != 0) goto L33
            if (r8 == r1) goto L39
            goto L18
        L33:
            java.lang.String r5 = "local wake state do not changed"
            cn.jiguang.ai.a.a(r6, r5)
            r5 = r2
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "lastCacheWakeState:"
            r2.append(r8)
            r2.append(r0)
            java.lang.String r0 = ",userWakeupEnable:"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ",isNeedReport:"
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            cn.jiguang.ai.a.a(r6, r0)
            if (r5 == 0) goto L96
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "status"
            if (r1 == 0) goto L69
            goto L6a
        L69:
            r7 = 2
        L6a:
            r0.put(r2, r7)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "aals"
            cn.jiguang.l.d.a(r9, r0, r2)     // Catch: java.lang.Throwable -> L7c
            cn.jiguang.l.d.a(r9, r0)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L78
            r3 = r4
        L78:
            cn.jiguang.l.b.m(r9, r3)     // Catch: java.lang.Throwable -> L7c
            goto L9b
        L7c:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "report local wake state failed, error:"
            r0.append(r1)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            cn.jiguang.ai.a.d(r6, r9)
            goto L9b
        L96:
            java.lang.String r9 = "do not need report local wake state"
            cn.jiguang.ai.a.a(r6, r9)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.al.c.a(android.content.Context):void");
    }
}
