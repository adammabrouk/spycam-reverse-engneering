package cn.jpush.android.bk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f9611a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9612b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<Long, a> f9613c = new ConcurrentHashMap<>();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9614a;

        /* renamed from: b, reason: collision with root package name */
        public int f9615b;

        /* renamed from: c, reason: collision with root package name */
        public long f9616c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f9617d;

        /* renamed from: e, reason: collision with root package name */
        public String f9618e;

        /* renamed from: f, reason: collision with root package name */
        public int f9619f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f9620g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f9621h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f9622i;

        public a(int i2, int i3, long j, ArrayList<String> arrayList, String str) {
            this.f9622i = 0;
            this.f9614a = i2;
            this.f9615b = i3;
            this.f9616c = j;
            this.f9617d = arrayList;
            if (i2 == 1 && arrayList == null) {
                this.f9617d = new ArrayList<>();
            }
            this.f9618e = str;
            this.f9622i = 1;
        }

        public String toString() {
            return "TagAliasCacheBean{protoType=" + this.f9614a + ", actionType=" + this.f9615b + ", seqID=" + this.f9616c + ", tags=" + this.f9617d + ", alias='" + this.f9618e + "', totalPage=" + this.f9619f + ", currPage=" + this.f9620g + ", retryCount=" + this.f9621h + '}';
        }
    }

    private a a(JSONObject jSONObject, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onUpdateCacheNode,responseJson:" + jSONObject + ",tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), "get")) {
            if (aVar.f9614a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.getString(i2));
                        }
                        if (arrayList.size() > 0) {
                            aVar.f9617d.addAll(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("TagAliasNewProtoRetryHelper", "parse tag list failed - error:" + th);
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    aVar.f9618e = optString;
                }
            }
        }
        return aVar;
    }

    public static b a() {
        if (f9611a == null) {
            synchronized (f9612b) {
                if (f9611a == null) {
                    f9611a = new b();
                }
            }
        }
        return f9611a;
    }

    private boolean a(Context context, int i2, a aVar) {
        int i3;
        Logger.d("TagAliasNewProtoRetryHelper", "action - CheckAndSendAgain, errorCode:" + i2 + ",tagAliasCacheNode:" + aVar);
        if (i2 != 1 || (i3 = aVar.f9621h) != 0) {
            return false;
        }
        aVar.f9621h = i3 + 1;
        if (a(context, aVar.f9614a, aVar.f9616c)) {
            return true;
        }
        return b(context, aVar);
    }

    private boolean a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "tagAlias cache was null";
        } else {
            Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, tagAliasCacheNode:" + aVar);
            if (aVar.f9620g < aVar.f9619f) {
                return true;
            }
            str = "all tags info was loaded";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return false;
    }

    private boolean b(Context context, a aVar) {
        String a2;
        String str;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onSendAgain, tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "onSendAgain - tagAliasCacheNode was null");
            return false;
        }
        int i2 = aVar.f9614a;
        if (i2 == 1) {
            a2 = cn.jpush.android.bk.a.a(context, aVar.f9617d, aVar.f9616c, aVar.f9615b, aVar.f9619f, aVar.f9620g);
        } else {
            if (i2 != 2) {
                Logger.d("TagAliasNewProtoRetryHelper", "unsupport proto type");
                return false;
            }
            a2 = cn.jpush.android.bk.a.a(context, aVar.f9618e, aVar.f9616c, i2);
        }
        if (a2 == null) {
            return false;
        }
        if (aVar.f9621h > 200) {
            this.f9613c.remove(Long.valueOf(aVar.f9616c));
            cn.jpush.android.bk.a.a(context, aVar.f9614a, JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY, aVar.f9616c);
            str = "same tag/alias request times greate than 200";
        } else {
            cn.jpush.android.bk.a.a(context, aVar.f9614a, aVar.f9616c, a2);
            aVar.f9621h++;
            this.f9613c.put(Long.valueOf(aVar.f9616c), aVar);
            str = "send request success";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return true;
    }

    public int a(int i2, int i3) {
        if (i2 == 0) {
            return i3;
        }
        if (i3 == 17) {
            try {
                return JPushInterface.ErrorCode.ERROR_CODE_ALIAS_LIMIT;
            } catch (Throwable unused) {
                return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
            }
        }
        if (i3 == 100) {
            return JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
        }
        switch (i3) {
        }
        return i3;
    }

    public int a(long j) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasTimeOut :" + j);
        a remove = this.f9613c.remove(Long.valueOf(j));
        Logger.d("TagAliasNewProtoRetryHelper", "onTagAliasTimeOut,removed cachenode:" + remove);
        if (remove != null) {
            return remove.f9614a;
        }
        return 0;
    }

    public Intent a(Context context, long j, int i2, JSONObject jSONObject, Intent intent) {
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, seqID:" + j + ",errorCode:" + i2 + ",intent:" + intent);
        a aVar = this.f9613c.get(Long.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f9613c.remove(Long.valueOf(j));
        if (jSONObject == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "responseJson was null");
            return intent;
        }
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        }
        if (!a(context, i2, aVar)) {
            if (i2 != 0) {
                if (i2 == 100) {
                    long optLong = jSONObject.optLong("wait", -1L);
                    Logger.ww("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                    if (optLong > 0) {
                        cn.jpush.android.cache.a.a(context, optLong);
                    }
                }
                int a2 = a(aVar.f9614a, i2);
                intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a2);
                Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a2);
                return intent;
            }
            aVar.f9621h = 0;
            if (aVar.f9615b == 5) {
                aVar.f9619f = jSONObject.optInt("total", -1);
                aVar.f9620g = jSONObject.optInt("curr", -1);
                a(jSONObject, aVar);
            }
            if (a(context, aVar)) {
                aVar.f9620g++;
                Logger.d("TagAliasNewProtoRetryHelper", "load next page, currpage:" + aVar.f9620g + ",totalPage:" + aVar.f9619f);
                if (a(context, aVar.f9614a, aVar.f9616c)) {
                    return null;
                }
                str2 = b(context, aVar) ? "get next page request was sended" : "retry action was sended";
            }
            int i3 = aVar.f9615b;
            if (i3 == 5) {
                int i4 = aVar.f9614a;
                if (i4 == 1) {
                    if (aVar.f9617d.size() > 0) {
                        intent.putStringArrayListExtra("tags", aVar.f9617d);
                    }
                } else if (i4 == 2 && (str = aVar.f9618e) != null) {
                    intent.putExtra("alias", str);
                }
            } else if (i3 == 6) {
                if (aVar.f9614a == 1) {
                    intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                } else {
                    Logger.w("TagAliasNewProtoRetryHelper", "unsupport  proto type");
                }
            }
            return intent;
        }
        Logger.d("TagAliasNewProtoRetryHelper", str2);
        return null;
    }

    public void a(int i2, int i3, long j, ArrayList<String> arrayList, String str) {
        a aVar = new a(i2, i3, j, arrayList, str);
        Logger.d("TagAliasNewProtoRetryHelper", "action - createNewCacheNode, tagAliasCacheNode:" + aVar);
        this.f9613c.put(Long.valueOf(j), aVar);
    }

    public boolean a(int i2) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f9613c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<Long, a>> it = this.f9613c.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null && value.f9614a == i2) {
                return false;
            }
        }
        return true;
    }

    public boolean a(Context context, int i2, long j) {
        if ((i2 != 1 && i2 != 2) || !cn.jpush.android.cache.a.k(context)) {
            return false;
        }
        Logger.w("TagAliasNewProtoRetryHelper", "tag/alias action was freezed");
        cn.jpush.android.bk.a.a(context, i2, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j);
        return true;
    }
}
