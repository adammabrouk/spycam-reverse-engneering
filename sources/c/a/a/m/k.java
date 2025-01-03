package c.a.a.m;

import a.k.a.r;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class k implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    public static final k f3376e = new k();

    /* renamed from: a, reason: collision with root package name */
    public volatile c.a.a.h f3377a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<FragmentManager, j> f3378b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, n> f3379c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Handler f3380d = new Handler(Looper.getMainLooper(), this);

    public static k a() {
        return f3376e;
    }

    public final c.a.a.h b(Context context) {
        if (this.f3377a == null) {
            synchronized (this) {
                if (this.f3377a == null) {
                    this.f3377a = new c.a.a.h(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.f3377a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f3378b.remove(obj);
        } else {
            if (i2 != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f3379c.remove(obj);
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    public c.a.a.h a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (c.a.a.r.h.c() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    @TargetApi(17)
    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public c.a.a.h a(FragmentActivity fragmentActivity) {
        if (c.a.a.r.h.b()) {
            return a(fragmentActivity.getApplicationContext());
        }
        b((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @TargetApi(11)
    public c.a.a.h a(Activity activity) {
        if (!c.a.a.r.h.b() && Build.VERSION.SDK_INT >= 11) {
            b(activity);
            return a(activity, activity.getFragmentManager());
        }
        return a(activity.getApplicationContext());
    }

    @TargetApi(17)
    public j a(FragmentManager fragmentManager) {
        j jVar = (j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = this.f3378b.get(fragmentManager);
        if (jVar2 != null) {
            return jVar2;
        }
        j jVar3 = new j();
        this.f3378b.put(fragmentManager, jVar3);
        fragmentManager.beginTransaction().add(jVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f3380d.obtainMessage(1, fragmentManager).sendToTarget();
        return jVar3;
    }

    @TargetApi(11)
    public c.a.a.h a(Context context, FragmentManager fragmentManager) {
        j a2 = a(fragmentManager);
        c.a.a.h b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        c.a.a.h hVar = new c.a.a.h(context, a2.a(), a2.c());
        a2.a(hVar);
        return hVar;
    }

    public n a(androidx.fragment.app.FragmentManager fragmentManager) {
        n nVar = (n) fragmentManager.c("com.bumptech.glide.manager");
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = this.f3379c.get(fragmentManager);
        if (nVar2 != null) {
            return nVar2;
        }
        n nVar3 = new n();
        this.f3379c.put(fragmentManager, nVar3);
        r b2 = fragmentManager.b();
        b2.a(nVar3, "com.bumptech.glide.manager");
        b2.b();
        this.f3380d.obtainMessage(2, fragmentManager).sendToTarget();
        return nVar3;
    }

    public c.a.a.h a(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        n a2 = a(fragmentManager);
        c.a.a.h a3 = a2.a();
        if (a3 != null) {
            return a3;
        }
        c.a.a.h hVar = new c.a.a.h(context, a2.getLifecycle(), a2.b());
        a2.a(hVar);
        return hVar;
    }
}
