package c.c.a.c.v;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* compiled from: ShadowRenderer.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5635i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f5636a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f5637b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f5638c;

    /* renamed from: d, reason: collision with root package name */
    public int f5639d;

    /* renamed from: e, reason: collision with root package name */
    public int f5640e;

    /* renamed from: f, reason: collision with root package name */
    public int f5641f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f5642g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f5643h;

    public a() {
        this(-16777216);
    }

    public void a(int i2) {
        this.f5639d = a.h.c.a.c(i2, 68);
        this.f5640e = a.h.c.a.c(i2, 20);
        this.f5641f = a.h.c.a.c(i2, 0);
        this.f5636a.setColor(this.f5639d);
    }

    public a(int i2) {
        this.f5642g = new Path();
        this.f5643h = new Paint();
        this.f5636a = new Paint();
        a(i2);
        this.f5643h.setColor(0);
        Paint paint = new Paint(4);
        this.f5637b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f5638c = new Paint(this.f5637b);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f5635i;
        iArr[0] = this.f5641f;
        iArr[1] = this.f5640e;
        iArr[2] = this.f5639d;
        Paint paint = this.f5638c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, f5635i, j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f5638c);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f5642g;
        if (z) {
            int[] iArr = k;
            iArr[0] = 0;
            iArr[1] = this.f5641f;
            iArr[2] = this.f5640e;
            iArr[3] = this.f5639d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = k;
            iArr2[0] = 0;
            iArr2[1] = this.f5639d;
            iArr2[2] = this.f5640e;
            iArr2[3] = this.f5641f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / width);
        float[] fArr = l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        this.f5637b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, k, l, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f5643h);
        }
        canvas.drawArc(rectF, f2, f3, true, this.f5637b);
        canvas.restore();
    }

    public Paint a() {
        return this.f5636a;
    }
}
