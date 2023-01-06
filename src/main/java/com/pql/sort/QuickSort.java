package com.pql.sort;

import java.util.Arrays;

/**
 * 快速排序实现
 * @author pengqinglong
 * @since 2023/1/5 10:16
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,9,8,6,7};
        new QuickSort().sort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        // 取一个锚点
        int anchor = arr[right];
        // 小于区
        int lt = left - 1;
        // 大于区
        int gt = right + 1;
        // 指针
        int pointer = left;

        while (pointer < gt){
            if(arr[pointer] < anchor){
                swap(arr, pointer, ++lt);
                pointer++;
            }else if(arr[pointer] > anchor){
                swap(arr, pointer, --gt);
            }else {
                pointer++;
            }
        }
        sort(arr, left, lt);
        sort(arr, gt, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
