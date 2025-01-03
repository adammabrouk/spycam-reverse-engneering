package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class al extends k implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<ak> f11069b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ak> f11070a = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a((Collection) this.f11070a, 0);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        if (f11069b == null) {
            f11069b = new ArrayList<>();
            f11069b.add(new ak());
        }
        this.f11070a = (ArrayList) iVar.a((i) f11069b, 0, true);
    }
}
