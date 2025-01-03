package a.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: i, reason: collision with root package name */
    public static x f607i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, a.e.h<ColorStateList>> f608a;

    /* renamed from: b, reason: collision with root package name */
    public a.e.g<String, e> f609b;

    /* renamed from: c, reason: collision with root package name */
    public a.e.h<String> f610c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, a.e.d<WeakReference<Drawable.ConstantState>>> f611d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f612e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f613f;

    /* renamed from: g, reason: collision with root package name */
    public f f614g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f606h = PorterDuff.Mode.SRC_IN;
    public static final c j = new c(6);

    /* compiled from: ResourceManagerInternal.java */
    public static class a implements e {
        @Override // a.b.f.x.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.b.c.a.a.e(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class b implements e {
        @Override // a.b.f.x.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.u.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class c extends a.e.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        public static int b(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
            return b(Integer.valueOf(b(i2, mode)));
        }

        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((c) Integer.valueOf(b(i2, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class d implements e {
        @Override // a.b.f.x.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    public interface f {
        ColorStateList a(Context context, int i2);

        PorterDuff.Mode a(int i2);

        Drawable a(x xVar, Context context, int i2);

        boolean a(Context context, int i2, Drawable drawable);

        boolean b(Context context, int i2, Drawable drawable);
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class g implements e {
        @Override // a.b.f.x.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.u.a.a.i.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            if (f607i == null) {
                x xVar2 = new x();
                f607i = xVar2;
                a(xVar2);
            }
            xVar = f607i;
        }
        return xVar;
    }

    public synchronized Drawable b(Context context, int i2) {
        return a(context, i2, false);
    }

    public synchronized ColorStateList c(Context context, int i2) {
        ColorStateList d2;
        d2 = d(context, i2);
        if (d2 == null) {
            d2 = this.f614g == null ? null : this.f614g.a(context, i2);
            if (d2 != null) {
                a(context, i2, d2);
            }
        }
        return d2;
    }

    public final ColorStateList d(Context context, int i2) {
        a.e.h<ColorStateList> hVar;
        WeakHashMap<Context, a.e.h<ColorStateList>> weakHashMap = this.f608a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.a(i2);
    }

    public final Drawable e(Context context, int i2) {
        int next;
        a.e.g<String, e> gVar = this.f609b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        a.e.h<String> hVar = this.f610c;
        if (hVar != null) {
            String a2 = hVar.a(i2);
            if ("appcompat_skip_skip".equals(a2) || (a2 != null && this.f609b.get(a2) == null)) {
                return null;
            }
        } else {
            this.f610c = new a.e.h<>();
        }
        if (this.f612e == null) {
            this.f612e = new TypedValue();
        }
        TypedValue typedValue = this.f612e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a3 = a(typedValue);
        Drawable a4 = a(context, a3);
        if (a4 != null) {
            return a4;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f610c.a(i2, name);
                e eVar = this.f609b.get(name);
                if (eVar != null) {
                    a4 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a4 != null) {
                    a4.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a3, a4);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (a4 == null) {
            this.f610c.a(i2, "appcompat_skip_skip");
        }
        return a4;
    }

    public synchronized void b(Context context) {
        a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f611d.get(context);
        if (dVar != null) {
            dVar.a();
        }
    }

    public static void a(x xVar) {
        if (Build.VERSION.SDK_INT < 24) {
            xVar.a("vector", new g());
            xVar.a("animated-vector", new b());
            xVar.a("animated-selector", new a());
            xVar.a("drawable", new d());
        }
    }

    public synchronized void a(f fVar) {
        this.f614g = fVar;
    }

    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable e2;
        a(context);
        e2 = e(context, i2);
        if (e2 == null) {
            e2 = a(context, i2);
        }
        if (e2 == null) {
            e2 = a.h.b.a.c(context, i2);
        }
        if (e2 != null) {
            e2 = a(context, i2, z, e2);
        }
        if (e2 != null) {
            r.b(e2);
        }
        return e2;
    }

    public static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public final Drawable a(Context context, int i2) {
        if (this.f612e == null) {
            this.f612e = new TypedValue();
        }
        TypedValue typedValue = this.f612e;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        f fVar = this.f614g;
        Drawable a4 = fVar == null ? null : fVar.a(this, context, i2);
        if (a4 != null) {
            a4.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a4);
        }
        return a4;
    }

    public final Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null) {
            if (r.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = a.h.c.l.a.i(drawable);
            a.h.c.l.a.a(i3, c2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return i3;
            }
            a.h.c.l.a.a(i3, a2);
            return i3;
        }
        f fVar = this.f614g;
        if ((fVar == null || !fVar.b(context, i2, drawable)) && !a(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    public final synchronized Drawable a(Context context, long j2) {
        a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f611d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> a2 = dVar.a(j2);
        if (a2 != null) {
            Drawable.ConstantState constantState = a2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.c(j2);
        }
        return null;
    }

    public final synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f611d.get(context);
        if (dVar == null) {
            dVar = new a.e.d<>();
            this.f611d.put(context, dVar);
        }
        dVar.c(j2, new WeakReference<>(constantState));
        return true;
    }

    public synchronized Drawable a(Context context, l0 l0Var, int i2) {
        Drawable e2 = e(context, i2);
        if (e2 == null) {
            e2 = l0Var.a(i2);
        }
        if (e2 == null) {
            return null;
        }
        return a(context, i2, false, e2);
    }

    public boolean a(Context context, int i2, Drawable drawable) {
        f fVar = this.f614g;
        return fVar != null && fVar.a(context, i2, drawable);
    }

    public final void a(String str, e eVar) {
        if (this.f609b == null) {
            this.f609b = new a.e.g<>();
        }
        this.f609b.put(str, eVar);
    }

    public PorterDuff.Mode a(int i2) {
        f fVar = this.f614g;
        if (fVar == null) {
            return null;
        }
        return fVar.a(i2);
    }

    public final void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.f608a == null) {
            this.f608a = new WeakHashMap<>();
        }
        a.e.h<ColorStateList> hVar = this.f608a.get(context);
        if (hVar == null) {
            hVar = new a.e.h<>();
            this.f608a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    public static void a(Drawable drawable, e0 e0Var, int[] iArr) {
        if (r.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!e0Var.f472d && !e0Var.f471c) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(a(e0Var.f472d ? e0Var.f469a : null, e0Var.f471c ? e0Var.f470b : f606h, iArr));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (x.class) {
            a2 = j.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                j.a(i2, mode, a2);
            }
        }
        return a2;
    }

    public final void a(Context context) {
        if (this.f613f) {
            return;
        }
        this.f613f = true;
        Drawable b2 = b(context, R$drawable.abc_vector_test);
        if (b2 == null || !a(b2)) {
            this.f613f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public static boolean a(Drawable drawable) {
        return (drawable instanceof a.u.a.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
