package cn.jiguang.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class g {
    public static int a(Context context) {
        return a(c(context));
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("wifi".equals(str)) {
            return 1;
        }
        if ("2g".equals(str)) {
            return 2;
        }
        if ("3g".equals(str)) {
            return 3;
        }
        if ("4g".equals(str)) {
            return 4;
        }
        return "5g".equals(str) ? 5 : 0;
    }

    public static String a(int i2) {
        cn.jiguang.as.d.a("TeleonyManagerUtils", "getRadioType - networkType:" + i2);
        String str = (i2 == 4 || i2 == 7 || i2 == 5 || i2 == 6 || i2 == 12 || i2 == 14) ? "cdma" : i2 == 13 ? "lte" : "gsm";
        cn.jiguang.as.d.a("TeleonyManagerUtils", "getRadioType - radioType:" + str);
        return str;
    }

    public static String a(Context context, int i2) {
        String c2 = c(context);
        cn.jiguang.as.d.a("TeleonyManagerUtils", "getCurrentNetType - type:" + c2);
        if (TextUtils.isEmpty(c2)) {
            try {
                Object a2 = e.a((Class<?>) TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(i2)}, new Class[]{Integer.TYPE});
                if (((Integer) a2).intValue() == 0) {
                    c2 = "unknown";
                } else if (((Integer) a2).intValue() == 1) {
                    c2 = "2g";
                } else if (((Integer) a2).intValue() == 2) {
                    c2 = "3g";
                } else if (((Integer) a2).intValue() == 3) {
                    c2 = "4g";
                }
                cn.jiguang.as.d.c("TeleonyManagerUtils", "step2 - type:" + c2);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
            }
        }
        return TextUtils.isEmpty(c2) ? "unknown" : c2;
    }

    public static String b(int i2) {
        cn.jiguang.as.d.a("TeleonyManagerUtils", "getNetworkClass networkType:" + i2);
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                switch (i2) {
                    case 16:
                        return "2g";
                    case 17:
                        return "3g";
                    case 18:
                    case 19:
                        return "4g";
                    case 20:
                        return "5g";
                    default:
                        return "unknown";
                }
        }
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        String b2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                b2 = "wifi";
            } else {
                if (activeNetworkInfo.getType() != 0) {
                    return "unknown";
                }
                b2 = b(activeNetworkInfo.getSubtype());
            }
            return b2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "unknown";
        }
    }
}
