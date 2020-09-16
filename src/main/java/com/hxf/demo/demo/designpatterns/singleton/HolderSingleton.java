package com.hxf.demo.demo.designpatterns.singleton;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/8 15:10
 */
public class HolderSingleton {
    /**
     *  类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *  没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static HolderSingleton instance = new HolderSingleton();
    }

    private HolderSingleton() {
    }

    public static HolderSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
