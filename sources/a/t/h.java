package a.t;

import android.animation.TypeEvaluator;

/* compiled from: FloatArrayEvaluator.java */
/* loaded from: classes.dex */
public class h implements TypeEvaluator<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f1809a;

    public h(float[] fArr) {
        this.f1809a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f1809a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            float f3 = fArr[i2];
            fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
        }
        return fArr3;
    }
}
