package c.k.d;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class o5 implements s5 {

    /* renamed from: a, reason: collision with root package name */
    public String f7464a;

    /* renamed from: b, reason: collision with root package name */
    public String f7465b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f7466c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f7467d;

    /* renamed from: e, reason: collision with root package name */
    public String f7468e;

    /* renamed from: f, reason: collision with root package name */
    public List<o5> f7469f;

    public o5(String str, String str2, String[] strArr, String[] strArr2) {
        this.f7466c = null;
        this.f7467d = null;
        this.f7469f = null;
        this.f7464a = str;
        this.f7465b = str2;
        this.f7466c = strArr;
        this.f7467d = strArr2;
    }

    public o5(String str, String str2, String[] strArr, String[] strArr2, String str3, List<o5> list) {
        this.f7466c = null;
        this.f7467d = null;
        this.f7469f = null;
        this.f7464a = str;
        this.f7465b = str2;
        this.f7466c = strArr;
        this.f7467d = strArr2;
        this.f7468e = str3;
        this.f7469f = list;
    }

    public static o5 a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i2 = 0;
        for (String str : keySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new o5(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<o5> list) {
        return a((o5[]) list.toArray(new o5[list.size()]));
    }

    public static Parcelable[] a(o5[] o5VarArr) {
        if (o5VarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[o5VarArr.length];
        for (int i2 = 0; i2 < o5VarArr.length; i2++) {
            parcelableArr[i2] = o5VarArr[i2].m322a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f7464a);
        bundle.putString("ext_ns", this.f7465b);
        bundle.putString("ext_text", this.f7468e);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f7466c;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f7466c;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f7467d[i2]);
                i2++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<o5> list = this.f7469f;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f7469f));
        }
        return bundle;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Parcelable m322a() {
        return a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m323a() {
        return this.f7464a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f7466c == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.f7466c;
            if (i2 >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i2])) {
                return this.f7467d[i2];
            }
            i2++;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m324a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = c6.a(str);
        }
        this.f7468e = str;
    }

    public String b() {
        return this.f7465b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f7468e) ? c6.b(this.f7468e) : this.f7468e;
    }

    @Override // c.k.d.s5
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f7464a);
        if (!TextUtils.isEmpty(this.f7465b)) {
            sb.append(LogUtils.PLACEHOLDER);
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f7465b);
            sb.append("\"");
        }
        String[] strArr = this.f7466c;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.f7466c.length; i2++) {
                if (!TextUtils.isEmpty(this.f7467d[i2])) {
                    sb.append(LogUtils.PLACEHOLDER);
                    sb.append(this.f7466c[i2]);
                    sb.append("=\"");
                    sb.append(c6.a(this.f7467d[i2]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f7468e)) {
            List<o5> list = this.f7469f;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            Iterator<o5> it = this.f7469f.iterator();
            while (it.hasNext()) {
                sb.append(it.next().d());
            }
        } else {
            sb.append(">");
            sb.append(this.f7468e);
        }
        sb.append("</");
        sb.append(this.f7464a);
        sb.append(">");
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
