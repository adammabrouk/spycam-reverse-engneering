package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import c.i.a.c;
import c.i.a.d;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public static EnumMap<d, Integer> f11230a;

    /* renamed from: b, reason: collision with root package name */
    public static EnumMap<c, Integer> f11231b;

    /* renamed from: c, reason: collision with root package name */
    public static c[] f11232c;

    /* renamed from: d, reason: collision with root package name */
    public static HashSet<Long> f11233d;

    /* renamed from: e, reason: collision with root package name */
    public static String f11234e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Parcelable.Creator<?>> f11235f;

    /* renamed from: g, reason: collision with root package name */
    public static c.i.a.b f11236g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f11237h;

    /* renamed from: i, reason: collision with root package name */
    public static c.i.a.a f11238i;
    public long nativeHandle;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11239a;

        static {
            int[] iArr = new int[c.values().length];
            f11239a = iArr;
            try {
                iArr[c.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11239a[c.LevelInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11239a[c.LevelWarning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11239a[c.LevelError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11239a[c.LevelNone.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface b {
        void a(String str);
    }

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>((Class<d>) d.class);
        f11230a = enumMap;
        enumMap.put((EnumMap<d, Integer>) d.OnErrorDiscard, (d) 0);
        f11230a.put((EnumMap<d, Integer>) d.OnErrorRecover, (d) 1);
        EnumMap<c, Integer> enumMap2 = new EnumMap<>((Class<c>) c.class);
        f11231b = enumMap2;
        enumMap2.put((EnumMap<c, Integer>) c.LevelDebug, (c) 0);
        f11231b.put((EnumMap<c, Integer>) c.LevelInfo, (c) 1);
        f11231b.put((EnumMap<c, Integer>) c.LevelWarning, (c) 2);
        f11231b.put((EnumMap<c, Integer>) c.LevelError, (c) 3);
        f11231b.put((EnumMap<c, Integer>) c.LevelNone, (c) 4);
        f11232c = new c[]{c.LevelDebug, c.LevelInfo, c.LevelWarning, c.LevelError, c.LevelNone};
        f11233d = new HashSet<>();
        f11234e = null;
        f11235f = new HashMap<>();
        f11237h = false;
    }

    public MMKV(long j) {
        this.nativeHandle = j;
    }

    public static String a(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + "/mmkv";
        a(str, (b) null, c.LevelInfo);
        return str;
    }

    public static native boolean checkProcessMode(long j);

    private native boolean containsKey(long j, String str);

    private native long count(long j);

    public static native long createNB(int i2);

    private native boolean decodeBool(long j, String str, boolean z);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d2);

    private native float decodeFloat(long j, String str, float f2);

    private native int decodeInt(long j, String str, int i2);

    private native long decodeLong(long j, String str, long j2);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    public static native void destroyNB(long j, int i2);

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBytes(long j, String str, byte[] bArr);

    private native boolean encodeDouble(long j, String str, double d2);

    private native boolean encodeFloat(long j, String str, float f2);

    private native boolean encodeInt(long j, String str, int i2);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    public static native long getDefaultMMKV(int i2, String str);

    public static native long getMMKVWithAshmemFD(String str, int i2, int i3, String str2);

    public static native long getMMKVWithID(String str, int i2, String str2, String str3);

    public static native long getMMKVWithIDAndSize(String str, int i2, int i3, String str2);

    public static native boolean isFileValid(String str);

    public static native void jniInitialize(String str, int i2);

    public static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        c.i.a.b bVar = f11236g;
        if (bVar != null && f11237h) {
            bVar.a(f11232c[i2], str, i3, str2, str3);
            return;
        }
        int i4 = a.f11239a[f11232c[i2].ordinal()];
        if (i4 == 1) {
            Log.d("MMKV", str3);
            return;
        }
        if (i4 == 2) {
            Log.i("MMKV", str3);
        } else if (i4 == 3) {
            Log.w("MMKV", str3);
        } else {
            if (i4 != 4) {
                return;
            }
            Log.e("MMKV", str3);
        }
    }

    public static void onContentChangedByOuterProcess(String str) {
        c.i.a.a aVar = f11238i;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public static native void onExit();

    public static int onMMKVCRCCheckFail(String str) {
        d dVar = d.OnErrorDiscard;
        c.i.a.b bVar = f11236g;
        if (bVar != null) {
            dVar = bVar.b(str);
        }
        a(c.LevelInfo, "Recover strategic for " + str + " is " + dVar);
        Integer num = f11230a.get(dVar);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int onMMKVFileLengthError(String str) {
        d dVar = d.OnErrorDiscard;
        c.i.a.b bVar = f11236g;
        if (bVar != null) {
            dVar = bVar.a(str);
        }
        a(c.LevelInfo, "Recover strategic for " + str + " is " + dVar);
        Integer num = f11230a.get(dVar);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    private native void removeValueForKey(long j, String str);

    public static native void setCallbackHandler(boolean z, boolean z2);

    public static native void setLogLevel(int i2);

    public static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j);

    private native int valueSize(long j, String str, boolean z);

    private native int writeValueToNB(long j, String str, long j2, int i2);

    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public void c(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return a(str);
    }

    public native String cryptKey();

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return a(str, set);
    }

    public native void lock();

    public native String mmapID();

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        encodeInt(this.nativeHandle, str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        b(str, set);
        return this;
    }

    public native boolean reKey(String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        c(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public boolean b(String str, int i2) {
        return encodeInt(this.nativeHandle, str, i2);
    }

    public boolean b(String str, long j) {
        return encodeLong(this.nativeHandle, str, j);
    }

    public static String a(String str, b bVar, c cVar) {
        if (bVar != null) {
            bVar.a("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, a(cVar));
        f11234e = str;
        return str;
    }

    public boolean b(String str, float f2) {
        return encodeFloat(this.nativeHandle, str, f2);
    }

    public boolean b(String str, double d2) {
        return encodeDouble(this.nativeHandle, str, d2);
    }

    public boolean b(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean b(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[0]));
    }

    public static int a(c cVar) {
        int i2 = a.f11239a[cVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return 2;
            }
            if (i2 == 4) {
                return 3;
            }
            if (i2 == 5) {
                return 4;
            }
        }
        return 1;
    }

    public boolean b(String str, byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public static MMKV a(Context context, String str, int i2, int i3, String str2) {
        if (f11234e != null) {
            String a2 = MMKVContentProvider.a(context, Process.myPid());
            if (a2 != null && a2.length() != 0) {
                if (a2.contains(":")) {
                    Uri a3 = MMKVContentProvider.a(context);
                    if (a3 == null) {
                        a(c.LevelError, "MMKVContentProvider has invalid authority");
                        return null;
                    }
                    a(c.LevelInfo, "getting parcelable mmkv in process, Uri = " + a3);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KEY_SIZE", i2);
                    bundle.putInt("KEY_MODE", i3);
                    if (str2 != null) {
                        bundle.putString("KEY_CRYPT", str2);
                    }
                    Bundle call = context.getContentResolver().call(a3, "mmkvFromAshmemID", str, bundle);
                    if (call != null) {
                        call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                        ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                        if (parcelableMMKV != null) {
                            MMKV a4 = parcelableMMKV.a();
                            if (a4 != null) {
                                a(c.LevelInfo, a4.mmapID() + " fd = " + a4.ashmemFD() + ", meta fd = " + a4.ashmemMetaFD());
                            }
                            return a4;
                        }
                    }
                    return null;
                }
                a(c.LevelInfo, "getting mmkv in main process");
                return new MMKV(getMMKVWithIDAndSize(str, i2, i3 | 8, str2));
            }
            a(c.LevelError, "process name detect fail, try again later");
            return null;
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public byte[] b(String str) {
        return a(str, (byte[]) null);
    }

    public static MMKV a() {
        if (f11234e != null) {
            return a(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV a(long j, String str, int i2) {
        String str2;
        if (j == 0) {
            return null;
        }
        if (!f11233d.contains(Long.valueOf(j))) {
            if (!checkProcessMode(j)) {
                if (i2 == 1) {
                    str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                } else {
                    str2 = ("Opening a MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                }
                throw new IllegalArgumentException(str2);
            }
            f11233d.add(Long.valueOf(j));
        }
        return new MMKV(j);
    }

    public boolean a(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public int a(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    public long a(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public float a(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    public double a(String str, double d2) {
        return decodeDouble(this.nativeHandle, str, d2);
    }

    public String a(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public Set<String> a(String str, Set<String> set) {
        return a(str, set, HashSet.class);
    }

    public Set<String> a(String str, Set<String> set, Class<? extends Set> cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set<String> newInstance = cls.newInstance();
            newInstance.addAll(Arrays.asList(decodeStringSet));
            return newInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public byte[] a(String str, byte[] bArr) {
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        return decodeBytes != null ? decodeBytes : bArr;
    }

    public boolean a(String str, Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, parcelable.describeContents());
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return encodeBytes(this.nativeHandle, str, marshall);
    }

    public <T extends Parcelable> T a(String str, Class<T> cls) {
        return (T) a(str, (Class<Class<T>>) cls, (Class<T>) null);
    }

    public <T extends Parcelable> T a(String str, Class<T> cls, T t) {
        byte[] decodeBytes;
        Parcelable.Creator<?> creator;
        if (cls == null || (decodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        try {
            String cls2 = cls.toString();
            synchronized (f11235f) {
                creator = f11235f.get(cls2);
                if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    f11235f.put(cls2, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(obtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + cls2);
        } catch (Exception e2) {
            a(c.LevelError, e2.toString());
            return t;
        } finally {
            obtain.recycle();
        }
    }

    public boolean a(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public static MMKV a(String str, int i2, int i3, String str2) {
        return new MMKV(getMMKVWithAshmemFD(str, i2, i3, str2));
    }

    public static void a(c cVar, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = f11231b.get(cVar);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }
}
