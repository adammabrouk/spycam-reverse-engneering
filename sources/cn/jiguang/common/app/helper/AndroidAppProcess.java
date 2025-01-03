package cn.jiguang.common.app.helper;

import java.io.File;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AndroidAppProcess extends AndroidProcess {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f8843c = new File("/dev/cpuctl/tasks").exists();

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f8844d = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");
}
