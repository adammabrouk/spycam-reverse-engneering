package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.as.d;
import cn.jiguang.az.e;
import cn.jiguang.az.h;
import cn.jiguang.az.k;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends JDispatchAction {
    public static JSONObject a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            d.c("JCoreDispatchAction", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            d.g("JCoreDispatchAction", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }

    private void a(Context context, long j, int i2, ByteBuffer byteBuffer) {
        if (i2 == 19) {
            h.a().a(context, "tcp_a18", null);
            return;
        }
        if (i2 == 25) {
            a(context, byteBuffer);
            return;
        }
        if (i2 == 26 && byteBuffer != null) {
            short s = byteBuffer.getShort();
            if (s == 0) {
                k.a().a(context, j);
            } else {
                k.a().a(context, j, s);
            }
        }
    }

    private void a(Context context, ByteBuffer byteBuffer) {
        JSONObject a2 = a(byteBuffer);
        if (a2 == null) {
            return;
        }
        try {
            int optInt = a2.optInt("cmd");
            JSONObject optJSONObject = a2.optJSONObject("content");
            d.c("JCoreDispatchAction", "deal command, cmd: " + optInt + ", content: " + (optJSONObject != null ? optJSONObject.toString() : ""));
            if (optInt == 75) {
                h.a().a(optJSONObject);
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("RESPONSE_BODY", byteBuffer.array());
            e.a(context, "cmd", bundle);
        } catch (Throwable th) {
            d.g("JCoreDispatchAction", "deal command failed, " + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i2, int i3, long j, long j2, ByteBuffer byteBuffer) {
        try {
            a(context, j2, i2, byteBuffer);
        } catch (Throwable th) {
            d.g("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return cn.jiguang.a.a.f8098b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i2) {
        return i2 == 0 || i2 == 1 || i2 == 19 || i2 == 25 || i2 == 26 || i2 == 30 || i2 == 32;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("lbsenable")) {
                    e.a(context, str2, bundle);
                    if (bundle != null) {
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.B().a((cn.jiguang.f.a<Boolean>) Boolean.valueOf(bundle.getBoolean("enable")))});
                        return;
                    }
                    return;
                }
                if (!str2.equals("lbsforenry")) {
                    if (!str2.equals("notification_state") && !str2.equals("old_cmd") && !str2.equals("user_present") && !str2.equals("set_wake_enable")) {
                        return;
                    }
                    e.a(context, str2, bundle);
                    return;
                }
                try {
                    long j = bundle.getLong("forenry");
                    d.c("JCoreDispatchAction", "setLbsPermissionDialogShieldDelay=" + j);
                    if (((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.z())).longValue() <= 0) {
                        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.z().a((cn.jiguang.f.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                    }
                    cn.jiguang.f.a[] aVarArr = new cn.jiguang.f.a[1];
                    aVarArr[0] = cn.jiguang.f.a.A().a((cn.jiguang.f.a<Long>) (j > 0 ? Long.valueOf(j) : null));
                    cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) aVarArr);
                } catch (Throwable th) {
                    d.i("JCoreDispatchAction", "onActionRun failed:" + th);
                }
            } catch (Throwable th2) {
                d.g("JCoreDispatchAction", "onActionRun failed:" + th2.getMessage());
            }
        }
    }
}
