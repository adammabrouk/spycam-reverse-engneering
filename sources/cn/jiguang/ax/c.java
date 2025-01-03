package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;
import com.google.zxing.decoding.InactivityTimer;
import com.shix.shixipc.he.Constant;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r27, cn.jiguang.bc.a r28) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ax.c.a(android.content.Context, cn.jiguang.bc.a):int");
    }

    public static void a(Context context) {
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.L().a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.M().a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.d(false).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.d(true).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.Q().a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.N().a((cn.jiguang.f.a<Boolean>) null), cn.jiguang.f.a.O().a((cn.jiguang.f.a<Long>) null), cn.jiguang.f.a.b(true).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.b(false).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.c(true).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.c(false).a((cn.jiguang.f.a<String>) null)});
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.c().a((cn.jiguang.f.a<Long>) null), cn.jiguang.f.a.d().a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.f().a((cn.jiguang.f.a<String>) null)});
    }

    public static void a(Context context, int i2) {
        a(context, i2, true);
    }

    public static void a(Context context, int i2, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        if (z) {
            String a2 = cn.jiguang.be.c.a(i2);
            cn.jiguang.as.d.j("ConnectingHelper", "Register Failed with server error - code:" + i2);
            if (!TextUtils.isEmpty(a2)) {
                cn.jiguang.as.d.h("ConnectingHelper", "Local error description: " + a2);
            }
            cn.jiguang.az.b.a().a(context, 0, i2, a2);
        }
        String e2 = cn.jiguang.d.a.e(context);
        if (i2 != 11) {
            if (i2 == 1012) {
                a(context);
                return;
            }
            if (i2 != 10001) {
                switch (i2) {
                    case 1005:
                        sb = new StringBuilder();
                        sb.append("包名: ");
                        sb.append(context.getPackageName());
                        sb.append(" 与 AppKey:");
                        sb.append(e2);
                        str2 = "不匹配";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1006:
                        sb = new StringBuilder();
                        sb.append("包名: ");
                        sb.append(context.getPackageName());
                        str2 = " 不存在";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1007:
                        str3 = "IMEI is duplicated reported by server. Give up now. ";
                        cn.jiguang.as.d.e("ConnectingHelper", str3);
                        break;
                    case 1008:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e2);
                        str2 = " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1009:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e2);
                        str2 = " 非android AppKey";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    default:
                        str3 = "Unhandled server response error code - " + i2;
                        cn.jiguang.as.d.e("ConnectingHelper", str3);
                        break;
                }
                return;
            }
            str = " 未在manifest中配置AppKey";
            cn.jiguang.e.a.a(context, str, -1);
        }
    }

    public static void a(Context context, long j) {
    }

    public static synchronized byte[] a(String str, int i2, byte[] bArr, boolean z, int i3) {
        byte[] b2;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.be.b bVar = new cn.jiguang.be.b(InactivityTimer.INACTIVITY_DELAY_SECONDS);
            bVar.b(0);
            bVar.a(str.getBytes());
            bVar.a(i2);
            bVar.b(i3);
            bVar.a(bArr);
            bVar.b(bVar.a(), 0);
            bVar.a((int) ((byte) ((z ? (byte) 1 : (byte) 0) | 16)), 4);
            b2 = bVar.b();
        }
        return b2;
    }

    public static byte[] a(String str, String str2) {
        boolean z;
        byte[] a2;
        byte[] i2 = cn.jiguang.e.f.i(str2);
        try {
            a2 = cn.jiguang.e.h.a(i2);
        } catch (IOException unused) {
        }
        if (a2.length < i2.length) {
            i2 = a2;
            z = true;
            int length = i2.length;
            int a3 = cn.jiguang.bk.e.a();
            String a4 = cn.jiguang.bk.e.a(a3);
            return a(str, a3, cn.jiguang.bk.e.a(i2, a4, a4.substring(0, 16), true), z, length);
        }
        z = false;
        int length2 = i2.length;
        int a32 = cn.jiguang.bk.e.a();
        String a42 = cn.jiguang.bk.e.a(a32);
        return a(str, a32, cn.jiguang.bk.e.a(i2, a42, a42.substring(0, 16), true), z, length2);
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.as.d.d("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new cn.jiguang.az.f(4, "response is empty!");
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.getShort();
            wrap.getShort();
            int i2 = wrap.getInt();
            int i3 = i2 >>> 24;
            long j = i2 & Constant.PPPP_STATUS_UNKNOWN;
            wrap.getShort();
            int remaining = wrap.remaining();
            byte[] bArr2 = new byte[remaining];
            wrap.get(bArr2, 0, remaining);
            if (j != 0) {
                String a2 = cn.jiguang.bk.e.a(j);
                try {
                    bArr2 = cn.jiguang.bk.e.a(bArr2, a2, a2.substring(0, 16), false);
                    if (bArr2 == null) {
                        throw new cn.jiguang.az.f(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new cn.jiguang.az.f(5, "decrypt response error");
                }
            }
            if ((i3 & 1) != 1) {
                return bArr2;
            }
            try {
                return cn.jiguang.e.h.b(bArr2);
            } catch (IOException unused2) {
                return bArr2;
            }
        } catch (Throwable th) {
            throw new cn.jiguang.az.f(4, "parse head error:" + th.getMessage());
        }
    }

    public static int b(Context context, cn.jiguang.bc.a aVar) {
        Object obj;
        Object obj2;
        String d2 = d(context);
        String str = cn.jiguang.be.a.a(context).f8679a;
        String e2 = e(context);
        String f2 = f(context);
        long b2 = cn.jiguang.az.b.a().b();
        String d3 = cn.jiguang.d.a.d(context);
        cn.jiguang.as.d.c("ConnectingHelper", "Register with: key:" + d2 + ", apkVersion:" + str + ", clientInfo:" + e2 + ", extKey:" + f2 + ",reg business:" + b2 + " accountId:" + d3);
        byte[] a2 = cn.jiguang.bb.b.a(context, cn.jiguang.bb.b.a(c(context), d2, str, e2, f2, b2, d3));
        if (a2 == null) {
            cn.jiguang.as.d.h("ConnectingHelper", "Register failed - encrytor reg info failed");
            return -1;
        }
        if (aVar.a(a2) != 0) {
            cn.jiguang.as.d.h("ConnectingHelper", "Register failed - send reg info failed");
            return -1;
        }
        try {
            Pair<cn.jiguang.bb.c, ByteBuffer> a3 = cn.jiguang.bb.a.a(context, aVar.a(20000).array(), "");
            if (a3 == null || (obj = a3.first) == null || (obj2 = a3.second) == null || ((cn.jiguang.bb.c) obj).f8637c != 0) {
                cn.jiguang.as.d.h("ConnectingHelper", "Register failed - can't parse a Register Response");
                return -1;
            }
            cn.jiguang.bb.e eVar = new cn.jiguang.bb.e((cn.jiguang.bb.c) obj, (ByteBuffer) obj2);
            cn.jiguang.as.d.c("ConnectingHelper", "register response:" + eVar);
            int i2 = eVar.f8652a;
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.D().a((cn.jiguang.f.a<Integer>) Integer.valueOf(i2))});
            if (i2 == 0) {
                long j = eVar.f8653b;
                String str2 = eVar.f8654c;
                String str3 = eVar.f8655d;
                String str4 = eVar.f8656e;
                cn.jiguang.as.d.f("ConnectingHelper", "Register succeed - juid:" + j + ", registrationId:" + str3 + ", deviceId:" + str4);
                if (cn.jiguang.e.f.a(str3) || 0 == j) {
                    cn.jiguang.as.d.j("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                    return -1;
                }
                cn.jiguang.av.b.a(context, str4);
                cn.jiguang.av.b.a(context, j, str2, str3);
                cn.jiguang.ap.e.b(context, j, str3);
            }
            return i2;
        } catch (cn.jiguang.az.f e3) {
            cn.jiguang.as.d.h("ConnectingHelper", "Register failed - recv msg failed with error:" + e3);
            return -1;
        }
    }

    public static String b(String str, String str2) {
        return !cn.jiguang.e.f.a(str) ? str : str2;
    }

    public static void b(Context context) {
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.c(true).a((cn.jiguang.f.a<String>) null), cn.jiguang.f.a.c(false).a((cn.jiguang.f.a<String>) null)});
    }

    public static synchronized long c(Context context) {
        long j;
        synchronized (c.class) {
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.J())).longValue();
            if (longValue == -1) {
                longValue = Math.abs(new Random().nextInt(10000));
            }
            j = (longValue + (longValue % 2 == 0 ? 1L : 2L)) % 10000;
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.J().a((cn.jiguang.f.a<Long>) Long.valueOf(j))});
        }
        return j;
    }

    public static String d(Context context) {
        return b(cn.jiguang.be.d.a(context), LogUtils.PLACEHOLDER) + "$$" + b(cn.jiguang.be.a.a(context).o, LogUtils.PLACEHOLDER) + "$$" + context.getPackageName() + "$$" + cn.jiguang.d.a.e(context);
    }

    public static String e(Context context) {
        String e2 = cn.jiguang.az.b.a().e();
        cn.jiguang.as.d.c("ConnectingHelper", "regVersion:" + e2);
        cn.jiguang.be.a a2 = cn.jiguang.be.a.a(context);
        return b(a2.f8680b, LogUtils.PLACEHOLDER) + "$$" + b(a2.f8681c, LogUtils.PLACEHOLDER) + "$$" + b(a2.f8682d, LogUtils.PLACEHOLDER) + "$$" + b(a2.f8683e, LogUtils.PLACEHOLDER) + "$$" + b(cn.jiguang.d.a.g(context), LogUtils.PLACEHOLDER) + "$$" + e2 + "$$" + a2.f8685g + "$$" + a2.f8686h + "$$" + a2.l + "$$" + a2.q + "&" + a2.r;
    }

    public static String f(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            String str6 = cn.jiguang.be.a.a(context).j;
            if ("unknown".equalsIgnoreCase(str6)) {
                str6 = LogUtils.PLACEHOLDER;
            }
            String a2 = cn.jiguang.bk.c.a(context);
            int i2 = cn.jiguang.bk.c.f8827a;
            String str7 = cn.jiguang.be.a.a(context).p;
            String str8 = cn.jiguang.be.a.a(context).f8687i;
            String g2 = cn.jiguang.d.a.l(context) ? cn.jiguang.e.a.g(context, "") : "";
            Object a3 = cn.jiguang.az.e.a(context, "get_all_ids", null);
            if (a3 == null || !(a3 instanceof JSONObject)) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                cn.jiguang.as.d.c("ConnectingHelper", "parse ids:" + a3.toString());
                str2 = ((JSONObject) a3).optString("udid", "");
                str3 = ((JSONObject) a3).optString("joad", "");
                str4 = ((JSONObject) a3).optString("jvad", "");
                str5 = ((JSONObject) a3).optString("jaad", "");
                str = ((JSONObject) a3).optString("jgad", "");
            }
            return i2 + "$$" + b(a2, LogUtils.PLACEHOLDER) + "$$" + b(str7, LogUtils.PLACEHOLDER) + "$$" + b(str8, LogUtils.PLACEHOLDER) + "$$" + b(g2, LogUtils.PLACEHOLDER) + "$$" + b(str6, LogUtils.PLACEHOLDER) + "$$" + b(str2, LogUtils.PLACEHOLDER) + "$$" + b(str3, LogUtils.PLACEHOLDER) + "$$" + b(str4, LogUtils.PLACEHOLDER) + "$$" + b(str5, LogUtils.PLACEHOLDER) + "$$" + b(str, LogUtils.PLACEHOLDER);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(Context context) {
        String str = JConstants.testCountry;
        return !TextUtils.isEmpty(str) ? str : cn.jiguang.e.a.n(context);
    }
}
