package com.hxf.demo.demo.designpatterns.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 14:26
 */
@Slf4j
public class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Before invoke " + method.getName());
        method.invoke(object, args);
        log.info("After invoke " + method.getName());
        return null;
    }
}
