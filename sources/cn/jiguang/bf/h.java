package cn.jiguang.bf;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bg.i;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.InAppSlotParams;
import com.shix.shixipc.system.ContentCommon;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.Thread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static h f8715a = new h();

    /* renamed from: c, reason: collision with root package name */
    public String f8717c;

    /* renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8716b = null;

    /* renamed from: d, reason: collision with root package name */
    public g f8718d = new g();

    public static h a() {
        return f8715a;
    }

    public static JSONObject a(Context context, String str) {
        String d2 = cn.jiguang.e.c.d(cn.jiguang.e.c.a(context, str));
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        try {
            return new JSONObject(d2);
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject a(Context context, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ContentCommon.TYPE, "sentry_crash_log");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a2 = d.a(context, th);
            if (jSONObject2.length() == 0) {
                return null;
            }
            jSONObject2.put("sentry_envelope_item_header", d.a(InAppSlotParams.SLOT_KEY.EVENT));
            jSONObject2.put("sentry_envelope_item", a2);
            jSONArray.put(jSONObject2);
            jSONObject.put("sentry_envelope_header", d.a(true));
            JSONObject jSONObject3 = new JSONObject();
            cn.jiguang.bg.i a3 = this.f8718d.a();
            a3.a(i.a.Crashed, "", true);
            jSONObject3.put("sentry_envelope_item_header", d.a("session"));
            jSONObject3.put("sentry_envelope_item", d.a(context, a3));
            jSONArray.put(jSONObject3);
            jSONObject.put("sentry_envelope_items", jSONArray);
            return jSONObject;
        } catch (Throwable th2) {
            cn.jiguang.ai.a.f("SentryCrashHandler", "generalJSONLog error : " + th2.getMessage());
            return null;
        }
    }

    private Throwable b(Thread thread, Throwable th) {
        cn.jiguang.bg.c cVar = new cn.jiguang.bg.c();
        cVar.a((Boolean) false);
        cVar.a("UncaughtExceptionHandler");
        return new c(cVar, th, thread);
    }

    public static void b(Context context, String str) {
        if (context == null) {
            cn.jiguang.ai.a.d("SentryCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            cn.jiguang.e.c.a(cn.jiguang.e.c.a(context, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject, String str) {
        File a2;
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        if (TextUtils.isEmpty(jSONObject2) || (a2 = cn.jiguang.e.c.a(context, str)) == null) {
            return;
        }
        cn.jiguang.e.c.c(a2, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return "sentry" + File.separator + cn.jiguang.e.b.a() + ".envelope";
    }

    public void a(final Context context) {
        cn.jiguang.ai.a.a("SentryCrashHandler", "init");
        this.f8718d.b();
        cn.jiguang.bj.d.a("FUTURE_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.bf.h.1
            @Override // cn.jiguang.bj.b
            public void a() {
                try {
                    cn.jiguang.bg.i a2 = h.this.f8718d.a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sentry_envelope_header", d.a(false));
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sentry_envelope_item_header", d.a("session"));
                    jSONObject2.put("sentry_envelope_item", d.a(context, a2));
                    jSONArray.put(jSONObject2);
                    jSONObject.put("sentry_envelope_items", jSONArray);
                    jSONObject.put(ContentCommon.TYPE, "sentry_crash_log");
                    cn.jiguang.ai.a.a("SentryCrashHandler", "session is " + jSONObject.toString());
                    h.this.f8717c = h.this.c();
                    h.this.b(context, jSONObject, h.this.f8717c);
                    h.this.a(context, jSONObject, h.this.f8717c);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void a(final Context context, final JSONObject jSONObject, final String str) {
        if (context == null) {
            cn.jiguang.ai.a.d("SentryCrashHandler", "Action - reportCrashLog context is null");
            return;
        }
        if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.bj.d.a("FUTURE_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.bf.h.3
                    @Override // cn.jiguang.bj.b
                    public void a() {
                        cn.jiguang.au.f.a(context, jSONObject, new ReportCallBack() { // from class: cn.jiguang.bf.h.3.1
                            @Override // cn.jiguang.api.ReportCallBack
                            public void onFinish(int i2) {
                                if (i2 == 0) {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    h.b(context, str);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                cn.jiguang.ai.a.f("SentryCrashHandler", "report crash e:" + th);
            }
        }
    }

    public void a(Thread thread, Throwable th) {
        cn.jiguang.ai.a.a("SentryCrashHandler", "handleException catch exception");
        a(th);
    }

    public void a(Throwable th) {
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            cn.jiguang.ai.a.f("SentryCrashHandler", "handleException failed: context is null");
            return;
        }
        try {
            JSONObject a2 = a(appContext, th);
            if (a2 == null) {
                return;
            }
            cn.jiguang.ai.a.a("SentryCrashHandler", "crash log is : " + a2.toString());
            String c2 = c();
            this.f8717c = c2;
            b(appContext, a2, c2);
            a(appContext, a2, this.f8717c);
        } catch (Throwable unused) {
        }
    }

    public void b() {
        cn.jiguang.ai.a.a("SentryCrashHandler", "setUncaughtExceptionHandler");
        if (this.f8716b == null) {
            this.f8716b = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b(final Context context) {
        cn.jiguang.bj.d.a("DELAY_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.bf.h.2
            @Override // cn.jiguang.bj.b
            public void a() {
                File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + "sentry");
                if (file.exists() && file.isDirectory() && file.canWrite() && file.canRead()) {
                    for (File file2 : file.listFiles(new FilenameFilter() { // from class: cn.jiguang.bf.h.2.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file3, String str) {
                            return str.endsWith(".envelope");
                        }
                    })) {
                        String str = "sentry" + File.separator + file2.getName();
                        JSONObject a2 = h.a(context, str);
                        if (a2 != null) {
                            h.this.a(context, a2, str);
                        }
                    }
                }
            }
        }, 10000);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        cn.jiguang.ai.a.a("SentryCrashHandler", "uncaughtException");
        a(b(thread, th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8716b;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
