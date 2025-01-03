package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class an extends k {

    /* renamed from: i, reason: collision with root package name */
    public static byte[] f11080i = {0};
    public static Map<String, String> j;

    /* renamed from: a, reason: collision with root package name */
    public byte f11081a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f11082b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f11083c = null;

    /* renamed from: f, reason: collision with root package name */
    public String f11086f = "";

    /* renamed from: d, reason: collision with root package name */
    public long f11084d = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f11087g = "";

    /* renamed from: e, reason: collision with root package name */
    public String f11085e = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f11088h = null;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11081a, 0);
        jVar.a(this.f11082b, 1);
        byte[] bArr = this.f11083c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        String str = this.f11086f;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.f11084d, 4);
        String str2 = this.f11087g;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        String str3 = this.f11085e;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        Map<String, String> map = this.f11088h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11081a = iVar.a(this.f11081a, 0, true);
        this.f11082b = iVar.a(this.f11082b, 1, true);
        this.f11083c = iVar.c(2, false);
        this.f11086f = iVar.b(3, false);
        this.f11084d = iVar.a(this.f11084d, 4, false);
        this.f11087g = iVar.b(5, false);
        this.f11085e = iVar.b(6, false);
        this.f11088h = (Map) iVar.a((i) j, 7, false);
    }
}
