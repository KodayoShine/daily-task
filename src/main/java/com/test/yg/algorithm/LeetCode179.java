package com.test.yg.algorithm;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class LeetCode179 {

    /**
     * 冒泡排序,依次判断两个数值合成str后 哪个数值更大
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        //排序，s1 + s2 > s2 + s1
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //b+a
                String str1 = "" + nums[j] + nums[i];
                //a+b
                String str2 = "" + nums[i] + nums[j];
                // 后者为b,大于前者则前移
                if (Long.parseLong(str1) > Long.parseLong(str2)) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sbf.append(nums[i]);
        }
        int len = sbf.length();
        int k = 0;
        while (k < len - 1 && sbf.charAt(k) == '0') {
            k++;
        }
        return sbf.substring(k);
    }

}
