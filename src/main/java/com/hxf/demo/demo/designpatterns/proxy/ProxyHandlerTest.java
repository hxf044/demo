package com.hxf.demo.demo.designpatterns.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 14:27
 */
@Slf4j
public class ProxyHandlerTest {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface hello = new Hello();
        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
