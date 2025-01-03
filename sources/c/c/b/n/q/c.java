package c.c.b.n.q;

import c.c.b.n.q.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f6077a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.b.c f6078b;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(c.c.b.c cVar) {
        this.f6077a = new File(cVar.b().getFilesDir(), "PersistedInstallation." + cVar.e() + ".json");
        this.f6078b = cVar;
    }

    public final JSONObject a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f6077a);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused2) {
            return new JSONObject();
        }
    }

    public d b() {
        JSONObject a2 = a();
        String optString = a2.optString("Fid", null);
        int optInt = a2.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = a2.optString("AuthToken", null);
        String optString3 = a2.optString("RefreshToken", null);
        long optLong = a2.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = a2.optLong("ExpiresInSecs", 0L);
        String optString4 = a2.optString("FisError", null);
        d.a p = d.p();
        p.b(optString);
        p.a(a.values()[optInt]);
        p.a(optString2);
        p.d(optString3);
        p.b(optLong);
        p.a(optLong2);
        p.c(optString4);
        return p.a();
    }

    public d a(d dVar) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.c());
            jSONObject.put("Status", dVar.f().ordinal());
            jSONObject.put("AuthToken", dVar.a());
            jSONObject.put("RefreshToken", dVar.e());
            jSONObject.put("TokenCreationEpochInSecs", dVar.g());
            jSONObject.put("ExpiresInSecs", dVar.b());
            jSONObject.put("FisError", dVar.d());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f6078b.b().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (createTempFile.renameTo(this.f6077a)) {
            return dVar;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }
}
