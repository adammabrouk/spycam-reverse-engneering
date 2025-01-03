package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class x0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6933a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6934b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s0 f6935c;

    public x0(String str, Context context, s0 s0Var) {
        this.f6933a = str;
        this.f6934b = context;
        this.f6935c = s0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f6933a)) {
            return;
        }
        String[] split = this.f6933a.split("~");
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = "";
                break;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str)) {
            c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive correct token");
        w0.c(this.f6934b, this.f6935c, str);
        w0.a(this.f6934b);
    }
}
