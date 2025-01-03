package c.e.b.f;

import android.widget.ImageView;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: Util.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6289a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f6289a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static int a(int i2) {
        return (i2 & 65280) >> 8;
    }

    public static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static boolean a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    public static boolean a(ImageView.ScaleType scaleType) {
        return (scaleType == null || a.f6289a[scaleType.ordinal()] == 1) ? false : true;
    }
}
