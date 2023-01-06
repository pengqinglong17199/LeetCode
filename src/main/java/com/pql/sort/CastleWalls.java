package com.pql.sort;

import java.util.Arrays;

/**
 * 逆序对
 * 对于一个包含N个非负整数的数组A[1..n]，如果有i < j，且A[ i ]>A[ j ]，则称(A[ i] ,A[ j] )为数组A中的一个逆序对。
 * 例如，数组（3，1，4，5，2）的逆序对有(3,1),(3,2),(4,2),(5,2)，共4个。
 * @author pengqinglong
 * @since 2022/11/1 19:28
 */
public class CastleWalls {

    public static void main(String[] args) {

        //int[] arr = {233,2000000001,234,2000000006,235, 2000000003,236,2000000007,237, 2000000002,2000000005,233,233,233,233,233,2000000004};
        int[] arr = {3,1,4,5,2};
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                y += arr[i] > arr[j] ? 1 : 0;
            }
        }

        int i = new CastleWalls().mergeSort(arr, 0, arr.length - 1);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
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
