package com.tencent.bugly.proguard;

import android.content.Context;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f11197a;

    /* renamed from: b, reason: collision with root package name */
    public int f11198b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11199c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11200d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f11201e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.info.a f11202f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.strategy.a f11203g;

    /* renamed from: h, reason: collision with root package name */
    public final s f11204h;

    /* renamed from: i, reason: collision with root package name */
    public final u f11205i;
    public final int j;
    public final t k;
    public final t l;
    public String m;
    public final String n;
    public final Map<String, String> o;
    public int p;
    public long q;
    public long r;
    public boolean s;

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, tVar, 2, 30000, z2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.bugly.proguard.an r4, boolean r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r4 = r3.f11200d
            r0 = 630(0x276, float:8.83E-43)
            if (r4 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r4 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r4 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r4 == r0) goto L17
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L1c
        L17:
            java.lang.String r4 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r4 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r1] = r4
            java.lang.String r4 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.x.a(r4, r6)
            goto L3d
        L2a:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r1] = r6
            r2[r0] = r4
            r4 = 2
            r2[r4] = r7
            java.lang.String r4 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.x.e(r4, r2)
        L3d:
            long r6 = r3.q
            long r0 = r3.r
            long r6 = r6 + r0
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L5d
            com.tencent.bugly.proguard.u r4 = r3.f11205i
            boolean r6 = r3.s
            long r6 = r4.a(r6)
            long r0 = r3.q
            long r6 = r6 + r0
            long r0 = r3.r
            long r6 = r6 + r0
            com.tencent.bugly.proguard.u r4 = r3.f11205i
            boolean r0 = r3.s
            r4.a(r6, r0)
        L5d:
            com.tencent.bugly.proguard.t r4 = r3.k
            if (r4 == 0) goto L64
            r4.a(r5)
        L64:
            com.tencent.bugly.proguard.t r4 = r3.l
            if (r4 == 0) goto L6b
            r4.a(r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    public final void b(long j) {
        this.r += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x01be A[Catch: all -> 0x0338, TryCatch #0 {all -> 0x0338, blocks: (B:3:0x0007, B:5:0x001a, B:9:0x0022, B:12:0x0027, B:14:0x003b, B:16:0x003f, B:18:0x0043, B:21:0x0049, B:23:0x0051, B:25:0x0057, B:27:0x0084, B:28:0x0089, B:30:0x00b8, B:33:0x00c0, B:35:0x00c6, B:36:0x00da, B:39:0x00e2, B:41:0x00f9, B:42:0x0106, B:45:0x0149, B:48:0x015c, B:51:0x0164, B:54:0x016b, B:57:0x0173, B:61:0x01be, B:63:0x01ea, B:64:0x01f2, B:66:0x01f8, B:68:0x0219, B:79:0x0253, B:81:0x0266, B:83:0x0277, B:84:0x027f, B:86:0x0285, B:88:0x02a0, B:91:0x02a9, B:93:0x02b0, B:96:0x02b8, B:98:0x02be, B:100:0x02c5, B:103:0x02db, B:105:0x02ee, B:107:0x02f5, B:109:0x02d8, B:111:0x02fd, B:114:0x017d, B:116:0x0183, B:117:0x018b, B:119:0x0199, B:120:0x01a5, B:121:0x01b2, B:123:0x0323, B:125:0x032a, B:127:0x0331), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, int i4, int i5, boolean z, Map<String, String> map) {
        this.f11197a = 2;
        this.f11198b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.f11199c = context;
        this.f11202f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f11201e = bArr;
        this.f11203g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f11204h = s.a(context);
        this.f11205i = u.a();
        this.j = i2;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.f11200d = i3;
        if (i4 > 0) {
            this.f11197a = i4;
        }
        if (i5 > 0) {
            this.f11198b = i5;
        }
        this.s = z;
        this.o = map;
    }

    public static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = anVar.f11081a;
        if (b2 != 0) {
            x.e("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!z.a(anVar.f11085e) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(anVar.f11085e)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f10891a, "device", anVar.f11085e.getBytes("UTF-8"), (o) null, true);
                aVar.f(anVar.f11085e);
            }
        } catch (Throwable th) {
            x.a(th);
        }
        aVar.f10878i = anVar.f11084d;
        int i2 = anVar.f11082b;
        if (i2 == 510) {
            byte[] bArr = anVar.f11083c;
            if (bArr == null) {
                x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            ap apVar = (ap) a.a(bArr, ap.class);
            if (apVar == null) {
                x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.f11082b));
                return false;
            }
            aVar2.a(apVar);
        }
        return true;
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
