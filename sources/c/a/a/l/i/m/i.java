package c.a.a.l.i.m;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f3143d = {Bitmap.Config.ARGB_8888, null};

    /* renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f3144e = {Bitmap.Config.RGB_565};

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f3145f = {Bitmap.Config.ARGB_4444};

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f3146g = {Bitmap.Config.ALPHA_8};

    /* renamed from: a, reason: collision with root package name */
    public final c f3147a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final e<b, Bitmap> f3148b = new e<>();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f3149c = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3150a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f3150a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3150a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3150a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3150a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    public static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        public final c f3151a;

        /* renamed from: b, reason: collision with root package name */
        public int f3152b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap.Config f3153c;

        public b(c cVar) {
            this.f3151a = cVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f3152b != bVar.f3152b) {
                return false;
            }
            Bitmap.Config config = this.f3153c;
            Bitmap.Config config2 = bVar.f3153c;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f3152b * 31;
            Bitmap.Config config = this.f3153c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return i.b(this.f3152b, this.f3153c);
        }

        public void a(int i2, Bitmap.Config config) {
            this.f3152b = i2;
            this.f3153c = config;
        }

        @Override // c.a.a.l.i.m.h
        public void a() {
            this.f3151a.a(this);
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    public static class c extends c.a.a.l.i.m.b<b> {
        public b a(int i2, Bitmap.Config config) {
            b b2 = b();
            b2.a(i2, config);
            return b2;
        }

        @Override // c.a.a.l.i.m.b
        public b a() {
            return new b(this);
        }
    }

    @Override // c.a.a.l.i.m.g
    public String b(int i2, int i3, Bitmap.Config config) {
        return b(c.a.a.r.h.a(i2, i3, config), config);
    }

    @Override // c.a.a.l.i.m.g
    public String c(Bitmap bitmap) {
        return b(c.a.a.r.h.a(bitmap), bitmap.getConfig());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f3148b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f3149c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f3149c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @Override // c.a.a.l.i.m.g
    public void a(Bitmap bitmap) {
        b a2 = this.f3147a.a(c.a.a.r.h.a(bitmap), bitmap.getConfig());
        this.f3148b.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f3152b));
        a3.put(Integer.valueOf(a2.f3152b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // c.a.a.l.i.m.g
    public int b(Bitmap bitmap) {
        return c.a.a.r.h.a(bitmap);
    }

    public static String b(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    public static Bitmap.Config[] b(Bitmap.Config config) {
        int i2 = a.f3150a[config.ordinal()];
        if (i2 == 1) {
            return f3143d;
        }
        if (i2 == 2) {
            return f3144e;
        }
        if (i2 != 3) {
            return i2 != 4 ? new Bitmap.Config[]{config} : f3146g;
        }
        return f3145f;
    }

    @Override // c.a.a.l.i.m.g
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        int a2 = c.a.a.r.h.a(i2, i3, config);
        Bitmap a3 = this.f3148b.a((e<b, Bitmap>) a(this.f3147a.a(a2, config), a2, config));
        if (a3 != null) {
            a(Integer.valueOf(c.a.a.r.h.a(a3)), a3.getConfig());
            a3.reconfigure(i2, i3, a3.getConfig() != null ? a3.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a3;
    }

    public final b a(b bVar, int i2, Bitmap.Config config) {
        for (Bitmap.Config config2 : b(config)) {
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVar;
                        }
                    } else if (config2.equals(config)) {
                        return bVar;
                    }
                }
                this.f3147a.a(bVar);
                return this.f3147a.a(ceilingKey.intValue(), config2);
            }
        }
        return bVar;
    }

    @Override // c.a.a.l.i.m.g
    public Bitmap a() {
        Bitmap a2 = this.f3148b.a();
        if (a2 != null) {
            a(Integer.valueOf(c.a.a.r.h.a(a2)), a2.getConfig());
        }
        return a2;
    }

    public final void a(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> a2 = a(config);
        Integer num2 = (Integer) a2.get(num);
        if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f3149c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f3149c.put(config, treeMap);
        return treeMap;
    }
}
