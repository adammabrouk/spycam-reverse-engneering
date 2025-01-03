package a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.shix.shixipc.utilcode.MemoryConstants;

/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1743a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1744b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f1745c;

    /* compiled from: TransitionUtils.java */
    public static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f1746a = new float[9];

        /* renamed from: b, reason: collision with root package name */
        public final float[] f1747b = new float[9];

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f1748c = new Matrix();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f1746a);
            matrix2.getValues(this.f1747b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f1747b;
                float f3 = fArr[i2];
                float[] fArr2 = this.f1746a;
                fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
            }
            this.f1748c.setValues(this.f1747b);
            return this.f1748c;
        }
    }

    static {
        f1743a = Build.VERSION.SDK_INT >= 19;
        f1744b = Build.VERSION.SDK_INT >= 18;
        f1745c = Build.VERSION.SDK_INT >= 28;
    }

    public static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        m0.b(view, matrix);
        m0.c(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap a2 = a(view, matrix, rectF, viewGroup);
        if (a2 != null) {
            imageView.setImageBitmap(a2);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(round4 - round2, MemoryConstants.GB));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.view.View r8, android.graphics.Matrix r9, android.graphics.RectF r10, android.view.ViewGroup r11) {
        /*
            boolean r0 = a.t.b0.f1743a
            r1 = 0
            if (r0 == 0) goto L13
            boolean r0 = r8.isAttachedToWindow()
            r0 = r0 ^ 1
            if (r11 != 0) goto Le
            goto L14
        Le:
            boolean r2 = r11.isAttachedToWindow()
            goto L15
        L13:
            r0 = 0
        L14:
            r2 = 0
        L15:
            boolean r3 = a.t.b0.f1744b
            r4 = 0
            if (r3 == 0) goto L31
            if (r0 == 0) goto L31
            if (r2 != 0) goto L1f
            return r4
        L1f:
            android.view.ViewParent r1 = r8.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.indexOfChild(r8)
            android.view.ViewGroupOverlay r3 = r11.getOverlay()
            r3.add(r8)
            goto L33
        L31:
            r1 = r4
            r2 = 0
        L33:
            float r3 = r10.width()
            int r3 = java.lang.Math.round(r3)
            float r5 = r10.height()
            int r5 = java.lang.Math.round(r5)
            if (r3 <= 0) goto L99
            if (r5 <= 0) goto L99
            r4 = 1065353216(0x3f800000, float:1.0)
            r6 = 1233125376(0x49800000, float:1048576.0)
            int r7 = r3 * r5
            float r7 = (float) r7
            float r6 = r6 / r7
            float r4 = java.lang.Math.min(r4, r6)
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            float r5 = (float) r5
            float r5 = r5 * r4
            int r5 = java.lang.Math.round(r5)
            float r6 = r10.left
            float r6 = -r6
            float r10 = r10.top
            float r10 = -r10
            r9.postTranslate(r6, r10)
            r9.postScale(r4, r4)
            boolean r10 = a.t.b0.f1745c
            if (r10 == 0) goto L88
            android.graphics.Picture r10 = new android.graphics.Picture
            r10.<init>()
            android.graphics.Canvas r3 = r10.beginRecording(r3, r5)
            r3.concat(r9)
            r8.draw(r3)
            r10.endRecording()
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r10)
            goto L99
        L88:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3, r5, r10)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r4)
            r10.concat(r9)
            r8.draw(r10)
        L99:
            boolean r9 = a.t.b0.f1744b
            if (r9 == 0) goto La9
            if (r0 == 0) goto La9
            android.view.ViewGroupOverlay r9 = r11.getOverlay()
            r9.remove(r8)
            r1.addView(r8, r2)
        La9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.b0.a(android.view.View, android.graphics.Matrix, android.graphics.RectF, android.view.ViewGroup):android.graphics.Bitmap");
    }

    public static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
