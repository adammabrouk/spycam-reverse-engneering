package c.c.a.c.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f5306a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f5307b = new a.l.a.a.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f5308c = new a.l.a.a.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f5309d = new a.l.a.a.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f5310e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }
}
