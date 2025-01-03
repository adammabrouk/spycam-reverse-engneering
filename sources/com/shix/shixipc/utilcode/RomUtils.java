package com.shix.shixipc.utilcode;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: classes.dex */
public final class RomUtils {
    public static final String UNKNOWN = "unknown";
    public static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    public static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    public static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    public static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    public static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    public static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    public static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    public static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    public static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    public static RomInfo bean;
    public static final String[] ROM_HUAWEI = {"huawei"};
    public static final String[] ROM_VIVO = {"vivo"};
    public static final String[] ROM_XIAOMI = {"xiaomi"};
    public static final String[] ROM_OPPO = {"oppo"};
    public static final String[] ROM_LEECO = {"leeco", "letv"};
    public static final String[] ROM_360 = {"360", "qiku"};
    public static final String[] ROM_ZTE = {"zte"};
    public static final String[] ROM_ONEPLUS = {"oneplus"};
    public static final String[] ROM_NUBIA = {"nubia"};
    public static final String[] ROM_COOLPAD = {"coolpad", "yulong"};
    public static final String[] ROM_LG = {"lg", "lge"};
    public static final String[] ROM_GOOGLE = {"google"};
    public static final String[] ROM_SAMSUNG = {"samsung"};
    public static final String[] ROM_MEIZU = {"meizu"};
    public static final String[] ROM_LENOVO = {"lenovo"};
    public static final String[] ROM_SMARTISAN = {"smartisan", "deltainno"};
    public static final String[] ROM_HTC = {"htc"};
    public static final String[] ROM_SONY = {"sony"};
    public static final String[] ROM_GIONEE = {"gionee", "amigo"};
    public static final String[] ROM_MOTOROLA = {"motorola"};

    public static class RomInfo {
        public String name;
        public String version;

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + "}";
        }
    }

    public RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getBrand() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo = bean;
        if (romInfo != null) {
            return romInfo;
        }
        bean = new RomInfo();
        String brand = getBrand();
        String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, ROM_HUAWEI)) {
            bean.name = ROM_HUAWEI[0];
            String romVersion = getRomVersion("ro.build.version.emui");
            String[] split = romVersion.split("_");
            if (split.length > 1) {
                bean.version = split[1];
            } else {
                bean.version = romVersion;
            }
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_VIVO)) {
            bean.name = ROM_VIVO[0];
            bean.version = getRomVersion(VERSION_PROPERTY_VIVO);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_XIAOMI)) {
            bean.name = ROM_XIAOMI[0];
            bean.version = getRomVersion(VERSION_PROPERTY_XIAOMI);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_OPPO)) {
            bean.name = ROM_OPPO[0];
            bean.version = getRomVersion("ro.build.version.opporom");
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_LEECO)) {
            bean.name = ROM_LEECO[0];
            bean.version = getRomVersion(VERSION_PROPERTY_LEECO);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_360)) {
            bean.name = ROM_360[0];
            bean.version = getRomVersion(VERSION_PROPERTY_360);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_ZTE)) {
            bean.name = ROM_ZTE[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ZTE);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_ONEPLUS)) {
            bean.name = ROM_ONEPLUS[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ONEPLUS);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_NUBIA)) {
            bean.name = ROM_NUBIA[0];
            bean.version = getRomVersion(VERSION_PROPERTY_NUBIA);
            return bean;
        }
        if (isRightRom(brand, manufacturer, ROM_COOLPAD)) {
            bean.name = ROM_COOLPAD[0];
        } else if (isRightRom(brand, manufacturer, ROM_LG)) {
            bean.name = ROM_LG[0];
        } else if (isRightRom(brand, manufacturer, ROM_GOOGLE)) {
            bean.name = ROM_GOOGLE[0];
        } else if (isRightRom(brand, manufacturer, ROM_SAMSUNG)) {
            bean.name = ROM_SAMSUNG[0];
        } else if (isRightRom(brand, manufacturer, ROM_MEIZU)) {
            bean.name = ROM_MEIZU[0];
        } else if (isRightRom(brand, manufacturer, ROM_LENOVO)) {
            bean.name = ROM_LENOVO[0];
        } else if (isRightRom(brand, manufacturer, ROM_SMARTISAN)) {
            bean.name = ROM_SMARTISAN[0];
        } else if (isRightRom(brand, manufacturer, ROM_HTC)) {
            bean.name = ROM_HTC[0];
        } else if (isRightRom(brand, manufacturer, ROM_SONY)) {
            bean.name = ROM_SONY[0];
        } else if (isRightRom(brand, manufacturer, ROM_GIONEE)) {
            bean.name = ROM_GIONEE[0];
        } else if (isRightRom(brand, manufacturer, ROM_MOTOROLA)) {
            bean.name = ROM_MOTOROLA[0];
        } else {
            bean.name = manufacturer;
        }
        bean.version = getRomVersion("");
        return bean;
    }

    public static String getRomVersion(String str) {
        String systemProperty = !TextUtils.isEmpty(str) ? getSystemProperty(str) : "";
        if (TextUtils.isEmpty(systemProperty) || systemProperty.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    systemProperty = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(systemProperty) ? "unknown" : systemProperty;
    }

    public static String getSystemProperty(String str) {
        String systemPropertyByShell = getSystemPropertyByShell(str);
        if (!TextUtils.isEmpty(systemPropertyByShell)) {
            return systemPropertyByShell;
        }
        String systemPropertyByStream = getSystemPropertyByStream(str);
        return (TextUtils.isEmpty(systemPropertyByStream) && Build.VERSION.SDK_INT < 28) ? getSystemPropertyByReflect(str) : systemPropertyByStream;
    }

    public static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getSystemPropertyByShell(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    readLine = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (readLine != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return readLine;
            }
            bufferedReader.close();
            return "";
        } catch (IOException unused5) {
            return "";
        }
    }

    public static String getSystemPropertyByStream(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean is360() {
        return ROM_360[0].equals(getRomInfo().name);
    }

    public static boolean isCoolpad() {
        return ROM_COOLPAD[0].equals(getRomInfo().name);
    }

    public static boolean isGionee() {
        return ROM_GIONEE[0].equals(getRomInfo().name);
    }

    public static boolean isGoogle() {
        return ROM_GOOGLE[0].equals(getRomInfo().name);
    }

    public static boolean isHtc() {
        return ROM_HTC[0].equals(getRomInfo().name);
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI[0].equals(getRomInfo().name);
    }

    public static boolean isLeeco() {
        return ROM_LEECO[0].equals(getRomInfo().name);
    }

    public static boolean isLenovo() {
        return ROM_LENOVO[0].equals(getRomInfo().name);
    }

    public static boolean isLg() {
        return ROM_LG[0].equals(getRomInfo().name);
    }

    public static boolean isMeizu() {
        return ROM_MEIZU[0].equals(getRomInfo().name);
    }

    public static boolean isMotorola() {
        return ROM_MOTOROLA[0].equals(getRomInfo().name);
    }

    public static boolean isNubia() {
        return ROM_NUBIA[0].equals(getRomInfo().name);
    }

    public static boolean isOneplus() {
        return ROM_ONEPLUS[0].equals(getRomInfo().name);
    }

    public static boolean isOppo() {
        return ROM_OPPO[0].equals(getRomInfo().name);
    }

    public static boolean isRightRom(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSamsung() {
        return ROM_SAMSUNG[0].equals(getRomInfo().name);
    }

    public static boolean isSmartisan() {
        return ROM_SMARTISAN[0].equals(getRomInfo().name);
    }

    public static boolean isSony() {
        return ROM_SONY[0].equals(getRomInfo().name);
    }

    public static boolean isVivo() {
        return ROM_VIVO[0].equals(getRomInfo().name);
    }

    public static boolean isXiaomi() {
        return ROM_XIAOMI[0].equals(getRomInfo().name);
    }

    public static boolean isZte() {
        return ROM_ZTE[0].equals(getRomInfo().name);
    }
}
