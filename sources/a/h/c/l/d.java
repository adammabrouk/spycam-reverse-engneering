package a.h.c.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
public class d extends Drawable implements Drawable.Callback, c, b {

    /* renamed from: g, reason: collision with root package name */
    public static final PorterDuff.Mode f1003g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f1004a;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f1005b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1006c;

    /* renamed from: d, reason: collision with root package name */
    public f f1007d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1008e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1009f;

    public d(f fVar, Resources resources) {
        this.f1007d = fVar;
        a(resources);
    }

    public final void a(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f1007d;
        if (fVar == null || (constantState = fVar.f1012b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    public boolean b() {
        return true;
    }

    public final f c() {
        return new f(this.f1007d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1009f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f1007d;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f1009f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f1007d;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f1007d.f1011a = getChangingConfigurations();
        return this.f1007d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1009f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1009f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1009f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.e(this.f1009f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1009f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1009f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1009f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1009f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1009f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1009f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.f(this.f1009f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!b() || (fVar = this.f1007d) == null) ? null : fVar.f1013c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1009f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1009f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1008e && super.mutate() == this) {
            this.f1007d = c();
            Drawable drawable = this.f1009f;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f1007d;
            if (fVar != null) {
                Drawable drawable2 = this.f1009f;
                fVar.f1012b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1008e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1009f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.a(this.f1009f, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        return this.f1009f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1009f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        a.a(this.f1009f, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f1009f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1009f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1009f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1009f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f1009f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1007d.f1013c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1007d.f1014d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1009f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        f fVar = this.f1007d;
        ColorStateList colorStateList = fVar.f1013c;
        PorterDuff.Mode mode = fVar.f1014d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1006c || colorForState != this.f1004a || mode != this.f1005b) {
                setColorFilter(colorForState, mode);
                this.f1004a = colorForState;
                this.f1005b = mode;
                this.f1006c = true;
                return true;
            }
        } else {
            this.f1006c = false;
            clearColorFilter();
        }
        return false;
    }

    public d(Drawable drawable) {
        this.f1007d = c();
        a(drawable);
    }

    @Override // a.h.c.l.c
    public final Drawable a() {
        return this.f1009f;
    }

    @Override // a.h.c.l.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1009f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1009f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f1007d;
            if (fVar != null) {
                fVar.f1012b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
