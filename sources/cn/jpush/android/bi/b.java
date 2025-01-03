package cn.jpush.android.bi;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class b {
    public static byte[] a(int i2, byte b2, long j, String str) {
        d dVar = new d(RecyclerView.c0.FLAG_IGNORE);
        dVar.b(i2);
        dVar.a((int) b2);
        dVar.a(j);
        if (!TextUtils.isEmpty(str)) {
            dVar.a(b(str));
        }
        return dVar.a();
    }

    public static byte[] a(int i2, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, String str4) {
        d dVar = new d(RecyclerView.c0.FLAG_IGNORE);
        dVar.a(i2);
        dVar.a(i3);
        dVar.a(i4);
        dVar.a(i5);
        dVar.a(i6);
        dVar.a(i7);
        dVar.a(str);
        dVar.a(str2);
        dVar.a(str3);
        dVar.a(str4);
        return dVar.a();
    }

    public static byte[] a(int i2, String str, String str2, String str3) {
        d dVar = new d(RecyclerView.c0.FLAG_IGNORE);
        dVar.a(i2);
        dVar.a(str);
        dVar.a(str2);
        dVar.a(str3);
        return dVar.a();
    }

    public static byte[] a(String str) {
        d dVar = new d(RecyclerView.c0.FLAG_IGNORE);
        dVar.a(7);
        dVar.a(1);
        dVar.a(str != null ? b(str) : new byte[0]);
        return dVar.a();
    }

    public static byte[] a(String str, byte b2) {
        d dVar = new d(8192);
        dVar.a(TextUtils.isEmpty(str) ? new byte[0] : b(str));
        dVar.a((int) b2);
        return dVar.a();
    }

    public static byte[] a(String str, int i2, String str2) {
        d dVar = new d(8192);
        if (i2 == 10) {
            dVar.a(b(str));
        }
        dVar.a(b(str2));
        return dVar.a();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            Logger.ee("PushPackage", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static byte[] c(String str) {
        d dVar = new d(8192);
        dVar.a(b(str));
        return dVar.a();
    }
}
