package com.zan.hu.sys.config;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-14 15:15
 * @Description todo
 **/
public class LoginConfig {

    private static ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();


    public static Boolean get() {
        return threadLocal.get();
    }

    public static void set(Boolean check) {
        threadLocal.set(check);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
