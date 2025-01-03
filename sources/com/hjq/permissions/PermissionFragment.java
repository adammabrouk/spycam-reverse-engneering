package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(23)
/* loaded from: classes.dex */
public final class PermissionFragment extends Fragment implements Runnable {
    public static final String REQUEST_CODE = "request_code";
    public static final SparseBooleanArray REQUEST_CODE_ARRAY = new SparseBooleanArray();
    public static final String REQUEST_PERMISSIONS = "request_permissions";
    public static final String USE_INTERCEPTOR = "use_interceptor";
    public OnPermissionCallback mCallBack;
    public boolean mDangerousRequest;
    public int mScreenOrientation;
    public boolean mSpecialRequest;

    public static void beginRequest(Activity activity, ArrayList<String> arrayList, OnPermissionCallback onPermissionCallback) {
        beginRequest(activity, arrayList, true, onPermissionCallback);
    }

    public void attachActivity(Activity activity) {
        activity.getFragmentManager().beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachActivity(Activity activity) {
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || i2 != arguments.getInt(REQUEST_CODE) || this.mDangerousRequest) {
            return;
        }
        this.mDangerousRequest = true;
        activity.getWindow().getDecorView().postDelayed(this, 200L);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.mScreenOrientation = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        int i2 = activity.getResources().getConfiguration().orientation;
        try {
            if (i2 == 2) {
                activity.setRequestedOrientation(0);
            } else if (i2 != 1) {
            } else {
                activity.setRequestedOrientation(1);
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.mScreenOrientation != -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.mCallBack == null || i2 != arguments.getInt(REQUEST_CODE)) {
            return;
        }
        boolean z = arguments.getBoolean(USE_INTERCEPTOR);
        OnPermissionCallback onPermissionCallback = this.mCallBack;
        this.mCallBack = null;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (PermissionUtils.isSpecialPermission(str)) {
                iArr[i3] = PermissionUtils.getPermissionStatus(activity, str);
            } else if (!PermissionUtils.isAndroid10() && (Permission.ACCESS_BACKGROUND_LOCATION.equals(str) || Permission.ACTIVITY_RECOGNITION.equals(str) || Permission.ACCESS_MEDIA_LOCATION.equals(str))) {
                iArr[i3] = PermissionUtils.getPermissionStatus(activity, str);
            } else if (!PermissionUtils.isAndroid9() && Permission.ACCEPT_HANDOVER.equals(str)) {
                iArr[i3] = PermissionUtils.getPermissionStatus(activity, str);
            } else if (!PermissionUtils.isAndroid8() && (Permission.ANSWER_PHONE_CALLS.equals(str) || Permission.READ_PHONE_NUMBERS.equals(str))) {
                iArr[i3] = PermissionUtils.getPermissionStatus(activity, str);
            }
        }
        REQUEST_CODE_ARRAY.delete(i2);
        detachActivity(activity);
        List<String> grantedPermissions = PermissionUtils.getGrantedPermissions(strArr, iArr);
        if (grantedPermissions.size() == strArr.length) {
            if (z) {
                XXPermissions.getInterceptor().grantedPermissions(activity, onPermissionCallback, grantedPermissions, true);
                return;
            } else {
                onPermissionCallback.onGranted(grantedPermissions, true);
                return;
            }
        }
        List<String> deniedPermissions = PermissionUtils.getDeniedPermissions(strArr, iArr);
        if (z) {
            XXPermissions.getInterceptor().deniedPermissions(activity, onPermissionCallback, deniedPermissions, PermissionUtils.isPermissionPermanentDenied(activity, deniedPermissions));
        } else {
            onPermissionCallback.onDenied(deniedPermissions, PermissionUtils.isPermissionPermanentDenied(activity, deniedPermissions));
        }
        if (grantedPermissions.isEmpty()) {
            return;
        }
        if (z) {
            XXPermissions.getInterceptor().grantedPermissions(activity, onPermissionCallback, grantedPermissions, false);
        } else {
            onPermissionCallback.onDenied(grantedPermissions, false);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mSpecialRequest) {
            return;
        }
        this.mSpecialRequest = true;
        requestSpecialPermission();
    }

    public void requestDangerousPermission() {
        final Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        final int i2 = arguments.getInt(REQUEST_CODE);
        final ArrayList<String> stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS);
        if (stringArrayList == null || stringArrayList.size() == 0) {
            return;
        }
        ArrayList arrayList = null;
        if (PermissionUtils.isAndroid10() && stringArrayList.contains(Permission.ACCESS_BACKGROUND_LOCATION)) {
            arrayList = new ArrayList();
            if (stringArrayList.contains(Permission.ACCESS_COARSE_LOCATION)) {
                arrayList.add(Permission.ACCESS_COARSE_LOCATION);
            }
            if (stringArrayList.contains(Permission.ACCESS_FINE_LOCATION)) {
                arrayList.add(Permission.ACCESS_FINE_LOCATION);
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), getArguments().getInt(REQUEST_CODE));
        } else {
            beginRequest(activity, arrayList, false, new OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.1
                @Override // com.hjq.permissions.OnPermissionCallback
                public void onDenied(List<String> list, boolean z) {
                    if (PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[stringArrayList.size()];
                        Arrays.fill(iArr, -1);
                        PermissionFragment.this.onRequestPermissionsResult(i2, (String[]) stringArrayList.toArray(new String[0]), iArr);
                    }
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onGranted(List<String> list, boolean z) {
                    if (z && PermissionFragment.this.isAdded()) {
                        PermissionFragment.beginRequest(activity, PermissionUtils.asArrayList(Permission.ACCESS_BACKGROUND_LOCATION), false, new OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.1.1
                            @Override // com.hjq.permissions.OnPermissionCallback
                            public void onDenied(List<String> list2, boolean z2) {
                                if (PermissionFragment.this.isAdded()) {
                                    int[] iArr = new int[stringArrayList.size()];
                                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                                        iArr[i3] = Permission.ACCESS_BACKGROUND_LOCATION.equals(stringArrayList.get(i3)) ? -1 : 0;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    PermissionFragment.this.onRequestPermissionsResult(i2, (String[]) stringArrayList.toArray(new String[0]), iArr);
                                }
                            }

                            @Override // com.hjq.permissions.OnPermissionCallback
                            public void onGranted(List<String> list2, boolean z2) {
                                if (z2 && PermissionFragment.this.isAdded()) {
                                    int[] iArr = new int[stringArrayList.size()];
                                    Arrays.fill(iArr, 0);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    PermissionFragment.this.onRequestPermissionsResult(i2, (String[]) stringArrayList.toArray(new String[0]), iArr);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void requestSpecialPermission() {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS);
        boolean z = false;
        if (PermissionUtils.containsSpecialPermission(stringArrayList)) {
            if (stringArrayList.contains(Permission.MANAGE_EXTERNAL_STORAGE) && !PermissionUtils.isGrantedStoragePermission(activity) && PermissionUtils.isAndroid11()) {
                startActivityForResult(PermissionSettingPage.getStoragePermissionIntent(activity), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
            if (stringArrayList.contains(Permission.REQUEST_INSTALL_PACKAGES) && !PermissionUtils.isGrantedInstallPermission(activity)) {
                startActivityForResult(PermissionSettingPage.getInstallPermissionIntent(activity), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
            if (stringArrayList.contains(Permission.SYSTEM_ALERT_WINDOW) && !PermissionUtils.isGrantedWindowPermission(activity)) {
                startActivityForResult(PermissionSettingPage.getWindowPermissionIntent(activity), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
            if (stringArrayList.contains(Permission.NOTIFICATION_SERVICE) && !PermissionUtils.isGrantedNotifyPermission(activity)) {
                startActivityForResult(PermissionSettingPage.getNotifyPermissionIntent(activity), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
            if (stringArrayList.contains(Permission.WRITE_SETTINGS) && !PermissionUtils.isGrantedSettingPermission(activity)) {
                startActivityForResult(PermissionSettingPage.getSettingPermissionIntent(activity), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
        }
        if (z) {
            return;
        }
        requestDangerousPermission();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            requestDangerousPermission();
        }
    }

    public void setCallBack(OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    public static void beginRequest(Activity activity, ArrayList<String> arrayList, boolean z, OnPermissionCallback onPermissionCallback) {
        int randomRequestCode;
        PermissionFragment permissionFragment = new PermissionFragment();
        Bundle bundle = new Bundle();
        do {
            randomRequestCode = PermissionUtils.getRandomRequestCode();
        } while (REQUEST_CODE_ARRAY.get(randomRequestCode));
        REQUEST_CODE_ARRAY.put(randomRequestCode, true);
        bundle.putInt(REQUEST_CODE, randomRequestCode);
        bundle.putStringArrayList(REQUEST_PERMISSIONS, arrayList);
        bundle.putBoolean(USE_INTERCEPTOR, z);
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setCallBack(onPermissionCallback);
        permissionFragment.attachActivity(activity);
    }
}
