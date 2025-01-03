package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import com.shix.shixipc.system.ContentCommon;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class e4 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile e4 f4142b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile e4 f4143c;

    /* renamed from: d, reason: collision with root package name */
    public static final e4 f4144d = new e4(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, s4.f<?, ?>> f4145a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f4146a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4147b;

        public a(Object obj, int i2) {
            this.f4146a = obj;
            this.f4147b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4146a == aVar.f4146a && this.f4147b == aVar.f4147b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f4146a) * ContentCommon.INVALID_OPTION) + this.f4147b;
        }
    }

    public e4() {
        this.f4145a = new HashMap();
    }

    public static e4 a() {
        e4 e4Var = f4142b;
        if (e4Var == null) {
            synchronized (e4.class) {
                e4Var = f4142b;
                if (e4Var == null) {
                    e4Var = f4144d;
                    f4142b = e4Var;
                }
            }
        }
        return e4Var;
    }

    public static e4 b() {
        e4 e4Var = f4143c;
        if (e4Var != null) {
            return e4Var;
        }
        synchronized (e4.class) {
            e4 e4Var2 = f4143c;
            if (e4Var2 != null) {
                return e4Var2;
            }
            e4 a2 = q4.a(e4.class);
            f4143c = a2;
            return a2;
        }
    }

    public e4(boolean z) {
        this.f4145a = Collections.emptyMap();
    }

    public final <ContainingType extends d6> s4.f<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (s4.f) this.f4145a.get(new a(containingtype, i2));
    }
}
