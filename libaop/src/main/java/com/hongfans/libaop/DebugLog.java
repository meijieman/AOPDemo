package com.hongfans.libaop;

import android.util.Log;

/**
 * TODO
 * Created by MEI on 2017/11/27.
 */

public class DebugLog {

    private DebugLog() {}

    /**
     * Send a debug log message
     *
     * @param tag Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.e(tag, message);
    }
}
