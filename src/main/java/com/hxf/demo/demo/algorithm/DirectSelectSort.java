package com.hxf.demo.demo.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年03月27日 16:56
 */
public class DirectSelectSort {

    /**
     *  先声明一个最小的数字，然后循环对比，得到最小的数字，然后替换他们的位置
     * @param array
     */
    private static void sort(int[] array) {
        int len = array.length;
        System.out.println("排序前：" + JSONObject.toJSONString(array));
        for (int i = 1; i < len; i++) {
            int min = array[i];
            int temi = i;
            for (int j = i +1 ; j <  len; j++) {
                if(array[j] < min){
                    min = array[j];
                    temi = j;
                }
            }
            array[temi] = array[i];
            array[i] = min;
        }
        System.out.println("排序后：" + JSONObject.toJSONString(array));
    }

    public static void main(String[] args) {
        sort(new int[]{1, 3, 2, 9, 8, 7, 6, 5, 4});
    }
}
