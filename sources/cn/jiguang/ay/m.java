package cn.jiguang.ay;

import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class m extends i {

    /* renamed from: e, reason: collision with root package name */
    public int f8543e;

    /* renamed from: f, reason: collision with root package name */
    public int f8544f;

    /* renamed from: g, reason: collision with root package name */
    public int f8545g;

    /* renamed from: h, reason: collision with root package name */
    public g f8546h;

    @Override // cn.jiguang.ay.i
    public void a(b bVar) {
        this.f8543e = bVar.g();
        this.f8544f = bVar.g();
        this.f8545g = bVar.g();
        this.f8546h = new g(bVar);
    }

    @Override // cn.jiguang.ay.i
    public void a(c cVar, a aVar, boolean z) {
        cVar.c(this.f8543e);
        cVar.c(this.f8544f);
        cVar.c(this.f8545g);
        this.f8546h.a(cVar, (a) null, z);
    }

    @Override // cn.jiguang.ay.i
    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f8543e + LogUtils.PLACEHOLDER);
        stringBuffer.append(this.f8544f + LogUtils.PLACEHOLDER);
        stringBuffer.append(this.f8545g + LogUtils.PLACEHOLDER);
        stringBuffer.append(this.f8546h);
        return stringBuffer.toString();
    }

    public int j() {
        return this.f8545g;
    }

    public g k() {
        return this.f8546h;
    }
}
