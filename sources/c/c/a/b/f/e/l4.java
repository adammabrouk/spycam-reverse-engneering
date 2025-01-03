package c.c.a.b.f.e;

import c.c.a.b.f.e.n4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class l4<T extends n4<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final l4 f4276d = new l4(true);

    /* renamed from: a, reason: collision with root package name */
    public final x6<T, Object> f4277a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4278b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4279c;

    public l4() {
        this.f4277a = x6.c(16);
    }

    public static <T extends n4<T>> l4<T> g() {
        return f4276d;
    }

    public final void a() {
        if (this.f4278b) {
            return;
        }
        this.f4277a.a();
        this.f4278b = true;
    }

    public final boolean b() {
        return this.f4278b;
    }

    public final Iterator<Map.Entry<T, Object>> c() {
        return this.f4279c ? new i5(this.f4277a.entrySet().iterator()) : this.f4277a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        l4 l4Var = new l4();
        for (int i2 = 0; i2 < this.f4277a.c(); i2++) {
            Map.Entry<T, Object> a2 = this.f4277a.a(i2);
            l4Var.a((l4) a2.getKey(), a2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f4277a.d()) {
            l4Var.a((l4) entry.getKey(), entry.getValue());
        }
        l4Var.f4279c = this.f4279c;
        return l4Var;
    }

    public final Iterator<Map.Entry<T, Object>> d() {
        return this.f4279c ? new i5(this.f4277a.e().iterator()) : this.f4277a.e().iterator();
    }

    public final boolean e() {
        for (int i2 = 0; i2 < this.f4277a.c(); i2++) {
            if (!b(this.f4277a.a(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f4277a.d().iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l4) {
            return this.f4277a.equals(((l4) obj).f4277a);
        }
        return false;
    }

    public final int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4277a.c(); i3++) {
            i2 += c(this.f4277a.a(i3));
        }
        Iterator<Map.Entry<T, Object>> it = this.f4277a.d().iterator();
        while (it.hasNext()) {
            i2 += c(it.next());
        }
        return i2;
    }

    public final int hashCode() {
        return this.f4277a.hashCode();
    }

    public static <T extends n4<T>> boolean b(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.C() == e8.MESSAGE) {
            if (key.D()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((d6) it.next()).b()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof d6)) {
                    if (value instanceof d5) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((d6) value).b()) {
                    return false;
                }
            }
        }
        return true;
    }

    public l4(boolean z) {
        this(x6.c(0));
        a();
    }

    public static int c(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.C() == e8.MESSAGE && !key.D() && !key.E()) {
            if (value instanceof d5) {
                return b4.b(entry.getKey().zza(), (d5) value);
            }
            return b4.b(entry.getKey().zza(), (d6) value);
        }
        return b((n4<?>) key, value);
    }

    public final Object a(T t) {
        Object obj = this.f4277a.get(t);
        if (!(obj instanceof d5)) {
            return obj;
        }
        d5.c();
        throw null;
    }

    public l4(x6<T, Object> x6Var) {
        this.f4277a = x6Var;
        a();
    }

    public final void a(T t, Object obj) {
        if (t.D()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    a(t.zzb(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(t.zzb(), obj);
        }
        if (obj instanceof d5) {
            this.f4279c = true;
        }
        this.f4277a.a((x6<T, Object>) t, (T) obj);
    }

    public static int b(b8 b8Var, Object obj) {
        switch (k4.f4254b[b8Var.ordinal()]) {
            case 1:
                return b4.b(((Double) obj).doubleValue());
            case 2:
                return b4.b(((Float) obj).floatValue());
            case 3:
                return b4.d(((Long) obj).longValue());
            case 4:
                return b4.e(((Long) obj).longValue());
            case 5:
                return b4.f(((Integer) obj).intValue());
            case 6:
                return b4.g(((Long) obj).longValue());
            case 7:
                return b4.i(((Integer) obj).intValue());
            case 8:
                return b4.b(((Boolean) obj).booleanValue());
            case 9:
                return b4.c((d6) obj);
            case 10:
                if (obj instanceof d5) {
                    return b4.a((d5) obj);
                }
                return b4.b((d6) obj);
            case 11:
                if (obj instanceof k3) {
                    return b4.b((k3) obj);
                }
                return b4.b((String) obj);
            case 12:
                if (obj instanceof k3) {
                    return b4.b((k3) obj);
                }
                return b4.b((byte[]) obj);
            case 13:
                return b4.g(((Integer) obj).intValue());
            case 14:
                return b4.j(((Integer) obj).intValue());
            case 15:
                return b4.h(((Long) obj).longValue());
            case 16:
                return b4.h(((Integer) obj).intValue());
            case 17:
                return b4.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof w4) {
                    return b4.k(((w4) obj).zza());
                }
                return b4.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof c.c.a.b.f.e.d5) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof c.c.a.b.f.e.w4) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(c.c.a.b.f.e.b8 r2, java.lang.Object r3) {
        /*
            c.c.a.b.f.e.u4.a(r3)
            int[] r0 = c.c.a.b.f.e.k4.f4253a
            c.c.a.b.f.e.e8 r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof c.c.a.b.f.e.d6
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof c.c.a.b.f.e.d5
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof c.c.a.b.f.e.w4
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof c.c.a.b.f.e.k3
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4e
        L4d:
            throw r2
        L4e:
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.l4.a(c.c.a.b.f.e.b8, java.lang.Object):void");
    }

    public final void a(l4<T> l4Var) {
        for (int i2 = 0; i2 < l4Var.f4277a.c(); i2++) {
            a((Map.Entry) l4Var.f4277a.a(i2));
        }
        Iterator<Map.Entry<T, Object>> it = l4Var.f4277a.d().iterator();
        while (it.hasNext()) {
            a((Map.Entry) it.next());
        }
    }

    public static Object a(Object obj) {
        if (obj instanceof i6) {
            return ((i6) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int b(n4<?> n4Var, Object obj) {
        b8 zzb = n4Var.zzb();
        int zza = n4Var.zza();
        if (n4Var.D()) {
            int i2 = 0;
            if (n4Var.E()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += b(zzb, it.next());
                }
                return b4.e(zza) + i2 + b4.l(i2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i2 += a(zzb, zza, it2.next());
            }
            return i2;
        }
        return a(zzb, zza, obj);
    }

    public final void a(Map.Entry<T, Object> entry) {
        d6 F;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof d5)) {
            if (key.D()) {
                Object a2 = a((l4<T>) key);
                if (a2 == null) {
                    a2 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) a2).add(a(it.next()));
                }
                this.f4277a.a((x6<T, Object>) key, (T) a2);
                return;
            }
            if (key.C() == e8.MESSAGE) {
                Object a3 = a((l4<T>) key);
                if (a3 == null) {
                    this.f4277a.a((x6<T, Object>) key, (T) a(value));
                    return;
                }
                if (a3 instanceof i6) {
                    F = key.a((i6) a3, (i6) value);
                } else {
                    F = key.a(((d6) a3).f(), (d6) value).F();
                }
                this.f4277a.a((x6<T, Object>) key, (T) F);
                return;
            }
            this.f4277a.a((x6<T, Object>) key, (T) a(value));
            return;
        }
        d5.c();
        throw null;
    }

    public static void a(b4 b4Var, b8 b8Var, int i2, Object obj) throws IOException {
        if (b8Var == b8.zzj) {
            d6 d6Var = (d6) obj;
            u4.a(d6Var);
            b4Var.a(i2, 3);
            d6Var.a(b4Var);
            b4Var.a(i2, 4);
        }
        b4Var.a(i2, b8Var.zzb());
        switch (k4.f4254b[b8Var.ordinal()]) {
            case 1:
                b4Var.a(((Double) obj).doubleValue());
                break;
            case 2:
                b4Var.a(((Float) obj).floatValue());
                break;
            case 3:
                b4Var.a(((Long) obj).longValue());
                break;
            case 4:
                b4Var.a(((Long) obj).longValue());
                break;
            case 5:
                b4Var.a(((Integer) obj).intValue());
                break;
            case 6:
                b4Var.c(((Long) obj).longValue());
                break;
            case 7:
                b4Var.d(((Integer) obj).intValue());
                break;
            case 8:
                b4Var.a(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((d6) obj).a(b4Var);
                break;
            case 10:
                b4Var.a((d6) obj);
                break;
            case 11:
                if (obj instanceof k3) {
                    b4Var.a((k3) obj);
                    break;
                } else {
                    b4Var.a((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof k3) {
                    b4Var.a((k3) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    b4Var.b(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                b4Var.b(((Integer) obj).intValue());
                break;
            case 14:
                b4Var.d(((Integer) obj).intValue());
                break;
            case 15:
                b4Var.c(((Long) obj).longValue());
                break;
            case 16:
                b4Var.c(((Integer) obj).intValue());
                break;
            case 17:
                b4Var.b(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof w4) {
                    b4Var.a(((w4) obj).zza());
                    break;
                } else {
                    b4Var.a(((Integer) obj).intValue());
                    break;
                }
        }
    }

    public static int a(b8 b8Var, int i2, Object obj) {
        int e2 = b4.e(i2);
        if (b8Var == b8.zzj) {
            u4.a((d6) obj);
            e2 <<= 1;
        }
        return e2 + b(b8Var, obj);
    }
}
