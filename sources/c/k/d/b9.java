package c.k.d;

/* loaded from: classes.dex */
public class b9 extends d9 {

    /* renamed from: a, reason: collision with root package name */
    public l8 f7003a;

    /* renamed from: b, reason: collision with root package name */
    public int f7004b;

    public b9(int i2) {
        this.f7003a = new l8(i2);
    }

    @Override // c.k.d.d9
    public int a(byte[] bArr, int i2, int i3) {
        byte[] m288a = this.f7003a.m288a();
        if (i3 > this.f7003a.a() - this.f7004b) {
            i3 = this.f7003a.a() - this.f7004b;
        }
        if (i3 > 0) {
            System.arraycopy(m288a, this.f7004b, bArr, i2, i3);
            this.f7004b += i3;
        }
        return i3;
    }

    @Override // c.k.d.d9
    /* renamed from: a */
    public void mo76a(byte[] bArr, int i2, int i3) {
        this.f7003a.write(bArr, i2, i3);
    }

    public int c() {
        return this.f7003a.size();
    }
}
