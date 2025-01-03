package cn.jiguang.ac;

import android.content.Context;
import android.os.Build;
import cn.jiguang.l.d;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e2) {
                cn.jiguang.ai.a.d("IdProvider", "loadClass error, " + e2.getMessage());
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            cn.jiguang.ai.a.d("IdProvider", String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e3.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e3);
        }
    }

    public static String a(Context context) {
        try {
            Class<?> a2 = a(context, d.g("KIHhQylffktk79IAY9r8iabG5YlYSM/WswW6fWtc2r2WbTdKR65l5atPPp2u96wd"));
            Object newInstance = a2.newInstance();
            Method method = a2.getMethod(d.g("Oi3ZFT8+schQHSyFZbsdUg=="), Context.class);
            Method method2 = a2.getMethod(d.g("fIdCW1auJ/CZh7w78TbJVQ=="), Context.class);
            Object invoke = a2.getMethod(d.g("cBEuCuv+AtdlTcgTe9OgSQ=="), Context.class).invoke(newInstance, context);
            Object invoke2 = method2.invoke(newInstance, context);
            Object invoke3 = method.invoke(newInstance, context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("joad", invoke3);
            jSONObject.put("jvad", invoke2);
            jSONObject.put("jaad", invoke);
            return jSONObject.toString();
        } catch (Throwable th) {
            cn.jiguang.ai.a.e("IdProvider", "getIds failed:" + th.getMessage());
            return "";
        }
    }
}
