package com.lxj.xpopup.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import com.google.zxing.decoding.Intents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class XPermission {
    public static List<String> k;
    public static XPermission l;
    public static d m;
    public static d n;

    /* renamed from: a, reason: collision with root package name */
    public Context f10799a;

    /* renamed from: b, reason: collision with root package name */
    public c f10800b;

    /* renamed from: c, reason: collision with root package name */
    public d f10801c;

    /* renamed from: d, reason: collision with root package name */
    public b f10802d;

    /* renamed from: e, reason: collision with root package name */
    public e f10803e;

    /* renamed from: f, reason: collision with root package name */
    public Set<String> f10804f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f10805g;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f10806h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f10807i;
    public List<String> j;

    public static class PermissionActivity extends Activity {
        public static void a(Context context, int i2) {
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(Intents.WifiConnect.TYPE, i2);
            context.startActivity(intent);
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        public void onActivityResult(int i2, int i3, Intent intent) {
            if (i2 == 2) {
                if (XPermission.m == null) {
                    return;
                }
                if (XPermission.l.c()) {
                    XPermission.m.a();
                } else {
                    XPermission.m.b();
                }
                d unused = XPermission.m = null;
            } else if (i2 == 3) {
                if (XPermission.n == null) {
                    return;
                }
                if (XPermission.l.b()) {
                    XPermission.n.a();
                } else {
                    XPermission.n.b();
                }
                d unused2 = XPermission.n = null;
            }
            finish();
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            getWindow().addFlags(262672);
            getWindow().getAttributes().alpha = 0.0f;
            int intExtra = getIntent().getIntExtra(Intents.WifiConnect.TYPE, 1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    super.onCreate(bundle);
                    XPermission.l.b(this, 2);
                    return;
                } else {
                    if (intExtra == 3) {
                        super.onCreate(bundle);
                        XPermission.l.a(this, 3);
                        return;
                    }
                    return;
                }
            }
            if (XPermission.l == null) {
                super.onCreate(bundle);
                Log.e("XPermission", "request permissions failed");
                finish();
                return;
            }
            if (XPermission.l.f10803e != null) {
                XPermission.l.f10803e.a(this);
            }
            super.onCreate(bundle);
            if (XPermission.l.c(this)) {
                finish();
                return;
            }
            if (XPermission.l.f10805g != null) {
                int size = XPermission.l.f10805g.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) XPermission.l.f10805g.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
            XPermission.l.b(this);
            finish();
        }
    }

    public class a implements c.a {
        public a(XPermission xPermission) {
        }
    }

    public interface b {
        void a(List<String> list);

        void a(List<String> list, List<String> list2);
    }

    public interface c {

        public interface a {
        }

        void a(a aVar);
    }

    public interface d {
        void a();

        void b();
    }

    public interface e {
        void a(Activity activity);
    }

    public XPermission(Context context, String... strArr) {
        l = this;
        this.f10799a = context;
        a(strArr);
    }

    public static XPermission l() {
        return l;
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f10799a.getPackageName()));
        if (a(intent)) {
            this.f10799a.startActivity(intent.addFlags(268435456));
        }
    }

    public void e() {
        this.f10799a = null;
    }

    public void f() {
        this.f10806h = new ArrayList();
        this.f10805g = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.f10806h.addAll(this.f10804f);
            g();
            return;
        }
        for (String str : this.f10804f) {
            if (b(str)) {
                this.f10806h.add(str);
            } else {
                this.f10805g.add(str);
            }
        }
        if (this.f10805g.isEmpty()) {
            g();
        } else {
            h();
        }
    }

    public final void g() {
        if (this.f10801c != null) {
            if (this.f10805g.size() == 0 || this.f10804f.size() == this.f10806h.size()) {
                this.f10801c.a();
            } else if (!this.f10807i.isEmpty()) {
                this.f10801c.b();
            }
            this.f10801c = null;
        }
        if (this.f10802d != null) {
            if (this.f10805g.size() == 0 || this.f10804f.size() == this.f10806h.size()) {
                this.f10802d.a(this.f10806h);
            } else if (!this.f10807i.isEmpty()) {
                this.f10802d.a(this.j, this.f10807i);
            }
            this.f10802d = null;
        }
        this.f10800b = null;
        this.f10803e = null;
    }

    public final void h() {
        this.f10807i = new ArrayList();
        this.j = new ArrayList();
        PermissionActivity.a(this.f10799a, 1);
    }

    public boolean c() {
        return Settings.System.canWrite(this.f10799a);
    }

    public final boolean c(Activity activity) {
        boolean z = false;
        if (this.f10800b != null) {
            Iterator<String> it = this.f10805g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    a(activity);
                    this.f10800b.a(new a(this));
                    z = true;
                    break;
                }
            }
            this.f10800b = null;
        }
        return z;
    }

    public List<String> a() {
        return a(this.f10799a.getPackageName());
    }

    public List<String> a(String str) {
        try {
            String[] strArr = this.f10799a.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    public final boolean b(String str) {
        return Build.VERSION.SDK_INT < 23 || a.h.b.a.a(this.f10799a, str) == 0;
    }

    @TargetApi(23)
    public final void b(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f10799a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    @TargetApi(23)
    public final void a(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.f10799a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public boolean b() {
        return Settings.canDrawOverlays(this.f10799a);
    }

    public final void b(Activity activity) {
        a(activity);
        g();
    }

    public static XPermission a(Context context, String... strArr) {
        XPermission xPermission = l;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.f10799a = context;
        xPermission.a(strArr);
        return l;
    }

    public final boolean a(Intent intent) {
        return this.f10799a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public final void a(String... strArr) {
        this.f10804f = new LinkedHashSet();
        k = a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : c.e.b.g.d.a(str)) {
                if (k.contains(str2)) {
                    this.f10804f.add(str2);
                }
            }
        }
    }

    public XPermission a(d dVar) {
        this.f10801c = dVar;
        return this;
    }

    public final void a(Activity activity) {
        for (String str : this.f10805g) {
            if (b(str)) {
                this.f10806h.add(str);
            } else {
                this.f10807i.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.j.add(str);
                }
            }
        }
    }
}
