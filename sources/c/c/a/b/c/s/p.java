package c.c.a.b.c.s;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class p {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
