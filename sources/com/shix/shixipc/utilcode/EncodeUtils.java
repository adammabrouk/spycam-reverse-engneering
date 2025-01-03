package com.shix.shixipc.utilcode;

import android.os.Build;
import android.text.Html;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public final class EncodeUtils {
    public EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] base64Decode(String str) {
        return (str == null || str.length() == 0) ? new byte[0] : Base64.decode(str, 2);
    }

    public static byte[] base64Encode(String str) {
        return base64Encode(str.getBytes());
    }

    public static String base64Encode2String(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : Base64.encodeToString(bArr, 2);
    }

    public static String binaryDecode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] split = str.split(LogUtils.PLACEHOLDER);
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            sb.append((char) Integer.parseInt(str2, 2));
        }
        return sb.toString();
    }

    public static String binaryEncode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            sb.append(Integer.toBinaryString(c2));
            sb.append(LogUtils.PLACEHOLDER);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static CharSequence htmlDecode(String str) {
        return (str == null || str.length() == 0) ? "" : Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static String htmlEncode(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '\"') {
                sb.append("&quot;");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt != '\'') {
                sb.append(charAt);
            } else {
                sb.append("&#39;");
            }
        }
        return sb.toString();
    }

    public static String urlDecode(String str) {
        return urlDecode(str, "UTF-8");
    }

    public static String urlEncode(String str) {
        return urlEncode(str, "UTF-8");
    }

    public static byte[] base64Encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.encode(bArr, 2);
    }

    public static String urlDecode(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), str2);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String urlEncode(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] base64Decode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.decode(bArr, 2);
    }
}
