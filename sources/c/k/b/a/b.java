package c.k.b.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public String f6765h;

    /* renamed from: i, reason: collision with root package name */
    public int f6766i;
    public long j;
    public String k;

    @Override // c.k.b.a.d
    public JSONObject a() {
        try {
            JSONObject a2 = super.a();
            if (a2 == null) {
                return null;
            }
            a2.put("eventId", this.f6765h);
            a2.put("eventType", this.f6766i);
            a2.put("eventTime", this.j);
            a2.put("eventContent", this.k == null ? "" : this.k);
            return a2;
        } catch (JSONException e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    @Override // c.k.b.a.d
    public String b() {
        return super.b();
    }
}
