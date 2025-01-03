package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements Serializable {
    public static HashMap<String, String> bH = new HashMap<>();
    public static Map<String, String> bI = new HashMap();
    public static HashMap<String, String> bJ = new HashMap<>();
    public static final long serialVersionUID = 8407025843324043625L;
    public String A;
    public int B;
    public String C;
    public String D;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public int M;
    public String N;
    public String O;
    public int Q;
    public String R;
    public String S;
    public int T;
    public String W;
    public String X;
    public String Y;
    public int Z;
    public int ab;
    public Integer ag;
    public String ah;
    public long ai;
    public String aj;
    public boolean ak;
    public boolean al;
    public long am;
    public String ap;
    public String aq;
    public String ar;
    public String as;
    public String at;
    public String au;
    public int av;
    public int aw;

    /* renamed from: b, reason: collision with root package name */
    public String f9698b;
    public int bA;
    public int bB;
    public int bC;
    public String bG;
    public String be;
    public int bq;
    public int br;
    public boolean bs;
    public boolean bt;
    public String bu;
    public String bv;
    public String bx;

    /* renamed from: c, reason: collision with root package name */
    public String f9699c;

    /* renamed from: d, reason: collision with root package name */
    public String f9700d;

    /* renamed from: e, reason: collision with root package name */
    public int f9701e;

    /* renamed from: f, reason: collision with root package name */
    public int f9702f;

    /* renamed from: g, reason: collision with root package name */
    public String f9703g;

    /* renamed from: h, reason: collision with root package name */
    public String f9704h;

    /* renamed from: i, reason: collision with root package name */
    public String f9705i;
    public int j;
    public boolean k;
    public int l;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public boolean s;
    public int t;
    public String u;
    public String v;
    public String w;
    public int x;
    public String y;
    public String z;

    /* renamed from: a, reason: collision with root package name */
    public int f9697a = -1;
    public int m = 0;
    public int E = -1;
    public String F = "";
    public int P = 0;
    public boolean U = false;
    public boolean V = false;
    public int aa = 0;
    public ArrayList<String> ac = new ArrayList<>();
    public String ad = "";
    public String ae = "";
    public byte af = 0;
    public double an = 200.0d;
    public double ao = 200.0d;
    public String ax = "";
    public String ay = "";
    public String az = "";
    public String aA = "";
    public String aB = "";
    public int aC = 1;
    public int aD = 2;
    public int aE = 0;
    public int aF = 0;
    public int aG = 0;
    public int aH = 0;
    public int aI = 1;
    public int aJ = 0;
    public String aK = "";
    public int aL = 0;
    public long aM = 0;
    public int aN = 0;
    public int aO = 0;
    public int aP = 0;
    public int aQ = 1;
    public int aR = 1;
    public String aS = "#FFFFFFFF";
    public String aT = "#FF000000";
    public String aU = "#FF000000";
    public int aV = 14;
    public int aW = 14;
    public int aX = 9;
    public int aY = 5;
    public float aZ = 1.0f;
    public float ba = 1.0f;
    public String bb = "";
    public int bc = 2;
    public int bd = 2;
    public String bf = "";
    public String bg = "";
    public float bh = 0.6f;
    public String bi = "";
    public String bj = "";
    public ArrayList<String> bk = new ArrayList<>();
    public int bl = 0;
    public int bm = 180;
    public int bn = 0;
    public int bo = 0;
    public String bp = "";
    public String bw = "";
    public String by = "";
    public ArrayList<Float> bz = new ArrayList<>();
    public int bD = 0;
    public int bE = 0;
    public float bF = -1.0f;

    public static d a(Context context, d dVar) {
        try {
            JSONObject optJSONObject = new JSONObject(dVar.f9705i).optJSONObject("inapp");
            if (optJSONObject == null) {
                return null;
            }
            dVar.a(context);
            dVar.aA = dVar.u;
            dVar.aB = dVar.w;
            dVar.aO = optJSONObject.optInt("inapp_delay_display_time", 10);
            dVar.bg = optJSONObject.optString("inapp_h5_tpl_url", "");
            dVar.br = optJSONObject.optInt("inapp_priority", 2);
            dVar.bs = optJSONObject.optInt("inapp_display_direct", 0) == 1;
            dVar.aE = optJSONObject.optInt("inapp_show_pos", 0);
            dVar.aY = optJSONObject.optInt("inapp_show_threshold_time", 5);
            String str = dVar.J;
            if (!TextUtils.isEmpty(str)) {
                dVar.bk.add(str);
            }
            dVar.au = optJSONObject.optString("inapp_end_time", "");
            dVar.av = optJSONObject.optInt("inapp_max_cache_numb", 10);
            dVar.aN = optJSONObject.optInt("inapp_msg_to_user", 1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("in_title", dVar.aA);
            jSONObject.put("in_body_content", dVar.aB);
            jSONObject.put("in_pic_path1", str);
            dVar.bi = jSONObject.toString();
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static d a(Context context, String str, String str2) {
        String str3;
        d dVar = new d();
        byte b2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("_jmsgid_");
            dVar.f9700d = optString;
            if (optString.isEmpty()) {
                dVar.f9700d = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            dVar.f9703g = a(dVar.f9700d, jSONObject);
            dVar.af = (byte) jSONObject.optInt("rom_type");
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                dVar.w = optJSONObject.optString("n_content");
                dVar.u = optJSONObject.optString("n_title");
                dVar.D = optJSONObject.optString("n_extras");
                dVar.F = optJSONObject.optString("n_channel_id");
                dVar.G = optJSONObject.optString("n_display_foreground");
                dVar.E = optJSONObject.optInt("n_alert_type");
                dVar.B = optJSONObject.optInt("n_priority");
                dVar.G = optJSONObject.optString("n_display_foreground");
                dVar.ar = optJSONObject.optString("n_sound");
                dVar.t = optJSONObject.optInt("n_flag", 1);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    dVar.V = true;
                    dVar.a(optJSONObject2);
                    dVar.j = 3;
                } else {
                    dVar.j = 4;
                    dVar.aa = -1;
                }
            } else {
                dVar.w = jSONObject.optString("n_content");
                dVar.u = jSONObject.optString("n_title");
                dVar.D = jSONObject.optString("n_extras");
                dVar.F = jSONObject.optString("n_channel_id");
                dVar.G = jSONObject.optString("n_display_foreground");
                dVar.E = jSONObject.optInt("n_alert_type");
                dVar.B = jSONObject.optInt("n_priority");
                dVar.G = jSONObject.optString("n_display_foreground");
                dVar.af = (byte) jSONObject.optInt("rom_type");
                dVar.f9704h = jSONObject.optString("override_msg_id");
                dVar.ar = jSONObject.optString("n_sound");
            }
            if (optInt != -1) {
                dVar.j = optInt;
            }
            dVar.r = 0;
            dVar.s = true;
            dVar.f9698b = context.getPackageName();
            return dVar;
        } catch (Throwable th) {
            Logger.e("PushEntity", "parseContent error:" + th);
            if (TextUtils.isEmpty(dVar.f9700d)) {
                str3 = "NO MSGID";
            } else {
                str3 = dVar.f9700d;
                b2 = dVar.af;
            }
            cn.jpush.android.helper.c.a(str3, str2, b2, 996, context);
            return null;
        }
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.f9697a = jSONObject.optInt("msgType", -1);
            dVar.f9698b = jSONObject.optString("appId");
            dVar.f9699c = jSONObject.optString("senderId");
            String optString = jSONObject.optString("messageId");
            dVar.f9700d = optString;
            dVar.f9703g = a(optString, jSONObject);
            dVar.f9701e = jSONObject.optInt("notificationId");
            dVar.f9702f = jSONObject.optInt("messageType");
            dVar.f9704h = jSONObject.optString("overrideMessageId");
            dVar.f9705i = jSONObject.optString("originalMessage");
            dVar.j = jSONObject.optInt("messageVersion");
            dVar.k = jSONObject.optBoolean("notificationOnly");
            dVar.l = jSONObject.optInt("notificationBuilderId");
            dVar.m = jSONObject.optInt("notificationType");
            dVar.n = jSONObject.optString("message");
            dVar.o = jSONObject.optString("contentType");
            dVar.p = jSONObject.optString("title");
            dVar.q = jSONObject.optString("extras");
            dVar.r = jSONObject.optInt(ContentCommon.TYPE);
            dVar.s = jSONObject.optBoolean("isFullScreen");
            dVar.t = jSONObject.optInt("notificationRemoveMode");
            dVar.u = jSONObject.optString("notificationTitle");
            dVar.v = jSONObject.optString("notificationAppName");
            dVar.w = jSONObject.optString("notificationContent");
            dVar.x = jSONObject.optInt("notificationStyle");
            dVar.y = jSONObject.optString("notificationBigText");
            dVar.z = jSONObject.optString("notificationBigPicPath");
            dVar.A = jSONObject.optString("notificationInbox");
            dVar.B = jSONObject.optInt("notificationPriority");
            dVar.C = jSONObject.optString("notificationCategory");
            dVar.D = jSONObject.optString("notificationExtra");
            dVar.E = jSONObject.optInt("notificationAlertType");
            dVar.F = jSONObject.optString("notificationChannelId");
            dVar.G = jSONObject.optString("displayForeground");
            dVar.H = jSONObject.optString("source");
            dVar.I = jSONObject.optString("smallIcon");
            dVar.J = jSONObject.optString("largeIcon");
            dVar.K = jSONObject.optString("normalSmallIcon");
            dVar.L = jSONObject.optString("deeplink");
            dVar.M = jSONObject.optInt("failedAction");
            dVar.N = jSONObject.optString("failedLink");
            dVar.O = jSONObject.optString("targetPkgName");
            dVar.Q = jSONObject.optInt("deeplinkBuilderId");
            dVar.V = jSONObject.optBoolean("isRichPush");
            dVar.W = jSONObject.optString("showUrl");
            dVar.X = jSONObject.optString("showTitle");
            dVar.Y = jSONObject.optString("_webPagePath");
            dVar.Z = jSONObject.optInt("jumpMode");
            dVar.aa = jSONObject.optInt("richType");
            dVar.ab = jSONObject.optInt("showMode");
            try {
                String optString2 = jSONObject.optString("showResourceList");
                if (!TextUtils.isEmpty(optString2)) {
                    dVar.ac = new ArrayList<>(Arrays.asList(optString2.split(",")));
                }
            } catch (Throwable th) {
                Logger.e("PushEntity", "showResourceList e:" + th);
            }
            dVar.ad = jSONObject.optString("fromNum");
            dVar.ae = jSONObject.optString("toNum");
            dVar.af = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_PLATFORM);
            if (jSONObject.has("badgeAddNum")) {
                dVar.ag = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.ah = jSONObject.optString("geofenceid");
            dVar.ai = jSONObject.optLong("radius");
            dVar.aj = jSONObject.optString("status");
            dVar.ak = jSONObject.optBoolean("repeat");
            dVar.al = jSONObject.optBoolean("hasShow");
            dVar.am = jSONObject.optLong("expiration");
            dVar.an = jSONObject.optDouble("longitude");
            dVar.ao = jSONObject.optDouble("latitude");
            dVar.ap = jSONObject.optString("lastGeoStatus");
            dVar.aq = jSONObject.optString("developerArg0");
            dVar.ar = jSONObject.optString("sound");
            dVar.as = jSONObject.optString("showBeginTime");
            dVar.at = jSONObject.optString("showEndTime");
            dVar.U = jSONObject.optBoolean("isWmDeepLink");
            dVar.R = jSONObject.optString("wxAppId");
            dVar.S = jSONObject.optString("miniOriginid");
            dVar.T = jSONObject.optInt("miniType");
            dVar.az = jSONObject.optString("inAppMsgContent");
            dVar.ay = jSONObject.optString("inAppIntent");
            dVar.aA = jSONObject.optString("inAppMsgTitle");
            dVar.aB = jSONObject.optString("inAppMsgContentBody");
            dVar.aC = jSONObject.optInt("inAppMsgType");
            dVar.aD = jSONObject.optInt("inAppMsgShowType");
            dVar.aE = jSONObject.optInt("inAppMsgShowPos");
            dVar.aF = jSONObject.optInt("inAppMsgShowAniAction");
            dVar.bn = jSONObject.optInt("inSupportNotifyAni");
            dVar.bo = jSONObject.optInt("inSupportVibration");
            dVar.bp = jSONObject.optString("inAppIcon");
            dVar.aG = jSONObject.optInt("inAppMsgDismissAniAction");
            dVar.aH = jSONObject.optInt("inAppMsgShowBackground");
            dVar.aI = jSONObject.optInt("inAppMsgAllowIntercept");
            dVar.aJ = jSONObject.optInt("inAppMsgFilterMsg");
            dVar.aK = jSONObject.optString("inAppMsgPicPath");
            dVar.aL = jSONObject.optInt("inAppMsgCountLmt");
            dVar.aM = jSONObject.optInt("inAppMsgGap");
            dVar.aN = jSONObject.optInt("inAppMsgToUser");
            dVar.aO = jSONObject.optInt("inAppMsgDelayDisplayTime");
            dVar.aP = jSONObject.optInt("inAppMsgPageDelayDisplayTime");
            dVar.aQ = jSONObject.optInt("inAppMsgReportPageName");
            dVar.aR = jSONObject.optInt("inAppUseSysAlert");
            dVar.aS = jSONObject.optString("inAppMsgBackgroundColor");
            dVar.aT = jSONObject.optString("inAppMsgTitleColor");
            dVar.aU = jSONObject.optString("inAppMsgContentColor");
            dVar.aV = jSONObject.optInt("inAppMsgTitleSize");
            dVar.aW = jSONObject.optInt("inAppMsgContentSize");
            dVar.aX = jSONObject.optInt("inAppMsgCircularSize");
            dVar.aY = jSONObject.optInt("inAppMsgShowTime");
            dVar.aZ = (float) jSONObject.optDouble("inAppMsgShowElapseTime");
            dVar.ba = (float) jSONObject.optDouble("inAppMsgDismissElapseTime");
            dVar.bb = jSONObject.optString("inAppWebPageUrl");
            dVar.bc = jSONObject.optInt("inAppProtocolVer");
            dVar.bm = jSONObject.optInt("inAppSSPGap");
            dVar.bd = jSONObject.optInt("inAppCheckIntent");
            dVar.be = jSONObject.optString("inAppTplContent");
            dVar.bf = jSONObject.optString("inAppTplId");
            dVar.bg = jSONObject.optString("inAppTplUrl");
            dVar.bh = (float) jSONObject.optDouble("inAppMarginY");
            dVar.bi = jSONObject.optString("inAppTplData");
            dVar.bj = jSONObject.optString("inAppIntentActions");
            dVar.bq = jSONObject.optInt("inAppType");
            dVar.au = jSONObject.optString("notifyInAppEndTime");
            dVar.av = jSONObject.optInt("notifyInAppCacheNumb");
            dVar.aw = jSONObject.optInt("notifyInAppMsgType");
            dVar.br = jSONObject.optInt("inAppPriority");
            dVar.bs = jSONObject.optBoolean("inAppIsDisplayDirect");
            dVar.bu = jSONObject.optString("inAppBlackConf");
            dVar.bv = jSONObject.optString("inAppAnimatorConf");
            dVar.bw = jSONObject.optString("inAppAdPosition");
            dVar.bx = jSONObject.optString("inAppFragment");
            dVar.by = jSONObject.optString("inAppAdPosId");
            dVar.bA = jSONObject.optInt("inAppCoordinateType");
            dVar.bB = jSONObject.optInt("inAppWinWidth");
            dVar.bC = jSONObject.optInt("inAppWinHeight");
            JSONArray optJSONArray = jSONObject.optJSONArray("inAppShowCoordinate");
            dVar.bz = new ArrayList<>();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    dVar.bz.add(Float.valueOf((float) optJSONArray.getDouble(i2)));
                }
            }
            dVar.bD = jSONObject.optInt("inAppPosMsgCountLmt");
            dVar.bE = jSONObject.optInt("inAppPosMsgGap");
            dVar.bF = (float) jSONObject.optDouble("inAppSizeRatio");
            dVar.ax = jSONObject.optString("sequenceId");
            dVar.bt = jSONObject.optBoolean("inAppFixed");
            try {
                String optString3 = jSONObject.optString("inAppShowResList");
                if (!TextUtils.isEmpty(optString3)) {
                    dVar.bk = new ArrayList<>(Arrays.asList(optString3.split(",")));
                }
            } catch (Throwable th2) {
                Logger.e("PushEntity", "inAppShowResList e:" + th2);
            }
            dVar.bG = jSONObject.optString("unionADExtras");
            return dVar;
        } catch (Throwable th3) {
            Logger.w("PushEntity", "parseJSONString e:" + th3);
            return null;
        }
    }

    public static d a(String str, String str2, String str3, long j) {
        JSONObject jSONObject;
        d dVar;
        d dVar2 = null;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Throwable th) {
            th = th;
        }
        try {
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("_jmsgid_", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = j + "";
            }
            Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + optString);
            dVar.f9700d = optString;
            dVar.f9698b = str2;
            dVar.f9699c = str3;
            dVar.f9703g = a(optString, jSONObject);
            String optString2 = jSONObject.optString("sequence_id", "");
            dVar.ax = optString2;
            b(optString, optString2);
            boolean z = true;
            if (jSONObject.optInt("n_only", 0) != 1) {
                z = false;
            }
            int optInt = z ? jSONObject.optInt("n_builder_id", 0) : 0;
            dVar.k = z;
            dVar.l = optInt;
            dVar.f9705i = str;
            dVar.j = jSONObject.optInt("show_type", 3);
            dVar.m = jSONObject.optInt("notificaion_type", 0);
            dVar.f9704h = jSONObject.optString("override_msg_id", "");
            dVar.n = jSONObject.optString("message", "");
            dVar.o = jSONObject.optString("content_type", "");
            dVar.p = jSONObject.optString("title", "");
            dVar.q = jSONObject.optString("extras", "");
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            dVar2 = dVar;
            Logger.w("PushEntity", "processMessage failed:" + th.getMessage());
            return dVar2;
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                String optString = jSONObject.optString("_j_data_", "");
                Logger.d("PushEntity", "parse jdata:" + optString);
                a(str, optString);
                return optString;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(String str, String str2) {
        if (bH == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bH.put(str, str2);
    }

    private void a(JSONObject jSONObject) {
        this.V = true;
        this.W = jSONObject.optString("e_url", "").trim();
        this.X = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.W) && !cn.jpush.android.bm.a.c(this.W)) {
            this.W = JPushConstants.HTTPS_PRE + this.W;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.W);
        }
        this.aa = jSONObject.optInt("e_rich_type", 0);
        this.Z = jSONObject.optInt("e_jump_mode", 0);
        this.ab = jSONObject.optInt("e_show", 0);
        int i2 = this.aa;
        if (3 == i2 || 2 == i2 || 1 == i2) {
            this.ac = k.a(jSONObject.optJSONArray("e_eres"));
        }
        this.ad = jSONObject.optString("from_num", "");
        this.ae = jSONObject.optString("to_num", "");
    }

    public static String b(String str) {
        HashMap<String, String> hashMap = bH;
        return hashMap != null ? hashMap.get(str) : "";
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bI.put(str, str2);
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? bI.get(str) : "";
    }

    public static void c(String str, String str2) {
        if (bJ == null || TextUtils.isEmpty(str)) {
            return;
        }
        bJ.put(str, str2);
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
                String readLine = lineNumberReader.readLine();
                String readLine2 = lineNumberReader.readLine();
                if (readLine == null) {
                    Logger.e("PushEntity", "NO appId");
                    return null;
                }
                if (readLine2 == null) {
                    Logger.e("PushEntity", "NO senderId");
                    return null;
                }
                int length = readLine.length() + readLine2.length() + 2;
                if (str.length() <= length + 1) {
                    Logger.d("PushEntity", "No msgContent");
                    return null;
                }
                String optString = new JSONObject(str.substring(length)).optString("_j_data_", "");
                Logger.d("PushEntity", "get jdata from push msg:" + optString);
                return optString;
            } catch (Throwable th) {
                Logger.d("PushEntity", "get jdata from push msg error:" + th.getMessage());
            }
        }
        return null;
    }

    public a a() {
        return new a(this);
    }

    public void a(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(this.f9705i).optJSONObject("m_content");
            int optInt = optJSONObject.optInt("ad_t", 0);
            this.r = optInt;
            if (optInt != 0) {
                return;
            }
            this.s = optJSONObject.optInt("full_screen", 0) >= 1;
            this.t = optJSONObject.optInt("n_flag", 1);
            this.u = optJSONObject.optString("n_title", "");
            this.v = optJSONObject.optString("n_app_name", "");
            this.w = optJSONObject.optString("n_content", "");
            this.x = optJSONObject.optInt("n_style", 0);
            this.y = optJSONObject.optString("n_big_text", "");
            this.z = optJSONObject.optString("n_big_pic_path", "");
            this.A = optJSONObject.optString("n_inbox", "");
            this.D = optJSONObject.optString("n_extras", "");
            this.B = optJSONObject.optInt("n_priority", 0);
            this.C = optJSONObject.optString("n_category", "");
            this.E = optJSONObject.optInt("n_alert_type", -1);
            this.F = optJSONObject.optString("n_channel_id");
            this.G = optJSONObject.optString("n_display_foreground");
            this.I = optJSONObject.optString("n_small_icon", "");
            this.J = optJSONObject.optString("n_large_icon", "");
            this.H = optJSONObject.optString("n_source", "");
            this.K = optJSONObject.optString("n_small_icon_uri", "");
            this.ay = optJSONObject.optString("n_intent");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            if (optJSONObject2 != null) {
                this.L = optJSONObject2.optString("n_url", "");
                this.M = optJSONObject2.optInt("n_fail_handle_type", 0);
                this.N = optJSONObject2.optString("n_fail_handle_url", "");
                this.O = optJSONObject2.optString("n_package_name", "");
                this.Q = optJSONObject2.optInt("n_builder_id", 0);
                this.R = optJSONObject2.optString("wx_app_id", "");
                this.S = optJSONObject2.optString("mini_originid", "");
                this.T = optJSONObject2.optInt("mini_type", 0);
            }
            if (TextUtils.isEmpty(this.u)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.u = cn.jpush.android.bm.a.b(context);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ad_content");
            if (!optJSONObject.isNull("ad_content") && optJSONObject3 != null) {
                a(optJSONObject3);
            }
            if (optJSONObject.has("n_badge_add_num")) {
                this.ag = Integer.valueOf(optJSONObject.optInt("n_badge_add_num"));
            } else {
                this.ag = null;
            }
            this.ar = optJSONObject.optString("n_sound");
            this.as = optJSONObject.optString("n_show_begin_time");
            this.at = optJSONObject.optString("n_show_end_time");
        } catch (Throwable th) {
            Logger.ww("PushEntity", "parse notification failed:" + th.getMessage());
        }
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.f9699c;
        notificationMessage.msgId = this.f9700d;
        notificationMessage.notificationAlertType = this.E;
        notificationMessage.notificationBigPicPath = this.z;
        notificationMessage.notificationBigText = this.y;
        notificationMessage.notificationBuilderId = this.l;
        notificationMessage.notificationCategory = this.C;
        notificationMessage.notificationContent = this.w;
        notificationMessage.notificationExtras = this.D;
        notificationMessage.notificationId = this.f9701e;
        notificationMessage.notificationInbox = this.A;
        notificationMessage.notificationLargeIcon = this.J;
        notificationMessage.notificationPriority = this.B;
        notificationMessage.notificationSmallIcon = this.I;
        notificationMessage.notificationStyle = this.x;
        notificationMessage.notificationTitle = this.u;
        notificationMessage.appId = this.f9698b;
        notificationMessage.notificationType = this.m;
        notificationMessage.developerArg0 = this.aq;
        notificationMessage.notificationChannelId = this.F;
        notificationMessage.isRichPush = this.V;
        notificationMessage.richType = this.aa;
        notificationMessage._webPagePath = this.Y;
        notificationMessage.showResourceList = this.ac;
        notificationMessage.platform = this.af;
        try {
            notificationMessage.deeplink = this.L;
            notificationMessage.failedAction = this.M;
            notificationMessage.failedLink = this.N;
            notificationMessage.targetPkgName = this.O;
            notificationMessage.displayForeground = this.G;
            notificationMessage.sspWxAppId = this.R;
            notificationMessage.sspWmOriginId = this.S;
            notificationMessage.sspWmType = this.T;
            notificationMessage.isWmDeepLink = this.U;
            notificationMessage.inAppMsgTitle = this.aA;
            notificationMessage.inAppMsgContentBody = this.aB;
            notificationMessage.inAppMsgType = this.aC;
            notificationMessage.inAppMsgShowType = this.aD;
            notificationMessage.inAppMsgShowPos = this.aE;
            notificationMessage.inAppType = this.bq;
            if (JPushConstants.SDK_VERSION_CODE >= 408) {
                notificationMessage.notificationNormalSmallIcon = this.K;
            }
        } catch (Throwable th) {
            Logger.w("PushEntity", "pushEntry toNotificationMessage error" + th.getMessage());
        }
        return notificationMessage;
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", this.f9697a);
            jSONObject.put("appId", this.f9698b);
            jSONObject.put("senderId", this.f9699c);
            jSONObject.put("messageId", this.f9700d);
            jSONObject.put("_j_data_", this.f9703g);
            jSONObject.put("notificationId", this.f9701e);
            jSONObject.put("messageType", this.f9702f);
            jSONObject.put("overrideMessageId", this.f9704h);
            jSONObject.put("messageVersion", this.j);
            jSONObject.put("notificationOnly", this.k);
            jSONObject.put("notificationBuilderId", this.l);
            jSONObject.put("notificationType", this.m);
            jSONObject.put("message", this.n);
            jSONObject.put("originalMessage", this.f9705i);
            jSONObject.put("contentType", this.o);
            jSONObject.put("title", this.p);
            jSONObject.put("extras", this.q);
            jSONObject.put(ContentCommon.TYPE, this.r);
            jSONObject.put("isFullScreen", this.s);
            jSONObject.put("notificationRemoveMode", this.t);
            jSONObject.put("notificationTitle", this.u);
            jSONObject.put("notificationAppName", this.v);
            jSONObject.put("notificationContent", this.w);
            jSONObject.put("notificationStyle", this.x);
            jSONObject.put("notificationBigText", this.y);
            jSONObject.put("notificationBigPicPath", this.z);
            jSONObject.put("notificationInbox", this.A);
            jSONObject.put("notificationPriority", this.B);
            jSONObject.put("notificationCategory", this.C);
            jSONObject.put("notificationExtra", this.D);
            jSONObject.put("notificationAlertType", this.E);
            jSONObject.put("notificationChannelId", this.F);
            jSONObject.put("displayForeground", this.G);
            jSONObject.put("source", this.H);
            jSONObject.put("smallIcon", this.I);
            jSONObject.put("largeIcon", this.J);
            jSONObject.put("normalSmallIcon", this.K);
            jSONObject.put("deeplink", this.L);
            jSONObject.put("failedAction", this.M);
            jSONObject.put("failedLink", this.N);
            jSONObject.put("targetPkgName", this.O);
            jSONObject.put("deeplinkBuilderId", this.Q);
            jSONObject.put("isRichPush", this.V);
            jSONObject.put("showUrl", this.W);
            jSONObject.put("showTitle", this.X);
            jSONObject.put("_webPagePath", this.Y);
            jSONObject.put("jumpMode", this.Z);
            jSONObject.put("richType", this.aa);
            jSONObject.put("showMode", this.ab);
            jSONObject.put("showResourceList", k.a(this.ac, ","));
            jSONObject.put("fromNum", this.ad);
            jSONObject.put("toNum", this.ae);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, (int) this.af);
            jSONObject.put("badgeAddNum", this.ag);
            jSONObject.put("geofenceid", this.ah);
            jSONObject.put("radius", this.ai);
            jSONObject.put("status", this.aj);
            jSONObject.put("repeat", this.ak);
            jSONObject.put("hasShow", this.al);
            jSONObject.put("expiration", this.am);
            jSONObject.put("longitude", this.an);
            jSONObject.put("latitude", this.ao);
            jSONObject.put("lastGeoStatus", this.ap);
            jSONObject.put("developerArg0", this.aq);
            jSONObject.put("sound", this.ar);
            jSONObject.put("showBeginTime", this.as);
            jSONObject.put("showEndTime", this.at);
            jSONObject.put("isWmDeepLink", this.U);
            jSONObject.put("wxAppId", this.R);
            jSONObject.put("miniOriginid", this.S);
            jSONObject.put("miniType", this.T);
            jSONObject.put("inAppMsgContent", this.az);
            jSONObject.put("inAppIntent", this.ay);
            jSONObject.put("inAppMsgTitle", this.aA);
            jSONObject.put("inAppMsgContentBody", this.aB);
            jSONObject.put("inAppMsgType", this.aC);
            jSONObject.put("inAppMsgShowType", this.aD);
            jSONObject.put("inAppMsgShowPos", this.aE);
            jSONObject.put("inAppMsgShowAniAction", this.aF);
            jSONObject.put("inSupportNotifyAni", this.bn);
            jSONObject.put("inSupportVibration", this.bo);
            jSONObject.put("inAppIcon", this.bp);
            jSONObject.put("inAppMsgDismissAniAction", this.aG);
            jSONObject.put("inAppMsgShowBackground", this.aH);
            jSONObject.put("inAppMsgAllowIntercept", this.aI);
            jSONObject.put("inAppMsgFilterMsg", this.aJ);
            jSONObject.put("inAppMsgPicPath", this.aK);
            jSONObject.put("inAppMsgCountLmt", this.aL);
            jSONObject.put("inAppMsgGap", this.aM);
            jSONObject.put("inAppMsgToUser", this.aN);
            jSONObject.put("inAppMsgDelayDisplayTime", this.aO);
            jSONObject.put("inAppMsgPageDelayDisplayTime", this.aP);
            jSONObject.put("inAppMsgReportPageName", this.aQ);
            jSONObject.put("inAppUseSysAlert", this.aR);
            jSONObject.put("inAppMsgBackgroundColor", this.aS);
            jSONObject.put("inAppMsgTitleColor", this.aT);
            jSONObject.put("inAppMsgContentColor", this.aU);
            jSONObject.put("inAppMsgTitleSize", this.aV);
            jSONObject.put("inAppMsgContentSize", this.aW);
            jSONObject.put("inAppMsgCircularSize", this.aX);
            jSONObject.put("inAppMsgShowTime", this.aY);
            jSONObject.put("inAppMsgShowElapseTime", this.aZ);
            jSONObject.put("inAppMsgDismissElapseTime", this.ba);
            jSONObject.put("inAppWebPageUrl", this.bb);
            jSONObject.put("inAppProtocolVer", this.bc);
            jSONObject.put("inAppSSPGap", this.bm);
            jSONObject.put("inAppCheckIntent", this.bd);
            jSONObject.put("inAppTplContent", this.be);
            jSONObject.put("inAppTplId", this.bf);
            jSONObject.put("inAppTplUrl", this.bg);
            jSONObject.put("inAppMarginY", this.bh);
            jSONObject.put("inAppTplData", this.bi);
            jSONObject.put("inAppIntentActions", this.bj);
            jSONObject.put("inAppShowResList", k.a(this.bk, ","));
            jSONObject.put("inAppType", this.bq);
            jSONObject.put("notifyInAppEndTime", this.au);
            jSONObject.put("notifyInAppCacheNumb", this.av);
            jSONObject.put("notifyInAppMsgType", this.aw);
            jSONObject.put("inAppPriority", this.br);
            jSONObject.put("inAppIsDisplayDirect", this.bs);
            jSONObject.put("inAppFixed", this.bt);
            jSONObject.put("inAppBlackConf", this.bu);
            jSONObject.put("inAppAnimatorConf", this.bv);
            jSONObject.put("inAppAdPosition", this.bw);
            jSONObject.put("inAppFragment", this.bx);
            jSONObject.put("inAppAdPosId", this.by);
            jSONObject.put("inAppCoordinateType", this.bA);
            jSONObject.put("inAppWinWidth", this.bB);
            jSONObject.put("inAppWinHeight", this.bC);
            JSONArray jSONArray = new JSONArray();
            Iterator<Float> it = this.bz.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().floatValue());
            }
            jSONObject.put("inAppShowCoordinate", jSONArray);
            jSONObject.put("inAppPosMsgCountLmt", this.bD);
            jSONObject.put("inAppPosMsgGap", this.bE);
            jSONObject.put("inAppSizeRatio", this.bF);
            jSONObject.put("sequenceId", this.ax);
            jSONObject.put("unionADExtras", this.bG);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.f9698b + "', senderId='" + this.f9699c + "', messageId='" + this.f9700d + "', jData='" + this.f9703g + "', notificationId=" + this.f9701e + ", messageType=" + this.f9702f + ", overrideMessageId='" + this.f9704h + "', originalMessage='" + this.f9705i + "', messageVersion=" + this.j + ", notificationOnly=" + this.k + ", notificationBuilderId=" + this.l + ", notificationType=" + this.m + ", message='" + this.n + "', contentType='" + this.o + "', title='" + this.p + "', extras='" + this.q + "', type=" + this.r + ", isFullScreen=" + this.s + ", notificationRemoveMode=" + this.t + ", notificationTitle='" + this.u + "', notificationAppName='" + this.v + "', notificationContent='" + this.w + "', notificationStyle=" + this.x + ", notificationBigText='" + this.y + "', notificationBigPicPath='" + this.z + "', notificationInbox='" + this.A + "', notificationPriority=" + this.B + ", notificationCategory='" + this.C + "', notificationExtra='" + this.D + "', notificationAlertType=" + this.E + ", notificationChannelId='" + this.F + "', displayForeground='" + this.G + "', source='" + this.H + "', smallIcon='" + this.I + "', largeIcon='" + this.J + "', normalSmallIcon='" + this.K + "', deeplink='" + this.L + "', failedAction=" + this.M + ", failedLink='" + this.N + "', targetPkgName='" + this.O + "', deeplinkBuilderId=" + this.Q + ", isRichPush=" + this.V + ", showUrl='" + this.W + "', showTitle='" + this.X + "', _webPagePath='" + this.Y + "', jumpMode=" + this.Z + ", richType=" + this.aa + ", showMode=" + this.ab + ", showResourceList=" + this.ac + ", fromNum='" + this.ad + "', toNum='" + this.ae + "', platform=" + ((int) this.af) + ", badgeAddNum=" + this.ag + ", geofenceid='" + this.ah + "', radius=" + this.ai + ", status='" + this.aj + "', repeat=" + this.ak + ", hasShow=" + this.al + ", expiration=" + this.am + ", longitude=" + this.an + ", latitude=" + this.ao + ", lastGeoStatus='" + this.ap + "', developerArg0='" + this.aq + "', sound='" + this.ar + "', showBeginTime='" + this.as + "', showEndTime='" + this.at + "', inAppMsgContent='" + this.az + "', inAppIntent='" + this.ay + ", inAppWebPageUrl = '" + this.bb + "', inAppProtocolVer = '" + this.bc + "', inAppSSPGap = '" + this.bm + "', inAppCheckIntent = '" + this.bd + "', inAppTplContent = '" + this.be + "', inAppTplId = '" + this.bf + "', inAppTplUrl = '" + this.bg + "', inAppMarginY  = '" + this.bh + "', inAppTplData = '" + this.bi + "', inAppIntentActions = '" + this.bj + "', inAppType= '" + this.bq + "', notifyInAppEndTime= '" + this.au + "', notifyInAppEndTime= '" + this.av + "', notifyInAppMsgType= '" + this.aw + "', inAppPriority= '" + this.br + "', inAppIsDisplayDirect= '" + this.bs + "', inAppFixed= '" + this.bt + "', inAppBlackConf= '" + this.bu + "', inAppAnimatorConf= '" + this.bv + "', inAppAdPosition= '" + this.bw + "', inAppAdPosId= '" + this.by + "', inAppFragment= '" + this.bx + "', inAppShowCoordinate= '" + this.bz + "', inAppCoordinateType= '" + this.bA + "', inAppWinWidth= '" + this.bB + "', inAppWinHeight= '" + this.bC + "', sequenceId= '" + this.ax + "'}";
    }
}
