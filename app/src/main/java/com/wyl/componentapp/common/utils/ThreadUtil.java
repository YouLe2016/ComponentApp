package com.wyl.componentapp.common.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Name: ThreadUtil
 * Action:
 * Author: liuan
 * creatTime:2017-02-14 11:43
 */

public class ThreadUtil {
    private static Executor executor = Executors.newSingleThreadExecutor();
    private static Handler handler = new Handler(Looper.getMainLooper());

    public static void executeSubThread(Runnable runnable) {
        executor.execute(runnable);
    }

    public static void executeMainThread(Runnable runnable) {
        handler.post(runnable);
    }

}