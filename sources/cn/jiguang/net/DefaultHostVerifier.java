package cn.jiguang.net;

import android.text.TextUtils;
import cn.jiguang.as.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class DefaultHostVerifier implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public String f8991a;

    public DefaultHostVerifier(String str) {
        this.f8991a = null;
        this.f8991a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        d.c("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f8991a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f8991a, str);
    }
}
