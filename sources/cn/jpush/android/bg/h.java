package cn.jpush.android.bg;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {
    public static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        String str3;
        Logger.v("RichHelper", "action:loadHtmlImageResources - urlPrefix:" + str);
        if (!cn.jpush.android.bm.a.c(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String next = it.next();
            if (next == null || next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                str3 = next;
            } else {
                str3 = str + next;
            }
            byte[] b2 = cn.jpush.android.bf.a.b(str3, 5, 5000L);
            if (b2 != null) {
                try {
                    String str4 = "";
                    if (next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                        str4 = next.substring(0, next.lastIndexOf("/") + 1);
                        next = cn.jpush.android.bm.c.b(next);
                    }
                    String b3 = !z ? cn.jpush.android.bm.c.b(context, str2) : cn.jpush.android.bm.c.c(context, str2);
                    if (!TextUtils.isEmpty(str4)) {
                        b3 = str4.replaceAll(str, b3);
                    }
                    String str5 = b3 + next;
                    cn.jpush.android.bm.c.a(str5, b2);
                    Logger.v("RichHelper", "Succeed to load image - " + str5);
                } catch (Exception e2) {
                    Logger.ww("RichHelper", "Write storage error,  create img file fail.", e2);
                }
            } else {
                cn.jpush.android.helper.c.a(str2, 1020, (String) null, context);
            }
            z2 = false;
        }
        return z2;
    }
}
