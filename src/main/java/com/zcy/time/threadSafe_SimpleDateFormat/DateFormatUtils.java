package com.zcy.time.threadSafe_SimpleDateFormat;

import java.text.SimpleDateFormat;

public class DateFormatUtils {

    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private DateFormatUtils() {
    }

    public static void set(String pattern) {
        threadLocal.set(new SimpleDateFormat(pattern));
    }

    public static SimpleDateFormat get() {
        return threadLocal.get();
    }
}
