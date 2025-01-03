package androidx.core.app;

import a.v.a;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2478a = (IconCompat) aVar.a((a) remoteActionCompat.f2478a, 1);
        remoteActionCompat.f2479b = aVar.a(remoteActionCompat.f2479b, 2);
        remoteActionCompat.f2480c = aVar.a(remoteActionCompat.f2480c, 3);
        remoteActionCompat.f2481d = (PendingIntent) aVar.a((a) remoteActionCompat.f2481d, 4);
        remoteActionCompat.f2482e = aVar.a(remoteActionCompat.f2482e, 5);
        remoteActionCompat.f2483f = aVar.a(remoteActionCompat.f2483f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.a(false, false);
        aVar.b(remoteActionCompat.f2478a, 1);
        aVar.b(remoteActionCompat.f2479b, 2);
        aVar.b(remoteActionCompat.f2480c, 3);
        aVar.b(remoteActionCompat.f2481d, 4);
        aVar.b(remoteActionCompat.f2482e, 5);
        aVar.b(remoteActionCompat.f2483f, 6);
    }
}
