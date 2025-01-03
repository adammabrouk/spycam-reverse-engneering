package cn.jpush.android.aa;

import android.content.Context;
import android.util.Base64;
import cn.jpush.android.ac.b;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0145 A[Catch: IOException -> 0x0141, TRY_LEAVE, TryCatch #12 {IOException -> 0x0141, blocks: (B:36:0x013d, B:30:0x0145), top: B:35:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015d A[Catch: IOException -> 0x0159, TRY_LEAVE, TryCatch #0 {IOException -> 0x0159, blocks: (B:49:0x0155, B:42:0x015d), top: B:48:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115 A[Catch: IOException -> 0x0111, TRY_LEAVE, TryCatch #3 {IOException -> 0x0111, blocks: (B:63:0x010d, B:57:0x0115), top: B:62:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.aa.a.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, byte[]):int");
    }

    public static int a(Context context, String str, JSONObject jSONObject) {
        byte[] a2 = b.a(cn.jpush.android.ac.a.b(jSONObject.toString().getBytes()), "JPUSHJPUSH123456", "JPUSHJPUSH123456");
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String a3 = cn.jpush.android.ac.a.a(valueOf + ':' + cn.jpush.android.ac.a.a(a2));
        return a(context, str, valueOf, Base64.encodeToString((cn.jpush.android.l.a.c(context) + ':' + a3).getBytes(StandardCharsets.UTF_8), 10), a2);
    }
}
