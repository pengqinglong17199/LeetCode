package com.pql.leetcode.offer.code70;

/**
 * leetCode 剑指offer 2 070 题 排序数组中只出现一次的数字
 *
 * @author pengqinglong
 * @since 2022/10/9 16:02
 */
public class Solution {

    /**
     * 思路 两个相同的数异或为0 所以异或整个数组 最后会拿到只有一次的数
     */
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i = i ^ num;
        }
        return i;
    }

}
