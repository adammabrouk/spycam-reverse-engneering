package c.k.d;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class v4 {

    /* renamed from: a, reason: collision with root package name */
    public XmlPullParser f7942a;

    public v4() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f7942a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public r5 a(byte[] bArr, z4 z4Var) {
        this.f7942a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f7942a.next();
        int eventType = this.f7942a.getEventType();
        String name = this.f7942a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return z5.a(this.f7942a);
        }
        if (name.equals("iq")) {
            return z5.a(this.f7942a, z4Var);
        }
        if (name.equals("presence")) {
            return z5.m551a(this.f7942a);
        }
        if (this.f7942a.getName().equals("stream")) {
            return null;
        }
        if (this.f7942a.getName().equals("error")) {
            throw new l5(z5.m552a(this.f7942a));
        }
        if (!this.f7942a.getName().equals("warning")) {
            this.f7942a.getName().equals("bind");
            return null;
        }
        this.f7942a.next();
        this.f7942a.getName().equals("multi-login");
        return null;
    }
}
