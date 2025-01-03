package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class m9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7403b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7404c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k9 f7405d;

    public m9(k9 k9Var, String str, String str2, String str3) {
        this.f7405d = k9Var;
        this.f7402a = str;
        this.f7403b = str2;
        this.f7404c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f7405d.f7330a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f7402a, 4).edit();
        edit.putString(this.f7403b, this.f7404c);
        edit.commit();
    }
}
