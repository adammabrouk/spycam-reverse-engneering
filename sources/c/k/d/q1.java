package c.k.d;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    public String f7755a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<p1> f7756b = new ArrayList<>();

    public q1() {
    }

    public q1(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f7755a = str;
    }

    public synchronized p1 a() {
        for (int size = this.f7756b.size() - 1; size >= 0; size--) {
            p1 p1Var = this.f7756b.get(size);
            if (p1Var.m330a()) {
                u1.a().m493a(p1Var.a());
                return p1Var;
            }
        }
        return null;
    }

    public synchronized q1 a(JSONObject jSONObject) {
        this.f7755a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            ArrayList<p1> arrayList = this.f7756b;
            p1 p1Var = new p1(this.f7755a);
            p1Var.a(jSONArray.getJSONObject(i2));
            arrayList.add(p1Var);
        }
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m418a() {
        return this.f7755a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ArrayList<p1> m419a() {
        return this.f7756b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m420a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f7755a);
        JSONArray jSONArray = new JSONArray();
        Iterator<p1> it = this.f7756b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m328a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(p1 p1Var) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f7756b.size()) {
                break;
            }
            if (this.f7756b.get(i2).a(p1Var)) {
                this.f7756b.set(i2, p1Var);
                break;
            }
            i2++;
        }
        if (i2 >= this.f7756b.size()) {
            this.f7756b.add(p1Var);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<p1> arrayList;
        for (int size = this.f7756b.size() - 1; size >= 0; size--) {
            p1 p1Var = this.f7756b.get(size);
            if (z) {
                if (p1Var.c()) {
                    arrayList = this.f7756b;
                    arrayList.remove(size);
                }
            } else if (!p1Var.b()) {
                arrayList = this.f7756b;
                arrayList.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7755a);
        sb.append(OSSUtils.NEW_LINE);
        Iterator<p1> it = this.f7756b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
