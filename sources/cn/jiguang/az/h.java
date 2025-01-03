package cn.jiguang.az;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.union.ads.api.JUnionAdError;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.tencent.bugly.CrashModule;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: i, reason: collision with root package name */
    public static volatile h f8571i;
    public static final Object j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public cn.jiguang.ax.h f8572a;

    /* renamed from: b, reason: collision with root package name */
    public int f8573b;

    /* renamed from: c, reason: collision with root package name */
    public int f8574c;

    /* renamed from: f, reason: collision with root package name */
    public long f8577f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8578g;
    public Context k;

    /* renamed from: d, reason: collision with root package name */
    public int f8575d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f8576e = 0;
    public boolean l = false;
    public final AtomicBoolean m = new AtomicBoolean(false);
    public cn.jiguang.bd.a n = new cn.jiguang.bd.a() { // from class: cn.jiguang.az.h.1
        @Override // cn.jiguang.bd.a
        public void a(Message message) {
            h hVar;
            Context context;
            String str;
            Bundle bundle;
            boolean z;
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1011) {
                    hVar = h.this;
                    context = hVar.k;
                    str = "tcp_a14";
                } else {
                    if (i2 != 1022) {
                        if (i2 == 2000) {
                            k.a().a(h.this.k);
                            return;
                        }
                        switch (i2) {
                            case CrashModule.MODULE_ID /* 1004 */:
                                bundle = new Bundle();
                                z = true;
                                bundle.putBoolean("force", z);
                                h hVar2 = h.this;
                                hVar2.a(hVar2.k, "tcp_a16", bundle);
                                break;
                            case 1005:
                                bundle = new Bundle();
                                z = false;
                                bundle.putBoolean("force", z);
                                h hVar22 = h.this;
                                hVar22.a(hVar22.k, "tcp_a16", bundle);
                                break;
                            case 1006:
                            case 1007:
                                hVar = h.this;
                                context = hVar.k;
                                str = "tcp_a2";
                                break;
                        }
                    }
                    hVar = h.this;
                    context = hVar.k;
                    str = "tcp_a17";
                }
                hVar.a(context, str, null);
            }
        }
    };
    public boolean o = false;
    public int p = 0;
    public int q = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8579h = true;

    public class a extends cn.jiguang.bj.b {

        /* renamed from: b, reason: collision with root package name */
        public Context f8582b;

        /* renamed from: c, reason: collision with root package name */
        public String f8583c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f8584d;

        public a(Context context, String str, Bundle bundle) {
            this.f8582b = context;
            this.f8583c = str;
            this.f8584d = bundle;
            this.f8813h = "TcpManager";
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            h hVar;
            long j;
            try {
                if (!this.f8583c.equals("tcp_a1")) {
                    if (!this.f8583c.equals("tcp_a3") && !this.f8583c.equals("tcp_a4") && !this.f8583c.equals("tcp_a20")) {
                        if (this.f8583c.equals("tcp_a5")) {
                            if (this.f8584d != null) {
                                byte[] byteArray = this.f8584d.getByteArray("body");
                                int i2 = this.f8584d.getInt("cmd", -1);
                                int i3 = this.f8584d.getInt("ver", -1);
                                long j2 = this.f8584d.getLong("rid", -1L);
                                String string = this.f8584d.getString(ActionManager.SDK_TYPE);
                                long j3 = this.f8584d.getLong("timeout");
                                cn.jiguang.as.d.c("JCoreTCPManager", "send quest,cmd:" + i2 + ",ver:" + i3 + ",rid:" + j2 + ",body size:" + byteArray.length);
                                if (i2 >= 0 && i3 >= 0 && j2 >= 0 && !TextUtils.isEmpty(string)) {
                                    j.a().a(this.f8582b, j2, i2, i3, byteArray, string, j3);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (this.f8583c.equals("tcp_a19")) {
                            h.this.l();
                            return;
                        }
                        if (this.f8583c.equals("tcp_a11")) {
                            cn.jiguang.as.d.d("JCoreTCPManager", "resgiter success:" + cn.jiguang.d.a.b(this.f8582b));
                            cn.jiguang.e.a.h(this.f8582b);
                            b.a().a(this.f8582b, 0, 0, cn.jiguang.d.a.b(this.f8582b));
                            e.a(this.f8582b, "on_register", null);
                            return;
                        }
                        if (this.f8583c.equals("tcp_a10")) {
                            h.this.j();
                            return;
                        }
                        if (this.f8583c.equals("tcp_a9")) {
                            h.this.d(this.f8582b);
                            return;
                        }
                        if (this.f8583c.equals("tcp_a8")) {
                            h.this.b(this.f8582b);
                            return;
                        }
                        if (this.f8583c.equals("tcp_a2")) {
                            g.a().a(this.f8582b, false);
                            h.this.a(this.f8584d);
                            return;
                        }
                        if (this.f8583c.equals("tcp_a13")) {
                            cn.jiguang.as.d.d("JCoreTCPManager", "resgiter failed");
                            if (this.f8584d != null) {
                                int i4 = this.f8584d.getInt("resCode", 0);
                                h.this.f8574c = i4;
                                cn.jiguang.ax.c.a(this.f8582b, i4);
                                return;
                            }
                            return;
                        }
                        if (this.f8583c.equals("tcp_a12")) {
                            cn.jiguang.as.d.d("JCoreTCPManager", "login failed");
                            if (this.f8584d != null) {
                                h.this.a(this.f8584d.getInt("resCode", 0));
                                return;
                            }
                            return;
                        }
                        if (this.f8583c.equals("tcp_a14")) {
                            hVar = h.this;
                        } else {
                            if (this.f8583c.equals("tcp_a15")) {
                                h.this.b(this.f8584d);
                                return;
                            }
                            if (this.f8583c.equals("tcp_a16")) {
                                h.this.c(this.f8584d);
                                return;
                            }
                            if (this.f8583c.equals("tcp_a17")) {
                                h.this.q();
                                return;
                            }
                            if (this.f8583c.equals("tcp_a18")) {
                                h.this.s();
                                return;
                            }
                            if (this.f8583c.equals("tcp_a6")) {
                                if (this.f8584d != null) {
                                    long j4 = this.f8584d.getLong("rid", -1L);
                                    if (j4 > 0) {
                                        j.a().b(this.f8582b, j4);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (this.f8583c.equals("tcp_a7")) {
                                if (this.f8584d != null) {
                                    long j5 = this.f8584d.getLong("rid", -1L);
                                    if (j5 > 0) {
                                        j.a().a(this.f8582b, j5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (this.f8583c.equals("tcp_a21")) {
                                h.this.k();
                                return;
                            }
                            if (this.f8583c.equals("tcp_a22")) {
                                h.this.b();
                                return;
                            }
                            if (this.f8583c.equals("tcp_a23")) {
                                h.this.c(this.f8582b);
                                return;
                            } else {
                                if (!this.f8583c.equals("tcp_a24")) {
                                    return;
                                }
                                h.this.m();
                                h.this.f8574c = 0;
                                h.this.f8573b = 0;
                                hVar = h.this;
                            }
                        }
                    }
                    if (h.this.f8572a != null) {
                        if (h.this.f8572a.d() != null) {
                            byte[] byteArray2 = this.f8584d.getByteArray("body");
                            int i5 = this.f8584d.getInt("cmd", -1);
                            int i6 = this.f8584d.getInt("ver", -1);
                            long j6 = this.f8584d.getLong("rid", -1L);
                            String string2 = this.f8584d.getString(ActionManager.SDK_TYPE);
                            cn.jiguang.as.d.c("JCoreTCPManager", "send data,cmd:" + i5 + ",ver:" + i6 + ",rid:" + j6 + ",body size:" + byteArray2.length);
                            if (i5 >= 0 && i6 >= 0 && j6 >= 0) {
                                if (this.f8583c.equals("tcp_a3")) {
                                    j.a().a(this.f8582b, j6, i5, i6, byteArray2, string2);
                                    return;
                                }
                                if (this.f8583c.equals("tcp_a20")) {
                                    long j7 = this.f8584d.getLong("uid", 0L);
                                    if (j7 == 0) {
                                        cn.jiguang.as.d.g("JCoreTCPManager", "share response uid is 0");
                                        return;
                                    }
                                    j = j7;
                                } else {
                                    j = 0;
                                }
                                h.a().c().d().a(cn.jiguang.bb.b.a(this.f8582b, i5, i6, j6, byteArray2, j));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    cn.jiguang.as.d.c("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                    hVar = h.this;
                } else if (h.this.f8572a != null) {
                    return;
                } else {
                    hVar = h.this;
                }
                hVar.o();
            } catch (Throwable th) {
                cn.jiguang.as.d.h("JCoreTCPManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    public static h a() {
        if (f8571i == null) {
            synchronized (j) {
                if (f8571i == null) {
                    f8571i = new h();
                }
            }
        }
        return f8571i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f8573b = i2;
        if (i2 == 1012) {
            cn.jiguang.ax.c.a(this.k);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        cn.jiguang.as.d.c("JCoreTCPManager", "handleStop...");
        if (((Boolean) cn.jiguang.f.b.a(context, cn.jiguang.f.a.C())).booleanValue()) {
            cn.jiguang.as.d.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.as.d.c("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
        } else {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.C().a((cn.jiguang.f.a<Boolean>) true)});
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.as.d.c("JCoreTCPManager", "handleUnRegister...");
        if (!((Boolean) cn.jiguang.f.b.a(context, cn.jiguang.f.a.p())).booleanValue()) {
            cn.jiguang.as.d.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.as.d.c("JCoreTCPManager", "Action: handleUnRegister - can't stop tcp");
        } else {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.p().a((cn.jiguang.f.a<Boolean>) false)});
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        String str;
        if (this.m.get()) {
            str = "isBeating, skip this time";
        } else {
            if ((bundle != null ? bundle.getBoolean("force", false) : false) || !p()) {
                cn.jiguang.as.d.d("JCoreTCPManager", "Send heart beat");
                cn.jiguang.bd.b.a().b(1005);
                if (this.f8578g) {
                    r();
                    return;
                } else {
                    cn.jiguang.as.d.c("JCoreTCPManager", "socket is closed or push isn't login");
                    return;
                }
            }
            str = "No need to rtc, Because it have succeed recently";
        }
        cn.jiguang.as.d.c("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        String str;
        cn.jiguang.as.d.c("JCoreTCPManager", "handleResume...");
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.C().a((cn.jiguang.f.a<Boolean>) false)});
        if (this.f8578g) {
            str = "[handleResume] is loggedin";
        } else {
            if (this.f8572a == null) {
                o();
                return;
            }
            str = "[handleResume] tcp is connecting...";
        }
        cn.jiguang.as.d.c("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - onLoggedIn");
        if (!this.f8578g) {
            this.f8578g = true;
            b.a().a(this.k, 1, 0, JUnionAdError.Message.SUCCESS);
        }
        b();
        this.f8575d = 0;
        this.f8576e = 0;
        cn.jiguang.as.d.c("JCoreTCPManager", "Force to send 12s heartbeat after login");
        cn.jiguang.a.a.a(this.k, true, 12000L);
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", true);
        e.a(this.k, "periodtask", bundle);
        if (k()) {
            cn.jiguang.bd.b.a().b(RecyclerView.MAX_SCROLL_DURATION, 2000L, this.n);
            j.a().a(this.k);
            g.a().a(this.k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (cn.jiguang.ao.c.a().a(this.k) || k.a().b(this.k)) {
            return true;
        }
        cn.jiguang.as.d.c("JCoreTCPManager", "not keep tcp");
        this.f8579h = false;
        m();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - onDisconnected");
        if (this.f8578g) {
            this.f8578g = false;
            b.a().a(this.k, -1, -1, "push connect break");
        }
        if (this.f8572a == null && ((Boolean) cn.jiguang.f.b.a(this.k, cn.jiguang.f.a.C())).booleanValue()) {
            cn.jiguang.as.d.c("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        this.f8576e = 0;
        m();
        n();
        this.f8575d++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        cn.jiguang.ax.h hVar = this.f8572a;
        if (hVar == null) {
            cn.jiguang.as.d.c("JCoreTCPManager", "tcp has stopeed");
        } else {
            hVar.c();
            this.f8572a = null;
        }
    }

    private void n() {
        String str;
        String str2;
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.f8575d);
        if (!cn.jiguang.e.a.d(this.k.getApplicationContext())) {
            str2 = "[retryConnect] network is not connect";
        } else {
            if (this.f8574c <= 0) {
                int c2 = cn.jiguang.e.a.c(this.k.getApplicationContext());
                int pow = (int) (Math.pow(2.0d, this.f8575d) * 3.0d * 1000.0d);
                int f2 = f();
                int i2 = (f2 * 1000) / 2;
                if (pow > i2) {
                    pow = i2;
                }
                cn.jiguang.as.d.c("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.f8575d + ",chargedLever:" + c2 + ",heartbeatInterval:" + f2 + ",delayTime:" + pow);
                if (c2 != 1 ? this.f8575d >= 5 : this.f8575d >= 30) {
                    str = "Give up to retry connect.";
                } else {
                    if (!cn.jiguang.bd.b.a().a(1011)) {
                        cn.jiguang.bd.b.a().b(1011, pow, this.n);
                        return;
                    }
                    str = "Already has MSG_RESTART_CONN";
                }
                cn.jiguang.as.d.c("JCoreTCPManager", str);
                return;
            }
            str2 = "[retryConnect] registerErrCode >0,registerErrCode:" + this.f8574c;
        }
        cn.jiguang.as.d.c("JCoreTCPManager", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.f8579h) {
            cn.jiguang.as.d.f("JCoreTCPManager", "need not keep tcp,next start app will re login");
            return;
        }
        if (!cn.jiguang.e.a.d(this.k.getApplicationContext())) {
            cn.jiguang.as.d.f("JCoreTCPManager", "No network connection. Give up to start connection thread.");
            return;
        }
        if (((Boolean) cn.jiguang.f.b.a(this.k, cn.jiguang.f.a.C())).booleanValue()) {
            cn.jiguang.as.d.d("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
            return;
        }
        if (!((Boolean) cn.jiguang.f.b.a(this.k, cn.jiguang.f.a.p())).booleanValue()) {
            cn.jiguang.as.d.d("JCoreTCPManager", "[restartNetworkingClient] tcp has close by ups.unregister");
            return;
        }
        if (this.f8574c != 1005 && this.f8574c != 1006 && this.f8574c != 1008 && this.f8574c != 1009) {
            if (this.f8573b == 102) {
                cn.jiguang.as.d.h("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                return;
            } else {
                if (this.f8572a != null) {
                    cn.jiguang.as.d.d("JCoreTCPManager", "NetworkingClient is running");
                    return;
                }
                cn.jiguang.ax.h hVar = new cn.jiguang.ax.h(this.k.getApplicationContext());
                this.f8572a = hVar;
                hVar.b();
                return;
            }
        }
        cn.jiguang.as.d.c("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.f8574c);
        b.a().a(this.k, 2002, this.f8574c, "");
    }

    private boolean p() {
        int i2 = this.p;
        long currentTimeMillis = System.currentTimeMillis() - this.f8577f;
        return i2 > 0 ? currentTimeMillis < ((long) (this.p + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.m.set(false);
        this.f8576e++;
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + this.f8576e);
        cn.jiguang.as.d.b("JCoreTCPManager", "============================================================");
        if (this.f8572a != null && !this.f8578g) {
            cn.jiguang.as.d.d("JCoreTCPManager", "Is connecting now. Give up to retry.");
            return;
        }
        if (!this.f8578g || this.f8576e > 1) {
            m();
            n();
        } else {
            cn.jiguang.as.d.d("JCoreTCPManager", "Already logged in. Give up to retry.");
            cn.jiguang.bd.b.a().b(1005, 5000L, this.n);
        }
    }

    private void r() {
        this.m.set(true);
        cn.jiguang.bd.b.a().b(1022);
        Long valueOf = Long.valueOf(cn.jiguang.ax.c.c(this.k));
        long f2 = cn.jiguang.d.a.f(this.k);
        int i2 = cn.jiguang.av.b.f8400b;
        cn.jiguang.as.d.c("JCoreTCPManager", "heartbeat - juid:" + f2 + ", flag:1 ,userType:" + i2);
        byte[] a2 = cn.jiguang.bb.b.a(this.k, cn.jiguang.bb.b.a(valueOf.longValue(), JConstants.tcpSessionId, f2, (short) 1, i2));
        if (a2 != null) {
            this.f8572a.d().a(a2);
        } else {
            cn.jiguang.as.d.h("JCoreTCPManager", "send hb failed:sendData is null");
        }
        cn.jiguang.bd.b.a().b(1022, 10000L, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        cn.jiguang.as.d.d("JCoreTCPManager", "Action - onHeartbeatSucceed");
        b.a().a(this.k, 19, 0, "ack success");
    }

    public synchronized void a(Context context) {
        if (this.l) {
            return;
        }
        if (context == null) {
            cn.jiguang.as.d.c("JCoreTCPManager", "init context is null");
            return;
        }
        cn.jiguang.as.d.c("JCoreTCPManager", "init tcp manager...");
        this.k = context.getApplicationContext();
        cn.jiguang.av.b.a("JCoreTCPManager");
        cn.jiguang.bd.b.a().a(this.k);
        g.a().a(context, true);
        this.l = true;
    }

    public void a(Context context, String str, Bundle bundle) {
        a(context);
        cn.jiguang.av.b.c(new a(context, str, bundle), new int[0]);
    }

    public void a(Bundle bundle) {
        long j2;
        if (((Boolean) cn.jiguang.f.b.a(this.k, cn.jiguang.f.a.C())).booleanValue()) {
            cn.jiguang.as.d.d("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j2 = bundle.getLong("delay_time", 0L);
        } else {
            j2 = 0;
        }
        if (this.f8572a == null) {
            o();
            return;
        }
        if (j2 <= 0) {
            c(bundle);
        } else {
            int i2 = CrashModule.MODULE_ID;
            if (z) {
                cn.jiguang.bd.b.a().b(1005);
                cn.jiguang.bd.b.a().b(CrashModule.MODULE_ID);
            }
            cn.jiguang.bd.b a2 = cn.jiguang.bd.b.a();
            if (!z) {
                i2 = 1005;
            }
            a2.b(i2, j2, this.n);
        }
        cn.jiguang.as.d.e("JCoreTCPManager", "send rtc force=" + z + " delay=" + j2);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean optBoolean = jSONObject.optBoolean("use_ssp");
                this.o = optBoolean;
                if (optBoolean) {
                    int optInt = jSONObject.optInt("hb_interval");
                    if (optInt <= 0) {
                        cn.jiguang.as.d.g("JCoreTCPManager", "hb_interval is less than 0, will use 15s");
                        this.p = 15;
                    } else if (optInt >= JConstants.DEFAULT_HEARTBEAT_INTERVAL / 2) {
                        cn.jiguang.as.d.g("JCoreTCPManager", "hb_interval is more than " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + ", will use " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + "s");
                        this.p = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                        this.p = 0;
                    } else {
                        cn.jiguang.as.d.g("JCoreTCPManager", "set ssp heartbeat interval:" + optInt);
                        this.p = optInt;
                    }
                    if (this.p > 0) {
                        i();
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.g("JCoreTCPManager", "[TcpManager] handleCtrlHeartBeatCmd error:" + th);
            }
        }
    }

    public void b() {
        cn.jiguang.bd.b.a().b(1022);
        this.f8577f = System.currentTimeMillis();
        this.f8576e = 0;
        this.m.set(false);
        cn.jiguang.as.d.e("JCoreTCPManager", "update rtc state");
    }

    public void b(Bundle bundle) {
        if (((Boolean) cn.jiguang.f.b.a(this.k, cn.jiguang.f.a.C())).booleanValue()) {
            cn.jiguang.as.d.g("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        cn.jiguang.bd.b.a().b(1006);
        cn.jiguang.bd.b.a().b(1007);
        if (!bundle.getBoolean("connected", false)) {
            cn.jiguang.as.d.c("JCoreTCPManager", "Handle disconnected state.");
            cn.jiguang.bd.b.a().b(1007, NetworkUtils.SCAN_PERIOD_MILLIS, this.n);
            return;
        }
        cn.jiguang.as.d.c("JCoreTCPManager", "Handle connected state.");
        if (this.f8572a == null) {
            o();
        } else {
            cn.jiguang.bd.b.a().b(1006, NetworkUtils.SCAN_PERIOD_MILLIS, this.n);
        }
    }

    public cn.jiguang.ax.h c() {
        return this.f8572a;
    }

    public boolean d() {
        return this.f8578g;
    }

    public void e() {
        cn.jiguang.as.d.c("JCoreTCPManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 > 0) {
            int i3 = this.q;
            if (i3 == 0) {
                this.q = i2 * 2;
                return;
            }
            int i4 = i3 * 2;
            int i5 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            if (i4 < i5 / 2) {
                this.q = i3 * 2;
            } else {
                this.q = i5;
            }
        }
    }

    public int f() {
        cn.jiguang.as.d.c("JCoreTCPManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 <= 0) {
            return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        }
        int i3 = this.q;
        return i3 == 0 ? i2 : i3;
    }

    public int g() {
        cn.jiguang.as.d.c("JCoreTCPManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 <= 0) {
            return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        }
        int i3 = this.q;
        if (i3 == 0) {
            int i4 = i2 * 2;
            int i5 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            return i4 < i5 / 2 ? i2 * 2 : i5;
        }
        int i6 = i3 * 2;
        int i7 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        return i6 < i7 / 2 ? i3 * 2 : i7;
    }

    public int h() {
        cn.jiguang.as.d.c("JCoreTCPManager", "getAlarmDelay  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 <= 0) {
            return JConstants.DEFAULT_ALARM_DELAY;
        }
        int i3 = this.q;
        return i3 == 0 ? i2 + 5 : i3 + 5;
    }

    public void i() {
        this.q = 0;
        g.a().b();
    }
}
