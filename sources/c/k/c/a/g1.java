package c.k.c.a;

import android.content.Context;
import android.content.Intent;
import c.k.d.i8;

/* loaded from: classes.dex */
public class g1 {
    public static <T extends i8<T, ?>> void a(Context context, c.k.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", aVar.e());
        intent.putExtra("action_cr_event_frequency", aVar.a());
        intent.putExtra("action_cr_perf_switch", aVar.f());
        intent.putExtra("action_cr_perf_frequency", aVar.c());
        intent.putExtra("action_cr_event_en", aVar.d());
        intent.putExtra("action_cr_max_file_size", aVar.b());
        i0.a(context).m26a(intent);
    }
}
