package f.j.b;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes.dex */
public abstract class g<R> implements e<R>, Serializable {
    public final int arity;

    public g(int i2) {
        this.arity = i2;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = h.a(this);
        f.b(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
