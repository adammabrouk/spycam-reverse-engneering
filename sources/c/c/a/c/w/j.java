package c.c.a.c.w;

/* compiled from: OffsetEdgeTreatment.java */
/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: a, reason: collision with root package name */
    public final f f5669a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5670b;

    public j(f fVar, float f2) {
        this.f5669a = fVar;
        this.f5670b = f2;
    }

    @Override // c.c.a.c.w.f
    public void a(float f2, float f3, float f4, o oVar) {
        this.f5669a.a(f2, f3 - this.f5670b, f4, oVar);
    }

    @Override // c.c.a.c.w.f
    public boolean a() {
        return this.f5669a.a();
    }
}
