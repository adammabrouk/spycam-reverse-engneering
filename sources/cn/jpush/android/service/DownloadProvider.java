package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import cn.jiguang.as.d;
import cn.jiguang.az.e;
import cn.jiguang.internal.JCoreInternalHelper;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class DownloadProvider extends ContentProvider {
    public static final String TAG = "DownloadProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            d.c(TAG, "method:" + str + ", arg=" + str2);
            return JCoreInternalHelper.getInstance().directHandle(getContext(), str, str2, bundle);
        } catch (Throwable th) {
            d.g(TAG, "call e:" + th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        d.c(TAG, "DownloadProvider query:" + uri);
        try {
            String queryParameter = uri.getQueryParameter("from_package");
            Bundle bundle = new Bundle();
            bundle.putString("from_package", queryParameter);
            bundle.putInt(ContentCommon.TYPE, 4);
            e.a(getContext(), "waked", bundle);
            return null;
        } catch (Throwable th) {
            d.g(TAG, "wake error:" + th.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
