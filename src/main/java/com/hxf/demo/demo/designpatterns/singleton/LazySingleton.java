package com.hxf.demo.demo.designpatterns.singleton;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/8 14:31
 * 懒汉式 该模式的特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
 * <p>
 * 注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
 * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
 */
public class LazySingleton {
    private static volatile LazySingleton singleton = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
             singleton = new LazySingleton();
        }
        return singleton;
    }

}
