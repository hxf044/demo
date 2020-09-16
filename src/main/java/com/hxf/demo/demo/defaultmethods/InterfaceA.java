package com.hxf.demo.demo.defaultmethods;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/11 16:36
 */
public interface InterfaceA {
    default String getName() {
        return "";
    }
}
