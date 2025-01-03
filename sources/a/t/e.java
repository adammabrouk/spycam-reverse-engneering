package a.t;

import a.t.b0;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* compiled from: ChangeImageTransform.java */
/* loaded from: classes.dex */
public class e extends w {
    public static final String[] K = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    public static final TypeEvaluator<Matrix> L = new a();
    public static final Property<ImageView, Matrix> M = new b(Matrix.class, "animatedTransform");

    /* compiled from: ChangeImageTransform.java */
    public static class a implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* compiled from: ChangeImageTransform.java */
    public static class b extends Property<ImageView, Matrix> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            o.a(imageView, matrix);
        }
    }

    /* compiled from: ChangeImageTransform.java */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1781a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f1781a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1781a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Matrix b(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f2 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f3 = intrinsicHeight;
        float max = Math.max(width / f2, height / f3);
        int round = Math.round((width - (f2 * max)) / 2.0f);
        int round2 = Math.round((height - (f3 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        d(c0Var);
    }

    @Override // a.t.w
    public void c(c0 c0Var) {
        d(c0Var);
    }

    public final void d(c0 c0Var) {
        View view = c0Var.f1753b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c0Var.f1752a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", c(imageView));
        }
    }

    @Override // a.t.w
    public String[] m() {
        return K;
    }

    public static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i2 = c.f1781a[imageView.getScaleType().ordinal()];
            if (i2 == 1) {
                return d(imageView);
            }
            if (i2 == 2) {
                return b(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    @Override // a.t.w
    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null) {
            return null;
        }
        Rect rect = (Rect) c0Var.f1752a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) c0Var2.f1752a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) c0Var.f1752a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) c0Var2.f1752a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) c0Var2.f1753b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return a(imageView);
        }
        if (matrix == null) {
            matrix = p.f1861a;
        }
        if (matrix2 == null) {
            matrix2 = p.f1861a;
        }
        M.set(imageView, matrix);
        return a(imageView, matrix, matrix2);
    }

    public static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    public final ObjectAnimator a(ImageView imageView) {
        Property<ImageView, Matrix> property = M;
        TypeEvaluator<Matrix> typeEvaluator = L;
        Matrix matrix = p.f1861a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    public final ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) M, (TypeEvaluator) new b0.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }
}
