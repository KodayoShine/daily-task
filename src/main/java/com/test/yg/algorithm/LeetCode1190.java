package com.test.yg.algorithm;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 */
public class LeetCode1190 {

    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                stack.push(i);

            } else if (aChar == ')') {
                Integer pop = stack.pop();
                // 根据当前坐标和栈的第一个坐标 翻转这一部分的数据
                // 当前指针指向的都是括号,所以pop +1  当前 i - 1
                int left = pop + 1;
                int right = i - 1;
                while (right > left) {
                    char tmp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmp;
                    right--;
                    left++;
                }
            }
        }

        // 移除全部括号
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != '(' && aChar != ')') {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }

}
