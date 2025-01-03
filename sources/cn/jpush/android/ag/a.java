package cn.jpush.android.ag;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import cn.jiguang.union.ads.callback.OnUnionAdListener;
import cn.jiguang.union.ads.nativ.api.JNativeAdError;
import cn.jiguang.union.ads.nativ.api.JNativeAdSlot;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener;
import cn.jpush.android.k.b;
import cn.jpush.android.k.c;
import cn.jpush.android.k.d;
import cn.jpush.android.k.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f9101a;

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentLinkedQueue<Long> f9102c = new ConcurrentLinkedQueue<>();

    /* renamed from: b, reason: collision with root package name */
    public AtomicLong f9103b;

    private int a(Context context, int i2, int i3, d dVar) {
        if (i2 == 1) {
            return ((c) dVar).a(i3);
        }
        if (i2 == 2) {
            return ((f) dVar).a(i3);
        }
        if (i2 == 3) {
            return ((b) dVar).a(i3);
        }
        if (i2 != 4) {
            return 0;
        }
        return ((cn.jpush.android.k.a) dVar).a(i3);
    }

    private int a(Context context, int i2, d dVar) {
        if (i2 == 1) {
            return ((c) dVar).a();
        }
        if (i2 == 2) {
            return ((f) dVar).a();
        }
        if (i2 == 3) {
            return ((b) dVar).a();
        }
        if (i2 != 4) {
            return 0;
        }
        return ((cn.jpush.android.k.a) dVar).a();
    }

    public static a a() {
        if (f9101a == null) {
            synchronized (a.class) {
                f9101a = new a();
            }
        }
        return f9101a;
    }

    private void a(Context context, int i2, OnNativeAdLoadListener onNativeAdLoadListener) {
        new cn.jpush.android.al.b(onNativeAdLoadListener).onError(new JNativeAdError(i2));
    }

    private void a(Context context, List<cn.jpush.android.ai.a> list, OnNativeAdLoadListener onNativeAdLoadListener) {
        cn.jpush.android.al.b bVar = new cn.jpush.android.al.b(onNativeAdLoadListener);
        try {
            ArrayList arrayList = new ArrayList();
            for (cn.jpush.android.ai.a aVar : list) {
                if (a(context, 2, aVar)) {
                    cn.jpush.android.l.c.a(cn.jpush.android.u.a.a(), aVar.e().f9950a, 22000, aVar.e().al, aVar.e().am);
                    arrayList.add(aVar);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            if (arrayList2.size() > 0) {
                bVar.onLoaded(arrayList2);
            } else {
                bVar.onError(new JNativeAdError(21009));
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JNativeBusiness", "onNativeAdLoadSuccess occur error, t: " + th.getMessage());
            bVar.onError(new JNativeAdError(21001));
        }
    }

    private synchronized boolean a(Context context) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = cn.jpush.android.ak.a.a(context);
        if (this.f9103b == null) {
            this.f9103b = new AtomicLong(cn.jpush.android.ak.a.b(context));
        }
        if (currentTimeMillis - a2 < this.f9103b.get()) {
            z = false;
        } else {
            cn.jpush.android.ak.a.a(context, System.currentTimeMillis());
            z = true;
        }
        return z;
    }

    private boolean a(Context context, int i2, cn.jpush.android.ai.a aVar) {
        int i3;
        StringBuilder sb;
        int c2;
        if (aVar.b() != null) {
            int a2 = a(context, aVar.a(), i2, aVar.b());
            if (a2 > 0) {
                cn.jpush.android.l.c.a(context, aVar.e().f9950a, (i2 * 1000) + 20000 + a2, aVar.e().al, aVar.e().am, aVar.b().b());
            }
            if (a2 == 100 || a2 == 200 || a2 == 300 || a2 == 400) {
                sb = new StringBuilder();
                sb.append("verify ad main url succeed, promoteType: ");
                c2 = aVar.a();
                sb.append(c2);
                cn.jpush.android.r.b.b("JNativeBusiness", sb.toString());
                return true;
            }
            cn.jpush.android.r.b.f("JNativeBusiness", "main url is unavailable for verifying, failCode: " + a2);
        }
        if (aVar.d() == null) {
            return false;
        }
        boolean c3 = aVar.d().c();
        cn.jpush.android.r.b.b("JNativeBusiness", "check second ad url can use, state: " + c3);
        if (!c3) {
            return false;
        }
        int a3 = a(context, aVar.c(), i2, aVar.d());
        if (a3 > 0) {
            i3 = a3;
            cn.jpush.android.l.c.a(context, aVar.e().f9950a, (i2 * 1000) + 20000 + a3, aVar.e().al, aVar.e().am, aVar.d().b());
        } else {
            i3 = a3;
        }
        if (i3 != 100 && i3 != 200 && i3 != 300 && i3 != 400) {
            return false;
        }
        sb = new StringBuilder();
        sb.append("verify ad second url succeed, promoteType: ");
        c2 = aVar.c();
        sb.append(c2);
        cn.jpush.android.r.b.b("JNativeBusiness", sb.toString());
        return true;
    }

    private boolean b(Context context, int i2, cn.jpush.android.ai.a aVar) {
        StringBuilder sb;
        int c2;
        StringBuilder sb2;
        boolean e2 = aVar.b().e();
        cn.jpush.android.r.b.b("JNativeBusiness", "Deal ad jump, operation: " + i2 + ", isCanUse: " + e2);
        if (e2) {
            cn.jpush.android.r.b.b("JNativeBusiness", "main url is useful and deal jump, url: " + aVar.b().b());
            int a2 = a(context, aVar.a(), aVar.b());
            if (a2 > 0) {
                cn.jpush.android.l.c.a(context, aVar.e().f9950a, (i2 * 1000) + 20000 + a2, aVar.e().al, aVar.e().am);
            }
            if (a2 != 100 && a2 != 200 && a2 != 300 && a2 != 400) {
                sb2 = new StringBuilder();
                sb2.append("jump ad main jump url failed, promoteType: ");
                sb2.append(aVar.a());
                cn.jpush.android.r.b.f("JNativeBusiness", sb2.toString());
                return false;
            }
            sb = new StringBuilder();
            sb.append("jump ad main jump url succeed, promoteType: ");
            c2 = aVar.a();
            sb.append(c2);
            cn.jpush.android.r.b.b("JNativeBusiness", sb.toString());
            return true;
        }
        if (aVar.d() == null) {
            return false;
        }
        boolean c3 = aVar.d().c();
        boolean e3 = aVar.d().e();
        cn.jpush.android.r.b.b("JNativeBusiness", "main url is not useful and use second url, failedUrlCanUse: " + c3 + ", failedUrlAvailable: " + e3);
        if (!e3 || !c3) {
            return false;
        }
        cn.jpush.android.r.b.b("JNativeBusiness", "main url is not useful, use second url jump");
        int a3 = a(context, aVar.c(), aVar.d());
        if (a3 > 0) {
            cn.jpush.android.l.c.a(context, aVar.e().f9950a, (i2 * 1000) + 20000 + a3, aVar.e().al, aVar.e().am);
        }
        if (a3 == 100 || a3 == 200 || a3 == 300 || a3 == 400) {
            sb = new StringBuilder();
            sb.append("jump ad second jump url succeed, promoteType: ");
            c2 = aVar.c();
            sb.append(c2);
            cn.jpush.android.r.b.b("JNativeBusiness", sb.toString());
            return true;
        }
        sb2 = new StringBuilder();
        sb2.append("jump ad second jump url failed, promoteType: ");
        sb2.append(aVar.c());
        sb2.append(", code: ");
        sb2.append(a3);
        cn.jpush.android.r.b.f("JNativeBusiness", sb2.toString());
        return false;
    }

    public int a(Context context, View view, int i2) {
        return view.getVisibility() != 0 ? i2 == 4 ? 24004 : 23004 : i2 == 4 ? 24999 : 23000;
    }

    public void a(Context context, int i2, List<cn.jpush.android.ai.a> list, OnUnionAdListener onUnionAdListener) {
        OnNativeAdLoadListener onNativeAdLoadListener = (OnNativeAdLoadListener) onUnionAdListener;
        if (i2 == 21000) {
            a(context, list, onNativeAdLoadListener);
        } else {
            a(context, i2, onNativeAdLoadListener);
        }
    }

    public void a(Context context, long j) {
        long j2;
        AtomicLong atomicLong = this.f9103b;
        if (atomicLong == null) {
            this.f9103b = new AtomicLong(j);
            j2 = 0;
        } else {
            j2 = atomicLong.get();
            this.f9103b.set(j);
        }
        if (j2 != j) {
            cn.jpush.android.ak.a.b(context, j);
        }
    }

    public void a(Context context, JNativeAdSlot jNativeAdSlot, OnNativeAdLoadListener onNativeAdLoadListener) {
        if (!b()) {
            cn.jpush.android.r.b.f("JNativeBusiness", "load failed limit api");
            new cn.jpush.android.al.b(onNativeAdLoadListener).onError(new JNativeAdError(21003));
            cn.jpush.android.ae.c.b(context, 13, 101, jNativeAdSlot.getAdCode());
        } else if (!cn.jpush.android.bm.a.a(context)) {
            cn.jpush.android.r.b.f("JNativeBusiness", "Load Native AD Failed For no network");
            new cn.jpush.android.al.b(onNativeAdLoadListener).onError(new JNativeAdError(21005));
            cn.jpush.android.ae.c.b(context, 13, 103, jNativeAdSlot.getAdCode());
        } else {
            if (a(context)) {
                cn.jpush.android.ah.a.a().a(context, jNativeAdSlot, onNativeAdLoadListener);
                return;
            }
            cn.jpush.android.r.b.f("JNativeBusiness", "load failed for server time limit");
            cn.jpush.android.l.c.a(cn.jpush.android.u.a.a(), jNativeAdSlot.getSequence(), 21004, jNativeAdSlot.getSequence(), 1);
            new cn.jpush.android.al.b(onNativeAdLoadListener).onError(new JNativeAdError(21004));
            cn.jpush.android.ae.c.b(context, 13, 102, jNativeAdSlot.getAdCode());
        }
    }

    public void a(Context context, cn.jpush.android.ai.a aVar) {
        if (context == null || aVar == null) {
            cn.jpush.android.r.b.f("JNativeBusiness", "unexpected error parameter is null, context: " + context + ", nativeAd: " + aVar);
            return;
        }
        if (!a(context, 4, aVar)) {
            cn.jpush.android.r.b.f("JNativeBusiness", "[click] ad jump link verify failed");
        } else if (!b(context, 5, aVar)) {
            cn.jpush.android.l.c.a(context, aVar.e().f9950a, 25001, aVar.e().al, aVar.e().am);
        } else {
            cn.jpush.android.r.b.d("JNativeBusiness", "native ad jump success");
            cn.jpush.android.l.c.a(context, aVar.e().f9950a, 25000, aVar.e().al, aVar.e().am);
        }
    }

    public void a(final cn.jpush.android.ai.a aVar, final View view, List<View> list, OnNativeAdEventListener onNativeAdEventListener) {
        if (onNativeAdEventListener == null) {
            cn.jpush.android.r.b.i("JNativeBusiness", "setOnNativeAdEventListener-listener  must set");
            return;
        }
        if (aVar == null) {
            cn.jpush.android.r.b.i("JNativeBusiness", "setOnNativeAdEventListener-nativeAd must set");
            new cn.jpush.android.al.a(onNativeAdEventListener).onError(new JNativeAdError(2));
            return;
        }
        if (view == null) {
            cn.jpush.android.r.b.i("JNativeBusiness", "setOnNativeAdEventListener-rootView  must set");
            new cn.jpush.android.al.a(onNativeAdEventListener).onError(new JNativeAdError(2));
            return;
        }
        if (!a(cn.jpush.android.u.a.a(), 3, aVar)) {
            cn.jpush.android.r.b.f("JNativeBusiness", "Native exposure occur error");
        }
        int a2 = a(cn.jpush.android.u.a.a(), view, 3);
        cn.jpush.android.al.a aVar2 = new cn.jpush.android.al.a(onNativeAdEventListener);
        if (a2 == 23000) {
            cn.jpush.android.ar.d.a(cn.jpush.android.u.a.a(), aVar.e().ad);
            aVar2.onAdExposed(aVar);
        } else {
            aVar2.onError(new JNativeAdError(a2));
        }
        cn.jpush.android.l.c.a(cn.jpush.android.u.a.a(), aVar.e().f9950a, a2, aVar.e().al, aVar.e().am);
        final int i2 = aVar.e().ao * 1000;
        cn.jpush.android.af.c.a().postDelayed(new Runnable() { // from class: cn.jpush.android.ag.a.1
            @Override // java.lang.Runnable
            public void run() {
                int a3 = a.this.a(cn.jpush.android.u.a.a(), view, 3);
                cn.jpush.android.r.b.b("JNativeBusiness", "native ad delay exposure check code: " + a3 + ", delayCheckTime: " + i2);
                if (a3 == 23000) {
                    cn.jpush.android.l.c.a(cn.jpush.android.u.a.a(), aVar.e().f9950a, 23999, aVar.e().al, aVar.e().am);
                }
            }
        }, i2);
        if (list == null || list.isEmpty()) {
            view.setOnClickListener(new cn.jpush.android.aj.a(cn.jpush.android.u.a.a(), aVar, onNativeAdEventListener));
            return;
        }
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(new cn.jpush.android.aj.a(cn.jpush.android.u.a.a(), aVar, onNativeAdEventListener));
        }
    }

    public synchronized boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f9102c.size() < 30) {
            f9102c.offer(Long.valueOf(elapsedRealtime));
            return true;
        }
        long longValue = elapsedRealtime - f9102c.element().longValue();
        if (longValue < 0) {
            f9102c.clear();
            return false;
        }
        if (longValue <= 10000) {
            return false;
        }
        while (f9102c.size() >= 30) {
            f9102c.poll();
        }
        f9102c.offer(Long.valueOf(elapsedRealtime));
        return true;
    }
}
