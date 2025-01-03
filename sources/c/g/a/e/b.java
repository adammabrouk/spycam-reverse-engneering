package c.g.a.e;

import android.annotation.TargetApi;
import com.hjq.permissions.Permission;
import f.e;
import f.i.o;
import f.i.q;
import java.util.Map;
import java.util.Set;

/* compiled from: PermissionMap.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f6362a = q.a((Object[]) new String[]{Permission.ACCESS_BACKGROUND_LOCATION, Permission.SYSTEM_ALERT_WINDOW, Permission.WRITE_SETTINGS, Permission.MANAGE_EXTERNAL_STORAGE, Permission.REQUEST_INSTALL_PACKAGES});

    /* renamed from: b, reason: collision with root package name */
    @TargetApi(29)
    public static final Map<String, String> f6363b;

    /* renamed from: c, reason: collision with root package name */
    @TargetApi(30)
    public static final Map<String, String> f6364c;

    /* renamed from: d, reason: collision with root package name */
    @TargetApi(31)
    public static final Map<String, String> f6365d;

    static {
        Map<String, String> a2 = o.a(e.a(Permission.READ_CALENDAR, "android.permission-group.CALENDAR"), e.a(Permission.WRITE_CALENDAR, "android.permission-group.CALENDAR"), e.a(Permission.READ_CALL_LOG, "android.permission-group.CALL_LOG"), e.a(Permission.WRITE_CALL_LOG, "android.permission-group.CALL_LOG"), e.a(Permission.PROCESS_OUTGOING_CALLS, "android.permission-group.CALL_LOG"), e.a(Permission.CAMERA, "android.permission-group.CAMERA"), e.a(Permission.READ_CONTACTS, "android.permission-group.CONTACTS"), e.a(Permission.WRITE_CONTACTS, "android.permission-group.CONTACTS"), e.a(Permission.GET_ACCOUNTS, "android.permission-group.CONTACTS"), e.a(Permission.ACCESS_FINE_LOCATION, "android.permission-group.LOCATION"), e.a(Permission.ACCESS_COARSE_LOCATION, "android.permission-group.LOCATION"), e.a(Permission.ACCESS_BACKGROUND_LOCATION, "android.permission-group.LOCATION"), e.a(Permission.RECORD_AUDIO, "android.permission-group.MICROPHONE"), e.a(Permission.READ_PHONE_STATE, "android.permission-group.PHONE"), e.a(Permission.READ_PHONE_NUMBERS, "android.permission-group.PHONE"), e.a(Permission.CALL_PHONE, "android.permission-group.PHONE"), e.a(Permission.ANSWER_PHONE_CALLS, "android.permission-group.PHONE"), e.a(Permission.ADD_VOICEMAIL, "android.permission-group.PHONE"), e.a(Permission.USE_SIP, "android.permission-group.PHONE"), e.a(Permission.ACCEPT_HANDOVER, "android.permission-group.PHONE"), e.a(Permission.BODY_SENSORS, "android.permission-group.SENSORS"), e.a(Permission.ACTIVITY_RECOGNITION, "android.permission-group.ACTIVITY_RECOGNITION"), e.a(Permission.SEND_SMS, "android.permission-group.SMS"), e.a(Permission.RECEIVE_SMS, "android.permission-group.SMS"), e.a(Permission.READ_SMS, "android.permission-group.SMS"), e.a(Permission.RECEIVE_WAP_PUSH, "android.permission-group.SMS"), e.a(Permission.RECEIVE_MMS, "android.permission-group.SMS"), e.a(Permission.READ_EXTERNAL_STORAGE, "android.permission-group.STORAGE"), e.a(Permission.WRITE_EXTERNAL_STORAGE, "android.permission-group.STORAGE"), e.a(Permission.ACCESS_MEDIA_LOCATION, "android.permission-group.STORAGE"));
        f6363b = a2;
        f6364c = a2;
        Map c2 = o.c(o.a(e.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), e.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), e.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")));
        c2.putAll(c());
        f6365d = o.b(c2);
    }

    public static final Set<String> a() {
        return f6362a;
    }

    public static final Map<String, String> b() {
        return f6363b;
    }

    public static final Map<String, String> c() {
        return f6364c;
    }

    public static final Map<String, String> d() {
        return f6365d;
    }
}
