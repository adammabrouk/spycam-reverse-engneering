package c.a.a.p.h;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: SquaringDrawable.java */
/* loaded from: classes.dex */
public class i extends c.a.a.l.k.f.b {

    /* renamed from: a, reason: collision with root package name */
    public c.a.a.l.k.f.b f3432a;

    /* renamed from: b, reason: collision with root package name */
    public a f3433b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3434c;

    /* compiled from: SquaringDrawable.java */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f3435a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3436b;

        public a(a aVar) {
            this(aVar.f3435a, aVar.f3436b);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public a(Drawable.ConstantState constantState, int i2) {
            this.f3435a = constantState;
            this.f3436b = i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this, null, resources);
        }
    }

    public i(c.a.a.l.k.f.b bVar, int i2) {
        this(new a(bVar.getConstantState(), i2), bVar, null);
    }

    @Override // c.a.a.l.k.f.b
    public boolean a() {
        return this.f3432a.a();
    }

    @Override // c.a.a.l.k.f.b
    public void b(int i2) {
        this.f3432a.b(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f3432a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3432a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.f3432a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.f3432a.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f3432a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f3433b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f3432a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3433b.f3436b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3433b.f3436b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f3432a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f3432a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f3432a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f3432a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f3432a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3432a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f3434c && super.mutate() == this) {
            this.f3432a = (c.a.a.l.k.f.b) this.f3432a.mutate();
            this.f3433b = new a(this.f3433b);
            this.f3434c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f3432a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3432a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f3432a.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f3432a.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.f3432a.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f3432a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f3432a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f3432a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f3432a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3432a.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f3432a.unscheduleSelf(runnable);
    }

    public i(a aVar, c.a.a.l.k.f.b bVar, Resources resources) {
        this.f3433b = aVar;
        if (bVar != null) {
            this.f3432a = bVar;
        } else if (resources != null) {
            this.f3432a = (c.a.a.l.k.f.b) aVar.f3435a.newDrawable(resources);
        } else {
            this.f3432a = (c.a.a.l.k.f.b) aVar.f3435a.newDrawable();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3432a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f3432a.setBounds(rect);
    }
}
