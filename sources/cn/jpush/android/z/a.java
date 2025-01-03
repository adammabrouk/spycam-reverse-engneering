package cn.jpush.android.z;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.s.b;
import cn.jpush.android.t.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Thread;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f9969a;

    /* renamed from: b, reason: collision with root package name */
    public static String f9970b;

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f9971d;

    /* renamed from: c, reason: collision with root package name */
    public File f9972c;

    /* renamed from: e, reason: collision with root package name */
    public Handler f9973e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f9974f;

    public static a a() {
        if (f9971d == null) {
            synchronized (a.class) {
                f9971d = new a();
            }
        }
        return f9971d;
    }

    private File a(Context context) {
        File file = this.f9972c;
        if (file != null && file.exists()) {
            return this.f9972c;
        }
        File filesDir = context.getFilesDir();
        File file2 = new File(filesDir.getAbsolutePath() + File.separator + "cn_jiguang_union_ads" + File.separator + cn.jpush.android.l.a.c(context) + File.separator + "result");
        this.f9972c = file2;
        if (!file2.exists()) {
            this.f9972c.mkdirs();
        }
        return this.f9972c;
    }

    private JSONObject a(Context context, JSONArray jSONArray) {
        try {
            b b2 = cn.jpush.android.n.b.a().b();
            cn.jpush.android.s.a c2 = cn.jpush.android.n.b.a().c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", jSONArray);
            jSONObject.put("uid", c2.b());
            jSONObject.put("product", b2.a());
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, b2.g());
            jSONObject.put("platform_version", b2.b());
            jSONObject.put("app_id", c2.c());
            jSONObject.put("app_key", c2.a());
            jSONObject.put("app_channel", c2.h());
            jSONObject.put("app_version", c2.d());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private synchronized JSONObject a(File file) {
        if (file != null) {
            if (file.exists()) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                    String readUTF = dataInputStream.readUTF();
                    dataInputStream.close();
                    if (TextUtils.isEmpty(readUTF)) {
                        return null;
                    }
                    return new JSONObject(readUTF);
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("JUnionAdReportBusiness", "readContent failed " + th.getMessage());
                    return null;
                }
            }
        }
        cn.jpush.android.r.b.b("JUnionAdReportBusiness", "cacheFile [" + file.getAbsolutePath() + "] is no exist");
        return null;
    }

    private synchronized Handler b() {
        if (this.f9974f == null || this.f9974f.getState() == Thread.State.TERMINATED) {
            this.f9974f = new HandlerThread("jg_union_ad_rp");
        }
        if (this.f9974f.getState() == Thread.State.NEW) {
            this.f9974f.start();
            this.f9973e = null;
        }
        if (this.f9973e == null) {
            this.f9973e = new Handler(this.f9974f.getLooper());
        }
        return this.f9973e;
    }

    private JSONObject d(Context context, JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            return a(context, jSONArray);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void a(Context context, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jpush.android.r.b.b("JUnionAdReportBusiness", "report failed, there are no content");
            return;
        }
        File c2 = c(context, jSONObject);
        JSONObject d2 = d(context, jSONObject);
        int a2 = cn.jpush.android.aa.a.a(context, str, d2);
        cn.jpush.android.r.b.b("JUnionAdReportBusiness", "report url: " + str);
        cn.jpush.android.r.b.b("JUnionAdReportBusiness", "report result " + a2 + "," + cn.jpush.android.r.b.a(d2));
        if (a2 == 0 && c2 != null && c2.exists()) {
            c2.delete();
        }
        File a3 = a(context);
        if (!a3.exists()) {
            cn.jpush.android.r.b.b("JUnionAdReportBusiness", "there are no report cache");
            return;
        }
        File[] listFiles = a3.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            JSONArray jSONArray = new JSONArray();
            for (File file : listFiles) {
                if (file.exists()) {
                    jSONArray.put(a(file));
                } else {
                    cn.jpush.android.r.b.b("JUnionAdReportBusiness", "cacheFile [" + file.getAbsolutePath() + "] is no exist");
                }
            }
            if (jSONArray.length() == 0) {
                return;
            }
            if (cn.jpush.android.aa.a.a(context, str, a(context, jSONArray)) != 0) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    file2.delete();
                } else {
                    cn.jpush.android.r.b.b("JUnionAdReportBusiness", "cacheFile [" + file2.getAbsolutePath() + "] is no exist");
                }
            }
            return;
        }
        cn.jpush.android.r.b.b("JUnionAdReportBusiness", "there are no report cache");
    }

    public void a(final Context context, final JSONObject jSONObject) {
        final String str = a.InterfaceC0158a.f9863a;
        b().post(new cn.jpush.android.r.a() { // from class: cn.jpush.android.z.a.1
            @Override // cn.jpush.android.r.a
            public void a() {
                try {
                    a.this.a(context, str, jSONObject);
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("JUnionAdReportBusiness", "loadADStatisticReport failed, " + th.getMessage());
                }
            }
        });
    }

    public void b(final Context context, final JSONObject jSONObject) {
        final String str = a.InterfaceC0158a.f9864b;
        b().post(new cn.jpush.android.r.a() { // from class: cn.jpush.android.z.a.2
            @Override // cn.jpush.android.r.a
            public void a() {
                try {
                    a.this.a(context, str, jSONObject);
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("JUnionAdReportBusiness", "adEventReport failed, " + th.getMessage());
                }
            }
        });
    }

    public synchronized File c(Context context, JSONObject jSONObject) {
        File file;
        try {
            String jSONObject2 = jSONObject.toString();
            String str = a(context).getAbsolutePath() + File.separator + System.currentTimeMillis();
            cn.jpush.android.r.b.b("JUnionAdReportBusiness", "save file:" + str);
            file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeUTF(jSONObject2);
            dataOutputStream.close();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdReportBusiness", "writeContent failed " + th.getMessage());
            return null;
        }
        return file;
    }
}
