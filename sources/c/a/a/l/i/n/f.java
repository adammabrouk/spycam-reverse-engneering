package c.a.a.l.i.n;

import android.content.Context;
import c.a.a.l.i.n.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3167a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3168b;

        public a(Context context, String str) {
            this.f3167a = context;
            this.f3168b = str;
        }

        @Override // c.a.a.l.i.n.d.a
        public File a() {
            File cacheDir = this.f3167a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f3168b != null ? new File(cacheDir, this.f3168b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
