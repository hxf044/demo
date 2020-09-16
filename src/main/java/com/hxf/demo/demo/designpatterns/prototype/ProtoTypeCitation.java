package com.hxf.demo.demo.designpatterns.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/9 9:17
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，原型实例指定了要创建的对象的种类。
 * 用这种方式创建对象非常高效，根本无须知道对象创建的细节
 */
public class ProtoTypeCitation {

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation obj1 = new Citation("张三", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
        obj1.display();
        Citation obj2 = obj1.clone();
        System.out.println(obj2 +""+ obj1);
        obj2.setName("李四");
        obj2.display();
    }
}

class Citation implements Cloneable {

    private String name;

    private String info;

    private String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功！");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return (this.name);
    }

    public void display() {
        System.out.println(name + info + college);
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (Citation) super.clone();
    }
}

