package com.test.yg.algorithm;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        for (int i = 0; i < m; i++) {
            int matrix1 = matrix[i][0];
            if (matrix1 > target) {
                l = i - 1;
                break;
            } else if (matrix1 == target) {
                l = i;
                break;
            }
        }

        if (l < 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            int matrix1 = matrix[l][i];
            if (matrix1 == target) {
                return true;
            }
        }


        return false;
    }

}
