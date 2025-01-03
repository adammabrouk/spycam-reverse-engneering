package c.g.a.f;

import android.os.Build;
import android.provider.Settings;
import com.hjq.permissions.Permission;
import java.util.List;

/* compiled from: RequestWriteSettingsPermission.kt */
/* loaded from: classes.dex */
public final class w extends k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(p pVar) {
        super(pVar);
        f.j.b.f.c(pVar, "permissionBuilder");
    }

    @Override // c.g.a.f.l
    public void a() {
        if (!this.f6381a.l()) {
            c();
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || this.f6381a.d() < 23) {
            this.f6381a.l.add(Permission.WRITE_SETTINGS);
            this.f6381a.f6403h.remove(Permission.WRITE_SETTINGS);
            c();
            return;
        }
        if (Settings.System.canWrite(this.f6381a.a())) {
            c();
            return;
        }
        p pVar = this.f6381a;
        if (pVar.r == null && pVar.s == null) {
            c();
            return;
        }
        List<String> b2 = f.i.h.b(Permission.WRITE_SETTINGS);
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
        this.f6381a.e(this);
    }
}
