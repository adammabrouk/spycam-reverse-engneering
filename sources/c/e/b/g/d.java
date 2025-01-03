package c.e.b.g;

import android.annotation.SuppressLint;
import android.os.Build;
import com.hjq.permissions.Permission;

/* compiled from: PermissionConstants.java */
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6307a = {Permission.READ_CALENDAR, Permission.WRITE_CALENDAR};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f6308b = {Permission.CAMERA};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6309c = {Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f6310d = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f6311e = {Permission.RECORD_AUDIO};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f6312f = {Permission.READ_PHONE_STATE, Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS, Permission.ANSWER_PHONE_CALLS};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f6313g = {Permission.READ_PHONE_STATE, Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f6314h = {Permission.BODY_SENSORS};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f6315i = {Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS};
    public static final String[] j = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String[] a(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return f6307a;
            case 1:
                return f6308b;
            case 2:
                return f6309c;
            case 3:
                return f6310d;
            case 4:
                return f6311e;
            case 5:
                return Build.VERSION.SDK_INT < 26 ? f6313g : f6312f;
            case 6:
                return f6314h;
            case 7:
                return f6315i;
            case '\b':
                return j;
            default:
                return new String[]{str};
        }
    }
}
