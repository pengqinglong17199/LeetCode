package com.pql.offer.code51;

/**
 * 剑指offer第51题
 *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @author pengqinglong
 * @since 2022/11/2 10:32
 */
public class Solution {

    /**
     * 思路 通过归并排序 在左右两边局部有序的过程中 将左右两边数据进行对比 得出逆序对数量
     */
    public int reversePairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        return mergeSort(nums, 0 , nums.length -1);
    }

    public int mergeSort(int[] arr, int left, int right){

        if(left == right){
            return 0;
        }
        int castleWalls = 0;

        int mid = left + (right - left) / 2;
        castleWalls += mergeSort(arr, left, mid);
        castleWalls += mergeSort(arr, mid + 1, right);
        castleWalls += mergeArr(arr, left, mid, right);
        return castleWalls;
    }

    private int mergeArr(int[] arr, int left, int mid, int right) {

        int[] tempArr = new int[right - left +1];
        int p1 = mid;
        int p2 = right;
        int i = right - left;
        int castleWalls = 0;

        while (p1 >= left && p2 >= mid+1){
            boolean flag = arr[p1] > arr[p2];
            castleWalls += flag ? p2 - mid : 0;
            tempArr[i--] = flag ? arr[p1--] : arr[p2--];
        }

        while (p1 >= left){
            tempArr[i--] = arr[p1--];
        }

        while (p2 >= mid+1){
            tempArr[i--] = arr[p2--];
        }
        for (int j = 0; j < tempArr.length; j++) {
            arr[left + j] = tempArr[j];
        }
        return castleWalls;
    }
}
