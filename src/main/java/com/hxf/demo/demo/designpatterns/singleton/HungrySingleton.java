package com.hxf.demo.demo.designpatterns.singleton;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/8 14:36
 * 饿汉试：该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
 */
public class HungrySingleton {

    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() { }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
