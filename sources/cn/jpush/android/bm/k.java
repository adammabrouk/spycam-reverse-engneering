package cn.jpush.android.bm;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import cn.jpush.android.helper.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9681a = d.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9682b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f9683c = new ConcurrentHashMap<>();

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        public String f9684a;

        public a(String str) {
            this.f9684a = str;
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f9684a, Locale.ENGLISH);
        }
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double d6 = d3 * 0.008726646259971648d;
        double d7 = d5 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt(Math.pow(Math.sin(d6 - d7), 2.0d) + ((Math.cos(d6 * 2.0d) * Math.cos(d7 * 2.0d)) * Math.pow(Math.sin((d2 - d4) * 0.008726646259971648d), 2.0d)))) * 1.2756274E7d) * 10000.0d) / 10000;
    }

    public static int a(Context context, int i2) {
        return context == null ? i2 : (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup.LayoutParams a(Context context, View view, boolean z, int i2, int i3, int i4, int i5) {
        if (context == null || view == null) {
            return null;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
            if (z) {
                i2 = a(context, i2);
                i4 = a(context, i4);
                i3 = a(context, i3);
                i5 = a(context, i5);
            }
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            view.setLayoutParams(marginLayoutParams);
            return marginLayoutParams;
        } catch (Throwable th) {
            Logger.w("Utils", "[setViewMargin] failed. err: " + th.getMessage());
            return null;
        }
    }

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f9683c.get(str);
        if (threadLocal == null) {
            synchronized (f9682b) {
                threadLocal = f9683c.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f9683c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        return bArr;
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a(byteArrayOutputStream2);
            throw th;
        }
    }
}
