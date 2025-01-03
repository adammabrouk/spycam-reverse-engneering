package com.vivo.push.sdk;

import android.content.Context;
import c.j.a.t.b;
import c.j.a.t.c;
import java.util.List;

/* loaded from: classes.dex */
public abstract class OpenClientPushMessageReceiver extends BasePushMessageReceiver {
    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final boolean isAllowNet(Context context) {
        return super.isAllowNet(context);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onBind(Context context, int i2, String str) {
        super.onBind(context, i2, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onListTags(Context context, int i2, List<String> list, String str) {
        super.onListTags(context, i2, list, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onLog(Context context, String str, int i2, boolean z) {
        super.onLog(context, str, i2, z);
    }

    @Override // c.j.a.y.a
    public final boolean onNotificationMessageArrived(Context context, b bVar) {
        return false;
    }

    @Override // c.j.a.y.a
    public void onNotificationMessageClicked(Context context, b bVar) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onPublish(Context context, int i2, String str) {
        super.onPublish(context, i2, str);
    }

    @Override // c.j.a.y.a
    public void onReceiveRegId(Context context, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public void onTransmissionMessage(Context context, c cVar) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, c.j.a.y.a
    public final void onUnBind(Context context, int i2, String str) {
        super.onUnBind(context, i2, str);
    }
}
