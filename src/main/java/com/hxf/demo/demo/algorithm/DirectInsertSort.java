package com.hxf.demo.demo.algorithm;


import com.alibaba.fastjson.JSONObject;


/**
 * <p>
 * 插入排序
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年03月26日 19:23
 */
public class DirectInsertSort {

    /**
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     */
    private static void sort(int[] array) {
        int len = array.length;
        System.out.println("排序前：" + JSONObject.toJSONString(array));
        for (int i = 1; i < len; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j > 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        System.out.println("排序后：" + JSONObject.toJSONString(array));
    }

    public static void main(String[] args) {
        sort(new int[]{1, 3, 2, 9, 8, 7, 6, 5, 4});
    }
}
