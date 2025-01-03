package a.b.c.a;

import a.b.c.a.b;
import a.b.c.a.d;
import a.b.f.x;
import a.e.h;
import a.u.a.a.i;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends a.b.c.a.d implements a.h.c.l.b {
    public c o;
    public g p;
    public int q;
    public int r;
    public boolean t;

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Animatable f225a;

        public b(Animatable animatable) {
            super();
            this.f225a = animatable;
        }

        @Override // a.b.c.a.a.g
        public void c() {
            this.f225a.start();
        }

        @Override // a.b.c.a.a.g
        public void d() {
            this.f225a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class c extends d.a {
        public a.e.d<Long> K;
        public h<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new a.e.d<>();
                this.L = new h<>();
            }
        }

        public static long f(int i2, int i3) {
            return i3 | (i2 << 32);
        }

        public int a(int i2, int i3, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f2 = f(i2, i3);
            long j = z ? 8589934592L : 0L;
            long j2 = a2;
            this.K.a(f2, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(f(i3, i2), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        public int b(int[] iArr) {
            int a2 = super.a(iArr);
            return a2 >= 0 ? a2 : super.a(StateSet.WILD_CARD);
        }

        public int c(int i2, int i3) {
            return (int) this.K.b(f(i2, i3), -1L).longValue();
        }

        public int d(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.b(i2, 0).intValue();
        }

        public boolean e(int i2, int i3) {
            return (this.K.b(f(i2, i3), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // a.b.c.a.d.a, a.b.c.a.b.d
        public void n() {
            this.K = this.K.m0clone();
            this.L = this.L.m1clone();
        }

        @Override // a.b.c.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        public boolean d(int i2, int i3) {
            return (this.K.b(f(i2, i3), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // a.b.c.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        public int a(int[] iArr, Drawable drawable, int i2) {
            int a2 = super.a(iArr, drawable);
            this.L.c(a2, Integer.valueOf(i2));
            return a2;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        public final a.u.a.a.c f226a;

        public d(a.u.a.a.c cVar) {
            super();
            this.f226a = cVar;
        }

        @Override // a.b.c.a.a.g
        public void c() {
            this.f226a.start();
        }

        @Override // a.b.c.a.a.g
        public void d() {
            this.f226a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f227a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f228b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f228b = z2;
            this.f227a = ofInt;
        }

        @Override // a.b.c.a.a.g
        public boolean a() {
            return this.f228b;
        }

        @Override // a.b.c.a.a.g
        public void b() {
            this.f227a.reverse();
        }

        @Override // a.b.c.a.a.g
        public void c() {
            this.f227a.start();
        }

        @Override // a.b.c.a.a.g
        public void d() {
            this.f227a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.a(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public final boolean b(int i2) {
        int b2;
        int c2;
        g bVar;
        g gVar = this.p;
        if (gVar == null) {
            b2 = b();
        } else {
            if (i2 == this.q) {
                return true;
            }
            if (i2 == this.r && gVar.a()) {
                gVar.b();
                this.q = this.r;
                this.r = i2;
                return true;
            }
            b2 = this.q;
            gVar.d();
        }
        this.p = null;
        this.r = -1;
        this.q = -1;
        c cVar = this.o;
        int d2 = cVar.d(b2);
        int d3 = cVar.d(i2);
        if (d3 == 0 || d2 == 0 || (c2 = cVar.c(d2, d3)) < 0) {
            return false;
        }
        boolean e2 = cVar.e(d2, d3);
        a(c2);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.d(d2, d3), e2);
        } else {
            if (!(current instanceof a.u.a.a.c)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((a.u.a.a.c) current);
        }
        bVar.c();
        this.p = bVar;
        this.r = b2;
        this.q = i2;
        return true;
    }

    public final int c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable b2 = resourceId2 > 0 ? x.a().b(context, resourceId2) : null;
        a2.recycle();
        int[] a3 = a(attributeSet);
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            b2 = xmlPullParser.getName().equals("vector") ? i.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (b2 != null) {
            return this.o.a(a3, b2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final void d() {
        onStateChange(getState());
    }

    @Override // a.b.c.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.b.c.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.p;
        if (gVar != null) {
            gVar.d();
            this.p = null;
            a(this.q);
            this.q = -1;
            this.r = -1;
        }
    }

    @Override // a.b.c.a.d, a.b.c.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.o.n();
                this.t = true;
            }
        }
        return this;
    }

    @Override // a.b.c.a.d, a.b.c.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int b2 = this.o.b(iArr);
        boolean z = b2 != b() && (b(b2) || a(b2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // a.b.c.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.p != null && (visible || z2)) {
            if (z) {
                this.p.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.q = -1;
        this.r = -1;
        a(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public final int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable b2 = resourceId3 > 0 ? x.a().b(context, resourceId3) : null;
        boolean z = a2.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            b2 = xmlPullParser.getName().equals("animated-vector") ? a.u.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (b2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.o.a(resourceId, resourceId2, b2, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    public void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        b(context, resources, xmlPullParser, attributeSet, theme);
        d();
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        public int[] f229a;

        /* renamed from: b, reason: collision with root package name */
        public int f230b;

        /* renamed from: c, reason: collision with root package name */
        public int f231c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        public int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f230b = numberOfFrames;
            int[] iArr = this.f229a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f229a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f229a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f231c = i2;
            return i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * this.f231c) + 0.5f);
            int i3 = this.f230b;
            int[] iArr = this.f229a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (i4 / i3) + (i4 < i3 ? i2 / this.f231c : 0.0f);
        }

        public int a() {
            return this.f231c;
        }
    }

    public final void a(TypedArray typedArray) {
        c cVar = this.o;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f246d |= typedArray.getChangingConfigurations();
        }
        cVar.b(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f251i));
        cVar.a(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.l));
        cVar.b(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.c(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.x));
    }

    @Override // a.b.c.a.d, a.b.c.a.b
    public c a() {
        return new c(this.o, this, null);
    }

    @Override // a.b.c.a.d, a.b.c.a.b
    public void a(b.d dVar) {
        super.a(dVar);
        if (dVar instanceof c) {
            this.o = (c) dVar;
        }
    }

    public final void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    c(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }
}
