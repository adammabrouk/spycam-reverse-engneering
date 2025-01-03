package com.shix.shixipc.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.jiguang.internal.JConstants;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.zxing.qrcode.encoder.Encoder;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ThreadUtils;
import com.shix.shixipc.utilcode.TimeConstants;
import com.tencent.bugly.Bugly;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class StringUtils {
    public static String add0(int i2, int i3) {
        return String.valueOf(((long) Math.pow(10.0d, i3)) + i2).substring(1);
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean checkEmail(String str) {
        try {
            return Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkInput(String str) {
        try {
            return Pattern.compile("^[a-zA-Z0-9_一-龥]+$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkMobile(String str) {
        try {
            return Pattern.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkParameter(String str) {
        return ((((((str.indexOf("'") + 1) + 0) + (str.indexOf(";") + 1)) + (str.indexOf("1=1") + 1)) + (str.indexOf("|") + 1)) + (str.indexOf("<") + 1)) + (str.indexOf(">") + 1) == 0;
    }

    public static boolean checkPwd(String str) {
        try {
            return Pattern.compile("^[a-z0-9A-Z]{6,13}$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkPwdCharacter(String str) {
        try {
            boolean matches = Pattern.compile("^[a-z0-9A-Z]+$").matcher(str).matches();
            MyLogUtils.e("lhc,checkPwdCharacter m.matches", "lhc,checkPwdCharacter m.matches:" + matches);
            return matches;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String commentTime(long j) {
        if (j == 0) {
            return "";
        }
        long j2 = j * 1000;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            long currentTimeMillis = System.currentTimeMillis() - j2;
            StringBuilder sb = new StringBuilder();
            if (currentTimeMillis > 0 || currentTimeMillis < 0 || currentTimeMillis == 0) {
                if (((int) (currentTimeMillis / JConstants.MIN)) <= 1) {
                    return "刚刚";
                }
                int i2 = (int) (currentTimeMillis / JConstants.MIN);
                if (i2 < 60) {
                    sb.append(i2);
                    sb.append("分钟前");
                    return sb.toString();
                }
                int i3 = (int) (currentTimeMillis / JConstants.HOUR);
                if (i3 >= 24) {
                    return ((int) (currentTimeMillis / JConstants.DAY)) < 365 ? simpleDateFormat.format(Long.valueOf(j2)) : simpleDateFormat2.format(Long.valueOf(j2));
                }
                sb.append(i3);
                sb.append("小时前");
                return sb.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static int compare(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, length + 1, length2 + 1);
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2][0] = i2;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            iArr[0][i3] = i3;
        }
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            char charAt = str.charAt(i5);
            for (int i6 = 1; i6 <= length2; i6++) {
                int i7 = i6 - 1;
                iArr[i4][i6] = min(iArr[i5][i6] + 1, iArr[i4][i7] + 1, iArr[i5][i7] + (charAt == str2.charAt(i7) ? 0 : 1));
            }
        }
        return iArr[length][length2];
    }

    public static String convert88591Toutf8(String str) {
        try {
            return new String(str.getBytes(Encoder.DEFAULT_BYTE_MODE_ENCODING), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String convertNullValue(String str) {
        return str == null ? "" : str;
    }

    public static int deciMal(int i2, int i3) {
        return (int) (new BigDecimal(i2 / i3).setScale(2, 4).doubleValue() * 100.0d);
    }

    public static String decodingFromISO8858_1(String str) throws UnsupportedEncodingException {
        return isEmpty(str) ? "" : new String(str.getBytes("ISO8859-1"));
    }

    public static String differTime(String str) {
        if (!isNotEmpty(str)) {
            return "";
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
            long j = currentTimeMillis / JConstants.MIN;
            if (j < 60) {
                return j + "分钟前";
            }
            long j2 = currentTimeMillis / JConstants.HOUR;
            if (j2 < 24) {
                return j2 + "小时前";
            }
            if (currentTimeMillis / JConstants.DAY >= 1) {
                long j3 = currentTimeMillis / JConstants.DAY;
                if (j3 <= 3) {
                    return j3 + "天前";
                }
            }
            return currentTimeMillis / JConstants.DAY > 3 ? str.substring(5, str.lastIndexOf("-") + 3) : "";
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String encodeUrl(String str) {
        if (!isNotEmpty(str)) {
            return "";
        }
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 19968 && charAt <= 40869) {
                arrayList.add(Character.valueOf(charAt));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Character ch = (Character) it.next();
            try {
                str = str.replace(ch.toString(), URLEncoder.encode(ch.toString(), "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static String formatNumber(String str, long j) {
        return new DecimalFormat(str).format(j);
    }

    public static String formatTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j * 1000));
    }

    public static String formatTimeAd(long j) {
        if (j == 0) {
            return "";
        }
        long j2 = j * 1000;
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j2)) + "       " + getWeek(new Date(j2));
    }

    public static String generator(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static String getApkNameFromUrl(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return "update" + new Random().nextInt(10000) + ".apk";
        }
        if (str.contains("/") && str.contains(".apk")) {
            return str.substring(str.lastIndexOf(47) + 1);
        }
        return hashKeyForDisk(str) + ".apk";
    }

    public static String getFileNameFromUrl(String str) {
        return hashKeyForDisk(str) + "..apk";
    }

    public static int getImageViewFieldValue(Object obj, String str) {
        if (!(obj instanceof ImageView)) {
            return 0;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getJsonString(java.lang.String r7) {
        /*
            java.lang.String r0 = "getJsonString"
            java.lang.String r1 = ""
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            if (r4 != 0) goto L25
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r3.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r3.append(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            java.lang.String r7 = "not contain the file !!!"
            r3.append(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            com.shix.shixipc.utils.MyLogUtils.i(r0, r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            return r1
        L25:
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r7.<init>(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            java.lang.String r1 = r7.readLine()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3c
            r7.close()     // Catch: java.io.IOException -> L37
            goto L65
        L37:
            return r2
        L38:
            r0 = move-exception
            r3 = r7
            r7 = r0
            goto L67
        L3c:
            r3 = move-exception
            r6 = r3
            r3 = r7
            r7 = r6
            goto L46
        L41:
            r7 = move-exception
            r3 = r2
            goto L67
        L44:
            r7 = move-exception
            r3 = r2
        L46:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r4.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "Exception e: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L66
            r4.append(r7)     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L66
            com.shix.shixipc.utils.MyLogUtils.i(r0, r7)     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L65
            r3.close()     // Catch: java.io.IOException -> L64
            goto L65
        L64:
            return r2
        L65:
            return r1
        L66:
            r7 = move-exception
        L67:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6d
            goto L6e
        L6d:
            return r2
        L6e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.StringUtils.getJsonString(java.lang.String):java.lang.String");
    }

    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    public static String getLinkString(String[] strArr) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(",");
            }
            str = sb.toString();
        }
        return str.indexOf(",") != -1 ? str.substring(0, str.length() - 1) : str;
    }

    public static long getMillisFromMin(String str) {
        if (isEmpty(str)) {
            return 0L;
        }
        return Integer.parseInt(str) * TimeConstants.MIN;
    }

    public static String getNameFromUrl(String str) {
        try {
            return isNotEmpty(str) ? str.substring(str.lastIndexOf("/") + 1) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNameFromUrlWithoutPostfix(String str) {
        try {
            return isNotEmpty(str) ? str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNewString(ArrayList<String> arrayList) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (arrayList == null || arrayList.size() <= 0) {
            str = "";
        } else {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            str = sb.toString();
        }
        return str.indexOf(",") != -1 ? str.substring(0, str.length() - 1) : str;
    }

    public static String getNum(int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= 1000 && i2 < 10000) {
            sb.append(i2 / 1000);
            sb.append(".");
            sb.append((i2 % 1000) / 100);
            sb.append("k");
            return sb.toString();
        }
        if (i2 >= 10000 && i2 < 100000) {
            sb.append(i2 / 10000);
            sb.append(".");
            sb.append((i2 % 10000) / 1000);
            sb.append("w");
            return sb.toString();
        }
        if (i2 < 100000) {
            return String.valueOf(i2);
        }
        sb.append(i2 / 10000);
        sb.append(".");
        sb.append((i2 % 10000) / 1000);
        sb.append("w");
        return sb.toString();
    }

    public static float getSimilarityRatio(String str, String str2) {
        return 1.0f - (compare(str, str2) / Math.max(str.length(), str2.length()));
    }

    public static String getSqlInClauseByList(String[] strArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            for (String str2 : strArr) {
                stringBuffer.append("'");
                stringBuffer.append(str2);
                stringBuffer.append("'");
                stringBuffer.append(",");
            }
            str = stringBuffer.toString();
        }
        return str.indexOf(",") != -1 ? str.substring(0, str.length() - 1) : str;
    }

    public static String getSysTime(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        long j2 = currentTimeMillis / JConstants.MIN;
        if (j2 < 60) {
            return j2 + "分钟前";
        }
        long j3 = currentTimeMillis / JConstants.HOUR;
        if (j3 < 24) {
            return j3 + "小时前";
        }
        long j4 = currentTimeMillis / JConstants.DAY;
        if (j4 < 1) {
            return "";
        }
        return j4 + "天前";
    }

    public static String getUpDataRules(String str) {
        return isEmpty(str) ? "" : str.contains("&") ? str.replaceAll("&", "*") : str;
    }

    public static String getUrlString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static String getValue(String str, String str2) {
        if (!sdCardExist() || !isNotEmpty(str2)) {
            return "";
        }
        try {
            String jsonString = getJsonString(str2);
            if (!isNotEmpty(jsonString)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(jsonString);
            return jSONObject.has(str) ? jSONObject.getString(str) : "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getWeatherHighTemp(String str) {
        if (isNotEmpty(str)) {
            try {
                return str.substring(str.indexOf("~") + 1, str.length() - 1) + "°";
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String getWeek(Date date) {
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i2 = calendar.get(7) - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        return strArr[i2];
    }

    public static String hashKeyForDisk(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static boolean httpJudge(String str) {
        return Pattern.compile("http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*").matcher(str).find();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static int min(int i2, int i3, int i4) {
        if (i2 >= i3) {
            i2 = i3;
        }
        return i2 < i4 ? i2 : i4;
    }

    public static synchronized void putValue(String str, String str2, String str3) throws IOException {
        synchronized (StringUtils.class) {
            if (sdCardExist() && isNotEmpty(str3)) {
                File file = new File(str3);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file.createNewFile();
                if (file.exists()) {
                    BufferedWriter bufferedWriter = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        try {
                            String jsonString = getJsonString(str3);
                            if (isNotEmpty(jsonString)) {
                                jSONObject = new JSONObject(jsonString);
                            }
                            jSONObject.put(str, str2);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str3));
                            try {
                                bufferedWriter2.write(jSONObject.toString());
                                bufferedWriter2.flush();
                                bufferedWriter2.close();
                            } catch (FileNotFoundException e2) {
                                bufferedWriter = bufferedWriter2;
                                e = e2;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (IOException e3) {
                                bufferedWriter = bufferedWriter2;
                                e = e3;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (JSONException e4) {
                                bufferedWriter = bufferedWriter2;
                                e = e4;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (Throwable th) {
                                bufferedWriter = bufferedWriter2;
                                th = th;
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                        } catch (IOException e6) {
                            e = e6;
                        } catch (JSONException e7) {
                            e = e7;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public static synchronized void putValueS(HashMap<String, String> hashMap, String str) throws IOException {
        synchronized (StringUtils.class) {
            if (sdCardExist() && isNotEmpty(str)) {
                File file = new File(str);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file.createNewFile();
                if (file.exists()) {
                    BufferedWriter bufferedWriter = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        try {
                            String jsonString = getJsonString(str);
                            if (isNotEmpty(jsonString)) {
                                jSONObject = new JSONObject(jsonString);
                            }
                            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                                jSONObject.put(entry.getKey(), entry.getValue());
                            }
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str));
                            try {
                                bufferedWriter2.write(jSONObject.toString());
                                bufferedWriter2.flush();
                                bufferedWriter2.close();
                            } catch (FileNotFoundException e2) {
                                bufferedWriter = bufferedWriter2;
                                e = e2;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (IOException e3) {
                                bufferedWriter = bufferedWriter2;
                                e = e3;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (JSONException e4) {
                                bufferedWriter = bufferedWriter2;
                                e = e4;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                            } catch (Throwable th) {
                                bufferedWriter = bufferedWriter2;
                                th = th;
                                if (bufferedWriter != null) {
                                    bufferedWriter.flush();
                                    bufferedWriter.close();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                        } catch (IOException e6) {
                            e = e6;
                        } catch (JSONException e7) {
                            e = e7;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public static String removeHtmlCssForTts(String str) {
        if ("".equals(str) || str == null) {
            return "";
        }
        String replaceAll = Pattern.compile("\\s*<.*?>\\s*", 42).matcher(str).replaceAll("").replaceAll("&nbsp", "").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        return replaceAll.substring(replaceAll.lastIndexOf(Bugly.SDK_IS_DEV) + 7).trim();
    }

    public static String removeHtmlFlow(String str) {
        return ("".equals(str) || str == null) ? "" : Pattern.compile("\\s*<.*?>\\s*", 42).matcher(str).replaceAll("").replaceAll(OSSUtils.NEW_LINE, "<br>     ");
    }

    public static String removeHtmlTag(String str) {
        return ("".equals(str) || str == null) ? "" : Pattern.compile("\\s*<.*?>\\s*", 42).matcher(str).replaceAll("").replaceAll("&nbsp;", LogUtils.PLACEHOLDER).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
    }

    public static String removeNFlow(String str) {
        if (!isNotEmpty(str)) {
            return "";
        }
        if (str.startsWith(OSSUtils.NEW_LINE)) {
            str = str.replaceFirst(OSSUtils.NEW_LINE, "");
        }
        return str.replaceAll(OSSUtils.NEW_LINE, "<br>     ");
    }

    public static String replace(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        do {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf == -1) {
                break;
            }
            stringBuffer.append(str.substring(i2, indexOf));
            stringBuffer.append(str3);
            i2 = str2.length() + indexOf;
        } while (i2 < str.length());
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static synchronized void saveJsonStrToFile(String str, String str2) throws IOException {
        synchronized (StringUtils.class) {
            if (sdCardExist() && isNotEmpty(str2)) {
                File file = new File(str2);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file.createNewFile();
                if (file.exists()) {
                    BufferedWriter bufferedWriter = null;
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
                            try {
                                bufferedWriter2.write(str);
                                bufferedWriter2.close();
                            } catch (Exception e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            }
        }
    }

    public static synchronized void saveJsonTocache(String str, String str2) throws IOException {
        synchronized (StringUtils.class) {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.close();
                    } catch (Exception e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    public static boolean sdCardExist() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String setSizetoDoble(double d2) {
        return new BigDecimal(d2).setScale(2, 4).toString();
    }

    public static String[] splitStringComma(String str) {
        try {
            if (isNotEmpty(str)) {
                return str.split(",");
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String waterwallRssTime(long j) {
        if (j == 0) {
            return "";
        }
        long j2 = j * 1000;
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("zjj, waterwallCTime:");
            sb.append(currentTimeMillis);
            sb.append(" min:");
            long j3 = currentTimeMillis / JConstants.MIN;
            sb.append(j3);
            MyLogUtils.e("zjj, waterwallCTime:", sb.toString());
            if (j3 < 60) {
                if (j3 == 0) {
                    j3 = 1;
                }
                return j3 + "分钟前";
            }
            long j4 = currentTimeMillis / JConstants.HOUR;
            if (j4 < 24) {
                return j4 + "小时前";
            }
            if (currentTimeMillis / JConstants.DAY >= 1) {
                return new SimpleDateFormat("MM-dd HH:mm").format(new Date(j2));
            }
        }
        return "";
    }

    public static String waterwallTime(long j) {
        if (j == 0) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis() - (j * 1000);
        StringBuilder sb = new StringBuilder();
        if (currentTimeMillis > 0) {
            long j2 = currentTimeMillis / JConstants.MIN;
            if (j2 < 60) {
                if (j2 == 0) {
                    j2 = 1;
                }
                sb.append(j2);
                sb.append("分钟前");
                return sb.toString();
            }
            long j3 = currentTimeMillis / JConstants.HOUR;
            if (j3 < 24) {
                sb.append(j3);
                sb.append("小时前");
                return sb.toString();
            }
        }
        return "";
    }

    public static String waterwallTimeForWeibo(String str) {
        if (isNotEmpty(str)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US).parse(str).getTime();
                long j = currentTimeMillis / JConstants.MIN;
                if (j < 60) {
                    if (j == 0) {
                        j = 1;
                    }
                    return j + "分钟前";
                }
                long j2 = currentTimeMillis / JConstants.HOUR;
                if (j2 < 24) {
                    return j2 + "小时前";
                }
                if (currentTimeMillis / JConstants.DAY >= 1) {
                    long j3 = currentTimeMillis / JConstants.DAY;
                    if (j3 <= 3) {
                        return j3 + "天前";
                    }
                }
                if (currentTimeMillis / JConstants.DAY > 3) {
                    return "";
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String waterwallTime(String str) {
        if (!isNotEmpty(str)) {
            return "";
        }
        try {
            return waterwallTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str).getTime());
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getLinkString(Object[] objArr) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (objArr == null || objArr.length <= 0) {
            str = "";
        } else {
            for (Object obj : objArr) {
                sb.append(obj.toString());
                sb.append(",");
            }
            str = sb.toString();
        }
        return str.indexOf(",") != -1 ? str.substring(0, str.length() - 1) : str;
    }

    public static String waterwallTimeForWeibo(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        long j2 = currentTimeMillis / JConstants.MIN;
        if (j2 < 60) {
            if (j2 == 0) {
                j2 = 1;
            }
            return j2 + "分钟前";
        }
        long j3 = currentTimeMillis / JConstants.HOUR;
        if (j3 < 24) {
            return j3 + "小时前";
        }
        long j4 = currentTimeMillis / JConstants.DAY;
        if (j4 < 1 || j4 > 3) {
            if (j4 > 3) {
            }
            return "";
        }
        return j4 + "天前";
    }
}
