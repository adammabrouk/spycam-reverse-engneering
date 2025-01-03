package c.c.a.a.j.v;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i2, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult a2;
        if (i2 < 1) {
            return aVar.a(tinput);
        }
        do {
            a2 = aVar.a(tinput);
            tinput = cVar.a(tinput, a2);
            if (tinput == null) {
                break;
            }
            i2--;
        } while (i2 >= 1);
        return a2;
    }
}
