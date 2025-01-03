package f.k;

/* compiled from: StringsJVM.kt */
/* loaded from: classes.dex */
public class i extends h {
    public static final boolean a(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }
}
