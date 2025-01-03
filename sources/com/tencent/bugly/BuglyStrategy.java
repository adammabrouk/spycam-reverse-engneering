package com.tencent.bugly;

import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    public String f10813c;

    /* renamed from: d, reason: collision with root package name */
    public String f10814d;

    /* renamed from: e, reason: collision with root package name */
    public String f10815e;

    /* renamed from: f, reason: collision with root package name */
    public long f10816f;

    /* renamed from: g, reason: collision with root package name */
    public String f10817g;

    /* renamed from: h, reason: collision with root package name */
    public String f10818h;

    /* renamed from: i, reason: collision with root package name */
    public String f10819i;
    public a t;
    public boolean j = true;
    public boolean k = true;
    public boolean l = false;
    public boolean m = true;
    public Class<?> n = null;
    public boolean o = true;
    public boolean p = true;
    public boolean q = true;
    public boolean r = true;
    public boolean s = false;

    /* renamed from: a, reason: collision with root package name */
    public int f10811a = 31;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10812b = false;
    public boolean u = true;

    /* compiled from: BUGLY */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        if (this.f10814d == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().l;
        }
        return this.f10814d;
    }

    public synchronized String getAppPackageName() {
        if (this.f10815e == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f10872c;
        }
        return this.f10815e;
    }

    public synchronized long getAppReportDelay() {
        return this.f10816f;
    }

    public synchronized String getAppVersion() {
        if (this.f10813c == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().j;
        }
        return this.f10813c;
    }

    public synchronized int getCallBackType() {
        return this.f10811a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f10812b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.t;
    }

    public synchronized String getDeviceID() {
        return this.f10818h;
    }

    public synchronized String getDeviceModel() {
        return this.f10819i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f10817g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.n;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.o;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.j;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.m;
    }

    public boolean isMerged() {
        return this.u;
    }

    public boolean isReplaceOldChannel() {
        return this.p;
    }

    public synchronized boolean isUploadProcess() {
        return this.q;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.r;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.s;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f10814d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f10815e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f10816f = j;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f10813c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.o = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.f10811a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f10812b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.t = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f10818h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f10819i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.k = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.l = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.j = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.m = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f10817g = str;
        return this;
    }

    public void setMerged(boolean z) {
        this.u = z;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.s = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.p = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.q = z;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z) {
        this.r = z;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.n = cls;
        return this;
    }
}
