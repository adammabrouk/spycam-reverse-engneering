package c.c.a.c.w;

/* compiled from: CutCornerTreatment.java */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a, reason: collision with root package name */
    public float f5647a = -1.0f;

    @Override // c.c.a.c.w.d
    public void a(o oVar, float f2, float f3, float f4) {
        oVar.a(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double sin = Math.sin(Math.toRadians(f2));
        double d2 = f4;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians(90.0f - f2));
        Double.isNaN(d2);
        Double.isNaN(d3);
        oVar.a((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }
}
