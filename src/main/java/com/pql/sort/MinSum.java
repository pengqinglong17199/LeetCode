package com.pql.sort;

import java.util.Arrays;

/**
 * 计算数组的小和
 * 数组小和的定义如下: 例如,数组s=[1,3,5,2,4,6],在s[0]的左边小于或等于s[0]的数的和为0,在s[1]的左边小于或等于s[1]的数的和为1
 * @author pengqinglong
 * @since 2022/10/27 16:30
 */
public class MinSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int minSum = new MinSum().mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(minSum);
    }
    /**
     * 思路 归并排序 在左边比右边小的时候 通过右边的位置得出有几个 得出左边的数累加 排序完成时 累计的小和也出来了
     */
    public int mergeSort(int[] arr, int left, int right){

        if(left == right){
            return 0 ;
        }
        int minSum = 0;
        // 数组二分
        int mid = left + (right - left) / 2;
        minSum += mergeSort(arr, left, mid);
        minSum += mergeSort(arr, mid+1, right);
        minSum += mergeArr(arr, left, mid, right);
        return minSum;
    }

    /**
     * 合并代码
     */
    private int mergeArr(int[] arr, int left, int mid, int right) {

        int[] tempArr = new int[right - left + 1];

        int p1 = left;
        int p2 = mid +1;
        int i = 0;
        int minSum = 0;
        while (p1 <= mid && p2 <= right){
            boolean flag = arr[p1] <= arr[p2];
            minSum += flag ? arr[p1] * (right - p2 +1) : 0;
            tempArr[i++] = flag ? arr[p1++] : arr[p2++];
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
        return minSum;
    }
}
