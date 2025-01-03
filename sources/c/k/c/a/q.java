package c.k.c.a;

import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public c.k.d.p9.l1.a f6893a = c.k.d.p9.l1.a.China;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6894b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6895c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6896d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6897e = false;

    public boolean a() {
        return this.f6896d;
    }

    public boolean b() {
        return this.f6895c;
    }

    public boolean c() {
        return this.f6897e;
    }

    public boolean d() {
        return this.f6894b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        c.k.d.p9.l1.a aVar = this.f6893a;
        stringBuffer.append(aVar == null ? LogUtils.NULL : aVar.name());
        stringBuffer.append(",mOpenHmsPush:" + this.f6894b);
        stringBuffer.append(",mOpenFCMPush:" + this.f6895c);
        stringBuffer.append(",mOpenCOSPush:" + this.f6896d);
        stringBuffer.append(",mOpenFTOSPush:" + this.f6897e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
