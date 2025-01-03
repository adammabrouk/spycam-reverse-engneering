package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class aq extends k {

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, String> f11100i;

    /* renamed from: a, reason: collision with root package name */
    public long f11101a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f11102b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f11103c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f11104d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f11105e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f11106f = null;

    /* renamed from: h, reason: collision with root package name */
    public String f11108h = "";

    /* renamed from: g, reason: collision with root package name */
    public boolean f11107g = true;

    static {
        HashMap hashMap = new HashMap();
        f11100i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11101a, 0);
        jVar.a(this.f11102b, 1);
        String str = this.f11103c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.f11104d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.f11105e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f11106f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.f11108h;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.f11107g, 7);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11101a = iVar.a(this.f11101a, 0, true);
        this.f11102b = iVar.a(this.f11102b, 1, true);
        this.f11103c = iVar.b(2, false);
        this.f11104d = iVar.b(3, false);
        this.f11105e = iVar.b(4, false);
        this.f11106f = (Map) iVar.a((i) f11100i, 5, false);
        this.f11108h = iVar.b(6, false);
        this.f11107g = iVar.a(7, false);
    }
}
