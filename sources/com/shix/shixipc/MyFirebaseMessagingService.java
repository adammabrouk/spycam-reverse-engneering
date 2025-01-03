package com.shix.shixipc;

import a.h.a.g;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.shix.lookcam.R;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;

/* loaded from: classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "MyFirebaseMsgService";

    private void handleNow() {
        Log.d(TAG, "Short lived task is done.");
    }

    private void scheduleJob() {
    }

    private void sendNotification(String str, String str2) {
        MyLogUtils.d(TAG, " messageBody=" + str + " messageTitle=" + str2);
        Intent intent = new Intent(this, (Class<?>) NUIMainActivity.class);
        intent.addFlags(67108864);
        PendingIntent broadcast = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this, 0, intent, 201326592) : PendingIntent.getBroadcast(this, 0, intent, MemoryConstants.GB);
        String string = getString(R.string.app_name);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        g.e eVar = new g.e(this, string);
        eVar.e(R.mipmap.ic_launcher_round);
        eVar.b(str2);
        eVar.a((CharSequence) str);
        eVar.a(true);
        eVar.a(defaultUri);
        eVar.a(broadcast);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(string, "Channel human readable title", 3));
        }
        notificationManager.notify(0, eVar.a());
    }

    private void sendRegistrationToServer(String str) {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        super.onDeletedMessages();
        Log.d(TAG, "在某些情况下，FCM 可能不会传递消息。如果在特定设备连接 FCM 时，您的应用在该设备上的待处理消息过多（超过 100 条），或者如果设备超过一个月未连接到 FCM，就会发生这种情况。在这些情况下，您可能会收到对 FirebaseMessagingService.onDeletedMessages() 的回调。");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String decodeString;
        if (remoteMessage == null || remoteMessage.u() == null) {
            return;
        }
        if (remoteMessage.u().size() > 0) {
            boolean z = false;
            LogUtils.d(TAG, "Message data payload: " + remoteMessage.u());
            String replace = remoteMessage.u().get("dev_uid").replace("-", "");
            String str = remoteMessage.u().get("unsub_en");
            int i2 = 0;
            while (true) {
                if (i2 >= SystemValue.arrayList.size()) {
                    break;
                }
                if (replace.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                if (!str.equalsIgnoreCase("1") || (decodeString = SpUtil.INSTANCE.decodeString("SHIXUUID")) == null || TextUtils.isEmpty(decodeString)) {
                    return;
                }
                NativeCallerTools.SDKAPIOpenDeviceSendCmd(replace, CommonUtil.SHIX_Delpush2(decodeString));
                return;
            }
            if (remoteMessage.u().get("alarm_type") == null || remoteMessage.u().get("alarm_type") == null) {
                return;
            }
            if (!remoteMessage.u().get("alarm_type").equals("1")) {
                sendNotification(remoteMessage.u().get("text"), remoteMessage.u().get("title"));
            }
            scheduleJob();
        }
        if (remoteMessage.v() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.v().a());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        Log.d(TAG, "Refreshed token: " + str);
        sendRegistrationToServer(str);
    }
}
