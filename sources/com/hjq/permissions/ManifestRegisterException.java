package com.hjq.permissions;

/* loaded from: classes.dex */
public final class ManifestRegisterException extends RuntimeException {
    public ManifestRegisterException() {
        super("No permissions are registered in the manifest file");
    }

    public ManifestRegisterException(String str) {
        super(str + ": Permissions are not registered in the manifest file");
    }
}
