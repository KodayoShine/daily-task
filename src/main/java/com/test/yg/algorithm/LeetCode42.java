package com.test.yg.algorithm;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int l = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > l) {
                    l = height[j];
                }
            }
            int r = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > r) {
                    r = height[j];
                }
            }
            int min = Math.min(l, r);
            if (min > height[i]) {
                total = total + (min - height[i]);
            }
        }
        return total;
    }


    /**
     * 超时了
     *
     * @param height
     * @return
     */
    public int trap_1(int[] height) {
        int high = 0;
        for (int i = 0; i < height.length; i++) {
            int v = height[i];
            if (v > high) {
                high = v;
            }
        }

        int total = 0;
        int l = Integer.MAX_VALUE, r = 0, count = 0;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < height.length; j++) {
                int value = height[j];
                if (value == 0) {
                    continue;
                }
                if (l == Integer.MAX_VALUE) {
                    l = j;
                }
                r = j;
                count++;
                height[j] = value - 1;
            }
            total = total + (r - l + 1 - count);
            l = Integer.MAX_VALUE;
            r = 0;
            count = 0;
        }
        return total;
    }

    public static void main(String[] args) {
        LeetCode42 l = new LeetCode42();
        System.out.println(l.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
