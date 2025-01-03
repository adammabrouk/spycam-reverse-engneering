package cn.jiguang.ax;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class h extends cn.jiguang.bj.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8426a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8427b;

    /* renamed from: c, reason: collision with root package name */
    public cn.jiguang.bc.a f8428c = new cn.jiguang.bc.b(8128, 20);

    static {
        cn.jiguang.av.b.a("NetworkingClient");
    }

    public h(Context context) {
        this.f8427b = context;
        this.f8813h = "NetworkingClient";
    }

    private void a(ByteBuffer byteBuffer) {
        cn.jiguang.av.b.b(new q(this.f8427b, byteBuffer.array()), new int[0]);
    }

    private boolean a(int i2) {
        if (this.f8426a) {
            return false;
        }
        if (i2 <= 0) {
            cn.jiguang.as.d.d("NetworkingClient", "login error,retry login too many times");
            g();
            f();
            return false;
        }
        cn.jiguang.as.d.c("NetworkingClient", "loginTimes:" + i2);
        if (!e()) {
            return false;
        }
        int a2 = c.a(this.f8427b, this.f8428c);
        if (a2 < 0) {
            f();
            return false;
        }
        if (a2 <= 0) {
            cn.jiguang.az.h.a().a(this.f8427b, "tcp_a10", null);
            return true;
        }
        g();
        if (a2 == 108) {
            cn.jiguang.av.b.a(this.f8427b);
            return a(i2 - 1);
        }
        b(a2);
        return false;
    }

    private boolean a(Context context) {
        String str;
        cn.jiguang.as.d.c("NetworkingClient", "google:true");
        cn.jiguang.be.a.a(context);
        try {
            this.f8428c = new j(k.a(context)).a(this);
        } catch (Exception e2) {
            f();
            str = "sis and connect failed:" + e2;
        }
        if (a(2)) {
            return true;
        }
        str = "login failed";
        cn.jiguang.as.d.g("NetworkingClient", str);
        return false;
    }

    private void b(int i2) {
        cn.jiguang.as.d.a("NetworkingClient", "Action - onLoginFailed - respCode:" + i2);
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", i2);
        cn.jiguang.az.h.a().a(this.f8427b, "tcp_a12", bundle);
    }

    private boolean e() {
        if (cn.jiguang.d.b.a(this.f8427b) && !TextUtils.isEmpty(cn.jiguang.d.a.i(this.f8427b))) {
            return true;
        }
        int b2 = c.b(this.f8427b, this.f8428c);
        if (b2 == 0) {
            cn.jiguang.az.h.a().a(this.f8427b, "tcp_a11", null);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", b2);
        cn.jiguang.az.h.a().a(this.f8427b, "tcp_a13", bundle);
        g();
        f();
        return false;
    }

    private void f() {
        cn.jiguang.as.d.d("NetworkingClient", "Action - closeConnection");
        cn.jiguang.e.h.a(this.f8428c);
        cn.jiguang.az.h.a().a(this.f8427b, "tcp_a19", null);
    }

    private void g() {
        c.b(this.f8427b);
    }

    @Override // cn.jiguang.bj.b
    public void a() {
        cn.jiguang.as.d.f("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
        } catch (Throwable th) {
            cn.jiguang.as.d.f("NetworkingClient", "run exception", th);
        }
        if (!a(this.f8427b)) {
            cn.jiguang.as.d.d("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        while (!this.f8426a) {
            cn.jiguang.as.d.d("NetworkingClient", "Network listening...");
            try {
                ByteBuffer a2 = this.f8428c.a();
                a(a2);
                cn.jiguang.as.d.d("NetworkingClient", "Received bytes - len:" + a2.array().length + ", pkg:" + cn.jiguang.e.a.b(this.f8427b));
            } catch (cn.jiguang.az.f e2) {
                cn.jiguang.as.d.g("NetworkingClient", " recv failed with error:" + e2 + " ,No Break!!");
            }
        }
        if (this.f8426a) {
            cn.jiguang.as.d.d("NetworkingClient", "Break receiving by wantStop");
        }
        f();
    }

    public synchronized void b() {
        try {
            cn.jiguang.bj.d.a("TCP_CONN_TASK", this);
        } catch (Throwable th) {
            cn.jiguang.as.d.h("NetworkingClient", "execute networkingClient exception :" + th);
        }
    }

    public synchronized void c() {
        cn.jiguang.as.d.d("NetworkingClient", "Action - stop");
        cn.jiguang.e.h.a(this.f8428c);
        this.f8426a = true;
        cn.jiguang.bj.d.a("TCP_CONN_TASK");
    }

    public cn.jiguang.bc.a d() {
        return this.f8428c;
    }
}
