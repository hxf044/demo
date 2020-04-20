package com.hxf.demo.demo.set;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * <p>
 * TestMap
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月20日 17:25
 */
@Slf4j
public class TestMap {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map1 = new Hashtable<>();
        map.put(1, "11111");
        map.put(2, "2222");
        map.put(1, "11");
    }
}
