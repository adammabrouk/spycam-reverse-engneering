package c.k.c.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes.dex */
public class j0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f6849a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(i0 i0Var, Looper looper) {
        super(looper);
        this.f6849a = i0Var;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        i0 i0Var;
        n0 n0Var;
        Context context5;
        HashMap<String, String> a2;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        i0 i0Var2;
        n0 n0Var2;
        Context context13;
        Context context14;
        if (message.what != 19) {
            return;
        }
        String str = (String) message.obj;
        int i2 = message.arg1;
        synchronized (z.class) {
            context = this.f6849a.f6838b;
            if (z.a(context).m63a(str)) {
                context2 = this.f6849a.f6838b;
                if (z.a(context2).a(str) < 10) {
                    if (n0.DISABLE_PUSH.ordinal() == i2) {
                        context14 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context14).a(n0.DISABLE_PUSH))) {
                            i0Var2 = this.f6849a;
                            n0Var2 = n0.DISABLE_PUSH;
                            i0Var2.a(str, n0Var2, true, (HashMap<String, String>) null);
                            context13 = this.f6849a.f6838b;
                            z.a(context13).b(str);
                        }
                    }
                    if (n0.ENABLE_PUSH.ordinal() == i2) {
                        context12 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context12).a(n0.ENABLE_PUSH))) {
                            i0Var2 = this.f6849a;
                            n0Var2 = n0.ENABLE_PUSH;
                            i0Var2.a(str, n0Var2, true, (HashMap<String, String>) null);
                            context13 = this.f6849a.f6838b;
                            z.a(context13).b(str);
                        }
                    }
                    if (n0.UPLOAD_HUAWEI_TOKEN.ordinal() == i2) {
                        context10 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context10).a(n0.UPLOAD_HUAWEI_TOKEN))) {
                            i0Var = this.f6849a;
                            n0Var = n0.UPLOAD_HUAWEI_TOKEN;
                            context11 = this.f6849a.f6838b;
                            a2 = w0.a(context11, s0.ASSEMBLE_PUSH_HUAWEI);
                            i0Var.a(str, n0Var, false, (HashMap<String, String>) a2);
                            context13 = this.f6849a.f6838b;
                            z.a(context13).b(str);
                        }
                    }
                    if (n0.UPLOAD_FCM_TOKEN.ordinal() == i2) {
                        context8 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context8).a(n0.UPLOAD_FCM_TOKEN))) {
                            i0Var = this.f6849a;
                            n0Var = n0.UPLOAD_FCM_TOKEN;
                            context9 = this.f6849a.f6838b;
                            a2 = w0.a(context9, s0.ASSEMBLE_PUSH_FCM);
                            i0Var.a(str, n0Var, false, (HashMap<String, String>) a2);
                            context13 = this.f6849a.f6838b;
                            z.a(context13).b(str);
                        }
                    }
                    if (n0.UPLOAD_COS_TOKEN.ordinal() == i2) {
                        context6 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context6).a(n0.UPLOAD_COS_TOKEN))) {
                            i0Var = this.f6849a;
                            n0Var = n0.UPLOAD_COS_TOKEN;
                            context7 = this.f6849a.f6838b;
                            a2 = w0.a(context7, s0.ASSEMBLE_PUSH_COS);
                            i0Var.a(str, n0Var, false, (HashMap<String, String>) a2);
                            context13 = this.f6849a.f6838b;
                            z.a(context13).b(str);
                        }
                    }
                    if (n0.UPLOAD_FTOS_TOKEN.ordinal() == i2) {
                        context4 = this.f6849a.f6838b;
                        if ("syncing".equals(z.a(context4).a(n0.UPLOAD_FTOS_TOKEN))) {
                            i0Var = this.f6849a;
                            n0Var = n0.UPLOAD_FTOS_TOKEN;
                            context5 = this.f6849a.f6838b;
                            a2 = w0.a(context5, s0.ASSEMBLE_PUSH_FTOS);
                            i0Var.a(str, n0Var, false, (HashMap<String, String>) a2);
                        }
                    }
                    context13 = this.f6849a.f6838b;
                    z.a(context13).b(str);
                } else {
                    context3 = this.f6849a.f6838b;
                    z.a(context3).c(str);
                }
            }
        }
    }
}
