package a.f.a.j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ConstraintWidgetGroup.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public List<f> f801a;

    /* renamed from: b, reason: collision with root package name */
    public int f802b;

    /* renamed from: c, reason: collision with root package name */
    public int f803c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f804d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f805e;

    /* renamed from: f, reason: collision with root package name */
    public List<f> f806f;

    /* renamed from: g, reason: collision with root package name */
    public List<f> f807g;

    /* renamed from: h, reason: collision with root package name */
    public HashSet<f> f808h;

    /* renamed from: i, reason: collision with root package name */
    public HashSet<f> f809i;
    public List<f> j;
    public List<f> k;

    public h(List<f> list) {
        this.f802b = -1;
        this.f803c = -1;
        this.f804d = false;
        this.f805e = new int[]{-1, -1};
        this.f806f = new ArrayList();
        this.f807g = new ArrayList();
        this.f808h = new HashSet<>();
        this.f809i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f801a = list;
    }

    public List<f> a(int i2) {
        if (i2 == 0) {
            return this.f806f;
        }
        if (i2 == 1) {
            return this.f807g;
        }
        return null;
    }

    public Set<f> b(int i2) {
        if (i2 == 0) {
            return this.f808h;
        }
        if (i2 == 1) {
            return this.f809i;
        }
        return null;
    }

    public void a(f fVar, int i2) {
        if (i2 == 0) {
            this.f808h.add(fVar);
        } else if (i2 == 1) {
            this.f809i.add(fVar);
        }
    }

    public void b() {
        int size = this.k.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.k.get(i2));
        }
    }

    public List<f> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f801a.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.f801a.get(i2);
            if (!fVar.b0) {
                a((ArrayList<f>) this.j, fVar);
            }
        }
        this.k.clear();
        this.k.addAll(this.f801a);
        this.k.removeAll(this.j);
        return this.j;
    }

    public h(List<f> list, boolean z) {
        this.f802b = -1;
        this.f803c = -1;
        this.f804d = false;
        this.f805e = new int[]{-1, -1};
        this.f806f = new ArrayList();
        this.f807g = new ArrayList();
        this.f808h = new HashSet<>();
        this.f809i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f801a = list;
        this.f804d = z;
    }

    public final void a(ArrayList<f> arrayList, f fVar) {
        if (fVar.d0) {
            return;
        }
        arrayList.add(fVar);
        fVar.d0 = true;
        if (fVar.z()) {
            return;
        }
        if (fVar instanceof j) {
            j jVar = (j) fVar;
            int i2 = jVar.l0;
            for (int i3 = 0; i3 < i2; i3++) {
                a(arrayList, jVar.k0[i3]);
            }
        }
        int length = fVar.A.length;
        for (int i4 = 0; i4 < length; i4++) {
            e eVar = fVar.A[i4].f779d;
            if (eVar != null) {
                f fVar2 = eVar.f777b;
                if (eVar != null && fVar2 != fVar.l()) {
                    a(arrayList, fVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(a.f.a.j.f r7) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.j.h.a(a.f.a.j.f):void");
    }
}
