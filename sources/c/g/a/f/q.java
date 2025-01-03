package c.g.a.f;

import android.os.Build;
import com.hjq.permissions.Permission;
import java.util.List;

/* compiled from: RequestBackgroundLocationPermission.kt */
/* loaded from: classes.dex */
public final class q extends k {

    /* compiled from: RequestBackgroundLocationPermission.kt */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.j.b.d dVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar) {
        super(pVar);
        f.j.b.f.c(pVar, "permissionBuilder");
    }

    @Override // c.g.a.f.l
    public void a() {
        if (this.f6381a.h()) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f6381a.f6403h.remove(Permission.ACCESS_BACKGROUND_LOCATION);
                this.f6381a.k.add(Permission.ACCESS_BACKGROUND_LOCATION);
            }
            if (c.g.a.b.a(this.f6381a.a(), Permission.ACCESS_BACKGROUND_LOCATION)) {
                c();
                return;
            }
            boolean a2 = c.g.a.b.a(this.f6381a.a(), Permission.ACCESS_FINE_LOCATION);
            boolean a3 = c.g.a.b.a(this.f6381a.a(), Permission.ACCESS_COARSE_LOCATION);
            if (a2 || a3) {
                p pVar = this.f6381a;
                if (pVar.r == null && pVar.s == null) {
                    a(f.i.h.a());
                    return;
                }
                List<String> b2 = f.i.h.b(Permission.ACCESS_BACKGROUND_LOCATION);
                p pVar2 = this.f6381a;
                c.g.a.c.b bVar = pVar2.s;
                if (bVar != null) {
                    f.j.b.f.a(bVar);
                    bVar.a(b(), b2, true);
                    return;
                } else {
                    c.g.a.c.a aVar = pVar2.r;
                    f.j.b.f.a(aVar);
                    aVar.onExplainReason(b(), b2);
                    return;
                }
            }
        }
        c();
    }

    @Override // c.g.a.f.l
    public void a(List<String> list) {
        f.j.b.f.c(list, "permissions");
        this.f6381a.a(this);
    }
}
