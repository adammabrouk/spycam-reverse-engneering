package cn.jiguang.v;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f9056a;

    /* renamed from: b, reason: collision with root package name */
    public String f9057b;

    public a(Context context) {
        this.f9057b = "";
        this.f9056a = context;
        this.f9057b = d.g("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cursor query = this.f9056a.getContentResolver().query(Uri.parse(this.f9057b), null, null, new String[]{str}, null);
            if (query != null) {
                r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            } else {
                cn.jiguang.ai.a.a("MeizuDB", "return cursor is null,return");
            }
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("MeizuDB", "getId error: " + e2.getMessage());
        }
        return r1;
    }
}
