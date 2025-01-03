package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static Bundle a(Context context, JSONObject jSONObject) {
        cn.jiguang.ar.f.b("JOperateHelper", "setLoginTag");
        return d.a(context, jSONObject);
    }

    public static void a(Context context) {
        cn.jiguang.ar.f.b("JOperateHelper", "init");
        d.a(context, 0L, (String) null);
    }

    public static void a(Context context, long j, String str) {
        cn.jiguang.ar.f.b("JOperateHelper", "register");
    }

    public static Bundle b(Context context, JSONObject jSONObject) {
        cn.jiguang.ar.f.b("JOperateHelper", "setChannel");
        return d.b(context, jSONObject);
    }

    public static void b(Context context) {
        cn.jiguang.ar.f.b("JOperateHelper", "periodTask");
        d.a(context, 0L, (String) null);
    }

    public static void b(Context context, long j, String str) {
        cn.jiguang.ar.f.b("JOperateHelper", "login");
        d.a(context, j, str);
    }
}
