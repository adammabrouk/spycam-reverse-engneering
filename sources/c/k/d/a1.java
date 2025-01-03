package c.k.d;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class a1 extends d1 {
    public a1(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static a1 a(Context context, String str, int i2) {
        c.k.a.a.a.c.b("delete  messages when db size is too bigger");
        String m186a = h1.a(context).m186a(str);
        if (TextUtils.isEmpty(m186a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m186a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new a1(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
    }

    public final void a(long j) {
        String[] strArr = this.f7208g;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // c.k.d.h1.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a2 = n1.a(m188a());
            long j = y0.f8030b;
            if (a2 <= j) {
                c.k.a.a.a.c.b("db size is suitable");
                return;
            }
            double d2 = a2 - j;
            Double.isNaN(d2);
            double d3 = j;
            Double.isNaN(d3);
            double d4 = longValue;
            Double.isNaN(d4);
            long j2 = (long) (((d2 * 1.2d) / d3) * d4);
            a(j2);
            u0.a(context).a("begin delete " + j2 + "noUpload messages , because db size is " + a2 + "B");
            super.a(context, obj);
        }
    }
}
