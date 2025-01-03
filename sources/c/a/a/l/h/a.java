package c.a.a.l.h;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f3042a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetManager f3043b;

    /* renamed from: c, reason: collision with root package name */
    public T f3044c;

    public a(AssetManager assetManager, String str) {
        this.f3043b = assetManager;
        this.f3042a = str;
    }

    public abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // c.a.a.l.h.c
    public T a(c.a.a.g gVar) throws Exception {
        T a2 = a(this.f3043b, this.f3042a);
        this.f3044c = a2;
        return a2;
    }

    public abstract void a(T t) throws IOException;

    @Override // c.a.a.l.h.c
    public String c() {
        return this.f3042a;
    }

    @Override // c.a.a.l.h.c
    public void cancel() {
    }

    @Override // c.a.a.l.h.c
    public void a() {
        T t = this.f3044c;
        if (t == null) {
            return;
        }
        try {
            a((a<T>) t);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e2);
            }
        }
    }
}
