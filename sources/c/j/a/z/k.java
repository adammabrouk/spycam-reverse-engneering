package c.j.a.z;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ClientReportUtil.java */
/* loaded from: classes.dex */
public final class k {
    public static boolean a(Context context, long j, long j2) {
        v.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        c.j.a.f.w wVar = new c.j.a.f.w(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String b2 = f0.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("remoteAppId", b2);
        }
        wVar.a(hashMap);
        c.j.a.m.m().a(wVar);
        return true;
    }

    public static boolean a(long j, HashMap<String, String> hashMap) {
        c.j.a.f.w wVar = new c.j.a.f.w(j);
        wVar.a(hashMap);
        wVar.d();
        c.j.a.m.m().a(wVar);
        return true;
    }
}
