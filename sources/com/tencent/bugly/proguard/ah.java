package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ah extends k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f11048a = "";

    /* renamed from: d, reason: collision with root package name */
    public String f11051d = "";

    /* renamed from: b, reason: collision with root package name */
    public String f11049b = "";

    /* renamed from: e, reason: collision with root package name */
    public String f11052e = "";

    /* renamed from: c, reason: collision with root package name */
    public String f11050c = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11048a, 0);
        String str = this.f11051d;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f11049b;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        String str3 = this.f11052e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        String str4 = this.f11050c;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11048a = iVar.b(0, true);
        this.f11051d = iVar.b(1, false);
        this.f11049b = iVar.b(2, false);
        this.f11052e = iVar.b(3, false);
        this.f11050c = iVar.b(4, false);
    }
}
