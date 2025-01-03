package c.c.a.b.g.b;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4966a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f4967b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4968c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f4969d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j4 f4970e;

    public o4(j4 j4Var, String str, Bundle bundle) {
        this.f4970e = j4Var;
        c.c.a.b.c.o.r.b(str);
        this.f4966a = str;
        this.f4967b = new Bundle();
    }

    public final Bundle a() {
        if (!this.f4968c) {
            this.f4968c = true;
            String string = this.f4970e.s().getString(this.f4966a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            char c2 = 65535;
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c2 = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    c2 = 2;
                                }
                            } else if (string3.equals("d")) {
                                c2 = 1;
                            }
                            if (c2 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c2 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c2 != 2) {
                                this.f4970e.c().t().a("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f4970e.c().t().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f4969d = bundle;
                } catch (JSONException unused2) {
                    this.f4970e.c().t().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f4969d == null) {
                this.f4969d = this.f4967b;
            }
        }
        return this.f4969d;
    }

    public final String b(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.f4970e.c().t().a("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    this.f4970e.c().t().a("Cannot serialize bundle value to SharedPreferences", e2);
                }
            }
        }
        return jSONArray.toString();
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f4970e.s().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f4966a);
        } else {
            edit.putString(this.f4966a, b(bundle));
        }
        edit.apply();
        this.f4969d = bundle;
    }
}
