package androidx.lifecycle;

import a.m.c;
import a.m.f;
import a.m.g;
import a.m.i;

/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements g {

    /* renamed from: a, reason: collision with root package name */
    public final c f2644a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2645b;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2646a;

        static {
            int[] iArr = new int[f.b.values().length];
            f2646a = iArr;
            try {
                iArr[f.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2646a[f.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2646a[f.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2646a[f.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2646a[f.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2646a[f.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2646a[f.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(c cVar, g gVar) {
        this.f2644a = cVar;
        this.f2645b = gVar;
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        switch (a.f2646a[bVar.ordinal()]) {
            case 1:
                this.f2644a.c(iVar);
                break;
            case 2:
                this.f2644a.e(iVar);
                break;
            case 3:
                this.f2644a.a(iVar);
                break;
            case 4:
                this.f2644a.d(iVar);
                break;
            case 5:
                this.f2644a.f(iVar);
                break;
            case 6:
                this.f2644a.b(iVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.f2645b;
        if (gVar != null) {
            gVar.a(iVar, bVar);
        }
    }
}
