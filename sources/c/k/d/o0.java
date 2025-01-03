package c.k.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public class o0 {
    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String a2 = r0.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = k0.a(20);
        r0.a(context).m439a("sp_client_report_status", "sp_client_report_key", a3);
        return a3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e4, code lost:
    
        if (r7 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.o0.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static boolean a(Context context, String str) {
        File file = new File(str);
        long b2 = c.k.b.b.b.a(context).m10a().b();
        if (file.exists()) {
            try {
                if (file.length() > b2) {
                    return false;
                }
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
                return false;
            }
        } else {
            v9.m513a(file);
        }
        return true;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(h0.m185a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static File[] m317a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new q0());
        }
        return null;
    }
}
