package cn.jpush.android.x;

import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends a {
    public static HashMap<String, String> ar = new HashMap<>();
    public static Map<String, String> as = new HashMap();
    public String J;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f9950a;
    public String aa;
    public String ac;
    public int af;
    public int ag;
    public int ah;

    /* renamed from: b, reason: collision with root package name */
    public String f9951b;

    /* renamed from: c, reason: collision with root package name */
    public String f9952c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9953d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9954e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f9955f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f9956g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f9957h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f9958i = 10;
    public int j = 2;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 1;
    public int p = 0;
    public String q = "";
    public int r = 0;
    public long s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 1;
    public int w = 1;
    public String x = "#FFFFFFFF";
    public String y = "#FF000000";
    public String z = "#FF000000";
    public int A = 14;
    public int B = 14;
    public int C = 9;
    public int D = 5;
    public float E = 0.5f;
    public float F = 0.5f;
    public String G = "";
    public int H = 2;
    public int I = 2;
    public String K = "";
    public String L = "";
    public float M = 0.6f;
    public String N = "";
    public String O = "";
    public ArrayList<String> P = new ArrayList<>();
    public int Q = 0;
    public int R = 180;
    public int S = 0;
    public int T = 0;
    public String U = "";
    public String ab = "";
    public String ad = "";
    public ArrayList<Float> ae = new ArrayList<>();
    public int ai = 0;
    public int aj = 0;
    public float ak = -1.0f;
    public String al = "";
    public int am = 0;
    public int an = 3600;
    public int ao = 1;
    public int ap = 0;
    public int aq = 1;

    public static cn.jpush.android.d.d a(String str, String str2, String str3, long j) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        String str4 = "NO MSGID";
        cn.jpush.android.d.d dVar = null;
        try {
            cn.jpush.android.r.b.b("JUnionAdInappEntity", "parse in app message, data: " + str);
            JSONObject jSONObject = new JSONObject(str);
            cn.jpush.android.d.d dVar2 = new cn.jpush.android.d.d();
            String optString = jSONObject.optString("ad_id", "");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("_jmsgid_", "");
            }
            str4 = TextUtils.isEmpty(optString) ? j + "" : optString;
            dVar2.f9700d = str4;
            dVar2.f9698b = str2;
            dVar2.f9699c = str3;
            String optString2 = jSONObject.optString("sequence_id", "");
            dVar2.ax = optString2;
            b(str4, optString2);
            dVar2.az = jSONObject.optString("in_content");
            JSONObject jSONObject2 = new JSONObject(dVar2.az);
            dVar2.aH = jSONObject2.optInt("in_show_background", 0);
            dVar2.aI = jSONObject2.optInt("in_allow_intercept", 1);
            dVar2.aJ = jSONObject2.optInt("in_filter_msg", 0);
            dVar2.aL = jSONObject2.optInt("in_msgcount_limit", 5);
            dVar2.aM = jSONObject2.optLong("in_msg_gap", 1800L);
            dVar2.aN = jSONObject2.optInt("in_msg_to_user", 0);
            dVar2.aO = jSONObject2.optInt("in_delay_display_time", 0);
            dVar2.aP = jSONObject2.optInt("page_delay_display_time", 0);
            dVar2.aQ = jSONObject2.optInt("in_report_page_name", 1);
            dVar2.aR = jSONObject2.optInt("in_use_sys_alert", 1);
            dVar2.bc = jSONObject2.optInt("in_protocol_ver", 0);
            dVar2.bd = jSONObject2.optInt("in_check_intent_action", 0);
            dVar2.bm = jSONObject2.optInt("in_ssp_gap", 180);
            dVar2.bj = jSONObject2.optString("in_intent_actions", "");
            dVar2.be = jSONObject2.optString("in_template_content", "");
            dVar2.br = jSONObject2.optInt("in_priority", 3);
            dVar2.bs = jSONObject2.optInt("in_display_direct", 0) == 1;
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("in_template_content");
            if (optJSONObject2 != null) {
                dVar2.aY = optJSONObject2.optInt("ein_show_threshold_time", 5);
                dVar2.aZ = (float) optJSONObject2.optDouble("ein_toshow_threshold_time", 1.0d);
                dVar2.ba = (float) optJSONObject2.optDouble("ein_todismiss_threshold_time", 1.0d);
                int optInt = optJSONObject2.optInt("in_message_type", 1);
                dVar2.aC = optInt;
                dVar2.bt = jSONObject2.optInt("in_msg_fixed", optInt == 1 ? 0 : 1) != 0;
                dVar2.bn = optJSONObject2.optInt("in_support_notify_ani", 0);
                dVar2.bo = optJSONObject2.optInt("in_support_vibration", 0);
                dVar2.aE = optJSONObject2.optInt("in_show_pos", 0);
                dVar2.aF = optJSONObject2.optInt("in_show_ani_action", 0);
                dVar2.aG = optJSONObject2.optInt("in_dismiss_ani_action", 0);
                dVar2.bf = optJSONObject2.optString("in_h5_template_id", "");
                dVar2.bg = optJSONObject2.optString("in_h5_template_url", "");
                dVar2.bi = optJSONObject2.optString("in_h5_template_data", "");
                dVar2.bh = (float) optJSONObject2.optDouble("in_margin_y", 0.6000000238418579d);
                dVar2.bb = dVar2.bg;
                if (Build.VERSION.SDK_INT >= 19 && (optJSONArray = optJSONObject2.optJSONArray("in_show_coordinate")) != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        dVar2.bz.add(Float.valueOf((float) optJSONArray.getDouble(i2)));
                    }
                }
                dVar2.bA = optJSONObject2.optInt("in_coordinate_type");
                dVar2.bB = optJSONObject2.optInt("in_win_width");
                dVar2.bC = optJSONObject2.optInt("in_win_height");
                dVar2.bx = optJSONObject2.optString("in_fragment", "");
                String a2 = a(str4, optJSONObject2);
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split("&");
                    if (split.length > 0) {
                        dVar2.by = split[0];
                        dVar2.bw = split.length > 1 ? split[1] : "";
                    }
                }
                dVar2.bD = optJSONObject2.optInt("in_pos_msgcount_limit", 0);
                dVar2.bE = optJSONObject2.optInt("in_pos_msg_gap", 0);
                dVar2.bF = (float) optJSONObject2.optDouble("in_size_ratio", -1.0d);
                if (!TextUtils.isEmpty(dVar2.bi) && (optJSONObject = optJSONObject2.optJSONObject("in_h5_template_data")) != null) {
                    dVar2.aA = optJSONObject.optString("in_title", "");
                    dVar2.aB = optJSONObject.optString("in_body_content", "");
                    dVar2.bl = optJSONObject.optInt("in_pic_count", 0);
                    int i3 = 0;
                    while (i3 < dVar2.bl) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        i3++;
                        sb.append(i3);
                        String optString3 = optJSONObject.optString(sb.toString(), "");
                        if (!TextUtils.isEmpty(optString3)) {
                            dVar2.bk.add(optString3);
                        }
                    }
                    dVar2.bp = optJSONObject.optString("in_app_icon", "");
                }
                dVar = dVar2;
            } else {
                cn.jpush.android.r.b.f("JUnionAdInappEntity", "in-app message in_template_content json content is null");
                cn.jpush.android.r.b.g("JUnionAdInappEntity", "in-msg tpl content is null");
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdInappEntity", "parse in app message error, " + th.getMessage());
            cn.jpush.android.r.b.g("JUnionAdInappEntity", "parse in-msg failed");
        }
        cn.jpush.android.l.c.a(JPushConstants.mApplicationContext, str4, dVar != null ? 1205 : 1279, 0);
        return dVar;
    }

    public static String a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return "";
        }
        try {
            String optString = jSONObject.optString("in_position", "");
            String optString2 = jSONObject.optString("in_position_id", "");
            cn.jpush.android.r.b.b("JUnionAdInappEntity", "parse ad_pos_name:" + optString + ", ad_pos_id: " + optString2);
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString)) {
                return "";
            }
            String str2 = optString2 + "&" + optString;
            a(str, str2);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<b> a(String str) {
        String str2;
        String str3;
        String str4;
        String optString;
        int optInt;
        JSONArray optJSONArray;
        String str5;
        String str6;
        String str7;
        JSONArray jSONArray;
        String str8;
        String str9;
        int i2;
        String str10;
        JSONObject optJSONObject;
        JSONArray optJSONArray2;
        String str11 = "sequence_id";
        String str12 = "ad_id";
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_id", "");
            boolean isEmpty = TextUtils.isEmpty(optString2);
            str2 = JThirdPlatFormInterface.KEY_MSG_ID;
            if (isEmpty) {
                optString2 = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            }
            str3 = "_jmsgid_";
            if (TextUtils.isEmpty(optString2)) {
                optString2 = jSONObject.optString("_jmsgid_", "");
            }
            str4 = "NO MSGID";
            if (TextUtils.isEmpty(optString2)) {
                String str13 = "NO MSGID";
            }
            optString = jSONObject.optString("sequence_id", "");
            optInt = jSONObject.optInt("render_type", 0);
            optJSONArray = jSONObject.optJSONArray("contents");
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdInappEntity", "parse ad message error, " + th.getMessage());
            cn.jpush.android.r.b.g("JUnionAdInappEntity", "parse ad failed");
        }
        if (optJSONArray == null) {
            cn.jpush.android.r.b.f("JUnionAdInappEntity", "Parse ad data failed for contents is null");
            return null;
        }
        int i3 = 0;
        while (i3 < optJSONArray.length()) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
            if (jSONObject2 == null) {
                cn.jpush.android.r.b.f("JUnionAdInappEntity", "parse contents array occur null object, index: " + i3);
                str7 = str11;
                str5 = str12;
                jSONArray = optJSONArray;
                str8 = str4;
                str9 = str2;
            } else {
                b bVar = new b();
                String optString3 = jSONObject2.optString(str12, "");
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = jSONObject2.optString(str2, "");
                }
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = jSONObject2.optString(str3, "");
                }
                if (TextUtils.isEmpty(optString3)) {
                    str5 = str12;
                    str6 = str4;
                } else {
                    str5 = str12;
                    str6 = optString3;
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject2.optString(str11, "");
                }
                bVar.al = optString;
                bVar.am = optInt;
                bVar.f9950a = str6;
                b(str6, optString);
                str7 = str11;
                bVar.f9953d = jSONObject2.optString("in_content");
                JSONObject jSONObject3 = new JSONObject(bVar.f9953d);
                jSONArray = optJSONArray;
                bVar.n = jSONObject3.optInt("in_show_background", 0);
                bVar.o = jSONObject3.optInt("in_allow_intercept", 1);
                bVar.p = jSONObject3.optInt("in_filter_msg", 0);
                bVar.r = jSONObject3.optInt("in_msgcount_limit", 5);
                str8 = str4;
                str9 = str2;
                bVar.s = jSONObject3.optLong("in_msg_gap", 1800L);
                bVar.t = jSONObject3.optInt("in_msg_to_user", 0);
                bVar.u = jSONObject3.optInt("in_delay_display_time", 0);
                bVar.v = jSONObject3.optInt("in_report_page_name", 1);
                bVar.w = jSONObject3.optInt("in_use_sys_alert", 1);
                bVar.H = jSONObject3.optInt("in_protocol_ver", 0);
                bVar.I = jSONObject3.optInt("in_check_intent_action", 0);
                bVar.R = jSONObject3.optInt("in_ssp_gap", 180);
                bVar.O = jSONObject3.optString("in_intent_actions", "");
                bVar.J = jSONObject3.optString("in_template_content", "");
                bVar.an = jSONObject3.optInt("expire_time", 3600);
                int optInt2 = jSONObject3.optInt("display_check_time", 1);
                bVar.ao = optInt2;
                if (optInt2 == -1) {
                    bVar.ao = 1;
                }
                int optInt3 = jSONObject3.optInt("page_delay_display_time", 0);
                bVar.ap = optInt3;
                if (optInt3 == -1) {
                    bVar.ap = 0;
                }
                bVar.aq = jSONObject3.optInt("in_ssp_ver", 1);
                bVar.W = jSONObject3.optInt("in_priority", 3);
                bVar.X = jSONObject3.optInt("in_display_direct", 0) == 1;
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("in_template_content");
                if (optJSONObject2 == null) {
                    cn.jpush.android.r.b.f("JUnionAdInappEntity", "parse ad message extras conent is null");
                } else {
                    bVar.D = optJSONObject2.optInt("ein_show_threshold_time", 5);
                    i2 = i3;
                    str10 = str3;
                    bVar.E = (float) optJSONObject2.optDouble("ein_toshow_threshold_time", 0.5d);
                    bVar.F = (float) optJSONObject2.optDouble("ein_todismiss_threshold_time", 0.5d);
                    bVar.f9956g = optJSONObject2.optInt("in_message_type", 1);
                    bVar.f9957h = optJSONObject2.optInt("in_style_type", 0);
                    bVar.f9958i = optJSONObject2.optInt("in_style_gap", 10);
                    bVar.Y = jSONObject3.optInt("in_msg_fixed", bVar.f9956g == 1 ? 0 : 1) != 0;
                    bVar.S = optJSONObject2.optInt("in_support_notify_ani", 0);
                    bVar.T = optJSONObject2.optInt("in_support_vibration", 0);
                    bVar.k = optJSONObject2.optInt("in_show_pos", 0);
                    bVar.l = optJSONObject2.optInt("in_show_ani_action", 0);
                    bVar.m = optJSONObject2.optInt("in_dismiss_ani_action", 0);
                    bVar.K = optJSONObject2.optString("in_h5_template_id", "");
                    bVar.L = optJSONObject2.optString("in_h5_template_url", "");
                    bVar.N = optJSONObject2.optString("in_h5_template_data", "");
                    bVar.M = (float) optJSONObject2.optDouble("in_margin_y", 0.6000000238418579d);
                    bVar.G = bVar.L;
                    if (Build.VERSION.SDK_INT >= 19 && (optJSONArray2 = optJSONObject2.optJSONArray("in_show_coordinate")) != null) {
                        for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                            bVar.ae.add(Float.valueOf((float) optJSONArray2.getDouble(i4)));
                        }
                    }
                    bVar.af = optJSONObject2.optInt("in_coordinate_type");
                    bVar.ag = optJSONObject2.optInt("in_win_width");
                    bVar.ah = optJSONObject2.optInt("in_win_height");
                    bVar.ac = optJSONObject2.optString("in_fragment", "");
                    String a2 = a(str6, optJSONObject2);
                    if (!TextUtils.isEmpty(a2)) {
                        String[] split = a2.split("&");
                        if (split.length > 0) {
                            bVar.ad = split[0];
                            bVar.ab = split.length > 1 ? split[1] : "";
                        }
                    }
                    bVar.ai = optJSONObject2.optInt("in_pos_msgcount_limit", 0);
                    bVar.aj = optJSONObject2.optInt("in_pos_msg_gap", 0);
                    bVar.ak = (float) optJSONObject2.optDouble("in_size_ratio", -1.0d);
                    if (!TextUtils.isEmpty(bVar.N) && (optJSONObject = optJSONObject2.optJSONObject("in_h5_template_data")) != null) {
                        bVar.f9954e = optJSONObject.optString("in_title", "");
                        bVar.f9955f = optJSONObject.optString("in_body_content", "");
                        bVar.Q = optJSONObject.optInt("in_pic_count", 0);
                        int i5 = 0;
                        while (i5 < bVar.Q) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("in_pic_path");
                            i5++;
                            sb.append(i5);
                            String optString4 = optJSONObject.optString(sb.toString(), "");
                            if (!TextUtils.isEmpty(optString4)) {
                                bVar.P.add(optString4);
                            }
                        }
                        bVar.U = optJSONObject.optString("in_app_icon", "");
                    }
                    arrayList.add(bVar);
                    cn.jpush.android.l.c.a(cn.jpush.android.u.a.a(), str6, 21010, optString, optInt);
                    i3 = i2 + 1;
                    str11 = str7;
                    str12 = str5;
                    optJSONArray = jSONArray;
                    str2 = str9;
                    str4 = str8;
                    str3 = str10;
                }
            }
            str10 = str3;
            i2 = i3;
            i3 = i2 + 1;
            str11 = str7;
            str12 = str5;
            optJSONArray = jSONArray;
            str2 = str9;
            str4 = str8;
            str3 = str10;
        }
        return arrayList;
    }

    public static void a(String str, String str2) {
        if (ar == null || TextUtils.isEmpty(str)) {
            return;
        }
        cn.jpush.android.d.d.c(str, str2);
        ar.put(str, str2);
    }

    public static String b(String str) {
        HashMap<String, String> hashMap = ar;
        return hashMap != null ? hashMap.get(str) : "";
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        as.put(str, str2);
        cn.jpush.android.d.d.b(str, str2);
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? as.get(str) : "";
    }

    public cn.jpush.android.d.d a() {
        cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
        dVar.f9700d = this.f9950a;
        dVar.ay = this.f9952c;
        dVar.az = this.f9953d;
        dVar.aA = this.f9954e;
        dVar.aB = this.f9955f;
        dVar.aC = this.f9956g;
        dVar.aD = this.j;
        dVar.aE = this.k;
        dVar.aF = this.l;
        dVar.aG = this.m;
        dVar.aH = this.n;
        dVar.aI = this.o;
        dVar.aJ = this.p;
        dVar.aK = this.q;
        dVar.aL = this.r;
        dVar.aM = this.s;
        dVar.aN = this.t;
        dVar.aO = this.u;
        dVar.aQ = this.v;
        dVar.aR = this.w;
        dVar.aY = this.D;
        dVar.aZ = this.E;
        dVar.ba = this.F;
        dVar.bc = this.H;
        dVar.bd = this.I;
        dVar.be = this.J;
        dVar.bf = this.K;
        dVar.bg = this.L;
        dVar.bi = this.N;
        dVar.bj = this.O;
        dVar.bu = this.Z;
        dVar.bv = this.aa;
        dVar.bw = this.ab;
        dVar.bx = this.ac;
        dVar.by = this.ad;
        dVar.bD = this.ai;
        dVar.bE = this.aj;
        dVar.r = 0;
        dVar.ab = 0;
        dVar.s = true;
        return dVar;
    }

    public String toString() {
        return "InAppEntity{, messageId='" + this.f9950a + "', overrideMessageId='" + this.f9951b + "', inAppMsgContent='" + this.f9953d + "', inAppIntent='" + this.f9952c + ", inAppWebPageUrl = '" + this.G + "', inAppProtocolVer = '" + this.H + "', inAppSSPGap = '" + this.R + "', inAppCheckIntent = '" + this.I + "', inAppTplContent = '" + this.J + "', inAppTplId = '" + this.K + "', inAppTplUrl = '" + this.L + "', inAppMarginY  = '" + this.M + "', inAppTplData = '" + this.N + "', inAppIntentActions = '" + this.O + "', inAppType= '" + this.V + "', inAppPriority= '" + this.W + "', inAppIsDisplayDirect= '" + this.X + "', inAppFixed= '" + this.Y + "', inAppBlackConf= '" + this.Z + "', inAppAnimatorConf= '" + this.aa + "', inAppAdPosition= '" + this.ab + "', inAppAdPosId= '" + this.ad + "', inAppFragment= '" + this.ac + "', inAppShowCoordinate= '" + this.ae + "', inAppCoordinateType= '" + this.af + "', inAppWinWidth= '" + this.ag + "', inAppWinHeight= '" + this.ah + "', inAppSizeRatio= '" + this.ak + "', adSequenceId= '" + this.al + "', adRenderType= '" + this.am + "', adExpireTime= '" + this.an + "', adExposureCheckTime= '" + this.ao + "', adPageDelayDisplayTime= '" + this.ap + "', adSspSvrVer= '" + this.aq + "'}";
    }
}
