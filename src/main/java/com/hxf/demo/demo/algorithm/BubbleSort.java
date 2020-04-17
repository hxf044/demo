package com.hxf.demo.demo.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * 冒泡排序
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年03月27日 17:08
 */
public class BubbleSort {

    /**
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * @param array
     */
    private static void sort(int[] array) {
        int len = array.length;
        System.out.println("排序前：" + JSONObject.toJSONString(array));
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("排序后：" + JSONObject.toJSONString(array));
    }

    public static void main(String[] args) {
        sort(new int[]{1, 3, 2, 9, 8, 7, 6, 5, 4});
    }
}
