package cn.jpush.android.ah;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.union.ads.callback.OnUnionAdListener;
import cn.jiguang.union.ads.nativ.api.JNativeAdSlot;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.ar.d;
import cn.jpush.android.helper.f;
import cn.jpush.android.l.c;
import cn.jpush.android.r.b;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f9108d;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, OnUnionAdListener> f9109a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, OnUnionAdListener> f9110b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public List<String> f9111c = new LinkedList();

    public static a a() {
        if (f9108d == null) {
            synchronized (a.class) {
                f9108d = new a();
            }
        }
        return f9108d;
    }

    private void a(long j, String str) {
        b.b("JNativeAdConnect", "removeAdListener rid:" + j + ",sequence:" + str);
        if (this.f9109a.containsKey(Long.valueOf(j))) {
            OnUnionAdListener onUnionAdListener = this.f9109a.get(Long.valueOf(j));
            Iterator<Map.Entry<String, OnUnionAdListener>> it = this.f9110b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, OnUnionAdListener> next = it.next();
                if (onUnionAdListener == next.getValue()) {
                    b.b("JNativeAdConnect", "removeAdListener sequence:" + next.getKey());
                    it.remove();
                }
            }
            this.f9109a.remove(Long.valueOf(j));
            b.b("JNativeAdConnect", "removeAdListener rid:" + j);
        }
        if (this.f9110b.containsKey(str)) {
            OnUnionAdListener onUnionAdListener2 = this.f9110b.get(str);
            Iterator<Map.Entry<Long, OnUnionAdListener>> it2 = this.f9109a.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Long, OnUnionAdListener> next2 = it2.next();
                if (onUnionAdListener2 == next2.getValue()) {
                    b.b("JNativeAdConnect", "removeAdListener rid:" + next2.getKey());
                    it2.remove();
                }
            }
            this.f9110b.remove(str);
            b.b("JNativeAdConnect", "removeAdListener sequence:" + str);
        }
    }

    private void a(long j, String str, OnUnionAdListener onUnionAdListener) {
        b.b("JNativeAdConnect", "addAdListener rid:" + j + ",sequence:" + str);
        this.f9109a.put(Long.valueOf(j), onUnionAdListener);
        this.f9110b.put(str, onUnionAdListener);
    }

    private OnUnionAdListener b(long j, String str) {
        OnUnionAdListener onUnionAdListener = this.f9109a.get(Long.valueOf(j));
        return onUnionAdListener == null ? this.f9110b.get(str) : onUnionAdListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03e1 A[Catch: all -> 0x0414, TRY_LEAVE, TryCatch #2 {all -> 0x0414, blocks: (B:93:0x039d, B:102:0x03e1, B:110:0x03d7, B:128:0x0374), top: B:92:0x039d }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03d7 A[Catch: all -> 0x0414, TRY_ENTER, TryCatch #2 {all -> 0x0414, blocks: (B:93:0x039d, B:102:0x03e1, B:110:0x03d7, B:128:0x0374), top: B:92:0x039d }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jpush.android.ai.a> c(android.content.Context r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ah.a.c(android.content.Context, java.lang.String):java.util.List");
    }

    public void a(Context context, long j, String str) {
        if (!this.f9109a.containsKey(Long.valueOf(j)) && !this.f9110b.containsKey(str)) {
            b.b("JNativeAdConnect", "had remove listener rid:" + j + ", sequence:" + str);
            return;
        }
        OnUnionAdListener b2 = b(j, str);
        a(j, str);
        try {
            if (this.f9111c.size() > 150) {
                this.f9111c.remove(this.f9111c.get(0));
            }
            this.f9111c.add(String.valueOf(j));
            this.f9111c.add(str);
            c.a(context, str, 21006, str, 1);
            cn.jpush.android.ag.a.a().a(context, 21006, (List<cn.jpush.android.ai.a>) null, b2);
        } catch (Throwable th) {
            b.f("JNativeAdConnect", "onTimeout failed " + th.getMessage());
            cn.jpush.android.ag.a.a().a(context, 21001, (List<cn.jpush.android.ai.a>) null, b2);
        }
    }

    public void a(Context context, Bundle bundle) {
        long j;
        JSONObject jSONObject;
        String string;
        String string2;
        String str = "";
        try {
            j = bundle.getLong("rid");
            bundle.setClassLoader(JNativeAdSlot.class.getClassLoader());
            jSONObject = new JSONObject(bundle.getString("ad_slot"));
            string = jSONObject.getString(InAppSlotParams.SLOT_KEY.SEQ);
            string2 = jSONObject.getString("ad_code");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cn.jpush.android.cache.a.c(context)) {
                b.f("JNativeAdConnect", "Load Native AD Failed For tcp disConnected");
                cn.jpush.android.ae.c.a(context, 13, 104, string2);
                c.a(cn.jpush.android.u.a.a(), "", 21011, string, 1);
                return;
            }
            int i2 = jSONObject.getInt("ad_count");
            jSONObject.getInt("ad_style");
            int i3 = jSONObject.getInt("timeout");
            String a2 = d.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = LogUtils.PLACEHOLDER;
            }
            String str2 = string2 + "$$" + a2 + "$$" + LogUtils.PLACEHOLDER + "$$" + string + "$$3";
            String a3 = cn.jpush.android.y.b.a(context, i2, i3);
            if (TextUtils.isEmpty(a3)) {
                b.f("JNativeAdConnect", "Send ad request failed for package body is null");
                cn.jpush.android.ae.c.a(context, 13, 107, string2);
                return;
            }
            String e2 = cn.jpush.android.at.c.a().e(context);
            b.b("JNativeAdConnect", "load nativeAd [command:34,version:5], rid: " + j + ", sequence: " + string + ", deviceInfo: " + e2 + ", adInfo: " + str2 + ", body: " + a3);
            cn.jpush.android.l.a.a(context, 34, 5, j, 20000L, cn.jpush.android.bi.b.a(0, str2, e2, a3));
            cn.jpush.android.ae.c.a(context, 13, 0, string2);
            b.d("JNativeAdConnect", "Send native ad request completed in remote process");
        } catch (Throwable th2) {
            th = th2;
            str = string2;
            cn.jpush.android.ae.c.a(context, 13, 105, str);
            b.f("JNativeAdConnect", "sendOnRemoteProcess failed " + th.getMessage());
        }
    }

    public void a(final Context context, JNativeAdSlot jNativeAdSlot, OnUnionAdListener onUnionAdListener) {
        final long a2 = f.a();
        final String sequence = jNativeAdSlot.getSequence();
        try {
            a(a2, sequence, onUnionAdListener);
            Bundle bundle = new Bundle();
            bundle.putLong("rid", a2);
            bundle.putInt("render_type", 1);
            bundle.putInt("ad_type", 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_code", jNativeAdSlot.getAdCode());
            jSONObject.put("ad_count", jNativeAdSlot.getAdCount());
            jSONObject.put("ad_style", jNativeAdSlot.getAdStyle());
            jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, sequence);
            jSONObject.put("timeout", jNativeAdSlot.getTimeout());
            bundle.putString("ad_slot", jSONObject.toString());
            cn.jpush.android.l.a.a(context, "load_native_ad", bundle);
            cn.jpush.android.af.c.a().postDelayed(new Runnable() { // from class: cn.jpush.android.ah.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a2, sequence);
                }
            }, jNativeAdSlot.getTimeout());
            b.d("JNativeAdConnect", "Send native ad request to remote process");
        } catch (Throwable th) {
            b.f("JNativeAdConnect", "send failed " + th.getMessage());
            a(a2, sequence);
            cn.jpush.android.ae.c.b(context, 13, 105, jNativeAdSlot.getAdCode());
            cn.jpush.android.ag.a.a().a(context, 21001, (List<cn.jpush.android.ai.a>) null, onUnionAdListener);
        }
    }

    public void a(Context context, String str) {
        long j;
        String str2;
        OnUnionAdListener onUnionAdListener;
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("request_id");
            String optString = jSONObject.optString("sequence_id");
            boolean optBoolean = jSONObject.optBoolean("is_timeout");
            String optString2 = jSONObject.optString("response_body");
            if (optBoolean) {
                b.f("JNativeAdConnect", "Load native ad server timeout");
                return;
            }
            b.d("JNativeAdConnect", "Load native ad response from cmd34 command: " + optString2);
            OnUnionAdListener b2 = b(optLong, optString);
            try {
                cn.jpush.android.x.c cVar = new cn.jpush.android.x.c(optString2);
                if (cVar.f9959a == 0) {
                    b.b("JNativeAdConnect", "Load Native AD Response Success, next request time interval: " + cVar.f9962d);
                    cn.jpush.android.ag.a.a().a(context, (long) cVar.f9962d);
                    return;
                }
                b.f("JNativeAdConnect", "Load native ad failed, code: " + cVar.f9959a);
                if (!cn.jpush.android.am.a.a()) {
                    a(optLong, optString);
                }
                cn.jpush.android.ag.a.a().a(context, cVar.f9959a, (List<cn.jpush.android.ai.a>) null, b2);
            } catch (Throwable th) {
                onUnionAdListener = b2;
                th = th;
                j = optLong;
                str2 = optString;
                b.f("JNativeAdConnect", "processResponse json body failed " + th.getMessage());
                a(j, str2);
                cn.jpush.android.ag.a.a().a(context, 21001, (List<cn.jpush.android.ai.a>) null, onUnionAdListener);
            }
        } catch (Throwable th2) {
            th = th2;
            j = 0;
            str2 = "";
            onUnionAdListener = null;
        }
    }

    public void b(Context context, String str) {
        String optString;
        String str2 = "";
        b.d("JNativeAdConnect", "Native ad received, , msgLen: " + str.length());
        int i2 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("render_type");
            try {
                optString = jSONObject.optString("sequence_id", "");
            } catch (Throwable th) {
                th = th;
                i2 = optInt;
            }
            try {
                String optString2 = jSONObject.optString("ad_id", "");
                OnUnionAdListener b2 = b(0L, optString);
                a(0L, optString);
                if (optInt != 1) {
                    b.b("JNativeAdConnect", "Only parse native render message, render_type: " + optInt);
                    c.a(context, optString2, 21009, optString, optInt);
                    return;
                }
                if (this.f9111c.contains(optString)) {
                    b.b("JNativeAdConnect", "Receive timeout ad message, will cache.");
                    c.a(context, optString2, 21008, optString, optInt);
                    return;
                }
                c.a(context, optString2, 21007, optString, optInt);
                List<cn.jpush.android.ai.a> c2 = c(context, str);
                if (c2.size() <= 0) {
                    c.a(context, optString2, 21009, optString, optInt);
                    cn.jpush.android.ag.a.a().a(context, 21009, (List<cn.jpush.android.ai.a>) null, b2);
                } else {
                    b.b("JNativeAdConnect", "native ad parse success");
                    c.a(context, optString2, 21000, optString, optInt);
                    cn.jpush.android.ag.a.a().a(context, 21000, c2, b2);
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = optInt;
                str2 = optString;
                b.f("JNativeAdConnect", "receive failed " + th.getMessage());
                c.a(context, "NO MSGID", 21001, str2, i2);
                cn.jpush.android.ag.a.a().a(context, 21001, (List<cn.jpush.android.ai.a>) null, (OnUnionAdListener) null);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
