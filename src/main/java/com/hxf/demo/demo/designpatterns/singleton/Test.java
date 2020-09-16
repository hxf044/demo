package com.hxf.demo.demo.designpatterns.singleton;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/8 14:41
 */
public class Test {

    public static void main(String[] args) {
        LazySingleton singleton = LazySingleton.getInstance();
        LazySingleton singleton1 = LazySingleton.getInstance();
        System.out.println(singleton.equals(singleton1) ? "相同" : "不相同");
    }
}
