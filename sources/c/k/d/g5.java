package c.k.d;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public final class g5 {

    /* renamed from: a, reason: collision with root package name */
    public static int f7156a = 5000;

    /* renamed from: b, reason: collision with root package name */
    public static int f7157b = 330000;

    /* renamed from: c, reason: collision with root package name */
    public static int f7158c = 600000;

    /* renamed from: d, reason: collision with root package name */
    public static Vector<String> f7159d = new Vector<>();

    static {
        try {
            for (ClassLoader classLoader : m174a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals("className")) {
                                        a(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        f7156a = a(newPullParser, f7156a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        f7157b = a(newPullParser, f7157b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f7159d.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static int a() {
        return f7157b;
    }

    public static int a(XmlPullParser xmlPullParser, int i2) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m173a() {
        return "3.1.0";
    }

    public static void a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static ClassLoader[] m174a() {
        ClassLoader[] classLoaderArr = {g5.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int b() {
        return f7158c;
    }
}
