package c.c.a.c.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f5316a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f5317b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f5318c = new Matrix();

    public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f5316a);
        matrix2.getValues(this.f5317b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f5317b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f5316a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f5318c.setValues(this.f5317b);
        return this.f5318c;
    }
}
