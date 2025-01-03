package cn.jiguang.k;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.p.e;
import com.google.zxing.decoding.InactivityTimer;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: cn.jiguang.k.a$a, reason: collision with other inner class name */
    public static class C0140a {

        /* renamed from: a, reason: collision with root package name */
        public HandlerThread f8928a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f8929b;

        /* renamed from: c, reason: collision with root package name */
        public int f8930c;

        /* renamed from: d, reason: collision with root package name */
        public String f8931d;

        public C0140a(String str, int i2) {
            this.f8930c = i2;
            this.f8931d = str;
            HandlerThread handlerThread = new HandlerThread("jg_ptm_thread");
            this.f8928a = handlerThread;
            handlerThread.start();
            this.f8929b = new Handler(this.f8928a.getLooper(), new Handler.Callback() { // from class: cn.jiguang.k.a.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Thread thread;
                    if (message == null || message.what != 1 || (thread = (Thread) message.obj) == null) {
                        return false;
                    }
                    thread.interrupt();
                    return false;
                }
            });
        }

        private void b(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
            Thread currentThread = Thread.currentThread();
            while (i2 < i3) {
                bArr2[3] = (byte) i2;
                if (bArr2[3] != bArr[3]) {
                    String b2 = a.b(bArr2);
                    if (!b2.equalsIgnoreCase(this.f8931d)) {
                        this.f8929b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.f8929b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString("ip", b2);
                        obtainMessage.setData(bundle);
                        this.f8929b.sendMessageDelayed(obtainMessage, this.f8930c);
                        e.a(new String[]{"ping -c 1 -w 1 " + b2}, 0);
                    }
                }
                i2++;
            }
        }

        public void a(byte[] bArr, int i2, int i3) {
            b(bArr, i2, i3);
            this.f8928a.quit();
        }
    }

    public static String a(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2 & ViewfinderView.OPAQUE);
        stringBuffer.append('.');
        stringBuffer.append((i2 >> 8) & ViewfinderView.OPAQUE);
        stringBuffer.append('.');
        stringBuffer.append((i2 >> 16) & ViewfinderView.OPAQUE);
        stringBuffer.append('.');
        stringBuffer.append((i2 >> 24) & ViewfinderView.OPAQUE);
        return stringBuffer.toString();
    }

    public static List<cn.jiguang.j.a> a(String str) {
        cn.jiguang.j.a b2;
        List<String> a2 = e.a(new String[]{"cat /proc/net/arp"}, 1);
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.ai.a.d("JArpHelper", "execute command failed");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : a2) {
            if (!TextUtils.isEmpty(str2) && (b2 = b(str2)) != null && b2.f8926c.equals("0x2") && !str.equals(b2.f8924a) && !b2.f8927d.equals("00:00:00:00:00:00")) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public static void a(String str, byte[] bArr) {
        new C0140a(str, InactivityTimer.INACTIVITY_DELAY_SECONDS).a(bArr, 0, ViewfinderView.OPAQUE);
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }

    public static cn.jiguang.j.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        cn.jiguang.j.a aVar = new cn.jiguang.j.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= bytes.length - 1) {
                break;
            }
            i2++;
            if (bytes[i2] == 32) {
                int i5 = i2 - i3;
                if (i5 > 1) {
                    String str2 = new String(bytes, i3, i5);
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 == 3) {
                                    aVar.f8927d = str2;
                                    break;
                                }
                            } else {
                                aVar.f8926c = str2;
                            }
                        } else {
                            aVar.f8925b = str2;
                        }
                    } else {
                        aVar.f8924a = str2;
                    }
                    i4++;
                }
                i3 = i2 + 1;
            }
        }
        return aVar;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & ThreadUtils.TYPE_SINGLE);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & ThreadUtils.TYPE_SINGLE);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & ThreadUtils.TYPE_SINGLE);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & ThreadUtils.TYPE_SINGLE);
        return stringBuffer.toString();
    }
}
