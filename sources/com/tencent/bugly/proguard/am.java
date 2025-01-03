package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class am extends k {
    public static byte[] y = {0};
    public static Map<String, String> z;

    /* renamed from: a, reason: collision with root package name */
    public int f11071a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f11072b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f11073c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f11074d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f11075e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f11076f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f11077g = 0;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f11078h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f11079i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String u = "";
    public String r = "";
    public String v = "";
    public String w = "";
    public String s = "";
    public String t = "";
    public String x = "";

    static {
        HashMap hashMap = new HashMap();
        z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f11071a, 0);
        jVar.a(this.f11072b, 1);
        jVar.a(this.f11073c, 2);
        jVar.a(this.f11074d, 3);
        String str = this.f11075e;
        if (str != null) {
            jVar.a(str, 4);
        }
        jVar.a(this.f11076f, 5);
        jVar.a(this.f11077g, 6);
        jVar.a(this.f11078h, 7);
        String str2 = this.f11079i;
        if (str2 != null) {
            jVar.a(str2, 8);
        }
        String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 9);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            jVar.a((Map) map, 10);
        }
        String str4 = this.l;
        if (str4 != null) {
            jVar.a(str4, 11);
        }
        jVar.a(this.m, 12);
        String str5 = this.n;
        if (str5 != null) {
            jVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            jVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            jVar.a(str7, 15);
        }
        jVar.a(this.q, 16);
        String str8 = this.u;
        if (str8 != null) {
            jVar.a(str8, 17);
        }
        String str9 = this.r;
        if (str9 != null) {
            jVar.a(str9, 18);
        }
        String str10 = this.v;
        if (str10 != null) {
            jVar.a(str10, 19);
        }
        String str11 = this.w;
        if (str11 != null) {
            jVar.a(str11, 20);
        }
        String str12 = this.s;
        if (str12 != null) {
            jVar.a(str12, 21);
        }
        String str13 = this.t;
        if (str13 != null) {
            jVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            jVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f11071a = iVar.a(this.f11071a, 0, true);
        this.f11072b = iVar.b(1, true);
        this.f11073c = iVar.b(2, true);
        this.f11074d = iVar.b(3, true);
        this.f11075e = iVar.b(4, false);
        this.f11076f = iVar.b(5, true);
        this.f11077g = iVar.a(this.f11077g, 6, true);
        this.f11078h = iVar.c(7, true);
        this.f11079i = iVar.b(8, false);
        this.j = iVar.b(9, false);
        this.k = (Map) iVar.a((i) z, 10, false);
        this.l = iVar.b(11, false);
        this.m = iVar.a(this.m, 12, false);
        this.n = iVar.b(13, false);
        this.o = iVar.b(14, false);
        this.p = iVar.b(15, false);
        this.q = iVar.a(this.q, 16, false);
        this.u = iVar.b(17, false);
        this.r = iVar.b(18, false);
        this.v = iVar.b(19, false);
        this.w = iVar.b(20, false);
        this.s = iVar.b(21, false);
        this.t = iVar.b(22, false);
        this.x = iVar.b(23, false);
    }
}
