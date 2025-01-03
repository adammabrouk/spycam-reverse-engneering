package c.c.b.g;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class o extends p {
    public final List<d<?>> componentsInCycle;

    public o(List<d<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<d<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
