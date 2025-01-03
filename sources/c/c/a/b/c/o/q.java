package c.c.a.b.c.o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class q {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f3990a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f3991b;

        public a(Object obj) {
            r.a(obj);
            this.f3991b = obj;
            this.f3990a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f3990a;
            r.a(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f3991b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f3990a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.f3990a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj);
    }
}
