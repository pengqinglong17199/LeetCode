package com.pql.offer.code03;

import java.util.*;

/**
 * 剑指offer 第3题
 *  找出数组中重复的数字。
 *      在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 *      但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @author pengqinglong
 * @since 2022/10/26 15:59
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = new Solution().findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }


}
