package com.hxf.demo.demo.test;

/**
 * <p>
 * ISLiveDemo
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月24日 17:42
 */
public class ISLiveDemo extends Thread  {
    @Override
    public void run() {
        System.out.println("run:" + isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        ISLiveDemo live = new ISLiveDemo();
        System.out.println("begin:" + live.isAlive());
        live.start();
        Thread.sleep(1000);

        System.out.println("end:" + live.isAlive());
    }
}
