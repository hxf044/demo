package com.hxf.demo.demo.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/7/27 10:00
 * 二分法查找
 * 1.数组必须有序
 * 2.把数组分成两份，获取到二分值
 * 3.比较要查的值和二分值对比
 * 4.如果二分值小于value， 向右边二分
 * 5.如果二分值大于value， 向左右二分
 */
@Slf4j
public class DichotomySort {
    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        Arrays.sort(arr);
        log.info("arr={}", arr);
        log.info("value={}", binarySearch(arr, 40));
        int low = 0;
        int high = arr.length - 1;
        log.info("value={}", binarySearch(arr, low, high, 40));
    }


    /**
     * 递归方法
     *
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int binarySearch(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearch(a, mid + 1, high, value);
        } else {
            return binarySearch(a, low, mid - 1, value);
        }
    }

    /**
     * 循环方法
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int frequency = 0;
        while (low <= high) {
            frequency++;
            log.info("frequency={}", frequency);
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                high = mid - 1;
            }
            if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
