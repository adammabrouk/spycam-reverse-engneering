package c.c.a.c.o;

import android.content.Context;
import android.graphics.Color;
import c.c.a.c.t.b;
import com.google.android.material.R$attr;
import com.google.zxing.view.ViewfinderView;

/* compiled from: ElevationOverlayProvider.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5479a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5480b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5481c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5482d;

    public a(Context context) {
        this.f5479a = b.a(context, R$attr.elevationOverlayEnabled, false);
        this.f5480b = c.c.a.c.k.a.a(context, R$attr.elevationOverlayColor, 0);
        this.f5481c = c.c.a.c.k.a.a(context, R$attr.colorSurface, 0);
        this.f5482d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i2, float f2) {
        float a2 = a(f2);
        return a.h.c.a.c(c.c.a.c.k.a.a(a.h.c.a.c(i2, ViewfinderView.OPAQUE), this.f5480b, a2), Color.alpha(i2));
    }

    public int b(int i2, float f2) {
        return (this.f5479a && a(i2)) ? a(i2, f2) : i2;
    }

    public float a(float f2) {
        if (this.f5482d <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean a() {
        return this.f5479a;
    }

    public final boolean a(int i2) {
        return a.h.c.a.c(i2, ViewfinderView.OPAQUE) == this.f5481c;
    }
}
