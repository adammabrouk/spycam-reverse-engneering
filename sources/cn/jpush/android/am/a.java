package cn.jpush.android.am;

import android.os.Bundle;
import android.text.TextUtils;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class a {
    public static boolean a() {
        Bundle b2 = cn.jpush.android.u.a.b();
        if (b2 == null || !b2.containsKey("mode")) {
            return false;
        }
        String string = b2.getString("mode");
        return !TextUtils.isEmpty(string) && TextUtils.equals(string.toLowerCase(), ContentCommon.SERVER_STRING);
    }
}
