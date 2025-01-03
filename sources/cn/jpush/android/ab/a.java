package cn.jpush.android.ab;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class a implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public String f9083a;

    public a(String str) {
        this.f9083a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f9083a, str);
    }
}
