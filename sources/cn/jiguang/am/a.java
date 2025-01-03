package cn.jiguang.am;

import cn.jiguang.internal.JConstants;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {
    public Map<String, d> k;
    public List<String> o;
    public List<String> p;
    public List<String> w;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8194a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8195b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8196c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8197d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8198e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f8199f = 5;

    /* renamed from: g, reason: collision with root package name */
    public long f8200g = 1800000;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8201h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8202i = true;
    public int j = 0;
    public long l = JConstants.HOUR;
    public long m = JConstants.HOUR;
    public String n = "disable";
    public long q = 1800000;
    public long r = 1800000;
    public long s = 7200000;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;

    public String toString() {
        return "JWakeConfigInfo{wakeEnableByAppKey=" + this.f8194a + ", beWakeEnableByAppKey=" + this.f8195b + ", wakeEnableByUId=" + this.f8196c + ", beWakeEnableByUId=" + this.f8197d + ", ignorLocal=" + this.f8198e + ", maxWakeCount=" + this.f8199f + ", wakeInterval=" + this.f8200g + ", wakeTimeEnable=" + this.f8201h + ", noWakeTimeConfig=" + this.f8202i + ", apiType=" + this.j + ", wakeTypeInfoMap=" + this.k + ", wakeConfigInterval=" + this.l + ", wakeReportInterval=" + this.m + ", config='" + this.n + "', pkgList=" + this.o + ", blackPackageList=" + this.p + ", accountWakeInterval=" + this.q + ", dactivityWakeInterval=" + this.r + ", activityWakeInterval=" + this.s + ", wakeReportEnable=" + this.t + ", beWakeReportEnable=" + this.u + ", appUnsupportedWakeupType=" + this.v + ", blacklistThirdPackage=" + this.w + '}';
    }
}
