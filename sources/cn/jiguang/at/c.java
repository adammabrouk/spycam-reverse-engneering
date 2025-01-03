package cn.jiguang.at;

import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.e.f;
import com.google.zxing.qrcode.encoder.Encoder;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static c f8352c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final String f8353a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8354b;

    public c() {
        String d2 = d();
        this.f8353a = d2;
        this.f8354b = a(d2);
    }

    public static c a() {
        return f8352c;
    }

    public static String a(String str) {
        return String.format("QiniuAndroid%s/%s (%s; %s; %s", "", "VERSION", b(), c(), str);
    }

    public static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public static String b() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? "-" : f.m(str.trim());
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static String c() {
        try {
            String trim = Build.MODEL.trim();
            String a2 = a(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(a2)) {
                a2 = a(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (a2 == null) {
                a2 = "-";
            }
            sb.append(a2);
            sb.append("-");
            sb.append(trim);
            return f.m(sb.toString());
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static String d() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    public String b(String str) {
        String trim = ("" + str).trim();
        if (trim.length() > 15) {
            trim = trim.substring(0, Math.min(16, trim.length()));
        }
        return new String((this.f8354b + "; " + trim + ")").getBytes(Charset.forName(Encoder.DEFAULT_BYTE_MODE_ENCODING)));
    }
}
