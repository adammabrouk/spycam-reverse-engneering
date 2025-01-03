package c.g.a.f;

import android.os.Build;
import com.hjq.permissions.Permission;
import java.util.List;

/* compiled from: RequestInstallPackagesPermission.kt */
/* loaded from: classes.dex */
public final class s extends k {

    /* compiled from: RequestInstallPackagesPermission.kt */
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
    public s(p pVar) {
        super(pVar);
        f.j.b.f.c(pVar, "permissionBuilder");
    }

    @Override // c.g.a.f.l
    public void a() {
        if (!this.f6381a.i() || Build.VERSION.SDK_INT < 26 || this.f6381a.d() < 26) {
            c();
            return;
        }
        if (this.f6381a.a().getPackageManager().canRequestPackageInstalls()) {
            c();
            return;
        }
        p pVar = this.f6381a;
        if (pVar.r == null && pVar.s == null) {
            c();
            return;
        }
        List<String> b2 = f.i.h.b(Permission.REQUEST_INSTALL_PACKAGES);
        p pVar2 = this.f6381a;
        c.g.a.c.b bVar = pVar2.s;
        if (bVar != null) {
            f.j.b.f.a(bVar);
            bVar.a(b(), b2, true);
        } else {
            c.g.a.c.a aVar = pVar2.r;
            f.j.b.f.a(aVar);
            aVar.onExplainReason(b(), b2);
        }
    }

    @Override // c.g.a.f.l
    public void a(List<String> list) {
        f.j.b.f.c(list, "permissions");
        this.f6381a.b(this);
    }
}
