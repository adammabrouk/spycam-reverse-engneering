package a.u.a.a;

import android.animation.TypeEvaluator;
import com.google.zxing.view.ViewfinderView;

/* compiled from: ArgbEvaluator.java */
/* loaded from: classes.dex */
public class f implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1939a = new f();

    public static f a() {
        return f1939a;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f2, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f3 = ((intValue >> 24) & ViewfinderView.OPAQUE) / 255.0f;
        float f4 = ((intValue >> 16) & ViewfinderView.OPAQUE) / 255.0f;
        float f5 = ((intValue >> 8) & ViewfinderView.OPAQUE) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f6 = ((intValue2 >> 24) & ViewfinderView.OPAQUE) / 255.0f;
        float f7 = ((intValue2 >> 16) & ViewfinderView.OPAQUE) / 255.0f;
        float f8 = ((intValue2 >> 8) & ViewfinderView.OPAQUE) / 255.0f;
        float pow = (float) Math.pow(f4, 2.2d);
        float pow2 = (float) Math.pow(f5, 2.2d);
        float pow3 = (float) Math.pow((intValue & ViewfinderView.OPAQUE) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(f7, 2.2d);
        float f9 = f3 + ((f6 - f3) * f2);
        float pow5 = pow2 + ((((float) Math.pow(f8, 2.2d)) - pow2) * f2);
        float pow6 = pow3 + (f2 * (((float) Math.pow((intValue2 & ViewfinderView.OPAQUE) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f2), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f9 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f));
    }
}
