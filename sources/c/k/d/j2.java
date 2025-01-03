package c.k.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class j2 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public String f7274a;

    /* renamed from: b, reason: collision with root package name */
    public String f7275b;

    /* renamed from: c, reason: collision with root package name */
    public Context f7276c;

    public j2(Context context, String str) {
        this.f7274a = "";
        this.f7276c = context;
        this.f7274a = str;
    }

    public final void a(String str) {
        d7 d7Var = new d7();
        d7Var.a(str);
        d7Var.a(System.currentTimeMillis());
        d7Var.a(x6.ActivityActiveTimeStamp);
        a3.a(this.f7276c, d7Var);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f7274a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f7275b = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.f7275b, localClassName)) {
            this.f7274a = "";
            return;
        }
        a(this.f7276c.getPackageName() + "|" + localClassName + ":" + this.f7274a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f7274a = "";
        this.f7275b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f7275b)) {
            this.f7275b = activity.getLocalClassName();
        }
        this.f7274a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
