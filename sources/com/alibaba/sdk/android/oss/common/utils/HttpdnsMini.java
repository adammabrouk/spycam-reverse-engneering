package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.OSSLog;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class HttpdnsMini {
    public static final String ACCOUNT_ID = "181345";
    public static final int EMPTY_RESULT_HOST_TTL = 30;
    public static final int MAX_HOLD_HOST_NUM = 100;
    public static final int MAX_THREAD_NUM = 5;
    public static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    public static final String SERVER_IP = "203.107.1.1";
    public static final String TAG = "HttpDnsMini";
    public static HttpdnsMini instance;
    public ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
    public ExecutorService pool = Executors.newFixedThreadPool(5);

    public class HostObject {
        public String hostName;
        public String ip;
        public long queryTime;
        public long ttl;

        public HostObject() {
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getIp() {
            return this.ip;
        }

        public long getQueryTime() {
            return this.queryTime;
        }

        public long getTtl() {
            return this.ttl;
        }

        public boolean isExpired() {
            return getQueryTime() + this.ttl < System.currentTimeMillis() / 1000;
        }

        public boolean isStillAvailable() {
            return (getQueryTime() + this.ttl) + 600 > System.currentTimeMillis() / 1000;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setQueryTime(long j) {
            this.queryTime = j;
        }

        public void setTtl(long j) {
            this.ttl = j;
        }

        public String toString() {
            return "[hostName=" + getHostName() + ", ip=" + this.ip + ", ttl=" + getTtl() + ", queryTime=" + this.queryTime + "]";
        }
    }

    public class QueryHostTask implements Callable<String> {
        public boolean hasRetryed = false;
        public String hostName;

        public QueryHostTask(String str) {
            this.hostName = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x016b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call() {
            /*
                Method dump skipped, instructions count: 379
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.QueryHostTask.call():java.lang.String");
        }
    }

    public static HttpdnsMini getInstance() {
        if (instance == null) {
            synchronized (HttpdnsMini.class) {
                if (instance == null) {
                    instance = new HttpdnsMini();
                }
            }
        }
        return instance;
    }

    public String getIpByHostAsync(String str) {
        HostObject hostObject = this.hostManager.get(str);
        if (hostObject == null || hostObject.isExpired()) {
            OSSLog.logDebug("[httpdnsmini] - refresh host: " + str);
            this.pool.submit(new QueryHostTask(str));
        }
        if (hostObject == null || !hostObject.isStillAvailable()) {
            return null;
        }
        return hostObject.getIp();
    }
}
