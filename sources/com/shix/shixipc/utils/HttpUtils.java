package com.shix.shixipc.utils;

import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class HttpUtils {
    public static String doHttpPost(String str, String str2) {
        System.out.println("发起的数据:" + str);
        byte[] bytes = str.getBytes();
        InputStream inputStream = null;
        try {
            try {
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.setDoOutput(true);
                openConnection.setDoInput(true);
                openConnection.setUseCaches(false);
                openConnection.setRequestProperty("content-Type", "application/json");
                openConnection.setRequestProperty("charset", "utf-8");
                openConnection.setRequestProperty("Content-length", String.valueOf(bytes.length));
                System.out.println(String.valueOf(bytes.length));
                DataOutputStream dataOutputStream = new DataOutputStream(openConnection.getOutputStream());
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                dataOutputStream.close();
                inputStream = openConnection.getInputStream();
                String str3 = new String(IOUtils.readStreamAsBytesArray(inputStream), "UTF-8");
                if ("".equals(str3.trim())) {
                    System.out.println("返回空");
                }
                System.out.println("返回数据为:" + str3);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                        return "0";
                    }
                }
                return str3;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                return "0";
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                    return "0";
                }
            }
            throw th;
        }
    }
}
