package cn.jpush.android.f;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f9730a;

    /* renamed from: b, reason: collision with root package name */
    public long f9731b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f9732c;

    public d(String str, long j, JSONObject jSONObject) {
        this.f9730a = str;
        this.f9731b = j;
        this.f9732c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f9730a, this.f9731b, this.f9732c);
    }
}
