package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f7373a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f7373a = simpleDateFormat;
        simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static z6 a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        z6 z6Var = new z6();
        z6Var.d("category_push_stat");
        z6Var.a("push_sdk_stat_channel");
        z6Var.a(1L);
        z6Var.b(str);
        z6Var.a(true);
        z6Var.b(System.currentTimeMillis());
        z6Var.g(u0.a(context).a());
        z6Var.e("com.xiaomi.xmsf");
        z6Var.f("");
        z6Var.c("push_stat");
        return z6Var;
    }
}
