package a.m;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class f {

    /* compiled from: Lifecycle.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1512a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1513b;

        static {
            int[] iArr = new int[b.values().length];
            f1513b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1513b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1513b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1513b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1513b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1513b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1513b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            f1512a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1512a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1512a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1512a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1512a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: Lifecycle.java */
    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b downFrom(c cVar) {
            int i2 = a.f1512a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_DESTROY;
            }
            if (i2 == 2) {
                return ON_STOP;
            }
            if (i2 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static b downTo(c cVar) {
            int i2 = a.f1512a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_STOP;
            }
            if (i2 == 2) {
                return ON_PAUSE;
            }
            if (i2 != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        public static b upFrom(c cVar) {
            int i2 = a.f1512a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_START;
            }
            if (i2 == 2) {
                return ON_RESUME;
            }
            if (i2 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static b upTo(c cVar) {
            int i2 = a.f1512a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_CREATE;
            }
            if (i2 == 2) {
                return ON_START;
            }
            if (i2 != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public c getTargetState() {
            switch (a.f1513b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.java */
    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    public f() {
        new AtomicReference();
    }

    public abstract c a();

    public abstract void a(h hVar);

    public abstract void b(h hVar);
}
