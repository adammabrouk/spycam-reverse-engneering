package a.f.a.j;

import a.f.a.i;

/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public final f f777b;

    /* renamed from: c, reason: collision with root package name */
    public final d f778c;

    /* renamed from: d, reason: collision with root package name */
    public e f779d;

    /* renamed from: h, reason: collision with root package name */
    public int f783h;

    /* renamed from: i, reason: collision with root package name */
    public a.f.a.i f784i;

    /* renamed from: a, reason: collision with root package name */
    public m f776a = new m(this);

    /* renamed from: e, reason: collision with root package name */
    public int f780e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f781f = -1;

    /* renamed from: g, reason: collision with root package name */
    public c f782g = c.NONE;

    /* compiled from: ConstraintAnchor.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f785a;

        static {
            int[] iArr = new int[d.values().length];
            f785a = iArr;
            try {
                iArr[d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f785a[d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f785a[d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f785a[d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f785a[d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f785a[d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f785a[d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f785a[d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f785a[d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: ConstraintAnchor.java */
    public enum b {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        b bVar = b.RELAXED;
        this.f783h = 0;
        this.f777b = fVar;
        this.f778c = dVar;
    }

    public void a(a.f.a.c cVar) {
        a.f.a.i iVar = this.f784i;
        if (iVar == null) {
            this.f784i = new a.f.a.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.a();
        }
    }

    public int b() {
        e eVar;
        if (this.f777b.s() == 8) {
            return 0;
        }
        return (this.f781f <= -1 || (eVar = this.f779d) == null || eVar.f777b.s() != 8) ? this.f780e : this.f781f;
    }

    public f c() {
        return this.f777b;
    }

    public m d() {
        return this.f776a;
    }

    public a.f.a.i e() {
        return this.f784i;
    }

    public c f() {
        return this.f782g;
    }

    public e g() {
        return this.f779d;
    }

    public d h() {
        return this.f778c;
    }

    public boolean i() {
        return this.f779d != null;
    }

    public void j() {
        this.f779d = null;
        this.f780e = 0;
        this.f781f = -1;
        this.f782g = c.STRONG;
        this.f783h = 0;
        b bVar = b.RELAXED;
        this.f776a.d();
    }

    public String toString() {
        return this.f777b.g() + ":" + this.f778c.toString();
    }

    public int a() {
        return this.f783h;
    }

    public boolean a(e eVar, int i2, c cVar, int i3) {
        return a(eVar, i2, -1, cVar, i3, false);
    }

    public boolean a(e eVar, int i2, int i3, c cVar, int i4, boolean z) {
        if (eVar == null) {
            this.f779d = null;
            this.f780e = 0;
            this.f781f = -1;
            this.f782g = c.NONE;
            this.f783h = 2;
            return true;
        }
        if (!z && !a(eVar)) {
            return false;
        }
        this.f779d = eVar;
        if (i2 > 0) {
            this.f780e = i2;
        } else {
            this.f780e = 0;
        }
        this.f781f = i3;
        this.f782g = cVar;
        this.f783h = i4;
        return true;
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        d h2 = eVar.h();
        d dVar = this.f778c;
        if (h2 == dVar) {
            return dVar != d.BASELINE || (eVar.c().y() && c().y());
        }
        switch (a.f785a[dVar.ordinal()]) {
            case 1:
                return (h2 == d.BASELINE || h2 == d.CENTER_X || h2 == d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = h2 == d.LEFT || h2 == d.RIGHT;
                if (eVar.c() instanceof i) {
                    return z || h2 == d.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = h2 == d.TOP || h2 == d.BOTTOM;
                if (eVar.c() instanceof i) {
                    return z2 || h2 == d.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f778c.name());
        }
    }
}
