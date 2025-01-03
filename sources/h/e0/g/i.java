package h.e0.g;

import h.s;
import h.y;
import java.net.Proxy;

/* compiled from: RequestLine.java */
/* loaded from: classes.dex */
public final class i {
    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.e());
        sb.append(' ');
        if (b(yVar, type)) {
            sb.append(yVar.g());
        } else {
            sb.append(a(yVar.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static boolean b(y yVar, Proxy.Type type) {
        return !yVar.d() && type == Proxy.Type.HTTP;
    }

    public static String a(s sVar) {
        String c2 = sVar.c();
        String e2 = sVar.e();
        if (e2 == null) {
            return c2;
        }
        return c2 + '?' + e2;
    }
}
