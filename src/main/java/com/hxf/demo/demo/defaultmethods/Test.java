package com.hxf.demo.demo.defaultmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 16:40
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        User user = new User();
        String name = user.getName();
        log.info("name = {}", name);
        Shop shop = new Shop();
        String name1 = shop.getName();
        log.info("name = {}", name1);
    }
}
