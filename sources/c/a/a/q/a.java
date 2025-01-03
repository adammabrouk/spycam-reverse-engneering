package c.a.a.q;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c.a.a.l.c> f3445a = new ConcurrentHashMap<>();

    public static c.a.a.l.c a(Context context) {
        String packageName = context.getPackageName();
        c.a.a.l.c cVar = f3445a.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        c.a.a.l.c b2 = b(context);
        c.a.a.l.c putIfAbsent = f3445a.putIfAbsent(packageName, b2);
        return putIfAbsent == null ? b2 : putIfAbsent;
    }

    public static c.a.a.l.c b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return new c(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }
}
