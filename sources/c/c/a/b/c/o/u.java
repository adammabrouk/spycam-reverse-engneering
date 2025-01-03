package c.c.a.b.c.o;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R$string;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f3997a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3998b;

    public u(Context context) {
        r.a(context);
        Resources resources = context.getResources();
        this.f3997a = resources;
        this.f3998b = resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue);
    }

    @Nullable
    public String a(String str) {
        int identifier = this.f3997a.getIdentifier(str, "string", this.f3998b);
        if (identifier == 0) {
            return null;
        }
        return this.f3997a.getString(identifier);
    }
}
