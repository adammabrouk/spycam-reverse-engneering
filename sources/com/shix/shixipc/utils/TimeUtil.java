package com.shix.shixipc.utils;

import android.os.Build;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.TimeConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class TimeUtil {
    public static String cloudLogDate(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(Long.parseLong(String.valueOf(j))));
    }

    public static long dateTransformBetweenTimeZone(Date date, TimeZone timeZone, TimeZone timeZone2) {
        return new Date(Long.valueOf((date.getTime() - timeZone.getRawOffset()) + timeZone2.getRawOffset()).longValue()).getTime();
    }

    public static String formatTimeS(int i2) {
        int i3 = i2 / 3600;
        int i4 = (i2 - ((i3 * 60) * 60)) / 60;
        String str = i3 + "";
        String str2 = i4 + "";
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        if (i3 == 24 && i4 == 0) {
            return "23:59";
        }
        if (str.length() == 1) {
            str = "0" + i3;
        }
        if (str2.length() == 1) {
            str2 = "0" + i4;
        }
        return str + ":" + str2;
    }

    public static String formatTimeS2(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        String str = i4 + "";
        String str2 = i5 + "";
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        if (str.length() == 1) {
            str = "0" + i4;
        }
        if (str2.length() == 1) {
            str2 = "0" + i5;
        }
        return str + ":" + str2;
    }

    public static boolean getCompareDate(String str, String str2) {
        int i2;
        int i3;
        if (TextUtils.isEmpty(str.trim()) || TextUtils.isEmpty(str2.trim())) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = Integer.parseInt(str);
            i3 = Integer.parseInt(str2);
        }
        return i2 <= i3;
    }

    public static int getSeconds(int i2, int i3) {
        return (i2 * 3600) + (i3 * 60);
    }

    public static String getStrDate() {
        try {
            r2 = Build.VERSION.SDK_INT >= 24 ? (Build.VERSION.SDK_INT >= 24 ? new android.icu.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss") : null).parse("2013-03-20 17:47:09") : null;
            System.out.println(r2);
            System.out.println(r2.getTime() / 1000);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return (r2.getTime() / 1000) + "";
    }

    private String getStrTodayDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String getStringDateShort(String str, long j) {
        if (j == 0) {
            return "";
        }
        return Build.VERSION.SDK_INT >= 24 ? new android.icu.text.SimpleDateFormat(str).format(new Date(j * 1000)) : "";
    }

    public static String getStringDateShort2(String str, long j) {
        return (j != 0 && Build.VERSION.SDK_INT >= 24) ? new android.icu.text.SimpleDateFormat(str).format(new Date(j)) : "";
    }

    public static String getTimeDesc(int i2) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        Object valueOf6;
        if (i2 < 60) {
            StringBuilder sb = new StringBuilder();
            sb.append("00:");
            if (i2 < 10) {
                valueOf6 = "0" + i2;
            } else {
                valueOf6 = Integer.valueOf(i2);
            }
            sb.append(valueOf6);
            sb.append("");
            return sb.toString();
        }
        if (i2 >= 60 && i2 < 3600) {
            int i3 = i2 / 60;
            int i4 = i2 % 60;
            StringBuilder sb2 = new StringBuilder();
            if (i3 < 10) {
                valueOf4 = "0" + i3;
            } else {
                valueOf4 = Integer.valueOf(i3);
            }
            sb2.append(valueOf4);
            sb2.append(":");
            if (i4 < 10) {
                valueOf5 = "0" + i4;
            } else {
                valueOf5 = Integer.valueOf(i4);
            }
            sb2.append(valueOf5);
            sb2.append("");
            return sb2.toString();
        }
        int i5 = i2 / 3600;
        int i6 = i2 % 3600;
        int i7 = i6 / 60;
        int i8 = i6 % 60;
        StringBuilder sb3 = new StringBuilder();
        if (i5 < 10) {
            valueOf = "0" + i5;
        } else {
            valueOf = Integer.valueOf(i5);
        }
        sb3.append(valueOf);
        sb3.append(":");
        if (i7 < 10) {
            valueOf2 = "0" + i7;
        } else {
            valueOf2 = Integer.valueOf(i7);
        }
        sb3.append(valueOf2);
        sb3.append(":");
        if (i8 < 10) {
            valueOf3 = "0" + i8;
        } else {
            valueOf3 = Integer.valueOf(i8);
        }
        sb3.append(valueOf3);
        sb3.append("");
        return sb3.toString();
    }

    public static String getTimeZone() {
        int offset = Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / TimeConstants.HOUR;
        if (offset < 0) {
            return String.valueOf(offset);
        }
        return String.valueOf("+" + offset);
    }

    public static String getTimeZone(float f2) {
        double d2 = f2;
        return d2 == -11.0d ? "GMT-11" : d2 == -10.0d ? "GMT-10" : d2 == -9.0d ? "GMT-9" : d2 == -8.0d ? "GMT-8" : d2 == -7.0d ? "GMT-7" : d2 == -6.0d ? "GMT-6" : d2 == -5.0d ? "GMT-5" : d2 == -4.0d ? "GMT-4" : d2 == -3.5d ? "GMT-3:30" : d2 == -3.0d ? "GMT-3" : d2 == -2.0d ? "GMT-2" : d2 == -1.0d ? "GMT-1" : f2 == 0.0f ? "GMT+0" : d2 == 1.0d ? "GMT+1" : d2 == 2.0d ? "GMT+2" : d2 == 3.0d ? "GMT+3" : d2 == 3.5d ? "GMT+3:30" : d2 == 4.0d ? "GMT+4" : d2 == 4.5d ? "GMT+4:30" : d2 == 5.0d ? "GMT+5" : d2 == 5.5d ? "GMT+5:30" : d2 == 6.0d ? "GMT+6" : d2 == 7.0d ? "GMT+7" : d2 == 8.0d ? "GMT+8" : f2 == 9.0f ? "GMT+9" : d2 == 9.5d ? "GMT+9:30" : d2 == 10.0d ? "GMT+10" : d2 == 11.0d ? "GMT+11" : d2 == 12.0d ? "GMT+12" : "GMT+8";
    }

    public static long getUTCTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        MyLogUtils.e("TAG", "[UTC-1] Local time:" + (calendar.getTimeInMillis() / 1000) + ", date:" + (new Date().getTime() / 1000) + ", System:" + (System.currentTimeMillis() / 1000));
        int i2 = calendar.get(15);
        StringBuilder sb = new StringBuilder();
        sb.append("[UTC-1] zoneOffset:");
        sb.append(i2);
        MyLogUtils.e("TAG", sb.toString());
        MyLogUtils.e("TAG", "[UTC-1] dstOffset:" + calendar.get(16));
        calendar.add(14, 0);
        MyLogUtils.e("TAG", "[UTC-1] UTC time :" + calendar.getTimeInMillis());
        return calendar.getTimeInMillis();
    }

    public static long getUTCTimeSec() {
        return getUTCTime() / 1000;
    }
}
