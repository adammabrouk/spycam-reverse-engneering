package a.b.f;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
public class l extends j {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f528d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f529e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f530f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f531g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f532h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f533i;

    public l(SeekBar seekBar) {
        super(seekBar);
        this.f530f = null;
        this.f531g = null;
        this.f532h = false;
        this.f533i = false;
        this.f528d = seekBar;
    }

    @Override // a.b.f.j
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        g0 a2 = g0.a(this.f528d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f528d;
        a.h.j.y.a(seekBar, seekBar.getContext(), R$styleable.AppCompatSeekBar, attributeSet, a2.a(), i2, 0);
        Drawable c2 = a2.c(R$styleable.AppCompatSeekBar_android_thumb);
        if (c2 != null) {
            this.f528d.setThumb(c2);
        }
        b(a2.b(R$styleable.AppCompatSeekBar_tickMark));
        if (a2.g(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f531g = r.a(a2.d(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f531g);
            this.f533i = true;
        }
        if (a2.g(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f530f = a2.a(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f532h = true;
        }
        a2.b();
        c();
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f529e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f529e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f528d);
            a.h.c.l.a.a(drawable, a.h.j.y.q(this.f528d));
            if (drawable.isStateful()) {
                drawable.setState(this.f528d.getDrawableState());
            }
            c();
        }
        this.f528d.invalidate();
    }

    public final void c() {
        if (this.f529e != null) {
            if (this.f532h || this.f533i) {
                Drawable i2 = a.h.c.l.a.i(this.f529e.mutate());
                this.f529e = i2;
                if (this.f532h) {
                    a.h.c.l.a.a(i2, this.f530f);
                }
                if (this.f533i) {
                    a.h.c.l.a.a(this.f529e, this.f531g);
                }
                if (this.f529e.isStateful()) {
                    this.f529e.setState(this.f528d.getDrawableState());
                }
            }
        }
    }

    public void d() {
        Drawable drawable = this.f529e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f528d.getDrawableState())) {
            this.f528d.invalidateDrawable(drawable);
        }
    }

    public void e() {
        Drawable drawable = this.f529e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void a(Canvas canvas) {
        if (this.f529e != null) {
            int max = this.f528d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f529e.getIntrinsicWidth();
                int intrinsicHeight = this.f529e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f529e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f528d.getWidth() - this.f528d.getPaddingLeft()) - this.f528d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f528d.getPaddingLeft(), this.f528d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f529e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
