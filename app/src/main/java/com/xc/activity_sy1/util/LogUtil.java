package com.xc.activity_sy1.util;

import android.util.Log;

public final class LogUtil {
    public static final String LOG_TAG = "test_log_tag";
    public static void debug(String message) {
        Log.d(LOG_TAG, message);
    }

    public static void info(String message) {
        Log.i(LOG_TAG, message);
    }

    public static void warn(String message) {
        Log.w(LOG_TAG, message);
    }

    public static void error(String message) {
        Log.e(LOG_TAG, message);
    }
}
