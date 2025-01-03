package c.k.d;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;

/* loaded from: classes.dex */
public class b {
    public static long a() {
        File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m77a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return true;
        }
    }

    public static boolean c() {
        return a() <= OSSConstants.MIN_PART_SIZE_LIMIT;
    }

    public static boolean d() {
        return (b() || c() || m77a()) ? false : true;
    }
}
