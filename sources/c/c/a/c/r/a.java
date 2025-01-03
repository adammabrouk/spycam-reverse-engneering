package c.c.a.c.r;

import a.h.j.y;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import c.c.a.c.r.i;
import c.c.a.c.t.a;

/* compiled from: CollapsingTextHelper.java */
/* loaded from: classes.dex */
public final class a {
    public static final boolean Z;
    public static final Paint a0;
    public boolean A;
    public Bitmap B;
    public Paint C;
    public float D;
    public float E;
    public int[] F;
    public boolean G;
    public TimeInterpolator J;
    public TimeInterpolator K;
    public float L;
    public float M;
    public float N;
    public ColorStateList O;
    public float P;
    public float Q;
    public float R;
    public ColorStateList S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;

    /* renamed from: a, reason: collision with root package name */
    public final View f5529a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5530b;

    /* renamed from: c, reason: collision with root package name */
    public float f5531c;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public c.c.a.c.t.a v;
    public c.c.a.c.t.a w;
    public CharSequence x;
    public CharSequence y;
    public boolean z;

    /* renamed from: g, reason: collision with root package name */
    public int f5535g = 16;

    /* renamed from: h, reason: collision with root package name */
    public int f5536h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f5537i = 15.0f;
    public float j = 15.0f;
    public int Y = 1;
    public final TextPaint H = new TextPaint(129);
    public final TextPaint I = new TextPaint(this.H);

    /* renamed from: e, reason: collision with root package name */
    public final Rect f5533e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5532d = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f5534f = new RectF();

    /* compiled from: CollapsingTextHelper.java */
    /* renamed from: c.c.a.c.r.a$a, reason: collision with other inner class name */
    public class C0105a implements a.InterfaceC0107a {
        public C0105a() {
        }

        @Override // c.c.a.c.t.a.InterfaceC0107a
        public void a(Typeface typeface) {
            a.this.a(typeface);
        }
    }

    /* compiled from: CollapsingTextHelper.java */
    public class b implements a.InterfaceC0107a {
        public b() {
        }

        @Override // c.c.a.c.t.a.InterfaceC0107a
        public void a(Typeface typeface) {
            a.this.c(typeface);
        }
    }

    static {
        Z = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        a0 = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            a0.setColor(-65281);
        }
    }

    public a(View view) {
        this.f5529a = view;
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        u();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        u();
    }

    public void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            u();
        }
    }

    public void d(int i2) {
        if (this.f5535g != i2) {
            this.f5535g = i2;
            u();
        }
    }

    public void e(Typeface typeface) {
        boolean b2 = b(typeface);
        boolean d2 = d(typeface);
        if (b2 || d2) {
            u();
        }
    }

    public void f(float f2) {
        if (this.f5537i != f2) {
            this.f5537i = f2;
            u();
        }
    }

    public int g() {
        return this.f5536h;
    }

    public float h() {
        a(this.I);
        return -this.I.ascent();
    }

    public Typeface i() {
        Typeface typeface = this.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int j() {
        return a(this.l);
    }

    public final int k() {
        return a(this.k);
    }

    public int l() {
        return this.f5535g;
    }

    public float m() {
        b(this.I);
        return -this.I.ascent();
    }

    public Typeface n() {
        Typeface typeface = this.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float o() {
        return this.f5531c;
    }

    public int p() {
        return this.Y;
    }

    public CharSequence q() {
        return this.x;
    }

    public final boolean r() {
        return y.q(this.f5529a) == 1;
    }

    public final boolean s() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    public void t() {
        this.f5530b = this.f5533e.width() > 0 && this.f5533e.height() > 0 && this.f5532d.width() > 0 && this.f5532d.height() > 0;
    }

    public void u() {
        if (this.f5529a.getHeight() <= 0 || this.f5529a.getWidth() <= 0) {
            return;
        }
        a();
        c();
    }

    public final boolean v() {
        return (this.Y <= 1 || this.z || this.A) ? false : true;
    }

    public void g(float f2) {
        float a2 = a.h.e.a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f5531c) {
            this.f5531c = a2;
            c();
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (a(this.f5533e, i2, i3, i4, i5)) {
            return;
        }
        this.f5533e.set(i2, i3, i4, i5);
        this.G = true;
        t();
    }

    public void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            u();
        }
    }

    public final void h(float f2) {
        b(f2);
        boolean z = Z && this.D != 1.0f;
        this.A = z;
        if (z) {
            e();
        }
        y.N(this.f5529a);
    }

    public void c(int i2) {
        c.c.a.c.t.d dVar = new c.c.a.c.t.d(this.f5529a.getContext(), i2);
        ColorStateList colorStateList = dVar.f5609b;
        if (colorStateList != null) {
            this.k = colorStateList;
        }
        float f2 = dVar.f5608a;
        if (f2 != 0.0f) {
            this.f5537i = f2;
        }
        ColorStateList colorStateList2 = dVar.f5615h;
        if (colorStateList2 != null) {
            this.S = colorStateList2;
        }
        this.Q = dVar.f5616i;
        this.R = dVar.j;
        this.P = dVar.k;
        c.c.a.c.t.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        this.v = new c.c.a.c.t.a(new b(), dVar.b());
        dVar.a(this.f5529a.getContext(), this.v);
        u();
    }

    public final boolean d(Typeface typeface) {
        c.c.a.c.t.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        if (this.t == typeface) {
            return false;
        }
        this.t = typeface;
        return true;
    }

    public final void e(float f2) {
        this.V = f2;
        y.N(this.f5529a);
    }

    public ColorStateList f() {
        return this.l;
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (a(this.f5532d, i2, i3, i4, i5)) {
            return;
        }
        this.f5532d.set(i2, i3, i4, i5);
        this.G = true;
        t();
    }

    public final void e() {
        if (this.B != null || this.f5532d.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        a(0.0f);
        int width = this.T.getWidth();
        int height = this.T.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.T.draw(new Canvas(this.B));
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(RectF rectF, int i2, int i3) {
        this.z = a(this.x);
        rectF.left = a(i2, i3);
        rectF.top = this.f5533e.top;
        rectF.right = b(rectF, i2, i3);
        rectF.bottom = this.f5533e.top + h();
    }

    public final void d(float f2) {
        this.U = f2;
        y.N(this.f5529a);
    }

    public void b(Rect rect) {
        b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void d() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    public final float b(RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) + (b() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.z ? rectF.left + b() : this.f5533e.right : this.z ? this.f5533e.right : rectF.left + b();
    }

    public final float a(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) - (b() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.z ? this.f5533e.left : this.f5533e.right - b() : this.z ? this.f5533e.right - b() : this.f5533e.left;
    }

    public float b() {
        if (this.x == null) {
            return 0.0f;
        }
        a(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void e(int i2) {
        if (i2 != this.Y) {
            this.Y = i2;
            d();
            u();
        }
    }

    public final void a(TextPaint textPaint) {
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
    }

    public final void b(TextPaint textPaint) {
        textPaint.setTextSize(this.f5537i);
        textPaint.setTypeface(this.t);
    }

    public void a(int i2) {
        c.c.a.c.t.d dVar = new c.c.a.c.t.d(this.f5529a.getContext(), i2);
        ColorStateList colorStateList = dVar.f5609b;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = dVar.f5608a;
        if (f2 != 0.0f) {
            this.j = f2;
        }
        ColorStateList colorStateList2 = dVar.f5615h;
        if (colorStateList2 != null) {
            this.O = colorStateList2;
        }
        this.M = dVar.f5616i;
        this.N = dVar.j;
        this.L = dVar.k;
        c.c.a.c.t.a aVar = this.w;
        if (aVar != null) {
            aVar.a();
        }
        this.w = new c.c.a.c.t.a(new C0105a(), dVar.b());
        dVar.a(this.f5529a.getContext(), this.w);
        u();
    }

    public void b(int i2) {
        if (this.f5536h != i2) {
            this.f5536h = i2;
            u();
        }
    }

    public void c(Typeface typeface) {
        if (d(typeface)) {
            u();
        }
    }

    public final boolean b(Typeface typeface) {
        c.c.a.c.t.a aVar = this.w;
        if (aVar != null) {
            aVar.a();
        }
        if (this.s == typeface) {
            return false;
        }
        this.s = typeface;
        return true;
    }

    public final void c() {
        a(this.f5531c);
    }

    public final void c(float f2) {
        this.f5534f.left = a(this.f5532d.left, this.f5533e.left, f2, this.J);
        this.f5534f.top = a(this.m, this.n, f2, this.J);
        this.f5534f.right = a(this.f5532d.right, this.f5533e.right, f2, this.J);
        this.f5534f.bottom = a(this.f5532d.bottom, this.f5533e.bottom, f2, this.J);
    }

    public final void b(float f2) {
        boolean z;
        float f3;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.f5533e.width();
        float width2 = this.f5532d.width();
        if (a(f2, this.j)) {
            f3 = this.j;
            this.D = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f4 = this.f5537i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (a(f2, this.f5537i)) {
                this.D = 1.0f;
            } else {
                this.D = f2 / this.f5537i;
            }
            float f5 = this.j / this.f5537i;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.E != f3 || this.G || z2;
            this.E = f3;
            this.G = false;
        }
        if (this.y == null || z2) {
            this.H.setTextSize(this.E);
            this.H.setTypeface(this.u);
            this.H.setLinearText(this.D != 1.0f);
            this.z = a(this.x);
            StaticLayout a2 = a(v() ? this.Y : 1, width, this.z);
            this.T = a2;
            this.y = a2.getText();
        }
    }

    public void a(Typeface typeface) {
        if (b(typeface)) {
            u();
        }
    }

    public final boolean a(int[] iArr) {
        this.F = iArr;
        if (!s()) {
            return false;
        }
        u();
        return true;
    }

    public final void a(float f2) {
        c(f2);
        this.q = a(this.o, this.p, f2, this.J);
        this.r = a(this.m, this.n, f2, this.J);
        h(a(this.f5537i, this.j, f2, this.K));
        d(1.0f - a(0.0f, 1.0f, 1.0f - f2, c.c.a.c.a.a.f5307b));
        e(a(1.0f, 0.0f, f2, c.c.a.c.a.a.f5307b));
        if (this.l != this.k) {
            this.H.setColor(a(k(), j(), f2));
        } else {
            this.H.setColor(j());
        }
        this.H.setShadowLayer(a(this.P, this.L, f2, (TimeInterpolator) null), a(this.Q, this.M, f2, (TimeInterpolator) null), a(this.R, this.N, f2, (TimeInterpolator) null), a(a(this.S), a(this.O), f2));
        y.N(this.f5529a);
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            d();
            u();
        }
    }

    public final int a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.F;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final void a() {
        StaticLayout staticLayout;
        float f2 = this.E;
        b(this.j);
        CharSequence charSequence = this.y;
        if (charSequence != null && (staticLayout = this.T) != null) {
            this.X = TextUtils.ellipsize(charSequence, this.H, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.X;
        float measureText = charSequence2 != null ? this.H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int a2 = a.h.j.e.a(this.f5536h, this.z ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.n = this.f5533e.top;
        } else if (i2 != 80) {
            this.n = this.f5533e.centerY() - ((this.H.descent() - this.H.ascent()) / 2.0f);
        } else {
            this.n = this.f5533e.bottom + this.H.ascent();
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.p = this.f5533e.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.p = this.f5533e.left;
        } else {
            this.p = this.f5533e.right - measureText;
        }
        b(this.f5537i);
        float height = this.T != null ? r1.getHeight() : 0.0f;
        CharSequence charSequence3 = this.y;
        float measureText2 = charSequence3 != null ? this.H.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.T;
        if (staticLayout2 != null && this.Y > 1 && !this.z) {
            measureText2 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.T;
        this.W = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int a3 = a.h.j.e.a(this.f5535g, this.z ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.m = this.f5532d.top;
        } else if (i4 != 80) {
            this.m = this.f5532d.centerY() - (height / 2.0f);
        } else {
            this.m = (this.f5532d.bottom - height) + this.H.descent();
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.o = this.f5532d.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.o = this.f5532d.left;
        } else {
            this.o = this.f5532d.right - measureText2;
        }
        d();
        h(f2);
    }

    public void a(Canvas canvas) {
        int save = canvas.save();
        if (this.y == null || !this.f5530b) {
            return;
        }
        boolean z = false;
        float lineLeft = (this.q + this.T.getLineLeft(0)) - (this.W * 2.0f);
        this.H.setTextSize(this.E);
        float f2 = this.q;
        float f3 = this.r;
        if (this.A && this.B != null) {
            z = true;
        }
        float f4 = this.D;
        if (f4 != 1.0f) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (z) {
            canvas.drawBitmap(this.B, f2, f3, this.C);
            canvas.restoreToCount(save);
            return;
        }
        if (v()) {
            a(canvas, lineLeft, f3);
        } else {
            canvas.translate(f2, f3);
            this.T.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public final void a(Canvas canvas, float f2, float f3) {
        int alpha = this.H.getAlpha();
        canvas.translate(f2, f3);
        float f4 = alpha;
        this.H.setAlpha((int) (this.V * f4));
        this.T.draw(canvas);
        this.H.setAlpha((int) (this.U * f4));
        int lineBaseline = this.T.getLineBaseline(0);
        CharSequence charSequence = this.X;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.H);
        String trim = this.X.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.H.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.T.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.H);
    }

    public final boolean a(CharSequence charSequence) {
        return (r() ? a.h.h.e.f1096d : a.h.h.e.f1095c).a(charSequence, 0, charSequence.length());
    }

    public final StaticLayout a(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        try {
            i a2 = i.a(this.x, this.H, (int) f2);
            a2.a(TextUtils.TruncateAt.END);
            a2.b(z);
            a2.a(Layout.Alignment.ALIGN_NORMAL);
            a2.a(false);
            a2.a(i2);
            staticLayout = a2.a();
        } catch (i.a e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        a.h.i.h.a(staticLayout);
        return staticLayout;
    }

    public static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    public static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.c.a.c.a.a.a(f2, f3, f4);
    }

    public static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
