package c.a.a.l.h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class g<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f3053a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3054b;

    /* renamed from: c, reason: collision with root package name */
    public T f3055c;

    public g(Context context, Uri uri) {
        this.f3054b = context.getApplicationContext();
        this.f3053a = uri;
    }

    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // c.a.a.l.h.c
    public final T a(c.a.a.g gVar) throws Exception {
        T a2 = a(this.f3053a, this.f3054b.getContentResolver());
        this.f3055c = a2;
        return a2;
    }

    public abstract void a(T t) throws IOException;

    @Override // c.a.a.l.h.c
    public String c() {
        return this.f3053a.toString();
    }

    @Override // c.a.a.l.h.c
    public void cancel() {
    }

    @Override // c.a.a.l.h.c
    public void a() {
        T t = this.f3055c;
        if (t != null) {
            try {
                a((g<T>) t);
            } catch (IOException e2) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e2);
                }
            }
        }
    }
}
