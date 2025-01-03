package c.a.a.l.i.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class f implements c.a.a.l.i.m.c {
    public static final Bitmap.Config j = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    public final g f3134a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Bitmap.Config> f3135b;

    /* renamed from: c, reason: collision with root package name */
    public final b f3136c;

    /* renamed from: d, reason: collision with root package name */
    public int f3137d;

    /* renamed from: e, reason: collision with root package name */
    public int f3138e;

    /* renamed from: f, reason: collision with root package name */
    public int f3139f;

    /* renamed from: g, reason: collision with root package name */
    public int f3140g;

    /* renamed from: h, reason: collision with root package name */
    public int f3141h;

    /* renamed from: i, reason: collision with root package name */
    public int f3142i;

    /* compiled from: LruBitmapPool.java */
    public interface b {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    public static class c implements b {
        public c() {
        }

        @Override // c.a.a.l.i.m.f.b
        public void a(Bitmap bitmap) {
        }

        @Override // c.a.a.l.i.m.f.b
        public void b(Bitmap bitmap) {
        }
    }

    public f(int i2, g gVar, Set<Bitmap.Config> set) {
        this.f3137d = i2;
        this.f3134a = gVar;
        this.f3135b = set;
        this.f3136c = new c();
    }

    public static Set<Bitmap.Config> e() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static g f() {
        return Build.VERSION.SDK_INT >= 19 ? new i() : new c.a.a.l.i.m.a();
    }

    @Override // c.a.a.l.i.m.c
    public synchronized boolean a(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isMutable() && this.f3134a.b(bitmap) <= this.f3137d && this.f3135b.contains(bitmap.getConfig())) {
            int b2 = this.f3134a.b(bitmap);
            this.f3134a.a(bitmap);
            this.f3136c.b(bitmap);
            this.f3141h++;
            this.f3138e += b2;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f3134a.c(bitmap));
            }
            b();
            d();
            return true;
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f3134a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f3135b.contains(bitmap.getConfig()));
        }
        return false;
    }

    @Override // c.a.a.l.i.m.c
    @TargetApi(12)
    public synchronized Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap a2;
        a2 = this.f3134a.a(i2, i3, config != null ? config : j);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f3134a.b(i2, i3, config));
            }
            this.f3140g++;
        } else {
            this.f3139f++;
            this.f3138e -= this.f3134a.b(a2);
            this.f3136c.a(a2);
            if (Build.VERSION.SDK_INT >= 12) {
                a2.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f3134a.b(i2, i3, config));
        }
        b();
        return a2;
    }

    public final void c() {
        Log.v("LruBitmapPool", "Hits=" + this.f3139f + ", misses=" + this.f3140g + ", puts=" + this.f3141h + ", evictions=" + this.f3142i + ", currentSize=" + this.f3138e + ", maxSize=" + this.f3137d + "\nStrategy=" + this.f3134a);
    }

    public final void d() {
        b(this.f3137d);
    }

    public f(int i2) {
        this(i2, f(), e());
    }

    public final synchronized void b(int i2) {
        while (this.f3138e > i2) {
            Bitmap a2 = this.f3134a.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.f3138e = 0;
                return;
            }
            this.f3136c.a(a2);
            this.f3138e -= this.f3134a.b(a2);
            a2.recycle();
            this.f3142i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f3134a.c(a2));
            }
            b();
        }
    }

    @Override // c.a.a.l.i.m.c
    public synchronized Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap b2;
        b2 = b(i2, i3, config);
        if (b2 != null) {
            b2.eraseColor(0);
        }
        return b2;
    }

    @Override // c.a.a.l.i.m.c
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @Override // c.a.a.l.i.m.c
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 60) {
            a();
        } else if (i2 >= 40) {
            b(this.f3137d / 2);
        }
    }

    public final void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }
}
