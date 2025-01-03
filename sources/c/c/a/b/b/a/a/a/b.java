package c.c.a.b.b.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.c.a.b.c.o.r;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final Lock f3798c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("sLk")
    public static b f3799d;

    /* renamed from: a, reason: collision with root package name */
    public final Lock f3800a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLk")
    public final SharedPreferences f3801b;

    public b(Context context) {
        this.f3801b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        r.a(context);
        f3798c.lock();
        try {
            if (f3799d == null) {
                f3799d = new b(context.getApplicationContext());
            }
            return f3799d;
        } finally {
            f3798c.unlock();
        }
    }

    @Nullable
    public final String b(String str) {
        this.f3800a.lock();
        try {
            return this.f3801b.getString(str, null);
        } finally {
            this.f3800a.unlock();
        }
    }

    @Nullable
    public GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }

    @Nullable
    public final GoogleSignInAccount a(String str) {
        String b2;
        if (!TextUtils.isEmpty(str) && (b2 = b(a("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.b(b2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }
}
