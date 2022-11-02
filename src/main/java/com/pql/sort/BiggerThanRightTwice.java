package com.pql.sort;

import java.util.Arrays;

/**
 * 寻找数组中每个数右边有多少个数乘2后还小于它
 * @author pengqinglong
 * @since 2022/11/2 11:37
 */
public class BiggerThanRightTwice {

    public static void main(String[] args) {

        int[] arr = {9, 5, 1, 3, 4, 8, 2};
        BiggerThanRightTwice biggerThanRightTwice = new BiggerThanRightTwice();
        int i = biggerThanRightTwice.mergeSort(arr, 0, arr.length-1);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }

    public int  mergeSort(int[] arr, int left, int right){

        // 如果递归到只剩一个数 则直接返回
        if(left == right){
            return 0;
        }

        int mid = left + (right - left) / 2;

        int biggerThanRight = 0;
        biggerThanRight += mergeSort(arr, left, mid);
        biggerThanRight += mergeSort(arr, mid +1, right);
        biggerThanRight += mergeArr(arr, left, mid, right);
        return biggerThanRight;
    }

    private int mergeArr(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;

        int biggerThanRight = 0;
        int windowR = mid +1;
        for (int j = left; j <= mid; j++) {
            for (int k = windowR; k <= right; k++) {
                if(windowR <= right && arr[j] > arr[k] << 1){
                    windowR++;
                }
            }
            biggerThanRight += windowR - mid - 1;
        }

        int i = 0;
        while (p1 <= mid && p2 <= right){
            tempArr[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            tempArr[i++] = arr[p1++];
        }

        while (p2 <= right){
            tempArr[i++] = arr[p2++];
        }

        for (int j = 0; j < tempArr.length; j++) {
            arr[left+j] = tempArr[j];
        }

        return biggerThanRight;
    }
}
