package c.k.d;

import android.content.ContentValues;
import android.content.Context;
import c.k.d.h1;

/* loaded from: classes.dex */
public class e1 extends h1.e {
    public e1(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
    }

    public static e1 a(Context context, String str, z6 z6Var) {
        byte[] a2 = h8.a(z6Var);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", z6Var.d());
        contentValues.put("messageItem", a2);
        contentValues.put("appId", u0.a(context).b());
        contentValues.put("packageName", u0.a(context).a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new e1(str, contentValues, "a job build to insert message to db");
    }
}
