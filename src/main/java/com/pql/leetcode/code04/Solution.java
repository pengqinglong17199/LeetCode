package com.pql.leetcode.code04;

public class Solution {

    // 1 3 5
    // 2 4 6
    // 6 / 2 =3
    // 3 / 2 = 1
    // 3 5
    // 2 4 6
    // 3 - 1 = 2
    // 2 /2 = 1
    //

    // 122334455667
    // 123456
    // 234567
    // 12 /2 = 6
    // 6 / 2 = 3
    // 456
    // 234567
    // 3 / 2 = 1
    // 456
    // 34567
    // 2 /2 = 1
    // 456
    // 4567
    // 1
    // 4

    // 1 3 4 5 7 8
    // 3 4 6 7 8 9
    // 12 / 2 = 6
    // 6 / 2 = 3
    // 5 7 8
    // 3 4 6 7 8 9
    // 6 - 3 = 3
    // 3 / 2 = 1
    // 5 7 8
    // 4 6 7 8 9
    // 3 - 1 =2
    // 2 / 2 = 1
    // 5 7 8
    // 6 7 8 9
    // 1
    // 5

    // 1 9
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14,15,16,17
    // 19 / 2 =10
    // 9 / 4 = 4
    // 1 9
    // 5, 6, 7, 8, 9, 10, 11, 12, 13,14,15,16,17
    // 9-4 = 5
    // 5 / 2 = 2
    // 1 9
    // 7, 8, 9, 10, 11, 12, 13,14,15,16,17
    // 3 / 2 = 1
    // 9
    // 7, 8, 9, 10, 11, 12, 13,14,15,16,17
    // 2 /2 = 1
    // 7
    public static void main(String[] args) {


       int[] num1 = {1,3,5};
        int[] num2 = {2,4,6};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
        System.out.println(solution.findMedianSortedArrayss(num1, num2));

        num1 = new int[]{1, 2};
        num2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
        System.out.println(solution.findMedianSortedArrayss(num1, num2));

        num1 = new int[]{};
        num2 = new int[]{1,1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
        System.out.println(solution.findMedianSortedArrayss(num1, num2));

        num1 = new int[]{1, 10};
        num2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
        System.out.println(solution.findMedianSortedArrayss(num1, num2));

        num1 = new int[]{3};
        num2 = new int[]{1,2,4,5,6,7,8};
        // 3
        // 1 2 4 5 6 7 8
        //
        solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1, num2));
        System.out.println(solution.findMedianSortedArrayss(num1, num2));
    }

    public double findMedianSortedArrayss(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5; }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0)
            return nums2[start2 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
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
