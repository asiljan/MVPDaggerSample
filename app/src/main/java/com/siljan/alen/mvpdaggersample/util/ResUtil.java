package com.siljan.alen.mvpdaggersample.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class ResUtil {
    private ResUtil() {

    }

    public static int getColor(Context context, int resID) {
        if (context != null) {
            return ContextCompat.getColor(context, resID);
        }

        return 0;
    }

    public static Drawable getDrawable(Context context, int resID) {
        if (context != null) {
            return ContextCompat.getDrawable(context, resID);
        }

        return null;
    }

    public static String getStringById(Context context, int resID) {
        return context != null ? context.getString(resID) : "";
    }
}
