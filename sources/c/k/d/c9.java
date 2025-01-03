package c.k.d;

/* loaded from: classes.dex */
public final class c9 extends d9 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7050a;

    /* renamed from: b, reason: collision with root package name */
    public int f7051b;

    /* renamed from: c, reason: collision with root package name */
    public int f7052c;

    @Override // c.k.d.d9
    public int a() {
        return this.f7051b;
    }

    @Override // c.k.d.d9
    public int a(byte[] bArr, int i2, int i3) {
        int b2 = b();
        if (i3 > b2) {
            i3 = b2;
        }
        if (i3 > 0) {
            System.arraycopy(this.f7050a, this.f7051b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    @Override // c.k.d.d9
    public void a(int i2) {
        this.f7051b += i2;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // c.k.d.d9
    /* renamed from: a */
    public void mo76a(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // c.k.d.d9
    /* renamed from: a, reason: collision with other method in class */
    public byte[] mo122a() {
        return this.f7050a;
    }

    @Override // c.k.d.d9
    public int b() {
        return this.f7052c - this.f7051b;
    }

    public void b(byte[] bArr, int i2, int i3) {
        this.f7050a = bArr;
        this.f7051b = i2;
        this.f7052c = i2 + i3;
    }
}
