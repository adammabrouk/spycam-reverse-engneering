package cn.jiguang.as;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f8344b = cn.jiguang.p.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 87, 112, 39, 101, 97, 95, 77, 117});

    /* renamed from: a, reason: collision with root package name */
    public static String f8343a = "";

    public static void a(final Context context) {
        if (context == null) {
            return;
        }
        int intValue = ((Integer) cn.jiguang.f.b.a(context, cn.jiguang.f.a.Z())).intValue();
        if (intValue <= 10) {
            intValue = 10;
        }
        cn.jiguang.bj.d.a("DELAY_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.as.a.1
            @Override // cn.jiguang.bj.b
            public void a() {
                String str;
                try {
                    long f2 = cn.jiguang.d.a.f(context);
                    if (f2 == 0) {
                        return;
                    }
                    String str2 = context.getFilesDir() + File.separator + c.f8346a + File.separator;
                    File file = new File(str2 + c.f8347b);
                    if (!file.getParentFile().exists()) {
                        d.c("LogFileHelper", "there is no log file dir!");
                        return;
                    }
                    if (file.exists() && file.length() != 0) {
                        String str3 = "android-" + cn.jiguang.e.a.p(context) + "-" + f2 + ".aes";
                        File file2 = new File(str2 + str3);
                        if (file2.exists()) {
                            file2.delete();
                            file2.createNewFile();
                            str = " repeat Create aesFile : " + file2.getName();
                        } else {
                            file2.createNewFile();
                            str = "Create aesFile : " + file2.getName();
                        }
                        d.a("LogFileHelper", str);
                        cn.jiguang.at.a.a(cn.jiguang.ao.a.a(context), file, file2);
                        if (file2.length() == 0) {
                            d.c("LogFileHelper", "aesFile encrypt fail");
                            file2.delete();
                            return;
                        }
                        String b2 = a.b(context, str3);
                        if (TextUtils.isEmpty(b2)) {
                            d.c("LogFileHelper", "getUploadToken token is empty");
                            file2.delete();
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("key", str3);
                        hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, b2);
                        if (cn.jiguang.at.b.a("https://upload-z2.qiniup.com", file2, hashMap)) {
                            file.delete();
                        }
                        file2.delete();
                        return;
                    }
                    d.c("LogFileHelper", "there is no log file to upload!");
                } catch (Throwable th) {
                    d.g("LogFileHelper", "startUpload error is " + th.getMessage());
                }
            }
        }, intValue * 1000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f3, code lost:
    
        if (r2 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x021d, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.as.a.b(android.content.Context, java.lang.String):java.lang.String");
    }
}
