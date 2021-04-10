package com.test.yg.algorithm;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 */
public class LeetCode263 {

    /**
     * 根据丑数的定义进行相应的运算
     *
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
