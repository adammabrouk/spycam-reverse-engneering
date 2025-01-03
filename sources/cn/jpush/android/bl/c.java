package cn.jpush.android.bl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.bm.e;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.PushReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static c f9638d;

    /* renamed from: a, reason: collision with root package name */
    public List<JThirdPlatFormInterface> f9640a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f9641c;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Byte> f9637b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9639e = new Object();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f9650a;

        /* renamed from: b, reason: collision with root package name */
        public int f9651b;

        /* renamed from: c, reason: collision with root package name */
        public String f9652c;

        /* renamed from: d, reason: collision with root package name */
        public byte f9653d;

        public a() {
        }

        public String toString() {
            return "ThirdMessage{msgid='" + this.f9650a + "', notiId=" + this.f9651b + ", content='" + this.f9652c + "', platform=" + ((int) this.f9653d) + '}';
        }
    }

    static {
        f9637b.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        f9637b.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        f9637b.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        f9637b.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        f9637b.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
        f9637b.put("cn.jpush.android.thirdpush.vivo.VivoPushManager", (byte) 5);
        f9637b.put(cn.jpush.android.asus.b.class.getName(), (byte) 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            aVar = new a();
            aVar.f9652c = bundle.getString(JThirdPlatFormInterface.KEY_DATA);
            aVar.f9650a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
            aVar.f9651b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            aVar.f9653d = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        } else {
            aVar = null;
        }
        Logger.d("ThirdPushManager", "parse third messgae:" + aVar);
        return aVar;
    }

    public static c a() {
        if (f9638d == null) {
            synchronized (f9639e) {
                if (f9638d == null) {
                    f9638d = new c();
                }
            }
        }
        return f9638d;
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface == null || !jThirdPlatFormInterface.isNeedClearToken(context)) {
            return;
        }
        byte romType = jThirdPlatFormInterface.getRomType(context);
        Sp.set(context, Key.ThirdPush_RegUpload(romType).set(false));
        Sp.set(context, Key.ThirdPush_RegID(romType).set(null));
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface, String str) {
        Logger.d("ThirdPushManager", "sendBroadCastToUploadToken:" + str);
        String token = jThirdPlatFormInterface.getToken(context);
        if (!TextUtils.isEmpty(token)) {
            b(context, jThirdPlatFormInterface.getRomType(context), token);
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", JPushConstants.SDK_TYPE);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, jThirdPlatFormInterface.getRomType(context));
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "send " + str + " failed:" + th);
        }
    }

    private void b(Context context, byte b2, String str) {
        Logger.ii("ThirdPushManager", "[uploadInService] regid:" + str + ",romtype:" + ((int) b2));
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f9640a) {
            if (jThirdPlatFormInterface.getRomType(context) == b2) {
                a(context, jThirdPlatFormInterface);
                c(context, b2, str);
            }
        }
    }

    private void c(Context context, byte b2, String str) {
        Logger.d("ThirdPushManager", "sendUpdateRegIDRequest, WhichPlatform:" + ((int) b2) + ",regID:" + str);
        Sp.set(context, Key.ThirdPush_RegUpload(b2).set(false));
        Sp.set(context, Key.ThirdPush_RegID(b2).set(str));
        cn.jpush.android.bl.a.a().a(context, b2, str);
    }

    private void j(Context context) {
        Object newInstance;
        Logger.d("ThirdPushManager", "[loadThirdPush]");
        for (Map.Entry<String, Byte> entry : f9637b.entrySet()) {
            try {
                Class<?> cls = Class.forName(entry.getKey(), false, context.getClassLoader());
                if (cls != null && (newInstance = cls.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.f9640a.add((JThirdPlatFormInterface) newInstance);
                    } else {
                        Byte value = entry.getValue();
                        Sp.set(context, Key.ThirdPush_RegID(value.byteValue()).set(null));
                        Sp.set(context, Key.ThirdPush_RegUpload(value.byteValue()).set(false));
                    }
                }
            } catch (Throwable th) {
                Byte value2 = entry.getValue();
                Sp.set(context, Key.ThirdPush_RegID(value2.byteValue()).set(null));
                Sp.set(context, Key.ThirdPush_RegUpload(value2.byteValue()).set(false));
                if ((th instanceof RuntimeException) && th.getMessage().contains("Please check") && JCoreManager.getDebugMode()) {
                    if (cn.jpush.android.bc.b.f9503c >= 238) {
                        JCoreHelper.futureExecutor(context, new e("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.bl.c.1
                            @Override // cn.jpush.android.bm.e
                            public void a() {
                                throw new RuntimeException(th);
                            }
                        });
                    } else {
                        new Thread(new Runnable() { // from class: cn.jpush.android.bl.c.2
                            @Override // java.lang.Runnable
                            public void run() {
                                throw new RuntimeException(th);
                            }
                        }).start();
                    }
                }
                Logger.w("ThirdPushManager", "loadThirdPush error:" + th.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT < 26 || this.f9640a.isEmpty()) {
            return;
        }
        cn.jpush.android.bg.a.a(context);
    }

    public byte a(Context context, String str) {
        if (!cn.jpush.android.bc.b.a()) {
            return (byte) -1;
        }
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f9640a) {
            byte romType = jThirdPlatFormInterface.getRomType(context);
            if (romType == 1) {
                int nofiticationID = JThirdPlatFormInterface.getNofiticationID(str, romType);
                Logger.d("ThirdPushManager", "clearThirdNotificaiton msgid:" + str + ",  romType:" + ((int) romType) + " , notificationId:" + nofiticationID);
                jThirdPlatFormInterface.clearNotification(context, nofiticationID);
                return romType;
            }
        }
        return (byte) -1;
    }

    public synchronized void a(Context context) {
        if (this.f9641c) {
            return;
        }
        if (context == null) {
            return;
        }
        j(context);
        this.f9641c = true;
    }

    public void a(Context context, byte b2, String str) {
        if (cn.jpush.android.bc.b.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            Logger.ii("ThirdPushManager", "uploadRegID regid:" + str);
            a(context);
            Bundle bundle = new Bundle();
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, b2);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_push_upload_regid", bundle);
        }
    }

    public void a(Context context, int i2, String str) {
        try {
            Logger.dd("ThirdPushManager", "[callBackTokenToUser] platform:" + i2 + ",token:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt(JThirdPlatFormInterface.KEY_PLATFORM, i2);
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            cn.jpush.android.bg.b.a(context, 10000, 0, "", bundle);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "callBackTokenToUser failed:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        if (context == null) {
            context = JPushConstants.mApplicationContext;
        }
        if (context == null) {
            Logger.e("ThirdPushManager", "context was null");
        } else if (bundle == null) {
            Logger.ww("ThirdPushManager", "bundle is null");
        } else {
            b(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) 0).byteValue(), bundle.getString(JThirdPlatFormInterface.KEY_TOKEN));
        }
    }

    public void a(final Context context, final String str, final Bundle bundle) {
        try {
            Logger.dd("ThirdPushManager", "doAction,action:" + str + ",bundle:" + bundle + ",enable:" + cn.jpush.android.bc.b.a());
            if (cn.jpush.android.bc.b.a()) {
                JCoreHelper.majorExecutor(context, "ThirdPushManager", new e("ThirdPushManager#doAction") { // from class: cn.jpush.android.bl.c.3
                    @Override // cn.jpush.android.bm.e
                    public void a() {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                                    a a2 = c.this.a(bundle);
                                    if (a2 != null) {
                                        b.a(context, a2.f9652c, a2.f9650a, a2.f9651b, a2.f9653d, 1);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                                    a a3 = c.this.a(bundle);
                                    if (a3 != null) {
                                        b.a(context, a3.f9652c, a3.f9650a, a3.f9651b, a3.f9653d, 0);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_UN_SHOW)) {
                                    a a4 = c.this.a(bundle);
                                    if (a4 != null) {
                                        b.a(context, a4.f9652c, a4.f9650a, a4.f9651b, a4.f9653d, 2);
                                    }
                                } else if (!str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW) && str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN) && bundle != null) {
                                    c.this.a(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue(), bundle.getString(JThirdPlatFormInterface.KEY_TOKEN));
                                }
                            }
                        } catch (Throwable th) {
                            Logger.ww("ThirdPushManager", "doAction failed internal:" + th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    public void b(Context context) {
        if (cn.jpush.android.bc.b.a()) {
            a(context);
            if (cn.jpush.android.cache.a.e(context.getApplicationContext())) {
                Logger.d("ThirdPushManager", "push has close");
                return;
            }
            Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().register(context);
                } catch (Throwable th) {
                    Logger.ww("ThirdPushManager", "Third push register failed#", th);
                }
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        if (!cn.jpush.android.bc.b.a()) {
            Logger.dd("ThirdPushManager", "[refreshToken] third disabled");
            return;
        }
        a(context);
        byte byteValue = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        if (byteValue <= 0) {
            Logger.w("ThirdPushManager", "refreshToken romtype is <= 0");
            return;
        }
        Logger.dd("ThirdPushManager", "[refreshToken] romType: " + ((int) byteValue));
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f9640a) {
            if (jThirdPlatFormInterface.getRomType(context) == byteValue) {
                String token = jThirdPlatFormInterface.getToken(context);
                if (TextUtils.isEmpty(token)) {
                    jThirdPlatFormInterface.register(context);
                } else {
                    a(context, byteValue, token);
                }
            }
        }
    }

    public void c(Context context) {
        if (cn.jpush.android.bc.b.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
            while (it.hasNext()) {
                it.next().resumePush(context);
            }
        }
    }

    public void d(Context context) {
        if (cn.jpush.android.bc.b.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
            while (it.hasNext()) {
                it.next().stopPush(context);
            }
        }
    }

    public byte e(Context context) {
        int i2;
        byte b2 = 0;
        if (!cn.jpush.android.bc.b.a()) {
            return (byte) 0;
        }
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f9640a) {
            byte romType = jThirdPlatFormInterface.getRomType(context);
            b2 = (byte) (b2 | romType);
            byte b3 = romType;
            String str = (String) Sp.get(context, Key.ThirdPush_RegID(b3));
            boolean booleanValue = ((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b3))).booleanValue();
            if (jThirdPlatFormInterface.getRomType(context) == 8) {
                b2 = (byte) (b2 | 8);
                if (booleanValue && !TextUtils.isEmpty(str)) {
                    i2 = b2 | 32;
                    b2 = (byte) i2;
                }
            } else {
                if (jThirdPlatFormInterface.getRomType(context) == 2) {
                    b2 = (byte) (b2 | 64);
                }
                if (!booleanValue || TextUtils.isEmpty(str)) {
                    i2 = b2 | 128;
                    b2 = (byte) i2;
                }
            }
        }
        Logger.d("ThirdPushManager", "getRomType,romType:" + ((int) b2));
        return b2;
    }

    public String f(Context context) {
        if (!cn.jpush.android.bc.b.a()) {
            return null;
        }
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f9640a) {
            if (jThirdPlatFormInterface.getRomType(context) != 8) {
                return (String) Sp.get(context, Key.ThirdPush_RegID(jThirdPlatFormInterface.getRomType(context)));
            }
        }
        return null;
    }

    public void g(Context context) {
        try {
            if (this.f9640a != null && !this.f9640a.isEmpty()) {
                Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
                while (it.hasNext()) {
                    c(context, it.next().getRomType(context), null);
                }
                return;
            }
            if (f9637b != null) {
                for (Byte b2 : f9637b.values()) {
                    Sp.set(context, Key.ThirdPush_RegUpload(b2.byteValue()).set(false));
                    Sp.set(context, Key.ThirdPush_RegID(b2.byteValue()).set(null));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void h(Context context) {
        if (cn.jpush.android.bc.b.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            a(context);
            Logger.ii("ThirdPushManager", "uploadRegIdAfterLogin");
            Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
            while (it.hasNext()) {
                a(context, it.next(), JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
            }
        }
    }

    public void i(Context context) {
        Logger.dd("ThirdPushManager", "reRegisterInPushReceiver");
        a(context);
        Iterator<JThirdPlatFormInterface> it = this.f9640a.iterator();
        while (it.hasNext()) {
            a(context, it.next(), JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
        }
    }
}
