package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ar extends k implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<aq> f11109f;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, String> f11110g;

    /* renamed from: a, reason: collision with root package name */
    public byte f11111a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f11112b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f11113c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<aq> f11114d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f11115e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11111a, 0);
        String str = this.f11112b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f11113c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        ArrayList<aq> arrayList = this.f11114d;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f11115e;
        if (map != null) {
            jVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11111a = iVar.a(this.f11111a, 0, true);
        this.f11112b = iVar.b(1, false);
        this.f11113c = iVar.b(2, false);
        if (f11109f == null) {
            f11109f = new ArrayList<>();
            f11109f.add(new aq());
        }
        this.f11114d = (ArrayList) iVar.a((i) f11109f, 3, false);
        if (f11110g == null) {
            HashMap hashMap = new HashMap();
            f11110g = hashMap;
            hashMap.put("", "");
        }
        this.f11115e = (Map) iVar.a((i) f11110g, 4, false);
    }
}
