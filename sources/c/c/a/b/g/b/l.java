package c.c.a.b.g.b;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.JConstants;
import com.hjq.permissions.Permission;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l extends v5 {

    /* renamed from: c, reason: collision with root package name */
    public long f4873c;

    /* renamed from: d, reason: collision with root package name */
    public String f4874d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f4875e;

    /* renamed from: f, reason: collision with root package name */
    public AccountManager f4876f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f4877g;

    /* renamed from: h, reason: collision with root package name */
    public long f4878h;

    public l(a5 a5Var) {
        super(a5Var);
    }

    public final boolean a(Context context) {
        if (this.f4875e == null) {
            F();
            this.f4875e = false;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", RecyclerView.c0.FLAG_IGNORE);
                    this.f4875e = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f4875e.booleanValue();
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        Calendar calendar = Calendar.getInstance();
        this.f4873c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f4874d = sb.toString();
        return false;
    }

    public final long s() {
        n();
        return this.f4873c;
    }

    public final String t() {
        n();
        return this.f4874d;
    }

    public final long u() {
        g();
        return this.f4878h;
    }

    public final void v() {
        g();
        this.f4877g = null;
        this.f4878h = 0L;
    }

    public final boolean w() {
        Account[] result;
        g();
        long a2 = b().a();
        if (a2 - this.f4878h > JConstants.DAY) {
            this.f4877g = null;
        }
        Boolean bool = this.f4877g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (a.h.b.a.a(d(), Permission.GET_ACCOUNTS) != 0) {
            c().x().a("Permission error checking for dasher/unicorn accounts");
            this.f4878h = a2;
            this.f4877g = false;
            return false;
        }
        if (this.f4876f == null) {
            this.f4876f = AccountManager.get(d());
        }
        try {
            result = this.f4876f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            c().u().a("Exception checking account types", e2);
        }
        if (result != null && result.length > 0) {
            this.f4877g = true;
            this.f4878h = a2;
            return true;
        }
        Account[] result2 = this.f4876f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f4877g = true;
            this.f4878h = a2;
            return true;
        }
        this.f4878h = a2;
        this.f4877g = false;
        return false;
    }
}
