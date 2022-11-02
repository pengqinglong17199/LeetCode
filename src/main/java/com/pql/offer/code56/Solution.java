package com.pql.offer.code56;

/**
 *  leetCode 剑指offer 56题 数组中数字出现的次数
 * @author pengqinglong
 * @since 2022/10/10 15:40
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {

        int s = 0;
        // 所有数都是只出现了两次 除两个数字之外 所以先将所有数全部异或 这样就得到了 两个数字异或的结果
        for (int num : nums) {
            s = s ^ num;
        }

        // 异或结果 两个数字肯定不相同 不然就是一个数字了 那么两个数字异或结果肯定也不会是0 所以s不会为0
        // 获取s最右侧的1
        int b = s & -s;

        int q = 0;
        // 通过b这个s最右侧的1来找出一个数 然后再异或s 就得到了两个数字
        for (int num : nums) {
            if((b & num) > 0){
                q = q ^ num;
            }
        }
        return new int[]{q, s^q};
    }
}
