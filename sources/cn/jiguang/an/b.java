package cn.jiguang.an;

import android.content.Context;
import cn.jiguang.p.g;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f8223a = "";

    /* renamed from: b, reason: collision with root package name */
    public static final String f8224b = cn.jiguang.p.a.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 106, 124, 100, 67, 69, 107, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 86, 43, 39, 119, 97, 64, 65, 110, 105, 125, 116, 31, 83, 109, 105, 98, 100, 67});

    public static long a(long j) {
        Date date = new Date();
        Date date2 = new Date(j);
        date.setHours(date2.getHours());
        date.setMinutes(date2.getMinutes());
        date.setSeconds(date2.getSeconds());
        return (date.getTime() / 1000) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: JSONException -> 0x0330, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0330, blocks: (B:6:0x0016, B:9:0x0020, B:11:0x002a, B:12:0x002d, B:14:0x0037, B:15:0x003a, B:17:0x0044, B:18:0x004c, B:20:0x0056, B:21:0x0059, B:23:0x0063, B:24:0x0066, B:26:0x0070, B:29:0x0078, B:30:0x009d, B:32:0x00a5, B:33:0x00b0, B:36:0x00bb, B:39:0x00d8, B:41:0x00e5, B:43:0x00eb, B:53:0x011b, B:57:0x0141, B:58:0x0148, B:60:0x0155, B:61:0x015d, B:63:0x01be, B:65:0x0145, B:69:0x01cb, B:71:0x01d3, B:72:0x01db, B:74:0x020c, B:75:0x021c, B:77:0x0222, B:79:0x024d, B:81:0x026a, B:82:0x026c, B:84:0x027a, B:86:0x028f, B:87:0x028c, B:90:0x0292, B:91:0x029a, B:93:0x02a0, B:94:0x02b3, B:96:0x02b9, B:99:0x02c5, B:100:0x02c7, B:103:0x02d8, B:106:0x02e9, B:109:0x02f9, B:112:0x0318, B:115:0x0325, B:126:0x00aa, B:132:0x0080, B:133:0x0083), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0155 A[Catch: JSONException -> 0x0330, TryCatch #0 {JSONException -> 0x0330, blocks: (B:6:0x0016, B:9:0x0020, B:11:0x002a, B:12:0x002d, B:14:0x0037, B:15:0x003a, B:17:0x0044, B:18:0x004c, B:20:0x0056, B:21:0x0059, B:23:0x0063, B:24:0x0066, B:26:0x0070, B:29:0x0078, B:30:0x009d, B:32:0x00a5, B:33:0x00b0, B:36:0x00bb, B:39:0x00d8, B:41:0x00e5, B:43:0x00eb, B:53:0x011b, B:57:0x0141, B:58:0x0148, B:60:0x0155, B:61:0x015d, B:63:0x01be, B:65:0x0145, B:69:0x01cb, B:71:0x01d3, B:72:0x01db, B:74:0x020c, B:75:0x021c, B:77:0x0222, B:79:0x024d, B:81:0x026a, B:82:0x026c, B:84:0x027a, B:86:0x028f, B:87:0x028c, B:90:0x0292, B:91:0x029a, B:93:0x02a0, B:94:0x02b3, B:96:0x02b9, B:99:0x02c5, B:100:0x02c7, B:103:0x02d8, B:106:0x02e9, B:109:0x02f9, B:112:0x0318, B:115:0x0325, B:126:0x00aa, B:132:0x0080, B:133:0x0083), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020c A[Catch: JSONException -> 0x0330, TryCatch #0 {JSONException -> 0x0330, blocks: (B:6:0x0016, B:9:0x0020, B:11:0x002a, B:12:0x002d, B:14:0x0037, B:15:0x003a, B:17:0x0044, B:18:0x004c, B:20:0x0056, B:21:0x0059, B:23:0x0063, B:24:0x0066, B:26:0x0070, B:29:0x0078, B:30:0x009d, B:32:0x00a5, B:33:0x00b0, B:36:0x00bb, B:39:0x00d8, B:41:0x00e5, B:43:0x00eb, B:53:0x011b, B:57:0x0141, B:58:0x0148, B:60:0x0155, B:61:0x015d, B:63:0x01be, B:65:0x0145, B:69:0x01cb, B:71:0x01d3, B:72:0x01db, B:74:0x020c, B:75:0x021c, B:77:0x0222, B:79:0x024d, B:81:0x026a, B:82:0x026c, B:84:0x027a, B:86:0x028f, B:87:0x028c, B:90:0x0292, B:91:0x029a, B:93:0x02a0, B:94:0x02b3, B:96:0x02b9, B:99:0x02c5, B:100:0x02c7, B:103:0x02d8, B:106:0x02e9, B:109:0x02f9, B:112:0x0318, B:115:0x0325, B:126:0x00aa, B:132:0x0080, B:133:0x0083), top: B:5:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.am.a a(android.content.Context r28, org.json.JSONObject r29) {
        /*
            Method dump skipped, instructions count: 842
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.b.a(android.content.Context, org.json.JSONObject):cn.jiguang.am.a");
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                int i2 = b2 & ThreadUtils.TYPE_SINGLE;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    public static List<String> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.get(i2).toString());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0534, code lost:
    
        if (r1 == 0) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x04f8, code lost:
    
        if (r1 == 0) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04bc, code lost:
    
        if (r1 == 0) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x047f, code lost:
    
        if (r1 == 0) goto L279;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0518 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0463 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b A[Catch: all -> 0x00c1, JSONException -> 0x00c7, IOException -> 0x00cd, UnsupportedEncodingException -> 0x00d3, TRY_ENTER, TRY_LEAVE, TryCatch #26 {UnsupportedEncodingException -> 0x00d3, IOException -> 0x00cd, JSONException -> 0x00c7, all -> 0x00c1, blocks: (B:34:0x00bb, B:37:0x00e9, B:40:0x00f4, B:43:0x00ff, B:46:0x010a, B:49:0x0115, B:60:0x014b, B:63:0x015c, B:64:0x0165, B:66:0x016b, B:68:0x0175, B:71:0x0189, B:73:0x019b, B:75:0x01a7, B:77:0x01b0, B:79:0x01ba, B:80:0x01c7, B:81:0x01cc, B:84:0x01d4, B:88:0x01e0), top: B:33:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015c A[Catch: all -> 0x00c1, JSONException -> 0x00c7, IOException -> 0x00cd, UnsupportedEncodingException -> 0x00d3, TRY_ENTER, TryCatch #26 {UnsupportedEncodingException -> 0x00d3, IOException -> 0x00cd, JSONException -> 0x00c7, all -> 0x00c1, blocks: (B:34:0x00bb, B:37:0x00e9, B:40:0x00f4, B:43:0x00ff, B:46:0x010a, B:49:0x0115, B:60:0x014b, B:63:0x015c, B:64:0x0165, B:66:0x016b, B:68:0x0175, B:71:0x0189, B:73:0x019b, B:75:0x01a7, B:77:0x01b0, B:79:0x01ba, B:80:0x01c7, B:81:0x01cc, B:84:0x01d4, B:88:0x01e0), top: B:33:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0189 A[Catch: all -> 0x00c1, JSONException -> 0x00c7, IOException -> 0x00cd, UnsupportedEncodingException -> 0x00d3, TRY_ENTER, TryCatch #26 {UnsupportedEncodingException -> 0x00d3, IOException -> 0x00cd, JSONException -> 0x00c7, all -> 0x00c1, blocks: (B:34:0x00bb, B:37:0x00e9, B:40:0x00f4, B:43:0x00ff, B:46:0x010a, B:49:0x0115, B:60:0x014b, B:63:0x015c, B:64:0x0165, B:66:0x016b, B:68:0x0175, B:71:0x0189, B:73:0x019b, B:75:0x01a7, B:77:0x01b0, B:79:0x01ba, B:80:0x01c7, B:81:0x01cc, B:84:0x01d4, B:88:0x01e0), top: B:33:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0256 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0258 A[Catch: all -> 0x0434, JSONException -> 0x0438, IOException -> 0x043c, UnsupportedEncodingException -> 0x0441, TryCatch #22 {UnsupportedEncodingException -> 0x0441, IOException -> 0x043c, JSONException -> 0x0438, all -> 0x0434, blocks: (B:30:0x0086, B:35:0x00db, B:38:0x00ee, B:41:0x00f9, B:44:0x0104, B:47:0x010f, B:50:0x011a, B:61:0x0150, B:69:0x017a, B:90:0x01e5, B:93:0x0258, B:96:0x027c, B:99:0x02a0), top: B:29:0x0086 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v44, types: [cn.jiguang.p.f] */
    /* JADX WARN: Type inference failed for: r2v50, types: [cn.jiguang.p.f] */
    /* JADX WARN: Type inference failed for: r2v56, types: [cn.jiguang.af.a] */
    /* JADX WARN: Type inference failed for: r2v58, types: [cn.jiguang.af.a] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 1379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.b.a(android.content.Context):org.json.JSONObject");
    }

    public static void a(Context context, String str) {
        if (str != null) {
            cn.jiguang.ai.a.a("JWakeConfigHelper", "write wakeConfigJson:" + str);
            cn.jiguang.p.c.a(context, "bwc.catch", str);
        }
    }

    public static cn.jiguang.am.a b(Context context) {
        cn.jiguang.am.a aVar = null;
        try {
            String c2 = cn.jiguang.p.c.c(context, "bwc.catch");
            if (c2 != null) {
                aVar = a(context, new JSONObject(g.a(c2)));
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeConfigHelper", "read config json from cache failed !! error:" + th);
        }
        return aVar == null ? new cn.jiguang.am.a() : aVar;
    }
}
