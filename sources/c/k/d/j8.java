package c.k.d;

import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.JsonUtils;
import com.shix.shixipc.utilcode.LogUtils;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class j8 {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f7301a = new a();

    public static class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? j8.a((List) obj, (List) obj2) : obj instanceof Set ? j8.a((Set) obj, (Set) obj2) : obj instanceof Map ? j8.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? j8.a((byte[]) obj, (byte[]) obj2) : j8.a((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b3 < b2 ? 1 : 0;
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i3 < i2 ? 1 : 0;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i2, remaining);
        return remaining;
    }

    public static int a(List list, List list2) {
        int a2 = a(list.size(), list2.size());
        if (a2 != 0) {
            return a2;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int compare = f7301a.compare(list.get(i2), list2.get(i2));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int a2 = a(map.size(), map2.size());
        if (a2 != 0) {
            return a2;
        }
        TreeMap treeMap = new TreeMap(f7301a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f7301a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f7301a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f7301a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int a2 = a(set.size(), set2.size());
        if (a2 != 0) {
            return a2;
        }
        TreeSet treeSet = new TreeSet(f7301a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f7301a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f7301a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    public static int a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a2 = a(bArr.length, bArr2.length);
        if (a2 != 0) {
            return a2;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int a3 = a(bArr[i2], bArr2[i2]);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    public static String a(byte b2) {
        return Integer.toHexString((b2 | JsonUtils.TYPE_BOOLEAN) & 511).toUpperCase().substring(1);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        return m257a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m258a(byteBuffer));
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i2 = limit - arrayOffset > 128 ? arrayOffset + RecyclerView.c0.FLAG_IGNORE : limit;
        for (int i3 = arrayOffset; i3 < i2; i3++) {
            if (i3 > arrayOffset) {
                sb.append(LogUtils.PLACEHOLDER);
            }
            sb.append(a(array[i3]));
        }
        if (limit != i2) {
            sb.append("...");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m257a(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m258a(ByteBuffer byteBuffer) {
        if (m257a(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }
}
