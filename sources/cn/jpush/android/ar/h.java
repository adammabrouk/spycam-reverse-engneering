package cn.jpush.android.ar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9301a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9302b = false;

    /* renamed from: c, reason: collision with root package name */
    public String f9303c = "";

    /* renamed from: d, reason: collision with root package name */
    public WindowManager f9304d;

    private WindowManager a(Context context) {
        if (context != null) {
            return (WindowManager) context.getSystemService("window");
        }
        return null;
    }

    private boolean a(Activity activity, View view) {
        Point b2 = b(activity.getApplicationContext());
        Rect rect = new Rect(0, 0, b2.x, b2.y);
        view.getLocationInWindow(new int[2]);
        return view.getLocalVisibleRect(rect) && view.getGlobalVisibleRect(rect);
    }

    private Point b(Context context) {
        WindowManager windowManager;
        Point point = new Point();
        if (context != null && (windowManager = this.f9304d) != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (i2 >= 13) {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }

    public int a(Context context, cn.jpush.android.aq.c cVar, boolean z) {
        try {
            this.f9303c = "";
            this.f9302b = z;
            cn.jpush.android.au.c f2 = cVar.f();
            View d2 = cVar.d();
            if (d2 == null) {
                return 101;
            }
            this.f9304d = a(context);
            if (context instanceof Activity) {
                this.f9303c = context.getClass().getCanonicalName();
                context = context.getApplicationContext();
            }
            if (this.f9304d == null) {
                return 102;
            }
            if (!cVar.b(context)) {
                cn.jpush.android.r.b.b("InAppWindowManager", "isSameOrientation is false");
                return 104;
            }
            Object a2 = cVar.a(context, f2, z, this.f9304d, d2);
            if (a2 instanceof Integer) {
                return ((Integer) a2).intValue();
            }
            cVar.a(context);
            cVar.a(this.f9304d, context);
            this.f9301a = true;
            return 0;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppWindowManager", "window manage add view failed. " + th.getMessage());
            return 103;
        }
    }

    public long a(Context context, cn.jpush.android.aq.c cVar) {
        long j = 0;
        if (cVar != null && context != null) {
            try {
                View d2 = cVar.d();
                View a2 = cVar.a();
                if (a2 != null) {
                    d2 = a2;
                }
                if (d2 != null) {
                    if (this.f9304d != null && a(cVar)) {
                        this.f9304d.removeViewImmediate(d2);
                        this.f9301a = false;
                        cn.jpush.android.r.b.b("InAppWindowManager", "[destroy] - window manager removeViewImmediate view succeed.");
                        j = Math.max(SystemClock.elapsedRealtime() - cVar.c().w, 0L);
                        cn.jpush.android.r.b.b("InAppWindowManager", "inapp exposure total time: " + j);
                    }
                    cVar.b();
                }
                this.f9303c = "";
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppWindowManager", "[destroy]  removeViewImmediate view from window error. " + th.getMessage());
            }
        }
        return j;
    }

    public boolean a() {
        return this.f9302b;
    }

    public boolean a(Context context, cn.jpush.android.aq.c cVar, View view) {
        Activity a2;
        if (!a(cVar) || (a2 = cn.jpush.android.p.c.a(context)) == null) {
            return false;
        }
        try {
            return a((Activity) new WeakReference(a2).get(), view);
        } catch (Throwable unused) {
            return true;
        }
    }

    public boolean a(cn.jpush.android.aq.c cVar) {
        if (cVar == null || cVar.d() == null) {
            return false;
        }
        boolean isShown = cVar.d().isShown();
        cn.jpush.android.r.b.b("InAppWindowManager", "webview is displayed, status: " + isShown + ", isDisplayed: " + this.f9301a);
        return isShown && this.f9301a;
    }

    public boolean a(String str) {
        cn.jpush.android.r.b.b("InAppWindowManager", "[checkShouldDestroy] drawlay: " + this.f9302b + ", showActivityName: " + this.f9303c + ", curActivityName: " + str);
        return !this.f9302b && b(str);
    }

    public boolean b(cn.jpush.android.aq.c cVar) {
        return (cVar == null || cVar.d() == null) ? false : true;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals(this.f9303c);
    }
}
