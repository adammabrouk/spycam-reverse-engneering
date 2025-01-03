package c.c.a.b.f.e;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a.e.a<String, Uri> f4081a = new a.e.a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (b2.class) {
            uri = f4081a.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                f4081a.put(str, uri);
            }
        }
        return uri;
    }
}
