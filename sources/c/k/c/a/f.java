package c.k.c.a;

import android.content.Context;
import com.hjq.permissions.Permission;
import java.io.File;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6819a = false;

    /* renamed from: b, reason: collision with root package name */
    public static c.k.a.a.a.a f6820b;

    public static c.k.a.a.a.a a() {
        return f6820b;
    }

    public static File a(String str) {
        File file;
        try {
            file = new File(str);
        } catch (NullPointerException unused) {
            c.k.a.a.a.c.d("null pointer exception while retrieve file.");
        }
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile() && !listFiles[i2].getName().contains("lock") && listFiles[i2].getName().contains("log")) {
                    return listFiles[i2];
                }
            }
            return null;
        }
        return null;
    }

    public static void a(Context context, c.k.a.a.a.a aVar) {
        f6820b = aVar;
        b(context);
    }

    public static void a(Context context, boolean z) {
        c.k.d.j.a(context).a(new j1(context, z));
    }

    public static boolean a(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (a(r4) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r4) {
        /*
            c.k.a.a.a.a r0 = c.k.c.a.f.f6820b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            boolean r3 = c.k.c.a.f.f6819a
            if (r3 == 0) goto Le
            goto L16
        Le:
            boolean r3 = a(r4)
            r2 = r0
            if (r3 == 0) goto L16
            goto L17
        L16:
            r1 = 0
        L17:
            c.k.d.g2 r0 = new c.k.d.g2
            r3 = 0
            if (r2 == 0) goto L1f
            c.k.a.a.a.a r2 = c.k.c.a.f.f6820b
            goto L20
        L1f:
            r2 = r3
        L20:
            if (r1 == 0) goto L27
            c.k.d.h2 r3 = new c.k.d.h2
            r3.<init>(r4)
        L27:
            r0.<init>(r2, r3)
            c.k.a.a.a.c.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.c.a.f.b(android.content.Context):void");
    }
}
