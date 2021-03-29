package com.test.yg.algorithm;

public class LeetCode190 {

    /**
     * 解题思路:
     * 计算每一位的数值,做取&(与)操作,都为1则为1
     * 计算后,结果为1的情况下,将1做左移动作
     * 然后, 做|(或),都为0,则为0,那么就将高位数值赋值
     * 翻转整个数字
     *
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int rev  = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1) {
                rev  = rev  | (1 << (31 - i));
            }
        }
        return rev ;
    }


    public static void main(String[] args) {
        LeetCode190 leetCode190 = new LeetCode190();
        leetCode190.reverseBits(0b01000010100101000001111010011100);
    }

}
