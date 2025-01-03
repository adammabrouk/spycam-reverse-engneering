package cn.jiguang.az;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f8555a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f8556b;

    /* renamed from: c, reason: collision with root package name */
    public String f8557c;

    /* renamed from: d, reason: collision with root package name */
    public int f8558d;

    /* renamed from: e, reason: collision with root package name */
    public int f8559e;

    /* renamed from: f, reason: collision with root package name */
    public long f8560f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f8561g;

    /* renamed from: h, reason: collision with root package name */
    public long f8562h;

    /* renamed from: i, reason: collision with root package name */
    public long f8563i;
    public boolean j;

    public d(long j, String str, int i2, int i3, long j2, long j3, byte[] bArr) {
        this.f8556b = j;
        this.f8557c = str;
        this.f8558d = i2;
        this.f8559e = i3;
        this.f8560f = j2;
        this.f8563i = j3;
        this.f8561g = bArr;
        if (j3 > 0) {
            this.j = true;
        }
    }

    public void a() {
        this.f8555a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.f8555a + ", requestId=" + this.f8556b + ", sdkType='" + this.f8557c + "', command=" + this.f8558d + ", ver=" + this.f8559e + ", rid=" + this.f8560f + ", reqeustTime=" + this.f8562h + ", timeout=" + this.f8563i + '}';
    }
}
