package cn.jpush.android.asus;

import android.content.Context;
import cn.jiguang.push.asus.PushMessageReceiver;
import cn.jpush.android.bl.c;

/* loaded from: classes.dex */
public class AsusPushMessageReceiver extends PushMessageReceiver {
    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, cn.jpush.android.c.a aVar) {
    }

    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, String str) {
        c.a().a(context, (byte) 6, str);
    }
}
