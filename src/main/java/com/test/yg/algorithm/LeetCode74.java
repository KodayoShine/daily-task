package com.test.yg.algorithm;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class LeetCode74 {

    /**
     * 解题思路:
     * 循环查找每一行首个下标的数值,是否大于所要查找的目标值
     * <p>
     * 对于查询到的行数依次遍历,查询到数值直接返回true
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        for (int i = 0; i < m; i++) {
            int matrix1 = matrix[i][0];
            if (matrix1 > target) {
                l = i - 1;
                break;
            }
            l = i;
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

    /**
     * 采用二分法 进行数据的查找
     * 针对于每一行、每一列进行二分的查询
     *  public static int binarySearch(int[] nums, int target, int left, int right) {
     *         //这里需要注意，循环条件
     *         while (left <= right) {
     *             //这里需要注意，计算mid
     *             int mid = left + ((right - left) >> 1);
     *             if (nums[mid] == target) {
     *                 return mid;
     *             }else if (nums[mid] < target) {
     *                 //这里需要注意，移动左指针
     *                 left  = mid + 1;
     *             }else if (nums[mid] > target) {
     *                 //这里需要注意，移动右指针
     *                 right = mid - 1;
     *             }
     *         }
     *         //没有找到该元素，返回 -1
     *         return -1;
     *     }
     *
     * 二分查找的思路及代码已经理解了，那么我们来看一下实现时容易出错的地方
     *
     * 1.计算 mid 时 ，不能使用 （left + right ）/ 2,否则有可能会导致溢出
     *
     * 2.while (left < = right) { } 注意括号内为 left <= right ,而不是 left < right ，
     * 如果我们设置条件为 left < right 则当我们执行到最后一步时，
     * 则我们的 left 和 right 重叠时，则会跳出循环，返回 -1，区间内不存在该元素，
     * 但是不是这样的，我们的 left 和 right 此时指向的就是我们的目标元素 ，但是此时 left = right 跳出循环
     *
     * 3.left = mid + 1,right = mid - 1 而不是 left = mid 和 right = mid。
     * 当我们的target 元素为 16 时，然后我们此时 left = 7 ，right = 8，mid = left + (right - left) = 7 + (8-7) = 7，
     * 那如果设置 left = mid 的话，则会进入死循环，mid 值一直为7 。
     * https://leetcode-cn.com/problems/search-a-2d-matrix/solution/yi-wen-dai-ni-gao-ding-duo-ge-er-fen-cha-2hl9/
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 做二分查找
        int l = 0;
        int r = m - 1;
        int row = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                row = mid;
                break;
            }
        }

        if (row < 0) {
            return false;
        }

        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LeetCode74 leetCode74 = new LeetCode74();
        //int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] arr = {{1}};
        System.out.println(leetCode74.searchMatrix2(arr, 1));
    }

}
