package com.pql.sort;

import java.util.Arrays;

/**
 * 归并排序实现
 * @author pengqinglong
 * @since 2022/10/27 10:59
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0 , arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int left, int right){

        // 如果递归到只剩一个数 则直接返回
        if(left == right){
            return;
        }

        // 计算中间数
        int mid = left + (right - left) / 2;

        // 二分数组后 左边排序
        mergeSort(arr, left, mid);
        // 二分数组后 右边排序
        mergeSort(arr, mid +1, right);
        // 左右数组全有序后 合并
        mergeArr(arr, left, mid, right);
    }

    private void mergeArr(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;
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
    }
}
