package a.d.a;

import a.d.a.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f645a = new RectF();

    /* compiled from: CardViewBaseImpl.java */
    public class a implements g.a {
        public a() {
        }

        @Override // a.d.a.g.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            float f3 = 2.0f * f2;
            float width = (rectF.width() - f3) - 1.0f;
            float height = (rectF.height() - f3) - 1.0f;
            if (f2 >= 1.0f) {
                float f4 = f2 + 0.5f;
                float f5 = -f4;
                c.this.f645a.set(f5, f5, f4, f4);
                int save = canvas.save();
                canvas.translate(rectF.left + f4, rectF.top + f4);
                canvas.drawArc(c.this.f645a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f645a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f645a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f645a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f6 = (rectF.left + f4) - 1.0f;
                float f7 = rectF.top;
                canvas.drawRect(f6, f7, (rectF.right - f4) + 1.0f, f7 + f4, paint);
                float f8 = (rectF.left + f4) - 1.0f;
                float f9 = rectF.bottom;
                canvas.drawRect(f8, f9 - f4, (rectF.right - f4) + 1.0f, f9, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
        }
    }

    @Override // a.d.a.e
    public void a() {
        g.r = new a();
    }

    @Override // a.d.a.e
    public ColorStateList b(d dVar) {
        return j(dVar).b();
    }

    @Override // a.d.a.e
    public float c(d dVar) {
        return j(dVar).g();
    }

    @Override // a.d.a.e
    public void d(d dVar) {
        Rect rect = new Rect();
        j(dVar).b(rect);
        dVar.a((int) Math.ceil(g(dVar)), (int) Math.ceil(f(dVar)));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // a.d.a.e
    public float e(d dVar) {
        return j(dVar).c();
    }

    @Override // a.d.a.e
    public float f(d dVar) {
        return j(dVar).e();
    }

    @Override // a.d.a.e
    public float g(d dVar) {
        return j(dVar).f();
    }

    @Override // a.d.a.e
    public void h(d dVar) {
    }

    @Override // a.d.a.e
    public void i(d dVar) {
        j(dVar).a(dVar.b());
        d(dVar);
    }

    public final g j(d dVar) {
        return (g) dVar.d();
    }

    @Override // a.d.a.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        g a2 = a(context, colorStateList, f2, f3, f4);
        a2.a(dVar.b());
        dVar.a(a2);
        d(dVar);
    }

    @Override // a.d.a.e
    public void b(d dVar, float f2) {
        j(dVar).c(f2);
    }

    @Override // a.d.a.e
    public void c(d dVar, float f2) {
        j(dVar).b(f2);
        d(dVar);
    }

    public final g a(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new g(context.getResources(), colorStateList, f2, f3, f4);
    }

    @Override // a.d.a.e
    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).b(colorStateList);
    }

    @Override // a.d.a.e
    public void a(d dVar, float f2) {
        j(dVar).a(f2);
        d(dVar);
    }

    @Override // a.d.a.e
    public float a(d dVar) {
        return j(dVar).d();
    }
}
