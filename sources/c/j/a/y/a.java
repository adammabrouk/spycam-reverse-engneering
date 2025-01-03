package c.j.a.y;

import android.content.Context;
import c.j.a.t.c;
import java.util.List;

/* compiled from: PushMessageCallback.java */
/* loaded from: classes.dex */
public interface a {
    boolean isAllowNet(Context context);

    void onBind(Context context, int i2, String str);

    void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str);

    void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str);

    void onListTags(Context context, int i2, List<String> list, String str);

    void onLog(Context context, String str, int i2, boolean z);

    boolean onNotificationMessageArrived(Context context, c.j.a.t.b bVar);

    void onNotificationMessageClicked(Context context, c.j.a.t.b bVar);

    void onPublish(Context context, int i2, String str);

    void onReceiveRegId(Context context, String str);

    void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str);

    void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str);

    void onTransmissionMessage(Context context, c cVar);

    void onUnBind(Context context, int i2, String str);
}
