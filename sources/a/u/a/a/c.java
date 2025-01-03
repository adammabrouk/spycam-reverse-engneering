package a.u.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c extends h implements a.u.a.a.b {

    /* renamed from: b, reason: collision with root package name */
    public b f1927b;

    /* renamed from: c, reason: collision with root package name */
    public Context f1928c;

    /* renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f1929d;

    /* renamed from: e, reason: collision with root package name */
    public final Drawable.Callback f1930e;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            c.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f1932a;

        /* renamed from: b, reason: collision with root package name */
        public i f1933b;

        /* renamed from: c, reason: collision with root package name */
        public AnimatorSet f1934c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f1935d;

        /* renamed from: e, reason: collision with root package name */
        public a.e.a<Animator, String> f1936e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f1932a = bVar.f1932a;
                i iVar = bVar.f1933b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f1933b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f1933b = (i) constantState.newDrawable();
                    }
                    i iVar2 = this.f1933b;
                    iVar2.mutate();
                    i iVar3 = iVar2;
                    this.f1933b = iVar3;
                    iVar3.setCallback(callback);
                    this.f1933b.setBounds(bVar.f1933b.getBounds());
                    this.f1933b.a(false);
                }
                ArrayList<Animator> arrayList = bVar.f1935d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f1935d = new ArrayList<>(size);
                    this.f1936e = new a.e.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f1935d.get(i2);
                        Animator clone = animator.clone();
                        String str = bVar.f1936e.get(animator);
                        clone.setTarget(this.f1933b.a(str));
                        this.f1935d.add(clone);
                        this.f1936e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f1934c == null) {
                this.f1934c = new AnimatorSet();
            }
            this.f1934c.playTogether(this.f1935d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1932a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public c() {
        this(null, null, null);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    @Override // a.u.a.a.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            return a.h.c.l.a.a(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f1927b.f1933b.draw(canvas);
        if (this.f1927b.f1934c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.c(drawable) : this.f1927b.f1933b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1927b.f1932a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.d(drawable) : this.f1927b.f1933b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1942a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0056c(this.f1942a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f1927b.f1933b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f1927b.f1933b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getOpacity() : this.f1927b.f1933b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.u.a.a.a.f1922e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a3 = i.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.f1930e);
                        i iVar = this.f1927b.f1933b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f1927b.f1933b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.u.a.a.a.f1923f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1928c;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        a(string, e.a(context, resourceId2));
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f1927b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.f(drawable) : this.f1927b.f1933b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f1942a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f1927b.f1934c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.isStateful() : this.f1927b.f1933b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1927b.f1933b.setBounds(rect);
        }
    }

    @Override // a.u.a.a.h, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.setLevel(i2) : this.f1927b.f1933b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.setState(iArr) : this.f1927b.f1933b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f1927b.f1933b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, z);
        } else {
            this.f1927b.f1933b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1927b.f1933b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.b(drawable, i2);
        } else {
            this.f1927b.f1933b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, colorStateList);
        } else {
            this.f1927b.f1933b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, mode);
        } else {
            this.f1927b.f1933b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1927b.f1933b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f1927b.f1934c.isStarted()) {
                return;
            }
            this.f1927b.f1934c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1927b.f1934c.end();
        }
    }

    public c(Context context) {
        this(context, null, null);
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.u.a.a.c$c, reason: collision with other inner class name */
    public static class C0056c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f1937a;

        public C0056c(Drawable.ConstantState constantState) {
            this.f1937a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1937a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1937a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f1937a.newDrawable();
            cVar.f1942a = newDrawable;
            newDrawable.setCallback(cVar.f1930e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f1937a.newDrawable(resources);
            cVar.f1942a = newDrawable;
            newDrawable.setCallback(cVar.f1930e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f1937a.newDrawable(resources, theme);
            cVar.f1942a = newDrawable;
            newDrawable.setCallback(cVar.f1930e);
            return cVar;
        }
    }

    public c(Context context, b bVar, Resources resources) {
        this.f1929d = null;
        this.f1930e = new a();
        this.f1928c = context;
        if (bVar != null) {
            this.f1927b = bVar;
        } else {
            this.f1927b = new b(context, bVar, this.f1930e, resources);
        }
    }

    public final void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                a(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f1929d == null) {
                    this.f1929d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f1929d);
            }
        }
    }

    public final void a(String str, Animator animator) {
        animator.setTarget(this.f1927b.f1933b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        b bVar = this.f1927b;
        if (bVar.f1935d == null) {
            bVar.f1935d = new ArrayList<>();
            this.f1927b.f1936e = new a.e.a<>();
        }
        this.f1927b.f1935d.add(animator);
        this.f1927b.f1936e.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
