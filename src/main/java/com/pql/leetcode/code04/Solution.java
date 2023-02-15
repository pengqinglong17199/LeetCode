package com.pql.leetcode.code04;

public class Solution {

    public static void main(String[] args) {


       int[] num1 = {1,3,5};
        int[] num2 = {2,4,6};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));

        num1 = new int[]{1, 2};
        num2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));

        num1 = new int[]{};
        num2 = new int[]{1,1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));

        num1 = new int[]{1, 10};
        num2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));

        num1 = new int[]{3};
        num2 = new int[]{1,2,4,5,6,7,8};
        // 3
        // 1 2 4 5 6 7 8
        //
        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取中心位
        int sumLength = nums1.length + nums2.length;


        int left = (sumLength + 1) / 2;
        int right = (sumLength + 2) / 2;

        double k1 = getK(nums1, nums2, left);
        double k2 = getK(nums1, nums2, right);
        return (k1 + k2) / 2.0;
    }

    public double getK(int[] nums1, int[] nums2, int k){

        // 前置判断 如果某个数组为空 则另外一个数组可直接拿出中心值
        if (nums1.length == 0) {
            return nums2[k-1];
        }

        if (nums2.length == 0) {
            return nums1[k-1];
        }

        // 两个数组各找i位
        int i = k;

        int start1 = 0;
        int start2 = 0;
        boolean out1 = false;
        boolean out2 = false;
        while (i > 1) {
            int avg = i / 2;

            // 获取当前的数组开头 -1 代表一个数组已经查找完了 此时可以直接从另一个数组开始获得中间值
            if (start1 == -1 || start2 == -1) {
                return start1 == -1 ? nums2[start2 + i-1] : nums1[start1 + i-1];
            }

            // 防止上一次累计时数组越界
            int offset1 = start1 + avg;
            if(offset1 >= nums1.length){
                offset1 = nums1.length;
                out1 = start1 >= nums1.length;
            }

            int offset2 = start2 + avg;
            if(offset2 >= nums2.length){
                offset2 = nums2.length;
                out2 = start2 >= nums2.length;
            }

            // 哪边数组小 就将哪边数组的开始偏移量直接累加 也就是去除
            int sub = avg;
            if (nums1[offset1 -1] < nums2[offset2-1]) {
                int temp = start1 + avg;
                sub = temp < nums1.length ? avg : nums1.length - start1;
                start1 = out1 || offset1 >= nums1.length ? -1 : temp;
            } else {
                int temp = start2 + avg;
                sub = temp < nums2.length ? avg : nums2.length - start2;
                start2 = out2 || offset2 >= nums2.length? -1 : temp;
            }

            // 去除不对的数据后 需要寻找的对应第i小的数字也要减去当前减去的数量
            i -= sub;
        }

        // 获取当前的数组开头 -1 代表一个数组已经查找完了 此时可以直接从另一个数组开始获得中间值
        if (start1 == -1 || start2 == -1) {
            return start1 == -1 ? nums2[start2] : nums1[start1];
        }


        int i1 = nums1[start1];
        int i2 = nums2[start2];

        return Math.min(i1, i2);
    }
}
