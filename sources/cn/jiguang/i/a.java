package cn.jiguang.i;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: classes.dex */
public class a implements ReportCallBack {

    /* renamed from: a, reason: collision with root package name */
    public String f8899a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8900b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8901c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8902d;

    public a(String str, Context context, String str2, String str3) {
        this.f8899a = str;
        this.f8900b = context;
        this.f8901c = str2;
        this.f8902d = str3;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i2) {
        if (TextUtils.isEmpty(this.f8899a)) {
            this.f8899a = "";
        }
        cn.jiguang.l.b.f(this.f8900b, this.f8901c + this.f8899a);
        if (cn.jiguang.l.b.h(this.f8900b, this.f8901c) == 0) {
            cn.jiguang.l.b.p(this.f8900b, this.f8899a);
        }
        cn.jiguang.l.b.f(this.f8900b, this.f8902d);
    }
}
