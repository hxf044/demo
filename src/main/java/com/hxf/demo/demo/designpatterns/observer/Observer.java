package com.hxf.demo.demo.designpatterns.observer;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/20 15:29
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
