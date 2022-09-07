package com.pql.leetcode.code03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abba"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcabc"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("swfexsw"));
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        // 常规判断
        if(s == null || "".equals(s)){
            return 0;
        }

        if(s.length() < 2){
            return s.length();
        }

        // map哈希计数
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();

        int start = 0;
        int end = 0;
        int max = 1;
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer v = map.put(c, i + 1);
                start = v < start ? start : v;
            }
            map.put(c, i+1);
            end = i;
            int temp = end + 1 - start;
            max = Math.max(temp, max);
        }

        return max;
    }
}
