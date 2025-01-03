package c.k.c.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import c.k.d.i4;
import c.k.d.j4;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
/* loaded from: classes.dex */
public class s implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f6913a = new HashSet();

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new s());
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        j4 a2;
        String packageName;
        String m221a;
        int i2;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.f6913a.contains(stringExtra)) {
            return;
        }
        this.f6913a.add(stringExtra);
        if (intExtra == 3000) {
            a2 = j4.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m221a = i4.m221a(intExtra);
            i2 = 3008;
        } else {
            if (intExtra != 1000) {
                return;
            }
            a2 = j4.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m221a = i4.m221a(intExtra);
            i2 = 1008;
        }
        a2.a(packageName, m221a, stringExtra, i2, null);
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
