package c.c.a.b.c.o;

import android.content.Context;
import android.util.SparseIntArray;
import c.c.a.b.c.l.a;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final SparseIntArray f3972a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public c.c.a.b.c.d f3973b;

    public j(c.c.a.b.c.d dVar) {
        r.a(dVar);
        this.f3973b = dVar;
    }

    public int a(Context context, a.f fVar) {
        r.a(context);
        r.a(fVar);
        int i2 = 0;
        if (!fVar.c()) {
            return 0;
        }
        int d2 = fVar.d();
        int i3 = this.f3972a.get(d2, -1);
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.f3972a.size()) {
                i2 = i3;
                break;
            }
            int keyAt = this.f3972a.keyAt(i4);
            if (keyAt > d2 && this.f3972a.get(keyAt) == 0) {
                break;
            }
            i4++;
        }
        if (i2 == -1) {
            i2 = this.f3973b.a(context, d2);
        }
        this.f3972a.put(d2, i2);
        return i2;
    }

    public void a() {
        this.f3972a.clear();
    }
}
