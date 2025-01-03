package a.p.a;

import a.p.a.a;
import java.util.List;

/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final a f1681a;

    /* compiled from: OpReorderer.java */
    public interface a {
        a.b a(int i2, int i3, int i4, Object obj);

        void a(a.b bVar);
    }

    public j(a aVar) {
        this.f1681a = aVar;
    }

    public final void a(List<a.b> list, int i2, int i3) {
        a.b bVar = list.get(i2);
        a.b bVar2 = list.get(i3);
        int i4 = bVar2.f1586a;
        if (i4 == 1) {
            a(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            b(list, i2, bVar, i3, bVar2);
        } else {
            if (i4 != 4) {
                return;
            }
            c(list, i2, bVar, i3, bVar2);
        }
    }

    public void b(List<a.b> list) {
        while (true) {
            int a2 = a(list);
            if (a2 == -1) {
                return;
            } else {
                a(list, a2, a2 + 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.util.List<a.p.a.a.b> r9, int r10, a.p.a.a.b r11, int r12, a.p.a.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f1589d
            int r1 = r13.f1587b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f1587b = r1
            goto L20
        Ld:
            int r5 = r13.f1589d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f1589d = r5
            a.p.a.j$a r0 = r8.f1681a
            int r1 = r11.f1587b
            java.lang.Object r5 = r13.f1588c
            a.p.a.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f1587b
            int r5 = r13.f1587b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f1587b = r5
            goto L41
        L2b:
            int r6 = r13.f1589d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            a.p.a.j$a r3 = r8.f1681a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f1588c
            a.p.a.a$b r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.f1589d
            int r1 = r1 - r5
            r13.f1589d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f1589d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            a.p.a.j$a r11 = r8.f1681a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.a.j.c(java.util.List, int, a.p.a.a$b, int, a.p.a.a$b):void");
    }

    public void b(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        boolean z;
        int i4 = bVar.f1587b;
        int i5 = bVar.f1589d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.f1587b == i4 && bVar2.f1589d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f1587b == i5 + 1 && bVar2.f1589d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar.f1589d;
        int i7 = bVar2.f1587b;
        if (i6 < i7) {
            bVar2.f1587b = i7 - 1;
        } else {
            int i8 = bVar2.f1589d;
            if (i6 < i7 + i8) {
                bVar2.f1589d = i8 - 1;
                bVar.f1586a = 2;
                bVar.f1589d = 1;
                if (bVar2.f1589d == 0) {
                    list.remove(i3);
                    this.f1681a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i9 = bVar.f1587b;
        int i10 = bVar2.f1587b;
        a.b bVar3 = null;
        if (i9 <= i10) {
            bVar2.f1587b = i10 + 1;
        } else {
            int i11 = bVar2.f1589d;
            if (i9 < i10 + i11) {
                bVar3 = this.f1681a.a(2, i9 + 1, (i10 + i11) - i9, null);
                bVar2.f1589d = bVar.f1587b - bVar2.f1587b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.f1681a.a(bVar);
            return;
        }
        if (z) {
            if (bVar3 != null) {
                int i12 = bVar.f1587b;
                if (i12 > bVar3.f1587b) {
                    bVar.f1587b = i12 - bVar3.f1589d;
                }
                int i13 = bVar.f1589d;
                if (i13 > bVar3.f1587b) {
                    bVar.f1589d = i13 - bVar3.f1589d;
                }
            }
            int i14 = bVar.f1587b;
            if (i14 > bVar2.f1587b) {
                bVar.f1587b = i14 - bVar2.f1589d;
            }
            int i15 = bVar.f1589d;
            if (i15 > bVar2.f1587b) {
                bVar.f1589d = i15 - bVar2.f1589d;
            }
        } else {
            if (bVar3 != null) {
                int i16 = bVar.f1587b;
                if (i16 >= bVar3.f1587b) {
                    bVar.f1587b = i16 - bVar3.f1589d;
                }
                int i17 = bVar.f1589d;
                if (i17 >= bVar3.f1587b) {
                    bVar.f1589d = i17 - bVar3.f1589d;
                }
            }
            int i18 = bVar.f1587b;
            if (i18 >= bVar2.f1587b) {
                bVar.f1587b = i18 - bVar2.f1589d;
            }
            int i19 = bVar.f1589d;
            if (i19 >= bVar2.f1587b) {
                bVar.f1589d = i19 - bVar2.f1589d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f1587b != bVar.f1589d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVar3 != null) {
            list.add(i2, bVar3);
        }
    }

    public final void a(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.f1589d < bVar2.f1587b ? -1 : 0;
        if (bVar.f1587b < bVar2.f1587b) {
            i4++;
        }
        int i5 = bVar2.f1587b;
        int i6 = bVar.f1587b;
        if (i5 <= i6) {
            bVar.f1587b = i6 + bVar2.f1589d;
        }
        int i7 = bVar2.f1587b;
        int i8 = bVar.f1589d;
        if (i7 <= i8) {
            bVar.f1589d = i8 + bVar2.f1589d;
        }
        bVar2.f1587b += i4;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    public final int a(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1586a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
