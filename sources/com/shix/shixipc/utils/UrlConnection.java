package com.shix.shixipc.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class UrlConnection {
    public static String getUrlConnect(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(MyAudioPlayer.KEY_SAMPLE_RATE);
            httpURLConnection.setReadTimeout(MyAudioPlayer.KEY_SAMPLE_RATE);
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuffer.toString();
                }
                stringBuffer.append(new String(bArr, 0, read, "utf-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String postUrlConnect(String str, Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                stringBuffer.append(str2 + "=" + map.get(str2) + "&");
            }
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        CommonUtil.Log(1, "zhaogenghuaiPOST request:" + substring);
        System.out.println(substring);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(substring.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer2 = new StringBuffer();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    inputStream.close();
                    outputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuffer2.toString();
                }
                stringBuffer2.append(new String(bArr, 0, read, "utf-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
