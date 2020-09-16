package com.hxf.demo.demo.designpatterns.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 14:29
 */
@Slf4j
public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        log.info("Hello 1111111111111!");
    }
}
