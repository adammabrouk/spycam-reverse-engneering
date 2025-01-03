package c.c.a.c.d;

import c.c.a.c.w.f;
import c.c.a.c.w.o;

/* compiled from: BottomAppBarTopEdgeTreatment.java */
/* loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public float f5357a;

    /* renamed from: b, reason: collision with root package name */
    public float f5358b;

    /* renamed from: c, reason: collision with root package name */
    public float f5359c;

    /* renamed from: d, reason: collision with root package name */
    public float f5360d;

    /* renamed from: e, reason: collision with root package name */
    public float f5361e;

    public a(float f2, float f3, float f4) {
        this.f5358b = f2;
        this.f5357a = f3;
        a(f4);
        this.f5361e = 0.0f;
    }

    @Override // c.c.a.c.w.f
    public void a(float f2, float f3, float f4, o oVar) {
        float f5 = this.f5359c;
        if (f5 == 0.0f) {
            oVar.a(f2, 0.0f);
            return;
        }
        float f6 = ((this.f5358b * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.f5357a;
        float f8 = f3 + this.f5361e;
        float f9 = (this.f5360d * f4) + ((1.0f - f4) * f6);
        if (f9 / f6 >= 1.0f) {
            oVar.a(f2, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((f10 * f10) - (f11 * f11));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f11));
        float f14 = 90.0f - degrees;
        oVar.a(f12, 0.0f);
        float f15 = f7 * 2.0f;
        oVar.a(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
        oVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        oVar.a(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - degrees, degrees);
        oVar.a(f2, 0.0f);
    }

    public float b() {
        return this.f5360d;
    }

    public float c() {
        return this.f5358b;
    }

    public void d(float f2) {
        this.f5359c = f2;
    }

    public float e() {
        return this.f5359c;
    }

    public float f() {
        return this.f5361e;
    }

    public void b(float f2) {
        this.f5358b = f2;
    }

    public void c(float f2) {
        this.f5357a = f2;
    }

    public float d() {
        return this.f5357a;
    }

    public void e(float f2) {
        this.f5361e = f2;
    }

    public void a(float f2) {
        if (f2 >= 0.0f) {
            this.f5360d = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }
}
