package c.a.a.l;

import c.a.a.l.i.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class d<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Collection<? extends g<T>> f3040a;

    /* renamed from: b, reason: collision with root package name */
    public String f3041b;

    @SafeVarargs
    public d(g<T>... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f3040a = Arrays.asList(gVarArr);
    }

    @Override // c.a.a.l.g
    public k<T> a(k<T> kVar, int i2, int i3) {
        Iterator<? extends g<T>> it = this.f3040a.iterator();
        k<T> kVar2 = kVar;
        while (it.hasNext()) {
            k<T> a2 = it.next().a(kVar2, i2, i3);
            if (kVar2 != null && !kVar2.equals(kVar) && !kVar2.equals(a2)) {
                kVar2.a();
            }
            kVar2 = a2;
        }
        return kVar2;
    }

    @Override // c.a.a.l.g
    public String c() {
        if (this.f3041b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends g<T>> it = this.f3040a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().c());
            }
            this.f3041b = sb.toString();
        }
        return this.f3041b;
    }
}
