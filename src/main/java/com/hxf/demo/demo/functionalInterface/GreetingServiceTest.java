package com.hxf.demo.demo.functionalInterface;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 16:20
 */
@Slf4j
public class GreetingServiceTest {
    public static void main(String[] args) {
        sendMsg("ehsihs ", message -> System.out.println("Hello " + message));
    }

    public static void sendMsg(String  msg,GreetingService greetingService){
        greetingService.sayMessage(msg);
    }
}
