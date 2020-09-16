package com.hxf.demo.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/9/15 11:06
 */
public class TestFastJson {

    List<Person> list = new ArrayList<Person>();
    Person p = new Person("ZhangSan", 23);

    /**
     *  测试main
     */
    public static void main(String[] args) {
       new TestFastJson().test1();

//        new TestFastJson().test2();
    }

    /**
     * 未关闭引用检测,转化字符串时会出现$ref
     */
    public void test1() {
        list.add(p);
        list.add(p);
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
    }

    /**
     * 关闭引用检测后,$ref的问题就会被解决
     */
    public void test2() {
        list.add(p);
        list.add(p);
        String jsonStr = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonStr);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;

}
