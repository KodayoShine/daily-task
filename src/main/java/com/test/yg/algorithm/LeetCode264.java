package com.test.yg.algorithm;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class LeetCode264 {

    /**
     * 根据已有的丑数 再通过2,3,5计算下一次最小的数值
     * 因此我们可以使用三个指针来指向目标序列 uglys 的某个下标（下标 0 作为哨兵不使用，起始都为 1），
     * 使用 arr[下标] * (2,3,5) 代表当前使用到三个有序序列中的哪一位，
     * 同时使用 i 表示当前生成到 uglys 哪一位丑数。
     *
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n + 1];
        uglys[1] = 1;

        // 指向数组的第一个下标 1
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2; i <= n; i++) {
            int min2 = uglys[i2] * 2;
            int min3 = uglys[i3] * 3;
            int min5 = uglys[i5] * 5;

            int min = Math.min(min2, Math.min(min3, min5));
            if (min == min2) {
                i2++;
            }
            if (min == min3) {
                i3++;
            }
            if (min == min5) {
                i5++;
            }

            uglys[i] = min;
        }

        return uglys[n];

    }

    public static void main(String[] args) {
        LeetCode264 leetCode264 = new LeetCode264();
        System.out.println(leetCode264.nthUglyNumber(10));
    }

}
