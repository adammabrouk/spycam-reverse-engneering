package f.j.b;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes.dex */
public class i {
    public String a(g gVar) {
        return a((e) gVar);
    }

    public String a(e eVar) {
        String obj = eVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
