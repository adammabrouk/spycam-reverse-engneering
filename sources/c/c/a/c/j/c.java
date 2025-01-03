package c.c.a.c.j;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import c.c.a.c.j.b;

/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface c extends b.a {

    /* compiled from: CircularRevealWidget.java */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f5390b = new b();

        /* renamed from: a, reason: collision with root package name */
        public final e f5391a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f2, e eVar, e eVar2) {
            this.f5391a.a(c.c.a.c.s.a.b(eVar.f5394a, eVar2.f5394a, f2), c.c.a.c.s.a.b(eVar.f5395b, eVar2.f5395b, f2), c.c.a.c.s.a.b(eVar.f5396c, eVar2.f5396c, f2));
            return this.f5391a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: c.c.a.c.j.c$c, reason: collision with other inner class name */
    public static class C0102c extends Property<c, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f5392a = new C0102c("circularReveal");

        public C0102c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class d extends Property<c, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f5393a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f5394a;

        /* renamed from: b, reason: collision with root package name */
        public float f5395b;

        /* renamed from: c, reason: collision with root package name */
        public float f5396c;

        public void a(float f2, float f3, float f4) {
            this.f5394a = f2;
            this.f5395b = f3;
            this.f5396c = f4;
        }

        public e() {
        }

        public e(float f2, float f3, float f4) {
            this.f5394a = f2;
            this.f5395b = f3;
            this.f5396c = f4;
        }

        public void a(e eVar) {
            a(eVar.f5394a, eVar.f5395b, eVar.f5396c);
        }

        public boolean a() {
            return this.f5396c == Float.MAX_VALUE;
        }

        public e(e eVar) {
            this(eVar.f5394a, eVar.f5395b, eVar.f5396c);
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
