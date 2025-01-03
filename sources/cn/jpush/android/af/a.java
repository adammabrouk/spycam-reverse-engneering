package cn.jpush.android.af;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class a {
    public static int a(Context context, int i2) {
        return context == null ? i2 : (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static DisplayMetrics a(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            int i2 = Build.VERSION.SDK_INT;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (i2 >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
        }
        return displayMetrics;
    }

    public static boolean a(String str) {
        return Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$").matcher(str).matches();
    }
}
