package c.c.a.b.f.e;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v1 implements q1 {

    /* renamed from: c, reason: collision with root package name */
    public static v1 f4486c;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f4487a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final ContentObserver f4488b;

    public v1(Context context) {
        this.f4487a = context;
        this.f4488b = new x1(this, null);
        context.getContentResolver().registerContentObserver(l1.f4267a, true, this.f4488b);
    }

    public static v1 a(Context context) {
        v1 v1Var;
        synchronized (v1.class) {
            if (f4486c == null) {
                f4486c = a.h.b.c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new v1(context) : new v1();
            }
            v1Var = f4486c;
        }
        return v1Var;
    }

    public final /* synthetic */ String b(String str) {
        return l1.a(this.f4487a.getContentResolver(), str, (String) null);
    }

    @Override // c.c.a.b.f.e.q1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a(final String str) {
        if (this.f4487a == null) {
            return null;
        }
        try {
            return (String) t1.a(new s1(this, str) { // from class: c.c.a.b.f.e.u1

                /* renamed from: a, reason: collision with root package name */
                public final v1 f4453a;

                /* renamed from: b, reason: collision with root package name */
                public final String f4454b;

                {
                    this.f4453a = this;
                    this.f4454b = str;
                }

                @Override // c.c.a.b.f.e.s1
                public final Object zza() {
                    return this.f4453a.b(this.f4454b);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    public v1() {
        this.f4487a = null;
        this.f4488b = null;
    }

    public static synchronized void a() {
        synchronized (v1.class) {
            if (f4486c != null && f4486c.f4487a != null && f4486c.f4488b != null) {
                f4486c.f4487a.getContentResolver().unregisterContentObserver(f4486c.f4488b);
            }
            f4486c = null;
        }
    }
}
