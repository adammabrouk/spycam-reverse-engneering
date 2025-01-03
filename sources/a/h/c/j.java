package a.h.c;

import a.h.b.d.c;
import a.h.g.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.viewpager.widget.ViewPager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, c.b> f998a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    public class a implements c<f.b> {
        public a(j jVar) {
        }

        @Override // a.h.c.j.c
        public int a(f.b bVar) {
            return bVar.d();
        }

        @Override // a.h.c.j.c
        public boolean b(f.b bVar) {
            return bVar.e();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    public class b implements c<c.C0017c> {
        public b(j jVar) {
        }

        @Override // a.h.c.j.c
        public int a(c.C0017c c0017c) {
            return c0017c.e();
        }

        @Override // a.h.c.j.c
        public boolean b(c.C0017c c0017c) {
            return c0017c.f();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T a(T[] tArr, int i2, c<T> cVar) {
        int i3 = (i2 & 1) == 0 ? ViewPager.MIN_FLING_VELOCITY : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i3) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    public static long b(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    public f.b a(f.b[] bVarArr, int i2) {
        return (f.b) a(bVarArr, i2, new a(this));
    }

    public Typeface a(Context context, InputStream inputStream) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (k.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i2).c());
            try {
                Typeface a2 = a(context, inputStream);
                k.a(inputStream);
                return a2;
            } catch (IOException unused) {
                k.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                k.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final c.C0017c a(c.b bVar, int i2) {
        return (c.C0017c) a(bVar.a(), i2, new b(this));
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0017c a2 = a(bVar, i2);
        if (a2 == null) {
            return null;
        }
        Typeface a3 = d.a(context, resources, a2.b(), a2.a(), i2);
        a(a3, bVar);
        return a3;
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (k.a(a2, resources, i2)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public c.b a(Typeface typeface) {
        long b2 = b(typeface);
        if (b2 == 0) {
            return null;
        }
        return this.f998a.get(Long.valueOf(b2));
    }

    public final void a(Typeface typeface, c.b bVar) {
        long b2 = b(typeface);
        if (b2 != 0) {
            this.f998a.put(Long.valueOf(b2), bVar);
        }
    }
}
