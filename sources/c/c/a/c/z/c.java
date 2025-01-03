package c.c.a.c.z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import c.c.a.c.w.m;

/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
public class c extends c.c.a.c.w.h {
    public final RectF A;
    public int B;
    public final Paint z;

    public c() {
        this(null);
    }

    public boolean D() {
        return !this.A.isEmpty();
    }

    public void E() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void F() {
        this.z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(-1);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void a(float f2, float f3, float f4, float f5) {
        RectF rectF = this.A;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        this.A.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        g(canvas);
        super.draw(canvas);
        canvas.drawRect(this.A, this.z);
        f(canvas);
    }

    public final void f(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.B);
    }

    public final void g(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!a(callback)) {
            h(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public final void h(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    public c(m mVar) {
        super(mVar == null ? new m() : mVar);
        this.z = new Paint(1);
        F();
        this.A = new RectF();
    }

    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
