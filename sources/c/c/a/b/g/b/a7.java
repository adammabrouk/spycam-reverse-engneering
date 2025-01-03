package c.c.a.b.g.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
@TargetApi(14)
/* loaded from: classes.dex */
public final class a7 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h6 f4584a;

    public a7(h6 h6Var) {
        this.f4584a = h6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a1 A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f A[Catch: Exception -> 0x01d6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.a7.a(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f4584a.c().B().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                this.f4584a.j();
                this.f4584a.a().a(new e7(this, bundle == null, data, s9.a(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
            }
        } catch (Exception e2) {
            this.f4584a.c().t().a("Throwable caught in onActivityCreated", e2);
        } finally {
            this.f4584a.r().a(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f4584a.r().c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f4584a.r().b(activity);
        w8 t = this.f4584a.t();
        t.a().a(new y8(t, t.b().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        w8 t = this.f4584a.t();
        t.a().a(new v8(t, t.b().b()));
        this.f4584a.r().a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f4584a.r().b(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public /* synthetic */ a7(h6 h6Var, i6 i6Var) {
        this(h6Var);
    }
}
