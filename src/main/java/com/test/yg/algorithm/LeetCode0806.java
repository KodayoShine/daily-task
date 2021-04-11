package com.test.yg.algorithm;

import java.util.HashMap;
import java.util.List;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 */
public class LeetCode0806 {

    /**
     * 采用分治思想,依次将判断
     *
     * 如果是一个盘子
     *                    直接将A柱子上的盘子从A移到C
     *          否则
     *                    先将A柱子上的n-1个盘子借助C移到B
     *                    直接将A柱子上的盘子从A移到C
     *                    最后将B柱子上的n-1个盘子借助A移到C
     *
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int hanotaSize = A.size();
        move(hanotaSize, A, B, C);
    }

    public void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size <= 0) {
            return;
        }
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);
    }


}
