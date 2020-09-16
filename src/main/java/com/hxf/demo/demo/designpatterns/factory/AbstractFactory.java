package com.hxf.demo.demo.designpatterns.factory;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/9 11:02
 * 工厂方法模式的主要优点有：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
 * 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
 * <p>
 * 其缺点是：每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Product a = new ConcreteProduct1();
        a.show();
    }
}

interface Product {
    void show();
}

class ConcreteProduct1 implements Product {

    @Override
    public void show() {
        System.out.println("产品实现类1");
    }
}

class ConcreteProduct2 implements Product {

    @Override
    public void show() {
        System.out.println("产品实现类2");
    }
}

class ConcreteProduct3 implements Product {

    @Override
    public void show() {
        System.out.println("产品实现类3");
    }
}

