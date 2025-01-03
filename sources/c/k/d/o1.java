package c.k.d;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class o1 {

    /* renamed from: a, reason: collision with root package name */
    public int f7442a;

    /* renamed from: b, reason: collision with root package name */
    public long f7443b;

    /* renamed from: c, reason: collision with root package name */
    public long f7444c;

    /* renamed from: d, reason: collision with root package name */
    public String f7445d;

    /* renamed from: e, reason: collision with root package name */
    public long f7446e;

    public o1() {
        this(0, 0L, 0L, null);
    }

    public o1(int i2, long j, long j2, Exception exc) {
        this.f7442a = i2;
        this.f7443b = j;
        this.f7446e = j2;
        this.f7444c = System.currentTimeMillis();
        if (exc != null) {
            this.f7445d = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f7442a;
    }

    public o1 a(JSONObject jSONObject) {
        this.f7443b = jSONObject.getLong("cost");
        this.f7446e = jSONObject.getLong("size");
        this.f7444c = jSONObject.getLong("ts");
        this.f7442a = jSONObject.getInt("wt");
        this.f7445d = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m318a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f7443b);
        jSONObject.put("size", this.f7446e);
        jSONObject.put("ts", this.f7444c);
        jSONObject.put("wt", this.f7442a);
        jSONObject.put("expt", this.f7445d);
        return jSONObject;
    }
}
