package com.pql.leetcode.code327;

/**
 * @author pengqinglong
 * @since 2022/11/23 15:48
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {-2147483647,0,-2147483647,2147483647};
        int i = new Solution().countRangeSum(arr, -564, 3864);
        System.out.println(i);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = this.getPrefix(nums);
        return this.mergeSort(prefixSum, 0, nums.length-1, lower, upper);
    }

    private int mergeSort(long[] prefixSum, int left, int right, int lower, int upper) {
        if(left == right){
            return prefixSum[left] >= lower && prefixSum[left] <= upper ? 1 : 0;
        }

        int mid = left + (right - left) / 2;
        int result = 0;
        result += mergeSort(prefixSum, left, mid, lower, upper);
        result += mergeSort(prefixSum, mid+1, right, lower, upper);
        result += mergeArr(prefixSum, left, mid, right, lower, upper);
        return result;
    }

    private int mergeArr(long[] prefixSum, int left, int mid, int right, int lower, int upper) {

        int windowL = left;
        int windowR = left;
        int sum = 0;
        for(int i = mid+1; i <= right; i++){
            long min = prefixSum[i] - upper;
            long max = prefixSum[i] - lower;
            while (windowL <= mid && prefixSum[windowL] < min){
                windowL++;
            }
            while (windowR <= mid && prefixSum[windowR] <= max){
                windowR ++;
            }
            sum += windowR - windowL;
        }


        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        long[] mergeArr = new long[right - left +1];
        while (p1 <= mid && p2 <= right){
            mergeArr[i++] = prefixSum[p1] <= prefixSum[p2] ? prefixSum[p1++] : prefixSum[p2++];
        }
        while (p1 <= mid){
            mergeArr[i++] = prefixSum[p1++];
        }
        while (p2 <= right){
            mergeArr[i++] = prefixSum[p2++];
        }

        for (int j = 0; j < mergeArr.length; j++) {
            prefixSum[left+j] = mergeArr[j];
        }
        return sum;
    }

    private long[] getPrefix(int[] nums) {
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        return prefixSum;
    }
}
