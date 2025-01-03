package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class aj extends k implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static byte[] f11056d;

    /* renamed from: a, reason: collision with root package name */
    public byte f11057a;

    /* renamed from: b, reason: collision with root package name */
    public String f11058b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f11059c;

    public aj() {
        this.f11057a = (byte) 0;
        this.f11058b = "";
        this.f11059c = null;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11057a, 0);
        jVar.a(this.f11058b, 1);
        byte[] bArr = this.f11059c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    public aj(byte b2, String str, byte[] bArr) {
        this.f11057a = (byte) 0;
        this.f11058b = "";
        this.f11059c = null;
        this.f11057a = b2;
        this.f11058b = str;
        this.f11059c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11057a = iVar.a(this.f11057a, 0, true);
        this.f11058b = iVar.b(1, true);
        if (f11056d == null) {
            f11056d = new byte[]{0};
        }
        this.f11059c = iVar.c(2, false);
    }
}
