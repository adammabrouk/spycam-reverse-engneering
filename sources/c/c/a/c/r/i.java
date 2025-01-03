package c.c.a.c.r;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* compiled from: StaticLayoutBuilderCompat.java */
/* loaded from: classes.dex */
public final class i {
    public static boolean k;
    public static Constructor<StaticLayout> l;
    public static Object m;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f5568a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f5569b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5570c;

    /* renamed from: e, reason: collision with root package name */
    public int f5572e;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5576i;

    /* renamed from: d, reason: collision with root package name */
    public int f5571d = 0;

    /* renamed from: f, reason: collision with root package name */
    public Layout.Alignment f5573f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    public int f5574g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5575h = true;
    public TextUtils.TruncateAt j = null;

    /* compiled from: StaticLayoutBuilderCompat.java */
    public static class a extends Exception {
        public a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    public i(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f5568a = charSequence;
        this.f5569b = textPaint;
        this.f5570c = i2;
        this.f5572e = charSequence.length();
    }

    public static i a(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new i(charSequence, textPaint, i2);
    }

    public final void b() throws a {
        Class<?> cls;
        if (k) {
            return;
        }
        try {
            boolean z = this.f5576i && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                m = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = i.class.getClassLoader();
                String str = this.f5576i ? "RTL" : "LTR";
                Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                m = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            l = declaredConstructor;
            declaredConstructor.setAccessible(true);
            k = true;
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public i a(Layout.Alignment alignment) {
        this.f5573f = alignment;
        return this;
    }

    public i a(boolean z) {
        this.f5575h = z;
        return this;
    }

    public i a(int i2) {
        this.f5574g = i2;
        return this;
    }

    public i a(TextUtils.TruncateAt truncateAt) {
        this.j = truncateAt;
        return this;
    }

    public StaticLayout a() throws a {
        if (this.f5568a == null) {
            this.f5568a = "";
        }
        int max = Math.max(0, this.f5570c);
        CharSequence charSequence = this.f5568a;
        if (this.f5574g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f5569b, max, this.j);
        }
        this.f5572e = Math.min(charSequence.length(), this.f5572e);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f5576i) {
                this.f5573f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f5571d, this.f5572e, this.f5569b, max);
            obtain.setAlignment(this.f5573f);
            obtain.setIncludePad(this.f5575h);
            obtain.setTextDirection(this.f5576i ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.j;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f5574g);
            return obtain.build();
        }
        b();
        try {
            Constructor<StaticLayout> constructor = l;
            a.h.i.h.a(constructor);
            Object obj = m;
            a.h.i.h.a(obj);
            return constructor.newInstance(charSequence, Integer.valueOf(this.f5571d), Integer.valueOf(this.f5572e), this.f5569b, Integer.valueOf(max), this.f5573f, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f5575h), null, Integer.valueOf(max), Integer.valueOf(this.f5574g));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public i b(boolean z) {
        this.f5576i = z;
        return this;
    }
}
