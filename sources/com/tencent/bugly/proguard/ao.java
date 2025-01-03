package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ao extends k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f11089a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f11090b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11089a, 0);
        jVar.a(this.f11090b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11089a = iVar.b(0, true);
        this.f11090b = iVar.b(1, true);
    }
}
