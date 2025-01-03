package c.c.a.b.f.e;

import c.c.a.b.f.e.b3;
import c.c.a.b.f.e.d3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class b3<MessageType extends b3<MessageType, BuilderType>, BuilderType extends d3<MessageType, BuilderType>> implements d6 {
    public int zza = 0;

    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // c.c.a.b.f.e.d6
    public final k3 d() {
        try {
            s3 zzc = k3.zzc(e());
            a(zzc.b());
            return zzc.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] g() {
        try {
            byte[] bArr = new byte[e()];
            b4 a2 = b4.a(bArr);
            a(a2);
            a2.b();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public static <T> void a(Iterable<T> iterable, List<? super T> list) {
        u4.a(iterable);
        if (iterable instanceof k5) {
            List<?> zzb = ((k5) iterable).zzb();
            k5 k5Var = (k5) list;
            int size = list.size();
            for (Object obj : zzb) {
                if (obj == null) {
                    int size2 = k5Var.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = k5Var.size() - 1; size3 >= size; size3--) {
                        k5Var.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof k3) {
                    k5Var.a((k3) obj);
                } else {
                    k5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof q6) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }
}
