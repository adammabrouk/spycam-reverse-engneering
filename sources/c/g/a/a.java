package c.g.a;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import c.g.a.f.p;
import com.hjq.permissions.Permission;
import f.i.h;
import f.j.b.f;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: PermissionMediator.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public FragmentActivity f6344a;

    /* renamed from: b, reason: collision with root package name */
    public Fragment f6345b;

    public a(FragmentActivity fragmentActivity) {
        f.c(fragmentActivity, "activity");
        this.f6344a = fragmentActivity;
    }

    public final p a(List<String> list) {
        int i2;
        f.c(list, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i3 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.f6344a;
        if (fragmentActivity != null) {
            f.a(fragmentActivity);
            i2 = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.f6345b;
            f.a(fragment);
            i2 = fragment.requireContext().getApplicationInfo().targetSdkVersion;
        }
        for (String str : list) {
            if (c.g.a.e.b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains(Permission.ACCESS_BACKGROUND_LOCATION) && (i3 == 29 || (i3 == 30 && i2 < 30))) {
            linkedHashSet2.remove(Permission.ACCESS_BACKGROUND_LOCATION);
            linkedHashSet.add(Permission.ACCESS_BACKGROUND_LOCATION);
        }
        return new p(this.f6344a, this.f6345b, linkedHashSet, linkedHashSet2);
    }

    public a(Fragment fragment) {
        f.c(fragment, "fragment");
        this.f6345b = fragment;
    }

    public final p a(String... strArr) {
        f.c(strArr, "permissions");
        return a(h.a(Arrays.copyOf(strArr, strArr.length)));
    }
}
