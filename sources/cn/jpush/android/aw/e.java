package cn.jpush.android.aw;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f9426a = 94;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public long K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public String P;
    public int Q;
    public int R;
    public int S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public cn.jpush.android.d.d Y;
    public float Z;
    public float aa;
    public float ab;
    public float ac;
    public float ad;

    /* renamed from: c, reason: collision with root package name */
    public String f9428c;

    /* renamed from: d, reason: collision with root package name */
    public int f9429d;

    /* renamed from: e, reason: collision with root package name */
    public String f9430e;

    /* renamed from: f, reason: collision with root package name */
    public String f9431f;

    /* renamed from: g, reason: collision with root package name */
    public int f9432g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9433h;

    /* renamed from: i, reason: collision with root package name */
    public String f9434i;
    public String j;
    public String p;
    public String q;
    public int r;
    public String s;
    public int u;
    public long w;
    public int x;
    public String z;

    /* renamed from: b, reason: collision with root package name */
    public int f9427b = 60;
    public boolean k = true;
    public boolean l = false;
    public boolean m = true;
    public boolean n = true;
    public boolean o = true;
    public boolean t = false;
    public int v = 0;
    public boolean y = false;

    public e(cn.jpush.android.d.d dVar) {
        this.D = "";
        this.E = "";
        this.F = 0;
        this.G = 0;
        this.H = 1;
        this.I = 0;
        this.J = 5;
        this.K = 1800L;
        this.L = 0;
        this.M = 10;
        this.N = true;
        this.O = true;
        this.Z = -1.0f;
        this.aa = -1.0f;
        this.ab = -1.0f;
        this.ac = -1.0f;
        this.ad = -1.0f;
        this.B = dVar.f9700d;
        this.z = dVar.f9698b;
        this.A = dVar.f9699c;
        this.C = dVar.f9703g;
        this.D = dVar.aA;
        this.E = dVar.aB;
        this.F = dVar.aC;
        this.G = dVar.aH;
        this.H = dVar.aI;
        this.I = dVar.aJ;
        this.J = dVar.aL;
        this.K = dVar.aM;
        this.L = dVar.aN;
        this.M = dVar.aO;
        this.P = dVar.bb;
        this.Q = dVar.bc;
        this.R = dVar.bm;
        this.S = dVar.bd;
        this.T = dVar.be;
        this.U = dVar.bf;
        this.V = dVar.bg;
        this.W = dVar.bi;
        this.X = dVar.bj;
        this.N = dVar.aQ != 0;
        this.O = dVar.aR != 0;
        this.f9428c = dVar.L;
        this.x = dVar.bA;
        this.ad = dVar.bF;
        if (dVar.bz.size() > 0) {
            this.Z = dVar.bz.get(0).floatValue();
            this.aa = dVar.bz.get(1).floatValue();
            this.ab = dVar.bz.get(2).floatValue();
            this.ac = dVar.bz.get(3).floatValue();
            if (this.x == 0) {
                float f2 = this.Z;
                this.Z = f2 > 0.0f ? f2 / 10000.0f : f2;
                float f3 = this.aa;
                this.aa = f3 > 0.0f ? f3 / 10000.0f : f3;
                float f4 = this.ab;
                this.ab = f4 > 0.0f ? f4 / 10000.0f : f4;
                float f5 = this.ac;
                this.ac = f5 > 0.0f ? f5 / 10000.0f : f5;
            }
            if (this.F == 1 && this.ad > 0.0f && this.aa > 0.0f && this.ac > 0.0f) {
                Logger.d("InAppMessage", "banner style use size radio, set top or bottom margin default");
                if (dVar.aE == 0) {
                    this.ac = -1.0f;
                } else {
                    this.aa = -1.0f;
                }
            }
        }
        this.Y = dVar;
        dVar.r = 0;
        dVar.ab = 0;
        dVar.s = true;
    }

    private float a(int i2) {
        return i2 == 0 ? this.Z : i2 == 1 ? this.aa : i2 == 2 ? this.ab : this.ac;
    }

    public static e a(String str) {
        cn.jpush.android.d.d a2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("entity");
            if (TextUtils.isEmpty(optString) || (a2 = cn.jpush.android.d.d.a(optString)) == null) {
                return null;
            }
            e eVar = new e(a2);
            eVar.f9427b = jSONObject.optInt("webWidth");
            eVar.f9428c = jSONObject.optString("deeplink");
            eVar.f9429d = jSONObject.optInt("failedAction");
            eVar.f9430e = jSONObject.optString("failedLink");
            eVar.f9431f = jSONObject.optString("targetPkgName");
            eVar.f9432g = jSONObject.optInt("urlOpenType");
            eVar.f9433h = jSONObject.optBoolean("isForNewUser");
            eVar.f9434i = jSONObject.optString("targetAppName");
            eVar.j = jSONObject.optString("targetAppIcon");
            eVar.k = jSONObject.optBoolean("isCanCancel");
            eVar.l = jSONObject.optBoolean("useRange");
            eVar.m = jSONObject.optBoolean("installBySys");
            eVar.n = jSONObject.optBoolean("failInstallByWeb");
            eVar.o = jSONObject.optBoolean("isPopGrantWin");
            eVar.p = jSONObject.optString("sspWxAppId");
            eVar.q = jSONObject.optString("sspWmOriginId");
            eVar.r = jSONObject.optInt("sspWmType");
            eVar.s = jSONObject.optString("sspWxPath");
            eVar.t = jSONObject.optBoolean("isWmDeepLink");
            eVar.u = jSONObject.optInt("actionType");
            return eVar;
        } catch (Throwable unused) {
        }
        return null;
    }

    private void a(Context context, DisplayMetrics displayMetrics) {
        String str;
        float f2 = this.Z;
        if (f2 > 0.0f) {
            float f3 = this.ab;
            if (f3 > 0.0f) {
                f2 += f3;
            }
        } else {
            f2 = this.ab;
            if (f2 <= 0.0f) {
                f2 = 0.0f;
            }
        }
        float f4 = this.aa;
        if (f4 > 0.0f) {
            float f5 = this.ac;
            if (f5 > 0.0f) {
                f4 += f5;
            }
        } else {
            float f6 = this.ac;
            f4 = f6 > 0.0f ? f6 : 0.0f;
        }
        if (this.x == 0) {
            if (f2 >= 1.0f) {
                Logger.w("InAppMessage", "coordinate is invalid use default, coor_type(percent): " + this.x + ", left: " + this.Z + ", right: " + this.ab);
                this.ab = -1.0f;
                this.Z = -1.0f;
            }
            if (f4 < 1.0f) {
                return;
            }
            str = "coordinate is invalid use default, coor_type(percent): " + this.x + ", top: " + this.aa + ", bottom: " + this.ac;
        } else {
            if (k.a(context, (int) f2) >= displayMetrics.widthPixels) {
                Logger.w("InAppMessage", "coordinate is invalid use default, coor_type(dp): " + this.x + ", left: " + this.Z + ", right: " + this.ab + ", pixelsW: " + displayMetrics.widthPixels);
                this.ab = -1.0f;
                this.Z = -1.0f;
            }
            if (k.a(context, (int) f4) < displayMetrics.heightPixels) {
                return;
            }
            str = "coordinate is invalid use default, coor_type(dp): " + this.x + ", top: " + this.aa + ", bottom: " + this.ac + ", pixelsH: " + displayMetrics.heightPixels;
        }
        Logger.w("InAppMessage", str);
        this.ac = -1.0f;
        this.aa = -1.0f;
    }

    public float a(Context context, DisplayMetrics displayMetrics, int i2) {
        a(context, displayMetrics);
        return a(i2);
    }

    public int a(Context context, String str) {
        String str2;
        JSONObject optJSONObject;
        int i2 = 0;
        int i3 = 1302;
        try {
            JSONArray jSONArray = new JSONArray(this.Y.bj);
            Logger.d("InAppMessage", "actionKey: " + str + ", parse intent action, actions: " + jSONArray.toString() + ", actionLen: " + jSONArray.length());
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i4);
                    if (optJSONObject2 != null && optJSONObject2.optString("ein_action_key", "").equals(str)) {
                        int optInt = optJSONObject2.optInt("ein_action_type", 0);
                        this.u = optInt;
                        boolean z = true;
                        if (optInt != 1) {
                            if (optInt == 2) {
                                try {
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ein_wx_intent");
                                    if (optJSONObject3 != null) {
                                        this.p = optJSONObject3.optString("wx_app_id", "");
                                        this.q = optJSONObject3.optString("mini_originid", "");
                                        this.r = optJSONObject3.optInt("mini_type", 0);
                                        this.s = optJSONObject3.optString("mini_path", "");
                                        this.t = true;
                                        str2 = "wx intent param, sspWxAppId=" + this.p + ", sspWmOriginId=" + this.q + ", sspWmType=" + this.r + ", sspWmType=" + this.r;
                                        Logger.d("InAppMessage", str2);
                                    }
                                    i3 = 0;
                                } catch (Throwable th) {
                                    th = th;
                                    Logger.w("InAppMessage", "parse intent action by actionKey: " + str + " failed. " + th.getMessage());
                                    return i2;
                                }
                            } else if (optInt != 3 && optInt != 4) {
                            }
                        }
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ein_intent");
                        this.f9433h = optJSONObject2.optInt("ein_for_new_user", 0) != 0;
                        if (optJSONObject4 != null) {
                            this.f9430e = optJSONObject4.optString("n_fail_handle_url", "");
                            this.f9428c = optJSONObject4.optString("n_url", "");
                            this.f9429d = optJSONObject4.optInt("n_fail_handle_type", 0);
                            this.f9431f = optJSONObject4.optString("n_package_name", "");
                            this.f9432g = optJSONObject4.optInt("n_url_open_type", 0);
                            if (this.f9433h && (optJSONObject = optJSONObject2.optJSONObject("ein_extras")) != null) {
                                this.f9434i = optJSONObject.optString("n_target_app_name");
                                this.j = optJSONObject.optString("n_target_app_icon");
                                this.k = optJSONObject.optInt("n_no_swipe_cancel", 0) == 0;
                                this.l = optJSONObject.optInt("n_use_range", 0) != 0;
                                this.m = optJSONObject.optInt("n_install_type", 0) == 0;
                                this.n = optJSONObject.optInt("n_fail_install_type", 0) == 0;
                                if (optJSONObject.optInt("n_pop_grant_win", 0) != 0) {
                                    z = false;
                                }
                                this.o = z;
                            }
                            str2 = "deeplink intent param, deeplink=" + this.f9428c + ", failedLink=" + this.f9430e + ", failedAction=" + this.f9429d + ", targetPkgName=" + this.f9431f + ", urlOpenType=" + this.f9432g + ", isForNewUser= " + this.f9433h + ", canCancel: " + this.k + ", installBySys: " + this.m + ", failInstallByWeb: " + this.n + ", popGrantWin: " + this.o;
                            Logger.d("InAppMessage", str2);
                        }
                        i3 = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = i3;
                }
            }
            return i3;
        } catch (Throwable th3) {
            th = th3;
            i2 = 1302;
        }
    }

    public int b(Context context, DisplayMetrics displayMetrics, int i2) {
        int a2;
        float a3 = a(context, displayMetrics, i2);
        if (a3 >= 0.0f) {
            if (this.x != 0) {
                a2 = k.a(context, (int) a3);
                if (this.F != 1 && a2 < 0) {
                    return !g.a(context, this) ? (i2 == 0 || i2 == 2) ? k.a(context, 10) : a2 : a2;
                }
                if (this.F != 2 && i2 == 1) {
                    boolean z = context.getResources().getConfiguration().orientation == 2;
                    int b2 = g.b(context);
                    return (!z || a2 >= b2) ? a2 : b2;
                }
            }
            a3 *= (i2 == 1 || i2 == 3) ? displayMetrics.heightPixels : displayMetrics.widthPixels;
        }
        a2 = (int) a3;
        if (this.F != 1) {
        }
        return this.F != 2 ? a2 : a2;
    }

    public boolean k() {
        return this.O;
    }

    public int l() {
        return this.u;
    }

    public String m() {
        return this.B;
    }

    public int n() {
        return this.F;
    }

    public boolean o() {
        return this.G != 0;
    }

    public int p() {
        return this.M * 1000;
    }

    public String q() {
        return this.P;
    }

    public String r() {
        return this.W;
    }

    public boolean s() {
        return this.N;
    }

    public cn.jpush.android.d.d t() {
        return this.Y;
    }

    public String toString() {
        return "InAppMessage{appId='" + this.z + "', senderId='" + this.A + "', messageId='" + this.B + "', inAppMsgTitle= '" + this.D + "', inAppMsgContentBody= '" + this.E + "', inAppMsgType= " + this.F + ", inAppMsgShowBackground= " + this.G + ", inAppMsgAllowIntercept= " + this.H + ", inAppMsgFilterMsg= " + this.I + ", inAppMsgCountLmt= " + this.J + ", inAppMsgGap= " + this.K + ", inAppMsgToUser= " + this.L + ", inAppMsgDelayDisplayTime= " + this.M + ", inAppWebPageUrl= '" + this.P + "', inAppProtocolVer= " + this.Q + ", inAppSSPGap= " + this.R + ", inAppTplId= '" + this.U + "', inAppTplUrl= '" + this.V + "', inAppTplData= '" + this.W + "', webWidth=" + this.f9427b + ", deeplink= '" + this.f9428c + "', failedAction=" + this.f9429d + ", failedLink= '" + this.f9430e + "', targetPkgName= '" + this.f9431f + "', urlOpenType=" + this.f9432g + ", sspWxAppId= '" + this.p + "', sspWmOriginId= '" + this.q + "', sspWmType=" + this.r + ", sspWxPath= '" + this.s + "', isWmDeepLink=" + this.t + ", actionType=" + this.u + ", isForNewUser=" + this.f9433h + ", targetAppName=" + this.f9433h + ", targetAppIcon=" + this.f9433h + ", isCanCancel=" + this.k + ", useRange=" + this.l + ", installBySys=" + this.m + ", failInstallByWeb=" + this.n + ", isPopGrantWin=" + this.o + '}';
    }

    public String u() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.z);
            jSONObject.put("senderId", this.A);
            jSONObject.put("messageId", this.B);
            jSONObject.put("inAppMsgTitle", this.D);
            jSONObject.put("inAppMsgContentBody", this.E);
            jSONObject.put("inAppMsgType", this.F);
            jSONObject.put("inAppMsgShowBackground", this.G);
            jSONObject.put("inAppMsgAllowIntercept", this.H);
            jSONObject.put("inAppMsgFilterMsg", this.I);
            jSONObject.put("inAppMsgCountLmt", this.J);
            jSONObject.put("inAppMsgGap", this.K);
            jSONObject.put("inAppMsgToUser", this.L);
            jSONObject.put("inAppMsgDelayDisplayTime", this.M);
            jSONObject.put("isReportPageName", this.N);
            jSONObject.put("isUseSysAlert", this.O);
            jSONObject.put("inAppWebPageUrl", this.P);
            jSONObject.put("inAppProtocolVer", this.Q);
            jSONObject.put("inAppSSPGap", this.Q);
            jSONObject.put("inAppCheckIntent", this.S);
            jSONObject.put("inAppTplContent", this.T);
            jSONObject.put("inAppTplId", this.U);
            jSONObject.put("inAppTplUrl", this.V);
            jSONObject.put("inAppTplData", this.W);
            jSONObject.put("inAppIntentActions", this.X);
            jSONObject.put("webWidth", this.f9427b);
            jSONObject.put("entity", this.Y.c());
            jSONObject.put("deeplink", this.f9428c);
            jSONObject.put("failedAction", this.f9429d);
            jSONObject.put("failedLink", this.f9430e);
            jSONObject.put("targetPkgName", this.f9431f);
            jSONObject.put("urlOpenType", this.f9432g);
            jSONObject.put("isForNewUser", this.f9433h);
            jSONObject.put("targetAppName", this.f9434i);
            jSONObject.put("targetAppIcon", this.j);
            jSONObject.put("isCanCancel", this.k);
            jSONObject.put("useRange", this.l);
            jSONObject.put("installBySys", this.m);
            jSONObject.put("failInstallByWeb", this.n);
            jSONObject.put("isPopGrantWin", this.o);
            jSONObject.put("sspWxAppId", this.p);
            jSONObject.put("sspWmOriginId", this.q);
            jSONObject.put("sspWmType", this.r);
            jSONObject.put("sspWxPath", this.s);
            jSONObject.put("isWmDeepLink", this.t);
            jSONObject.put("actionType", this.u);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
