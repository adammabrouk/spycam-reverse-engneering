package c.k.d;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class y5 {

    /* renamed from: c, reason: collision with root package name */
    public static y5 f8037c;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Object> f8038a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Object> f8039b = new ConcurrentHashMap();

    public y5() {
        m534a();
    }

    public static synchronized y5 a() {
        y5 y5Var;
        synchronized (y5.class) {
            if (f8037c == null) {
                f8037c = new y5();
            }
            y5Var = f8037c;
        }
        return y5Var;
    }

    public Object a(String str, String str2) {
        return this.f8038a.get(m533a(str, str2));
    }

    /* renamed from: a, reason: collision with other method in class */
    public final String m533a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m534a() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            for (ClassLoader classLoader : m535a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String m533a = m533a(nextText, nextText2);
                                    if (!this.f8039b.containsKey(m533a)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (w5.class.isAssignableFrom(cls)) {
                                                map2 = this.f8039b;
                                                obj2 = cls.newInstance();
                                            } else if (p5.class.isAssignableFrom(cls)) {
                                                map2 = this.f8039b;
                                                obj2 = cls;
                                            }
                                            map2.put(m533a, obj2);
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String m533a2 = m533a(nextText4, nextText5);
                                    if (!this.f8038a.containsKey(m533a2)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (x5.class.isAssignableFrom(cls2)) {
                                                map = this.f8038a;
                                                obj = cls2.newInstance();
                                            } else if (s5.class.isAssignableFrom(cls2)) {
                                                map = this.f8038a;
                                                obj = cls2;
                                            }
                                            map.put(m533a2, obj);
                                        } catch (ClassNotFoundException e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                        inputStream.close();
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof x5) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f8038a.put(m533a(str, str2), obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final ClassLoader[] m535a() {
        ClassLoader[] classLoaderArr = {y5.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
