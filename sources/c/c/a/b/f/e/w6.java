package c.c.a.b.f.e;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class w6<FieldDescriptorType> extends x6<FieldDescriptorType, Object> {
    public w6(int i2) {
        super(i2, null);
    }

    @Override // c.c.a.b.f.e.x6
    public final void a() {
        if (!b()) {
            for (int i2 = 0; i2 < c(); i2++) {
                Map.Entry<FieldDescriptorType, Object> a2 = a(i2);
                if (((n4) a2.getKey()).D()) {
                    a2.setValue(Collections.unmodifiableList((List) a2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((n4) entry.getKey()).D()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
