package c.g.a.f;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import com.hjq.permissions.Permission;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: InvisibleFragment.kt */
/* loaded from: classes.dex */
public final class o extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public p f6387a;

    /* renamed from: b, reason: collision with root package name */
    public l f6388b;

    /* renamed from: c, reason: collision with root package name */
    public final a.a.e.b<String[]> f6389c;

    /* renamed from: d, reason: collision with root package name */
    public final a.a.e.b<String> f6390d;

    /* renamed from: e, reason: collision with root package name */
    public final a.a.e.b<Intent> f6391e;

    /* renamed from: f, reason: collision with root package name */
    public final a.a.e.b<Intent> f6392f;

    /* renamed from: g, reason: collision with root package name */
    public final a.a.e.b<Intent> f6393g;

    /* renamed from: h, reason: collision with root package name */
    public final a.a.e.b<Intent> f6394h;

    /* renamed from: i, reason: collision with root package name */
    public final a.a.e.b<Intent> f6395i;

    public o() {
        a.a.e.b<String[]> registerForActivityResult = registerForActivityResult(new a.a.e.d.b(), new a.a.e.a() { // from class: c.g.a.f.j
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.a(o.this, (Map) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult, "registerForActivityResul…esult(grantResults)\n    }");
        this.f6389c = registerForActivityResult;
        a.a.e.b<String> registerForActivityResult2 = registerForActivityResult(new a.a.e.d.c(), new a.a.e.a() { // from class: c.g.a.f.i
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.a(o.this, (Boolean) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult2, "registerForActivityResul…sionResult(granted)\n    }");
        this.f6390d = registerForActivityResult2;
        a.a.e.b<Intent> registerForActivityResult3 = registerForActivityResult(new a.a.e.d.d(), new a.a.e.a() { // from class: c.g.a.f.e
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.d(o.this, (ActivityResult) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult3, "registerForActivityResul…wPermissionResult()\n    }");
        this.f6391e = registerForActivityResult3;
        a.a.e.b<Intent> registerForActivityResult4 = registerForActivityResult(new a.a.e.d.d(), new a.a.e.a() { // from class: c.g.a.f.h
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.e(o.this, (ActivityResult) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult4, "registerForActivityResul…sPermissionResult()\n    }");
        this.f6392f = registerForActivityResult4;
        a.a.e.b<Intent> registerForActivityResult5 = registerForActivityResult(new a.a.e.d.d(), new a.a.e.a() { // from class: c.g.a.f.g
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.c(o.this, (ActivityResult) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult5, "registerForActivityResul…ePermissionResult()\n    }");
        this.f6393g = registerForActivityResult5;
        a.a.e.b<Intent> registerForActivityResult6 = registerForActivityResult(new a.a.e.d.d(), new a.a.e.a() { // from class: c.g.a.f.c
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.b(o.this, (ActivityResult) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult6, "registerForActivityResul…sPermissionResult()\n    }");
        this.f6394h = registerForActivityResult6;
        a.a.e.b<Intent> registerForActivityResult7 = registerForActivityResult(new a.a.e.d.d(), new a.a.e.a() { // from class: c.g.a.f.a
            @Override // a.a.e.a
            public final void a(Object obj) {
                o.a(o.this, (ActivityResult) obj);
            }
        });
        f.j.b.f.b(registerForActivityResult7, "registerForActivityResul…issions))\n        }\n    }");
        this.f6395i = registerForActivityResult7;
    }

    public static final void a(o oVar, Map map) {
        f.j.b.f.c(oVar, "this$0");
        f.j.b.f.b(map, "grantResults");
        oVar.a((Map<String, Boolean>) map);
    }

    public static final void b(o oVar, ActivityResult activityResult) {
        f.j.b.f.c(oVar, "this$0");
        oVar.c();
    }

    public static final void c(o oVar, ActivityResult activityResult) {
        f.j.b.f.c(oVar, "this$0");
        oVar.d();
    }

    public static final void d(o oVar, ActivityResult activityResult) {
        f.j.b.f.c(oVar, "this$0");
        oVar.e();
    }

    public static final void e(o oVar, ActivityResult activityResult) {
        f.j.b.f.c(oVar, "this$0");
        oVar.f();
    }

    public final void f() {
        if (a()) {
            if (Build.VERSION.SDK_INT < 23) {
                l lVar = this.f6388b;
                if (lVar != null) {
                    lVar.c();
                    return;
                } else {
                    f.j.b.f.e("task");
                    throw null;
                }
            }
            if (Settings.System.canWrite(getContext())) {
                l lVar2 = this.f6388b;
                if (lVar2 != null) {
                    lVar2.c();
                    return;
                } else {
                    f.j.b.f.e("task");
                    throw null;
                }
            }
            p pVar = this.f6387a;
            if (pVar == null) {
                f.j.b.f.e("pb");
                throw null;
            }
            if (pVar.r == null) {
                if (pVar == null) {
                    f.j.b.f.e("pb");
                    throw null;
                }
                if (pVar.s == null) {
                    return;
                }
            }
            p pVar2 = this.f6387a;
            if (pVar2 == null) {
                f.j.b.f.e("pb");
                throw null;
            }
            c.g.a.c.b bVar = pVar2.s;
            if (bVar != null) {
                if (pVar2 == null) {
                    f.j.b.f.e("pb");
                    throw null;
                }
                f.j.b.f.a(bVar);
                l lVar3 = this.f6388b;
                if (lVar3 != null) {
                    bVar.a(lVar3.b(), f.i.g.a(Permission.WRITE_SETTINGS), false);
                    return;
                } else {
                    f.j.b.f.e("task");
                    throw null;
                }
            }
            if (pVar2 == null) {
                f.j.b.f.e("pb");
                throw null;
            }
            c.g.a.c.a aVar = pVar2.r;
            f.j.b.f.a(aVar);
            l lVar4 = this.f6388b;
            if (lVar4 != null) {
                aVar.onExplainReason(lVar4.b(), f.i.g.a(Permission.WRITE_SETTINGS));
            } else {
                f.j.b.f.e("task");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a()) {
            p pVar = this.f6387a;
            if (pVar == null) {
                f.j.b.f.e("pb");
                throw null;
            }
            Dialog dialog = pVar.f6401f;
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public static final void a(o oVar, Boolean bool) {
        f.j.b.f.c(oVar, "this$0");
        f.j.b.f.b(bool, "granted");
        oVar.a(bool.booleanValue());
    }

    public final void b(p pVar, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        if (Build.VERSION.SDK_INT < 26) {
            c();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(Uri.parse(f.j.b.f.a("package:", (Object) requireActivity().getPackageName())));
        this.f6394h.a(intent);
    }

    public final void c(p pVar, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            d();
        } else {
            this.f6393g.a(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
        }
    }

    public final void d(p pVar, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(getContext())) {
            e();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse(f.j.b.f.a("package:", (Object) requireActivity().getPackageName())));
        this.f6391e.a(intent);
    }

    public final void e(p pVar, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(getContext())) {
            f();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse(f.j.b.f.a("package:", (Object) requireActivity().getPackageName())));
        this.f6392f.a(intent);
    }

    public static final void a(o oVar, ActivityResult activityResult) {
        f.j.b.f.c(oVar, "this$0");
        if (oVar.a()) {
            l lVar = oVar.f6388b;
            if (lVar == null) {
                f.j.b.f.e("task");
                throw null;
            }
            p pVar = oVar.f6387a;
            if (pVar != null) {
                lVar.a(new ArrayList(pVar.p));
            } else {
                f.j.b.f.e("pb");
                throw null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(p pVar, Set<String> set, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(set, "permissions");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        a.a.e.b<String[]> bVar = this.f6389c;
        Object[] array = set.toArray(new String[0]);
        if (array != null) {
            bVar.a(array);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void c() {
        if (a()) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (requireActivity().getPackageManager().canRequestPackageInstalls()) {
                    l lVar = this.f6388b;
                    if (lVar != null) {
                        lVar.c();
                        return;
                    } else {
                        f.j.b.f.e("task");
                        throw null;
                    }
                }
                p pVar = this.f6387a;
                if (pVar != null) {
                    if (pVar.r == null) {
                        if (pVar == null) {
                            f.j.b.f.e("pb");
                            throw null;
                        }
                        if (pVar.s == null) {
                            return;
                        }
                    }
                    p pVar2 = this.f6387a;
                    if (pVar2 == null) {
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    c.g.a.c.b bVar = pVar2.s;
                    if (bVar != null) {
                        if (pVar2 != null) {
                            f.j.b.f.a(bVar);
                            l lVar2 = this.f6388b;
                            if (lVar2 != null) {
                                bVar.a(lVar2.b(), f.i.g.a(Permission.REQUEST_INSTALL_PACKAGES), false);
                                return;
                            } else {
                                f.j.b.f.e("task");
                                throw null;
                            }
                        }
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    if (pVar2 != null) {
                        c.g.a.c.a aVar = pVar2.r;
                        f.j.b.f.a(aVar);
                        l lVar3 = this.f6388b;
                        if (lVar3 != null) {
                            aVar.onExplainReason(lVar3.b(), f.i.g.a(Permission.REQUEST_INSTALL_PACKAGES));
                            return;
                        } else {
                            f.j.b.f.e("task");
                            throw null;
                        }
                    }
                    f.j.b.f.e("pb");
                    throw null;
                }
                f.j.b.f.e("pb");
                throw null;
            }
            l lVar4 = this.f6388b;
            if (lVar4 != null) {
                lVar4.c();
            } else {
                f.j.b.f.e("task");
                throw null;
            }
        }
    }

    public final void b() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        this.f6395i.a(intent);
    }

    public final void d() {
        if (a()) {
            if (Build.VERSION.SDK_INT >= 30) {
                if (Environment.isExternalStorageManager()) {
                    l lVar = this.f6388b;
                    if (lVar != null) {
                        lVar.c();
                        return;
                    } else {
                        f.j.b.f.e("task");
                        throw null;
                    }
                }
                p pVar = this.f6387a;
                if (pVar != null) {
                    if (pVar.r == null) {
                        if (pVar == null) {
                            f.j.b.f.e("pb");
                            throw null;
                        }
                        if (pVar.s == null) {
                            return;
                        }
                    }
                    p pVar2 = this.f6387a;
                    if (pVar2 == null) {
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    c.g.a.c.b bVar = pVar2.s;
                    if (bVar != null) {
                        if (pVar2 != null) {
                            f.j.b.f.a(bVar);
                            l lVar2 = this.f6388b;
                            if (lVar2 != null) {
                                bVar.a(lVar2.b(), f.i.g.a(Permission.MANAGE_EXTERNAL_STORAGE), false);
                                return;
                            } else {
                                f.j.b.f.e("task");
                                throw null;
                            }
                        }
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    if (pVar2 != null) {
                        c.g.a.c.a aVar = pVar2.r;
                        f.j.b.f.a(aVar);
                        l lVar3 = this.f6388b;
                        if (lVar3 != null) {
                            aVar.onExplainReason(lVar3.b(), f.i.g.a(Permission.MANAGE_EXTERNAL_STORAGE));
                            return;
                        } else {
                            f.j.b.f.e("task");
                            throw null;
                        }
                    }
                    f.j.b.f.e("pb");
                    throw null;
                }
                f.j.b.f.e("pb");
                throw null;
            }
            l lVar4 = this.f6388b;
            if (lVar4 != null) {
                lVar4.c();
            } else {
                f.j.b.f.e("task");
                throw null;
            }
        }
    }

    public final void e() {
        if (a()) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    l lVar = this.f6388b;
                    if (lVar != null) {
                        lVar.c();
                        return;
                    } else {
                        f.j.b.f.e("task");
                        throw null;
                    }
                }
                p pVar = this.f6387a;
                if (pVar != null) {
                    if (pVar.r == null) {
                        if (pVar == null) {
                            f.j.b.f.e("pb");
                            throw null;
                        }
                        if (pVar.s == null) {
                            return;
                        }
                    }
                    p pVar2 = this.f6387a;
                    if (pVar2 == null) {
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    c.g.a.c.b bVar = pVar2.s;
                    if (bVar != null) {
                        if (pVar2 != null) {
                            f.j.b.f.a(bVar);
                            l lVar2 = this.f6388b;
                            if (lVar2 != null) {
                                bVar.a(lVar2.b(), f.i.g.a(Permission.SYSTEM_ALERT_WINDOW), false);
                                return;
                            } else {
                                f.j.b.f.e("task");
                                throw null;
                            }
                        }
                        f.j.b.f.e("pb");
                        throw null;
                    }
                    if (pVar2 != null) {
                        c.g.a.c.a aVar = pVar2.r;
                        f.j.b.f.a(aVar);
                        l lVar3 = this.f6388b;
                        if (lVar3 != null) {
                            aVar.onExplainReason(lVar3.b(), f.i.g.a(Permission.SYSTEM_ALERT_WINDOW));
                            return;
                        } else {
                            f.j.b.f.e("task");
                            throw null;
                        }
                    }
                    f.j.b.f.e("pb");
                    throw null;
                }
                f.j.b.f.e("pb");
                throw null;
            }
            l lVar4 = this.f6388b;
            if (lVar4 != null) {
                lVar4.c();
            } else {
                f.j.b.f.e("task");
                throw null;
            }
        }
    }

    public final void a(p pVar, l lVar) {
        f.j.b.f.c(pVar, "permissionBuilder");
        f.j.b.f.c(lVar, "chainTask");
        this.f6387a = pVar;
        this.f6388b = lVar;
        this.f6390d.a(Permission.ACCESS_BACKGROUND_LOCATION);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0123, code lost:
    
        if (r9.s != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b7, code lost:
    
        if ((!r9.o.isEmpty()) != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01ff, code lost:
    
        if (r9.j == false) goto L159;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0218  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.Map<java.lang.String, java.lang.Boolean> r9) {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.g.a.f.o.a(java.util.Map):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        if (r5.s != null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r9) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.g.a.f.o.a(boolean):void");
    }

    public final boolean a() {
        if (this.f6387a != null && this.f6388b != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }
}
