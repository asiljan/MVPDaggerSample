package com.siljan.alen.mvpdaggersample.common.helpers;

import com.siljan.alen.mvpdaggersample.BuildConfig;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class LogHelper {

    private static final String TAG = "MVPDaggerExample";
    private static final boolean DEBUG_ENABLED = BuildConfig.DEBUG;

    private LogHelper() {

    }

    public static void printLogMessage(String msg) {
        if (DEBUG_ENABLED) {
            System.out.println(String.format("%s: %s", TAG, msg));
        }
    }
}
