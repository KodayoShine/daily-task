package com.test.yg.algorithm;


import java.util.Arrays;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 *
 *
 */
public class LeetCode781 {

    /**
     * 解题思路:
     * 这个题的关键是读懂这道题所要表达的含义
     *
     * 假如有 3 只白兔，每只白兔的回答必然都是 2；但假如有兔子回答了数值 2，可能只是三只白兔，也可能是三只白兔和三只灰兔同时进行了回答。
     * 所以要求最少的兔子数量。
     *
     * 我们可以先对 answers 进行排序，然后根据遍历到某个 cnt 时，
     * 将其对答案的影响应用到 ans 中（ans += cnt + 1），并将后面的 cnt 个 cnt 进行忽略。
     *
     *
     *
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int length = answers.length;

        int result = 0;
        for (int i = 0; i < length; i++) {
            int answer = answers[i];
            // 求出的兔子是当前值 + 1
            result += answer + 1;

            // 对d的数值的个数进行忽略
            int d = answer;
            // 判断下一个和当前数值是否一样
            // 并且下一个值不能超过length
            while (d-- > 0 && i + 1 < length && answers[i] == answers[i + 1]) {
                i++;
            }

        }

        return result;
    }

}
