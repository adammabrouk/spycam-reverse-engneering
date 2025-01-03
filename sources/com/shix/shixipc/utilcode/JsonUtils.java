package com.shix.shixipc.utilcode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class JsonUtils {
    public static final byte TYPE_BOOLEAN = 0;
    public static final byte TYPE_DOUBLE = 3;
    public static final byte TYPE_INT = 1;
    public static final byte TYPE_JSON_ARRAY = 6;
    public static final byte TYPE_JSON_OBJECT = 5;
    public static final byte TYPE_LONG = 2;
    public static final byte TYPE_STRING = 4;

    public JsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String formatJson(String str) {
        return formatJson(str, 4);
    }

    public static boolean getBoolean(JSONObject jSONObject, String str) {
        return getBoolean(jSONObject, str, false);
    }

    public static double getDouble(JSONObject jSONObject, String str) {
        return getDouble(jSONObject, str, -1.0d);
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, -1);
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        return (JSONArray) getValueByType(jSONObject, str, jSONArray, (byte) 6);
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        return (JSONObject) getValueByType(jSONObject, str, jSONObject2, (byte) 5);
    }

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, -1L);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static <T> T getValueByType(JSONObject jSONObject, String str, T t, byte b2) {
        T t2;
        if (jSONObject != null && str != null && str.length() != 0) {
            try {
                if (b2 == 0) {
                    t2 = (T) Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (b2 == 1) {
                    t2 = (T) Integer.valueOf(jSONObject.getInt(str));
                } else if (b2 == 2) {
                    t2 = (T) Long.valueOf(jSONObject.getLong(str));
                } else if (b2 == 3) {
                    t2 = (T) Double.valueOf(jSONObject.getDouble(str));
                } else if (b2 == 4) {
                    t2 = (T) jSONObject.getString(str);
                } else if (b2 == 5) {
                    t2 = (T) jSONObject.getJSONObject(str);
                } else if (b2 == 6) {
                    t2 = (T) jSONObject.getJSONArray(str);
                }
                return t2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return t;
    }

    public static <T> boolean isJSONArray(T t) {
        return t instanceof JSONArray;
    }

    public static <T> boolean isJSONObject(T t) {
        return t instanceof JSONObject;
    }

    public static String formatJson(String str, int i2) {
        try {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '{') {
                    return new JSONObject(str).toString(i2);
                }
                if (charAt == '[') {
                    return new JSONArray(str).toString(i2);
                }
                if (!Character.isWhitespace(charAt)) {
                    return str;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        return ((Boolean) getValueByType(jSONObject, str, Boolean.valueOf(z), (byte) 0)).booleanValue();
    }

    public static double getDouble(JSONObject jSONObject, String str, double d2) {
        return ((Double) getValueByType(jSONObject, str, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static int getInt(JSONObject jSONObject, String str, int i2) {
        return ((Integer) getValueByType(jSONObject, str, Integer.valueOf(i2), (byte) 1)).intValue();
    }

    public static JSONArray getJSONArray(String str, String str2, JSONArray jSONArray) {
        return (JSONArray) getValueByType(str, str2, jSONArray, (byte) 6);
    }

    public static JSONObject getJSONObject(String str, String str2, JSONObject jSONObject) {
        return (JSONObject) getValueByType(str, str2, jSONObject, (byte) 5);
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        return ((Long) getValueByType(jSONObject, str, Long.valueOf(j), (byte) 2)).longValue();
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        return (String) getValueByType(jSONObject, str, str2, (byte) 4);
    }

    public static boolean getBoolean(String str, String str2) {
        return getBoolean(str, str2, false);
    }

    public static double getDouble(String str, String str2) {
        return getDouble(str, str2, -1.0d);
    }

    public static int getInt(String str, String str2) {
        return getInt(str, str2, -1);
    }

    public static long getLong(String str, String str2) {
        return getLong(str, str2, -1L);
    }

    public static String getString(String str, String str2) {
        return getString(str, str2, "");
    }

    public static boolean getBoolean(String str, String str2, boolean z) {
        return ((Boolean) getValueByType(str, str2, Boolean.valueOf(z), (byte) 0)).booleanValue();
    }

    public static double getDouble(String str, String str2, double d2) {
        return ((Double) getValueByType(str, str2, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static int getInt(String str, String str2, int i2) {
        return ((Integer) getValueByType(str, str2, Integer.valueOf(i2), (byte) 1)).intValue();
    }

    public static long getLong(String str, String str2, long j) {
        return ((Long) getValueByType(str, str2, Long.valueOf(j), (byte) 2)).longValue();
    }

    public static String getString(String str, String str2, String str3) {
        return (String) getValueByType(str, str2, str3, (byte) 4);
    }

    public static <T> T getValueByType(String str, String str2, T t, byte b2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            try {
                return (T) getValueByType(new JSONObject(str), str2, t, b2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return t;
    }
}
