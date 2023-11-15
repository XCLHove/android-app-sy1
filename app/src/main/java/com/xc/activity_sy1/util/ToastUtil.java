package com.xc.activity_sy1.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    /**
     * 显示Toast消息
     * @param context 上下文
     * @param text 消息内容
     */
    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_LONG);
    }

    /**
     * 显示Toast消息
     * @param context 上下文
     * @param text 消息内容
     * @param duration 持续时间(0：短，1：长)
     */
    public static void showToast(Context context, String text, int duration) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
