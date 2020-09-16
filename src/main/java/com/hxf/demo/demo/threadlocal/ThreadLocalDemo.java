package com.hxf.demo.demo.threadlocal;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/6/19 9:59
 */
public class ThreadLocalDemo {
    final static ThreadPoolExecutor threadPoolExecutor
            = new ThreadPoolExecutor(10, 10,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    static class MyData{
        //构建对象就会占用1M的内存
        private byte[] a = new byte[1024 * 1024 * 5];
    }

    ThreadLocal<MyData> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; ++i) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
                threadLocalDemo.threadLocal.set(new MyData());
//                threadLocalDemo.threadLocal.remove();
              System.out.println("args = " + threadLocalDemo.threadLocal.get());
            });
            Thread.sleep(100);
        }
    }

}
