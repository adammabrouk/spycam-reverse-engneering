package cn.jpush.android.g;

import android.content.Intent;
import android.text.TextUtils;
import cn.asus.push.DataBuffer;
import cn.jiguang.push.asus.PushMessageReceiver;

/* loaded from: classes.dex */
public final class b extends b.a.a.a {
    @Override // b.a.a.b
    public final void call(DataBuffer dataBuffer) {
        try {
            cn.jpush.android.i.b.a("ClientAIDLCallBack", "[call] data:" + String.valueOf(dataBuffer) + ",cmd:" + dataBuffer.f8095a);
            String str = dataBuffer.f8095a;
            long j = dataBuffer.f8096b.getLong("message_rid", -1L);
            String string = dataBuffer.f8096b.getString("message_content");
            String b2 = cn.jpush.android.f.c.b(cn.jpush.android.f.c.f9721a);
            if (TextUtils.isEmpty(b2)) {
                Intent intent = new Intent();
                dataBuffer.f8096b.putString("message_cmd", dataBuffer.f8095a);
                intent.putExtras(dataBuffer.f8096b);
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(cn.jpush.android.f.c.f9723c);
                cn.jpush.android.f.c.f9721a.sendBroadcast(intent);
            } else {
                ((PushMessageReceiver) Class.forName(b2).newInstance()).a(cn.jpush.android.f.c.f9721a, j, str, string);
            }
        } catch (Throwable unused) {
        }
    }
}
