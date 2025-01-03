package cn.jpush.android.b;

import android.content.Context;
import cn.jpush.android.bd.e;
import cn.jpush.android.bd.f;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f9494a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9495b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public c f9496c;

    /* renamed from: d, reason: collision with root package name */
    public f f9497d;

    public d(Context context) {
        b(context);
    }

    public static d a(Context context) {
        if (f9494a == null) {
            synchronized (f9495b) {
                if (f9494a == null) {
                    f9494a = new d(context);
                }
            }
        }
        return f9494a;
    }

    private void b(Context context) {
        if (context == null) {
            Logger.dd("GeofenceManager", "context is null,init failed");
            return;
        }
        e.a().a(context);
        this.f9496c = new a(context);
        this.f9497d = new f(context);
    }

    public void a() {
        this.f9496c.b();
    }

    public void a(int i2) {
        e.a().a(i2);
    }

    public void a(long j) {
        this.f9496c.a(j);
    }

    public void a(long j, int i2, cn.jpush.android.bd.d dVar) {
        this.f9497d.a(j, i2, dVar);
    }

    public void a(b bVar) {
        Logger.dd("GeofenceManager", "recv geofence...");
        e.a().b(bVar);
    }

    public void a(cn.jpush.android.bd.b bVar) {
        this.f9497d.a(bVar);
    }

    public void a(String str) {
        e.a().a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r3 == 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        if (r3 == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        cn.jpush.android.helper.Logger.w("GeofenceManager", "operation " + r1 + " not supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        cn.jpush.android.bd.e.a().a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        cn.jpush.android.bd.e.a().a(r2, r9, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "GeofenceManager"
            java.lang.String r1 = "content"
            org.json.JSONObject r9 = r9.getJSONObject(r1)     // Catch: java.lang.Throwable -> La0
            if (r9 == 0) goto Lb5
            int r1 = r9.length()     // Catch: java.lang.Throwable -> La0
            if (r1 <= 0) goto Lb5
            java.lang.String r1 = "op"
            java.lang.String r1 = r9.optString(r1)     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "geofenceid"
            java.lang.String r2 = r9.optString(r2)     // Catch: java.lang.Throwable -> La0
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> La0
            if (r3 != 0) goto L9a
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L2a
            goto L9a
        L2a:
            r3 = -1
            int r4 = r1.hashCode()     // Catch: java.lang.Throwable -> La0
            r5 = 96417(0x178a1, float:1.35109E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L55
            r5 = 99339(0x1840b, float:1.39204E-40)
            if (r4 == r5) goto L4b
            r5 = 116009(0x1c529, float:1.62563E-40)
            if (r4 == r5) goto L41
            goto L5e
        L41:
            java.lang.String r4 = "upd"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L5e
            r3 = 1
            goto L5e
        L4b:
            java.lang.String r4 = "del"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L5e
            r3 = 2
            goto L5e
        L55:
            java.lang.String r4 = "add"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L5e
            r3 = 0
        L5e:
            if (r3 == 0) goto L8e
            if (r3 == r7) goto L86
            if (r3 == r6) goto L7e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            r9.<init>()     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "operation "
            r9.append(r2)     // Catch: java.lang.Throwable -> La0
            r9.append(r1)     // Catch: java.lang.Throwable -> La0
            java.lang.String r1 = " not supported"
            r9.append(r1)     // Catch: java.lang.Throwable -> La0
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> La0
            cn.jpush.android.helper.Logger.w(r0, r9)     // Catch: java.lang.Throwable -> La0
            goto Lb5
        L7e:
            cn.jpush.android.bd.e r9 = cn.jpush.android.bd.e.a()     // Catch: java.lang.Throwable -> La0
            r9.a(r2)     // Catch: java.lang.Throwable -> La0
            goto Lb5
        L86:
            cn.jpush.android.bd.e r1 = cn.jpush.android.bd.e.a()     // Catch: java.lang.Throwable -> La0
            r1.a(r2, r9, r7)     // Catch: java.lang.Throwable -> La0
            goto Lb5
        L8e:
            cn.jpush.android.b.b r9 = cn.jpush.android.b.b.a(r9)     // Catch: java.lang.Throwable -> La0
            cn.jpush.android.bd.e r1 = cn.jpush.android.bd.e.a()     // Catch: java.lang.Throwable -> La0
            r1.b(r9)     // Catch: java.lang.Throwable -> La0
            goto Lb5
        L9a:
            java.lang.String r9 = "json error: required key not found"
            cn.jpush.android.helper.Logger.w(r0, r9)     // Catch: java.lang.Throwable -> La0
            return
        La0:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "json error:"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            cn.jpush.android.helper.Logger.w(r0, r9)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.d.a(org.json.JSONObject):void");
    }

    public void b() {
        this.f9496c.a();
    }

    public void c() {
        this.f9497d.a();
    }

    public void d() {
        this.f9497d.b();
    }
}
