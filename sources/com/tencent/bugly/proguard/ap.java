package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ap extends k implements Cloneable {
    public static Map<String, String> n;
    public static /* synthetic */ boolean o = !ap.class.desiredAssertionStatus();
    public static ao m = new ao();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11091a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11092b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11093c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f11094d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f11095e = "";

    /* renamed from: f, reason: collision with root package name */
    public ao f11096f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f11097g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f11098h = 0;
    public String j = "";
    public String k = "";
    public int l = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f11099i = 0;

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11091a, 0);
        jVar.a(this.f11092b, 1);
        jVar.a(this.f11093c, 2);
        String str = this.f11094d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f11095e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        ao aoVar = this.f11096f;
        if (aoVar != null) {
            jVar.a((k) aoVar, 5);
        }
        Map<String, String> map = this.f11097g;
        if (map != null) {
            jVar.a((Map) map, 6);
        }
        jVar.a(this.f11098h, 7);
        String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        String str4 = this.k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.l, 10);
        jVar.a(this.f11099i, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ap apVar = (ap) obj;
        return l.a(this.f11091a, apVar.f11091a) && l.a(this.f11092b, apVar.f11092b) && l.a(this.f11093c, apVar.f11093c) && l.a(this.f11094d, apVar.f11094d) && l.a(this.f11095e, apVar.f11095e) && l.a(this.f11096f, apVar.f11096f) && l.a(this.f11097g, apVar.f11097g) && l.a(this.f11098h, apVar.f11098h) && l.a(this.j, apVar.j) && l.a(this.k, apVar.k) && l.a(this.l, apVar.l) && l.a(this.f11099i, apVar.f11099i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11091a = iVar.a(0, true);
        this.f11092b = iVar.a(1, true);
        this.f11093c = iVar.a(2, true);
        this.f11094d = iVar.b(3, false);
        this.f11095e = iVar.b(4, false);
        this.f11096f = (ao) iVar.a((k) m, 5, false);
        this.f11097g = (Map) iVar.a((i) n, 6, false);
        this.f11098h = iVar.a(this.f11098h, 7, false);
        this.j = iVar.b(8, false);
        this.k = iVar.b(9, false);
        this.l = iVar.a(this.l, 10, false);
        this.f11099i = iVar.a(this.f11099i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.f11091a, "enable");
        hVar.a(this.f11092b, "enableUserInfo");
        hVar.a(this.f11093c, "enableQuery");
        hVar.a(this.f11094d, "url");
        hVar.a(this.f11095e, "expUrl");
        hVar.a((k) this.f11096f, "security");
        hVar.a((Map) this.f11097g, "valueMap");
        hVar.a(this.f11098h, "strategylastUpdateTime");
        hVar.a(this.j, "httpsUrl");
        hVar.a(this.k, "httpsExpUrl");
        hVar.a(this.l, "eventRecordCount");
        hVar.a(this.f11099i, "eventTimeInterval");
    }
}
