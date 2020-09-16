package com.hxf.demo.demo.designpatterns.observer;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/20 15:31
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }

}
