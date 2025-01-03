package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class f extends k {

    /* renamed from: e, reason: collision with root package name */
    public byte[] f11127e;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f11131i;
    public Map<String, String> j;
    public static /* synthetic */ boolean m = !f.class.desiredAssertionStatus();
    public static byte[] k = null;
    public static Map<String, String> l = null;

    /* renamed from: a, reason: collision with root package name */
    public short f11123a = 0;

    /* renamed from: f, reason: collision with root package name */
    public byte f11128f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f11129g = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f11124b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f11125c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f11126d = null;

    /* renamed from: h, reason: collision with root package name */
    public int f11130h = 0;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11123a, 1);
        jVar.a(this.f11128f, 2);
        jVar.a(this.f11129g, 3);
        jVar.a(this.f11124b, 4);
        jVar.a(this.f11125c, 5);
        jVar.a(this.f11126d, 6);
        jVar.a(this.f11127e, 7);
        jVar.a(this.f11130h, 8);
        jVar.a((Map) this.f11131i, 9);
        jVar.a((Map) this.j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return l.a(1, (int) fVar.f11123a) && l.a(1, (int) fVar.f11128f) && l.a(1, fVar.f11129g) && l.a(1, fVar.f11124b) && l.a((Object) 1, (Object) fVar.f11125c) && l.a((Object) 1, (Object) fVar.f11126d) && l.a((Object) 1, (Object) fVar.f11127e) && l.a(1, fVar.f11130h) && l.a((Object) 1, (Object) fVar.f11131i) && l.a((Object) 1, (Object) fVar.j);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        try {
            this.f11123a = iVar.a(this.f11123a, 1, true);
            this.f11128f = iVar.a(this.f11128f, 2, true);
            this.f11129g = iVar.a(this.f11129g, 3, true);
            this.f11124b = iVar.a(this.f11124b, 4, true);
            this.f11125c = iVar.b(5, true);
            this.f11126d = iVar.b(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            this.f11127e = iVar.c(7, true);
            this.f11130h = iVar.a(this.f11130h, 8, true);
            if (l == null) {
                HashMap hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.f11131i = (Map) iVar.a((i) l, 9, true);
            if (l == null) {
                HashMap hashMap2 = new HashMap();
                l = hashMap2;
                hashMap2.put("", "");
            }
            this.j = (Map) iVar.a((i) l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + e.a(this.f11127e));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.f11123a, "iVersion");
        hVar.a(this.f11128f, "cPacketType");
        hVar.a(this.f11129g, "iMessageType");
        hVar.a(this.f11124b, "iRequestId");
        hVar.a(this.f11125c, "sServantName");
        hVar.a(this.f11126d, "sFuncName");
        hVar.a(this.f11127e, "sBuffer");
        hVar.a(this.f11130h, "iTimeout");
        hVar.a((Map) this.f11131i, "context");
        hVar.a((Map) this.j, "status");
    }
}
