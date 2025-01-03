package cn.jiguang.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.ad.c;
import cn.jiguang.l.d;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f8125a;

    /* renamed from: b, reason: collision with root package name */
    public String f8126b = d.g("7vqR3nNqKoDAlUrx74tE1g==");

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f8127c = new LinkedBlockingQueue<>(1);

    /* renamed from: d, reason: collision with root package name */
    public ServiceConnection f8128d = new ServiceConnection() { // from class: cn.jiguang.ad.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f8127c.put(iBinder);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("MsaOpenIDHelper", "linkedBlockingQueue error: " + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.f8125a = context;
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setClassName(this.f8126b, d.g("dYE0CPNDFJTaYbJHvdYTELPkLL9xmlHysh4O1rCwUiLYHLJ6VxirNHcrSo3Xn2UJ"));
        intent.setAction(d.g("AdKS/+o+CvOMDbvCnPWRYS8wCU0Ooy6tyMT0tXjLMUvWRKeDq6D985Ar35mAOPu+"));
        intent.putExtra(d.g("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), str);
        try {
            intent.putExtra(d.g("iCmt493CpcicRY98bz8pUjI+wbDT5u8oLPJxFa2B2Zg="), true);
            if (this.f8125a.startService(intent) != null) {
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("MsaOpenIDHelper", "startMsaklServer error: " + th.getMessage());
        }
    }

    public String a() {
        try {
            this.f8125a.getPackageManager().getPackageInfo(this.f8126b, 0);
            String packageName = this.f8125a.getPackageName();
            a(packageName);
            Intent intent = new Intent();
            intent.setClassName(this.f8126b, d.g("dYE0CPNDFJTaYbJHvdYTEBK/MhYfAvKlbba3ZFsuZ+on9OG47ABUmhfzcQhqhJOU"));
            intent.setAction(d.g("AdKS/+o+CvOMDbvCnPWRYUnA2ZKRLZpCerAAd95VliYNvOuVTnj4/o7GUNhJXhWl"));
            intent.putExtra(d.g("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), packageName);
            if (this.f8125a.bindService(intent, this.f8128d, 1)) {
                try {
                    c.a.C0132a c0132a = new c.a.C0132a(this.f8127c.take());
                    String a2 = c0132a.a();
                    c0132a.b();
                    this.f8125a.unbindService(this.f8128d);
                    return a2;
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ai.a.d("MsaOpenIDHelper", "getOAID error: " + th.getMessage());
                    } finally {
                        this.f8125a.unbindService(this.f8128d);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
