package com.hxf.demo.demo.designpatterns.observer;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/20 15:32
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
