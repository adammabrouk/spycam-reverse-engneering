package com.hichip.widget.photoview.log;

/* loaded from: classes.dex */
public final class LogManager {
    public static Logger logger = new LoggerDefault();

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger2) {
        logger = logger2;
    }
}
