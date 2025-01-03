package c.a.a.l.j;

import android.content.Context;
import android.net.Uri;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3216a;

    /* renamed from: b, reason: collision with root package name */
    public final l<d, T> f3217b;

    public q(Context context, l<d, T> lVar) {
        this.f3216a = context;
        this.f3217b = lVar;
    }

    public abstract c.a.a.l.h.c<T> a(Context context, Uri uri);

    public abstract c.a.a.l.h.c<T> a(Context context, String str);

    @Override // c.a.a.l.j.l
    public final c.a.a.l.h.c<T> a(Uri uri, int i2, int i3) {
        String scheme = uri.getScheme();
        if (a(scheme)) {
            if (!a.a(uri)) {
                return a(this.f3216a, uri);
            }
            return a(this.f3216a, a.b(uri));
        }
        if (this.f3217b == null || !("http".equals(scheme) || "https".equals(scheme))) {
            return null;
        }
        return this.f3217b.a(new d(uri.toString()), i2, i3);
    }

    public static boolean a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }
}
