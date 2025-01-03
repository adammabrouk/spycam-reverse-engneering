package c.g.a.f;

import android.os.Build;
import android.os.Environment;
import com.hjq.permissions.Permission;
import java.util.List;

/* compiled from: RequestManageExternalStoragePermission.kt */
/* loaded from: classes.dex */
public final class t extends k {

    /* compiled from: RequestManageExternalStoragePermission.kt */
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
    public t(p pVar) {
        super(pVar);
        f.j.b.f.c(pVar, "permissionBuilder");
    }

    @Override // c.g.a.f.l
    public void a() {
        if (!this.f6381a.j() || Build.VERSION.SDK_INT < 30) {
            c();
            return;
        }
        if (Environment.isExternalStorageManager()) {
            c();
            return;
        }
        p pVar = this.f6381a;
        if (pVar.r == null && pVar.s == null) {
            c();
            return;
        }
        List<String> b2 = f.i.h.b(Permission.MANAGE_EXTERNAL_STORAGE);
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
        this.f6381a.c(this);
    }
}
