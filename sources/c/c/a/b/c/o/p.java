package c.c.a.b.c.o;

import cn.jiguang.internal.ActionManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    public static final i f3987b = new i("LibraryVersion", "");

    /* renamed from: c, reason: collision with root package name */
    public static p f3988c = new p();

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f3989a = new ConcurrentHashMap<>();

    public static p a() {
        return f3988c;
    }

    public String a(String str) {
        r.a(str, (Object) "Please provide a valid libraryName");
        if (this.f3989a.containsKey(str)) {
            return this.f3989a.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = p.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty(ActionManager.SDK_VERSION, null);
                i iVar = f3987b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                iVar.c("LibraryVersion", sb.toString());
            } else {
                i iVar2 = f3987b;
                String valueOf = String.valueOf(str);
                iVar2.b("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e2) {
            i iVar3 = f3987b;
            String valueOf2 = String.valueOf(str);
            iVar3.a("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e2);
        }
        if (str2 == null) {
            f3987b.a("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f3989a.put(str, str2);
        return str2;
    }
}
