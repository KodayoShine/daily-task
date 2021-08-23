package com.test.leetcode.array;

import java.util.*;

public class 三数之和15 {

    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 采用双指针的方式
     * 先对数组数据进行排序,然后依次计算所要得出的值
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                break;
            }
            // 跳过重复的值
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int handleNum = -num;

            while (left < right) {
                if (nums[left] + nums[right] == handleNum) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[left]);
                    list.add(num);
                    list.add(nums[right]);
                    allList.add(list);

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (nums[left] + nums[right] > handleNum) {
                    right--;
                } else {
                    left++;
                }

            }


        }
        return allList;
    }


    /**
     * 这个写法有些走歪了,误入歧途
     * 类似于三重循环的方式,放弃
     *
     * @param args
     */
/*    public static List<List<Integer>> threeSum(int[] nums) {
        // 先对数组进行排序
        int[] sortNums = Arrays.stream(nums).sorted().toArray();
        Set<List<Integer>> allList = new LinkedHashSet<>();


        *//*Map<Integer, Integer> map = new HashMap<>();
        for (int num : sortNums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault + 1);
        }*//*
        // 最后两位不需要再次进行计算了
        int tmpNum = Integer.MAX_VALUE;
        for (int i = 0; i < sortNums.length - 2; i++) {
            int sortNum = sortNums[i];
            if (tmpNum == Integer.MAX_VALUE) {
                // 重新赋值
                tmpNum = sortNum;
            } else if (tmpNum == sortNum) {
                tmpNum = Integer.MAX_VALUE;
                continue;
            }
            // 当前数据为0,或者及其以上的话 就不需要向下获取数据了
            if (sortNum > 0) {
                break;
            }

            List<Integer> list = new ArrayList<>(3);
            int num = sortNum;
            int temp = i + 1;
            int nextNum = sortNums[temp];

            int sum = num + nextNum;
            int findSum = -sum;
            //Integer integer = map.get(-sum);
            for (int j = i + 2; j < sortNums.length; j++) {
                if (sortNums[j] == findSum) {
                    list.add(num);
                    list.add(nextNum);
                    list.add(sortNums[j]);
                    list.sort(Integer::compareTo);
                    allList.add(list);
                    break;
                }
            }

        }

        return new ArrayList<>(allList);
    }*/

}
