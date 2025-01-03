package a.u.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.shix.shixipc.activity.AddCameraActivity;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class g implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public float[] f1940a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f1941b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (a.h.b.d.g.a(xmlPullParser, "pathData")) {
            String a2 = a.h.b.d.g.a(typedArray, xmlPullParser, "pathData", 4);
            Path b2 = a.h.c.c.b(a2);
            if (b2 != null) {
                a(b2);
                return;
            }
            throw new InflateException("The path is null, which is created from " + a2);
        }
        if (!a.h.b.d.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!a.h.b.d.g.a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float a3 = a.h.b.d.g.a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float a4 = a.h.b.d.g.a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean a5 = a.h.b.d.g.a(xmlPullParser, "controlX2");
        if (a5 != a.h.b.d.g.a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (a5) {
            a(a3, a4, a.h.b.d.g.a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), a.h.b.d.g.a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            a(a3, a4);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f1940a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f1940a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f1940a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f1941b[i2];
        }
        float f4 = (f2 - fArr[i2]) / f3;
        float[] fArr2 = this.f1941b;
        float f5 = fArr2[i2];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.l);
        a(a2, xmlPullParser);
        a2.recycle();
    }

    public final void a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        a(path);
    }

    public final void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        a(path);
    }

    public final void a(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(AddCameraActivity.SEARCH_TIME, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f1940a = new float[min];
            this.f1941b = new float[min];
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < min; i3++) {
                pathMeasure.getPosTan((i3 * length) / (min - 1), fArr, null);
                this.f1940a[i3] = fArr[0];
                this.f1941b[i3] = fArr[1];
            }
            if (Math.abs(this.f1940a[0]) <= 1.0E-5d && Math.abs(this.f1941b[0]) <= 1.0E-5d) {
                int i4 = min - 1;
                if (Math.abs(this.f1940a[i4] - 1.0f) <= 1.0E-5d && Math.abs(this.f1941b[i4] - 1.0f) <= 1.0E-5d) {
                    float f2 = 0.0f;
                    int i5 = 0;
                    while (i2 < min) {
                        float[] fArr2 = this.f1940a;
                        int i6 = i5 + 1;
                        float f3 = fArr2[i5];
                        if (f3 >= f2) {
                            fArr2[i2] = f3;
                            i2++;
                            f2 = f3;
                            i5 = i6;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f1940a[0]);
            sb.append(",");
            sb.append(this.f1941b[0]);
            sb.append(" end:");
            int i7 = min - 1;
            sb.append(this.f1940a[i7]);
            sb.append(",");
            sb.append(this.f1941b[i7]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }
}
