package com.vivo.push.sdk.service;

import android.app.Activity;
import c.j.a.z.v;

/* loaded from: classes.dex */
public class LinkProxyActivity extends Activity {
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1 A[Catch: Exception -> 0x00e3, TryCatch #2 {Exception -> 0x00e3, blocks: (B:28:0x0094, B:30:0x009a, B:32:0x00a6, B:34:0x00ac, B:36:0x00b4, B:39:0x00bb, B:41:0x00c3, B:43:0x00c7, B:47:0x00d1, B:48:0x00d5), top: B:27:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e3, blocks: (B:28:0x0094, B:30:0x009a, B:32:0x00a6, B:34:0x00ac, B:36:0x00b4, B:39:0x00bb, B:41:0x00c3, B:43:0x00c7, B:47:0x00d1, B:48:0x00d5), top: B:27:0x0094 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "LinkProxyActivity"
            if (r7 != 0) goto L14
            java.lang.String r7 = "enter RequestPermissionsActivity onCreate, intent is null, finish"
            c.j.a.z.v.d(r0, r7)
            r6.finish()
            return
        L14:
            r1 = 1
            r2 = 0
            android.view.Window r3 = r6.getWindow()     // Catch: java.lang.Throwable -> L30
            r4 = 8388659(0x800033, float:1.1755015E-38)
            r3.setGravity(r4)     // Catch: java.lang.Throwable -> L30
            android.view.WindowManager$LayoutParams r4 = r3.getAttributes()     // Catch: java.lang.Throwable -> L30
            r4.x = r2     // Catch: java.lang.Throwable -> L30
            r4.y = r2     // Catch: java.lang.Throwable -> L30
            r4.height = r1     // Catch: java.lang.Throwable -> L30
            r4.width = r1     // Catch: java.lang.Throwable -> L30
            r3.setAttributes(r4)     // Catch: java.lang.Throwable -> L30
            goto L36
        L30:
            r3 = move-exception
            java.lang.String r4 = "enter onCreate error "
            c.j.a.z.v.b(r0, r4, r3)
        L36:
            java.lang.String r3 = r6.getPackageName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r6.hashCode()
            r4.append(r5)
            java.lang.String r5 = " enter onCreate "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            c.j.a.z.v.d(r0, r4)
            java.lang.String r4 = "com.vivo.abe"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "previous_intent"
            if (r3 == 0) goto L94
            if (r7 != 0) goto L68
            java.lang.String r7 = "adapterToService intent is null"
            c.j.a.z.v.d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Leb
        L68:
            android.os.Bundle r1 = r7.getExtras()     // Catch: java.lang.Exception -> L8b
            if (r1 != 0) goto L75
            java.lang.String r7 = "adapterToService getExtras() is null"
            c.j.a.z.v.d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Leb
        L75:
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> L8b
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> L8b
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> L8b
            if (r7 != 0) goto L87
            java.lang.String r7 = "adapterToService proxyIntent is null"
            c.j.a.z.v.d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Leb
        L87:
            c.j.a.z.f0.a(r6, r7)     // Catch: java.lang.Exception -> L8b
            goto Leb
        L8b:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            c.j.a.z.v.a(r0, r1, r7)
            goto Leb
        L94:
            android.os.Bundle r3 = r7.getExtras()     // Catch: java.lang.Exception -> Le3
            if (r3 == 0) goto Leb
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> Le3
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> Le3
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> Le3
            if (r7 == 0) goto Lce
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> Le3
            if (r3 == 0) goto Lce
            r4 = 576(0x240, float:8.07E-43)
            java.util.List r3 = r3.queryIntentServices(r7, r4)     // Catch: java.lang.Exception -> Le3
            if (r3 == 0) goto Lce
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> Le3
            if (r4 == 0) goto Lbb
            goto Lce
        Lbb:
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> Le3
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.lang.Exception -> Le3
            if (r3 == 0) goto Lce
            android.content.pm.ServiceInfo r4 = r3.serviceInfo     // Catch: java.lang.Exception -> Le3
            if (r4 == 0) goto Lce
            android.content.pm.ServiceInfo r3 = r3.serviceInfo     // Catch: java.lang.Exception -> Le3
            boolean r3 = r3.exported     // Catch: java.lang.Exception -> Le3
            if (r3 == 0) goto Lce
            goto Lcf
        Lce:
            r1 = 0
        Lcf:
            if (r1 == 0) goto Ld5
            r6.startService(r7)     // Catch: java.lang.Exception -> Le3
            goto Leb
        Ld5:
            java.lang.String r7 = "service's exported is "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> Le3
            java.lang.String r7 = r7.concat(r1)     // Catch: java.lang.Exception -> Le3
            c.j.a.z.v.b(r0, r7)     // Catch: java.lang.Exception -> Le3
            goto Leb
        Le3:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            c.j.a.z.v.a(r0, r1, r7)
        Leb:
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.sdk.service.LinkProxyActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
