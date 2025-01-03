package c.g.a.f;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hjq.permissions.Permission;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: PermissionBuilder.kt */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public FragmentActivity f6396a;

    /* renamed from: b, reason: collision with root package name */
    public Fragment f6397b;

    /* renamed from: c, reason: collision with root package name */
    public int f6398c;

    /* renamed from: d, reason: collision with root package name */
    public int f6399d;

    /* renamed from: e, reason: collision with root package name */
    public int f6400e;

    /* renamed from: f, reason: collision with root package name */
    public Dialog f6401f;

    /* renamed from: g, reason: collision with root package name */
    public Set<String> f6402g;

    /* renamed from: h, reason: collision with root package name */
    public Set<String> f6403h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6404i;
    public boolean j;
    public Set<String> k;
    public Set<String> l;
    public Set<String> m;
    public Set<String> n;
    public Set<String> o;
    public Set<String> p;
    public c.g.a.c.d q;
    public c.g.a.c.a r;
    public c.g.a.c.b s;
    public c.g.a.c.c t;

    /* compiled from: PermissionBuilder.kt */
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

    public p(FragmentActivity fragmentActivity, Fragment fragment, Set<String> set, Set<String> set2) {
        f.j.b.f.c(set, "normalPermissions");
        f.j.b.f.c(set2, "specialPermissions");
        this.f6398c = -1;
        this.f6399d = -1;
        this.f6400e = -1;
        this.k = new LinkedHashSet();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashSet();
        this.o = new LinkedHashSet();
        this.p = new LinkedHashSet();
        if (fragmentActivity != null) {
            a(fragmentActivity);
        }
        if (fragmentActivity == null && fragment != null) {
            FragmentActivity requireActivity = fragment.requireActivity();
            f.j.b.f.b(requireActivity, "fragment.requireActivity()");
            a(requireActivity);
        }
        this.f6397b = fragment;
        this.f6402g = set;
        this.f6403h = set2;
    }

    public final FragmentActivity a() {
        FragmentActivity fragmentActivity = this.f6396a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        f.j.b.f.e("activity");
        throw null;
    }

    public final void b(l lVar) {
        f.j.b.f.c(lVar, "chainTask");
        c().b(this, lVar);
    }

    public final void c(l lVar) {
        f.j.b.f.c(lVar, "chainTask");
        c().c(this, lVar);
    }

    public final void d(l lVar) {
        f.j.b.f.c(lVar, "chainTask");
        c().d(this, lVar);
    }

    public final void e(l lVar) {
        f.j.b.f.c(lVar, "chainTask");
        c().e(this, lVar);
    }

    public final void f() {
        Fragment c2 = b().c("InvisibleFragment");
        if (c2 != null) {
            a.k.a.r b2 = b().b();
            b2.d(c2);
            b2.b();
        }
    }

    public final void g() {
        a().setRequestedOrientation(this.f6400e);
    }

    public final boolean h() {
        return this.f6403h.contains(Permission.ACCESS_BACKGROUND_LOCATION);
    }

    public final boolean i() {
        return this.f6403h.contains(Permission.REQUEST_INSTALL_PACKAGES);
    }

    public final boolean j() {
        return this.f6403h.contains(Permission.MANAGE_EXTERNAL_STORAGE);
    }

    public final boolean k() {
        return this.f6403h.contains(Permission.SYSTEM_ALERT_WINDOW);
    }

    public final boolean l() {
        return this.f6403h.contains(Permission.WRITE_SETTINGS);
    }

    public final void a(FragmentActivity fragmentActivity) {
        f.j.b.f.c(fragmentActivity, "<set-?>");
        this.f6396a = fragmentActivity;
    }

    public final FragmentManager b() {
        Fragment fragment = this.f6397b;
        FragmentManager childFragmentManager = fragment == null ? null : fragment.getChildFragmentManager();
        if (childFragmentManager != null) {
            return childFragmentManager;
        }
        FragmentManager supportFragmentManager = a().getSupportFragmentManager();
        f.j.b.f.b(supportFragmentManager, "activity.supportFragmentManager");
        return supportFragmentManager;
    }

    public final o c() {
        Fragment c2 = b().c("InvisibleFragment");
        if (c2 != null) {
            return (o) c2;
        }
        o oVar = new o();
        a.k.a.r b2 = b().b();
        b2.a(oVar, "InvisibleFragment");
        b2.d();
        return oVar;
    }

    public final int d() {
        return a().getApplicationInfo().targetSdkVersion;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void e() {
        this.f6400e = a().getRequestedOrientation();
        int i2 = a().getResources().getConfiguration().orientation;
        if (i2 == 1) {
            a().setRequestedOrientation(7);
        } else {
            if (i2 != 2) {
                return;
            }
            a().setRequestedOrientation(6);
        }
    }

    public final p a(c.g.a.c.a aVar) {
        this.r = aVar;
        return this;
    }

    public final void a(c.g.a.c.d dVar) {
        this.q = dVar;
        e();
        r rVar = new r();
        rVar.a(new u(this));
        rVar.a(new q(this));
        rVar.a(new v(this));
        rVar.a(new w(this));
        rVar.a(new t(this));
        rVar.a(new s(this));
        rVar.a();
    }

    public final void a(l lVar, boolean z, List<String> list, String str, String str2, String str3) {
        f.j.b.f.c(lVar, "chainTask");
        f.j.b.f.c(list, "permissions");
        f.j.b.f.c(str, "message");
        f.j.b.f.c(str2, "positiveText");
        a(lVar, z, new c.g.a.e.a(a(), list, str, str2, str3, this.f6398c, this.f6399d));
    }

    public final void a(final l lVar, final boolean z, final c.g.a.e.c cVar) {
        f.j.b.f.c(lVar, "chainTask");
        f.j.b.f.c(cVar, "dialog");
        this.j = true;
        final List<String> b2 = cVar.b();
        f.j.b.f.b(b2, "dialog.permissionsToRequest");
        if (b2.isEmpty()) {
            lVar.c();
            return;
        }
        this.f6401f = cVar;
        cVar.show();
        if ((cVar instanceof c.g.a.e.a) && ((c.g.a.e.a) cVar).f()) {
            cVar.dismiss();
            lVar.c();
        }
        View c2 = cVar.c();
        f.j.b.f.b(c2, "dialog.positiveButton");
        View a2 = cVar.a();
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        c2.setClickable(true);
        c2.setOnClickListener(new View.OnClickListener() { // from class: c.g.a.f.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.a(c.g.a.e.c.this, z, lVar, b2, this, view);
            }
        });
        if (a2 != null) {
            a2.setClickable(true);
            a2.setOnClickListener(new View.OnClickListener() { // from class: c.g.a.f.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.a(c.g.a.e.c.this, lVar, view);
                }
            });
        }
        Dialog dialog = this.f6401f;
        if (dialog == null) {
            return;
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: c.g.a.f.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                p.a(p.this, dialogInterface);
            }
        });
    }

    public static final void a(c.g.a.e.c cVar, boolean z, l lVar, List list, p pVar, View view) {
        f.j.b.f.c(cVar, "$dialog");
        f.j.b.f.c(lVar, "$chainTask");
        f.j.b.f.c(list, "$permissions");
        f.j.b.f.c(pVar, "this$0");
        cVar.dismiss();
        if (z) {
            lVar.a(list);
        } else {
            pVar.a((List<String>) list);
        }
    }

    public static final void a(c.g.a.e.c cVar, l lVar, View view) {
        f.j.b.f.c(cVar, "$dialog");
        f.j.b.f.c(lVar, "$chainTask");
        cVar.dismiss();
        lVar.c();
    }

    public static final void a(p pVar, DialogInterface dialogInterface) {
        f.j.b.f.c(pVar, "this$0");
        pVar.f6401f = null;
    }

    public final void a(Set<String> set, l lVar) {
        f.j.b.f.c(set, "permissions");
        f.j.b.f.c(lVar, "chainTask");
        c().a(this, set, lVar);
    }

    public final void a(l lVar) {
        f.j.b.f.c(lVar, "chainTask");
        c().a(this, lVar);
    }

    public final void a(List<String> list) {
        this.p.clear();
        this.p.addAll(list);
        c().b();
    }
}
