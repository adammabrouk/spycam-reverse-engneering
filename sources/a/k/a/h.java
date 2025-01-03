package a.k.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class h<E> extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f1367a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1368b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f1369c;

    /* renamed from: d, reason: collision with root package name */
    public final FragmentManager f1370d;

    public h(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // a.k.a.e
    public View a(int i2) {
        return null;
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        a.h.b.a.a(this.f1368b, intent, bundle);
    }

    @Deprecated
    public void a(Fragment fragment, String[] strArr, int i2) {
    }

    @Override // a.k.a.e
    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public Activity b() {
        return this.f1367a;
    }

    public Context c() {
        return this.f1368b;
    }

    public Handler d() {
        return this.f1369c;
    }

    public abstract E e();

    public LayoutInflater f() {
        return LayoutInflater.from(this.f1368b);
    }

    public void g() {
    }

    public h(Activity activity, Context context, Handler handler, int i2) {
        this.f1370d = new k();
        this.f1367a = activity;
        a.h.i.h.a(context, "context == null");
        this.f1368b = context;
        a.h.i.h.a(handler, "handler == null");
        this.f1369c = handler;
    }

    @Deprecated
    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            a.h.a.a.a(this.f1367a, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
}
