package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y2 extends a3 {
    public y2(Context context, int i2) {
        super(context, i2);
    }

    private String b() {
        Bundle extras;
        StringBuilder sb = new StringBuilder();
        try {
            Intent registerReceiver = this.f6950b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && (extras = registerReceiver.getExtras()) != null) {
                Set<String> keySet = extras.keySet();
                JSONObject jSONObject = new JSONObject();
                if (keySet != null && keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject.put(str, String.valueOf(extras.get(str)));
                            } catch (Exception unused) {
                            }
                        }
                    }
                    sb.append(jSONObject);
                }
            }
        } catch (Exception unused2) {
        }
        return sb.toString();
    }

    @Override // c.k.d.j.a
    public int a() {
        return 20;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public x6 mo92a() {
        return x6.Battery;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        return b();
    }
}
