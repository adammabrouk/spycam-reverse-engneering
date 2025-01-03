package a.h.h;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.h.h.d f1093a = new C0025e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final a.h.h.d f1094b = new C0025e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final a.h.h.d f1095c = new C0025e(b.f1099a, false);

    /* renamed from: d, reason: collision with root package name */
    public static final a.h.h.d f1096d = new C0025e(b.f1099a, true);

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f1097b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1098a;

        public a(boolean z) {
            this.f1098a = z;
        }

        @Override // a.h.h.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f1098a) {
                        return 1;
                    }
                } else if (this.f1098a) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f1098a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1099a = new b();

        @Override // a.h.h.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = e.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static abstract class d implements a.h.h.d {

        /* renamed from: a, reason: collision with root package name */
        public final c f1100a;

        public d(c cVar) {
            this.f1100a = cVar;
        }

        public abstract boolean a();

        @Override // a.h.h.d
        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            }
            return this.f1100a == null ? a() : b(charSequence, i2, i3);
        }

        public final boolean b(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f1100a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.h.h.e$e, reason: collision with other inner class name */
    public static class C0025e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1101b;

        public C0025e(c cVar, boolean z) {
            super(cVar);
            this.f1101b = z;
        }

        @Override // a.h.h.e.d
        public boolean a() {
            return this.f1101b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f1102b = new f();

        public f() {
            super(null);
        }

        @Override // a.h.h.e.d
        public boolean a() {
            return a.h.h.f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        new C0025e(a.f1097b, false);
        f fVar = f.f1102b;
    }

    public static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
