package c.c.a.c.u;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import com.google.zxing.view.ViewfinderView;

/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f5626a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5627b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5628c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5629d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f5630e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f5631f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f5632g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f5633h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5634i;
    public static final int[] j;
    public static final int[] k;
    public static final String l;

    static {
        f5626a = Build.VERSION.SDK_INT >= 21;
        f5627b = new int[]{R.attr.state_pressed};
        f5628c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f5629d = new int[]{R.attr.state_focused};
        f5630e = new int[]{R.attr.state_hovered};
        f5631f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f5632g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f5633h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f5634i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        j = new int[]{R.attr.state_selected};
        k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        l = b.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f5626a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f5631f), a(colorStateList, f5627b)});
        }
        int[] iArr = f5631f;
        int[] iArr2 = f5632g;
        int[] iArr3 = f5633h;
        int[] iArr4 = f5634i;
        int[] iArr5 = f5627b;
        int[] iArr6 = f5628c;
        int[] iArr7 = f5629d;
        int[] iArr8 = f5630e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(k, 0)) != 0) {
            Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean a(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f5626a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    public static int a(int i2) {
        return a.h.c.a.c(i2, Math.min(Color.alpha(i2) * 2, ViewfinderView.OPAQUE));
    }
}
