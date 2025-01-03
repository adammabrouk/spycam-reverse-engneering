package c.c.a.b.d;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: c.c.a.b.d.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0092a extends c.c.a.b.f.c.b implements a {

        /* renamed from: c.c.a.b.d.a$a$a, reason: collision with other inner class name */
        public static class C0093a extends c.c.a.b.f.c.a implements a {
            public C0093a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0092a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0093a(iBinder);
        }
    }
}
