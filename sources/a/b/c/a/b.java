package a.b.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import com.google.zxing.view.ViewfinderView;

/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public d f232a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f233b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f234c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f235d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f237f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f239h;

    /* renamed from: i, reason: collision with root package name */
    public Runnable f240i;
    public long j;
    public long k;
    public c l;

    /* renamed from: e, reason: collision with root package name */
    public int f236e = ViewfinderView.OPAQUE;

    /* renamed from: g, reason: collision with root package name */
    public int f238g = -1;

    /* compiled from: DrawableContainer.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: a.b.c.a.b$b, reason: collision with other inner class name */
    public static class C0004b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static Resources a(Resources.Theme theme) {
            return theme.getResources();
        }

        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    /* compiled from: DrawableContainer.java */
    public static class c implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        public Drawable.Callback f242a;

        public c a(Drawable.Callback callback) {
            this.f242a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f242a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f242a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f242a;
            this.f242a = null;
            return callback;
        }
    }

    public d a() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r10) {
        /*
            r9 = this;
            int r0 = r9.f238g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            a.b.c.a.b$d r0 = r9.f232a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f235d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f234c
            if (r0 == 0) goto L29
            r9.f235d = r0
            a.b.c.a.b$d r0 = r9.f232a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.k = r0
            goto L35
        L29:
            r9.f235d = r4
            r9.k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f234c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            a.b.c.a.b$d r0 = r9.f232a
            int r1 = r0.f250h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.a(r10)
            r9.f234c = r0
            r9.f238g = r10
            if (r0 == 0) goto L5a
            a.b.c.a.b$d r10 = r9.f232a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.j = r2
        L51:
            r9.a(r0)
            goto L5a
        L55:
            r9.f234c = r4
            r10 = -1
            r9.f238g = r10
        L5a:
            long r0 = r9.j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f240i
            if (r0 != 0) goto L73
            a.b.c.a.b$a r0 = new a.b.c.a.b$a
            r0.<init>()
            r9.f240i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.c.a.b.a(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f232a.a(theme);
    }

    public int b() {
        return this.f238g;
    }

    public final boolean c() {
        return isAutoMirrored() && a.h.c.l.a.e(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f232a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f234c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f235d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f236e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f232a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f232a.a()) {
            return null;
        }
        this.f232a.f246d = getChangingConfigurations();
        return this.f232a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f234c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f233b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f232a.m()) {
            return this.f232a.f();
        }
        Drawable drawable = this.f234c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f232a.m()) {
            return this.f232a.j();
        }
        Drawable drawable = this.f234c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f232a.m()) {
            return this.f232a.g();
        }
        Drawable drawable = this.f234c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f232a.m()) {
            return this.f232a.h();
        }
        Drawable drawable = this.f234c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f234c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f232a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f234c;
        if (drawable != null) {
            C0004b.a(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect i2 = this.f232a.i();
        if (i2 != null) {
            rect.set(i2);
            padding = (i2.right | ((i2.left | i2.top) | i2.bottom)) != 0;
        } else {
            Drawable drawable = this.f234c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (c()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f232a;
        if (dVar != null) {
            dVar.l();
        }
        if (drawable != this.f234c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f232a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f235d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f235d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f234c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f237f) {
                this.f234c.setAlpha(this.f236e);
            }
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (this.j != 0) {
            this.j = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f239h && super.mutate() == this) {
            d a2 = a();
            a2.n();
            a(a2);
            this.f239h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f235d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f234c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f232a.b(i2, b());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f235d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f234c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f235d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f234c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f234c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f237f && this.f236e == i2) {
            return;
        }
        this.f237f = true;
        this.f236e = i2;
        Drawable drawable = this.f234c;
        if (drawable != null) {
            if (this.j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        d dVar = this.f232a;
        if (dVar.C != z) {
            dVar.C = z;
            Drawable drawable = this.f234c;
            if (drawable != null) {
                a.h.c.l.a.a(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f232a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f234c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        d dVar = this.f232a;
        if (dVar.x != z) {
            dVar.x = z;
            Drawable drawable = this.f234c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f234c;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f233b;
        if (rect == null) {
            this.f233b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f234c;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f232a;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            a.h.c.l.a.a(this.f234c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f232a;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            a.h.c.l.a.a(this.f234c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f235d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f234c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f234c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* compiled from: DrawableContainer.java */
    public static abstract class d extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a, reason: collision with root package name */
        public final b f243a;

        /* renamed from: b, reason: collision with root package name */
        public Resources f244b;

        /* renamed from: c, reason: collision with root package name */
        public int f245c;

        /* renamed from: d, reason: collision with root package name */
        public int f246d;

        /* renamed from: e, reason: collision with root package name */
        public int f247e;

        /* renamed from: f, reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f248f;

        /* renamed from: g, reason: collision with root package name */
        public Drawable[] f249g;

        /* renamed from: h, reason: collision with root package name */
        public int f250h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f251i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public d(d dVar, b bVar, Resources resources) {
            this.f251i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f243a = bVar;
            this.f244b = resources != null ? resources : dVar != null ? dVar.f244b : null;
            int a2 = b.a(resources, dVar != null ? dVar.f245c : 0);
            this.f245c = a2;
            if (dVar == null) {
                this.f249g = new Drawable[10];
                this.f250h = 0;
                return;
            }
            this.f246d = dVar.f246d;
            this.f247e = dVar.f247e;
            this.v = true;
            this.w = true;
            this.f251i = dVar.f251i;
            this.l = dVar.l;
            this.x = dVar.x;
            this.y = dVar.y;
            this.z = dVar.z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
            if (dVar.f245c == a2) {
                if (dVar.j) {
                    this.k = dVar.k != null ? new Rect(dVar.k) : null;
                    this.j = true;
                }
                if (dVar.m) {
                    this.n = dVar.n;
                    this.o = dVar.o;
                    this.p = dVar.p;
                    this.q = dVar.q;
                    this.m = true;
                }
            }
            if (dVar.r) {
                this.s = dVar.s;
                this.r = true;
            }
            if (dVar.t) {
                this.u = dVar.u;
                this.t = true;
            }
            Drawable[] drawableArr = dVar.f249g;
            this.f249g = new Drawable[drawableArr.length];
            this.f250h = dVar.f250h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f248f;
            if (sparseArray != null) {
                this.f248f = sparseArray.clone();
            } else {
                this.f248f = new SparseArray<>(this.f250h);
            }
            int i2 = this.f250h;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                    if (constantState != null) {
                        this.f248f.put(i3, constantState);
                    } else {
                        this.f249g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        public final int a(Drawable drawable) {
            int i2 = this.f250h;
            if (i2 >= this.f249g.length) {
                a(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f243a);
            this.f249g[i2] = drawable;
            this.f250h++;
            this.f247e = drawable.getChangingConfigurations() | this.f247e;
            l();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public final Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                a.h.c.l.a.a(drawable, this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f243a);
            return mutate;
        }

        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f248f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f249g[this.f248f.keyAt(i2)] = b(this.f248f.valueAt(i2).newDrawable(this.f244b));
                }
                this.f248f = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f248f.get(i3);
                    if (constantState != null && C0004b.a(constantState)) {
                        return true;
                    }
                } else if (a.h.c.l.a.a(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.f249g.length;
        }

        public final int e() {
            return this.f250h;
        }

        public final int f() {
            if (!this.m) {
                b();
            }
            return this.o;
        }

        public final int g() {
            if (!this.m) {
                b();
            }
            return this.q;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f246d | this.f247e;
        }

        public final int h() {
            if (!this.m) {
                b();
            }
            return this.p;
        }

        public final Rect i() {
            Rect rect = null;
            if (this.f251i) {
                return null;
            }
            if (this.k != null || this.j) {
                return this.k;
            }
            c();
            Rect rect2 = new Rect();
            int i2 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect2)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect2.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect2.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect2.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect2.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.j = true;
            this.k = rect;
            return rect;
        }

        public final int j() {
            if (!this.m) {
                b();
            }
            return this.n;
        }

        public final int k() {
            if (this.r) {
                return this.s;
            }
            c();
            int i2 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void l() {
            this.r = false;
            this.t = false;
        }

        public final boolean m() {
            return this.l;
        }

        public abstract void n();

        public final boolean b(int i2, int i3) {
            int i4 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            boolean z = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean a2 = Build.VERSION.SDK_INT >= 23 ? a.h.c.l.a.a(drawableArr[i5], i2) : false;
                    if (i5 == i3) {
                        z = a2;
                    }
                }
            }
            this.z = i2;
            return z;
        }

        public final void c(int i2) {
            this.B = i2;
        }

        public final void b(boolean z) {
            this.f251i = z;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final Drawable a(int i2) {
            int indexOfKey;
            Drawable drawable = this.f249g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f248f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable b2 = b(this.f248f.valueAt(indexOfKey).newDrawable(this.f244b));
            this.f249g[i2] = b2;
            this.f248f.removeAt(indexOfKey);
            if (this.f248f.size() == 0) {
                this.f248f = null;
            }
            return b2;
        }

        public final void a(Resources resources) {
            if (resources != null) {
                this.f244b = resources;
                int a2 = b.a(resources, this.f245c);
                int i2 = this.f245c;
                this.f245c = a2;
                if (i2 != a2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public final void b(int i2) {
            this.A = i2;
        }

        public final void a(Resources.Theme theme) {
            if (theme != null) {
                c();
                int i2 = this.f250h;
                Drawable[] drawableArr = this.f249g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && a.h.c.l.a.a(drawableArr[i3])) {
                        a.h.c.l.a.a(drawableArr[i3], theme);
                        this.f247e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                a(C0004b.a(theme));
            }
        }

        public final void a(boolean z) {
            this.l = z;
        }

        public void a(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f249g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f249g = drawableArr;
        }

        public boolean a() {
            if (this.v) {
                return this.w;
            }
            c();
            this.v = true;
            int i2 = this.f250h;
            Drawable[] drawableArr = this.f249g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    public final void a(Drawable drawable) {
        if (this.l == null) {
            this.l = new c();
        }
        c cVar = this.l;
        cVar.a(drawable.getCallback());
        drawable.setCallback(cVar);
        try {
            if (this.f232a.A <= 0 && this.f237f) {
                drawable.setAlpha(this.f236e);
            }
            if (this.f232a.E) {
                drawable.setColorFilter(this.f232a.D);
            } else {
                if (this.f232a.H) {
                    a.h.c.l.a.a(drawable, this.f232a.F);
                }
                if (this.f232a.I) {
                    a.h.c.l.a.a(drawable, this.f232a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f232a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                a.h.c.l.a.a(drawable, a.h.c.l.a.e(this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                a.h.c.l.a.a(drawable, this.f232a.C);
            }
            Rect rect = this.f233b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                a.h.c.l.a.a(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.l.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f237f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f234c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f236e
            r3.setAlpha(r9)
            r13.j = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            a.b.c.a.b$d r9 = r13.f232a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f236e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.j = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f235d
            if (r9 == 0) goto L65
            long r10 = r13.k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f235d = r0
            r13.k = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            a.b.c.a.b$d r4 = r13.f232a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f236e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.k = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f240i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.c.a.b.a(boolean):void");
    }

    public final void a(Resources resources) {
        this.f232a.a(resources);
    }

    public void a(d dVar) {
        this.f232a = dVar;
        int i2 = this.f238g;
        if (i2 >= 0) {
            Drawable a2 = dVar.a(i2);
            this.f234c = a2;
            if (a2 != null) {
                a(a2);
            }
        }
        this.f235d = null;
    }

    public static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }
}
