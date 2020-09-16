package com.hxf.demo.demo.designpatterns.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/20 15:28
 * 观察者模式
 */
public class Subject {
    /**
     * 观察者集合
     */
    private final List<Observer> observers = Lists.newArrayList();

    private int state;

    public int getState() {
        return state;
    }

    /**
     * 状态变更
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 消息通知
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
