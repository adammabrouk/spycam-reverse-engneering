package a.d.a;

import a.d.a.g;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: CardViewApi17Impl.java */
/* loaded from: classes.dex */
public class a extends c {

    /* compiled from: CardViewApi17Impl.java */
    /* renamed from: a.d.a.a$a, reason: collision with other inner class name */
    public class C0010a implements g.a {
        public C0010a(a aVar) {
        }

        @Override // a.d.a.g.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    @Override // a.d.a.c, a.d.a.e
    public void a() {
        g.r = new C0010a(this);
    }
}
