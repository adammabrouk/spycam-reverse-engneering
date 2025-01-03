package com.google.zxing.common;

/* loaded from: classes.dex */
public final class PerspectiveTransform {
    public final float a11;
    public final float a12;
    public final float a13;
    public final float a21;
    public final float a22;
    public final float a23;
    public final float a31;
    public final float a32;
    public final float a33;

    public PerspectiveTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a11 = f2;
        this.a12 = f5;
        this.a13 = f8;
        this.a21 = f3;
        this.a22 = f6;
        this.a23 = f9;
        this.a31 = f4;
        this.a32 = f7;
        this.a33 = f10;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return squareToQuadrilateral(f10, f11, f12, f13, f14, f15, f16, f17).times(quadrilateralToSquare(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return squareToQuadrilateral(f2, f3, f4, f5, f6, f7, f8, f9).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new PerspectiveTransform(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new PerspectiveTransform((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public PerspectiveTransform buildAdjoint() {
        float f2 = this.a22;
        float f3 = this.a33;
        float f4 = this.a23;
        float f5 = this.a32;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.a31;
        float f8 = this.a21;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.a13;
        float f12 = this.a12;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.a11;
        return new PerspectiveTransform(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    public PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        float f2 = this.a11;
        float f3 = perspectiveTransform.a11;
        float f4 = this.a21;
        float f5 = perspectiveTransform.a12;
        float f6 = this.a31;
        float f7 = perspectiveTransform.a13;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = perspectiveTransform.a21;
        float f10 = perspectiveTransform.a22;
        float f11 = perspectiveTransform.a23;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = perspectiveTransform.a31;
        float f14 = perspectiveTransform.a32;
        float f15 = perspectiveTransform.a33;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.a12;
        float f18 = this.a22;
        float f19 = this.a32;
        float f20 = (f17 * f3) + (f18 * f5) + (f19 * f7);
        float f21 = (f17 * f9) + (f18 * f10) + (f19 * f11);
        float f22 = (f19 * f15) + (f17 * f13) + (f18 * f14);
        float f23 = this.a13;
        float f24 = this.a23;
        float f25 = (f3 * f23) + (f5 * f24);
        float f26 = this.a33;
        return new PerspectiveTransform(f8, f12, f16, f20, f21, f22, (f7 * f26) + f25, (f9 * f23) + (f10 * f24) + (f11 * f26), (f23 * f13) + (f24 * f14) + (f26 * f15));
    }

    public void transformPoints(float[] fArr) {
        float f2 = this.a11;
        float f3 = this.a12;
        float f4 = this.a13;
        float f5 = this.a21;
        float f6 = this.a22;
        float f7 = this.a23;
        float f8 = this.a31;
        float f9 = this.a32;
        float f10 = this.a33;
        int length = fArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr[i2];
            int i3 = i2 + 1;
            float f12 = fArr[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            float f3 = fArr2[i2];
            float f4 = (this.a13 * f2) + (this.a23 * f3) + this.a33;
            fArr[i2] = (((this.a11 * f2) + (this.a21 * f3)) + this.a31) / f4;
            fArr2[i2] = (((this.a12 * f2) + (this.a22 * f3)) + this.a32) / f4;
        }
    }
}
