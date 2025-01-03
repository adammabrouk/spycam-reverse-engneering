package cn.jiguang.analytics.page;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.as.d;
import cn.jiguang.au.f;
import cn.jiguang.bj.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PushSA {
    public static final String CACHE_PATH = "push_stat_cache.json";
    public static final String KEY_SESSION_ID = "session_id";
    public static final String REPORT_ACTIVE_LAUNCH = "active_launch";
    public static final String REPORT_ACTIVE_TERMINATE = "active_terminate";
    public static final String SESSION_END_MILLIS = "cse";
    public static final String SESSION_START_MILLIS = "css";
    public static final String TAG = "PushSA";
    public static volatile PushSA instance = null;
    public static boolean isOnPauseInvoke = false;
    public static boolean isOnResumeInvoke = false;
    public String cur_activity = null;
    public String cur_session_id = null;
    public long interval = 30;
    public long latestResumeTime = 0;
    public long latestPauseTime = 0;
    public boolean firstResume = true;
    public boolean activitySwitch = false;
    public boolean stat_enable = true;
    public long tempTimelong = 0;
    public JSONObject flow_cache = null;
    public final Object cur_session_file_lock = new Object();

    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8238a;

        /* renamed from: b, reason: collision with root package name */
        public Context f8239b;

        /* renamed from: c, reason: collision with root package name */
        public PushSA f8240c;

        public a(boolean z, Context context, PushSA pushSA) {
            this.f8238a = z;
            this.f8239b = context;
            this.f8240c = pushSA;
            this.f8813h = PushSA.TAG;
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            try {
                if (this.f8238a) {
                    this.f8240c.sendLogRoutine(this.f8239b);
                } else {
                    this.f8240c.saveLogRoutine(this.f8239b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void clearCurrentLogFile(Context context) {
        f.a(context, CACHE_PATH, (JSONObject) null);
    }

    private JSONObject createNewSession(Context context, long j) {
        this.cur_session_id = generateSessionID(context, j);
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.q().a((cn.jiguang.f.a<Long>) Long.valueOf(this.latestResumeTime)), cn.jiguang.f.a.t().a((cn.jiguang.f.a<String>) this.cur_session_id)});
        JSONObject jSONObject = new JSONObject();
        try {
            wrapDate(jSONObject);
            cn.jiguang.d.a.a(context, jSONObject, REPORT_ACTIVE_LAUNCH);
            jSONObject.put(KEY_SESSION_ID, this.cur_session_id);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private String generateSessionID(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        String e2 = cn.jiguang.d.a.e(context);
        if (!TextUtils.isEmpty(e2)) {
            sb.append(e2);
        }
        sb.append(j);
        return cn.jiguang.e.f.d(sb.toString());
    }

    private JSONObject getFlowCache(Context context) {
        if (this.flow_cache == null) {
            this.flow_cache = cn.jiguang.d.a.a(context, CACHE_PATH);
        }
        return this.flow_cache;
    }

    public static PushSA getInstance() {
        if (instance == null) {
            synchronized (PushSA.class) {
                instance = new PushSA();
            }
        }
        return instance;
    }

    private boolean invokeCheck(Context context, String str) {
        if (!this.stat_enable) {
            d.e(TAG, "stat function has been disabled");
            return false;
        }
        if (context == null) {
            d.e(TAG, "context is null");
            return false;
        }
        if (!(context instanceof Application)) {
            return true;
        }
        d.j(TAG, "Context should be an Activity on this method : " + str);
        return false;
    }

    private boolean isNewSession(Context context) {
        if (this.firstResume) {
            this.firstResume = false;
            d.c(TAG, "statistics start");
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.s())).longValue();
            d.c(TAG, "lastPause:" + longValue + ",latestResumeTime:" + this.latestResumeTime + ",interval:" + (this.interval * 1000) + ",a:" + (this.latestResumeTime - longValue));
            if (longValue > 0 && this.latestResumeTime - longValue <= this.interval * 1000) {
                return false;
            }
        } else if (this.latestResumeTime - this.latestPauseTime <= this.interval * 1000) {
            return false;
        }
        return true;
    }

    private void saveCurrentLog(Context context, JSONObject jSONObject) {
        f.a(context, CACHE_PATH, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLogRoutine(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.cur_session_file_lock) {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.s().a((cn.jiguang.f.a<Long>) Long.valueOf(this.latestPauseTime)), cn.jiguang.f.a.r().a((cn.jiguang.f.a<Long>) Long.valueOf(this.latestPauseTime))});
            JSONObject flowCache = getFlowCache(context);
            if (flowCache == null) {
                flowCache = new JSONObject();
            }
            try {
                updateFlowInfo(flowCache, context);
            } catch (Exception unused) {
            }
            updateFlowCache(flowCache);
            saveCurrentLog(context, flowCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLogRoutine(Context context) {
        JSONObject flowCache;
        if (!isNewSession(context)) {
            this.cur_session_id = (String) cn.jiguang.f.b.b(context, cn.jiguang.f.a.t());
            return;
        }
        d.e(TAG, "new statistics session");
        JSONArray jSONArray = new JSONArray();
        JSONObject createNewSession = createNewSession(context, this.latestResumeTime);
        if (createNewSession != null) {
            jSONArray.put(createNewSession);
        }
        synchronized (this.cur_session_file_lock) {
            flowCache = getFlowCache(context);
            if (flowCache != null && flowCache.length() > 0) {
                try {
                    cn.jiguang.d.a.a(context, flowCache, REPORT_ACTIVE_TERMINATE);
                } catch (Exception unused) {
                }
                clearCurrentLogFile(context);
                this.flow_cache = null;
            }
        }
        if (flowCache != null && flowCache.length() > 0) {
            jSONArray.put(flowCache);
        }
        cn.jiguang.d.a.a(context, jSONArray);
    }

    private void updateFlowCache(JSONObject jSONObject) {
        this.flow_cache = jSONObject;
    }

    private void updateFlowInfo(JSONObject jSONObject, Context context) {
        long j;
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.q())).longValue();
        if (longValue <= 0) {
            long j2 = this.latestPauseTime - this.tempTimelong;
            j = j2 > 0 ? j2 / 1000 : 10L;
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.q().a((cn.jiguang.f.a<Long>) Long.valueOf(this.tempTimelong))});
        } else {
            j = (this.latestPauseTime - longValue) / 1000;
        }
        jSONObject.put("duration", j);
        jSONObject.put("itime", System.currentTimeMillis() / 1000);
        jSONObject.put(KEY_SESSION_ID, this.cur_session_id);
        wrapDate(jSONObject);
    }

    private void wrapDate(JSONObject jSONObject) {
        String b2 = cn.jiguang.e.b.b();
        String str = b2.split("_")[0];
        String str2 = b2.split("_")[1];
        jSONObject.put("date", str);
        jSONObject.put("time", str2);
    }

    public long getInterval() {
        return this.interval;
    }

    public boolean isStatEnable() {
        return this.stat_enable;
    }

    public void onFragmentPause(Context context, String str) {
        if (!this.activitySwitch) {
            d.c(TAG, "JCoreInterface.onPause() must be called after called JCoreInterface.onResume() in this Activity or Fragment");
            return;
        }
        this.activitySwitch = false;
        String str2 = this.cur_activity;
        if (str2 == null || !str2.equals(str)) {
            d.j(TAG, "page name didn't match the last one passed by onResume");
            return;
        }
        this.latestPauseTime = System.currentTimeMillis();
        final Context applicationContext = context.getApplicationContext();
        try {
            cn.jiguang.bj.d.a("SCHEDULE_TASK", new b("PushSA#onFragmentPause") { // from class: cn.jiguang.analytics.page.PushSA.2
                @Override // cn.jiguang.bj.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(applicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onFragmentResume(Context context, String str) {
        if (this.activitySwitch) {
            d.c(TAG, "JCoreInterface.onResume() must be called after called JCoreInterface.onPause() in last Activity or Fragment");
            return;
        }
        this.activitySwitch = true;
        this.cur_activity = str;
        this.latestResumeTime = System.currentTimeMillis();
        final Context applicationContext = context.getApplicationContext();
        try {
            cn.jiguang.bj.d.a("SCHEDULE_TASK", new b("PushSA#onFragmentResume") { // from class: cn.jiguang.analytics.page.PushSA.1
                @Override // cn.jiguang.bj.b
                public void a() {
                    try {
                        PushSA.this.sendLogRoutine(applicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onKillProcess(Context context) {
        try {
            if (this.cur_activity == null || !this.activitySwitch) {
                return;
            }
            this.latestPauseTime = System.currentTimeMillis();
            final Context applicationContext = context.getApplicationContext();
            cn.jiguang.bj.d.a("SCHEDULE_TASK", new b("PushSA#onKillProcess") { // from class: cn.jiguang.analytics.page.PushSA.3
                @Override // cn.jiguang.bj.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(applicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onPause(Context context) {
        if (invokeCheck(context, "onPause")) {
            isOnPauseInvoke = true;
            try {
                this.activitySwitch = true;
            } catch (ClassCastException unused) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.activitySwitch) {
                this.activitySwitch = false;
                String str = this.cur_activity;
                if (str == null || !str.equals(context.getClass().getName())) {
                    d.e(TAG, "the activity pass by onPause didn't match last one passed by onResume");
                    return;
                }
                this.latestPauseTime = System.currentTimeMillis();
                this.tempTimelong = this.latestResumeTime;
                try {
                    cn.jiguang.bj.d.a("SCHEDULE_TASK", new a(false, context.getApplicationContext(), this));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void onResume(Context context) {
        if (invokeCheck(context, "onResume")) {
            isOnResumeInvoke = true;
            try {
                this.activitySwitch = false;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.activitySwitch) {
                return;
            }
            this.activitySwitch = true;
            this.latestResumeTime = System.currentTimeMillis();
            this.cur_activity = context.getClass().getName();
            try {
                cn.jiguang.bj.d.a("SCHEDULE_TASK", new a(true, context.getApplicationContext(), this));
            } catch (Throwable unused2) {
            }
        }
    }

    public void setInterval(long j) {
        this.interval = j;
    }

    public void setStatEnable(boolean z) {
        this.stat_enable = z;
    }
}
