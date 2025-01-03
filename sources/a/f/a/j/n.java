package a.f.a.j;

/* compiled from: ResolutionDimension.java */
/* loaded from: classes.dex */
public class n extends o {

    /* renamed from: c, reason: collision with root package name */
    public float f819c = 0.0f;

    public void a(int i2) {
        if (this.f821b == 0 || this.f819c != i2) {
            this.f819c = i2;
            if (this.f821b == 1) {
                b();
            }
            a();
        }
    }

    @Override // a.f.a.j.o
    public void d() {
        super.d();
        this.f819c = 0.0f;
    }

    public void f() {
        this.f821b = 2;
    }
}
