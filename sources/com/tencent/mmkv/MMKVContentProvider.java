package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public class MMKVContentProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static Uri f11240a;

    public static Uri a(Context context) {
        String b2;
        Uri uri = f11240a;
        if (uri != null) {
            return uri;
        }
        if (context == null || (b2 = b(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://" + b2);
        f11240a = parse;
        return parse;
    }

    public static String b(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (!str.equals("mmkvFromAshmemID") || bundle == null) {
            return null;
        }
        return a(str2, bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), bundle.getString("KEY_CRYPT"));
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String b2;
        Context context = getContext();
        if (context == null || (b2 = b(context)) == null) {
            return false;
        }
        if (f11240a != null) {
            return true;
        }
        f11240a = Uri.parse("content://" + b2);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public final Bundle a(String str, int i2, int i3, String str2) {
        MMKV a2 = MMKV.a(getContext(), str, i2, i3, str2);
        if (a2 == null) {
            return null;
        }
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(a2);
        Log.i("MMKV", str + " fd = " + a2.ashmemFD() + ", meta fd = " + a2.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", parcelableMMKV);
        return bundle;
    }

    public static String a(Context context, int i2) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i2) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }
}
