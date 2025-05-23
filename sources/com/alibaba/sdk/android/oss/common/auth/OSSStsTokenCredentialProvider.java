package com.alibaba.sdk.android.oss.common.auth;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class OSSStsTokenCredentialProvider implements OSSCredentialProvider {
    public String accessKeyId;
    public String secretKeyId;
    public String securityToken;

    public OSSStsTokenCredentialProvider(String str, String str2, String str3) {
        setAccessKeyId(str.trim());
        setSecretKeyId(str2.trim());
        setSecurityToken(str3.trim());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public OSSFederationToken getFederationToken() {
        return new OSSFederationToken(this.accessKeyId, this.secretKeyId, this.securityToken, RecyclerView.FOREVER_NS);
    }

    public String getSecretKeyId() {
        return this.secretKeyId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setSecretKeyId(String str) {
        this.secretKeyId = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public OSSStsTokenCredentialProvider(OSSFederationToken oSSFederationToken) {
        setAccessKeyId(oSSFederationToken.getTempAK().trim());
        setSecretKeyId(oSSFederationToken.getTempSK().trim());
        setSecurityToken(oSSFederationToken.getSecurityToken().trim());
    }
}
