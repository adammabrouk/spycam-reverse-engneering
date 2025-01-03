package com.shix.shixipc.utils;

import android.content.SharedPreferences;
import com.shix.shixipc.CrashApplication;

/* loaded from: classes.dex */
public class SharedPreferencesUtils {
    public static final String USER_NAME = "name";
    public static SharedPreferencesUtils instance;
    public String SHARED_NAME = "shix_sp";
    public SharedPreferences.Editor editor;
    public SharedPreferences share;

    public SharedPreferencesUtils() {
        SharedPreferences sharedPreferences = CrashApplication.getContext().getSharedPreferences(this.SHARED_NAME, 0);
        this.share = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtils getInstance() {
        if (instance == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (instance == null) {
                    instance = new SharedPreferencesUtils();
                }
            }
        }
        return instance;
    }

    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }

    public boolean contains(String str) {
        return this.share.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.share.getBoolean(str, z);
    }

    public float getFloat(String str, float f2) {
        return this.share.getFloat(str, f2);
    }

    public int getInt(String str, int i2) {
        return this.share.getInt(str, i2);
    }

    public long getLong(String str, long j) {
        return this.share.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.share.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z);
        this.editor.commit();
    }

    public void putFloat(String str, float f2) {
        this.editor.putFloat(str, f2);
        this.editor.commit();
    }

    public void putInt(String str, int i2) {
        this.editor.putInt(str, i2);
        this.editor.commit();
    }

    public void putLong(String str, long j) {
        this.editor.putLong(str, j);
        this.editor.commit();
    }

    public void putString(String str, String str2) {
        this.editor.putString(str, str2);
        this.editor.commit();
    }

    public void remove(String str) {
        this.editor.remove(str);
        this.editor.commit();
    }

    public String getString(String str) {
        return this.share.getString(str, "");
    }
}
