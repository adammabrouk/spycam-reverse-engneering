package cn.jiguang.ay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class e implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static i[] f8502d = new i[0];

    /* renamed from: e, reason: collision with root package name */
    public static h[] f8503e = new h[0];

    /* renamed from: a, reason: collision with root package name */
    public d f8504a;

    /* renamed from: b, reason: collision with root package name */
    public List[] f8505b;

    /* renamed from: c, reason: collision with root package name */
    public int f8506c;

    public e() {
        this(new d());
    }

    public e(b bVar) {
        this(new d(bVar));
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                int c2 = this.f8504a.c(i2);
                if (c2 > 0) {
                    this.f8505b[i2] = new ArrayList(c2);
                }
                for (int i3 = 0; i3 < c2; i3++) {
                    this.f8505b[i2].add(i.a(bVar, i2));
                }
            } catch (IOException e2) {
                throw e2;
            }
        }
        this.f8506c = bVar.a();
    }

    public e(d dVar) {
        this.f8505b = new List[4];
        this.f8504a = dVar;
    }

    public e(byte[] bArr) {
        this(new b(bArr));
    }

    private int a(c cVar, int i2, a aVar, int i3) {
        int size = this.f8505b[i2].size();
        int a2 = cVar.a();
        i iVar = null;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i iVar2 = (i) this.f8505b[i2].get(i6);
            if (i2 == 3) {
                i4++;
            } else {
                if (iVar != null && !a(iVar2, iVar)) {
                    a2 = cVar.a();
                    i5 = i6;
                }
                iVar2.a(cVar, i2, aVar);
                if (cVar.a() > i3) {
                    cVar.a(a2);
                    return (size - i5) + i4;
                }
                iVar = iVar2;
            }
        }
        return i4;
    }

    public static e a(i iVar) {
        e eVar = new e();
        eVar.a(iVar, 0);
        return eVar;
    }

    private boolean a(c cVar, int i2) {
        if (i2 < 12) {
            return false;
        }
        cVar.a();
        this.f8504a.a(cVar);
        a aVar = new a();
        this.f8504a.c();
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.f8505b[i3] != null) {
                a(cVar, i3, aVar, i2);
            }
        }
        return true;
    }

    public static boolean a(i iVar, i iVar2) {
        return iVar.f() == iVar2.f() && iVar.g() == iVar2.g() && iVar.d().equals(iVar2.d());
    }

    public i a() {
        List list = this.f8505b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (i) list.get(0);
    }

    public void a(i iVar, int i2) {
        List[] listArr = this.f8505b;
        if (listArr[i2] == null) {
            listArr[i2] = new LinkedList();
        }
        this.f8504a.b(i2);
        this.f8505b[i2].add(iVar);
    }

    public i[] a(int i2) {
        List[] listArr = this.f8505b;
        if (listArr[i2] == null) {
            return f8502d;
        }
        List list = listArr[i2];
        return (i[]) list.toArray(new i[list.size()]);
    }

    public h[] b(int i2) {
        if (this.f8505b[i2] == null) {
            return f8503e;
        }
        LinkedList linkedList = new LinkedList();
        i[] a2 = a(i2);
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < a2.length; i3++) {
            g d2 = a2[i3].d();
            boolean z = true;
            if (hashSet.contains(d2)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    h hVar = (h) linkedList.get(size);
                    if (hVar.c() == a2[i3].f() && hVar.d() == a2[i3].g() && hVar.b().equals(d2)) {
                        hVar.a(a2[i3]);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new h(a2[i3]));
                hashSet.add(d2);
            }
        }
        return (h[]) linkedList.toArray(new h[linkedList.size()]);
    }

    public byte[] c(int i2) {
        c cVar = new c();
        a(cVar, i2);
        this.f8506c = cVar.a();
        return cVar.b();
    }

    public Object clone() {
        e eVar = new e();
        int i2 = 0;
        while (true) {
            List[] listArr = this.f8505b;
            if (i2 >= listArr.length) {
                eVar.f8504a = (d) this.f8504a.clone();
                eVar.f8506c = this.f8506c;
                return eVar;
            }
            if (listArr[i2] != null) {
                eVar.f8505b[i2] = new LinkedList(this.f8505b[i2]);
            }
            i2++;
        }
    }
}
