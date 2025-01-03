package cn.jiguang.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: classes.dex */
public class a implements ReportCallBack {

    /* renamed from: a, reason: collision with root package name */
    public Context f8977a;

    /* renamed from: b, reason: collision with root package name */
    public String f8978b;

    /* renamed from: c, reason: collision with root package name */
    public String f8979c;

    public a(Context context, String str, String str2) {
        this.f8977a = context;
        this.f8978b = str;
        this.f8979c = str2;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i2) {
        cn.jiguang.ai.a.a("DeviceReport", "report finish code:" + i2);
        if (i2 != 0) {
            return;
        }
        cn.jiguang.l.b.f(this.f8977a, this.f8979c);
        if (TextUtils.isEmpty(this.f8978b)) {
            return;
        }
        cn.jiguang.l.b.u(this.f8977a, this.f8978b);
    }
}
