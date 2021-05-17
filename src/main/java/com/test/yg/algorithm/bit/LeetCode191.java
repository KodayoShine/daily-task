package com.test.yg.algorithm.bit;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * <p>
 *
 *     &运算 两个位数上都为1,则为1,否则为0
 *     |运算,两个运算上都为0,则为0,否则为1
 *
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1){
                sum++;
            }
            n >>>= 1;
        }
        return sum;
    }


    public static void main(String[] args) {

        LeetCode191 leetCode191 = new LeetCode191();
        int i = leetCode191.hammingWeight(11);
        System.out.println(i);

    }

}
