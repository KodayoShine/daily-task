package com.test.yg.algorithm;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                Integer pop1 = numStack.pop();
                Integer pop2 = numStack.pop();
                numStack.push(pop2 + pop1);
            } else if (token.equals("-") ){
                Integer pop1 = numStack.pop();
                Integer pop2 = numStack.pop();
                numStack.push(pop2 - pop1);
            } else if (token.equals("*")) {
                Integer pop1 = numStack.pop();
                Integer pop2 = numStack.pop();
                numStack.push(pop2 * pop1);
            } else if (token.equals("/")) {
                Integer pop1 = numStack.pop();
                Integer pop2 = numStack.pop();
                numStack.push(pop2 / pop1);
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] arrys = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        LeetCode150 leetCode150 = new LeetCode150();
        int i = leetCode150.evalRPN(arrys);
        System.out.println(i);
    }
}
