package c.g.a.f;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.hjq.permissions.Permission;
import java.util.ArrayList;

/* compiled from: BaseTask.kt */
/* loaded from: classes.dex */
public abstract class k implements l {

    /* renamed from: a, reason: collision with root package name */
    public p f6381a;

    /* renamed from: b, reason: collision with root package name */
    public l f6382b;

    /* renamed from: c, reason: collision with root package name */
    public m f6383c;

    /* renamed from: d, reason: collision with root package name */
    public n f6384d;

    public k(p pVar) {
        f.j.b.f.c(pVar, "pb");
        this.f6381a = pVar;
        this.f6383c = new m(pVar, this);
        this.f6384d = new n(this.f6381a, this);
        this.f6383c = new m(this.f6381a, this);
        this.f6384d = new n(this.f6381a, this);
    }

    @Override // c.g.a.f.l
    public m b() {
        return this.f6383c;
    }

    @Override // c.g.a.f.l
    public void c() {
        f.h hVar;
        l lVar = this.f6382b;
        if (lVar == null) {
            hVar = null;
        } else {
            lVar.a();
            hVar = f.h.f11319a;
        }
        if (hVar == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f6381a.m);
            arrayList.addAll(this.f6381a.n);
            arrayList.addAll(this.f6381a.k);
            if (this.f6381a.h()) {
                if (c.g.a.b.a(this.f6381a.a(), Permission.ACCESS_BACKGROUND_LOCATION)) {
                    this.f6381a.l.add(Permission.ACCESS_BACKGROUND_LOCATION);
                } else {
                    arrayList.add(Permission.ACCESS_BACKGROUND_LOCATION);
                }
            }
            if (this.f6381a.k() && Build.VERSION.SDK_INT >= 23 && this.f6381a.d() >= 23) {
                if (Settings.canDrawOverlays(this.f6381a.a())) {
                    this.f6381a.l.add(Permission.SYSTEM_ALERT_WINDOW);
                } else {
                    arrayList.add(Permission.SYSTEM_ALERT_WINDOW);
                }
            }
            if (this.f6381a.l() && Build.VERSION.SDK_INT >= 23 && this.f6381a.d() >= 23) {
                if (Settings.System.canWrite(this.f6381a.a())) {
                    this.f6381a.l.add(Permission.WRITE_SETTINGS);
                } else {
                    arrayList.add(Permission.WRITE_SETTINGS);
                }
            }
            if (this.f6381a.j()) {
                if (Build.VERSION.SDK_INT < 30 || !Environment.isExternalStorageManager()) {
                    arrayList.add(Permission.MANAGE_EXTERNAL_STORAGE);
                } else {
                    this.f6381a.l.add(Permission.MANAGE_EXTERNAL_STORAGE);
                }
            }
            if (this.f6381a.i()) {
                if (Build.VERSION.SDK_INT < 26 || this.f6381a.d() < 26) {
                    arrayList.add(Permission.REQUEST_INSTALL_PACKAGES);
                } else if (this.f6381a.a().getPackageManager().canRequestPackageInstalls()) {
                    this.f6381a.l.add(Permission.REQUEST_INSTALL_PACKAGES);
                } else {
                    arrayList.add(Permission.REQUEST_INSTALL_PACKAGES);
                }
            }
            c.g.a.c.d dVar = this.f6381a.q;
            if (dVar != null) {
                f.j.b.f.a(dVar);
                dVar.onResult(arrayList.isEmpty(), new ArrayList(this.f6381a.l), arrayList);
            }
            this.f6381a.f();
            this.f6381a.g();
        }
    }

    @Override // c.g.a.f.l
    public n d() {
        return this.f6384d;
    }
}
