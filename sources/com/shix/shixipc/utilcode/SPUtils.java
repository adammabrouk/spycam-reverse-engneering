package com.shix.shixipc.utilcode;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressLint({"ApplySharedPref"})
/* loaded from: classes.dex */
public final class SPUtils {
    public static final Map<String, SPUtils> SP_UTILS_MAP = new HashMap();
    public SharedPreferences sp;

    public SPUtils(String str) {
        this.sp = Utils.getApp().getSharedPreferences(str, 0);
    }

    public static SPUtils getInstance() {
        return getInstance("", 0);
    }

    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        clear(false);
    }

    public boolean contains(String str) {
        return this.sp.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, Collections.emptySet());
    }

    public void put(String str, String str2) {
        put(str, str2, false);
    }

    public void remove(String str) {
        remove(str, false);
    }

    public static SPUtils getInstance(int i2) {
        return getInstance("", i2);
    }

    public void clear(boolean z) {
        if (z) {
            this.sp.edit().clear().commit();
        } else {
            this.sp.edit().clear().apply();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sp.getBoolean(str, z);
    }

    public float getFloat(String str, float f2) {
        return this.sp.getFloat(str, f2);
    }

    public int getInt(String str, int i2) {
        return this.sp.getInt(str, i2);
    }

    public long getLong(String str, long j) {
        return this.sp.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.sp.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.sp.getStringSet(str, set);
    }

    public void put(String str, String str2, boolean z) {
        if (z) {
            this.sp.edit().putString(str, str2).commit();
        } else {
            this.sp.edit().putString(str, str2).apply();
        }
    }

    public void remove(String str, boolean z) {
        if (z) {
            this.sp.edit().remove(str).commit();
        } else {
            this.sp.edit().remove(str).apply();
        }
    }

    public SPUtils(String str, int i2) {
        this.sp = Utils.getApp().getSharedPreferences(str, i2);
    }

    public static SPUtils getInstance(String str) {
        return getInstance(str, 0);
    }

    public static SPUtils getInstance(String str, int i2) {
        if (isSpace(str)) {
            str = "spUtils";
        }
        SPUtils sPUtils = SP_UTILS_MAP.get(str);
        if (sPUtils == null) {
            synchronized (SPUtils.class) {
                sPUtils = SP_UTILS_MAP.get(str);
                if (sPUtils == null) {
                    sPUtils = new SPUtils(str, i2);
                    SP_UTILS_MAP.put(str, sPUtils);
                }
            }
        }
        return sPUtils;
    }

    public void put(String str, int i2) {
        put(str, i2, false);
    }

    public void put(String str, int i2, boolean z) {
        if (z) {
            this.sp.edit().putInt(str, i2).commit();
        } else {
            this.sp.edit().putInt(str, i2).apply();
        }
    }

    public void put(String str, long j) {
        put(str, j, false);
    }

    public void put(String str, long j, boolean z) {
        if (z) {
            this.sp.edit().putLong(str, j).commit();
        } else {
            this.sp.edit().putLong(str, j).apply();
        }
    }

    public void put(String str, float f2) {
        put(str, f2, false);
    }

    public void put(String str, float f2, boolean z) {
        if (z) {
            this.sp.edit().putFloat(str, f2).commit();
        } else {
            this.sp.edit().putFloat(str, f2).apply();
        }
    }

    public void put(String str, boolean z) {
        put(str, z, false);
    }

    public void put(String str, boolean z, boolean z2) {
        if (z2) {
            this.sp.edit().putBoolean(str, z).commit();
        } else {
            this.sp.edit().putBoolean(str, z).apply();
        }
    }

    public void put(String str, Set<String> set) {
        put(str, set, false);
    }

    public void put(String str, Set<String> set, boolean z) {
        if (z) {
            this.sp.edit().putStringSet(str, set).commit();
        } else {
            this.sp.edit().putStringSet(str, set).apply();
        }
    }
}
