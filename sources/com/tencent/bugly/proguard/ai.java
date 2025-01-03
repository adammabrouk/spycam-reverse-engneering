package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ai extends k implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f11053c;

    /* renamed from: a, reason: collision with root package name */
    public String f11054a = "";

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f11055b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11054a, 0);
        ArrayList<String> arrayList = this.f11055b;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11054a = iVar.b(0, true);
        if (f11053c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f11053c = arrayList;
            arrayList.add("");
        }
        this.f11055b = (ArrayList) iVar.a((i) f11053c, 1, false);
    }
}
