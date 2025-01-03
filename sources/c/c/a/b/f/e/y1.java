package c.c.a.b.f.e;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile o2<Boolean> f4528a = o2.zzc();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4529b = new Object();

    public static boolean a(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
    }

    public static boolean a(Context context, Uri uri) {
        ProviderInfo resolveContentProvider;
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (f4528a.zza()) {
            return f4528a.zzb().booleanValue();
        }
        synchronized (f4529b) {
            if (f4528a.zza()) {
                return f4528a.zzb().booleanValue();
            }
            if (!"com.google.android.gms".equals(context.getPackageName()) && ((resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) == null || !"com.google.android.gms".equals(resolveContentProvider.packageName))) {
                z = false;
                if (z && a(context)) {
                    z2 = true;
                }
                f4528a = o2.zza(Boolean.valueOf(z2));
                return f4528a.zzb().booleanValue();
            }
            z = true;
            if (z) {
                z2 = true;
            }
            f4528a = o2.zza(Boolean.valueOf(z2));
            return f4528a.zzb().booleanValue();
        }
    }
}
