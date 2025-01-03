package cn.jpush.android.ap;

import android.os.CountDownTimer;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public CountDownTimer f9148a;

    /* renamed from: cn.jpush.android.ap.a$a, reason: collision with other inner class name */
    public interface InterfaceC0143a {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f9148a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f9148a = null;
        }
    }

    public void a(final InterfaceC0143a interfaceC0143a, long j, long j2) {
        this.f9148a = new CountDownTimer(j, j2) { // from class: cn.jpush.android.ap.a.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                InterfaceC0143a interfaceC0143a2 = interfaceC0143a;
                if (interfaceC0143a2 != null) {
                    interfaceC0143a2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }
        }.start();
    }
}
