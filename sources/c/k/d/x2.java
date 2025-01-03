package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class x2 extends a3 {
    public x2(Context context, int i2) {
        super(context, i2);
    }

    @Override // c.k.d.j.a
    public int a() {
        return 4;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public x6 mo92a() {
        return x6.AppInstallList;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = this.f6950b.getPackageManager();
        StringBuilder sb = new StringBuilder();
        try {
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, RecyclerView.c0.FLAG_IGNORE)) {
                if ((resolveInfo.activityInfo.applicationInfo.flags & 1) == 0) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    String charSequence = resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString();
                    String str = resolveInfo.activityInfo.packageName;
                    sb.append(charSequence);
                    sb.append(",");
                    sb.append(str);
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public boolean mo68a() {
        return true;
    }
}
