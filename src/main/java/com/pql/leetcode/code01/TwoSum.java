package com.pql.leetcode.code01;

import java.util.HashMap;
import java.util.Map;

/**
 * 01.两数之和
 * @author pengqinglong
 * @since 2022/9/2 16:42
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // 前置判断
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        // 通过map进行处理
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;

        // O(N)
        for(int i = 0; i < length; i++){
            // 必定存在一个有效对象
            // 所以直接用target 减去当前数 获得结果数
            // 如果不在map中 那么将当前数以及下标存入map 因为可能另外一个数还没加入map
            // 当第二个数被target减去时 第一个数肯定已经在map中了 此时直接返回结果即可
            int v = target - nums[i];
            if(map.containsKey(v)){
                return new int[]{map.get(v), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

