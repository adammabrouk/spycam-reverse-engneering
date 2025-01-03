package a.t;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
public class s<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    public final Property<T, PointF> f1862a;

    /* renamed from: b, reason: collision with root package name */
    public final PathMeasure f1863b;

    /* renamed from: c, reason: collision with root package name */
    public final float f1864c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f1865d;

    /* renamed from: e, reason: collision with root package name */
    public final PointF f1866e;

    /* renamed from: f, reason: collision with root package name */
    public float f1867f;

    public s(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1865d = new float[2];
        this.f1866e = new PointF();
        this.f1862a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f1863b = pathMeasure;
        this.f1864c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f2) {
        this.f1867f = f2.floatValue();
        this.f1863b.getPosTan(this.f1864c * f2.floatValue(), this.f1865d, null);
        PointF pointF = this.f1866e;
        float[] fArr = this.f1865d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1862a.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((s<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f1867f);
    }
}
