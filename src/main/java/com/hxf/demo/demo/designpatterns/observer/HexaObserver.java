package com.hxf.demo.demo.designpatterns.observer;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/20 15:33
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
