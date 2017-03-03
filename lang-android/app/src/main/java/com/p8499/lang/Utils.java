package com.p8499.lang;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2/18/2017.
 */

public class Utils {
    public static Pattern cellPattern = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$");

    public static SharedPreferences getPreferenceCredential(Context context) {
        return context.getSharedPreferences("credential", Context.MODE_PRIVATE);
    }

    public static String getCachePath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }

    public static File getPortraitThumbnailPath(Context context) {
        return new File(getCachePath(context), "portrait-thumbnail.png");
    }

    public static File getPvThumbnailPath(Context context) {
        return new File(getCachePath(context), "pv-thumbnail.png");
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static void setWindowGravity(Window window, int gravity) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = gravity;
        window.setAttributes(attributes);
    }
}
