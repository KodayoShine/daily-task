package com.test.yg.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class LeetCode16_26 {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Character> operational = new LinkedList<>();
        char[] chars = s.toCharArray();

        int length = chars.length;
        for (int i = 0; i < length;) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            char tmp = chars[i];
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                operational.push(tmp);
                i++;
            }
            int num = 0;
            while (i < length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }
            stack.push(num);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode16_26 leetCode16_26 = new LeetCode16_26();
        int calculate = leetCode16_26.calculate("123132*126+12/2+7/3-456");
        System.out.println(calculate);
    }


}
