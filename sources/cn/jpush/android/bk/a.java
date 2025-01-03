package cn.jpush.android.bk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.bm.g;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.TagAliasReceiver;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<Long> f9610a = new ConcurrentLinkedQueue<>();

    public static int a(long j) {
        if (f9610a.size() >= 10) {
            long longValue = j - f9610a.element().longValue();
            if (longValue < 0) {
                f9610a.clear();
                return 2;
            }
            if (longValue <= 10000) {
                return 1;
            }
            while (f9610a.size() >= 10) {
                f9610a.poll();
            }
        }
        f9610a.offer(Long.valueOf(j));
        return 0;
    }

    public static long a(Context context, String str, int i2, long j) {
        Logger.d("TagAliasHelper", "action - onRecvTagAliasCallBack");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, JPushInterface.ErrorCode.UNKNOWN_ERROR);
            if (i2 == 0) {
                j = jSONObject.optLong(InAppSlotParams.SLOT_KEY.SEQ);
            }
            Intent intent = new Intent();
            if (i2 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                if (!TextUtils.isEmpty(messageReceiverClass)) {
                    intent = new Intent(context, Class.forName(messageReceiverClass));
                }
                intent.setAction(JPushConstants.USER_MESSAGE_RECEIVER_ACTION);
                if (i2 == 1) {
                    intent.putExtra("message_type", 1);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            Intent intent2 = intent;
            intent2.addCategory(context.getPackageName());
            intent2.putExtra("proto_type", i2);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, optInt);
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j);
            Intent a2 = b.a().a(context, j, optInt, jSONObject, intent2);
            if (a2 != null) {
                context.sendBroadcast(a2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
            }
            return j;
        } catch (Throwable unused) {
            Logger.w("TagAliasHelper", "tagalias msgContent:" + str);
            return -1L;
        }
    }

    public static String a(Context context, String str, long j, int i2) {
        String jSONObject;
        if (c(i2)) {
            try {
                JSONObject a2 = a(i2);
                if (b(2, i2)) {
                    if (TextUtils.isEmpty(str)) {
                        Logger.ee("TagAliasHelper", "alias was empty. Give up action.");
                        a(context, 2, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                        return null;
                    }
                    if (!a(context, 2, str, j)) {
                        return null;
                    }
                    a2.put("alias", str);
                }
                jSONObject = a2.toString();
                Logger.d("TagAliasHelper", "alias str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "alias exception:" + th);
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                return jSONObject;
            }
            Logger.d("TagAliasHelper", "alias request action was empty");
            return null;
        }
        Logger.e("TagAliasHelper", "unsupport alias action type");
        a(context, 2, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.json.JSONArray] */
    public static String a(Context context, List<String> list, long j, int i2, int i3, int i4) {
        String jSONObject;
        if (i2 != 0) {
            try {
                JSONObject a2 = a(i2);
                if (a(1, i2)) {
                    if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet(list);
                        if (!a(context, 1, hashSet, j)) {
                            return null;
                        }
                        Object b2 = b(hashSet);
                        if (!b(context, b2, j, 1)) {
                            return null;
                        }
                        if (i2 != 6) {
                            b2 = new JSONArray();
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                b2.put(it.next());
                            }
                        } else if (TextUtils.isEmpty(b2)) {
                            Logger.ee("TagAliasHelper", "stags was empty. Give up action.");
                            a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                            return null;
                        }
                        a2.put("tags", b2);
                    }
                    Logger.ee("TagAliasHelper", "tags was empty. Give up action.");
                    a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                    return null;
                }
                if (i2 == 5) {
                    if (i4 == -1) {
                        i4 = 1;
                    }
                    a2.put("curr", i4);
                }
                jSONObject = a2.toString();
                Logger.d("TagAliasHelper", "tag str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "tag exception:" + th);
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                return jSONObject;
            }
            Logger.d("TagAliasHelper", "tag request action was empty");
            return null;
        }
        Logger.e("TagAliasHelper", "unsupport tag action type");
        a(context, 1, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
        return null;
    }

    public static String a(Context context, List<String> list, String str, long j) {
        String jSONObject;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        if (str != null && !a(context, 0, str, j)) {
            return null;
        }
        if (hashSet != null && !a(context, 0, hashSet, j)) {
            return null;
        }
        String b2 = b(hashSet);
        if (!b(context, b2, j, 0)) {
            return null;
        }
        if (b2 == null && str == null) {
            Logger.ee("TagAliasHelper", "NULL alias and tags. Give up action.");
            a(context, 0, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
            return null;
        }
        Logger.dd("TagAliasHelper", "action:setAliasAndTags - alias:" + str + ", tags:" + b2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JThirdPlatFormInterface.KEY_PLATFORM, c.a.a.j.a.o);
            if (str != null) {
                jSONObject2.put("alias", str);
            }
            if (hashSet != null) {
                jSONObject2.put("tags", b2);
            }
            jSONObject = jSONObject2.toString();
            Logger.d("TagAliasHelper", "tagalias str:" + jSONObject);
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "tagalias exception:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
        }
        if (!TextUtils.isEmpty(jSONObject)) {
            return jSONObject;
        }
        Logger.d("TagAliasHelper", "tagalias request action was empty");
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        for (String str : set) {
            if (TextUtils.isEmpty(str) || !g.a(str)) {
                Logger.ee("TagAliasHelper", "Invalid tag : " + str);
            } else {
                linkedHashSet.add(str);
                i2++;
                if (i2 >= 1000) {
                    Logger.ww("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
        return linkedHashSet;
    }

    public static JSONObject a(int i2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, c.a.a.j.a.o);
        jSONObject.put("op", b(i2));
        return jSONObject;
    }

    public static void a(Context context, int i2, int i3, long j) {
        try {
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i2 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                intent.setAction(JPushConstants.USER_MESSAGE_RECEIVER_ACTION);
                intent.setClass(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                if (i2 == 1) {
                    intent.putExtra("message_type", 1);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i3);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j);
            context.sendBroadcast(intent, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("TagAliasHelper", "NotifyTagAliasError:" + th.getMessage());
        }
    }

    public static void a(Context context, int i2, long j, String str) {
        Logger.dd("TagAliasHelper", "tagalias:" + str);
        if (str == null) {
            Logger.w("TagAliasHelper", "tagaliasRequest was null");
        } else {
            int i3 = i2 == 0 ? 10 : i2 == 1 ? 28 : 29;
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, i3, i2 == 0 ? 4 : i2 == 1 ? 1 : 2, j, 20000L, cn.jpush.android.bi.b.a(JCoreHelper.getAppKey(context), i3, str));
        }
    }

    public static void a(Context context, Bundle bundle) {
        int i2;
        int i3;
        String str;
        int i4;
        String str2;
        String str3;
        int i5;
        String string = bundle.getString("alias");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
        long j = bundle.getLong("seq", 0L);
        try {
            i2 = Integer.parseInt(bundle.getString("proto_type"));
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "load tag/alias proto type failed - error:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
            i2 = 0;
        }
        try {
            i3 = Integer.parseInt(bundle.getString("action_type"));
        } catch (Throwable th2) {
            Logger.w("TagAliasHelper", "load tag/alias action type failed - error:" + th2);
            a(context, i2, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
            i3 = 0;
        }
        if (cn.jpush.android.cache.a.e(context)) {
            i5 = JPushInterface.ErrorCode.PUSH_STOPED;
        } else {
            int a2 = a(System.currentTimeMillis());
            if (a2 != 0) {
                Logger.w("TagAliasHelper", a2 == 1 ? "set tags/alias too soon,over 10 times in 10s" : "set tags/alias failed,time shaft error，please try again");
                a(context, i2, a2 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, j);
                return;
            }
            if (!b.a().a(context, i2, j)) {
                String str4 = null;
                if (i2 == 0) {
                    Logger.d("TagAliasHelper", "old tag/alias proto");
                    str2 = a(context, stringArrayList, string, j);
                    str = "alias";
                    i4 = 2;
                } else {
                    if (i2 == 1) {
                        str = "alias";
                        i4 = 2;
                        str4 = a(context, stringArrayList, j, i3, -1, -1);
                    } else {
                        str = "alias";
                        i4 = 2;
                        if (i2 == 2) {
                            str4 = a(context, string, j, i3);
                        }
                    }
                    str2 = str4;
                }
                if (str2 == null || !(i2 == 1 || i2 == i4)) {
                    str3 = str2;
                } else {
                    if (!b.a().a(i2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2 == 1 ? "tag" : str);
                        sb.append(" is operatoring, please wait last operator complete");
                        Logger.w("TagAliasHelper", sb.toString());
                        a(context, i2, i2 == 1 ? JPushInterface.ErrorCode.ERROR_CODE_TAG_OPERATORING : JPushInterface.ErrorCode.ERROR_CODE_ALIAS_OPERATORING, j);
                        return;
                    }
                    int i6 = i3;
                    str3 = str2;
                    b.a().a(i2, i6, j, stringArrayList, string);
                }
                a(context, i2, j, str3);
                return;
            }
            i5 = JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
        }
        a(context, i2, i5, j);
    }

    public static void a(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        long a2 = f.a();
        if (callBackParams != null) {
            c.a().a(context, Long.valueOf(a2), callBackParams);
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (callBackParams != null && callBackParams.protoType == 0) {
            c.a().a(context);
        }
        Bundle bundle = new Bundle();
        bundle.putString("alias", str);
        bundle.putStringArrayList("tags", set != null ? new ArrayList<>(set) : null);
        bundle.putLong("seq", a2);
        StringBuilder sb = new StringBuilder();
        sb.append(callBackParams != null ? callBackParams.protoType : 0);
        sb.append("");
        bundle.putString("proto_type", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(callBackParams != null ? callBackParams.action : 0);
        sb2.append("");
        bundle.putString("action_type", sb2.toString());
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "tagalis", bundle);
    }

    public static boolean a(int i2, int i3) {
        return i2 == 1 && (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 6);
    }

    public static boolean a(Context context, int i2, String str, long j) {
        int b2 = g.b(str);
        if (b2 == 0) {
            return true;
        }
        Logger.dd("TagAliasHelper", "Invalid alias: " + str + ", will not set alias this time.");
        a(context, i2, b2, j);
        return false;
    }

    public static boolean a(Context context, int i2, Set<String> set, long j) {
        int a2 = g.a(set);
        if (a2 == 0) {
            return true;
        }
        Logger.dd("TagAliasHelper", "Invalid tags, will not set tags this time.");
        a(context, i2, a2, j);
        return false;
    }

    public static boolean a(String str, boolean z) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length + 0 : 0;
        Logger.v("TagAliasHelper", "tags length:" + length);
        if (z) {
            if (length > 5000) {
                return false;
            }
        } else if (length > 7000) {
            return false;
        }
        return true;
    }

    public static String b(int i2) {
        switch (i2) {
            case 1:
                return "add";
            case 2:
                return "set";
            case 3:
                return "del";
            case 4:
                return "clean";
            case 5:
                return "get";
            case 6:
                return "valid";
            default:
                return null;
        }
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i2 = 0;
        for (String str2 : set) {
            if (TextUtils.isEmpty(str2) || !g.a(str2)) {
                Logger.ee("TagAliasHelper", "Invalid tag: " + str2);
            } else {
                if (str != null) {
                    str2 = str + "," + str2;
                }
                i2++;
                if (i2 >= 1000) {
                    return str2;
                }
                str = str2;
            }
        }
        return str;
    }

    public static boolean b(int i2, int i3) {
        return i2 == 2 && i3 == 2;
    }

    public static boolean b(Context context, String str, long j, int i2) {
        if (str != null) {
            if (!a(str.replaceAll(",", ""), i2 != 0)) {
                a(context, i2, JPushInterface.ErrorCode.TOO_LONG_TAGALIAS, j);
                StringBuilder sb = new StringBuilder();
                sb.append("The length of tags should be less than ");
                sb.append(i2 != 0 ? LogThreadPoolManager.TIME_KEEP_ALIVE : 7000);
                sb.append(" bytes.");
                Logger.ww("TagAliasHelper", sb.toString());
                return false;
            }
        }
        return true;
    }

    public static boolean c(int i2) {
        return i2 == 2 || i2 == 3 || i2 == 5;
    }
}
