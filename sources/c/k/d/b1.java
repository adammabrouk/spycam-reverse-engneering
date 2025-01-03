package c.k.d;

import android.content.Context;
import android.database.Cursor;
import c.k.d.h1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b1 extends h1.b<Long> {
    public long n;

    public b1(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i2);
        this.n = 0L;
    }

    public static b1 a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new b1(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.k.d.h1.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // c.k.d.h1.a
    /* renamed from: a */
    public Object mo187a() {
        return Long.valueOf(this.n);
    }

    @Override // c.k.d.h1.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.n = list.get(0).longValue();
    }
}
