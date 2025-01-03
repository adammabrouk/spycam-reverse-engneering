package cn.jiguang.y;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.l.d;
import cn.jpush.android.api.JThirdPlatFormInterface;

/* loaded from: classes.dex */
public class a {
    @TargetApi(11)
    public static String a(Context context, Uri uri) {
        Bundle call;
        try {
            String g2 = d.g("Oi3ZFT8+schQHSyFZbsdUg==");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                call = acquireUnstableContentProviderClient.call(g2, null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(uri, g2, (String) null, (Bundle) null);
            }
            if (call.getInt(JThirdPlatFormInterface.KEY_CODE, -1) != 0) {
                return call.getString("message");
            }
            String string = call.getString("id");
            cn.jiguang.ai.a.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("NubiaIdManager", "get ids-o err:" + e2.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String a(Context context, String str, Uri uri) {
        Bundle call;
        try {
            String g2 = d.g("cBEuCuv+AtdlTcgTe9OgSQ==");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                call = acquireUnstableContentProviderClient.call(g2, str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(uri, g2, str, (Bundle) null);
            }
            if (call.getInt(JThirdPlatFormInterface.KEY_CODE, -1) != 0) {
                return call.getString("message");
            }
            String string = call.getString("id");
            cn.jiguang.ai.a.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("NubiaIdManager", "get ids-aa err:" + th.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String b(Context context, String str, Uri uri) {
        Bundle bundle;
        try {
            String g2 = d.g("fIdCW1auJ/CZh7w78TbJVQ==");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                bundle = acquireUnstableContentProviderClient.call(g2, str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                context.getContentResolver().call(uri, g2, str, (Bundle) null);
                bundle = null;
            }
            if (bundle.getInt(JThirdPlatFormInterface.KEY_CODE, -1) != 0) {
                return bundle.getString("message");
            }
            String string = bundle.getString("id");
            cn.jiguang.ai.a.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("NubiaIdManager", "get ids-va err:" + th.getMessage());
            return null;
        }
    }
}
