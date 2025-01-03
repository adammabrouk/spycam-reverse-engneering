package cn.jiguang.p;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static long f9025a;

    static {
        cn.jiguang.l.d.a("JCommon");
        cn.jiguang.l.d.a("JLocation");
        cn.jiguang.l.d.a("JArp");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0273 A[Catch: all -> 0x028b, TryCatch #0 {all -> 0x028b, blocks: (B:4:0x000b, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:13:0x0025, B:14:0x0029, B:15:0x0034, B:21:0x00c5, B:22:0x00ca, B:24:0x00d2, B:25:0x00e1, B:27:0x00ed, B:30:0x00f3, B:32:0x00fd, B:34:0x010f, B:36:0x0120, B:39:0x012a, B:41:0x012f, B:43:0x0134, B:45:0x0145, B:47:0x0151, B:50:0x015b, B:51:0x016c, B:53:0x0170, B:55:0x0177, B:56:0x017b, B:61:0x01e1, B:62:0x01ea, B:64:0x01f6, B:65:0x0201, B:66:0x020a, B:69:0x021e, B:72:0x0227, B:73:0x022b, B:74:0x022f, B:75:0x0248, B:77:0x0252, B:78:0x017f, B:81:0x0189, B:84:0x0194, B:87:0x019e, B:90:0x01a7, B:93:0x01b1, B:96:0x01bb, B:99:0x01c5, B:102:0x01cf, B:105:0x026f, B:107:0x0273, B:109:0x027a, B:112:0x0284, B:116:0x0039, B:119:0x0045, B:122:0x0051, B:125:0x005b, B:128:0x0065, B:131:0x006f, B:134:0x007a, B:137:0x0084, B:140:0x008e, B:143:0x0098, B:146:0x00a2, B:149:0x00ac), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027a A[Catch: all -> 0x028b, TryCatch #0 {all -> 0x028b, blocks: (B:4:0x000b, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:13:0x0025, B:14:0x0029, B:15:0x0034, B:21:0x00c5, B:22:0x00ca, B:24:0x00d2, B:25:0x00e1, B:27:0x00ed, B:30:0x00f3, B:32:0x00fd, B:34:0x010f, B:36:0x0120, B:39:0x012a, B:41:0x012f, B:43:0x0134, B:45:0x0145, B:47:0x0151, B:50:0x015b, B:51:0x016c, B:53:0x0170, B:55:0x0177, B:56:0x017b, B:61:0x01e1, B:62:0x01ea, B:64:0x01f6, B:65:0x0201, B:66:0x020a, B:69:0x021e, B:72:0x0227, B:73:0x022b, B:74:0x022f, B:75:0x0248, B:77:0x0252, B:78:0x017f, B:81:0x0189, B:84:0x0194, B:87:0x019e, B:90:0x01a7, B:93:0x01b1, B:96:0x01bb, B:99:0x01c5, B:102:0x01cf, B:105:0x026f, B:107:0x0273, B:109:0x027a, B:112:0x0284, B:116:0x0039, B:119:0x0045, B:122:0x0051, B:125:0x005b, B:128:0x0065, B:131:0x006f, B:134:0x007a, B:137:0x0084, B:140:0x008e, B:143:0x0098, B:146:0x00a2, B:149:0x00ac), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0170 A[Catch: all -> 0x028b, TryCatch #0 {all -> 0x028b, blocks: (B:4:0x000b, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:13:0x0025, B:14:0x0029, B:15:0x0034, B:21:0x00c5, B:22:0x00ca, B:24:0x00d2, B:25:0x00e1, B:27:0x00ed, B:30:0x00f3, B:32:0x00fd, B:34:0x010f, B:36:0x0120, B:39:0x012a, B:41:0x012f, B:43:0x0134, B:45:0x0145, B:47:0x0151, B:50:0x015b, B:51:0x016c, B:53:0x0170, B:55:0x0177, B:56:0x017b, B:61:0x01e1, B:62:0x01ea, B:64:0x01f6, B:65:0x0201, B:66:0x020a, B:69:0x021e, B:72:0x0227, B:73:0x022b, B:74:0x022f, B:75:0x0248, B:77:0x0252, B:78:0x017f, B:81:0x0189, B:84:0x0194, B:87:0x019e, B:90:0x01a7, B:93:0x01b1, B:96:0x01bb, B:99:0x01c5, B:102:0x01cf, B:105:0x026f, B:107:0x0273, B:109:0x027a, B:112:0x0284, B:116:0x0039, B:119:0x0045, B:122:0x0051, B:125:0x005b, B:128:0x0065, B:131:0x006f, B:134:0x007a, B:137:0x0084, B:140:0x008e, B:143:0x0098, B:146:0x00a2, B:149:0x00ac), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0177 A[Catch: all -> 0x028b, TryCatch #0 {all -> 0x028b, blocks: (B:4:0x000b, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:13:0x0025, B:14:0x0029, B:15:0x0034, B:21:0x00c5, B:22:0x00ca, B:24:0x00d2, B:25:0x00e1, B:27:0x00ed, B:30:0x00f3, B:32:0x00fd, B:34:0x010f, B:36:0x0120, B:39:0x012a, B:41:0x012f, B:43:0x0134, B:45:0x0145, B:47:0x0151, B:50:0x015b, B:51:0x016c, B:53:0x0170, B:55:0x0177, B:56:0x017b, B:61:0x01e1, B:62:0x01ea, B:64:0x01f6, B:65:0x0201, B:66:0x020a, B:69:0x021e, B:72:0x0227, B:73:0x022b, B:74:0x022f, B:75:0x0248, B:77:0x0252, B:78:0x017f, B:81:0x0189, B:84:0x0194, B:87:0x019e, B:90:0x01a7, B:93:0x01b1, B:96:0x01bb, B:99:0x01c5, B:102:0x01cf, B:105:0x026f, B:107:0x0273, B:109:0x027a, B:112:0x0284, B:116:0x0039, B:119:0x0045, B:122:0x0051, B:125:0x005b, B:128:0x0065, B:131:0x006f, B:134:0x007a, B:137:0x0084, B:140:0x008e, B:143:0x0098, B:146:0x00a2, B:149:0x00ac), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(final android.content.Context r17, java.lang.String r18, final java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.p.b.a(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f9025a = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            cn.jiguang.ai.a.a("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("JCommonActionHelper", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }

    public static void a(Context context, int i2) {
        long a2 = d.a();
        String a3 = cn.jiguang.o.a.a(context, i2);
        byte[] a4 = d.a(f9025a, a3);
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 25);
        bundle.putInt("ver", 1);
        bundle.putLong("rid", a2);
        bundle.putLong("timeout", 0L);
        bundle.putByteArray("body", a4);
        if (!TextUtils.isEmpty(a3)) {
            cn.jiguang.ai.a.a("JCommonActionHelper", "tcp report deviceInfo:" + a3);
        }
        cn.jiguang.l.d.a(context, bundle);
    }

    public static void a(Context context, Bundle bundle) {
        cn.jiguang.l.a a2;
        JSONObject a3 = a(bundle);
        if (a3 == null) {
            return;
        }
        int optInt = a3.optInt("cmd");
        a(context, optInt);
        if (optInt == 5 || optInt == 45) {
            if (!cn.jiguang.h.a.a().a(1500) || !cn.jiguang.d.a.l(context)) {
                return;
            } else {
                a2 = cn.jiguang.af.a.a();
            }
        } else {
            if (optInt == 50) {
                cn.jiguang.al.b.a(context, a3);
                return;
            }
            if (optInt != 52) {
                if (optInt == 70) {
                    cn.jiguang.al.a.a(context);
                    return;
                }
                if (optInt != 82) {
                    return;
                }
                try {
                    JSONObject optJSONObject = a3.optJSONObject("content");
                    if (optJSONObject != null) {
                        int optInt2 = optJSONObject.optInt("log_enable");
                        int optInt3 = optJSONObject.optInt("log_print");
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.W().a((cn.jiguang.f.a<Integer>) Integer.valueOf(optInt2))});
                        JConstants.CMD_TO_PRINT_ALL_LOG = optInt3 == 1;
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.X().a((cn.jiguang.f.a<Integer>) Integer.valueOf(optInt3))});
                        int optInt4 = optJSONObject.optInt("expire");
                        if (optInt4 <= 0) {
                            optInt4 = 7;
                        }
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.Y().a((cn.jiguang.f.a<Long>) Long.valueOf(cn.jiguang.e.b.a(optInt4)))});
                        if (optInt2 == 1) {
                            cn.jiguang.a.a.f8103g = true;
                            int optInt5 = optJSONObject.optInt("delay_upload");
                            if (optInt5 <= 10) {
                                optInt5 = 10;
                            }
                            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.Z().a((cn.jiguang.f.a<Integer>) Integer.valueOf(optInt5))});
                        } else {
                            cn.jiguang.a.a.f8103g = false;
                            cn.jiguang.l.d.a("FUTURE_TASK", new cn.jiguang.l.e() { // from class: cn.jiguang.p.b.3
                                @Override // cn.jiguang.l.e
                                public void a() {
                                    cn.jiguang.as.c.a();
                                }
                            });
                        }
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (!cn.jiguang.h.a.a().a(1600)) {
                return;
            } else {
                a2 = cn.jiguang.i.b.a();
            }
        }
        a2.a(context, a3);
    }

    public static int b(Object obj) {
        return ((obj instanceof Bundle) && ((Bundle) obj).getBoolean("login")) ? 2 : 0;
    }

    public static void b(final Context context, final Object obj) {
        cn.jiguang.h.a a2 = cn.jiguang.h.a.a();
        if (a2.a(1600)) {
            cn.jiguang.i.b.a().a(context, a2.b(1600));
        }
        if (a2.a(1500) && cn.jiguang.d.a.l(context)) {
            cn.jiguang.af.a.a().a(context, a2.b(1500));
        }
        if (a2.a(1800)) {
            cn.jiguang.l.d.a(new cn.jiguang.l.e() { // from class: cn.jiguang.p.b.2
                @Override // cn.jiguang.l.e
                public void a() {
                    cn.jiguang.aj.a.a(context, b.b(obj));
                }
            }, a2.b(1800));
        }
        if (a2.a(1000)) {
            cn.jiguang.n.b.a().a(context, a2.b(1000));
        }
        if (a2.d(1200)) {
            cn.jiguang.n.c.a().a(context, a2.b(1200));
        }
        if (a2.d(1900)) {
            cn.jiguang.n.d.a().a(context, a2.b(1900));
        }
        cn.jiguang.al.a.a(context, "heartbeat");
        cn.jiguang.al.b.a(context, null);
        cn.jiguang.al.d.a().b(context);
    }
}
