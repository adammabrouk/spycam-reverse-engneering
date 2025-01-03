package a.h.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class n implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f947a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final Context f948b;

    /* compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public n(Context context) {
        this.f948b = context;
    }

    public static n a(Context context) {
        return new n(context);
    }

    public void b() {
        a((Bundle) null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f947a.iterator();
    }

    public n a(Intent intent) {
        this.f947a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = e.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f948b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public n a(ComponentName componentName) {
        int size = this.f947a.size();
        try {
            Intent a2 = e.a(this.f948b, componentName);
            while (a2 != null) {
                this.f947a.add(size, a2);
                a2 = e.a(this.f948b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(Bundle bundle) {
        if (!this.f947a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f947a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (a.h.b.a.a(this.f948b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f948b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
