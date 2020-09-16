package com.hxf.demo.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/10 11:44
 */
public class Test1 {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            User user = new User(i);
            list.add(user);
        }
        long l = System.currentTimeMillis();
        System.out.println("开始时间 = " + l);
        List<User> collect = list.stream()
                .sorted(Comparator.comparing(User::getId).reversed())
                .collect(Collectors.toList());
        long l1 = System.currentTimeMillis();
        System.out.println("结束时间 = " + l1);
        System.out.println("结束时间 = " + (l1-l));

    }
}
