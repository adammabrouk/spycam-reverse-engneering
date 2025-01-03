package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.bm.e;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* loaded from: classes.dex */
public class ActionHelper {
    public static final String TAG = "ActionHelper";
    public static volatile ActionHelper actionHelper;
    public static final Object locker = new Object();
    public JPushAction jPushAction;
    public cn.jpush.android.bh.a loadedResource;

    public class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public Context f9796b;

        /* renamed from: c, reason: collision with root package name */
        public String f9797c;

        /* renamed from: d, reason: collision with root package name */
        public Object f9798d;

        public a(Context context, String str, Object obj) {
            this.f9796b = context;
            this.f9797c = str;
            this.f9798d = obj;
            this.f9666f = "ActionHelper#Action";
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f9796b);
                ActionHelper.this.jPushAction.handleAction(this.f9796b, this.f9797c, this.f9798d);
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends e {

        /* renamed from: b, reason: collision with root package name */
        public Context f9800b;

        /* renamed from: c, reason: collision with root package name */
        public String f9801c;

        /* renamed from: d, reason: collision with root package name */
        public int f9802d;

        /* renamed from: e, reason: collision with root package name */
        public Set<String> f9803e;

        /* renamed from: g, reason: collision with root package name */
        public CallBackParams f9804g;

        public b(Context context, String str, Set<String> set, int i2, CallBackParams callBackParams) {
            this.f9804g = callBackParams;
            this.f9801c = str;
            this.f9802d = i2;
            this.f9800b = context;
            this.f9803e = set;
            this.f9666f = "ActionHelper#TagAliasAction";
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f9800b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.f9800b, this.f9801c, this.f9803e, this.f9804g);
            } catch (Throwable unused) {
            }
        }
    }

    public ActionHelper() {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 13, TAG, null, new Object[0]);
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                if (actionHelper == null) {
                    actionHelper = new ActionHelper();
                }
            }
        }
        return actionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initLoad(Context context) {
        if (this.jPushAction != null) {
            return;
        }
        if (this.jPushAction == null) {
            Logger.d(TAG, "load from local");
            this.jPushAction = new cn.jpush.android.bb.a();
        }
    }

    public Object beforLogin(Context context, String str, int i2, String str2) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.beforLogin(context, str, i2, str2);
        }
        return null;
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.majorExecutor(context, TAG, new a(context, str, obj));
    }

    public void doSingleAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doSingleAction: " + str);
        JCoreHelper.futureExecutor(context, TAG, new a(context, str, obj));
    }

    public Class getClassInPlugin(String str) {
        return null;
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPopWinActivity(context);
        }
        return null;
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPushActivity(context);
        }
        return null;
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        return 0;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.handleNotificationIntent(context, intent);
        }
    }

    public boolean isSupportedCMD(String str, int i2) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.isSupportedCMD(str, i2) : i2 == 3 || i2 == 29 || i2 == 28 || i2 == 27 || i2 == 10 || i2 == 26 || i2 == 25 || i2 == 34 || i2 == 36 || i2 == 37;
    }

    public void onActivityLifeCallback(Activity activity, String str) {
        if (activity != null) {
            initLoad(activity.getApplicationContext());
            JPushAction jPushAction = this.jPushAction;
            if (jPushAction != null) {
                jPushAction.onActivityLifeCallback(activity, str);
            }
        }
    }

    public void onEvent(Thread thread, Throwable th) {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
    }

    public void onInAppMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageArrived(context, notificationMessage);
        }
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageClick(context, notificationMessage);
        }
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
        }
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMessage(context, customMessage);
        }
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMultiAction(context, intent);
        }
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageArrived(context, notificationMessage);
        }
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageOpened(context, notificationMessage);
        }
    }

    public void onTagAliasResponse(Context context, long j, int i2, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onTagAliasResponse(context, j, i2, intent);
        }
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i2, int i3) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i2, i3)));
    }

    public void setAliasWithCallBack(Context context, int i2, String str, int i3, int i4) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, null, i2, new CallBackParams(i2, str, System.currentTimeMillis(), i3, i4)));
    }

    public void setTagsWithCallBack(Context context, int i2, Set<String> set, int i3, int i4) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, set, i2, new CallBackParams(i2, set, System.currentTimeMillis(), i3, i4)));
    }
}
