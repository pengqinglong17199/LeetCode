package com.pql.leetcode.offer2.code56;

/**
 * leetCode 剑指offer 2 56 题 数组汇总数字出现的次数2
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @author pengqinglong
 * @since 2022/10/9 16:02
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        int k = 3;
        int[] binaryArr = new int[32];

        // 获得数组所有数 每一位的二进制累计
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                binaryArr[i] += num >> i & 1;
            }
        }

        int result = 0;
        // 二进制取余最终获得结果
        for (int i = 0; i < binaryArr.length; i++) {
            result |= binaryArr[i] % k > 0 ? 1 << i : 0;
        }

        return result;
    }

}
