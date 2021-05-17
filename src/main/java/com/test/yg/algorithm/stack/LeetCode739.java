package com.test.yg.algorithm.stack;

import java.util.Stack;

/**
 * 739. 每日温度
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] r = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                Integer pop = stack.pop();
                r[pop] = i - pop;
            }
            stack.push(i);
        }
        return r;
    }

    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] ints = leetCode739.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}); // 8,1,5,4,3,2,1,1,0,0
        //int[] ints = leetCode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}); // 1, 1, 4, 2, 1, 1, 0, 0
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

}
