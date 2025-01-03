package a.h.c.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21.java */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: h, reason: collision with root package name */
    public static Method f1010h;

    public e(Drawable drawable) {
        super(drawable);
        d();
    }

    @Override // a.h.c.l.d
    public boolean b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1009f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void d() {
        if (f1010h == null) {
            try {
                f1010h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f1009f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f1009f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f1009f;
        if (drawable != null && (method = f1010h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f1009f.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f1009f.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // a.h.c.l.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // a.h.c.l.d, android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        if (b()) {
            super.setTint(i2);
        } else {
            this.f1009f.setTint(i2);
        }
    }

    @Override // a.h.c.l.d, android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f1009f.setTintList(colorStateList);
        }
    }

    @Override // a.h.c.l.d, android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f1009f.setTintMode(mode);
        }
    }

    public e(f fVar, Resources resources) {
        super(fVar, resources);
        d();
    }
}
