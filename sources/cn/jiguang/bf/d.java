package cn.jiguang.bf;

import android.content.Context;
import cn.jiguang.bg.i;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.system.ContentCommon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static cn.jiguang.bg.e f8709a;

    public static JSONArray a(Throwable th) {
        try {
            if (!(th instanceof c)) {
                return null;
            }
            l lVar = new l(new k());
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(((c) th).c().getId()));
            List<cn.jiguang.bg.h> a2 = lVar.a(arrayList);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.bg.h hVar = a2.get(i2);
                if (hVar != null) {
                    if (hVar.c() != null) {
                        jSONObject.put("crashed", hVar.c());
                    }
                    if (hVar.d() != null) {
                        jSONObject.put("current", hVar.d());
                    }
                    if (hVar.b() != null) {
                        jSONObject.put("name", hVar.b());
                    }
                    if (hVar.g() != null) {
                        jSONObject.put("daemon", hVar.g());
                    }
                    if (hVar.a() != null) {
                        jSONObject.put("id", hVar.a());
                    }
                    if (hVar.f() != null) {
                        jSONObject.put("priority", hVar.f());
                    }
                    if (hVar.e() != null) {
                        a(jSONObject, hVar.e());
                    }
                    if (hVar.h() != null) {
                        jSONObject.put("state", hVar.h());
                    }
                    if (jSONObject.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse Exception.", e2);
            return null;
        }
    }

    public static JSONObject a(Context context, cn.jiguang.bg.i iVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (iVar.b() != null) {
                jSONObject.put("sid", iVar.b().toString());
            }
            jSONObject.put(FragmentCameraList.STR_DID, cn.jiguang.bk.c.a(context));
            if (iVar.c() != null) {
                jSONObject.put("init", iVar.c());
            }
            Date a2 = iVar.a();
            if (a2 != null) {
                jSONObject.put("started", cn.jiguang.e.b.a(a2));
            }
            i.a e2 = iVar.e();
            if (e2 != null) {
                jSONObject.put("status", e2.name().toLowerCase(Locale.ROOT));
            }
            if (iVar.f() != null) {
                jSONObject.put("seq", iVar.f());
            }
            int d2 = iVar.d();
            if (d2 > 0) {
                jSONObject.put("errors", d2);
            }
            if (iVar.g() != null) {
                jSONObject.put("duration", iVar.g());
            }
            if (iVar.h() != null) {
                jSONObject.put("timestamp", cn.jiguang.e.b.a(iVar.h()));
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse SentrySessionEnvelopeItem.", th);
            return null;
        }
    }

    public static JSONObject a(Context context, Throwable th) {
        cn.jiguang.bg.c a2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray b2 = b(context, th);
            if (b2 == null || b2.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("values", b2);
            jSONObject.put("exception", jSONObject2);
            if ((th instanceof c) && (a2 = ((c) th).a()) != null && a2.a().equalsIgnoreCase("UncaughtExceptionHandler")) {
                jSONObject.put("level", "fatal");
            }
            JSONArray a3 = a(th);
            if (a3 != null && a3.length() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("values", a3);
                jSONObject.put("threads", jSONObject3);
            }
            jSONObject.put("timestamp", cn.jiguang.e.b.a(cn.jiguang.e.b.c()));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("app", cn.jiguang.bh.e.j(context));
            jSONObject4.put("os", cn.jiguang.bh.e.k(context));
            jSONObject4.put("device", cn.jiguang.bh.e.i(context));
            jSONObject.put("contexts", jSONObject4);
            jSONObject.put("dist", Integer.toString(cn.jiguang.a.a.f8099c));
            jSONObject.put("environment", "production");
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, "java");
            cn.jiguang.bg.e eVar = new cn.jiguang.bg.e();
            f8709a = eVar;
            jSONObject.put("event_id", eVar.toString());
            jSONObject.put("sdk", cn.jiguang.bh.e.f());
            jSONObject.put("user", cn.jiguang.bh.e.l(context));
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse SentryEventEnvelopeItem.", e2);
            return null;
        }
    }

    public static JSONObject a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", "application/json");
            jSONObject.put(ContentCommon.TYPE, str);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse SentryEnvelopeItemHeader.", e2);
            return null;
        }
    }

    public static JSONObject a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z && f8709a != null) {
                jSONObject.put("event_id", f8709a.toString());
            }
            JSONObject jSONObject2 = new JSONObject();
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject2);
            jSONObject2.put("core_sdk_ver", cn.jiguang.a.a.f8098b);
            jSONObject.put("sdks", jSONObject2);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse SentryEnvelopeHeader.", e2);
            return null;
        }
    }

    public static void a(JSONObject jSONObject, cn.jiguang.bg.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (cVar.a() != null) {
                jSONObject2.put(ContentCommon.TYPE, cVar.a());
            }
            if (cVar.b() != null) {
                jSONObject2.put("handled", cVar.b());
            }
            jSONObject.put("mechanism", jSONObject2);
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse writeMechanism.", e2);
        }
    }

    public static void a(JSONObject jSONObject, cn.jiguang.bg.f fVar) {
        if (fVar == null) {
            return;
        }
        try {
            if (fVar.n() != null) {
                jSONObject.put("native", fVar.n());
            }
            if (fVar.a() != null) {
                jSONObject.put("filename", fVar.a());
            }
            if (fVar.b() != null) {
                jSONObject.put("function", fVar.b());
            }
            if (fVar.h() != null) {
                jSONObject.put("in_app", fVar.h());
            }
            if (fVar.d() != null) {
                jSONObject.put("lineno", fVar.d());
            }
            if (fVar.c() != null) {
                jSONObject.put("module", fVar.c());
            }
            if (fVar.i() != null) {
                jSONObject.put("package", fVar.i());
            }
            if (fVar.f() != null) {
                jSONObject.put("abs_path", fVar.f());
            }
            if (fVar.e() != null) {
                jSONObject.put("colno", fVar.e());
            }
            if (fVar.g() != null) {
                jSONObject.put("context_line", fVar.g());
            }
            if (fVar.j() != null) {
                jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, fVar.j());
            }
            if (fVar.k() != null) {
                jSONObject.put("image_addr", fVar.k());
            }
            if (fVar.l() != null) {
                jSONObject.put("symbol_addr", fVar.l());
            }
            if (fVar.m() != null) {
                jSONObject.put("instruction_addr", fVar.m());
            }
            if (fVar.o() != null) {
                jSONObject.put("raw_function", fVar.o());
            }
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse StackFrame.", e2);
        }
    }

    public static void a(JSONObject jSONObject, cn.jiguang.bg.g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (gVar.a() != null && gVar.a().size() > 0) {
                if (gVar.b() != null) {
                    jSONObject2.put("snapshot", gVar.b());
                }
                int size = gVar.a().size();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject3 = new JSONObject();
                    cn.jiguang.bg.f fVar = gVar.a().get(i2);
                    if (fVar != null) {
                        a(jSONObject3, fVar);
                        if (jSONObject3.length() > 0) {
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject2.put("frames", jSONArray);
                }
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("stacktrace", jSONObject2);
            }
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse StackTrace.", e2);
        }
    }

    public static JSONArray b(Context context, Throwable th) {
        try {
            List<cn.jiguang.bg.d> a2 = new j(new k()).a(th);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.bg.d dVar = a2.get(i2);
                if (dVar != null) {
                    a(jSONObject, dVar.f());
                    if (dVar.c() != null) {
                        jSONObject.put("module", dVar.c());
                    }
                    if (dVar.d() != null) {
                        jSONObject.put("thread_id", dVar.d());
                    }
                    if (dVar.a() != null) {
                        jSONObject.put(ContentCommon.TYPE, dVar.a());
                    }
                    if (dVar.b() != null) {
                        jSONObject.put("value", dVar.b());
                    }
                    if (dVar.e() != null) {
                        a(jSONObject, dVar.e());
                    }
                    if (jSONObject.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("ExceptionParseUtils", "Error parse Exception.", e2);
            return null;
        }
    }
}
