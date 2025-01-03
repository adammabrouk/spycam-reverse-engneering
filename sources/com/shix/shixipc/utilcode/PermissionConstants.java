package com.shix.shixipc.utilcode;

import android.annotation.SuppressLint;
import android.os.Build;
import com.hjq.permissions.Permission;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class PermissionConstants {
    public static final String ACTIVITY_RECOGNITION = "ACTIVITY_RECOGNITION";
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACTS = "CONTACTS";
    public static final String LOCATION = "LOCATION";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String PHONE = "PHONE";
    public static final String SENSORS = "SENSORS";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";
    public static final String[] GROUP_CALENDAR = {Permission.READ_CALENDAR, Permission.WRITE_CALENDAR};
    public static final String[] GROUP_CAMERA = {Permission.CAMERA};
    public static final String[] GROUP_CONTACTS = {Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS};
    public static final String[] GROUP_LOCATION = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_BACKGROUND_LOCATION};
    public static final String[] GROUP_MICROPHONE = {Permission.RECORD_AUDIO};
    public static final String[] GROUP_PHONE = {Permission.READ_PHONE_STATE, Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS, Permission.ANSWER_PHONE_CALLS};
    public static final String[] GROUP_PHONE_BELOW_O = {Permission.READ_PHONE_STATE, Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS};
    public static final String[] GROUP_SENSORS = {Permission.BODY_SENSORS};
    public static final String[] GROUP_SMS = {Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS};
    public static final String[] GROUP_STORAGE = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};
    public static final String[] GROUP_ACTIVITY_RECOGNITION = {Permission.ACTIVITY_RECOGNITION};

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    public static String[] getPermissions(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "CALENDAR":
                return GROUP_CALENDAR;
            case "CAMERA":
                return GROUP_CAMERA;
            case "CONTACTS":
                return GROUP_CONTACTS;
            case "LOCATION":
                return GROUP_LOCATION;
            case "MICROPHONE":
                return GROUP_MICROPHONE;
            case "PHONE":
                return Build.VERSION.SDK_INT < 26 ? GROUP_PHONE_BELOW_O : GROUP_PHONE;
            case "SENSORS":
                return GROUP_SENSORS;
            case "SMS":
                return GROUP_SMS;
            case "STORAGE":
                return GROUP_STORAGE;
            case "ACTIVITY_RECOGNITION":
                return GROUP_ACTIVITY_RECOGNITION;
            default:
                return new String[]{str};
        }
    }
}
