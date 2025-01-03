package c.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import c.a.a.m.m;
import c.a.a.p.h.j;

/* compiled from: GenericRequestBuilder.java */
/* loaded from: classes.dex */
public class c<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    public boolean A;
    public Drawable B;
    public int C;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2905a;

    /* renamed from: b, reason: collision with root package name */
    public final e f2906b;

    /* renamed from: c, reason: collision with root package name */
    public final Class<TranscodeType> f2907c;

    /* renamed from: d, reason: collision with root package name */
    public final m f2908d;

    /* renamed from: e, reason: collision with root package name */
    public final c.a.a.m.g f2909e;

    /* renamed from: f, reason: collision with root package name */
    public c.a.a.o.a<ModelType, DataType, ResourceType, TranscodeType> f2910f;

    /* renamed from: g, reason: collision with root package name */
    public ModelType f2911g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2913i;
    public int j;
    public int k;
    public c.a.a.p.d<? super ModelType, TranscodeType> l;
    public Float m;
    public c<?, ?, ?, TranscodeType> n;
    public Drawable p;
    public Drawable q;
    public boolean z;

    /* renamed from: h, reason: collision with root package name */
    public c.a.a.l.c f2912h = c.a.a.q.b.a();
    public Float o = Float.valueOf(1.0f);
    public g r = null;
    public boolean t = true;
    public c.a.a.p.g.d<TranscodeType> u = c.a.a.p.g.e.c();
    public int v = -1;
    public int w = -1;
    public c.a.a.l.i.b x = c.a.a.l.i.b.RESULT;
    public c.a.a.l.g<ResourceType> y = c.a.a.l.k.d.a();

    /* compiled from: GenericRequestBuilder.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2914a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f2914a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2914a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2914a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2914a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(Context context, Class<ModelType> cls, c.a.a.o.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, e eVar, m mVar, c.a.a.m.g gVar) {
        this.f2905a = context;
        this.f2907c = cls2;
        this.f2906b = eVar;
        this.f2908d = mVar;
        this.f2909e = gVar;
        this.f2910f = fVar != null ? new c.a.a.o.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.l.e<DataType, ResourceType> eVar) {
        c.a.a.o.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f2910f;
        if (aVar != null) {
            aVar.a(eVar);
        }
        return this;
    }

    public void a() {
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(int i2) {
        this.j = i2;
        return this;
    }

    public void b() {
    }

    public final g c() {
        g gVar = this.r;
        return gVar == g.LOW ? g.NORMAL : gVar == g.NORMAL ? g.HIGH : g.IMMEDIATE;
    }

    public <Y extends j<TranscodeType>> Y b(Y y) {
        c.a.a.r.h.a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.f2913i) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        c.a.a.p.b e2 = y.e();
        if (e2 != null) {
            e2.clear();
            this.f2908d.a(e2);
            e2.a();
        }
        c.a.a.p.b a2 = a((j) y);
        y.a(a2);
        this.f2909e.a(y);
        this.f2908d.b(a2);
        return y;
    }

    @Override // 
    /* renamed from: clone */
    public c<ModelType, DataType, ResourceType, TranscodeType> mo4clone() {
        try {
            c<ModelType, DataType, ResourceType, TranscodeType> cVar = (c) super.clone();
            cVar.f2910f = this.f2910f != null ? this.f2910f.m5clone() : null;
            return cVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.l.b<DataType> bVar) {
        c.a.a.o.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f2910f;
        if (aVar != null) {
            aVar.a(bVar);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.l.i.b bVar) {
        this.x = bVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.l.g<ResourceType>... gVarArr) {
        this.z = true;
        if (gVarArr.length == 1) {
            this.y = gVarArr[0];
        } else {
            this.y = new c.a.a.l.d(gVarArr);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.p.g.d<TranscodeType> dVar) {
        if (dVar != null) {
            this.u = dVar;
            return this;
        }
        throw new NullPointerException("Animation factory must not be null!");
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(int i2) {
        this.k = i2;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(boolean z) {
        this.t = !z;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(int i2, int i3) {
        if (c.a.a.r.h.a(i2, i3)) {
            this.w = i2;
            this.v = i3;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(c.a.a.l.c cVar) {
        if (cVar != null) {
            this.f2912h = cVar;
            return this;
        }
        throw new NullPointerException("Signature must not be null");
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> a(ModelType modeltype) {
        this.f2911g = modeltype;
        this.f2913i = true;
        return this;
    }

    public j<TranscodeType> a(ImageView imageView) {
        c.a.a.r.h.a();
        if (imageView != null) {
            if (!this.z && imageView.getScaleType() != null) {
                int i2 = a.f2914a[imageView.getScaleType().ordinal()];
                if (i2 == 1) {
                    a();
                } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                    b();
                }
            }
            j<TranscodeType> a2 = this.f2906b.a(imageView, this.f2907c);
            b((c<ModelType, DataType, ResourceType, TranscodeType>) a2);
            return a2;
        }
        throw new IllegalArgumentException("You must pass in a non null View");
    }

    public final c.a.a.p.b a(j<TranscodeType> jVar) {
        if (this.r == null) {
            this.r = g.NORMAL;
        }
        return a(jVar, (c.a.a.p.f) null);
    }

    public final c.a.a.p.b a(j<TranscodeType> jVar, c.a.a.p.f fVar) {
        c<?, ?, ?, TranscodeType> cVar = this.n;
        if (cVar != null) {
            if (!this.A) {
                if (cVar.u.equals(c.a.a.p.g.e.c())) {
                    this.n.u = this.u;
                }
                c<?, ?, ?, TranscodeType> cVar2 = this.n;
                if (cVar2.r == null) {
                    cVar2.r = c();
                }
                if (c.a.a.r.h.a(this.w, this.v)) {
                    c<?, ?, ?, TranscodeType> cVar3 = this.n;
                    if (!c.a.a.r.h.a(cVar3.w, cVar3.v)) {
                        this.n.a(this.w, this.v);
                    }
                }
                c.a.a.p.f fVar2 = new c.a.a.p.f(fVar);
                c.a.a.p.b a2 = a(jVar, this.o.floatValue(), this.r, fVar2);
                this.A = true;
                c.a.a.p.b a3 = this.n.a(jVar, fVar2);
                this.A = false;
                fVar2.a(a2, a3);
                return fVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.m != null) {
            c.a.a.p.f fVar3 = new c.a.a.p.f(fVar);
            fVar3.a(a(jVar, this.o.floatValue(), this.r, fVar3), a(jVar, this.m.floatValue(), c(), fVar3));
            return fVar3;
        }
        return a(jVar, this.o.floatValue(), this.r, fVar);
    }

    public final c.a.a.p.b a(j<TranscodeType> jVar, float f2, g gVar, c.a.a.p.c cVar) {
        return c.a.a.p.a.b(this.f2910f, this.f2911g, this.f2912h, this.f2905a, gVar, jVar, f2, this.p, this.j, this.q, this.k, this.B, this.C, this.l, cVar, this.f2906b.e(), this.y, this.f2907c, this.t, this.u, this.w, this.v, this.x);
    }
}
