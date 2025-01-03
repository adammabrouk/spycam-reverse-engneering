package com.shix.shixipc.utils;

import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StringUtil {
    public static String buildTelNumberHtmlText(String str) {
        return "";
    }

    public static ArrayList<String> findNumber(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d{7,}").matcher(str);
        while (matcher.find()) {
            if (!isEmpty(matcher.group())) {
                arrayList.add(matcher.group());
            }
        }
        return arrayList;
    }

    public static String getTopicCommentDateStr(long j) {
        Date date = new Date(j);
        Date date2 = new Date();
        long time = date2.getTime() - j;
        if (time <= JConstants.MIN) {
            return "刚刚";
        }
        if (time <= JConstants.HOUR) {
            return ((int) Math.floor(time / JConstants.MIN)) + "分钟前";
        }
        if (time > JConstants.DAY) {
            return (date.getMonth() + 1) + "月" + date.getDate() + "日";
        }
        if (date2.getDate() != date.getDate()) {
            return (date.getMonth() + 1) + "月" + date.getDate() + "日";
        }
        return date.getHours() + "点" + date.getMinutes() + "分";
    }

    public static boolean isEmail(String str) {
        Boolean bool = false;
        if (str != null && str.indexOf("@") > 0 && str.indexOf(".") > 0) {
            bool = true;
        }
        return bool.booleanValue();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("") || str.trim().equalsIgnoreCase(LogUtils.NULL);
    }

    public static boolean isMobileNumber(String str) {
        return Pattern.compile("^((13)|(14)|(15)|(17)|(18))\\d{9}$").matcher(str).matches();
    }
}
