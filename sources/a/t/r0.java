package a.t;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
public class r0 extends q0 {
    @Override // a.t.n0, a.t.s0
    public void a(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // a.t.n0, a.t.s0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // a.t.o0, a.t.s0
    public void c(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // a.t.q0, a.t.s0
    public void a(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // a.t.o0, a.t.s0
    public void b(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // a.t.p0, a.t.s0
    public void a(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // a.t.o0, a.t.s0
    public void a(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }
}
