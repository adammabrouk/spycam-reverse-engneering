package c.k.d;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z1 implements Comparable<z1> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<o1> f8054a;

    /* renamed from: b, reason: collision with root package name */
    public String f8055b;

    /* renamed from: c, reason: collision with root package name */
    public long f8056c;

    /* renamed from: d, reason: collision with root package name */
    public int f8057d;

    public z1() {
        this(null, 0);
    }

    public z1(String str) {
        this(str, 0);
    }

    public z1(String str, int i2) {
        this.f8054a = new LinkedList<>();
        this.f8056c = 0L;
        this.f8055b = str;
        this.f8057d = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z1 z1Var) {
        if (z1Var == null) {
            return 1;
        }
        return z1Var.f8057d - this.f8057d;
    }

    public synchronized z1 a(JSONObject jSONObject) {
        this.f8056c = jSONObject.getLong("tt");
        this.f8057d = jSONObject.getInt("wt");
        this.f8055b = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            LinkedList<o1> linkedList = this.f8054a;
            o1 o1Var = new o1();
            o1Var.a(jSONObject2);
            linkedList.add(o1Var);
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f8056c);
        jSONObject.put("wt", this.f8057d);
        jSONObject.put("host", this.f8055b);
        JSONArray jSONArray = new JSONArray();
        Iterator<o1> it = this.f8054a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m318a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(o1 o1Var) {
        if (o1Var != null) {
            this.f8054a.add(o1Var);
            int a2 = o1Var.a();
            if (a2 > 0) {
                this.f8057d += o1Var.a();
            } else {
                int i2 = 0;
                for (int size = this.f8054a.size() - 1; size >= 0 && this.f8054a.get(size).a() < 0; size--) {
                    i2++;
                }
                this.f8057d += a2 * i2;
            }
            if (this.f8054a.size() > 30) {
                this.f8057d -= this.f8054a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f8055b + ":" + this.f8057d;
    }
}
