package c.c.a.b.h.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.o.c;
import c.c.a.b.c.o.r;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zah;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes.dex */
public class a extends c.c.a.b.c.o.g<f> implements c.c.a.b.h.f {
    public final Bundle A;
    public Integer B;
    public final boolean y;
    public final c.c.a.b.c.o.d z;

    public a(Context context, Looper looper, boolean z, c.c.a.b.c.o.d dVar, Bundle bundle, c.c.a.b.c.l.f fVar, c.c.a.b.c.l.g gVar) {
        super(context, looper, 44, dVar, fVar, gVar);
        this.y = true;
        this.z = dVar;
        this.A = bundle;
        this.B = dVar.d();
    }

    @Override // c.c.a.b.h.f
    public final void a(d dVar) {
        r.a(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.z.b();
            ((f) v()).a(new zah(new ResolveAccountRequest(b2, this.B.intValue(), "<<default account>>".equals(b2.name) ? c.c.a.b.b.a.a.a.b.a(r()).a() : null)), dVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.a(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // c.c.a.b.c.o.c
    public String b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // c.c.a.b.c.o.g, c.c.a.b.c.o.c, c.c.a.b.c.l.a.f
    public int d() {
        return c.c.a.b.c.h.f3820a;
    }

    @Override // c.c.a.b.h.f
    public final void i() {
        a(new c.d());
    }

    @Override // c.c.a.b.c.o.c, c.c.a.b.c.l.a.f
    public boolean j() {
        return this.y;
    }

    @Override // c.c.a.b.c.o.c
    public String k() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // c.c.a.b.c.o.c
    public Bundle s() {
        if (!r().getPackageName().equals(this.z.f())) {
            this.A.putString("com.google.android.gms.signin.internal.realClientPackageName", this.z.f());
        }
        return this.A;
    }

    public a(Context context, Looper looper, boolean z, c.c.a.b.c.o.d dVar, c.c.a.b.h.a aVar, c.c.a.b.c.l.f fVar, c.c.a.b.c.l.g gVar) {
        this(context, looper, true, dVar, a(dVar), fVar, gVar);
    }

    public static Bundle a(c.c.a.b.c.o.d dVar) {
        c.c.a.b.h.a h2 = dVar.h();
        Integer d2 = dVar.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (d2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d2.intValue());
        }
        if (h2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h2.h());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h2.g());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h2.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h2.f());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h2.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h2.i());
            if (h2.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h2.a().longValue());
            }
            if (h2.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h2.c().longValue());
            }
        }
        return bundle;
    }

    @Override // c.c.a.b.c.o.c
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new g(iBinder);
    }
}
