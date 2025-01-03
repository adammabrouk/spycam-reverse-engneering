package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import c.j.a.m;
import c.j.a.y.a;
import c.j.a.z.c;
import c.j.a.z.v;
import c.j.a.z.z;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements a {
    public static final String TAG = "PushMessageReceiver";

    @Override // c.j.a.y.a
    public boolean isAllowNet(Context context) {
        if (context == null) {
            v.a(TAG, "isAllowNet sContext is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            v.a(TAG, "isAllowNet pkgName is null");
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(packageName);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            return z.a(context, packageName);
        }
        v.a(TAG, "this is client sdk");
        return true;
    }

    @Override // c.j.a.y.a
    public void onBind(Context context, int i2, String str) {
    }

    @Override // c.j.a.y.a
    public void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // c.j.a.y.a
    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // c.j.a.y.a
    public void onListTags(Context context, int i2, List<String> list, String str) {
    }

    @Override // c.j.a.y.a
    public void onLog(Context context, String str, int i2, boolean z) {
    }

    @Override // c.j.a.y.a
    public void onPublish(Context context, int i2, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context applicationContext = c.c(context).getApplicationContext();
        m.m().a(applicationContext);
        v.d(TAG, "PushMessageReceiver " + applicationContext.getPackageName() + " ; requestId = " + intent.getStringExtra("req_id"));
        try {
            m.m().a(intent, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.j.a.y.a
    public void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // c.j.a.y.a
    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // c.j.a.y.a
    public void onTransmissionMessage(Context context, c.j.a.t.c cVar) {
    }

    @Override // c.j.a.y.a
    public void onUnBind(Context context, int i2, String str) {
    }
}
