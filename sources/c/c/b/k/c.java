package c.c.b.k;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        public final int code;

        a(int i2) {
            this.code = i2;
        }

        public int getCode() {
            return this.code;
        }
    }

    a a(String str);
}
