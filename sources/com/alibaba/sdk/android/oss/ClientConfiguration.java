package com.alibaba.sdk.android.oss;

import com.alibaba.sdk.android.oss.common.HttpProtocol;
import com.shix.shixipc.utilcode.TimeConstants;
import h.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ClientConfiguration {
    public static final int DEFAULT_MAX_RETRIES = 2;
    public String ipWithHeader;
    public String mUserAgentMark;
    public String proxyHost;
    public int proxyPort;
    public int maxConcurrentRequest = 5;
    public int socketTimeout = TimeConstants.MIN;
    public int connectionTimeout = TimeConstants.MIN;
    public long max_log_size = 5242880;
    public int maxErrorRetry = 2;
    public List<String> customCnameExcludeList = new ArrayList();
    public boolean httpDnsEnable = false;
    public boolean checkCRC64 = false;
    public boolean pathStyleAccessEnable = false;
    public boolean customPathPrefixEnable = false;
    public boolean followRedirectsEnable = false;
    public v okHttpClient = null;
    public HttpProtocol httpProtocol = HttpProtocol.HTTPS;

    public static ClientConfiguration getDefaultConf() {
        return new ClientConfiguration();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public List<String> getCustomCnameExcludeList() {
        return Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public HttpProtocol getHttpProtocol() {
        return this.httpProtocol;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public v getOkHttpClient() {
        return this.okHttpClient;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isCustomPathPrefixEnable() {
        return this.customPathPrefixEnable;
    }

    public boolean isFollowRedirectsEnable() {
        return this.followRedirectsEnable;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isPathStyleAccessEnable() {
        return this.pathStyleAccessEnable;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public void setConnectionTimeout(int i2) {
        this.connectionTimeout = i2;
    }

    public void setCustomCnameExcludeList(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("cname exclude list should not be null.");
        }
        this.customCnameExcludeList.clear();
        for (String str : list) {
            if (str.contains("://")) {
                this.customCnameExcludeList.add(str.substring(str.indexOf("://") + 3));
            } else {
                this.customCnameExcludeList.add(str);
            }
        }
    }

    public void setCustomPathPrefixEnable(boolean z) {
        this.customPathPrefixEnable = z;
    }

    public void setFollowRedirectsEnable(boolean z) {
        this.followRedirectsEnable = z;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setHttpProtocol(HttpProtocol httpProtocol) {
        this.httpProtocol = httpProtocol;
    }

    public void setIpWithHeader(String str) {
        this.ipWithHeader = str;
    }

    public void setMaxConcurrentRequest(int i2) {
        this.maxConcurrentRequest = i2;
    }

    public void setMaxErrorRetry(int i2) {
        this.maxErrorRetry = i2;
    }

    public void setMaxLogSize(long j) {
        this.max_log_size = j;
    }

    public void setOkHttpClient(v vVar) {
        this.okHttpClient = vVar;
    }

    public void setPathStyleAccessEnable(boolean z) {
        this.pathStyleAccessEnable = z;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setProxyPort(int i2) {
        this.proxyPort = i2;
    }

    public void setSocketTimeout(int i2) {
        this.socketTimeout = i2;
    }

    public void setUserAgentMark(String str) {
        this.mUserAgentMark = str;
    }
}
